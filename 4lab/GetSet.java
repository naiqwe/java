package com.company;

import java.io.OutputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public interface GetSet {
    String getName();
    void setName(String name);

    int getIntrParphCount();
    void setIntrParphCount(int intrParphCount) throws WrongParException;

    int getParagraphСount();
    void setParagraphСount(int paragraphСount);


    List<String> getAuthor();
    void setAuthor(List<String> author);

    int paragraphCountWithoutIntr(int index);

    void output (OutputStream out);

    void write (Writer out);

}


