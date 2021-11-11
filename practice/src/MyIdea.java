import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MyIdea {

    public static void main(String[] args){

    }

    public static String readText(String filename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        
    }
}
