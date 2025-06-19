package com.collection.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

public class CollectionTraversal {

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


        /**
         * 
         *   - Traversal
         *       1. Iterator
         *       2. for-each
         *           - (String s : c2) {}
         *           - shortcut: c2.for enter
         *       3. Lambda
         */
        Collection<String> strColl = new ArrayList<>();
        strColl.add("a");
        strColl.add("b");
        strColl.add("c");
        strColl.add("d");
        strColl.add("e");
        strColl.add("f");
        System.out.println(strColl); // what is the result?


        // 1. Iterator
        // must be aware of the boundary of the collection, if there are only 4 elements in the collection and you print element "null" after the last element, you will get Exception
        // 1.1 NoSuchElementException
        // 1.2 After loop the pointer will not be reset
        // 1.3 next() can only be used once within loop
        // 1.4 add() and remove() of Collection can't be used together with Iterator ==> instead, use remove() of Iterator
        System.out.println("===== Traversal: iterator =====");

        // it ==> like a pointer
        Iterator<String> it = strColl.iterator();
        // although the name of the method is hasNext(), it actually means that does the current pointer (it) have element?
        // if yes it will enter into the while loop
        while(it.hasNext()) {
            // next(): get the element under the current pointer and move the pointer to the next
            String str = it.next();
            if (str.equals('c')) {
                // 1.4
                it.remove();
                // strColl.remove(str);
            }
            System.out.println(str);
            // Don't use next() in this way
            // System.out.println(it.next());
            // System.out.println(it.next());
        }
        // 1.1 NoSuchElementException
        // System.out.println(it.next());
        System.out.println(strColl);


        // 2. for-each
        System.out.println("===== Traversal: for-each =====");

        for (String s : strColl) {
            s = "a";
            System.out.println(s);
        }
        System.out.println(strColl); // [a, b, c, d, e, f], not [a, a, a, a, a, a]

        // 3. lambda
        // 3.1 forEach()
        // underlying principle: fori, override accept()
        System.out.println("===== Traversal: lambda =====");
        strColl.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        // 3.2 simplified
        // (parameter of method) -> {method body}
        strColl.forEach((String s) -> {
            System.out.println(s);
        });
        // 3.3 simplified
        strColl.forEach(s -> System.out.println(s));
        // 3.4 simplified
        strColl.forEach(System.out::println);
    }
}
