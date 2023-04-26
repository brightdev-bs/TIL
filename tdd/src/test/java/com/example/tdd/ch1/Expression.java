package com.example.tdd.ch1;

public interface Expression {

    Money reduce(Bank bank, String to);

    Expression plus(Expression addend);
}
