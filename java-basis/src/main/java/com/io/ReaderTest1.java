package com.io;

import java.io.FileReader;
import java.io.Reader;

public class ReaderTest1 {

    public static void main(String[] args) {

        // 1. read one character every time
        try (
            Reader r1 = new FileReader("java-basis/src/main/resources/Reader/test3.txt");
        ) {
            int c;
            while ((c = r1.read()) != -1) {
                System.out.print((char)c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 2. read with buffer/"bucket"
        try (
            Reader r2 = new FileReader("java-basis/src/main/resources/Reader/test3.txt");
        ) {
            // a buffer/bucket to take water from the stream
            char[] buffer = new char[3];
            // read(buffer) will return how many "water" you take
            // we need this len to 
            int len;
            while ((len = r2.read(buffer)) != -1) {
                String hasRead = new String(buffer, 0, len);
                System.out.print(hasRead);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
