
package com.mycompany.funcionarios.iud.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionUtil {
    
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Admin";
    
    
    public static Connection getConnectios() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
}
