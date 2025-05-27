package com.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SleepAndNotifyTest1 {

    static final Object lock = new Object();

    private static final Logger log = LoggerFactory.getLogger(ThreadSecuritySellTicket.class);
    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            synchronized (lock) {
                log.debug("get the lock");
                try {
//                    Thread.sleep(10000);
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "t1").start();

        Thread.sleep(1000);
        synchronized (lock) {
            log.debug("get the lock");
        }
    }
}
