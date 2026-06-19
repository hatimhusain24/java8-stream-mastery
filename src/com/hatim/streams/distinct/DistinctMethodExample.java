package com.hatim.streams.distinct;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DistinctMethodExample {
    static class Employee{
        String name;
        int salary;
        Employee(String name, int salary){
            this.name=name;
            this.salary=salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", salary=" + salary +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return salary == employee.salary && Objects.equals(name, employee.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, salary);
        }
    }
    public static void main(String[] args) {

        List<Integer> list =
                Arrays.asList(1,2,2,3,3,4,5,5);

        // 1. Remove duplicate integers
        list.stream().distinct().forEach(System.out::println);

        List<String> list1 = Arrays.asList("Java",
                "Spring",
                "Java",
                "Angular",
                "Spring");

        // 2. Remove duplicate strings

        list1.stream().distinct().forEach(System.out::println);

        long count = list.stream().distinct().count();
        long count1 = list1.stream().distinct().count();
        System.out.println(count +" "+count1);

        List<Employee>  list2 = Arrays.asList(
                new Employee("Hatim",40000),
                new Employee("John",60000),
                new Employee("Hatim", 40000),
                new Employee("John", 60000)
        );
        list2.stream().distinct().forEach(System.out::println);
    }
}
