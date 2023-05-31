package headfirst.prac;

public interface QuackObservable {
    public void registerObserver(Observer observer);
    public void notifyObservers();
}
