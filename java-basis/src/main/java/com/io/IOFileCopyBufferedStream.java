package com.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class IOFileCopyBufferedStream {

    public static void main(String[] args) throws Exception {

        // try (

        //     // only allow the resource objects
        //     // all resource objects implement AutoCloseable interface and have close() method
        //     InputStream is = new FileInputStream("java-basis/src/main/resources/InputStream/test3.txt");
        //     OutputStream os = new FileOutputStream("java-basis/src/main/resources/OutputStream/test6.txt");

        //     // you can also define how big the buffer is, by default is 8192 bytes = 8 kB
        //     // InputStream bis = new BufferedInputStream(is, 8192 * 2)
        //     InputStream bis = new BufferedInputStream(is);
        //     OutputStream bos = new BufferedOutputStream(os);

        // ) {
            
        //     byte[] buffer = new byte[1024];
        //     int len;
        //     while ((len = bis.read(buffer)) != -1) {
        //         bos.write(buffer, 0, len);
        //     }

        // } catch (Exception e) {
        //     e.printStackTrace();
        // }         

        try (

            // Polymorphism
            Reader r = new FileReader("java-basis/src/main/resources/BufferedStream/test1.txt");
            Writer w = new FileWriter("java-basis/src/main/resources/BufferedStream/test2.txt");

            // we can't write Reader br = new BufferedReader(r) because we want to use the method from BufferedReader and not in Reader ==> readLine()
            BufferedReader br = new BufferedReader(r);
            // don't use Writer bw = new BufferedWriter(w) because we need to use newLine() which is method only in BufferedWriter()
            BufferedWriter bw = new BufferedWriter(w);

        ) {
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line + "\r\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
