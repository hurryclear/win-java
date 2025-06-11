package com.simplefactory;

public abstract class Coffee {

    public abstract String getName();

    public void addMilk() {
        System.out.println("add milk");
        // throw new UnsupportedOperationException("Unimplemented method 'addMilk'");
    }

    public void addSugar() {
        System.out.println("add sugar");
        // throw new UnsupportedOperationException("Unimplemented method 'addSugar'");
    }
    
}
