package com.company;

import com.company.GetSet;

public class ThreadRead extends Thread{

    private GetSet collection;

    public ThreadRead(GetSet col) {
        collection = col;
    }

    @Override
    public void run() {
        var arr = collection.getArray();
        for (int i = 0; i < arr.length; ++i) {
            System.out.println("Read: " + arr[i] + " from position " + i);
        }
    }

}
