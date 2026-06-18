package com.hatim.streams.creation;

import java.util.Set;

public class SetStreamExample {
    public static void main(String[] args) {
        Set<String> set = Set.of("Husain","Hatim");
        set.stream().forEach(System.out::println);
    }
}
