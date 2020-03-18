package com.company.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyStream {
    public static List<Integer> numbers = Arrays.asList(8, 3, 5, 2);
    public void withOutStream() {
        long count = 0;
        for (Integer i: numbers) {
            if(i % 2 == 0) {
                count++;
            }
        }
        System.out.printf("co %d so chan", count);
    }
    public void withStream() {
        long count = numbers.stream().filter(num -> num % 2 == 0).count();
        System.out.printf("co %d so chan", count);
    }

    public static void main(String[] args) {

    }
}
