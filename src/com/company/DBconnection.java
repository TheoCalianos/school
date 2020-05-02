package com.company;
import java.sql.*;

import java.sql.Connection;

public class DBconnection {
    //private static final String USERNAME = "root";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    //private static final String PASSWORD = "root";
    private static final String CONN = "jdbc:mysql://localhost:3306/project";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONN,USERNAME,PASSWORD);
    }
}
