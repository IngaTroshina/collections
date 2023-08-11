package com.collections.collections.Service;

import com.collections.collections.Employee;
import com.collections.collections.Exception.EmployeeAlreadyAddedException;
import com.collections.collections.Exception.EmployeeNotFoundException;
import com.collections.collections.Exception.InvalidNameException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmployeeServiceTest {
    private EmployeeServiceInterface employeeService = new EmployeeService();

    @Test
    public void addEmployeeTest(){
        Employee employee = employeeService.addEmployee("Ivan", "Ivanov");

        Employee newEmployee = employeeService.findEmployee("Ivan", "Ivanov");
        assertEquals(employee, newEmployee);
    }

    @Test
    public void employeeAlreadyAddedExceptionTest(){
        Employee employee = employeeService.addEmployee("Ivan", "Ivanov");
        assertThrows(EmployeeAlreadyAddedException.class,() -> employeeService.addEmployee("Ivan", "Ivanov"));
    }

    @Test
    public void removeEmployeeTest(){
        Employee employee = employeeService.addEmployee("Ivan", "Ivanov");
        employeeService.removeEmployee("Ivan", "Ivanov");
        assertThrows(EmployeeNotFoundException.class,() -> employeeService.findEmployee("Ivan", "Ivanov"));
    }
    @Test
    public void validateTest(){
        assertThrows(InvalidNameException.class,() -> employeeService.addEmployee("E@or", "Egorov1111"));
    }
}
