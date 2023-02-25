package ch2.singleton;

public class MetaElvis<T> {

    private static final MetaElvis<Object> INSTANCE = new MetaElvis<>();

    private MetaElvis() {}

    public static <T> MetaElvis<T> getInstance() {
        return (MetaElvis<T>) INSTANCE;
    }

    public void hello(T t) {
        System.out.println(t);
    }

    public static void main(String[] args) {
        MetaElvis<String> instance = MetaElvis.getInstance();
        MetaElvis<Integer> instance2 = MetaElvis.getInstance();
        System.out.println(instance);
        System.out.println(instance2);
        instance.hello("Hello I'm Elvis");
        instance2.hello(200);
    }
}
