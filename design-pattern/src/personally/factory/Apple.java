package personally.factory;

public class Apple extends Fruit {

    private final int price;

    public Apple(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return this.price;
    }
}
