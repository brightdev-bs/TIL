package functionalInterface.defaultMethod;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        DefaultMethodPractice dmp = new DefaultMethodPractice();
        dmp.printToday();
        dmp.printFormattedToday(new Date());
    }
}
