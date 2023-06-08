package com.collections.collections.Service;

import com.collections.collections.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeServiceInterface {
    Employee addEmployee (String firstName, String lastName);
    Employee removeEmployee (String firstName, String lastName);
    Employee findEmployee (String firstName, String lastName);
    Collection<Employee> listAllEmployees();

}
