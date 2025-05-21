package com.collection.collection;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class CollectionTest1 {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // Array, ArrayList, LinkedList
        String[] stringArray = new String[] {"hello", "world", "!"};
        ArrayList<String> stringArrayList = new ArrayList<String>();
        LinkedList<String> stringLinkedList = new LinkedList<String>();
        // add elements
        stringArrayList.add("hello");
        stringArrayList.add("world");
        stringArrayList.add("!");

        stringLinkedList.add("hello");
        stringLinkedList.add("world");
        stringLinkedList.add("!");

        // update/change: set (index, element)
        stringArray[0] = "goodbye";
        stringArrayList.set(0, "goodbye");
        stringLinkedList.set(0, "goodbye");

        // remove/delete: remove(index)
        for (int i = 0; i < stringArray.length - 1; i++) {
            stringArray[i] = stringArray[i+1];
        }
        stringArrayList.remove(0);
        stringLinkedList.remove(0);

        // traversal
        for (int i = 0; i < stringArray.length - 1; i++) {
            System.out.print(stringArray[i]);
        }
        for (String s : stringArrayList) {
            System.out.print(s);
        }
        for (String s : stringLinkedList) {
            System.out.print(s);
        }

        // Vector and Stack

        // Queue
        
        ArrayDeque<String> stringArrayDeque = new ArrayDeque<>();
        PriorityQueue<String> stringPriorityQueue = new PriorityQueue<>();

        // add elements in queue
        stringArrayDeque.add("hello");
        stringArrayDeque.add("world");
        stringArrayDeque.add("!");

        stringPriorityQueue.offer("hello");
        stringPriorityQueue.offer("wolrd");
        stringPriorityQueue.offer("!");

//        System.out.println(stringArrayDeque);
//        System.out.println(stringPriorityQueue);
        // delete elements in queue
        stringArrayDeque.remove("!"); // ArrayDeque is based on array, it's function similar to array
        stringPriorityQueue.poll();
        // update/change elements in queue

        LinkedHashSet<String> set = new LinkedHashSet<>();

        // 添加元素
        set.add("沉默");
        set.add("王二");
        set.add("陈清扬");

        // 删除元素
        set.remove("王二");

        // 修改元素
        set.remove("沉默");
        set.add("沉默的力量");

        // 查找元素
        boolean hasChenQingYang = set.contains("陈清扬");
        System.out.println("set包含陈清扬吗？" + hasChenQingYang);

    }
}
