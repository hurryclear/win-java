package com.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadExerciseTea {

    private final static Logger log = LoggerFactory.getLogger(ThreadExerciseTea.class);

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            log.info("t1-1 wash water pot");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("t1-2 heat the water");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            log.info("t2-1 wash tea pot");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("t2-2 wash tea cup");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("t2-3 get tea");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            try {
                t1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
