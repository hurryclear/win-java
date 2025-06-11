package com.singleton.instantiatewhenuse1;

/**
 * in order not to waste the resource
 * so only when you invoke the getInstance() the instance will be created
 */

public class Singleton {

    // make the constructor private so public can't new Singleton
    private Singleton() {}

    // we need a static member variable to store the instance of the class
    private static Singleton instance;

    // provide a public method to allow public to get the instance
    public static Singleton getInstance() {
    // public static synchronized Singleton getInstance() {

        // 1. thread unsafe
        // when there are two threads are executing at the same time
        // they could create two instances
        if (instance == null) {
            instance = new Singleton();
        }

        // 2. thread safe
        // add synchronized lock for the method
        // public static synchronized Singleton getInstance()
        // other parts are same


        return instance;
    }

    
}
