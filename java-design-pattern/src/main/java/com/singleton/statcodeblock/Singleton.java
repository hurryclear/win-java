package com.singleton.statcodeblock;

/**
 * with "static member variable" implementation once you load the class Singleton the instance will be created no matter if you use it or not, it can be waste if you don't use it
 */
public class Singleton {

    private Singleton() {};

    private static Singleton instance;

    // instantiate with static code block
    static {
        instance = new Singleton();
    }

    // with static so this method can be used just with class name "Singleton.getInstance()"
    public static Singleton getInstance() {
        return instance;
    }
    
}
