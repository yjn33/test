package user.dao;


import java.sql.*;

import user.domain.User;


public class UserDao
{
    private ConnectionMaker connectionMaker;

    public UserDao(ConnectionMaker connectionMaker)
    {
        this.connectionMaker = connectionMaker;
    }


    public void add(User user) throws ClassNotFoundException, SQLException
    {

        // 첫번째 concerns
        Connection c = connectionMaker.makeConnection(); // 분리된 기능
        // 첫번째 concerns 끝

        // 두번째 concerns
        PreparedStatement ps = c.prepareStatement
                (
                        "insert into users(id, name, password) values(?,?,?)"
                );

        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();
        // 두번째 concerns 끝


        // 세번째 concerns
        ps.close();
        c.close();
        // 세번째 concerns 끝
    }


    public User get(String id) throws ClassNotFoundException, SQLException
    {
        Connection c = connectionMaker.makeConnection();


        PreparedStatement ps = c
                .prepareStatement("select * from users where id = ?");
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