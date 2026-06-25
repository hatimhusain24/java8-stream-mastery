package com.hatim.streams.collectors;

import java.util.List;
import java.util.stream.Collectors;

public class SummingIntMethodExample {
    static class Employee {
        private int id;
        private String name;
        private int salary;
        private int age;

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

        public Employee(int id, String name, int salary, int age) {
            this.id = id;
            this.name = name;
            this.salary = salary;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", salary=" + salary +
                    ", age=" + age +
                    '}';
        }
    }
    public static void main(String[] args) {
        List<Employee> employee = List.of(
                new Employee(1, "Adam", 9000, 25),
                new Employee(2, "Noah", 50000, 26),
                new Employee(3, "Abraham", 60000, 27),
                new Employee(4, "Moses", 70000, 28),
                new Employee(5, "Jesus", 80000, 29),
                new Employee(6, "Mohammad", 90000, 30)
        );

        // 1. Find total employee salary
        long result1 = employee.stream().collect(Collectors.summingInt(Employee::getSalary));
        System.out.println(result1);

        // 2. Find total age of employees
        long result2 = employee.stream().collect(Collectors.summingInt(Employee::getAge));
        System.out.println(result2);
    }
}
