package headfirst.prac;

public class DuckFactory extends AbstractDuckFactory {

    @Override
    public Quackalbe createMallardDuck() {
        return new QuackCounter(new MallardDuck());
    }

    @Override
    public Quackalbe createRedHeadDuck() {
        return new QuackCounter(new ReadHeadDuck());
    }

    @Override
    public Quackalbe createDuckCall() {
        return new QuackCounter(new DuckCall());
    }

    @Override
    public Quackalbe createRubberDuck() {
        return new QuackCounter(new RubberDuck());
    }
}
