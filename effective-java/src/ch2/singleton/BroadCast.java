package ch2.singleton;

import java.util.function.Supplier;

public class BroadCast {

    private int channel;
    private boolean on;
    private IElvis elvis;

    public BroadCast() {}

    public BroadCast(IElvis elvis) {
        this.elvis = elvis;
    }

    public void start(Supplier<Elvis> supplier) {
        Elvis instance = supplier.get();
        instance.hello();
    }

    public void perform() {
        on = true;
        elvis.hello();
    }

    public int getChannel() {
        return channel;
    }

    public boolean isOn() {
        return on;
    }

    public static void main(String[] args) {
        BroadCast broadCast = new BroadCast();
        broadCast.start(Elvis::getInstance);
    }

}
