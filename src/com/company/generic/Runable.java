package com.company.generic;

public interface Runable {
    void run();
    default String talk() {
        return "go go";
    }
}
