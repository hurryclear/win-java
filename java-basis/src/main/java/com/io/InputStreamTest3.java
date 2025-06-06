package com.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * read all bytes at once
 * 1. set size of buffer/bucket as same as the size of the file
 * 2. readAllBytes() API from InputStream
 */
public class InputStreamTest3 {
    
    public static void main(String[] args) throws Exception {

        InputStream is1 = new FileInputStream("java-basis/src/main/resources/InputStream/test3.txt");
        
        InputStream is2 = new FileInputStream("java-basis/src/main/resources/InputStream/test3.txt");
        // 1. set size of buffer/bucket as same as the size of the file
        // 1.1 get the size of the file
        File file = new File("java-basis/src/main/resources/InputStream/test3.txt");
        long fileSize = file.length();
        // 1.2 create a buffer/bucket with the same size of the file
        byte[] buffer = new byte[(int)fileSize];
        // 1.3 take the "water" with big enough "bucket" at once
        int len1 = is1.read(buffer);
        System.out.println(new String(buffer));
        System.out.println(len1);
        System.out.println(fileSize);

        is1.close();

        // 2. readAllBytes()
        // I can't find this method from InputStream

        // byte[] allBytes = is2.readAllBytes();
        // System.out.println(new String(allBytes));
        // is2.close();





    }
}
