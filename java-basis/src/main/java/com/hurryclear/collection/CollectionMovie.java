package com.hurryclear.collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionMovie {

    public static void main(String[] args) {

        Collection<Movie> movies = new ArrayList<>();

        movies.add(new Movie("aaa", 1, "lin"));
        movies.add(new Movie("bbb", 2, "jiang"));
        movies.add(new Movie("ccc", 3, "huo"));

        System.out.println(movies);

        for (Movie movie : movies) {
            System.out.println("name of the movie: " + movie.getName());
            System.out.println("score of the movie: " + movie.getScore());
            System.out.println("actor of the movie: " + movie.getActor());
            System.out.println("=======");
        }
    }
}
