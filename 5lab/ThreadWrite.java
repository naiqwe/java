package com.company;

public class ThreadWrite extends Thread {

    private GetSet collection;

    public ThreadWrite(GetSet col) {
        collection = col;
    }

    @Override
    public void run() {
        var arr = collection.getArray();
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = (int) (Math.random() * 100 + 1);
            System.out.println("Write: " + arr[i] + " to position " + i);
        }
    }

}
