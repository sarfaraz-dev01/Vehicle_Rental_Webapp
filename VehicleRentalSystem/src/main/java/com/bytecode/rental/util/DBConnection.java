package com.bytecode.rental.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:9091/vehicle_rent_db";

    private static final String USER ="root";

    private static final String PASSWORD ="root";  
    
    public static Connection getConnection() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

            System.out.println("=================================");
            System.out.println("DATABASE CONNECTED SUCCESSFULLY");
            System.out.println("=================================");

            return con;

        } catch (Exception e) {

            System.out.println("=================================");
            System.out.println("DATABASE CONNECTION FAILED");
            System.out.println("=================================");

            e.printStackTrace();

          
            throw new RuntimeException(
                    "Database connection failed: "
                    + e.getMessage(), e);
        }
    }
}