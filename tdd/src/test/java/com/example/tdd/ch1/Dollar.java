package com.example.tdd.ch1;

public class Dollar extends Money {

    public Dollar(int amount, String currecny) {
        super(amount, currecny);
    }

    String currency() {
        return currency;
    }
}
