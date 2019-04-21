package com.microservices.payment.backend.dao;

import com.microservices.payment.backend.model.Payment;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class DbConnect{

    private static final SimpleDateFormat TIMEFORMAT = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
    private static final String DB_URL= "jdbc:mysql://" +
                                        "localhost:3306/" +
                                        "neoflex_task?" +
                                        "&useSSL=false" +
                                        "&useLegacyDatetimeCode=false" +
                                        "&serverTimezone=UTC";
    private static final String DB_USERNAME="root";
    private static final String DB_PASSWORD="123456";
   // private Connection connection = getConnection();
    public Connection getConnection(){
        Connection connection = null;
        try {
            connection= DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
            System.out.println("Connection successful");
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("Connection fail");
        }

        return connection;
    }




}
