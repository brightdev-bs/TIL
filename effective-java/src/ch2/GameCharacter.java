package ch2;

public class GameCharacter {

    private String username;
    private int level;

    private GameCharacter() {};

    private static final GameCharacter INSTANCE = new GameCharacter();

    public static GameCharacter newInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        System.out.println(new GameCharacter());
        System.out.println(new GameCharacter());
        System.out.println(new GameCharacter());

        System.out.println(GameCharacter.newInstance());
        System.out.println(GameCharacter.newInstance());
    }
}
