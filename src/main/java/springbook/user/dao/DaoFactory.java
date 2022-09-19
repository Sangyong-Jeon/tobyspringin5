package springbook.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

@Configuration // 애플리케이션 컨텍스트 또는 빈 팩토리가 사용할 설정정보라는 표시
public class DaoFactory {

    // DataSource 타입의 빈을 DI 받는 userDao() 빈 정의 메소드
    @Bean // 오브젝트 생성을 담당하는 IoC용 메소드라는 표시
    public UserDao userDao() {
        UserDao userDao = new UserDao();
        userDao.setDataSource(dataSource());
        return userDao;
    }

    @Bean
    public ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }

    // DataSource 타입의 dataSource 빈 정의 메소드
    @Bean
    public DataSource dataSource() {
        // DataSource 구현 클래스 중 테스트 환경에서 간단히 사용하는 SimpleDriverDataSource
        // 이것은 DB 연결에 필요한 필수 정보를 제공받을 수 있도록 여러 수정자 메소드를 가지고 있음
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

        // DB 연결정보를 수정자 메소드로 넣어줌. 이러면 오브젝트 레벨에서 DB 연결 방식을 변경할 수 있음
        dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
        dataSource.setUrl("jdbc:mysql://localhost/springbook");
        dataSource.setUsername("spring");
        dataSource.setPassword("book");

        return dataSource;
    }
}
