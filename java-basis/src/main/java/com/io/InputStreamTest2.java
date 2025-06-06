package com.io;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * read(byte[] buffer)
 */

public class InputStreamTest2 {

    public static void main(String[] args) throws Exception {
        
        InputStream is = new FileInputStream("java-basis/src/main/resources/InputStream/test2.txt");

        // buffer is a byte array
        // you can understand buffer as a bucket to get the water from the stream (water stream)
        // you need to define how big the bucket is
        // so every time you get the water from the water stream you use the bucket with the certain capacity
        byte[] buffer = new byte[3];

        // read(byte[] buffer): get the water from the water stream using bucket and tells you how many water you take ==> not every time you can fill the bucket
        int len1 = is.read(buffer);
        String rs1 = new String(buffer, 0, len1);
        System.out.println("how many bytes have been read? : " + len1);
        System.out.print(rs1);

        // although buffer (bucket) has been used once and filled with water, you can still use it again to take the water
        int len2 = is.read(buffer);
        // why do you create string with the length? because it could be that at the end the bucket can't be filled
        // when you use the buffer again the new "water" will be just put into the buffer and override the old "water", if the new "water" can't fill the buffer, there will be old "water" left over in the buffer, so i need to know how much "water" i get this time, in order to avoid to read the old "water" from the buffer
        String rs2 = new String(buffer, 0, len2);
        System.out.println("how many bytes have been read? : " + len2);
        System.out.println(rs2);

        is.close();


        // how to read(byte[] buffer) with while loop?

        // it also can't avoid mojibake when you read chinese
        InputStream is1 = new FileInputStream("java-basis/src/main/resources/InputStream/test2.txt");
        byte[] bucket = new byte[3];
        int len;
        while ((len = is1.read(bucket)) != -1) {
            // how much you take and how much you out
            String rs = new String (bucket, 0, len);
            // System.out.println("how many you take: " + len);
            System.out.print(rs);
        }
    }
    
}
