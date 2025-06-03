package com.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class ReentrantLockTryLock {

    private static final Logger log = LoggerFactory.getLogger(ReentrantLockTryLock.class);

    private static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            log.debug("try to get the lock");
            try {
                // t1 try to get the lock (tryLock())
                // t1 can't get the lock at the beginning, because the lock is occupied by main
                // thread. But t1 will not immediately say "fails", it will wait for 2s. What
                // does t1 during the 2s? try to get the lock again? how often it trys?
                // t1 waits up to 2s and try to get the lock again and now t1 can acquire the
                // lock because main thread released the lock
                if (!reentrantLock.tryLock(2, TimeUnit.SECONDS)) {
                    log.debug("can't get the lock");
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                log.debug("can't get the lock");
                return;
            }
            try {
                log.debug("get the lock");
            } finally {
                reentrantLock.unlock();
            }
        }, "t1");

        // 1. main thread gets the lock
        reentrantLock.lock();
        log.debug("get the lock");

        t1.start();

        // main thread sleep for 1s, during the sleep time the lock is still occupied by main thread
        // after 1s main thread will release the lock
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("release the lock");
        reentrantLock.unlock(); // main thread release the lock
    }
}
