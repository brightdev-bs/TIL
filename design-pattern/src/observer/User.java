package observer;

public class User implements Observer {

    private Long userId;
    private String name;

    public User(Long userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    @Override
    public void notifyToSubscriber() {
        System.out.println("새로운 글이 작성되었습니다.");
    }
}
