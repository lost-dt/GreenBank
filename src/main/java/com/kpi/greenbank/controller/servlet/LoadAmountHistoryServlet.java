package com.kpi.greenbank.controller.servlet;

import com.kpi.greenbank.model.dto.AmountTransactionDTO;
import com.kpi.greenbank.model.dto.UserDTO;
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
import java.util.List;

@WebServlet(name = "LoadAmountHistory", urlPatterns = { "/load_amounts" })
public class LoadAmountHistoryServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(LoadAmountHistoryServlet.class);

    private static final String WEB_PAGE_AMOUNT_HISTORY = "amount_history.jsp";

    private AmountTransactionService amountTransactionService;


    public void init(ServletConfig servletConfig) {
        amountTransactionService = new AmountTransactionService();

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("currentUserEntity");
        List<AmountTransactionDTO> amountTransactionDTOS = amountTransactionService.loadAllAmountTransactionsByUserEmail(userDTO.getEmail());

        request.setAttribute("allUserAmountTransactions", amountTransactionDTOS);
        RequestDispatcher rd = request.getRequestDispatcher(WEB_PAGE_AMOUNT_HISTORY);
        rd.forward(request, response);


    }
}