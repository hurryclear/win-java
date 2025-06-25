package com.proxy.static_proxy;

// Proxy class
public class ProxyPoint implements SellTickets{

    // what's the relationship between TrainStation and ProxyPoint?
    TrainStation trainStation = new TrainStation();
    public void sell(){
        System.out.println("Proxy point charges fee");
        trainStation.sell();
    }
}
