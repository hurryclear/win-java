package com.concurrency;

public class MonitorTets1 {
    static final Object lock = new Object();
    static int counter = 0;

    public static void main (String [] args) {
        synchronized (lock) {
            counter++;
        }
    }
}
