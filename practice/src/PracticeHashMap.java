import java.util.*;

public class PracticeHashMap {

    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("Kim", "1234");
        map.put("mango", "1111");
        map.put("mango", "1234");

        Set set = map.entrySet();
        Iterator it = set.iterator();

        while(it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            System.out.println("이름 : " + e.getKey() + ", 점수 : " + e.getValue());
        }

        set = map.keySet();
        System.out.println("키 셋 : " + set);

        Collection values = map.values();
        System.out.println("값 : " + values);

        System.out.println("mango : " + map.containsKey("mango"));
        System.out.println("mario : " + map.containsKey("mario"));

        System.out.println("1234 : " + map.containsValue("1234"));
        System.out.println("1111 : " + map.containsValue("1111"));
    }
}
