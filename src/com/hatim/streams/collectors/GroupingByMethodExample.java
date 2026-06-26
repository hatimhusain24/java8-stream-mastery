package com.hatim.streams.collectors;

import java.util.*;
import java.util.stream.Collectors;

public class GroupingByMethodExample {
    static class Employee {
        private int id;
        private String name;
        private int salary;
        private int age;
        private String department;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getSalary() {
            return salary;
        }

        public int getAge() {
            return age;
        }

        public String getDepartment() {
            return department;
        }

        public Employee(int id, String name, int salary, int age, String department) {
            this.id = id;
            this.name = name;
            this.salary = salary;
            this.age = age;
            this.department = department;
        }

        @Override
        public String toString() {
            return name;
        }
    }
    public static void main(String[] args) {
        List<Employee> employee = List.of(
                new Employee(1, "Adam", 90000, 25,"IT"),
                new Employee(2, "Noah", 50000, 26, "Finance"),
                new Employee(3, "Abraham", 50000, 27, "HR"),
                new Employee(4, "Moses", 70000, 28, "IT"),
                new Employee(5, "Jesus", 80000, 29, "Admin"),
                new Employee(6, "Mohammad", 90000, 30, "HR")
        );

        // 1. Group Employees By Department
        Map<String, List<Employee>> result1 = employee.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(result1);

        // 2. Group Employees By Salary
        Map<Integer, List<Employee>> result2 = employee.stream().collect(Collectors.groupingBy(Employee::getSalary));
        System.out.println(result2);

        // 3. Count Employees Per Department
        Map<String, Long> result3 = employee.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(result3);

        // 4. Average Salary Per Department
        Map<String, Double> result4 = employee.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingInt(Employee::getSalary)));
        System.out.println(result4);

        // 5. Total Salary Per Department
        Map<String, Integer> result5 = employee.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingInt(Employee::getSalary)));
        System.out.println(result5);

        // 6. Employee Names Per Department
        Map<String, List<String>> result6 = employee.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println(result6);

        // 7. Department Wise Highest Salary
        Map<String, Optional<Employee>> result7 = employee.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
        System.out.println(result7);

        // 8. Department Wise Lowest Salary
        Map<String, Integer> result8 = employee.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(Collectors.minBy(Comparator.comparing(Employee::getSalary)),
                emp -> emp.get().getSalary())));
        System.out.println(result8);

        List<Integer> number = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        // 9. Group Numbers By Even/Odd
        Map<Boolean, List<Integer>> result9 = number.stream().collect(Collectors.partitioningBy(n -> n%2 == 0));
        System.out.println(result9);

        List<String> names =
                Arrays.asList(
                        "java",
                        "spring",
                        "angular",
                        "kafka"
                );

        // 10. Group Strings By Length
        Map<Integer, List<String>> result10 = names.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(result10);
    }
}
