package com.company.thread;

public class thread {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread thread = new Thread(thread1);

        Thread2 thread2 = new Thread2();

        thread.start();
        thread2.start();
    }
}
