package functionalInterface.lazy;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class LazyEvaluation {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

//        printState(true, getName());
//        printState(false, getName());
//        printState(false, getName());

        printStateV2(true, () -> getName());
        printStateV2(false, () -> getName());
        printStateV2(false, () -> getName());

        System.out.println((System.currentTimeMillis() - startTime) / 1000 + "sec");
    }

    public static void printStateV2(boolean valid, Supplier<String> nameSupplier) {
        if(valid) {
            System.out.println(nameSupplier.get() + " world");
        } else {
            System.out.println("hello world");
        }
    }

    public static void printState(boolean valid, String name) {
        if(valid) {
            System.out.println(name + " world");
        } else {
            System.out.println("hello world");
        }
    }

    public static String getName()  {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "vanilla";
    }
}
