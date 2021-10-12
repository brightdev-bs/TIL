package network.ch1;

import java.io.File;

public class Ch1_1 {

    public static void main(String[] args) {
        File file = new File("..\\dirC\\ch1_1.txt");
        System.out.println(file.getName()); // 파일명 출력
        System.out.println(file.getPath()); //패스명
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getParent());
    }
}
