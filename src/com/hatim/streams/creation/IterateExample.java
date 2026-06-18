package com.hatim.streams.creation;

import java.util.stream.Stream;

public class IterateExample {
    public static void main(String[] args) {
        Stream.iterate(1,i -> i + 1).limit(10).forEach(System.out::println);
        Stream.iterate(1, i-> i+2).limit(10).forEach(System.out::println);
    }
}
