package com.kpi.greenbank.model.dao.implementation;

import com.kpi.greenbank.model.dao.DaoFactory;
import com.kpi.greenbank.model.dao.UserDao;
import com.kpi.greenbank.model.dao.connector.MySqlPoolConnector;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import javax.sql.DataSource;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {

    private static final Logger logger = LogManager.getLogger(JDBCDaoFactory.class);


    private DataSource dataSource = MySqlPoolConnector.getDataSource();

    @Override
    public UserDao createUserDao() {
        return new JDBSUserDao(getConnection());
    }

    private Connection getConnection(){
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            logger.info(e.getStackTrace());
        }
        return connection;
    }
}
