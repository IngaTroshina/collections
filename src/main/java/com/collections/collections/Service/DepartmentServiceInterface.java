package com.collections.collections.Service;

import com.collections.collections.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentServiceInterface {
    Employee findEmployeeMaxSalary(Integer departmentId);
    Employee findEmployeeMinSalary(Integer departmentId);
    Collection<Employee> listAllEmployeesInDepartment(Integer departmentId);
    Map<Integer, List<Employee>> listAllEmployeesByDepartment();
}
