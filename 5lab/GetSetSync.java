package com.company;

import com.company.GetSet;

public class GetSetSync {

    private GetSet collection;
    private volatile int current = -1;

    private volatile boolean set = false;
    private volatile boolean isEnd;

    public GetSetSync(GetSet col) {
        collection = col;
        isEnd = col.getArray().length == 0;
    }

    public void read() throws InterruptedException {
        while (!isEnd) {
            synchronized (collection) {
                while (!isEnd && !set) {
                    collection.wait();
                }

                if (!isEnd) {
                    var arr = collection.getArray();
                    System.out.println("Read: " + arr[current] + " from position " + current);
                    set = false;
                }

                collection.notifyAll();
            }
        }

        System.out.println("End read");
    }

    public void write() throws InterruptedException {
        while (!isEnd) {
            synchronized (collection) {
                while (!isEnd && set) {
                    collection.wait();
                }

                current++;

                var arr = collection.getArray();
                isEnd = current >= arr.length;

                if (!isEnd) {
                    arr[current] = (int) (Math.random() * 100 + 1);
                    System.out.println("Write: " + arr[current] + " to position " + current);
                    set = true;
                }

                collection.notifyAll();
            }
        }

        System.out.println("End write");
    }
}
