package com.vladuken.datalayer;

import com.vladuken.exceptions.DAOException;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class MySQLConnectionTest {

    @Test
    public void getConnection() throws DAOException {
        Connection connection = MySQLConnection.getConnection();
    }


    @Test
    public void close() throws DAOException{
        Connection connection = MySQLConnection.getConnection();
        MySQLConnection.close(connection);
    }
}