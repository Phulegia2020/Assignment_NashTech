package com.example.springboot.restcontroller;

import com.example.springboot.entity.Employee;
import com.example.springboot.exception.EmployeeException;
import com.example.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees()
    {
        List<Employee> employees = employeeService.retrieveEmployees();
        return employees;
    }

    @GetMapping("/{employeeId}")
    public Employee findEmployee(@PathVariable Long employeeId)
    {
        Employee emp = employeeService.getEmployee(employeeId);
        if (emp == null)
        {
            throw new EmployeeException(employeeId);
        }
        return employeeService.getEmployee(employeeId);
    }

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee)
    {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/{employeeId}")
    public Employee updateEmployee(@PathVariable(name = "employeeId") Long employeeId, @Validated @RequestBody Employee employeeDetails)
    {
        Employee emp = employeeService.getEmployee(employeeId);
        if (emp == null)
        {
            throw new EmployeeException(employeeId);
        }
        else
        {
            emp.setName(employeeDetails.getName());
            emp.setEmail(employeeDetails.getEmail());
            emp.setRole(employeeDetails.getRole());
            employeeService.updateEmployee(emp);
        }
        return emp;
    }

    @DeleteMapping("/{employeeId}")
    public HashMap<String, String> deleteEmployee(@PathVariable(name = "employeeId") Long employeeId)
    {
        Employee emp = employeeService.getEmployee(employeeId);
        if (emp == null)
        {
            throw new EmployeeException(employeeId);
        }
        employeeService.deleteEmployee(employeeId);
        HashMap<String, String> map = new HashMap<>();
        map.put("message", "Delete Succesfully!");
        return map;
    }
}
