package com.company.generic;

public class Genericc {
    public <T> void showAll(T[] object) {
        for (T o: object) {
            System.out.println(o);
        }
    }
    public <K, V> void showInfo(K key, V value) {
        System.out.println(key+ ", "+value);
    }

    public <T extends Comparable<T>> T getMax(T[] arr){
        T max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(max) > 0) {
                max=arr[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        String[] s = {"show", "me", "your", "face"};
        Integer[] i = {1, 3, 5, 6};
        Genericc genericc = new Genericc();
        genericc.showAll(s);
        genericc.showAll(i);
        genericc.showInfo(2,"sdklfjsl");

        System.out.println(genericc.getMax(i));
        String a = "sldkf";

    }
}
