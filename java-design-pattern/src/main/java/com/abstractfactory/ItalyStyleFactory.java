package com.abstractfactory;

public class ItalyStyleFactory implements AbstractFactory {

    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }
    @Override
    public Dessert createDessert() {
        return new MatchaMousse();
    }
}
