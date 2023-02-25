package ch2.singleton;

public class Elvis implements IElvis {

    // 주석을 달면 JavaDocs를 만들면 이를 쉽게 확인할 수 있다.
    public static final Elvis INSTANCE = new Elvis();
    private static boolean created;

    private Elvis() {
        if(created) {
            throw new UnsupportedOperationException("already created");
        }
        created = true;
    };

    @Override
    public void hello() {
        System.out.println("Hello I'm Elvis");
    }

    public static Elvis getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.hello();
    }

}
