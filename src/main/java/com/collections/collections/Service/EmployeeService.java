package com.collections.collections.Service;

import com.collections.collections.Employee;
import com.collections.collections.Exception.EmployeeAlreadyAddedException;
import com.collections.collections.Exception.EmployeeNotFoundException;
import com.collections.collections.Exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService implements EmployeeServiceInterface {
    private final Map<String, Employee> employees;
    public EmployeeService() {
        employees = new HashMap<>();
    }
    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = findEmployee(firstName, lastName);
        employees.remove(employee.getFullName());
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> listAllEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }


}
