package com.hatim.streams.limitskippeek;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SkipMethodExample {
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
        List<Integer> list =
                Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // 1. Skip first 3 numbers
        list.stream().skip(3).forEach(System.out::println);

        List<Employee> employee = List.of(
                new Employee(1, "Adam", 9000),
                new Employee(2, "Noah", 50000),
                new Employee(3, "Abraham", 60000),
                new Employee(4, "Moses", 70000),
                new Employee(5, "Jesus", 80000),
                new Employee(6, "Mohammad", 90000)
        );
        // 2. Skip first 2 employee records
        employee.stream().skip(2).forEach(System.out::println);

        // 3. Sort then skip first 2 elements
        employee.stream().sorted(Comparator.comparing(Employee::getId)).skip(2).forEach(System.out::println);

        // 4. Get second highest number
        list.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().ifPresent(System.out::println);

        // 5. Get third highest salary employee
        employee.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(2).findFirst().ifPresent(System.out::println);
    }
}
