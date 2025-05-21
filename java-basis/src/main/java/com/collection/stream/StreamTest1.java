package com.collection.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest1 {

    public static void main(String[] args) {

        List<String> list1 = new ArrayList<>();
        Collections.addAll(list1, "Jiang", "Lin", "Ian", "Zhao", "Jin", "Ja");
        System.out.println(list1);

        List<String> list2 = new ArrayList<>();
        // with traditional method
        for (String name : list1) {
           if (name.startsWith("J") && name.length() >= 3) {
               list2.add(name);
           }
        }
        System.out.println(list2);

        // with stream
        List<String> list3 = new ArrayList<>();
        Collections.addAll(list3, "Jiang", "Lin", "Ian", "Zhao", "Jin", "Ja");
        List<String> newList3 = list3.stream()
                .filter(s -> s.startsWith("J") && s.length() >= 3)
                .collect(Collectors.toList());
        System.out.println(newList3);

    }
}
