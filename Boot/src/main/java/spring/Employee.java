package spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Employee implements WorkManager {
    @Override
    public String doIt() {
        return "do Work";
    }

    @PostConstruct
    public void onCreated() {
        System.out.println("Employee 초기화");
    }

    @PreDestroy
    public void onDestroyed() {
        System.out.println("Employee 소멸");
    }
}
