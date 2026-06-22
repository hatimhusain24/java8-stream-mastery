package com.hatim.streams.limitskippeek;

import java.util.Arrays;
import java.util.List;

public class PeekMethodExample {
    public static void main(String[] args) {
        List<Integer> list =
                Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // 1. use of peek
        list.stream().peek(System.out::println).forEach(System.out::println);

        // 2. Print values before filter
        list.stream().peek(System.out::println).filter(e -> e % 2 == 0).forEach(System.out::println);

        // 3. Print values after filter
        list.stream().filter(e -> e % 2 == 0).peek(System.out::println).forEach(System.out::println);

        // 4. Observe stream execution order
        list.stream().peek(System.out::println).filter(e -> e % 2 == 0).peek(System.out::println).map(String::valueOf).peek(System.out::println).forEach(System.out::println);
    }
}
