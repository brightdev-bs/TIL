package headfirst.prac;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Flock implements Quackalbe {
    List<Quackalbe> quackers = new ArrayList<>();

    public void add(Quackalbe quacker) {
        quackers.add(quacker);
    }

    @Override
    public void quack() {
        Iterator<Quackalbe> iterator = quackers.iterator();
        while (iterator.hasNext()) {
            Quackalbe quacker = iterator.next();
            quacker.quack();
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        Iterator<Quackalbe> iterator = quackers.iterator();
        while (iterator.hasNext()) {
            Quackalbe quacker = iterator.next();
            quacker.registerObserver(observer);
        }
    }

    @Override
    public void notifyObservers() {}
}
