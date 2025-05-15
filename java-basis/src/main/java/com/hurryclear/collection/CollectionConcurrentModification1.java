package com.hurryclear.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionConcurrentModification1 {

    public static void main(String[] args) {

        List<String> names1 = new ArrayList<>();
        names1.add("jiang");
        names1.add("li");
        names1.add("aa");
        names1.add("hh");
        names1.add("ll");

        /*
            1. for
            1.1 ConcurrentModificationException
            result: [li, aa, hh, ll]
            when index i find the name which contains "i", it will be deleted and then the next
            element will move forward, but the index i will continue to move on to the next, so if
            you have two words next to each other and both contain "i", then the second one will
            not be found out
            ==> this is a bug and no report from program will warn you!!! Have to be careful!
         */
        for (int i = 0; i < names1.size(); i++) {
            String name = names1.get(i);
            if (name.contains("i")) {
                names1.remove(name);
            }
        }
        System.out.println(names1);

        /*
            1.2 solve ConcurrentModificationException method1
         */
        List<String> names2 = new ArrayList<>();
        names2.add("jiang");
        names2.add("li");
        names2.add("aa");
        names2.add("hh");
        names2.add("ll");

        for (int i = 0; i < names2.size(); i++) {
            String name = names2.get(i);
            if (name.contains("i")) {
                names2.remove(name);
                i--;
            }
        }
        System.out.println(names2);

        /*
            1.3 solve ConcurrentModificationException method2
            traverse from behind???
         */

        /*
            2. Iterator
            2.1 ConcurrentModificationException
         */
        List<String> names3 = new ArrayList<>();
        names3.add("jiang");
        names3.add("li");
        names3.add("aa");
        names3.add("hh");
        names3.add("ll");

//        Iterator<String> it = names3.iterator();
//        while (it.hasNext()) {
//
//            String name = it.next();
//
//            if (name.contains("i")) {
//                names3.remove(name);
//            }
//        }
        /*
            2.2 solve ConcurrentModificationException
         */
        List<String> names4 = new ArrayList<>();
        names4.add("jiang");
        names4.add("li");
        names4.add("aa");
        names4.add("hh");
        names4.add("ll");

        Iterator<String> it2 = names4.iterator();
        while (it2.hasNext()) {

            String name = it2.next();
            if (name.contains("i")) {
                it2.remove(); // instead of "remove" method of list using "remove" method of
                // iterator, it will do i-- actually
            }
        }
        System.out.println(names4);


        /*
            3. for-each (won't be able to be solved, because?)
            for-each is the simplified version of iterator and you can't get it2 itself
            ==> result: ConcurrentModificationException and you can't solve it
         */
        List<String> names5 = new ArrayList<>();
        names5.add("jiang");
        names5.add("li");
        names5.add("aa");
        names5.add("hh");
        names5.add("ll");

//        for (String name : names5) {
//
//            if (name.contains("i")) {
//                names5.remove(name);
//            }
//        }
//        System.out.println(names5);

        /*
            4. lambda
            result: ConcurrentModificationException
         */
        List<String> names6 = new ArrayList<>();
        names6.add("jiang");
        names6.add("li");
        names6.add("aa");
        names6.add("hh");
        names6.add("ll");

        names6.forEach(name -> {
            if (name.contains("i")) {
                names6.remove(name);
            }
        });
        System.out.println(names6);
    }
}
