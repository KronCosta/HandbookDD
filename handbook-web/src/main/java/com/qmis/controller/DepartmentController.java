package com.qmis.controller;

import com.qmis.dto.DepartmentDto;
import com.qmis.entity.Department;
import com.qmis.service.interfces.DepartmentService;
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
@RequestMapping("/api/v1/departments")
@Tag(name = "Контроллер для работы с отделами")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @Operation(description = "show all departments")
    @GetMapping
    @PreAuthorize("hasAuthority('user:read,search')")
    public List<Department> showAllDepartment() {
        return departmentService.showAllDepartment();
    }

    @Operation(description = "get department by ID")
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('user:read,search')")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") long departmentId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(departmentService.getDepartmentById(departmentId));
    }

    @Operation(description = "delete department by ID")
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('user:administrate')")
    public void deleteDepartmentById(@PathVariable("id") long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
    }

    @Operation(description = "save a new department")
    @PostMapping
    @PreAuthorize("hasAuthority('user:moderate')")
    public ResponseEntity<Department> saveDepartment(@RequestBody DepartmentDto departmentDto) {
        return  ResponseEntity
                .status(HttpStatus.CREATED)
                .body(departmentService.saveDepartment(departmentDto));
    }

    @Operation(description = "update department by ID")
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('user:moderate')")
    public ResponseEntity<Department> updateDepartmentById(@PathVariable("id") long departmentId, @RequestBody DepartmentDto departmentDto) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(departmentService.updateDepartmentById(departmentDto, departmentId));
    }
}
