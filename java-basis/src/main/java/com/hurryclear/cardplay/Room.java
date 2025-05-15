package com.hurryclear.cardplay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
    - play room is also a class
    - and in the play room must be one cardSet (a list of cards)
    -
 */
public class Room {

    // one cardSet
    private List<Card> allCards = new ArrayList<>();

    // constructor (no argus)
    // we always want to have one set of cards when we create a room instance, how to do it?
    // we can write the do it within the constructor
    public Room() {

        // 1. 54 cards in cardList
        // a. numbers
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        // b. color
        String[] colors = {"♠", "♥", "♣", "♦"};
        int size = 0; // indicate the size of the card
        // c. color-number through traversal
        for (String number : numbers) {
            size++;
            for (String color : colors) {
                Card c = new Card (number, color, size);
                allCards.add(c);
            }
        }
        // d. small/big king 🂮,🃎
        Card c0 = new Card("", "🂮", ++size);
        Card c1 = new Card("", "🃎", ++size);
        Collections.addAll(allCards, c0, c1);
        System.out.println("new cards" + allCards); // have to also override the toString method
        // in Card class
    }

    public void start() {

        // 1. init cards ==> "clean" cards
        Collections.shuffle(allCards);
        System.out.println("after cleaning cards" + allCards);

        // 2. each of three players will receive 17 cards and 3 cards will be left
        // instead of creating a new class for player, we consider player as a collection
        List<Card> person1 = new ArrayList<>();
        List<Card> person2 = new ArrayList<>();
        List<Card> person3 = new ArrayList<>();

        // 2.1 how to give three players cards? each one get one card each round
        for (int i = 0; i < allCards.size() - 3; i++) {
            Card c = allCards.get(i);
            if (i % 3 == 0) {
                person1.add(c);
            } else if (i % 3 == 1) {
                person2.add(c);
            } else if (i % 3 == 2) {
                person3.add(c);
            }
        }
        // 2.2 how about the last three cards? put them into one list
        List<Card> lastThreeCards = allCards.subList(allCards.size() -3, allCards.size());

        // 3. let's have a look at player's cards
        System.out.println("person1" + person1);
        System.out.println("person2" + person2);
        System.out.println("person3" + person3);
        System.out.println("last three cards" + lastThreeCards);

        // 4. if person1 want to take the last 3 cards
        person1.addAll(lastThreeCards);
        System.out.println("person1 after taking last three" + person1);

        // 5. after players receiving cards they need to sort all cards
        // let's write a sort method for that
        sortCards(person1);
        sortCards(person2);
        sortCards(person3);

        // 6. check players' cards again
        System.out.println("person1" + person1);
        System.out.println("person2" + person2);
        System.out.println("person3" + person3);
    }

    private void sortCards(List<Card> cards) {

        /*
            How to compare two instance of one class (for example: two cards)?
            - Comparator<>
         */
        Collections.sort(cards, new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return o1.getSize() - o2.getSize();
            }
        });
    }
}
