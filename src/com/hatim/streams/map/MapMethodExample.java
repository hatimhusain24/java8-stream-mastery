package com.hatim.streams.map;

import com.hatim.streams.filters.FilterMethodExample;

import java.util.Arrays;
import java.util.List;

public class MapMethodExample {
    static class Employee {
        int id;
        String name;
        double salary;

        Employee(int id){
            this.id = id;
        }
        Employee(int id, String name, double salary) {
            this.id=id;
            this.name=name;
            this.salary=salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    '}';
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }
    }
    public static void main(String[] args) {
        List<Integer> list =
                Arrays.asList(1,2,3,4,5);

        // 1. Square Every Number
        list.stream().map(n -> n*n).forEach(System.out::println);

        // 2. Multiply By 10
        list.stream().map(n -> n*10).forEach(System.out::println);

        // 3. Convert To String
        list.stream().map(String::valueOf).forEach(System.out::println);

        List<String> names =
                Arrays.asList(
                        "java",
                        "spring",
                        "angular"
                );

        // 4. Uppercase Strings
        names.stream().map(s -> s.toUpperCase()).forEach(System.out::println);

        List<String> names1 =
                Arrays.asList(
                        "JAVA",
                        "SPRING",
                        "ANGULAR"
                );

        // 5. Lowercase Strings
        names1.stream().map(String::toLowerCase).forEach(System.out::println);

        // 6. Find Length Of Each String
        names.stream().map(String::length).forEach(System.out::println);

        // 7. Add Prefix
        names.stream().map(s -> "Learning "+s).forEach(System.out::println);

        List<Employee> employee = List.of(
                new Employee(1, "Adam", 40000),
                new Employee(2, "Noah", 50000),
                new Employee(3, "Abraham", 60000),
                new Employee(4, "Moses", 70000),
                new Employee(5, "Jesus", 80000),
                new Employee(6, "Mohammad", 90000)
        );

        // 8. Convert Integer To Employee
        list.stream().map(id -> new Employee(id)).forEach(System.out::println);

        // 9. Extract Employee Names
        employee.stream().map(s -> s.name).forEach(System.out::println);

        // 10. Extract Salaries
        employee.stream().map(s -> s.salary).forEach(System.out::println);

        // 11. Convert Employee → String
        employee.stream().map(Employee::getName).forEach(System.out::println);

        // 12. Convert Employee → Salary + Bonus
        employee.stream().map(e -> e.getSalary()+5000).forEach(System.out::println);
    }
}
