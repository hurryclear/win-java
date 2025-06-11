package com.singleton.doublecheck;

// double check singleton

public class Singleton {

    // 1. private constructor
    private Singleton() {}
    // 2. private static member variable
    // keyword: volatile
    private static volatile Singleton instance;

    // 3. public method for public to get the instance
    public static Singleton getInstance() {

        // Is instance null? if not, then don't need to get the synchronized lock ==> save resource
        if (instance == null) {
            // keyword: synchronized
            synchronized (Singleton.class) { // same with: public static synchronized Singleton getInstance()
                // why check again?
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}