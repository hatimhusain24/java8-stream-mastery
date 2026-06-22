package com.hatim.streams.find;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindMethodsExample {
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
                Arrays.asList(10,20,30,40,50);

        // 1. Find first element
        Optional<Integer> first = list.stream().findFirst();
        System.out.println(first);

        // 2. Find first even number
        Optional<Integer> second = list.stream().filter(n -> n%2 == 0).findFirst();
        System.out.println(second);

        // 3. Find first number greater than 25
        Optional<Integer> third = list.stream().filter(n -> n > 25).findFirst();
        System.out.println(third);

        List<String> list1 =
                Arrays.asList("Java",
                        "Angular",
                        "Spring");

        // 4. Find first string starting with "A"
        Optional<String> first1 = list1.stream().filter(s -> s.startsWith("A")).findFirst();
        System.out.println(first1);

        List<Employee> employee = List.of(
                new Employee(1, "Adam", 9000),
                new Employee(2, "Noah", 50000),
                new Employee(3, "Abraham", 60000),
                new Employee(4, "Moses", 70000),
                new Employee(5, "Jesus", 80000),
                new Employee(6, "Mohammad", 90000)
        );

        // 5. Find first employee salary > 70000
        Optional<Employee> result2 = employee.stream().filter(e -> e.getSalary() > 70000).findFirst();
        System.out.println(result2);

        // 6. Find first employee name starting with M
        Optional<Employee> result3 = employee.stream().filter(e -> e.getName().startsWith("M")).findFirst();
        System.out.println(result3);

        // 7. use findAny
        Optional<Employee> result4 = employee.stream().findAny();
        System.out.println(result4);

        // 8. Filter even numbers then findAny
        Optional<Employee> result5 = employee.stream().filter(e -> e.getId()%2 == 0).findAny();
        System.out.println(result5);

        // 9. Find any employee salary > 60000
        Optional<Employee> result6 = employee.stream().filter(e -> e.getSalary() > 60000).findAny();
        System.out.println(result6);

        // 10. Convert stream to parallel stream and compare
        Optional<Employee> result7 = employee.parallelStream().findAny();
        System.out.println(result7);

        Optional<Employee> result8 = employee.parallelStream().filter(e -> e.getId()%2 == 0).findAny();
        System.out.println(result8);
    }
}
