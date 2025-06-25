package com.adpter.class_adapter;

public class TFCardImpl implements TFCard{
    @Override
    public String readTF() {
        return "tf card is read";
    }
    @Override
    public void writeTF(String data) {
        System.out.println(data + "is written in tf card");
    }
}
