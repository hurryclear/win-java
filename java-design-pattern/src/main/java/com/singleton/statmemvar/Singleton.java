package com.singleton.statmemvar;

/**
 * once you load the class Singleton
 * the instance will be created no matter if you use it or not
 * it can be waste if you don't use it
 */

public class Singleton {
    
    // 1. private constructor without parameter
    private Singleton() {}

    // 2. instantiate this class and put into a static member variable
    // with static so public can visit it with class name "Singleton"
    private static Singleton instance = new Singleton();

    // 3. provide a public access for public to get the instance
    public static Singleton getInstance() {
        return instance;
    }
}
