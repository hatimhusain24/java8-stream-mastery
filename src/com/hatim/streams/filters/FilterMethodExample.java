package com.hatim.streams.filters;

import java.util.Arrays;
import java.util.List;

public class FilterMethodExample {
    static class Employee {
        int id;
        String name;
        double salary;

        public Employee(int id, String name, double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", salary=" + salary;
        }
    }
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // 1. Print even numbers
        list.stream().filter(n-> n%2==0).forEach(System.out::println);

        // 2. Print odd numbers
        list.stream().filter(n-> n%2!=0).forEach(System.out::println);

        // 3. Print numbers greater than 5
        list.stream().filter(n -> n>5).forEach(System.out::println);

        // 4. Print numbers divisible by 3
        list.stream().filter(n -> n%3 == 0).forEach(System.out::println);

        List<String> names =
                Arrays.asList(
                        "Java",
                        "Spring",
                        "Angular",
                        "Scala",
                        "C",
                        "SQL"
                );

        // 5. Print strings having length > 4
        names.stream().filter(s -> s.length() > 4).forEach(System.out::println);

         // 6. Print names starting with 'A'
        names.stream().filter(s -> s.startsWith("A")).forEach(System.out::println);

        // 7. Print names ending with 'a'
        names.stream().filter(s -> s.endsWith("a")).forEach(System.out::println);

        List<String> names1 =
                Arrays.asList(
                        "Java",
                        null,
                        "Spring",
                        null,
                        "Angular"
                );

        // 8. Remove null values
        names1.stream().filter(s -> s!= null).forEach(System.out::println);

        List<String> names2 = Arrays.asList(
                "Java",
                "",
                "Spring",
                "",
                "Angular"
        );

        // 9. Print non-empty strings
        names2.stream().filter(s -> !s.isEmpty()).forEach(System.out::println);

        // 10. Print employees with salary > 50000
        List<Employee> employee = List.of(
                new Employee(1, "Adam", 40000),
                new Employee(2, "Noah", 50000),
                new Employee(3, "Abraham", 60000),
                new Employee(4, "Moses", 70000),
                new Employee(5, "Jesus", 80000),
                new Employee(6, "Mohammad", 90000)
        );

        employee.stream().filter(emp -> emp.salary > 50000).forEach(System.out::println);
    }
}
