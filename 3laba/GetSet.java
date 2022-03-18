package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public interface GetSet {
    String getName();
    void setName(String name);

    int getIntrParphCount();
    void setIntrParphCount(int intrParphCount) throws WrongParException;

    ArrayList<Integer> getParagraphСount();
    void setParagraphСount(ArrayList<Integer> paragraphСount);

    int paragraphCountWithoutIntr(int index);
}


