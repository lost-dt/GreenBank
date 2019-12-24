package com.kpi.greenbank.model.service;

import com.kpi.greenbank.model.dao.DaoFactory;
import com.kpi.greenbank.model.dao.interfase.AmountTransactionDao;
import com.kpi.greenbank.model.dto.AmountTransactionDTO;
import com.kpi.greenbank.model.entity.AmountTransaction;

import java.sql.SQLException;
import java.util.List;

public class AmountTransactionService {
    private AmountTransactionDao amountTransactionDao;

    public AmountTransactionService() {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.amountTransactionDao = daoFactory.createAmountTransactionDao();
    }

    public Boolean addAmountTransaction(AmountTransaction amountTransaction) {

        boolean status = false;
        try {
            amountTransactionDao.add(amountTransaction);
            status = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;
    }

    public List<AmountTransactionDTO> loadAllAmountTransactionsByUserEmail(String userEmail) {
        return amountTransactionDao.loadAllByUserEmail(userEmail);
    }

    public List<AmountTransactionDTO> loadAllWaitAmountTransactions() {
        return amountTransactionDao.loadAllWaitTransactions();
    }

    public void updateAmountTransaction(AmountTransaction amountTransaction) {
        try {
            amountTransactionDao.update(amountTransaction);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
