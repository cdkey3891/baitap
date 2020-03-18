package com.company.set;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.util.HashMap;

public class Mapp {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "thang");
        map.put(2, "tran");
        map.put(3, "van");

        List<String> list = new ArrayList<>();
        list.add("thang");
        list.add("them");
        list.add("tom");
        list.add("ngao");

        map.forEach((k, v) -> System.out.println("key: "+k+", value: "+v));

    }
}
