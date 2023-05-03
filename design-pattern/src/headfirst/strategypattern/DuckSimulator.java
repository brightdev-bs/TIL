package headfirst.strategypattern;

public class DuckSimulator {

    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performFly();
        mallard.perfromQuack();
    }
}
