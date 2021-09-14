package com.mango;

import java.io.FileOutputStream;

public class Ex03 {

    public static void main(String[] args) throws Exception {
        FileOutputStream fos = new FileOutputStream("fos321.dat");
        int data = 321;
        fos.write(data);
        fos.close();
    }
}
