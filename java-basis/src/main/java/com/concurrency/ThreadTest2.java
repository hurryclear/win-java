package com.concurrency;

public class ThreadTest2 {

    // to understand how multi-threads interact with each other

    public static void main(String[] args) {

        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                while(true) {
                    System.out.println("t1: running");
                }
            }
        };
        t1.start();


        new Thread(() -> {
            while(true) {
                System.out.println("t2: running");
            }
        }, "t2").start();
    }

}
