package com.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static cn.hutool.core.thread.ThreadUtil.sleep;


public class ThreadLivenessDeadlock1 {

    private static final Logger log = LoggerFactory.getLogger(ThreadLivenessDeadlock1.class);

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Object A = new Object();
        Object B = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (A) {
                log.debug("Lock A");
                sleep(1000);

                synchronized (B) {
                    log.debug("Lock B");
                    log.debug("executing");
                }
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            synchronized (B) {
                log.debug("Lock B");
                sleep(500);

                synchronized (A) {
                    log.debug("Lock A");
                    log.debug("executing");
                }
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
