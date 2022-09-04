package springbook.user.dao;

public class DaoFactory {
    // ConnectionMaker 구현 클래스를 선정하고 생성하는 코드의 중복 발생!
    public UserDao userDao() {
        return new UserDao(connectionMaker());
    }

    public AccountDao accountDao() {
        return new AccountDao(connectionMaker());
    }

    public MessageDao messageDao() {
        return new MessageDao(connectionMaker());
    }

    public ConnectionMaker connectionMaker() {
        // 분리해서 중복을 제거한 ConnectionMaker 타입 오브젝트 생성 코드
        return new DConnectionMaker();
    }
}
