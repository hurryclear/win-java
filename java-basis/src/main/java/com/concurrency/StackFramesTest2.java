package com.concurrency;

/*
    Stack Frame
    - two threads: main + t2
    - which proves that
        - the stack frames between two threads are separated and independent of each other
 */
public class StackFramesTest2 {
    public static void main(String[] args) {

        Thread t2 = new Thread("t2") {
            @Override
            public void run() {
                method1(20);
            }
        };
        t2.start();

        method1(10);
    }

    private static void method1(int x) {
        int y = x + 1;
        Object m = method2();
        System.out.println(m);
    }

    private static Object method2() {
        Object n = new Object();
        return n;
    }
}
