package com.company;

import java.util.ArrayList;
import java.util.Objects;

public class SbornikCitat implements GetSet {
    private ArrayList<Integer> paragraphСount;
    private String name;
    private int intrParphCount;

    SbornikCitat() {
    }

    SbornikCitat(ArrayList<Integer> paragraphСount, String name, int intrParphCount) {
        this.paragraphСount = paragraphСount;
        this.name = name;
        this.intrParphCount = intrParphCount;
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

    public ArrayList<Integer> getParagraphСount() {return paragraphСount;}

    public void setParagraphСount (ArrayList<Integer> paragraphСount) {
        if (paragraphСount == null) {
        throw new ParagraphCountIsNullRuntimeException("Citata paragraphCount is null");
        }
        this.paragraphСount = paragraphСount;
    }
    public int paragraphCountWithoutIntr(int index)
    {
        int result =  paragraphСount.get(index) - intrParphCount;
        return result;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SbornikCitat that = (SbornikCitat) o;
        return intrParphCount == that.intrParphCount && Objects.equals(paragraphСount, that.paragraphСount) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paragraphСount, name, intrParphCount);
    }

    @Override
    public String toString() {
        return "SbornikCitat{" +
                "paragraphСount=" + paragraphСount +
                ", name='" + name + '\'' +
                ", intrParphCount=" + intrParphCount +
                '}';
    }
}