package com.qmis.controller;

import com.qmis.entity.Department;
import com.qmis.service.DepartmentService;
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
@Tag(name = "Контроллер для работы с отделами")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @Operation(description = "show all departments")
    @GetMapping("/department")
    public List<Department> showAllDepartment() {
        return departmentService.showAllDepartment();
    }

    @Operation(description = "get department by ID")
    @GetMapping("/department{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") long departmentId) {
        return new ResponseEntity<>(departmentService.getDepartmentById(departmentId),HttpStatus.OK);
    }

    @Operation(description = "delete department by ID")
    @DeleteMapping("/department{id}")
    public void deleteDepartmentById(@PathVariable("id") long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
    }

    @Operation(description = "save a new department")
    @PutMapping("/department")
    public ResponseEntity<Department> saveDepartment(Department department) {
        return new ResponseEntity<>(departmentService.saveDepartment(department), HttpStatus.CREATED) ;
    }

    @Operation(description = "update department by ID")
    @PutMapping("/department/{id}")
    public ResponseEntity<Department> updateDepartmentById(@PathVariable("id") long departmentId,@RequestBody Department department){
        return new ResponseEntity<>(departmentService.updateDepartmentById(department,departmentId), HttpStatus.OK);
    }
}
