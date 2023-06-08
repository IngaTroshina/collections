package com.collections.collections.Service;

import com.collections.collections.Employee;
import com.collections.collections.Exception.EmployeeAlreadyAddedException;
import com.collections.collections.Exception.EmployeeNotFoundException;
import com.collections.collections.Exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceInterface {
    private final List<Employee> employees;
    public EmployeeService() {
        employees = new ArrayList<>();
    }
    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = findEmployee(firstName, lastName);
        employees.remove(employee);
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public List<Employee> listAllEmployees() {
        return employees;
    }


}
