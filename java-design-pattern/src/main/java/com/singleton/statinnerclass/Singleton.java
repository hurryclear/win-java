package com.singleton.statinnerclass;

/**
 * - when JVM load the outer class, it will not load the inner class, only when the attributes/methods of the inner class get invoked, then the inner class will be loaded
 * - when you load the class Singleton it will not initiate INSTANCE, only when you invoke `getInstance()` method of class SingletonHolder ...
 * - thread safe ==> no need of any lock ==> good Singleton design
 */
public class Singleton {

    private Singleton(){}

    // static inner class
    private static class SingletonHolder {
        // INSTANCE is a constant because of final
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
    
}
