package com.simplefactory;

// Don't let CoffeeStore create the coffee instance, instead of that let factory do it
// 解耦合: CoffeeStore and Coffee

public class CoffeeStore {
    
    public Coffee orderCoffee(String type) {

        Coffee coffee = null;
        // the key step: use factory to help us to create instance of coffee
        SimpleCoffeeFactory simpleCoffeeFactory = new SimpleCoffeeFactory();
        coffee = simpleCoffeeFactory.createCoffee(type);

        // add milk and sugar
        coffee.addMilk();
        coffee.addSugar();

        return coffee;
    }

}
