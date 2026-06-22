package com.hatim.streams.limitskippeek;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class LimitMethodExample {
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

        // 1. Print first 3 numbers
        list.stream().limit(3) .forEach(System.out::println);

        List<Employee> employee = List.of(
                new Employee(1, "Adam", 9000),
                new Employee(2, "Noah", 50000),
                new Employee(3, "Abraham", 60000),
                new Employee(4, "Moses", 70000),
                new Employee(5, "Jesus", 80000),
                new Employee(6, "Mohammad", 90000)
        );
        // 2. Print first 5 employee names
        employee.stream().map(Employee::getName).limit(5).forEach(System.out::println);

        // 3. Print first 2 salaries after sorting
        employee.stream().sorted(Comparator.comparing(Employee::getSalary)).map(Employee::getSalary).limit(2).forEach(System.out::println);

        // 4. Generate infinite stream and take first 10 elements
        Stream.iterate(1,n -> n+1).limit(10).forEach(System.out::println);
    }
}
