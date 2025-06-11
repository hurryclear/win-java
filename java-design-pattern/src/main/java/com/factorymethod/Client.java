package com.factorymethod;

public class Client {

    public static void main(String[] args) {
        
        // CoffeeStore instance
        CoffeeStore coffeeStore = new CoffeeStore();

        // coffee store connect with factory
        // if the store needs american coffee, then it needs to ask AmericanCoffeeFactory
        // or LatteCoffeeFactory
        // coffeeStore.setFactory(new AmericanCoffeeFactory());
        coffeeStore.setFactory(new LatteCoffeeFactory());

        // order coffee
        Coffee coffee = coffeeStore.orderCoffee();

        System.out.println(coffee.getName());


    }
    
}
