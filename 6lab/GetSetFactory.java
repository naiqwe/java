package com.company;

import java.util.List;

public interface GetSetFactory {
    public GetSet createInstance();

    public GetSet createInstance(int paragraphСount, String name, int intrParphCount, List<String> author) throws Exception;
}
