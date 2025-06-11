package com.abstractfactory;

public class AmericanStyleFactory implements AbstractFactory{

    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }
    @Override
    public Dessert createDessert() {
        return new Tiramisu();
    }
    
}
