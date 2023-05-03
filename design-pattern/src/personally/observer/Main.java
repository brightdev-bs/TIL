package personally.observer;

public class Main {

    public static void main(String[] args) {
        Topic designPattern = new Topic();
        Observer user1 = new User(1L, "user1");
        Observer user2 = new User(2L, "user2");
        Observer user3 = new User(3L, "user3");

        designPattern.subscribe(user1);
        designPattern.subscribe(user2);
        designPattern.subscribe(user3);
        designPattern.notifyToSubscriber();

        System.out.println("====================================");
        designPattern.unsubscribe(user1);
        designPattern.notifyToSubscriber();
    }
}
