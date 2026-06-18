package com.hatim.streams.creation;

import java.util.Random;
import java.util.stream.Stream;

public class GenerateExample {
    public static void main(String[] args) {
        Stream.generate(() -> "Java").limit(10).forEach(System.out::println);
        Random random = new Random();
        Stream.generate(() -> random.nextInt(10)).limit(10).forEach(System.out::println);
    }
}
