package com.adpter.class_adapter;

public class Client {
    public static void main(String[] args) {
        // computer can only read or write from sd card
        Computer computer = new Computer();
        String msg = computer.readSD(new SDCardImpl());
        System.out.println(msg);

        System.out.println("===============");

        // but i have a tf card and also want the computer to read tf card ==> we need a adapter to enable computer to read tf card
        // computer actually read adapter
        String msg1 = computer.readSD(new SDAdapterTF());
        System.out.println(msg1);
    }
}
