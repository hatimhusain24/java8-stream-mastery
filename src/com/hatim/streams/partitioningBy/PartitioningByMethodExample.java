package com.hatim.streams.partitioningBy;

import com.hatim.streams.groupingBy.GroupingByMethodExample;

import java.util.*;
import java.util.stream.Collectors;

public class PartitioningByMethodExample {
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
                new Employee(1, "Adam", 20000, 34,"IT"),
                new Employee(2, "Noah", 50000, 26, "Finance"),
                new Employee(3, "Abraham", 50000, 31, "HR"),
                new Employee(4, "Moses", 70000, 28, "IT"),
                new Employee(5, "Jesus", 80000, 29, "Admin"),
                new Employee(6, "Mohammad", 90000, 30, "HR")
        );

        // 1. Partition employees by salary > 60000
        Map<Boolean, List<Employee>> result1 = employee.stream().collect(Collectors.partitioningBy(emp -> emp.getSalary() > 60000));
        System.out.println(result1);

        // 2. Partition employees by age > 30
        Map<Boolean, List<Employee>> result2 = employee.stream().collect(Collectors.partitioningBy(emp -> emp.getAge() > 30));
        System.out.println(result2);

        // 3. Partition employees by department == "IT"
        Map<Boolean, List<Employee>> result3 = employee.stream().collect(Collectors.partitioningBy(emp -> emp.getDepartment() == "IT"));
        System.out.println(result3);

        List<Integer> number = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // 4. Partition numbers into even and odd
        Map<Boolean, List<Integer>> result4 = number.stream().collect(Collectors.partitioningBy(n -> n%2 == 0));
        System.out.println(result4);

        // 5. Partition strings having length > 5
        Map<Boolean, List<Employee>> result5 = employee.stream().collect(Collectors.partitioningBy(emp -> emp.getName().length() > 5));
        System.out.println(result5);

        // 6. Count employees in each partition
        Map<Boolean, Long> result6 = employee.stream().collect(Collectors.partitioningBy(emp -> emp.getSalary() > 45000, Collectors.counting()));
        System.out.println(result6);

        // 7. Average salary in each partition
        Map<Boolean, Double> result7 = employee.stream().collect(Collectors.partitioningBy(emp -> emp.getSalary() > 60000, Collectors.averagingInt(Employee::getSalary)));
        System.out.println(result7);

        // 8. Total salary in each partition
        Map<Boolean, Integer> result8 = employee.stream().collect(Collectors.partitioningBy(emp -> emp.getSalary() > 60000, Collectors.summingInt(Employee::getSalary)));
        System.out.println(result8);

        // 9. Employee names in each partition
        Map<Boolean, List<String>> result9 = employee.stream().collect(Collectors.partitioningBy(emp -> emp.getSalary()>60000, Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println(result9);

        // 10. Highest salary in each partition
        Map<Boolean, Integer> result10 = employee.stream().collect(Collectors.partitioningBy(emp -> emp.getSalary() > 60000, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Employee::getSalary)), emp -> emp.get().getSalary())));
        System.out.println(result10);
    }
}
