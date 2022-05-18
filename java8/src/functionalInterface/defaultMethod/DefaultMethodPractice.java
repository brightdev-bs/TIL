package functionalInterface.defaultMethod;

import java.util.Date;

public class DefaultMethodPractice implements Today {

    @Override
    public void printToday() {
        System.out.println(new Date());
    }
}
