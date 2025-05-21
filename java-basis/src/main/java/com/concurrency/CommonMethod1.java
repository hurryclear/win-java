package com.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
    start and run
 */
public class CommonMethod1 {


    private static final Logger log = LoggerFactory.getLogger(CommonMethod1.class);

    public static void main(String[] args) {


        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                log.info("This is from thread: {}", Thread.currentThread().getName());
            }
        };
        t1.run(); // 14:51:00.332 [main] INFO  com.concurrency.CommonMethod1 - This is from thread: main
        t1.start(); // 14:51:24.571 [t1] INFO  com.concurrency.CommonMethod1 - This is from thread: t1
        System.out.println(t1.getState());

    }

}
