import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MyIdea {

    public static void main(String[] args){
        MyIdea idea = new MyIdea();
        System.out.println(idea.getClass().getResource("/network/ping.jpg"));
    }
}
