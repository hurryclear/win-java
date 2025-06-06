package com.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class IOFileCopy {

    public static void main(String[] args) throws Exception {

    //     // release the resource properly: try-catch-finally

    //     InputStream is = null;
    //     OutputStream os = null;

    //     try {
            
    //         is = new FileInputStream("java-basis/src/main/resources/InputStream/test3.txt");

    //         os = new FileOutputStream("java-basis/src/main/resources/OutputStream/test6.txt");

    //         byte[] buffer = new byte[1024];
    //         int len;
    //         while ((len = is.read(buffer)) != -1) {
    //             os.write(buffer, 0, len);
    //         }

    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     } finally {
    //         // release the source from here (close())

    //         try {
    //             if (os != null) os.close();
    //         } catch (IOException e) {
    //             e.printStackTrace();
    //         }

    //         try {
    //             if (is != null) is.close();
    //         } catch (IOException e) {
    //             e.printStackTrace();
    //         }
    //     }



        try (

            // only allow the resource objects
            // all resource objects implement AutoCloseable interface and have close() method
            InputStream is = new FileInputStream("java-basis/src/main/resources/InputStream/test3.txt");
            OutputStream os = new FileOutputStream("java-basis/src/main/resources/OutputStream/test6.txt");
        ) {
            
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }         
    }
    
}
