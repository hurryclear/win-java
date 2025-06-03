package com.concurrency.dinningphil;

import java.util.concurrent.locks.ReentrantLock;

class Chopstick extends ReentrantLock {

    private String num;

    public Chopstick(String num) {
        this.num = num;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Chopstick{" + num + '}';
    }
}
