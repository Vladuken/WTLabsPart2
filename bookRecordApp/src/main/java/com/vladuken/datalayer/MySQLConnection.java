package com.vladuken.datalayer;

import com.vladuken.exceptions.DAOException;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    private static final String DB_DRIVER="com.mysql.cj.jdbc.Driver";
    private static final String DB_URL="jdbc:mysql://localhost:3306/?autoReconnect=true&useSSL=false";
    private static final String DB_USERNAME="root";
    private static final String DB_PASSWORD="root";

    private static Connection connection;
    public static Connection getConnection() throws DAOException {
        if(connection == null) {
            try{
                Class.forName(DB_DRIVER);
                connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            }catch (SQLException e){
                throw new DAOException("MySQL connection error",e);
            }catch (ClassNotFoundException e){
                throw new DAOException("Driver for MySQL not found",e);
            }
        }
        return connection;
    }

    public static void close(Connection con) throws DAOException{
        if(connection.equals(con) && connection!=null)
        {
            try {
                connection.close();
                connection=null;
            }catch (SQLException e){
                throw new DAOException("MySQL close connection error ",e);
            }
        }
    }

}
