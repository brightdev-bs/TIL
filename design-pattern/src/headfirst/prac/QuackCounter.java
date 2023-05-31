package headfirst.prac;

public class QuackCounter implements Quackalbe {

    Quackalbe duck;
    static int numberOfQuakcs;

    public QuackCounter(Quackalbe duck) {
        this.duck = duck;
    }

    @Override
    public void quack() {
        duck.quack();
        numberOfQuakcs++;
    }

    public static int getQuakcs() {
        return numberOfQuakcs;
    }

    @Override
    public void registerObserver(Observer observer) {
        duck.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        duck.notifyObservers();
    }
}
