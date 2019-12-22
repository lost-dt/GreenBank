package com.kpi.greenbank.controller.command.implementation;

import com.kpi.greenbank.controller.command.Command;
import com.kpi.greenbank.controller.websession.ActiveSession;
import com.kpi.greenbank.model.entity.User;
import com.kpi.greenbank.model.service.UserService;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.ResourceBundle;

public class Login implements Command {
    private static final ResourceBundle resource = ResourceBundle.getBundle("web-pages");

    private static final String LOGIN_PAGE_NAME = resource.getString("loginPageName");
    private static final String INDEX_PAGE_NAME = resource.getString("indexPageName");

    private static final Logger logger = LogManager.getLogger(Login.class);
    private UserService userService;

    public Login(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email == null) return LOGIN_PAGE_NAME;
        logger.info("user enter email: " + email + " " + password);

        Optional<User> user = userService.findUser(email, password);
        if (!user.isPresent()) {
            logger.info("Invalid attempt of user email: '" + email + "'");
            request.setAttribute("userExists", "No");
            return LOGIN_PAGE_NAME;
        }
        if (ActiveSession.checkUserIsLogged(request, user.get())) {
            logger.info("User email " + email + " already logged.");
            request.setAttribute("userAlreadyLogin", "yes");
            return LOGIN_PAGE_NAME;
        }
        logger.info("User email " + email + " logged successfully.");

        request.getSession().setAttribute("userEntity", user);

        return INDEX_PAGE_NAME;
    }
}
