package com.company;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.Writer;
import java.util.*;

public class SbornikAnekdotov implements GetSet, Serializable {
    private int paragraphСount;
    private List<String> author;
    private String name;
    private int intrParphCount;

    SbornikAnekdotov() {
    }

    SbornikAnekdotov(int paragraphСount, String name, int intrParphCount, List<String> author) {
        this.paragraphСount = paragraphСount;
        this.name = name;
        this.intrParphCount = intrParphCount;
        this.author = author;
    }

    public List<String> getAuthor() {return author;}
    public void setAuthor (List<String> author)
    {
        this.author = author;
    }


    public String getName()          {return name;}
    public void setName(String name) {this.name = name;}

    public int getIntrParphCount() {return intrParphCount;};

    public void setIntrParphCount(int intrParphCount) throws WrongParException {
        if (intrParphCount < 0)
        {
            throw new WrongParException("Incorrect Anekdot intrParghCount");
        }
        this.intrParphCount = intrParphCount;
    }

    public int getParagraphСount() {return paragraphСount;}

    public void setParagraphСount(int paragraphСount)
    {
        this.paragraphСount = paragraphСount;
    }


    public int paragraphCountWithoutIntr(int index)
    {
        int result =  paragraphСount - intrParphCount;
        return result;
    }


    public void output (OutputStream out)
    {

    }

    public void write (Writer out)
    {

    }








    @Override
    public boolean equals(Object obj) {
        return Objects.nonNull(obj) && obj instanceof SbornikAnekdotov && obj.hashCode() == hashCode();
    }



    @Override
    public int hashCode() {
        return Objects.hash(paragraphСount, name, intrParphCount, author);
    }


    @Override
    public String toString() {
        return "SbornikAnekdotov{" +
                "paragraphСount=" + paragraphСount +
                ", author=" + author +
                ", name='" + name + '\'' +
                ", intrParphCount=" + intrParphCount +
                '}';
    }



    @Override
    public Iterator<String> iterator() {
        return new Itr();
    }

private class Itr implements Iterator<String> {
    int cursor;
    int lastRet = -1;

    Itr() {
    }

    @Override
    public boolean hasNext() {
        return cursor != SbornikAnekdotov.this.author.size();
    }

    @Override
    public String next() {
        int i = cursor;
        if (i >= SbornikAnekdotov.this.author.size()) {
            throw new NoSuchElementException();
        }
        cursor = i + 1;
        return SbornikAnekdotov.this.author.get(lastRet = i);
    }

    @Override
    public void remove() {
        if (lastRet < 0) {
            throw new IllegalStateException();
        }
        SbornikAnekdotov.this.author.remove(lastRet);
        cursor = lastRet;
        lastRet = -1;
    }
}
}