package com.concurrency;

public class WaitAndNotifyTest0 {

    static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        synchronized (lock) {
            lock.wait();
        }
    }
}
