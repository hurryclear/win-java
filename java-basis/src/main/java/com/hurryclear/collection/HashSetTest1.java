package com.hurryclear.collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest1 {

    public static void main(String[] args) {

        Set<Movie> movies1 = new HashSet<>();

        movies1.add(new Movie("a", 1, "j"));
        movies1.add(new Movie("b", 2, "k"));
        movies1.add(new Movie("b", 2, "k"));
        movies1.add(new Movie("c", 3, "a"));

        /*
            there are two same movies in the set "movies1", will both of them be stored in the set?
            both will be stored because they are two different objects with different address
            why?
         */

        System.out.println(movies1);

        /*
            what if we want the set collection to know that if two objects have same content, then we consider it as duplication?
            ==> override hashCode() and equals() in the object class
         */

        Set<Movie> movies2 = new HashSet<>();

        movies2.add(new Movie("a", 1, "j"));
        movies2.add(new Movie("b", 2, "k"));
        movies2.add(new Movie("b", 2, "k"));
        movies2.add(new Movie("c", 3, "l"));

        System.out.println(movies2);
    }
}
