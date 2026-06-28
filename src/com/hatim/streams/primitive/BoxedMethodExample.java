package com.hatim.streams.primitive;

import com.hatim.streams.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BoxedMethodExample {
    public static void main(String[] args) {
        IntStream intStream = IntStream.of(1,2,3,4,5);
        // 1. Convert
        intStream.boxed().forEach(System.out::println);

        // 2. Convert IntStream into List<Integer> into Set<Integer>
        IntStream intStream2 = IntStream.of(1,2,3,4,5);
        List<Integer> result2 = intStream2.boxed().toList();
        System.out.println(result2);

        // 3. Convert IntStream.rangeClosed(1,10)
        IntStream intStream3 = IntStream.rangeClosed(1,10);
        Set<Integer> result3 = intStream3.boxed().collect(Collectors.toSet());
        System.out.println(result3);

        // 4. Create IntStream Convert to List<String> First boxed() Then transform each Integer into a String.
        IntStream intStream4 = IntStream.of(1,2,3,4,5);
        List<String> result4 = intStream4.boxed().map(String::valueOf).toList();
        System.out.println(result4);

        List<Employee> employees = List.of(
                new Employee(1,"Adam",28,"IT",40000,List.of("Java", "Spring Boot", "SQL")),
                new Employee(2,"Noah",32,"HR",50000,List.of("Excel", "Communication", "Recruitment")),
                new Employee(3,"Abraham",35,"IT",60000,List.of("Java", "Kafka", "Docker")),
                new Employee(4,"Moses",40,"Admin",70000,List.of("Management", "Leadership", "Communication")),
                new Employee(5,"Jesus",30,"Finance",80000,List.of("Excel", "SQL", "Power BI")),
                new Employee(6,"Mohammad",38,"IT",90000,List.of("Java", "Spring Boot", "Kafka", "Docker", "Kubernetes"))
        );

        // 5. Convert intstream into Stream
        employees.stream().mapToInt(Employee::getSalary).boxed().forEach(System.out::println);

        // 6. Collect all employee salaries into list
        List<Integer> result6 = employees.stream().mapToInt(Employee::getSalary).boxed().toList();
        System.out.println(result6);

        // 7. Collect salaries into Set<Integer>
        Set<Integer> result7 = employees.stream().mapToInt(Employee::getSalary).boxed().collect(Collectors.toSet());
        System.out.println(result7);

        // 8. Filter even numbers after boxing
        IntStream intStream5 = IntStream.of(1,2,3,4,5);
        intStream5.boxed().filter(n -> n%2 == 0).forEach(System.out::println);

        // 9. Sort salaries in descending order
        employees.stream().mapToInt(Employee::getSalary).boxed().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        // 10. Find distinct salaries
        employees.stream().mapToInt(Employee::getSalary).boxed().distinct().forEach(System.out::println);
    }
}
