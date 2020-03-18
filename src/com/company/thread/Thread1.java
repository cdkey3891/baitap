package com.company.thread;

public class Thread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 8; i++) {
            System.out.println("Runnable: "+i);
        }
    }
}
