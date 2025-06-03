package com.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockReenterable {
    private static final Logger log = LoggerFactory.getLogger(ReentrantLockReenterable.class);

    private static  ReentrantLock reentrantLock = new ReentrantLock();
    public static void main(String[] args) {
        reentrantLock.lock();
        try {
            log.debug("enter main");
            m1();
        } finally {
            reentrantLock.unlock();
        }
    }

    private static void m1() {
        reentrantLock.lock();

        try {
            log.debug("enter m1"); // reenter first
            m2();
        } finally {
            reentrantLock.unlock();
        }
    }

    private static void m2() {
        reentrantLock.lock();
        try {
            log.debug("enter m2"); // reenter second
        } finally {
            reentrantLock.unlock();
        }
    }
}
