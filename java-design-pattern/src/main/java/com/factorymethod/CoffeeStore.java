package com.factorymethod;

public class CoffeeStore {
    
    private CoffeeFactory coffeeFactory;

    public void setFactory(CoffeeFactory coffeeFactory) {
        this.coffeeFactory = coffeeFactory;
    }

    public Coffee orderCoffee() {

        Coffee coffee = null;

        // create coffee through factory (AmericanCoffeeFactory/LatteCoffeeFactory)
        coffee = coffeeFactory.createCoffee();
        // add
        coffee.addMilk();
        coffee.addSugar();

        return coffee;
    }
}
