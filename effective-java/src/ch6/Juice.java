package ch6;

import java.io.Serializable;

public class Juice implements Serializable {

    String name;
    int price;

    public Juice(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
