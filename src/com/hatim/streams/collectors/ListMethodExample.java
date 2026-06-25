package com.hatim.streams.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListMethodExample {
        static class Employee {
            private int id;
            private String name;
            private int salary;

            public int getId() {
                return id;
            }

            public String getName() {
                return name;
            }

            public int getSalary() {
                return salary;
            }

            public Employee(int id, String name, int salary) {
                this.id = id;
                this.name = name;
                this.salary = salary;
            }

            @Override
            public String toString() {
                return "Employee{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", salary=" + salary +
                        '}';
            }
        }
    public static void main(String[] args) {
        List<String> names =
                Arrays.asList(
                        "java",
                        "spring",
                        "angular"
                );
        List<Integer> number = Arrays.asList(1, 2, 3, 4, 5);

        // 1. Convert names to uppercase and collect into List
        List<String> result1 = names.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(result1);

        // 2. Collect all even numbers into List
        List<Integer> result2 = number.stream().filter(n-> n%2==0).collect(Collectors.toList());
        System.out.println(result2);

        List<Employee> employee = List.of(
                new Employee(1, "Adam", 9000),
                new Employee(2, "Noah", 50000),
                new Employee(3, "Abraham", 60000),
                new Employee(4, "Moses", 70000),
                new Employee(5, "Jesus", 80000),
                new Employee(6, "Mohammad", 90000)
        );

        // 3. Collect employee names into List
        List<String> result3 = employee.stream().map(Employee::getName).collect(Collectors.toList());
        System.out.println(result3);
    }
}
