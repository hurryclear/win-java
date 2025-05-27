package com.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Thread.sleep;

// notify() doesn't work here, don't know why
public class WaitAndNotifyTest1 {


    private static final Logger log = LoggerFactory.getLogger(ThreadSecuritySellTicket.class);

    final static Object obj = new Object();
    public static void main(String[] args) throws InterruptedException {

//        Object obj = new Object();

        new Thread (() -> {
            synchronized (obj) {
                log.info("executing...");
                System.out.println("I am t1");
            }
            try {
                obj.wait ();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            try {
//                sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            log.info("t1 is wake up");
        }, "t1").start();

//        new Thread (() -> {
//            synchronized (obj) {
//                log.info ("executing...");
//            }
//            try {
//                obj.wait ();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
////            try {
////                sleep(2000);
////            } catch (InterruptedException e) {
////                throw new RuntimeException(e);
////            }
//            log.info("t2 is wake up");
//        }, "t2").start();

        Thread.sleep(4000);
        log.info("wake up other threads");
        synchronized (obj) {
//            obj.notify();
            obj.notifyAll();
        }
    }
}
