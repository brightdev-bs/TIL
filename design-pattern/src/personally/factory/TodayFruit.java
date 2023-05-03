package personally.factory;

public class TodayFruit extends Fruit {

    private final int price;

    public TodayFruit(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return this.price;
    }
}
