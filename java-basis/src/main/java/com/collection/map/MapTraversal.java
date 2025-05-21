package com.collection.map;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTraversal {

    public static void main(String[] args) {

        Map<String, Double> map = new HashMap<>();
        map.put("jiang", 165.8);
        map.put("lin", 163.4);
        map.put("kk", 176.4);
        map.put("ii", 173.1);

        System.out.println(map);

        // Method 1: find value with key
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key + ": " + map.get(key));
        }

        // Method 2: key-value
        Set<Map.Entry<String, Double>> entries = map.entrySet();
        for (Map.Entry<String, Double> entry : entries) {

            String key = entry.getKey();
            Double value = entry.getValue();
            System.out.println(key + ": " + value);

        }

        // Method 3: lambda
        map.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });

    }
}
