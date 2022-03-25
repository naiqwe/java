package com.company;

import java.io.OutputStream;
import java.io.Serializable;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SbornikCitat implements GetSet, Serializable {
    private int paragraphСount;
    private List<String> author;
    private String name;
    private int intrParphCount;

    SbornikCitat() {
    }

    SbornikCitat(int paragraphСount, String name, int intrParphCount, List<String> author) {
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

    public void setName(String name)  {this.name = name;}

    public int getIntrParphCount() {return intrParphCount;}

    public void setIntrParphCount(int intrParphCount) throws WrongParException  {
        if (intrParphCount < 0) {
            throw new WrongParException("Incorrect Citata intrParghCount");
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
        return Objects.nonNull(obj) && obj instanceof SbornikCitat && obj.hashCode() == hashCode();
    }




    @Override
    public int hashCode() {
        return Objects.hash(paragraphСount, name, intrParphCount, author);
    }


    @Override
    public String toString() {
        return "SbornikCitat{" +
                "paragraphСount=" + paragraphСount +
                ", author=" + author +
                ", name='" + name + '\'' +
                ", intrParphCount=" + intrParphCount +
                '}';
    }




}