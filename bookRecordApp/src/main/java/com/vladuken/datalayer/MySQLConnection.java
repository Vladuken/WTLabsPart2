package com.vladuken.datalayer;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class MySQLConnection {

    private static final String DB_DRIVER="com.mysql.jdbc.Driver";
    private static final String DB_URL="jdbc:mysql://localhost:3306/?autoReconnect=true&useSSL=false";
    private static final String DB_USERNAME="root";
    private static final String DB_PASSWORD="v375699v210499";

    public Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);

        }catch (Exception e){
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return connection;
    }

}
