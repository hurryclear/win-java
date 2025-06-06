package com.file;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class EncodingInJava {
    
    public static void main(String[] args) throws UnsupportedEncodingException {
        
        // 1. encoding by default character set
        // result: [97, -26, -120, -111, 98]
        // by default character set is UTF-8: 1 byte for english and num, 3 bytes for chinese
        String data = "a我b";
        byte[] bytes1= data.getBytes();
        String string1 = Arrays.toString(bytes1);
        System.out.println(string1); 

        // System.out.println(bytes); // why can't?
        // println() expects a format string, bytes is byte[] which is not acceptable for println()

        // 2. encoding with specific character set
        // result: [97, -50, -46, 98]
        // in GBK character set: english and num 1 byte and chinese 2 bytes
        byte[] bytes2 = data.getBytes("GBK"); // an exception
        String string2 = Arrays.toString(bytes2);
        System.out.println(string2);


        // 3. decoding UTF-8
        String s1 = new String(bytes1);
        String s2 = new String(bytes2);

        System.out.println(s1); // a我b
        System.out.println(s2); // a��b

        // 3. decoding GBK

        String s3 = new String(bytes1, "GBK"); 
        String s4 = new String(bytes2, "GBK");

        System.out.println(s3); // a鎴慴
        System.out.println(s4); // a我b
    }
}
