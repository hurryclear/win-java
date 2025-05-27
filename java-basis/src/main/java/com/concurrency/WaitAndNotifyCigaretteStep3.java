package com.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static cn.hutool.core.thread.ThreadUtil.sleep;

public class WaitAndNotifyCigaretteStep3 {

    static final Object room = new Object();
    static boolean hasCigarette = false;
    static boolean hasTakeout = false;
    private static final Logger log = LoggerFactory.getLogger(WaitAndNotifyCigaretteStep3.class);

    public static void main(String[] args) throws InterruptedException {

        // which thread will get the "room"(lock object) first? t1, right?
        // let's see the process with 1., 2., 3., ...
        new Thread(() -> {
            // 1. t1 get the room
            synchronized (room) {
                // 2. t1 want to get to work, but before that t1 need a cigarette, so t1 check
                // cigarette first
                log.debug("do you have cigarette? [{}]", hasCigarette);
                // 3. if no cigarette, t1 gets the rest first (wait)
                // * important here: when t1 is waiting, the room (lock object) will be released
                // to other threads, t1 will go to waiting room and enter into the state "WAITING"
                if (!hasCigarette) {
                    log.debug("no cigarette, then rest");
                    try {
                        room.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                // 6. t1 wakes up and check cigarette, since cigarette has been delivered, t1
                // begins to work
                log.debug("do you have cigarette? [{}]", hasCigarette);
                if (hasCigarette) {
                    log.debug("ok, let's work");
                } // until this code block is finished, the other threads won't get the lock
                // object and won't be able to enter into the room
            }
        }, "t1").start();

        // 4. during t1 is waiting for cigarette, the room is open for other threads to use, so
        // these threads enter into the room
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                synchronized (room) {
                    log.debug("let's work");
                }
            }, "others").start();
        }

        // 5. the main thread wants to deliver cigarette but the room is occupied by others
        // after others release the room, main thread gets the room and can deliver the cigarette
        // to t1
        sleep(1000);
        new Thread(() -> {
            synchronized (room) {
                hasCigarette = true;
                log.debug("cigarette delivered");
                room.notify();
            }
        }, "delivery").start();
    }
}
