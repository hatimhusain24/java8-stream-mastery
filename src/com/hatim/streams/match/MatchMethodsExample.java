package com.hatim.streams.match;

import java.util.List;

public class MatchMethodsExample {
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

        // 1. Check if any employee salary > 80000
        boolean flag = employee.stream().anyMatch(e -> e.getSalary() > 80000);
        System.out.println("1. Check if any employee salary > 80000 : "+flag);

        // 2. Check if any employee name starts with M
        boolean flag1 = employee.stream().anyMatch(e -> e.getName().startsWith("M"));
        System.out.println("2. Check if any employee name starts with M : "+flag1);

        // 3. Check if all employees salary > 30000
        boolean flag2 = employee.stream().allMatch(e -> e.getSalary()>30000);
        System.out.println("3. Check if all employees salary > 30000 : "+flag2);

        // 4. Check if all employees name length > 2
        boolean flag3 = employee.stream().allMatch(e -> e.getName().length() > 2);
        System.out.println("3. Check if all employees name length > 2 : "+flag3);

        // 5. Check if none of employees salary < 10000
        boolean flag4 = employee.stream().noneMatch(e -> e.getSalary() < 10000);
        System.out.println("5. Check if none of employees salary < 10000 : "+flag4);

        // 6. Check if none of employees name equals "John"
        boolean flag5 = employee.stream().noneMatch(e -> e.getName().equals("John"));
        System.out.println("6. Check if none of employees name equals John : "+flag5);

        // 7. Check if any integer is even
        boolean flag6 = employee.stream().anyMatch(e -> e.getId()%2 == 0);
        System.out.println("7. Check if any integer is even : "+flag6);

        // 8. Check if all integers are positive
        boolean flag7 = employee.stream().allMatch(e -> e.getId() > 0);
        System.out.println(" 8. Check if all integers are positive : "+flag7);

        // 9. Check if none of integers are negative
        boolean flag8 = employee.stream().noneMatch(e -> e.getId() < 0);
        System.out.println("9. Check if none of integers are negative : "+flag8);
    }
}
