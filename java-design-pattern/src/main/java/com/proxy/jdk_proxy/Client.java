package com.proxy.jdk_proxy;

public class Client {
    public static void main(String[] args) {
        // get proxy object
        // 1. create proxy factory object
        ProxyFactory proxyFactory = new ProxyFactory();
        // 2. get proxy object through factory object method
        SellTickets proxyObject = proxyFactory.getProxyObject();
        // 3. invoke sell() method of proxy object
        // 本质是什么? public Object invoke() in InvocationHandler
        proxyObject.sell();
    }
}
