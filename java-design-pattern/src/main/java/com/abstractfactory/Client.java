package com.abstractfactory;

public class Client {
    public static void main(String[] args) {
        ItalyStyleFactory italyStyleFactory = new ItalyStyleFactory();
        Coffee coffee = italyStyleFactory.createCoffee();
        Dessert dessert = italyStyleFactory.createDessert();

        System.out.println(coffee.getName());
        dessert.show();
    }
}
