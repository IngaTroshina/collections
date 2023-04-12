package com.collections.collections;

import java.util.Objects;

public class Employee {
    private String fio;
    private int department;
    private int salary;
    private int id;
    private static int counter;

    public Employee(String fio, int department, int salary){
        this.fio = fio;
        this.department = department;
        this.salary = salary;
        id = ++counter;
    }


    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public String getFio() {
        return fio;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && salary == employee.salary && id == employee.id && Objects.equals(fio, employee.fio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fio, department, salary, id);
    }

    @Override
    public String toString() {
        return this.id + ". " + "Сотрудник: " + this.fio + ", отдел: " + this.department + ", оклад: " + this.salary + " руб.";
    }
}

