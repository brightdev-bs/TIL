package com.mango;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 빈 팩토리를 위한 오브젝트 설정을 담당하는 클래스
public class DaoFactory {
    /* 팩토리의 메서드는 UserDao 타입의 오브젝트를 어떻게 만들고, 어떻게 준비시킬지를 결정 */
    @Bean // 오브젝트를 만들어주는 메서드
    public UserDao userDao() {
        ConnectionMaker connectionMaker = new DconnectionMaker();
        UserDao userDao = new UserDao(connectionMaker);
        return userDao;
    }

    @Bean
    public ConnectionMaker connectionMaker() {
        return new DconnectionMaker();
    }
}
