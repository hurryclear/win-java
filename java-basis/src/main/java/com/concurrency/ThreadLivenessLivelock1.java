package com.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Thread.sleep;

public class ThreadLivenessLivelock1 {

    private static final Logger log = LoggerFactory.getLogger(ThreadLivenessLivelock1.class);

    static volatile int count = 10;
    static final Object lock = new Object();

    public static void main(String[] args) {

        new Thread(() -> {
            while (count > 0) {
                try {
                    sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                count--;
                log.debug("count: {}", count);
            }
        }, "t1").start();

        new Thread(() -> {
            while (count < 20) {
                try {
                    sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                count++;
                log.debug("count: {}", count);
            }
        }, "t2").start();
    }
}
