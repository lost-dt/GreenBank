package com.kpi.greenbank.model.dao.connector;

import org.apache.commons.dbcp.BasicDataSource;
import javax.sql.DataSource;
import java.util.ResourceBundle;

public class MySqlPoolConnector {

    private static final ResourceBundle resource = ResourceBundle.getBundle("my-sql-database-connection");

    private static final String DB_DRIVER = resource.getString("dbDriver");
    private static final String DB_URL = resource.getString("url");
    private static final String DB_USERNAME = resource.getString("user");
    private static final String DB_PASSWORD = resource.getString("password");
    private static final Integer DB_MIN_IDLE = Integer.parseInt(resource.getString("minIdle"));
    private static final Integer DB_MAX_IDLE = Integer.parseInt(resource.getString("maxIdle"));
    private static final Integer DB_MAX_OPEN_PREPARED_STATEMENTS = Integer.parseInt(resource.getString("maxOpenPreparedStatements"));

    private MySqlPoolConnector() {

    }

    private static volatile BasicDataSource dataSource;

    public static DataSource getDataSource() {

        if (dataSource == null) {
            synchronized (MySqlPoolConnector.class) {
                if (dataSource == null) {
                    BasicDataSource ds = null;
                    try {
                        ds = new BasicDataSource();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    ds.setDriverClassName(DB_DRIVER);
                    ds.setUrl(DB_URL);
                    ds.setUsername(DB_USERNAME);
                    ds.setPassword(DB_PASSWORD);
                    ds.setMinIdle(DB_MIN_IDLE);
                    ds.setMaxIdle(DB_MAX_IDLE);
                    ds.setMaxOpenPreparedStatements(DB_MAX_OPEN_PREPARED_STATEMENTS);
                    dataSource = ds;
                }
            }
        }
        return dataSource;

    }
}
