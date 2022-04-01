package com.company;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class UnmodifiableGetSet implements GetSet{
    private GetSet collection;

    UnmodifiableGetSet(GetSet collection) throws UnsupportedOperationException {
        this.collection = collection;
    }

    @Override
    public Iterator<String> iterator() {
        return collection.iterator();
    }

    @Override
    public String getName() {
        return collection.getName();
    }

    @Override
    public int getIntrParphCount() {
        return collection.getIntrParphCount();
    }

    @Override
    public int getParagraphСount(){
        return  collection.getParagraphСount();
    }

    @Override
    public List<String> getAuthor() {
        return Collections.unmodifiableList(collection.getAuthor());
    }

    @Override
    public int paragraphCountWithoutIntr (int index) {
        return collection.paragraphCountWithoutIntr(index);
    }


}
