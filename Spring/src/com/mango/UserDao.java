package com.mango;

import java.sql.*;

public class UserDao {
    private SimpleConnectionMaker simpleConnectionMaker;

    /* 상태를 관리하는 것이 아니기 때문에 한 번만 만들어 인스턴스 변수에 저장하고 메소드에서 사용한다 */
    public UserDao() {
        simpleConnectionMaker = new SimpleConnectionMaker();
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection c = simpleConnectionMaker.makeNewConnection();
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
        Connection c = simpleConnectionMaker.makeNewConnection();

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
