package headfirst.adapter;

import headfirst.strategypattern.FlyWithWings;
import headfirst.strategypattern.Quack;

public class MallardDuck implements Duck {

    @Override
    public void quack() {
        System.out.println("꽥꽥");
    }

    @Override
    public void fly() {
        System.out.println("하늘 나는중 ~");
    }
}
