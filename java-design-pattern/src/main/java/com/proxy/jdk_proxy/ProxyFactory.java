package com.proxy.jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    
    // real subject object / target object
    private TrainStation trainStation = new TrainStation();

    // - get proxy object through method
    // - why return SellTickets? not 
    public SellTickets getProxyObject() {

        /**
         * - newProxyInstance(): return a instance of proxy class for the specified interfaces...
         * - @param ClassLoader loader: the class loader to define the proxy class ==> get it through target object
         * - @param Class<?>[] interfaces: the list of interfaces for the proxy class to implement ==> through target object
         * - @param InvocationHandler h: the invocation handler to dispatch method invocations to
         */
        SellTickets proxyObject = (SellTickets)Proxy.newProxyInstance(
            trainStation.getClass().getClassLoader(), 
            trainStation.getClass().getInterfaces(),
            new InvocationHandler() {
                /**
                 * - Object proxy: same object with proxyObject
                 * - Method method: invoked method
                 * - Object[] args: parameter of invoked method
                 * - return: what the invoked method returns
                 */
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    // System.out.println("invoke method executed");
                    System.out.println("proxy point charges service fee (jdk)");
                    Object obj = method.invoke(trainStation, args);
                    return obj;
                }
            }
        );

        return proxyObject;
    }
}
