package com.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static cn.hutool.core.thread.ThreadUtil.sleep;

public class WaitAndNotifyCigaretteStep5 {

    static final Object room = new Object();
    static boolean hasCigarette = false;
    static boolean hasTakeout = false;
    private static final Logger log = LoggerFactory.getLogger(WaitAndNotifyCigaretteStep5.class);

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            synchronized (room) {
                log.debug("do you have cigarette? [{}]", hasCigarette);
                while (!hasCigarette) { // using while instead of if
                    log.debug("no cigarette, then rest");
                    try {
                        room.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                log.debug("do you have cigarette? [{}]", hasCigarette);
                if (hasCigarette) {
                    log.debug("ok, let's work");
                }
            }
        }, "t1").start();

        new Thread(() -> {
            synchronized (room) {
                log.debug("do you have takeout? [{}]", hasTakeout);
                while (!hasTakeout) { // using while instead of if
                    log.debug("no takeout, then rest");
                    try {
                        room.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                log.debug("do you have takeout? [{}]", hasTakeout);
                if (hasTakeout) {
                    log.debug("ok, let's work");
                }
            }
        }, "t2").start();

        sleep(1000);
        new Thread(() -> {
            synchronized (room) {
                hasTakeout = true;
                log.debug("takeout delivered");
                room.notifyAll(); // after you wake up all threads in WAITING, t1 wants to have
                // cigarette and t2 wants to have takeout, but only t2 can get takeout since main
                // thread only takes care of the takeout, so t1 wasted its after being waked up.
                // We can ask t1 to enter into the WAITING again!
            }
        }, "delivery").start();
    }
}
