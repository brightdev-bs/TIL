package headfirst.adapter;

import headfirst.strategypattern.FlyBehavior;
import headfirst.strategypattern.QuackBehavior;

public interface Duck {

    public void quack();
    public void fly();
}