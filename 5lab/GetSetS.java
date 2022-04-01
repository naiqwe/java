package com.company;

import com.company.GetSet;

public class GetSetS implements GetSet {

    private int[] array;

    public GetSetS() {
        array = new int[10];
    }

    public int[] getArray() {
        return array;
    }
}
