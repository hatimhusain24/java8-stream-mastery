package com.hatim.streams.optional;

import com.hatim.streams.Employee;

import java.util.List;
import java.util.Optional;

public class OptionalMethodExample {
    public static void main(String[] args) throws Exception {
        // 1. Create Optional using: Optional.of()
        Optional<String> optional = Optional.of("Hello");
        System.out.println(optional);

        // 2. Create Optional using: Optional.ofNullable()
        Optional<String> optional2 = Optional.ofNullable(null);
        System.out.println(optional2);

        // 3. Create empty Optional
        Optional<String> optional3 = Optional.empty();
        System.out.println(optional3);

        // 4. Check whether value exists
        boolean result4 = Optional.of("Java").isPresent();
        System.out.println(result4);

        // 5. Check whether value is empty
        boolean optional5 = Optional.ofNullable(5).isEmpty();
        System.out.println(optional5);

        // 6. Get value using: get()
        Optional<String> optional6 = Optional.of("Java");
        System.out.println(optional6.get());

        // 7. Use: orElse()
        String optional7 = Optional.<String>empty().orElse("unknown");
        System.out.println(optional7);

        // 8. Use: orElseGet()
         Optional.of("Java").orElseGet(() -> "Hello");

         // 9. Use: orElseThrow()
        String result9 = Optional.of("Java").orElseThrow(Exception::new);
        System.out.println(result9);

        // 10. Filter employee list. Find employee id 10
        List<Employee> employees = List.of(
                new Employee(1,"Adam",28,"IT",40000,List.of("Java", "Spring Boot", "SQL")),
                new Employee(2,"Noah",32,"HR",50000,List.of("Excel", "Communication", "Recruitment")),
                new Employee(3,"Abraham",35,"IT",60000,List.of("Java", "Kafka", "Docker")),
                new Employee(4,"Moses",40,"Admin",70000,List.of("Management", "Leadership", "Communication")),
                new Employee(5,"Jesus",30,"Finance",80000,List.of("Excel", "SQL", "Power BI")),
                new Employee(6,"Mohammad",38,"IT",90000,List.of("Java", "Spring Boot", "Kafka", "Docker", "Kubernetes"))
        );

        Optional<Integer> result10 = employees.stream().map(Employee::getId).filter(id -> id == 10).findFirst();
        System.out.println(result10);
    }
}
