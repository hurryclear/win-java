package com.concurrency;

import org.openjdk.jol.info.ClassLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BiasedLockTest1 {

    private static final Logger log = LoggerFactory.getLogger(ThreadSecuritySellTicket.class);
    public static void main(String[] args) throws InterruptedException {

        Dog dog = new Dog();
        log.info(ClassLayout.parseInstance(dog).toPrintable());

        Thread.sleep(7000);
        log.info(ClassLayout.parseInstance(new Dog()).toPrintable());


    }
}

class Dog {

}
