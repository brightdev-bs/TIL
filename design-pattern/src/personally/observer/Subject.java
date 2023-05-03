package personally.observer;


public interface Subject {

    void subscribe(Observer ob);
    void unsubscribe(Observer ob);
    void notifyToSubscriber();
}
