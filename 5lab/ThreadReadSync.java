package com.company;


public class ThreadReadSync implements Runnable {
    private GetSetSync sync;

    public ThreadReadSync(GetSetSync s) {
        sync = s;
    }

    @Override
    public void run() {
        try {
            sync.read();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}