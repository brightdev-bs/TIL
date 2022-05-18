package functionalInterface.defaultMethod;

import java.text.SimpleDateFormat;
import java.util.Date;

public interface Today {

    void printToday();

    default void printFormattedToday(Date date) {
        SimpleDateFormat formattedDate = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println(formattedDate.format(date));
    }
}
