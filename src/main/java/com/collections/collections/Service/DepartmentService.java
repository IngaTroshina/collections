package com.collections.collections.Service;

import com.collections.collections.Employee;
import com.collections.collections.Exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentService implements DepartmentServiceInterface{
    private final EmployeeServiceInterface employeeService;

    public DepartmentService(EmployeeServiceInterface employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findEmployeeMaxSalary(Integer departmentId) {
        return employeeService.listAllEmployees()
                .stream()
                .filter(employee -> Objects.equals(employee.getDepartmentId(), departmentId))
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee findEmployeeMinSalary(Integer departmentId) {
        return employeeService.listAllEmployees()
                .stream()
                .filter(employee -> Objects.equals(employee.getDepartmentId(), departmentId))
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Collection<Employee> listAllEmployeesInDepartment(Integer departmentId) {
        return employeeService.listAllEmployees()
                .stream()
                .filter(employee -> Objects.equals(employee.getDepartmentId(), departmentId))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> listAllEmployeesByDepartment() {
        return employeeService.listAllEmployees()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }
}
