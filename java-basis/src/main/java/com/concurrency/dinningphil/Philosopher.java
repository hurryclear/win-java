package com.concurrency.dinningphil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Philosopher extends Thread {

    private static final Logger log = LoggerFactory.getLogger(Philosopher.class);

    private Chopstick left;
    private Chopstick right;

    public Philosopher(String name, Chopstick left, Chopstick right) {
        super(name);
        this.left = left;
        this.right = right;
    }

    public void run() {
        while (true) {
            if (left.tryLock()) {
                try {
                    if (right.tryLock()) {
                        try {
                            eat();
                        } finally {
                            right.unlock();
                        }
                    }
                } finally {
                    left.unlock(); // if philosopher can only get left chopstick and can't get
                    // the right one, it will "put down" the left one as well for other
                    // philosopher to use, so it makes sure that not every philosopher is waiting
                    // for others to "put down" their right chopstick and no one put down and
                    // enter into the deadlock
                }
            }
            // deadlock
//            synchronized (left) {
//                synchronized (right) {
//                    eat();
//                }
//            }
        }
    }

    private void eat() {
        log.debug("eating...");
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
