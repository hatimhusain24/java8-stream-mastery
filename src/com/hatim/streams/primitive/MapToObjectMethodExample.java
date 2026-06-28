package com.hatim.streams.primitive;

import java.util.List;
import java.util.stream.IntStream;

public class MapToObjectMethodExample {
    static class Employee{
        private int id;

        public void setId(int id) {
            this.id = id;
        }

        Employee(int id){
            this.id = id;
        }

        @Override
        public String toString() {
            return "Employee(" +
                     id +
                    ')';
        }
    }
    public static void main(String[] args) {
        // 1. Convert intstream into Stream<String>
        IntStream.of(1,2,3,4,5).mapToObj(String::valueOf).forEach(System.out::println);

        // 2. Convert 1 into Employee - 1
        IntStream.of(1,2,3,4,5).mapToObj(n -> "Employee - "+n).forEach(System.out::println);

        // 3. Convert 1 into Employee(1)
        IntStream.of(1,2,3,4,5).mapToObj(Employee::new).forEach(System.out::println);

        // 4. convert IntStream.rangeClosed(1,5) into List<Employee>
        List<Employee> result4 = IntStream.rangeClosed(1,5).mapToObj(Employee::new).toList();
        System.out.println(result4);

        // 5. Convert numbers into squares
        IntStream.rangeClosed(1,5).mapToObj(n -> "Square is "+n*n).forEach(System.out::println);

        // 6. Convert ASCII values
        IntStream.of(65,66,67,68).mapToObj(n -> (char)n).forEach(System.out::println);

        // 7. Convert 1 2 to odd even
        IntStream.rangeClosed(1,5).mapToObj(n -> n%2==0 ? "Even":"Odd").forEach(System.out::println);

        // 8. Create a list : 1 -> Java-1
        List<String> result8 = IntStream.rangeClosed(1,5).mapToObj(n -> "Java-"+n).toList();
        System.out.println(result8);

        // 9. Generate IDs
        IntStream.rangeClosed(1001,1010).mapToObj(n -> "EMP"+n).forEach(System.out::println);

        // 10. Generate Email IDs
        IntStream.rangeClosed(1,5).mapToObj(n -> "user"+n+"@gmail.com").forEach(System.out::println);
    }
}
