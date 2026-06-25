package com.hatim.streams.collectors;

import java.util.List;
import java.util.stream.Collectors;

public class CountingMethodExample {
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
        List<Employee> employee = List.of(
                new Employee(1, "Adam", 9000),
                new Employee(2, "Noah", 50000),
                new Employee(3, "Abraham", 60000),
                new Employee(4, "Moses", 70000),
                new Employee(5, "Jesus", 80000),
                new Employee(6, "Mohammad", 90000)
        );

        // 1. Count total employees
        long result1 = employee.stream().collect(Collectors.counting());
        System.out.println(result1);

        // 2. Count employees having salary > 50000
        long result2 = employee.stream().filter(e -> e.getSalary() > 50000).collect(Collectors.counting());
        System.out.println(result2);
    }
}
