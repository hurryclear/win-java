package com.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class InputStreamReaderTest1 {

    public static void main(String[] args) {
        try (
            // 1. get the original bytes stream of the file (with GBK character set)
            InputStream is = new FileInputStream("...");
            // 2. transfer the bytes stream to character stream according to the original character set
            Reader isr = new InputStreamReader(is, "GBK");
            // 3. put the character stream into the wrapper stream
            BufferedReader br = new BufferedReader(isr);
        ) {
            //....
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
