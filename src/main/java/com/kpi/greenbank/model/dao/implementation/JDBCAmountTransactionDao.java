package com.kpi.greenbank.model.dao.implementation;

import com.kpi.greenbank.model.dao.interfase.AmountTransactionDao;
import com.kpi.greenbank.model.dto.AmountTransactionDTO;
import com.kpi.greenbank.model.entity.AmountTransaction;
import com.kpi.greenbank.model.entity.TransactionStatus;
import com.kpi.greenbank.model.util.date.DateFormator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JDBCAmountTransactionDao implements AmountTransactionDao {

    private static final Logger logger = LogManager.getLogger(JDBCAmountTransactionDao.class);

    private static final String DATABASE_NAME = "green_bank";
    private static final String TABLE_NAME = "amount_transaction";

    private static final String QUERY_ADD = String.format(
            "INSERT INTO %s.%s (USER_EMAIL, AMOUNT_VALUE, STATUS, CREATION_TIME, HANDLED_BY, HANDLED_TIME) " +
                    "VALUES (?, ?, ?, ?, ?, ?)",
            DATABASE_NAME,
            TABLE_NAME
    );
    private static final String QUERY_LOAD_ALL = String.format(
            "SELECT ID, USER_EMAIL, AMOUNT_VALUE, STATUS, CREATION_TIME, HANDLED_BY, HANDLED_TIME FROM %s.%s",
            DATABASE_NAME,
            TABLE_NAME
    );

    private Connection connection;

    JDBCAmountTransactionDao(Connection connection) {
        this.connection = connection;
    }


    private AmountTransactionDTO createAmountTransactionFromResultSet(ResultSet resultSet) throws SQLException {
        AmountTransactionDTO amountTransactionDTO = new AmountTransactionDTO.Builder()
                .setId(resultSet.getInt("ID"))
                .setUserEmail(resultSet.getString("USER_EMAIL"))
                .setAmountValue(resultSet.getFloat("AMOUNT_VALUE"))
                .setStatus(TransactionStatus.valueOf(resultSet.getString("STATUS").toUpperCase()))
                .setCreationTime(resultSet.getDate("CREATION_TIME"))
                .setHandledBy(resultSet.getString("HANDLED_BY"))
                .setHandledTime(resultSet.getDate("HANDLED_TIME"))
                .build();

        return amountTransactionDTO;
    }

    @Override
    public void add(AmountTransaction entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ADD);

        preparedStatement.setString(1, entity.getUserEmail());
        preparedStatement.setFloat(2, entity.getAmountValue());
        preparedStatement.setString(3, entity.getStatus().getTitle());
        preparedStatement.setString(4, DateFormator.formatByDefaultFormator(entity.getCreationTime()));
        preparedStatement.setString(5, entity.getHandledBy());
        preparedStatement.setString(6, DateFormator.formatByDefaultFormator(entity.getHandledTime()));

        preparedStatement.executeUpdate();
    }

    @Override
    public List<AmountTransactionDTO> loadAll() {
        List<AmountTransactionDTO> amountTransactionDTOS = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(QUERY_LOAD_ALL);

            while (resultSet.next()) {
                AmountTransactionDTO card = createAmountTransactionFromResultSet(resultSet);
                amountTransactionDTOS.add(card);
            }
        } catch (SQLException e) {
            logger.info(e.getStackTrace());
        }
        return amountTransactionDTOS;
    }

    @Override
    public List<AmountTransactionDTO> loadAllByUserEmail(String userEmail) {
        List<AmountTransactionDTO> amountTransactionDTOS = loadAll();

        return amountTransactionDTOS.stream().filter(item -> item.getUserEmail().equals(userEmail)).collect(Collectors.toList());
    }

    @Override
    public AmountTransaction findById(String id) throws SQLException {
        return null;
    }

    @Override
    public void update(AmountTransaction entity) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public void close() throws SQLException {

    }
}
