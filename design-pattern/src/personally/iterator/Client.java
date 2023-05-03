package personally.iterator;

import java.util.Iterator;
import java.util.List;

public class Client {

    public static void main(String[] args) {
        Board board = new Board();
        board.addTitle("디자인 패턴");
        board.addTitle("gof 디자인 패턴");
        board.addTitle("디자인 패턴 공부중");

        // 기존 코드
        List<String> titles = board.getTitles();
        for (String title : titles) {
            System.out.println(title);
        }


        System.out.println("================================");

        // Iterator 이용
        Iterator<String> iterator = board.getTitles().iterator();
        while(iterator.hasNext()) {
            String title = iterator.next();
            System.out.println(title);
        }

    }
}
