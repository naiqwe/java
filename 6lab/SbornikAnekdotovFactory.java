package com.company;

import java.util.List;

public class SbornikAnekdotovFactory implements GetSetFactory {
    @Override
    public GetSet createInstance() {
        return new SbornikAnekdotov();
    }

    @Override
    public GetSet createInstance(int paragraphСount, String name, int intrParphCount, List<String> author) {

        return new SbornikAnekdotov(paragraphСount, name, intrParphCount, author);
    }
}
