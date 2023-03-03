package factory;

public class Main {

    public static void main(String[] args) {
        Fruit apple = FruitFactory.getFruit("apple", 1000);
        Fruit mango = FruitFactory.getFruit("mango", 1500);
        System.out.println("apple = " + apple.getPrice());
        System.out.println("mango = " + mango.getPrice());
    }
}
