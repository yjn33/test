package user.dao;

import user.domain.User;

import java.sql.SQLException;

public class UserDaoTest
{
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {

        UserDao dao = new DaoFactory().userDao();

        User user = new User();
        user.setId("fdfd");
        user.setName("zzz");
        user.setPassword("ggg");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());

        System.out.println(user2.getId() + " 조회 성공");
    }

}
