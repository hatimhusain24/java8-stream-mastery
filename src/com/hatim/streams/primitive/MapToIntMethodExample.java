package com.hatim.streams.primitive;

import com.hatim.streams.Employee;

import java.util.*;
import java.util.stream.IntStream;

public class MapToIntMethodExample {
    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // 1. Convert List<Integer> to IntStream
        IntStream result1 = number.stream().mapToInt(Integer::intValue);
        System.out.println(result1);

        // 2. Find sum
        int result2 = number.stream().mapToInt(Integer::intValue).sum();
        System.out.println(result2);

        // 3. Find average
        OptionalDouble result3 = number.stream().mapToInt(Integer::intValue).average();
        System.out.println(result3);

        // 4. Find maximum
        OptionalInt result4 = number.stream().mapToInt(Integer::intValue).max();
        System.out.println(result4);

        // 5. Find minimum
        OptionalInt result5 = number.stream().mapToInt(Integer::intValue).min();
        System.out.println(result5);

        List<Employee> employees = List.of(
                new Employee(1,"Adam",28,"IT",40000,List.of("Java", "Spring Boot", "SQL")),
                new Employee(2,"Noah",32,"HR",50000,List.of("Excel", "Communication", "Recruitment")),
                new Employee(3,"Abraham",35,"IT",60000,List.of("Java", "Kafka", "Docker")),
                new Employee(4,"Moses",40,"Admin",70000,List.of("Management", "Leadership", "Communication")),
                new Employee(5,"Jesus",30,"Finance",80000,List.of("Excel", "SQL", "Power BI")),
                new Employee(6,"Mohammad",38,"IT",90000,List.of("Java", "Spring Boot", "Kafka", "Docker", "Kubernetes"))
        );

        // 6. Employee salary sum
        int result6 = employees.stream().mapToInt(Employee::getSalary).sum();
        System.out.println(result6);

        // 7. Employee salary average
        OptionalDouble result7 = employees.stream().mapToInt(Employee::getSalary).average();
        System.out.println(result7);

        // 8. Employee highest salary
        OptionalInt result8 = employees.stream().mapToInt(Employee::getSalary).max();
        System.out.println(result8);

        // 9. Employee minimum salary
        OptionalInt result9 = employees.stream().mapToInt(Employee::getSalary).min();
        System.out.println(result9);

        // 10. Use summaryStatistics()
        IntSummaryStatistics result10 = employees.stream().mapToInt(Employee::getSalary).summaryStatistics();
        System.out.println(result10);
    }
}
