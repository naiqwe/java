package com.company;

public class ThreadWriteSync implements Runnable {
    private GetSetSync sync;


    public ThreadWriteSync(GetSetSync s) {
        sync = s;
    }

   

    @Override
    public void run() {
        try {
            sync.write();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}