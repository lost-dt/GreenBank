package com.kpi.greenbank.controller.servlet;

import com.kpi.greenbank.model.dto.UserDTO;
import com.kpi.greenbank.model.entity.AmountTransaction;
import com.kpi.greenbank.model.entity.TransactionStatus;
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
import java.util.Date;
import java.util.Optional;


@WebServlet(name = "AmountRequest", urlPatterns = {"/amount_request"})
public class AmountRequestServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(AmountRequestServlet.class);

    private static final String WEB_PAGE_AMOUNTS_REQUESTS = "amounts_requests.jsp";

    private UserService userService;
    private AmountTransactionService amountTransactionService;

    public void init(ServletConfig servletConfig) {
        amountTransactionService = new AmountTransactionService();
        userService = new UserService();

    }

    public void doGet(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {

        String userEmail = request.getParameter("userEmail");
        Float amountValue = Float.parseFloat(request.getParameter("amountValue"));
        Integer transactionId = Integer.parseInt(request.getParameter("transactionId"));
        TransactionStatus transactionStatus = TransactionStatus.valueOf(request.getParameter("status"));
        String handledBy = request.getParameter("handledBy");

        if (transactionStatus.equals(TransactionStatus.ACCEPT)) {
            UserDTO userDTO = userService.findUserByEmail(userEmail).get();
            userDTO.setAmount(userDTO.getAmount() + amountValue);
            request.getSession().setAttribute("currentUserEntity", userDTO);
            userService.updateUser(userDTO);
        }

        AmountTransaction amountTransaction = new AmountTransaction();
        amountTransaction.setId(transactionId);
        amountTransaction.setAmountValue(amountValue);
        amountTransaction.setUserEmail(userEmail);
        amountTransaction.setHandledBy(handledBy);
        amountTransaction.setHandledTime(new Date());
        amountTransaction.setStatus(transactionStatus);
        amountTransaction.setCreationTime(new Date());

        amountTransactionService.updateAmountTransaction(amountTransaction);

        RequestDispatcher rd = request.getRequestDispatcher(WEB_PAGE_AMOUNTS_REQUESTS);
        rd.forward(request, response);

    }

}