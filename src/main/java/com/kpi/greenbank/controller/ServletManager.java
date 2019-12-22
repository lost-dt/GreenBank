package com.kpi.greenbank.controller;

import com.kpi.greenbank.controller.command.Command;
import com.kpi.greenbank.controller.command.implementation.Login;
import com.kpi.greenbank.model.entity.User;
import com.kpi.greenbank.model.service.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ServletManager extends HttpServlet {
    private Map<String, Command> commands = new HashMap<>();
    private static final Logger logger = LogManager.getLogger(ServletManager.class);

    public void init(ServletConfig servletConfig) {

        UserService userService = new UserService();
        logger.info("Servlet was created.");

        servletConfig.getServletContext()
                .setAttribute("loggedUsers", new HashSet<User>());

        commands.put("login", new Login(userService));

    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getRequestURI();
        logger.info(path);
        path = path.replaceAll(".*/app/", "");
        logger.info(path);
        if(!commands.containsKey(path)) {
            return;
        }
        Command command = commands.get(path);
        String page = command.execute(request);
        if (page.startsWith("redirect")) {
            response.sendRedirect(page.replace("redirect:", ""));
        } else {
            System.err.println(request.getAttribute("userExists"));
            response.sendRedirect(page);
        }
    }

}
