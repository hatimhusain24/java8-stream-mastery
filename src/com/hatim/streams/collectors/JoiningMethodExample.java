package com.hatim.streams.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoiningMethodExample {
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

        List<Employee> employee = List.of(
                new Employee(1, "Adam", 9000),
                new Employee(2, "Noah", 50000),
                new Employee(3, "Abraham", 60000),
                new Employee(4, "Moses", 70000),
                new Employee(5, "Jesus", 80000),
                new Employee(6, "Mohammad", 90000)
        );

        // 1. Create sentence from words
        String result1 = names.stream().collect(Collectors.joining(" "));
        System.out.println(result1);

        // 2. Create comma separated technology list
        String result2 = names.stream().collect(Collectors.joining(", "));

        // 3. Join employee names
        String result3 = employee.stream().map(Employee::getName).collect(Collectors.joining());
        System.out.println(result3);
    }
}
