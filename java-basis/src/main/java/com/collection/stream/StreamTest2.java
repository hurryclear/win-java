package com.collection.stream;

import java.util.*;
import java.util.stream.Stream;

/*
    How to get Stream?
    - collection
    - map
    - array
 */
public class StreamTest2 {

    public static void main(String[] args) {

        // 1. List
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "Jiang", "Lin", "Ian", "Zhao", "Jin", "Ja");
        System.out.println(list.stream()); // what's the stream if we print it out?

        list.forEach(s -> System.out.println(s));

        // 2. Set
        Set<String> set = new HashSet<>();
        Collections.addAll(set, "Jiang", "Lin", "Ian", "Zhao", "Jin", "Ja");
        set.stream().filter(s -> s.contains("i")).forEach(System.out::println);

        // 3. Map
        Map<String, Integer> map = new HashMap<>();
        map.put("Jiang", 1);
        map.put("Lin", 2);
        map.put("Ian", 3);
        map.put("Zhao", 4);
        map.put("Jin", 5);
        map.put("Ja", 6);

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        entries.stream()
                .filter(e -> e.getKey().contains("i"))
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        // 4. Array
        String[] array = {"Jiang", "Lin", "Ian", "Zhao", "Jin", "Ja"};
        // method 1: Arrays.stream()
        Stream<String> s1 = Arrays.stream(array);

        // method 2: Stream.of()
        Stream<String> s2 = Stream.of(array);

        System.out.println(s1);
        System.out.println(s2);
    }

}
