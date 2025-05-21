package com.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SynchronizedTest4 {

    private static final Logger log = LoggerFactory.getLogger(SynchronizedTest4.class);
    public static void main(String[] args) {

        Number n1 = new Number();

        new Thread(() -> {
            log.info("begin");
            n1.a();
        }, "t1").start();

        new Thread(() -> {
            log.info("begin");
            n1.b();
        }, "t2").start();

        new Thread(() -> {
            log.info("begin");
            n1.c();
        }, "t3").start();


    }

    static class Number {

        public synchronized void a() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("1");
        }
        public synchronized void b() {
            log.info("2");
        }
        public void c() {
            log.info("3");
        }
    }
}
