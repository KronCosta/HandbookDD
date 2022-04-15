package com.qmis.controller;

import com.qmis.entyti.Department;
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
@RequestMapping("/api/department")
@Tag(name = "Контроллер для работы с отделами")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @Operation(description = "show all departments")
    @GetMapping("/departments")
    public List<Department> showAllDepartment() {
        return departmentService.showAllDepartment();
    }

    @Operation(description = "get department by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Integer id) {
        return new ResponseEntity<>(departmentService.getDepartmentById(id),HttpStatus.OK);
    }

    @Operation(description = "delete department by ID")
    @DeleteMapping("/{id}")
    public void deleteDepartmentById(@PathVariable Integer id) {
        departmentService.deleteDepartmentById(id);
    }

    @Operation(description = "save a new department")
    @PutMapping()
    public ResponseEntity<Department> saveDepartment(Department department) {
        return new ResponseEntity<>(departmentService.saveDepartment(department), HttpStatus.CREATED) ;
    }

    @Operation(description = "update department by ID")
    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartmentById(@PathVariable Integer id,@RequestBody Department department){
        return new ResponseEntity<>(departmentService.updateDepartmentById(department,id), HttpStatus.OK);
    }


}
