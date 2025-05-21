package com.concurrency;

// add lock object (synchronized) to solve the race condition

public class SynchronizedTest2 {

    static int counter = 0;
    static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                synchronized (lock) {
                    counter++; // critical section, in this section race condition will happen
                }
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                synchronized (lock) {
                    counter--; // critical section, in this section race condition will happen
                }
            }
        }, "t2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(counter); // you can see that the result is always changing, because
        // of race condition
    }
}
