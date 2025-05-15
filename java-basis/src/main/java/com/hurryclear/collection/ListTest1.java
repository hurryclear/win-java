package com.hurryclear.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * what's features of List (interface)
 * - ordered
 * - repeatable
 * - indexed
 * - list is an interface, to use it you need the implementing class of this interface
 *
 */
public class ListTest1 {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();

        names.add("j");
        names.add("l");
        names.add("ll");
        names.add("ee");

        System.out.println(names);
        System.out.println("====");

        /*
            - common methods in List interface
         */
        names.add(1, "ooo");
        System.out.println(names);

        names.remove(3);
        System.out.println(names);

        names.set(0, "xx");
        System.out.println(names);

        System.out.println(names.get(3));

        /*
            - traversal
         */

        // 1. for --> .fori
        System.out.println("==== for ====");
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            System.out.println(name);
        }

        // 2. iterator -->
        System.out.println("==== iterator ====");
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // 3. for-each --> .for
        System.out.println("==== for-each ====");
        for (String name : names) {
            System.out.println(name);
        }

        // 4. lambda
        // don't understand lambda variant
        System.out.println("==== lambda ====");
        names.forEach(s -> {
            System.out.println(s);
        });

    }

}
