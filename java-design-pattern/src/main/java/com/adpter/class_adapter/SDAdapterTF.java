package com.adpter.class_adapter;

public class SDAdapterTF extends TFCardImpl implements SDCard{
    
    public String readSD() {
        System.out.println("adapter read tf card");
        return readTF();
    }

    public void writeSD(String data) {
        System.out.println("adapter write tf card");
        writeTF(data);
    }
}
