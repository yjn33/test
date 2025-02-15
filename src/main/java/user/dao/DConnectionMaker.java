package user.dao;

import java.sql.*;


public class DConnectionMaker implements ConnectionMaker
{
    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException
    {
        //Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/users", "zen",
                "1234!@abcABC");

        return c;
    }
}
