package com.concurrency;

import static java.lang.Thread.sleep;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VisibilityProblemTest1 {
    
    private static final Logger log = LoggerFactory.getLogger(VisibilityProblemTest1.class);

    static boolean run = true;

    public static void main(String[] args) throws InterruptedException{
        Thread t = new Thread(() -> {
            while (run) {
                log.debug("running...");
            }
        });
        t.start();

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            log.debug("exception");
        }
        log.debug("stop t");
        run = false;
    }
}