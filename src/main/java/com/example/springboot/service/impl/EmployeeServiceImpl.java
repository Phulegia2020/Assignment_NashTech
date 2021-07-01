package com.example.springboot.service.impl;

import com.example.springboot.entity.Employee;
import com.example.springboot.repository.EmployeeRepository;
import com.example.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public void setEmployeeRepository(EmployeeRepository employeeRepository)
    {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> retrieveEmployees()
    {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    public Employee getEmployee(Long employeeId)
    {
        Employee emp = employeeRepository.findById(employeeId).get();
        return emp;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee emp = employeeRepository.findById(employeeId).get();

        employeeRepository.delete(emp);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
