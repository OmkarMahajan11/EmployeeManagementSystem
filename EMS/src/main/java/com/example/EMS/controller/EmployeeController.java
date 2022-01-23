package com.example.EMS.controller;

import java.util.List;

import com.example.EMS.model.Employee;
import com.example.EMS.repository.EmployeeRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class EmployeeController {
  
  private EmployeeRepository employeeRepository;

  public EmployeeController(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @GetMapping
  public List<Employee> getAllEmployees() {
    return employeeRepository.findAll();
  }
}
