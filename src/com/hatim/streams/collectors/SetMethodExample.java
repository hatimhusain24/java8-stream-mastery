package com.hatim.streams.collectors;

import java.util.*;
import java.util.stream.Collectors;

public class SetMethodExample {
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
                        "Mumbai",
                        "Bangalore",
                        "Mumbai",
                        "Pune",
                        "Hyderabad",
                        "Hyderabad"
                );

        List<Integer> number = Arrays.asList(1, 2, 3, 3, 4, 5, 5);

        List<Employee> employee = List.of(
                new Employee(1, "Adam", 9000),
                new Employee(2, "Noah", 50000),
                new Employee(3, "Noah", 60000),
                new Employee(4, "Moses", 70000),
                new Employee(5, "Moses", 80000),
                new Employee(6, "Mohammad", 90000)
        );

        // 1. Collect all unique integers
        Set<Integer> result1 = number.stream().collect(Collectors.toSet());
        System.out.println(result1);

        // 2. Collect unique city names
        Set<String> result2 = names.stream().collect(Collectors.toSet());
        System.out.println(result2);

        // 3. Collect unique employee names
        Set<String> result3 = employee.stream().map(Employee::getName).collect(Collectors.toSet());
        System.out.println(result3);
    }
}
