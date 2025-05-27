package com.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static cn.hutool.core.thread.ThreadUtil.sleep;

public class WaitAndNotifyCigaretteStep4 {

    static final Object room = new Object();
    static boolean hasCigarette = false;
    static boolean hasTakeout = false;
    private static final Logger log = LoggerFactory.getLogger(WaitAndNotifyCigaretteStep4.class);

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            synchronized (room) {
                log.debug("do you have cigarette? [{}]", hasCigarette);
                if (!hasCigarette) {
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
                if (!hasTakeout) {
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
                room.notifyAll(); // notify() can't notify a specific thread, it just notifies
                // the thread randomly, so it's better to use notifyAll() if there are more than
                // one threads are waiting

            }
        }, "delivery").start();
    }
}
