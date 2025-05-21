package com.collection.map;

import com.collection.cardplay.Card;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/*
    the most important thing in TreeMap is that you have to consider how to compare
 */
public class TreeMapTest1 {

    public static void main(String[] args) {

        // Method 1:

        Map<Card, Integer> map1 = new TreeMap<>();

        map1.put(new Card("1", "red", 1), 1);
        map1.put(new Card("2", "black", 2), 2);
        map1.put(new Card("3", "blue", 3), 3);
        map1.put(new Card("4", "yellow", 4), 4);

        System.out.println(map1);

        Map<Card, Integer> map2 = new TreeMap<>(new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return Integer.compare(o2.getSize(), o1.getSize());
            }
        });

        map2.put(new Card("1", "red", 1), 1);
        map2.put(new Card("2", "black", 2), 2);
        map2.put(new Card("3", "blue", 3), 3);
        map2.put(new Card("4", "yellow", 4), 4);

        System.out.println(map2);

    }
}
