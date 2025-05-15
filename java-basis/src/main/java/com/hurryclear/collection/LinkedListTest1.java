package com.hurryclear.collection;

import java.util.LinkedList;

public class LinkedListTest1 {

    public static void main(String[] args) {

        /*
            - scenario: design a queue (FIFO)
            - in an array enter from right and left from left
         */
        LinkedList<String> queue = new LinkedList<>();

        // in queue
        queue.addLast("1");
        queue.addLast("2");
        queue.addLast("3");
        queue.addLast("4");
        System.out.println(queue);

        // out queue
        System.out.println(queue.removeFirst());
        System.out.println(queue.removeFirst());

        System.out.println(queue);

        /*
            - scenario: design a stack (FILO)
         */
        LinkedList<String> stack = new LinkedList<>();
        // push = addFirst: push is implemented with addFirst
        stack.addFirst("1"); // stack.push("1");
        stack.addFirst("2"); // stack.push("2");
        stack.addFirst("3"); // stack.push("3");
        stack.addFirst("4"); // stack.push("4");
        System.out.println(stack);

        // pop = removeFirst: pop is implemented with removeFirst
        stack.removeFirst(); // stack.pop();
        stack.removeFirst(); // stack.pop();
    }
}
