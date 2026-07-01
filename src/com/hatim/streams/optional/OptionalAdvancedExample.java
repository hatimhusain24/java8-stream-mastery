package com.hatim.streams.optional;

import com.hatim.streams.Employee;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

public class OptionalAdvancedExample {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee(1,"Adam",28,"IT",40000,List.of("Java", "Spring Boot", "SQL")),
                new Employee(2,"Noah",32,"HR",50000,List.of("Excel", "Communication", "Recruitment")),
                new Employee(3,"Abraham",35,"IT",60000,List.of("Java", "Kafka", "Docker")),
                new Employee(4,"Moses",40,"Admin",70000,List.of("Management", "Leadership", "Communication")),
                new Employee(5,"Jesus",30,"Finance",80000,List.of("Excel", "SQL", "Power BI")),
                new Employee(6,"Mohammad",38,"IT",90000,List.of("Java", "Spring Boot", "Kafka", "Docker", "Kubernetes"))
        );

        // 1. find employee with id 1
        Optional<String> result1 = employees.stream()
                .filter(emp -> emp.getId() == 1)
                .findFirst().map(Employee::getName);
        System.out.println(result1.get());

        // 2. Convert Optional<Employee> Optional<Integer> :: Salary
        Optional<Employee> result2 = employees.stream()
                .filter(emp -> emp.getSalary() > 60000)
                .findFirst();
        System.out.println(result2.map(Employee::getSalary).get());

        // 3. Print employee department using map()
        Optional<Employee> result3 = employees.stream()
                .findFirst();
        System.out.println(result3.map(Employee::getDepartment).get());

        // 4. Keep employee only if salary > 50000
        Optional<Employee> result4 = employees.stream()
                .filter(emp -> emp.getSalary() > 90000)
                .findFirst();
        System.out.println(result4);

        // 5. Keep employee only if department = IT
        Optional<Employee> result5 = employees.stream()
                .filter(emp -> emp.getDepartment().equals("IT"))
                .findFirst();
        System.out.println(result5);

        // 6. Print employee salary using
        employees.stream()
                .filter(emp -> emp.getSalary() > 70000)
                .findFirst()
                .map(Employee::getSalary)
                .ifPresent(System.out::println);

        // 7. Search employee id 10. Print Employee Not Found
        employees.stream()
                .filter(emp -> emp.getId() == 10)
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("Employee not found"));

        // 8. Search employee id 1. Print employee.
        employees.stream()
                .filter(emp -> emp.getId() == 1)
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("Employee not found"));

        // 9. Create getDefaultName() Print Method Executed orElse and orElseGet

        Optional<String> name = Optional.of("Adam");
        String result9a = name.orElse(getDefaultName());
        System.out.println(result9a);

        String result9b = name.orElseGet(OptionalAdvancedExample::getDefaultName);
        System.out.println(result9b);

        // 10. map chaining
        String res = employees.stream()
                .map(Employee::getName)
                .map(String::toUpperCase)
                .findFirst()
                .orElse("Unknown");
        System.out.println(res);
    }

    private static String getDefaultName() {
        System.out.println("Hello World");
        return "ABC";
    }
}
