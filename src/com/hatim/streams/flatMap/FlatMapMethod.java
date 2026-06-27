package com.hatim.streams.flatMap;

import com.hatim.streams.Employee;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapMethod {
    public static void main(String[] args) {
        List<List<String>> subjects =
                List.of(
                        List.of("Java","Spring"),
                        List.of("Kafka","Redis"),
                        List.of("Docker","Kubernetes")
                );

        // 1. Flatten
        Stream<String> result1 = subjects.stream().flatMap(List::stream);
        System.out.println(result1);

        // 2. Print all strings
        subjects.stream().flatMap(List::stream).forEach(System.out::println);

        // 3. Count total subjects from nested lists
        long result3 = subjects.stream().flatMap(List::stream).count();
        System.out.println(result3);

        // 4. Collect all subjects into one List
        List<String> result4 = subjects.stream().flatMap(List::stream).toList();
        System.out.println(result4);

        List<List<String>> subjects1 =
                List.of(
                        List.of("Java","Spring"),
                        List.of("Kafka","Java"),
                        List.of("Spring","Kafka")
                );

        // 5. Find distinct subjects
        Set<String> result5 = subjects1.stream().flatMap(List::stream).collect(Collectors.toSet());
        System.out.println(result5);

        // 6. Sort all flattened subjects
        subjects.stream().flatMap(List::stream).sorted().forEach(System.out::println);

        List<Employee> employees = List.of(
                new Employee(1,"Adam",28,"IT",40000,List.of("Java", "Spring Boot", "SQL")),
                new Employee(2,"Noah",32,"HR",50000,List.of("Excel", "Communication", "Recruitment")),
                new Employee(3,"Abraham",35,"IT",60000,List.of("Java", "Kafka", "Docker")),
                new Employee(4,"Moses",40,"Admin",70000,List.of("Management", "Leadership", "Communication")),
                new Employee(5,"Jesus",30,"Finance",80000,List.of("Excel", "SQL", "Power BI")),
                new Employee(6,"Mohammad",38,"IT",90000,List.of("Java", "Spring Boot", "Kafka", "Docker", "Kubernetes"))
        );

        // 7. Print all skills
        List<String> result7 = employees.stream().flatMap(emp -> emp.getSkills().stream()).toList();
        System.out.println(result7);

        // 8. Print distinct skills
        List<String> result8 = employees.stream().flatMap(emp -> emp.getSkills().stream()).distinct().toList();
        System.out.println(result8);

        // 9. Count total skills
        long result9 = employees.stream()
                        .map(Employee::getSkills)
                                .flatMap(List::stream)
                                        .count();
        System.out.println(result9);

        // 10. Find all skills starting with "S"
        List<String> result10 = employees.stream().flatMap(emp -> emp.getSkills().stream()).filter(skill -> skill.startsWith("S")).distinct().toList();
        System.out.println(result10);
    }
}
