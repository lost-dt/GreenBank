package com.kpi.greenbank.model.dao.connector;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
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

    private MySqlPoolConnector() {

    }

    private static volatile HikariDataSource dataSource;

    public static DataSource getDataSource() {

        if (dataSource == null) {
            synchronized (MySqlPoolConnector.class) {
                final HikariConfig config = new HikariConfig();
                if (dataSource == null) {
                    config.setDriverClassName(DB_DRIVER);
                    config.setJdbcUrl(DB_URL);
                    config.setUsername(DB_USERNAME);
                    config.setPassword(DB_PASSWORD);
                    config.setMinimumIdle(DB_MIN_IDLE);
                    config.setMaximumPoolSize(DB_MAX_IDLE);

                    dataSource = new HikariDataSource(config);
                }
            }
        }
        return dataSource;

    }
}
