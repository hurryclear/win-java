package com.hurryclear.map;

import com.hurryclear.cardplay.Card;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest1 {

    public static void main(String[] args) {

        Map<Card, Integer> map = new HashMap<>();
        map.put(new Card("1", "red", 1), 1);
        map.put(new Card("1", "red", 1), 1);
        map.put(new Card("2", "black", 2), 2);

        System.out.println(map);
        /*
            - before override hashCode and equals
            ==> {red1=1, red1=1, black2=2}
            - after
            ==> {red1=1, black2=2}
         */
    }

}
