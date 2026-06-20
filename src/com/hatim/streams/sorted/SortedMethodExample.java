package com.hatim.streams.sorted;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortedMethodExample {
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
                Arrays.asList(5,2,8,1,3);

        // 1. Sort Integers Ascending
        list.stream().sorted().forEach(System.out::println);

        // 2. Sort Integers Descending
        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        List<String> names =
                Arrays.asList(
                        "Spring",
                        "Java",
                        "Angular",
                        "Kafka"
                );

        // 3. Sort Strings Alphabetically
        names.stream().sorted().forEach(System.out::println);

        // 4. Sort Strings Reverse Alphabetically
        names.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        List<Employee> employee = List.of(
                new Employee(1, "Adam", 40000),
                new Employee(2, "Noah", 50000),
                new Employee(3, "Abraham", 60000),
                new Employee(4, "Moses", 70000),
                new Employee(5, "Jesus", 80000),
                new Employee(6, "Mohammad", 90000)
        );

        // 5. Sort Employees by Salary Ascending
        employee.stream().sorted(Comparator.comparing(Employee::getSalary)).forEach(System.out::println);

        // 6. Sort Employees by Salary Descending
        employee.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).forEach(System.out::println);

        // 7. Sort Employees by Name Ascending
        employee.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);

        // 8. Sort Employees by Name Descending
        employee.stream().sorted(Comparator.comparing(Employee::getName).reversed()).forEach(System.out::println);

        // 9. Sort By Salary Then Name
        employee.stream().sorted(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName)).forEach(System.out::println);
    }
}
