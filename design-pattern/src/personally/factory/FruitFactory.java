package personally.factory;

public class FruitFactory {
    public static Fruit getFruit(String type, int price) {
        if("Apple".equalsIgnoreCase(type)) return new Apple(price);
        else if("Mango".equalsIgnoreCase(type)) return new Mango(price);
        else return new TodayFruit(price);
    }
}
