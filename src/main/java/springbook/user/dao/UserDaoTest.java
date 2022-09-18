package springbook.user.dao;

import javafx.application.Application;
import springbook.user.domain.User;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // GenericXmlApplicationContext를 이용해 애플리케이션 컨텍스트를 생성하게 만듬.
        // 생성자에는 applicationContext.xml의 클래스패스를 넣는다.
        // 클래스패스를 시작하는 "/"는 생략가능함. "/" 생략해도 항상 루트에서부터 시작하는 클래스패스이다.
        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
        UserDao dao = context.getBean("userDao", UserDao.class);

        User user = new User();
        user.setId("whiteship");
        user.setName("백기선");
        user.setPassword("married");

        dao.add(user);

        System.out.println(user.getId() + "등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
    }
}
