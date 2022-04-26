package com.qmis.controller;

import com.qmis.dto.EmployeeDto;
import com.qmis.entity.Employee;
import com.qmis.exception.ResourceNotFoundException;
import com.qmis.service.interfces.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/v1/employees")
@Tag(name = "Контроллер для работы с сотрудниками")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @Operation(description = "save a new employee | сохранение нового сотрудника")
    @PostMapping
    @PreAuthorize("hasAuthority('user:moderate')")
    public ResponseEntity<Employee> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(employeeService.saveEmployee(employeeDto));
    }

    @Operation(description = "show all employees | получения списка всех сотрудников")
    @GetMapping
    @PreAuthorize("hasAuthority('user:read,search')")
    public List<Employee> getAllEmployees() {
        return employeeService.showAllEmployees();
    }

    @Operation(description = "get employee by ID | получение сотрудника по ID")
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('user:read,search')")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(employeeService.getEmployeeById(id));
    }


    @Operation(description = "update employee by ID | обновление данных сотрудника по ID")
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('user:moderate')")
    public ResponseEntity<Employee> updateEmployeeById(@RequestBody EmployeeDto employeeDto, @PathVariable int id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(employeeService.updateEmployeeById(employeeDto, id));
    }

    @Operation(description = "delete employee by ID | удаление сотрудника по ID")
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('user:moderate')")
    public void deleteEmployeeById(@PathVariable long id) {
        employeeService.deleteEmployeeById(id);
    }

}
