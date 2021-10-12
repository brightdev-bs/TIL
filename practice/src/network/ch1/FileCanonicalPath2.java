package network.ch1;

import java.io.File;
import java.io.IOException;

public class FileCanonicalPath2 {

    public static void main(String[] args) throws Exception {
        File file1 = new File("Ran.test");
        File file2 = new File(".");
        File file3 = new File("..");
        System.out.println(System.getProperty("user.dir"));
        System.out.println(file1.getCanonicalPath());
        System.out.println(file1.getCanonicalFile());
//        System.out.println(file2.getCanonicalPath());
//        System.out.println(file3.getCanonicalPath());

    }
}
