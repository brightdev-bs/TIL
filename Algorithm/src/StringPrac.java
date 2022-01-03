import java.util.*;

public class StringPrac {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("1", 1); map.put("2", 2); map.put("3", 3);

        System.out.println("EntrySet을 이용한 방법");

        Set set = map.entrySet();
        Iterator it = set.iterator();
        while(it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            System.out.println("e.getKey() = " + e.getKey() + " e.getValue() = " + e.getValue());
        }

        System.out.println("keySet를 이용한 방법");

        Set keys = map.keySet();
        System.out.println("keys = " + keys);

        Collection values = map.values();
        System.out.println("values = " + values);


    }
}
