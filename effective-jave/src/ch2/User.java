package ch2;

public class User {

    private boolean event;
    private boolean normal;
    private GameCharacter gameCharacter;

    public User() {}

    public User(boolean event, GameCharacter gameCharacter) {
        this.event = event;
        this.gameCharacter = gameCharacter;
    }

    public User(GameCharacter gameCharacter, boolean normal) {
        this.normal = normal;
        this.gameCharacter = gameCharacter;
    }

    public static User eventUser(GameCharacter gameCharacter) {
        User user = new User();
        user.event = true;
        user.gameCharacter = gameCharacter;
        return user;
    }
}
