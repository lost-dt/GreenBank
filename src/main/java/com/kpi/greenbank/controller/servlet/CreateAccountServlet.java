package com.kpi.greenbank.controller.servlet;

import com.kpi.greenbank.model.entity.User;
import com.kpi.greenbank.model.entity.UserBranch;
import com.kpi.greenbank.model.entity.UserRole;
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
import java.util.ResourceBundle;

@WebServlet(name = "CreateAccount", urlPatterns = { "/create" })
public class CreateAccountServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(CreateAccountServlet.class);


    private static final String WEB_PAGE_CREATE_ACCOUNT = "create_new_account.jsp";
    private static final String WEB_PAGE_CREATE_ACCOUNT_SUCCESS = "create_new_account_success.jsp";


    private UserService userService;


    public void init(ServletConfig servletConfig) {
        userService = new UserService();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        logger.info(String.format(
                "Start to create new user: %s %s",
                request.getParameter("firstName"),
                request.getParameter("lastName")
        ));

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        UserBranch branch =
                UserBranch.valueOf(request.getParameter("branch").toUpperCase().replace(" ", "_"));
        String zip = request.getParameter("zip");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String rePassword = request.getParameter("re_password");
        String phoneNumber = request.getParameter("phone");
        UserRole role =
                UserRole.valueOf(request.getParameter("role").toUpperCase().replace(" ", "_"));
        Float amount = Float.parseFloat(request.getParameter("amount"));

        if (!password.equals(rePassword)) {

            logger.info(String.format(
                    "Passwords for %s %s are not same (%s and %s)",
                    firstName, lastName, password, rePassword
            ));
            request.setAttribute("passwordDoNotMatch", "yes");
            RequestDispatcher rd = request.getRequestDispatcher(WEB_PAGE_CREATE_ACCOUNT);
            rd.forward(request, response);

        } else if(userService.findUserByEmail(email).isPresent()) {

            logger.info(String.format("User %s already have account", email));
            request.setAttribute("userAlreadyHaveAccount", true);
            RequestDispatcher rd = request.getRequestDispatcher(WEB_PAGE_CREATE_ACCOUNT);
            rd.forward(request, response);
        } else {

            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setAddress(address);
            user.setCity(city);
            user.setBranch(branch);
            user.setZip(zip);
            user.setEmail(email);
            user.setPassword(password);
            user.setPhoneNumber(phoneNumber);
            user.setRole(role);
            user.setAmount(amount);

            userService.addUser(user);

            logger.info("New user add to GreenBank system");
            request.setAttribute("createdUser", user);
            RequestDispatcher rd = request.getRequestDispatcher(WEB_PAGE_CREATE_ACCOUNT_SUCCESS);
            rd.forward(request, response);
        }


    }
}
