package com.collections.collections.Controller;

import com.collections.collections.Employee;
import com.collections.collections.Service.DepartmentServiceInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentServiceInterface departmentService;
    public DepartmentController(DepartmentServiceInterface departmentService){
        this.departmentService = departmentService;
    }
    @GetMapping("/max-salary")
    public Employee findEmployeeMaxSalary(@RequestParam("departmentId") Integer departmentId){
        return departmentService.findEmployeeMaxSalary(departmentId);
    }
    @GetMapping("/min-salary")
    public Employee findEmployeeMinSalary(@RequestParam("departmentId") Integer departmentId){
        return departmentService.findEmployeeMinSalary(departmentId);
    }
    @GetMapping(value = "/all", params = "departmentId")
    public Collection<Employee> listAllEmployeesInDepartment(@RequestParam("departmentId") Integer departmentId){
        return departmentService.listAllEmployeesInDepartment(departmentId);
    }
    @GetMapping("/all")
    public Map<Integer, List<Employee>> listAllEmployeesByDepartment() {
        return departmentService.listAllEmployeesByDepartment();
    }
}
