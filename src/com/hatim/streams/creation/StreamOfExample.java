package com.hatim.streams.creation;

import java.util.stream.Stream;

public class StreamOfExample {
    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).forEach(System.out::println);
        Stream.of("Mumbai","Pune","Hyderabad","Bangalore","Chennai").forEach(System.out::println);
    }
}
