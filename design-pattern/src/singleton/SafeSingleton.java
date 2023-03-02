package singleton;

public class SafeSingleton {

    private SafeSingleton() {}

    private static class SettingsHolder {
        private static final SafeSingleton INSTANCE = new SafeSingleton();
    }

    public static SafeSingleton getInstance() {
        return SettingsHolder.INSTANCE;
    }
}