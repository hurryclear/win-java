package com.file;

import java.io.File;

public class FileChangeNameOfFiles {

    public static void main(String[] args) {
        
        File dir = new File("java-basis/src/main/resources/test1");
        System.out.println(dir.mkdir());

        // 1. get level one files as objects
        File[] videos = dir.listFiles();
        
        // 2. get the names one by one
        for (File video : videos) {

            // 3. get the name and change to new name
            String name = video.getName();
            String toChange = name.substring(0, name.indexOf(":")); //#TODO substring()
            String lastName = name.substring(name.indexOf(":"));

            String newName = (Integer.valueOf(toChange) + 18) + lastName;

            // 4. change the name
            video.renameTo(new File(dir, newName));
        }
    }
}
