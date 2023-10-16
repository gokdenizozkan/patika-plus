package dev.patika.plus.week7.helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnector {
    private Connection connection = null;

    public Connection connectDb() {
        try {
            connection = DriverManager.getConnection(Config.DB_URL, Config.DB_USERNAME, Config.DB_PASSWORD);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public static Connection getInstance() {
        DbConnector db = new DbConnector();
        return db.connectDb();
    }
}
