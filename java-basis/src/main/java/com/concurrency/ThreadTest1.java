package com.concurrency;



/*
    Create Thread
 */
public class ThreadTest1 {

    public static void main(String[] args) {

        // Method 1: Thread
        Thread t1 = new Thread() {
            @Override
            public void run() {
//                log.debug("running");
                System.out.println("t1: running");
            }
        };

        t1.start();


        // Method 2: Runnable and Thread
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
//                log.debug("t2: running");
                System.out.println("t2: running");
            }

        };
        Thread t2 = new Thread(runnable, "t2");
        t2.start();

        // Method 3: Runnable in Lambda
//        Runnable runnable1 = () -> {log.debug("t3: running");};
        Runnable runnable1 = () -> System.out.println("t3: running");
        Thread t3 = new Thread(runnable1, "t3");
        t3.start();

    }
}
