package com.kpi.greenbank.controller.servlet;

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

@WebServlet(name = "CreateAccount", urlPatterns = { "/change_pass" })
public class ChangePasswordServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(ChangePasswordServlet.class);

    private static final String WEB_PAGE_INDEX = "index.jsp";
    private static final String WEB_PAGE_CHANGE_PASSWORD = "change_password.jsp";


    private UserService userService;

    public void init(ServletConfig servletConfig) {
        userService = new UserService();

    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {

        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("currentUserEntity");


        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String reNewPassword = request.getParameter("newRePassword");

        if (!oldPassword.equals(userDTO.getPassword())) {
            logger.info(String.format("User %s try to change password using wrong old one", userDTO.getEmail()));
            request.setAttribute("oldPasswordWrong", true);
            RequestDispatcher rd = request.getRequestDispatcher(WEB_PAGE_CHANGE_PASSWORD);
            rd.forward(request, response);
        } else if (!newPassword.equals(reNewPassword)) {
            logger.info(String.format(
                    "Passwords for %s are not same (%s and %s)",
                    userDTO.getEmail(), newPassword, reNewPassword
            ));
            request.setAttribute("newPasswordsSame", false);
            RequestDispatcher rd = request.getRequestDispatcher(WEB_PAGE_CHANGE_PASSWORD);
            rd.forward(request, response);
        }
        else {
            userDTO.setPassword(newPassword);
            userService.updateUser(userDTO);
            RequestDispatcher rd = request.getRequestDispatcher(WEB_PAGE_INDEX);
            rd.forward(request, response);
        }
    }
}
