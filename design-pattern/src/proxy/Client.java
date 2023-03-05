package proxy;

public class Client {

    public static void main(String[] args) {
        WelcomeService welcomeService = new WelComeServiceProxy(new WelcomeServiceImpl());
        welcomeService.welcome();
    }
}
