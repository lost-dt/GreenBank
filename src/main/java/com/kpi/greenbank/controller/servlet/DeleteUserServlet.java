package com.kpi.greenbank.controller.servlet;

import com.kpi.greenbank.model.dto.UserDTO;
import com.kpi.greenbank.model.service.AmountTransactionService;
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
import java.util.Base64;

@WebServlet(name = "DeleteUser", urlPatterns = { "/delete_account" })
public class DeleteUserServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(DeleteUserServlet.class);

    private static final String WEB_PAGE_LOGOUT = "logout.jsp";
    private static final String WEB_PAGE_DELETE_ACCOUNT = "delete_account.jsp";


    private UserService userService;
    private AmountTransactionService amountTransactionService;

    public void init(ServletConfig servletConfig) {
        amountTransactionService = new AmountTransactionService();
        userService = new UserService();

    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {

        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("currentUserEntity");

        String enteredPassword = request.getParameter("password");
        enteredPassword = Base64.getEncoder().encodeToString(enteredPassword.getBytes());

        if (enteredPassword.equals(userDTO.getPassword())) {
            userService.deleteUserByEmail(userDTO.getEmail());
            amountTransactionService.deleteByUserEmail(userDTO.getEmail());

            RequestDispatcher rd = request.getRequestDispatcher(WEB_PAGE_LOGOUT);
            rd.forward(request, response);
        }
        else {
            request.setAttribute("oldPasswordWrong", true);
            RequestDispatcher rd = request.getRequestDispatcher(WEB_PAGE_DELETE_ACCOUNT);
            rd.forward(request, response);
        }



    }

}