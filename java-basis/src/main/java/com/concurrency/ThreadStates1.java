package com.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadStates1 {

    private static final Logger log = LoggerFactory.getLogger(ThreadStates1.class);
    public static void main(String[] args) {

        // state: NEW
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                log.info("t1: NEW");
            }
        };

        // RUNNABLE
        Thread t2 = new Thread("t2") {
            @Override
            public void run() {
                while (true) {
                }
            }
        };
        t2.start();


        // TERMINATED
        Thread t3 = new Thread("t3") {
            @Override
            public void run() {
                log.info("t3 is running");
            }
        };
        t3.start();

        // TIME_WAITING
        Thread t4 = new Thread("t4") {

            @Override
            public void run() {
                synchronized (ThreadStates1.class) { // give t4 a lock
                    try {
                        Thread.sleep(1000000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        t4.start();

        // WAITING
        Thread t5 = new Thread("t5") {
            @Override
            public void run() {
                try {
                    t2.join(); // t5 will wait until t2 terminates, but t2 is in not-terminated
                    // loop
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        t5.start();


        // BLOCKED
        Thread t6 = new Thread("t6") {
            @Override
            public void run() {
                synchronized (ThreadStates1.class) { // t4 and t6 compete for the lock, but
                    // because t4 starts first, so t4 get the lock and t6 also wants to have
                    // lock, so t6 will enter into the "BLOCKED"
                    try {
                        Thread.sleep(1000000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        t6.start();


        // Let main thread sleep for a while so that t3 thread can finishs and goes to TERMINATED
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        log.info("t1: {}", t1.getState());
        log.info("t2: {}", t2.getState());
        log.info("t3: {}", t3.getState());
        log.info("t4: {}", t4.getState());
        log.info("t5: {}", t5.getState());
        log.info("t6: {}", t6.getState());
    }
}
