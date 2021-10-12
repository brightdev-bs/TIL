package network.ch1;

import java.io.File;
import java.io.IOException;

public class FileCreationPractice {

    public static void main(String[] args) throws IOException {
        File newFile = new File("myFile");
        boolean suc = newFile.createNewFile();
        System.out.println(suc);
    }
}
