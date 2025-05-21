package com.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Thread.sleep;

/*
    Join for multi-threads
 */
public class CommonMethodJoin2 {

    static int r1 = 0;
    static int r2 = 0;
    private static final Logger log = LoggerFactory.getLogger(CommonMethodJoin2.class);

    public static void main(String[] args) throws InterruptedException {

        test2();

    }

    private static void test2() {

        Thread t1 = new Thread(() -> {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            r1 = 10;
        });

        Thread t2 = new Thread(() -> {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            r2 = 20;
        });

        t1.start();
        t2.start();

        long start = System.currentTimeMillis();

        log.info("Start to join");
        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("t1 end join");
        try {
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("t2 end join");
        long end = System.currentTimeMillis();

        log.info("r1: {}, r2: {}, cost: {}", r1, r2, end-start);
        // r1: 10, r2: 20, cost: 2006
        // when t1 starts, t2 starts as well, so the result is not 1+2=3, instead is 2
        // what if t2.join() first and t1.join()? the result is same

    }
}
