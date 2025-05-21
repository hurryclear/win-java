package com.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import static java.lang.Math.random;

/*
    - Exercise: sell ticket
    - To understand which part is critical section and if it is thread safe or not
    - Analyse the thread safety
    - reference: https://www.bilibili.com/video/BV16J411h7Rd?spm_id_from=333.788.videopod.episodes&vd_source=5700f6f960dc64a5c17cbedf10fb3a37&p=73

 */
public class ThreadSecuritySellTicket {

    private static final int PEOPLE_NUM = 3000;
    private static final Logger log = LoggerFactory.getLogger(ThreadSecuritySellTicket.class);

    public static void main(String[] args) {

        // simulate many people buy ticket (Threads)
        TicketWindow ticketWindow = new TicketWindow(1000);

        // to store amount of ticket each time
        List<Integer> amountList = new Vector<>();

        // to store threads for latter using
        List<Thread> threadList = new ArrayList<>(); // will only be used by main thread so no
        // need to use thread safe collection

        for (int i = 0; i < PEOPLE_NUM; i++) {
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                int amount = ticketWindow.sell(random(5));
                amountList.add(amount);
            });
            threadList.add(thread);
            thread.start();
        }

        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        log.info("There are {} tickets left", ticketWindow.getCount());
        log.info("{} tickets were sold out", amountList.stream().mapToInt(i -> i).sum()); // ?

    }

    // get a random number (1-5)
    static Random random = new Random();

    public static int random(int amount) {
        return random.nextInt(amount) + 1;
    }
}

class TicketWindow {
    private int count = 0; // member variable will be shared in multi-threads

    public TicketWindow (int count) {
        this.count = count;
    }

    // get count
    public int getCount () {
        return count;
    }

    // sell
    public synchronized int sell (int amount) {
        if (count >= amount) {
            count -= amount;
            return amount;
        } else {
            return 0;
        }
    }
}
