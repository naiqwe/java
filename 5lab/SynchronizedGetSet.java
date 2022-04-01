package com.company;

import com.company.GetSet;

public class SynchronizedGetSet implements GetSet {

    private GetSet collection;

    public SynchronizedGetSet(GetSet col) {
        collection = col;
    }

    @Override
    public synchronized int[] getArray() {
        return collection.getArray();
    }
}
