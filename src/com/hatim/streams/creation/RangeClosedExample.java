package com.hatim.streams.creation;

import java.util.stream.IntStream;

public class RangeClosedExample {
    public static void main(String[] args) {
        IntStream.rangeClosed(1,10).forEach(System.out::println);
    }
}
