package personally.observer;

import java.util.ArrayList;
import java.util.List;

public class Topic implements  Subject {

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void subscribe(Observer ob) {
        observers.add(ob);
    }

    @Override
    public void unsubscribe(Observer ob) {
        observers.remove(ob);
    }

    @Override
    public void notifyToSubscriber() {
        for (Observer observer : observers) {
            observer.notifyToSubscriber();
        }
    }
}
