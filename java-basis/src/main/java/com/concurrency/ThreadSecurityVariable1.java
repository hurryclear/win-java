package com.concurrency;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ThreadSecurityVariable1 {

    static final int THREAD_NUMMBER = 2;
    static final int LOOP_NUMMBER = 200;
    public static void main(String[] args) {

        // when i create instance of ThreadUnsafe, list (member variable) will also be created
        // and will be allotted storage in stack and this list will be shared to method2 and
        // method3 as well
        ThreadUnsafe threadUnsafe = new ThreadUnsafe();
        ThreadSafe threadSafe = new ThreadSafe();


        for (int i = 0; i < THREAD_NUMMBER; i++) {
            new Thread(() -> {
//                threadUnsafe.method1(LOOP_NUMMBER);
                threadSafe.smethod1(LOOP_NUMMBER);
            }, "Thread" + (i+1)).start();
        }
    }
}

class ThreadUnsafe {
    ArrayList<String> list = new ArrayList<>(); // list is member variable
    public void method1 (int loopNum) {
        for (int i = 0; i < loopNum; i++) {
            // method2 and method3 will visit the shared data: list (member variable)
            // this will cause the problem
            // --- critical section below: (race condition) ---
            method2();
            method3();
            // --- critical section ---
        }
    }

    private void method2() {
        list.add("1");
    }

    private void method3() {
        list.remove(0);
    }
}

// to solve the thread unsafe problem: we can let list be local variable (not shared data)
class ThreadSafe {
    public final void smethod1 (int loopNumber) {
        // list is now a local variable that is "hidden" within smethod1
        // when thread1 invokes smethod1, it will create a list and thread2 will create another list
        // they will not share the same list
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < loopNumber; i++) {
            smethod2(list);
            smethod3(list);
        }
    }

    private void smethod2(ArrayList<String> list) {
        list.add("1");
    }

    private void smethod3(ArrayList<String> list) {
        list.remove(0);
    }
}
