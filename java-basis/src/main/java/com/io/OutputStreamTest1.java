package com.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class OutputStreamTest1 {
    
    public static void main(String[] args) throws Exception {

        // public FileOutputStream(File file)
        OutputStream os1 = new FileOutputStream(new File("java-basis/src/main/resources/OutputStream/test1.txt"));

        // public FileOutputStream(String filepath)
        OutputStream os2 = new FileOutputStream("java-basis/src/main/resources/OutputStream/test2.txt");

        // public FileOutputStream(String filepath, boolean append)
        OutputStream os3 = new FileOutputStream("java-basis/src/main/resources/OutputStream/test3.txt");

        // write() method only contains byte / byte[] parameter
        os1.write(97); // represents a byte
        os2.write('a'); // 'a' is a byte
        os3.write("win-java".getBytes());
        os3.write("\r\n".getBytes()); // next line
        os3.write('b');

        
        os1.close();
        os2.close();
        os3.close();
        
    }
}
