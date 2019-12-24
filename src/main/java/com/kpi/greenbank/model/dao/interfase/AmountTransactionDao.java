package com.kpi.greenbank.model.dao.interfase;

import com.kpi.greenbank.model.dto.AmountTransactionDTO;
import com.kpi.greenbank.model.entity.AmountTransaction;

import java.sql.SQLException;
import java.util.List;

public interface AmountTransactionDao extends GeneralDao<AmountTransaction> {
    List<AmountTransactionDTO> loadAll();
    List<AmountTransactionDTO> loadAllByUserEmail(String userEmail);
    List<AmountTransactionDTO> loadAllWaitTransactions();
    void deleteByUserEmail(String userEmail) throws SQLException;
}
