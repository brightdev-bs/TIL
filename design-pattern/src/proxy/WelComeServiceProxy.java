package proxy;

import java.time.LocalDateTime;

public class WelComeServiceProxy implements WelcomeService {

    private WelcomeService welcomeService;

    public WelComeServiceProxy(WelcomeService welcomeService) {
        this.welcomeService = welcomeService;
    }

    @Override
    public void welcome() {
        LocalDateTime now = LocalDateTime.now();
        welcomeService.welcome();
        System.out.println(now + " 접속하였습니다.");
    }
}
