package personally.factory;

public class Mango extends Fruit {

    private final int price;

    public Mango(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return this.price;
    }
}
