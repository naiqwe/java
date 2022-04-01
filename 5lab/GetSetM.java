package com.company;

public class GetSetM {

        public static GetSet SynchronizedGetSet(GetSet collection) {
            return new SynchronizedGetSet(collection);

    }
}
