package com.mango;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {
    /* 팩토리의 메서드는 UserDao 타입의 오브젝트를 어떻게 만들고, 어떻게 준비시킬지를 결정 */
    @Bean
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
