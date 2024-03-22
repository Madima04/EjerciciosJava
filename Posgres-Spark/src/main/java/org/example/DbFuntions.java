package org.example;

import java.sql.Connection;

public class DbFuntions {
    public Connection connect_to_db() {
        Connection conn = null;
        try {
             conn = java.sql.DriverManager.getConnection("jdbc:postgresql://localhost:5432/concesionario", "Mario", "1234");
             if (conn != null) {
                 System.out.println("Connected to the database!");
             } else {
                 System.out.println("Failed to make connection!");
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

}
