package headfirst.prac;

public class DuckSimulator {

    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        AbstractDuckFactory duckFactory = new DuckFactory();
        simulator.simulate(duckFactory);
    }

    void simulate(AbstractDuckFactory duckFactory) {
        Quackalbe readHeadDuck = duckFactory.createRedHeadDuck();
        Quackalbe duckCall = duckFactory.createDuckCall();
        Quackalbe rubberDuck = duckFactory.createRubberDuck();
        Quackalbe gooseDuck = new GooseAdapter(new Goose());
//
//        System.out.println("\n오리 시뮬레이션 게임: 무리 (+컴포지트)");

        Flock flockOfDucks = new Flock();
        flockOfDucks.add(readHeadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(gooseDuck);

        Flock flockOfMallards = new Flock();

        Quackalbe mallardDuck = duckFactory.createMallardDuck();
        Quackalbe mallardDuck2 = duckFactory.createMallardDuck();
        Quackalbe mallardDuck3 = duckFactory.createMallardDuck();
        Quackalbe mallardDuck4 = duckFactory.createMallardDuck();

        flockOfMallards.add(mallardDuck);
        flockOfMallards.add(mallardDuck2);
        flockOfMallards.add(mallardDuck3);
        flockOfMallards.add(mallardDuck4);
        flockOfDucks.add(flockOfMallards);

        System.out.println("\n 오리 시뮬레이션 게임 (+옵저버");
        Quackologist quackologist = new Quackologist();
        flockOfDucks.registerObserver(quackologist);

        simulate(flockOfDucks);

        System.out.println("울음 소리 : " + QuackCounter.numberOfQuakcs);
    }

    void simulate(Quackalbe duck) {
        duck.quack();
    }
}
