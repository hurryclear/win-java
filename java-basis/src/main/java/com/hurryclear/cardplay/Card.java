package com.hurryclear.cardplay;

import java.util.Objects;

/*
    - we consider each card is a class
    - what attributes does a card have?
        - number
        - color
        - size
        - (constructor, getter, setter)
 */
public class Card implements Comparable<Card> {

    private String number;
    private String color;

    // size is correspond to the number, in order for card to be compared with each other
    private int size;

    public Card(String number, String color, int size) {
        this.number = number;
        this.color = color;
        this.size = size;
    }

    public Card() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    // why do we need to override "toString" method
    @Override
    public String toString() {
        return color + number; // + "==>" + size;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return size == card.size && Objects.equals(number, card.number) && Objects.equals(color, card.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, color, size);
    }

    @Override
    public int compareTo(Card o) {
        return this.size - o.size;
    }
}
