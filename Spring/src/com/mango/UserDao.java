package com.mango;

import java.sql.*;

public class UserDao {
    private ConnectionMaker connectionMaker;

    /* 상태를 관리하는 것이 아니기 때문에 한 번만 만들어 인스턴스 변수에 저장하고 메소드에서 사용한다 */
    public UserDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        /* 인터페이스에 정의된 메소드를 사용하므로 클래스가 바뀐다고 해도 메소드 이름이 변경될 걱정은 없다 */
        Connection c = connectionMaker.makeConnection();
         //SQL을 담은 Statement
        PreparedStatement ps = c.prepareStatement("insert into users(id, name, password) values(?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        // SQL 문 실행
        ps.executeUpdate();

        ps.close();
        c.close();
    }

    public User get(String id) throws  ClassNotFoundException, SQLException {
        Connection c = connectionMaker.makeConnection();

        PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }
}
