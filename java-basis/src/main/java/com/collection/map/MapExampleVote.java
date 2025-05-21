package com.collection.map;

import java.util.*;

/*
    - count the vote
        - 80 students vote for 4 different places: A, B, C, D
        - emulate voting process with Random
        - store vote result in the ArrayList
        - count vote result with Map<String, Integer>: four keys (A, B, C, D)
        - traverse vote result and store it according to keys
 */
public class MapExampleVote {

    public static void main(String[] args) {

        // 1. emulate voting process and store the result in ArrayList #todo why ArrayList?
        List<String> voteResult = new ArrayList<>();
        String[] places = {"A", "B", "C", "D"};
        Random r = new Random();

        for (int i = 0; i < 80; i++) {
            int index = r.nextInt(4);
            voteResult.add(places[index]);
        }

        System.out.println(voteResult);

        // 2. count number of people for each place
        Map<String, Integer> voteMap = new HashMap<>();

        for (String key : voteResult) {
            if (!voteMap.containsKey(key)) {
                voteMap.put(key, 1);
            } else {
                voteMap.put(key, voteMap.get(key) + 1);
            }
        }

        System.out.println(voteMap);

    }
}
