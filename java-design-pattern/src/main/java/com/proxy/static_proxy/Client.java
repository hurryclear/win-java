package com.proxy.static_proxy;

public class Client {
    public static void main(String[] args) {
        ProxyPoint proxyPoint = new ProxyPoint();
        // client wants to buy ticket ==> proxy point sells ticket
        proxyPoint.sell();
    }
}
