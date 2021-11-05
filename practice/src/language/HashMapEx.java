package language;

import java.util.*;

public class HashMapEx {

    public static void main(String[] args) {
        HashMap hashMap = new HashMap();

        hashMap.put("data1", "1");
        hashMap.put("data2", 2);
        hashMap.put("data2", "2");
        hashMap.put("data3", "3");

        System.out.println(hashMap.containsKey("data2"));
        System.out.println(hashMap.containsValue(2));

        Set set = hashMap.entrySet();
        Iterator it = set.iterator();

        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            System.out.println("이름 : " + entry.getKey() + ", 점수 : " + entry.getValue());
        }

        set = hashMap.keySet();
        System.out.println(set);

        Collection values = hashMap.values();
        System.out.println(values);
    }
}
