package com.company;

import java.util.List;

public class SbornikCitatFactory implements GetSetFactory{
    @Override
    public GetSet createInstance() {
        return new SbornikCitat();
    }

    @Override
    public GetSet createInstance(int paragraphСount, String name, int intrParphCount, List<String> author) {

        return new SbornikCitat(paragraphСount, name, intrParphCount, author);
    }
}
