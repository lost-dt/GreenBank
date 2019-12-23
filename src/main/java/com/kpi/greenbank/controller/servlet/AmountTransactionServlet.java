package com.kpi.greenbank.controller.servlet;

import com.kpi.greenbank.model.dto.UserDTO;
import com.kpi.greenbank.model.entity.AmountTransaction;
import com.kpi.greenbank.model.entity.TransactionStatus;
import com.kpi.greenbank.model.service.AmountTransactionService;
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

@WebServlet(name = "AmountTransaction", urlPatterns = {"/amount_transaction"})
public class AmountTransactionServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(AmountTransactionServlet.class);

    private static final String WEB_PAGE_AMOUNT_TRANSACTION_SUCCESS = "add_amount_success.jsp";

    private AmountTransactionService amountTransactionService;

    public void init(ServletConfig servletConfig) {
        amountTransactionService = new AmountTransactionService();

    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {

        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("currentUserEntity");

        Float amountValue = Float.parseFloat(request.getParameter("amountValue"));
        TransactionStatus status = TransactionStatus.WAIT;
        Date date = new Date();

        AmountTransaction amountTransaction = new AmountTransaction();
        amountTransaction.setAmountValue(amountValue);
        amountTransaction.setUserEmail(userDTO.getEmail());
        amountTransaction.setCreationTime(date);
        amountTransaction.setStatus(status);
//        amountTransaction.setHandledBy("NONE");
        amountTransaction.setHandledTime(date);

        amountTransactionService.addAmountTransaction(amountTransaction);

        RequestDispatcher rd = request.getRequestDispatcher(WEB_PAGE_AMOUNT_TRANSACTION_SUCCESS);
        rd.forward(request, response);

    }

}
