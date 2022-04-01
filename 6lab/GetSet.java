package com.company;
import java.io.OutputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public interface GetSet extends Iterable<String> {
    String getName();

    int getIntrParphCount();

    int getParagraphСount();

    List<String> getAuthor();

    int paragraphCountWithoutIntr(int index);
}





















/*
    void setName(String name);
    void setIntrParphCount(int intrParphCount) throws WrongParException;
    void setParagraphСount(int paragraphСount);
    void setAuthor(List<String> author);
*/
