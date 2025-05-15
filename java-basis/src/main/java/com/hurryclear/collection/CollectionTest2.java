package com.hurryclear.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

public class CollectionTest2 {

    public static void main(String[] args) {

        /*
         * Collection Interface
         * - features
         * 1. no order
         * 2. element can be repeated
         * - Basic and important methods
         * 1. public boolean add (E e)
         *    public boolean addAll(Collection<? extends E> c)
         * 2. public void clear ()
         * 3. public boolean remove (E e)
         * 4. public boolean contains(Object obj) // why is the parameter Object not E?
         * 5. public boolean isEmpty()
         * 6. public int size()
         * 7. public Object[] toArray()
         */
        Collection<String> testCollection = new ArrayList<>();

        testCollection.add("muster1");
        testCollection.add("muster2");
        testCollection.add("muster1");

        System.out.println(testCollection);

        System.out.println(testCollection.isEmpty());

        // toArray() : why and when do you use it?
        System.out.println(testCollection.toArray());


        /*
            - Traversal
                1. Iterator
                2. for-each
                  - (String s : c2) {}
                  - shortcut: c2.for enter
                3. Lambda
         */
        Collection<String> c2 = new ArrayList<>();
        c2.add("a");
        c2.add("b");
        c2.add("c");
        c2.add("d");
        System.out.println(c2); // what is the result?


        // 1. Iterator
        // must be aware of the boundary of the collection, if there are only 4 elements in the collection and you print element "null" after the last element, you will get Exception
        System.out.println("===== Traversal: iterator =====");

        Iterator<String> it = c2.iterator();
        while(it.hasNext()) {

            System.out.println(it.next());

        }

        // 2. for-each

        System.out.println("===== Traversal: for-each =====");

        for (String s : c2) {
            System.out.println(s);
        }

        // 3. lambda
        System.out.println("===== Traversal: lambda =====");
        c2.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        // 3.1 simplified
        c2.forEach((String s) -> {
            System.out.println(s);
        });
        // 3.2 simplified
        c2.forEach(s -> System.out.println(s));
        // 3.3. simplified
        c2.forEach(System.out::println);


    }
}
