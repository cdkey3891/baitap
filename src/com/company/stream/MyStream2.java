package com.company.stream;

import java.util.Arrays;
import java.util.List;

public class MyStream2 extends MyStream{
    public static void main(String[] args) {
        System.out.println();
        String s = getString("hedfhllo",input -> "hello");
        System.out.println(s);


    }
    public interface StringProcessor{
        String stringProcess(String inupt);

    }

    public static String getString(String input, StringProcessor processor) {
        return processor.stringProcess(input).toUpperCase()+" WORLD";
    }
}
