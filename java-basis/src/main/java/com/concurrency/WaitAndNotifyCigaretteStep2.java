package com.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static cn.hutool.core.thread.ThreadUtil.sleep;

public class WaitAndNotifyCigaretteStep2 {

    static final Object room = new Object();
    static boolean hasCigarette = false;
    static boolean hasTakeout = false;
    private static final Logger log = LoggerFactory.getLogger(ThreadSecuritySellTicket.class);

    public static void main(String[] args) throws InterruptedException {

        // which thread will get the "room"(lock object) first? t1, right?
        // let's see the process with 1., 2., 3., ...
        new Thread(() -> {
            // 1. t1 get the room
            synchronized (room) {
                // 2. t1 want to get to work, but before that t1 need a cigarette, so t1 check
                // cigarette first
                log.debug("do you have cigarette? [{}]", hasCigarette);
                // 3. if no cigarette, t1 gets the rest first (sleep 2s)
                // * important here: when t1 is sleeping, the room is still occupied by t1 and
                // locked, so other threads can't get the lock object
                if (!hasCigarette) {
                    log.debug("no cigarette, then rest");
                    sleep(2000);
                }
                // 4. t1 wakes up and check cigarette, since cigarette has been delivered, t1
                // begins to work
                log.debug("do you have cigarette? [{}]", hasCigarette);
                if (hasCigarette) {
                    log.debug("ok, let's work");
                } // until this code block is finished, the other threads won't get the lock
                // object and won't be able to enter into the room
            }
        }, "t1").start();

        // 6. after t1 finished its job, the lock object will be released and other threads can
        // enter into the room now
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                synchronized (room) {
                    log.debug("let's work");
                }
            }, "others").start();
        }

        // 5. main thread sleep 1s and will deliver the cigarette and now the hasCigarette=true
        sleep(1000);

        // * what if main thread will also be synchronized?
        // the main thread won't be able to deliver the cigarette either, it has to wait until t1
        // release the lock object
        new Thread(() -> {
            synchronized (room) {
                hasCigarette = true;
                log.debug("cigarette delivered");
            }
        }, "delivery").start();
    }
}
