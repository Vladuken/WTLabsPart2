package com.vladuken.datalayer;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    private static final String DB_DRIVER="com.mysql.jdbc.Driver";
    private static final String DB_URL="jdbc:mysql://localhost:3306/?autoReconnect=true&useSSL=false";
    private static final String DB_USERNAME="root";
    private static final String DB_PASSWORD="root";

    private static Connection connection;
    public static Connection getConnection()throws SQLException,ClassNotFoundException{
        if(connection == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        }
        return connection;
    }

    public static void close(Connection con) throws SQLException{
        if(connection.equals(con) && connection!=null)
        {
            connection.close();
            connection=null;
        }
    }

}
