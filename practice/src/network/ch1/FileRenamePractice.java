package network.ch1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileRenamePractice  {

    public static void main(String[] args) {
//        File from = new File("old.txt");
//        File to = new File("to.txt");
//        from.renameTo(to);

        File from = new File("to.txt");
        File to = new File("D:\\study\\" + from.getName());
        from.renameTo(to);
    }
}
