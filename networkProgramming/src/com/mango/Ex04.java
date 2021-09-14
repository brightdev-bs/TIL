package com.mango;

import java.io.FileOutputStream;

public class Ex04 {
    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("file02a.dat");
        for(int i = 321; i < 321 + 26; i++) {
            fos.write(i);
        }
        fos.close();
    }
}
