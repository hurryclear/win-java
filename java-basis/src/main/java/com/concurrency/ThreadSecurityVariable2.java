package com.concurrency;

import java.util.ArrayList;

public class ThreadSecurityVariable2 {

    static final int THREAD_NUMBER = 2;
    static final int LOOP_NUMBER = 200;
    public static void main(String[] args) {
        SubThreadSafe2 subThreadSafe2 = new SubThreadSafe2();
        for (int i = 0; i < THREAD_NUMBER; i++) {
            new Thread(() -> {
                subThreadSafe2.method1(LOOP_NUMBER);
            }, "Thread" + (i+1)).start();
        }

    }
}

class ThreadSafe2 {

    public void method1(int loopNum) { // for thread security: add final
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < loopNum; i++) {
            method2(list);
            method3(list);
        }

    }

    public void method2(ArrayList<String> list) { // for thread security: private
        list.add("1");

    }
    public void method3(ArrayList<String> list) { // for thread security: private
        list.remove(0);
    }
}

// method3 is changed in child class of ThreadSafe2, which cause the thread security problem
class SubThreadSafe2 extends ThreadSafe2 {
    public void method3(ArrayList<String> list) {
        new Thread(() -> {
            list.remove(0);
        }).start();
    }

}
