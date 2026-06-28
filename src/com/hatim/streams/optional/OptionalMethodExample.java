package com.hatim.streams.optional;

import java.util.Optional;

public class OptionalMethodExample {
    public static void main(String[] args) throws Exception {
        // 1. Create Optional using: Optional.of()
        Optional<String> optional = Optional.of("Hello");
        System.out.println(optional.get());

        // 2. Create Optional using: Optional.ofNullable()
        Optional<String> optional2 = Optional.ofNullable(null);
        System.out.println(optional2);

        // 3. Create empty Optional
        Optional<String> optional3 = Optional.empty();
        System.out.println(optional3);

        // 4. Check whether value exists
        Optional.of("Java").ifPresent(System.out::println);

        // 5. Check whether value is empty
        boolean optional5 = Optional.ofNullable(5).isEmpty();
        System.out.println(optional5);

        // 6. Get value using: get()
        Optional<String> optional6 = Optional.of("Java");
        System.out.println(optional6.get());

        // 7. Use: orElse()
        String optional7 = Optional.empty().orElse("unknown").toString();
        System.out.println(optional7);

        // 8. Use: orElseGet()
         Optional.of("Java").orElseGet(() -> "Hello");

         // 9. Use: orElseThrow()
        String result9 = Optional.of("Java").orElseThrow(Exception::new);
        System.out.println(result9);
    }
}
