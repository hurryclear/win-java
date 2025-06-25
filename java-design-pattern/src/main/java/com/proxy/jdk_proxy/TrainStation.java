package com.proxy.jdk_proxy;

// Real subject class
public class TrainStation implements SellTickets{

    @Override
    public void sell() {
        System.out.println("train station sells ticket");
    }
}
