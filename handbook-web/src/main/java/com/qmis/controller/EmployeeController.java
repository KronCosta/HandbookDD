package com.qmis.controller;

import com.qmis.entity.Employee;
import com.qmis.exception.ResourceNotFoundException;
import com.qmis.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/v1")
@Tag(name = "Контроллер для работы с сотрудниками")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Operation(description = "save a new employee | сохранение новых сотрудников")
    @PostMapping("/employee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED) ;
    }

    @Operation(description = "show all employees | получения списка всех сотрудников")
    @GetMapping("/employee")
    public List<Employee> getAllEmployees() {
        return employeeService.showAllEmployees();
    }

    @Operation(description = "get employee by ID | получение сотрудника по ID")
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) throws ResourceNotFoundException {
       return new ResponseEntity<>(employeeService.getEmployeeById(id),HttpStatus.OK);
    }


    @Operation(description = "update employee by ID")
    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@RequestBody Employee employee,@PathVariable int id){
        return new ResponseEntity<>(employeeService.updateEmployeeById(employee,id), HttpStatus.OK);
    }

    @Operation(description = "delete employee by ID")
    @DeleteMapping("/employee/{id}")
    public void deleteEmployeeById(@PathVariable long id) {
        employeeService.deleteEmployeeById(id);
    }

}
