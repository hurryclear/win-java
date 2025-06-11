package com.factorymethod;

/**
 * Only used for creating latte coffee
 */
public class LatteCoffeeFactory implements CoffeeFactory {

    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }
    
}
