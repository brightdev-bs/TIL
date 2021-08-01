package com.mango;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConnectionMaker {
    public Connection makeNewConnection() throws ClassNotFoundException, SQLException {
         /*
         JDBC란 자바에서 제공하는 데이터베이스와 연결하여 데이터를 주고 받을 수 있도록 하는 인터페이스.
         Class.forName() 메서드를 이용하여 드라이버를 로드.
         DriverManager.getConnection() 메서드를 이용하여 DB와 연결.
         */
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/spring", "spring", "1234");
        return c;
    }
}
