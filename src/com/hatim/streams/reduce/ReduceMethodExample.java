package com.hatim.streams.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceMethodExample {
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
                Arrays.asList(1,2,3,4,5);

        // 1. Sum of Numbers
        Optional<Integer> result = list.stream().reduce((a, b) -> a+b);
        System.out.println(result);

        // 2. Product of Numbers
        Optional<Integer> result1 = list.stream().reduce((a, b) -> a*b);
        System.out.println(result1);

        // 3. Maximum Number
        Optional<Integer> result2 = list.stream().reduce((a,b) -> a>b?a:b);
        System.out.println(result2);

        // 4. Minimum Number
        Optional<Integer> result3 = list.stream().reduce((a,b) -> a<b?a:b);
        System.out.println(result3);

        List<String> list1 = Arrays.asList(
                "Java",
                "Spring",
                "Boot"
        );

        // 5. Concatenate Strings
        String str = list1.stream().reduce("",(a,b) -> a+b);
        System.out.println(str);

        // 6. Longest String
        String str1 = list1.stream().reduce((a,b) -> a.length() > b.length() ? a:b).get();
        System.out.println(str1);

        List<Employee> employee = List.of(
                new Employee(1, "Adam", 9000),
                new Employee(2, "Noah", 50000),
                new Employee(3, "Abraham", 60000),
                new Employee(4, "Moses", 70000),
                new Employee(5, "Jesus", 80000),
                new Employee(6, "Mohammad", 90000)
        );

        // 7. Total Employee Salary
        Integer totalSalary = employee.stream().map(Employee::getSalary).reduce((a,b) -> a+b).get();
        System.out.println(totalSalary);

        // 8. Highest Employee Salary
        Integer highestSalary = employee.stream().map(Employee::getSalary).reduce((a,b) -> a>b ? a:b).get();
        System.out.println(highestSalary);

        // 9. Employee with Highest Salary
        Employee empSal = employee.stream().reduce((emp1, emp2) -> emp1.getSalary() > emp2.getSalary() ? emp1:emp2).get();
        System.out.println(empSal);

        List<String> words =
                Arrays.asList(
                        "I",
                        "love",
                        "Java"
                );

        // 10. Create Sentence
        String sentence = words.stream().reduce((a,b) -> a+" "+b).get();
        System.out.println(sentence);

        // 11. Average of all numbers
        int sum = list.stream().reduce(0, (a,b) -> a+b);
        long count = list.stream().count();
        double avg = (double) sum /count;
        System.out.println(avg);
    }
}
