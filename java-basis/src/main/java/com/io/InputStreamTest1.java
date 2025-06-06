package com.io;

import java.io.FileInputStream;
import java.io.InputStream;

public class InputStreamTest1 {

    public static void main(String[] args) throws Exception {
        
        // InputStream pipeline

        InputStream fileInputStream = new FileInputStream("java-basis/src/main/resources/InputStream/test1.txt");
        
        // read one byte every time

        // int b1 = fileInputStream.read();
        // int b2 = fileInputStream.read();
        // int b3 = fileInputStream.read();
        // int b4 = fileInputStream.read();

        // System.out.println(b1); // 97
        // System.out.println(b2); // 98
        // System.out.println(b3); // 99
        // System.out.println(b4); // -1

        // System.out.println((char)b1); // a
        // System.out.println((char)b2); // b
        // System.out.println((char)b3); // c
        // System.out.println((char)b4); // ￿


        // use while loop to read
        int b;
        while ((b = fileInputStream.read()) != -1) {
            System.out.print((char)b);
        }

        // stream pipeline must close right after using
        fileInputStream.close();
    }
    
}
