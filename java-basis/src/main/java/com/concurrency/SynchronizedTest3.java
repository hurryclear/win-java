package com.concurrency;

import com.collection.map.TreeMapTest1;

// synchronized with oop principle
public class SynchronizedTest3 {

    public static void main(String[] args) throws InterruptedException {

        Room room = new Room();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                room.incre();
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                room.decre();
            }
        }, "t2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(room.getCounter());

    }

    static class Room {
        private int counter = 0;

        public void incre() {
            synchronized (this) {
                counter++;
            }
        }
//        public synchronized void incre() {
//            counter++;
//        }

        public void decre() {
            synchronized (this) {
                counter--;
            }
        }

//        public synchronized void decre() {
//            counter--;
//        }

        public int getCounter() {
            synchronized (this) {
                return counter;
            }
        }
    }
}
