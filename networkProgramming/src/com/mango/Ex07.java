package com.mango;

import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

public class Ex07 {

    public static void main(String[] args) throws Exception {
        String s = "자랑스러운 우리학교";
        byte[] data = s.getBytes(StandardCharsets.UTF_8);

        FileOutputStream fos = new FileOutputStream("edu.dat");
        fos.write(data);
        fos.close();
    }
}
