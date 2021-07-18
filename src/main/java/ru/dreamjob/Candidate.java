package ru.dreamjob;

import java.util.Objects;

public class Candidate {

    private String name;
    private int age;
    private String position;
    private int salary;

    public Candidate(String name, String position, int salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public boolean postResume() {
        return false;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return age == candidate.age && salary == candidate.salary && Objects.equals(name, candidate.name) && Objects.equals(position, candidate.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, position, salary);
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
