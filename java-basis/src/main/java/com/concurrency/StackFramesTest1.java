package com.concurrency;

/*
    Stack Frames
    - one thread (main thread)
    - every time call method will create a new stack frame
    - after method calling the stack frame will be freed
    - in order to save the stack storage
 */
public class StackFramesTest1 {

    public static void main(String[] args) {

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
