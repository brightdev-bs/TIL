package com.example.tdd.ch1;


import java.util.Hashtable;

public class Bank {

    private Hashtable<Pair, Integer> rates = new Hashtable<>();
    public Money reduce(Expression source, String to) {
        return source.reduce(this, to);
    }

    int rate(String from, String to) {
        if(from.equals(to)) return 1;
        return rates.get(new Pair(from, to));
    }

    public void addRate(String from, String to, int rate) {
        rates.put(new Pair(from, to), rate);

    }
}
