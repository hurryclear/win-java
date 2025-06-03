package com.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCondition {

    static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {

        // new conditions (waiting rooms)
        Condition c1 = reentrantLock.newCondition();
        Condition c2 = reentrantLock.newCondition();

        // main thread gets the lock
        reentrantLock.lock();

        // main thread enters into the waiting room 1 (condition 1) to rest
        try {
            c1.await(); // wait()
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        c1.signal(); // notify()
        c1.signalAll(); // notifyAll()
    }
}
