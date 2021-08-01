package com.mango;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DconnectionMaker implements ConnectionMaker{
    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring", "spring", "1234");
        return c;
    }
}
