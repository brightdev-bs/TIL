package com.mango;

import java.io.FileOutputStream;

public class Ex06 {

    public static void main(String[] args) throws Exception {
        byte[] b = new byte[26];
        for(int i = 0; i < 26; i++) {
            b[i] = (byte)(i + 65);
        }

        FileOutputStream fos = new FileOutputStream("file03a.dat");
        fos.write(b);
        fos.close();
    }
}
