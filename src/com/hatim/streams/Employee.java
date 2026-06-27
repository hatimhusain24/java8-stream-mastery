package com.hatim.streams;

import java.util.List;

public class Employee {
    private int id;
    private String name;
    private int age;
    private String department;
    private int salary;
    private List<String> skills;

    public Employee(int id, String name, int age, String department, int salary, List<String> skills) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
        this.skills = skills;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public List<String> getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", skills=" + skills +
                '}';
    }

}
