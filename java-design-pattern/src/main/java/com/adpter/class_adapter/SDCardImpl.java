package com.adpter.class_adapter;

public class SDCardImpl implements SDCard{

    @Override
    public String readSD(){
        return "sd card is read";
    }
    @Override
    public void writeSD(String data) {
        System.out.println(data + "is written in sd card");
    }
}
