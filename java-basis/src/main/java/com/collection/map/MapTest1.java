package com.collection.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapTest1 {

    public static void main(String[] args) {

        /*
            1. HashMap: unordered, unrepeatable, not indexed
         */
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("aaa", 100);
        hashMap.put("bbb", 111);
        hashMap.put("ccc", 211);
        hashMap.put("bbb", 222); // if there is a second same key, then the value of the first key
        // will be covered by the second value

        System.out.println("HashMap: " + hashMap);

        /*
            2. LinkedHashMap: ordered, unrepeatable, not indexed
         */
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, "aa");
        linkedHashMap.put(3, "cc");
        linkedHashMap.put(2, "cc");

        System.out.println("LinkedHashMap: " + linkedHashMap);

        /*
            3. TreeMap: ordered according to the key size, unrepeatable, not indexed
         */
        Map<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(1, 2);
        treeMap.put(2, 3);
        treeMap.put(5, 3);
        treeMap.put(4, 1);

        System.out.println("TreeMap: " + treeMap);
    }
}
