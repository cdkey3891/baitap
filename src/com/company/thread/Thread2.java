package com.company.thread;

public class Thread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 8; i++) {
            System.out.println("Thread: "+i);
        }
    }
}
