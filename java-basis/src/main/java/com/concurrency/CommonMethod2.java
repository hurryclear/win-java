package com.concurrency;

import ch.qos.logback.core.joran.conditional.ThenAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/*
    sleep and yield
 */
public class CommonMethod2 {


    private static final Logger log = LoggerFactory.getLogger(CommonMethod2.class);
    public static void main(String[] args) {

//        Thread t1 = new Thread("t1") {
//            @Override
//            public void run() {
//                log.info("t1");
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        };
//
//        t1.start();
//        log.info("t1 state {}", t1.getState()); // t1 state: RUNNABLE ==> thread t1 has not
//        // started and main thread has finished
//
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        log.info("t1 state {}", t1.getState()); // t1 state: TIMED_WAITING ==> we let main thread
//        // to wait for half second, so that thread t1 will start

        Thread t2 = new Thread("t2") {
            @Override
            public void run() {
                log.info("wanna sleep...");
                try {
//                    Thread.sleep(2000);
                    TimeUnit.SECONDS.sleep(1); // same usage but easier to read
                } catch (InterruptedException e) {
                    log.info("oh on, i want to sleep, go away");
                    throw new RuntimeException(e);
                }
            }
        };

        t2.start();

        // let main thread also sleep
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // will wake t1 up, no more sleep
        log.info("wake up please...");
        t2.interrupt();

        Thread t3 = new Thread("t3") {
            @Override
            public void run() {
                Thread.yield();
            }
        };
        t3.start();
        System.out.println(t3.getState()); // RUNNABLE

    }
}
