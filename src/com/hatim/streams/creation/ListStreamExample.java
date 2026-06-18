package com.hatim.streams.creation;

import java.util.Arrays;
import java.util.List;

public class ListStreamExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10,20,30,40,50);

        // 1. Create stream and print all elements
        list.stream().forEach(System.out::println);
    }
}
