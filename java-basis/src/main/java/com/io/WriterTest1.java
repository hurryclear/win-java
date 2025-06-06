package com.io;

import java.io.FileWriter;
import java.io.Writer;

public class WriterTest1 {

    public static void main(String[] args) throws Exception {
        
        try (
            // override every time
            Writer w1 = new FileWriter("java-basis/src/main/resources/Writer/test2.txt");

            // append the new writing
            Writer w2 = new FileWriter("java-basis/src/main/resources/Writer/test3.txt", true)
        ) {
            // write character
            w1.write('j');
            w1.write(97);
            // write string
            w1.write("jiang");
            w1.write("\r\n");
            w1.write("huo", 0, 2);
            // write char[]
            char[] ch = { 'a', 'b', 'c' };
            w2.write(ch);

        } catch (Exception e) {
            e.printStackTrace();
        }
        

    }
    
}
