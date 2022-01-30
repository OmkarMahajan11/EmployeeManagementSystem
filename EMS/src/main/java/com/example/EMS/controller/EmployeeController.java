package com.example.EMS.controller;

import java.util.List;

import com.example.EMS.exception.ResourceNotFoundException;
import com.example.EMS.model.Employee;
import com.example.EMS.repository.EmployeeRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
  
  private EmployeeRepository employeeRepository;

  public EmployeeController(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @GetMapping
  public List<Employee> getAllEmployees() {
    return employeeRepository.findAll();
  }

  @PostMapping
  public Employee createEmployee(@RequestBody Employee employee) {
    return employeeRepository.save(employee);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
    Employee e = employeeRepository.findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with id: " + id));
    return ResponseEntity.ok(e);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee updateDetails) {
    Employee ue = employeeRepository.findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with id: " + id));
    ue.setFirstName(updateDetails.getFirstName());
    ue.setLastName(updateDetails.getLastName());
    ue.setEmailId(updateDetails.getEmailId());
    employeeRepository.save(ue);
    return ResponseEntity.ok(ue);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id) {
    Employee e = employeeRepository.findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with id: " + id));
    employeeRepository.delete(e);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
