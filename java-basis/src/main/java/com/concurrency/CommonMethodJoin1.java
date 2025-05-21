package com.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Thread.sleep;

/*
    Join()
 */
public class CommonMethodJoin1 {

    static int r = 0;

    private static final Logger log = LoggerFactory.getLogger(CommonMethodJoin1.class);
    public static void main(String[] args) throws InterruptedException {
        test1();
    }

    private static void test1() throws InterruptedException {

        log.info("start...");

        Thread t1 = new Thread(() -> {
            log.info("start");
            try {
                sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("end");
            r = 10;
        }, "t1");

        t1.start();
        t1.join();
        log.info("result is {}", r);
        log.info("end");


    }
}
