package com.mango;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Ex02 {

    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("file02.dat");
        for(int i = 33; i <= 125; i++) {
            fos.write(i);
        }
        fos.close();
    }
}
