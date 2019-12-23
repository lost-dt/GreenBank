package com.kpi.greenbank.controller.servlet;

import com.kpi.greenbank.controller.websession.ActiveSession;
import com.kpi.greenbank.model.dto.UserDTO;
import com.kpi.greenbank.model.service.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.ResourceBundle;

@WebServlet(name = "UserLogin", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(LoginServlet.class);


    private static final String WEB_PAGE_INDEX = "index.jsp";
    private static final String WEB_PAGE_LOGIN = "login.jsp";


    private UserService userService;

    public void init(ServletConfig servletConfig) {
        userService = new UserService();

        servletConfig.getServletContext().setAttribute("loggedUsers", new HashSet<UserDTO>());

    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Optional<UserDTO> user = userService.checkUserCredentials(email, password);
        if (email == null || !user.isPresent()) {

            logger.info(String.format("User %s try to login with wrong credentials", email));
            request.setAttribute("userExists", "No");
            RequestDispatcher rd = request.getRequestDispatcher(WEB_PAGE_LOGIN);
            rd.forward(request, response);

        } else if (ActiveSession.checkUserIsLogged(request, user.get())) {

            logger.info(String.format("User %s already logged", email));
            request.setAttribute("userAlreadyLogin", "yes");
            RequestDispatcher rd = request.getRequestDispatcher(WEB_PAGE_LOGIN);
            rd.forward(request, response);
        }
        else {

            logger.info(String.format("User %s login successfully", email));
            request.getSession().setAttribute("currentUserEntity", user.get());
            RequestDispatcher rd = request.getRequestDispatcher(WEB_PAGE_INDEX);
            rd.forward(request, response);

        }
    }
}
