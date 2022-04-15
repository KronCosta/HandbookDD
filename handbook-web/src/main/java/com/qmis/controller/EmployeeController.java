package com.qmis.controller;

import com.qmis.entyti.Employee;
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
@RequestMapping("/api")
@Tag(name = "Контроллер для работы с сотрудниками")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Operation(description = "save a new employee | сохранение новых сотрудников")
    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED) ;
    }

    @Operation(description = "show all employees | получения списка всех сотрудников")
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.showAllEmployees();
    }

    @Operation(description = "get employee by ID | получение сотрудника по ID")
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
       return new ResponseEntity<>(employeeService.getEmployeeById(id),HttpStatus.OK);
    }

    @Operation(description = "update employee by ID")
    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@RequestBody Employee employee,@PathVariable Integer id){
        return new ResponseEntity<>(employeeService.updateEmployeeById(employee,id), HttpStatus.OK);
    }

    @Operation(description = "delete employee by ID")
    @DeleteMapping("/employee/{id}")
    public void deleteEmployeeById(@PathVariable Integer id) {
        employeeService.deleteEmployeeById(id);
    }

}
