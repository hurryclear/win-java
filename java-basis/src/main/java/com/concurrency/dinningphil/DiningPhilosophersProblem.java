package com.concurrency.dinningphil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DiningPhilosophersProblem {

    private static final Logger log = LoggerFactory.getLogger(DiningPhilosophersProblem.class);

    public static void main(String[] args) {

        Chopstick c1 = new Chopstick("1");
        Chopstick c2 = new Chopstick("2");
        Chopstick c3 = new Chopstick("3");
        Chopstick c4 = new Chopstick("4");
        Chopstick c5 = new Chopstick("5");

        new Philosopher("p1", c1, c2).start();
        new Philosopher("p2", c2, c3).start();
        new Philosopher("p3", c3, c4).start();
        new Philosopher("p4", c4, c5).start();
        new Philosopher("p5", c5, c1).start();
    }


}

