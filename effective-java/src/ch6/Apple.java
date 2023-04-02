package ch6;

public enum Apple {
    FUJI(5000),
    PIPPIN(3000),
    GRANNY_SMITH(1000);

    private final int price;

    Apple(int price) {
        this.price = price;
    }

    public int getPrice() { return price; }
}
