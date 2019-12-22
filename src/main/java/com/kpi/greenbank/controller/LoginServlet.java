package com.kpi.greenbank.controller;

import com.kpi.greenbank.controller.websession.ActiveSession;
import com.kpi.greenbank.model.entity.User;
import com.kpi.greenbank.model.service.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "UserLogin", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(LoginServlet.class);

    public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {

        UserService userService = new UserService();

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        logger.info("user enter email: " + email + " " + password);

        Optional<User> user = userService.findUser(email, password);
        if (email == null || !user.isPresent()) {
            logger.info("Invalid attempt of user email: '" + email + "'");
            request.setAttribute("userExists", "No");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }
        else if (ActiveSession.checkUserIsLogged(request, user.get())) {
            logger.info("User email " + email + " already logged.");
            request.setAttribute("userAlreadyLogin", "yes");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }
        else {
            logger.info("User email " + email + " logged successfully.");

            request.getSession().setAttribute("currentUserEntity", user);

            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
    }
}
