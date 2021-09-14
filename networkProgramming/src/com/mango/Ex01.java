package com.mango;

import java.io.FileOutputStream;

public class Ex01 {

    public static void main(String[] args) throws Exception{
        FileOutputStream fos = new FileOutputStream("file01.txt ");
        for(int i = 65; i < 65 + 26; i++) {
            fos.write(i);// write your code here
        }
        fos.close();
    }
}
