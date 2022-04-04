package controller;

import entyti.Department;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import repository.DepartmentRepository;
import service.DepartmentService;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/handbook/v1/")
@Tag(name = "Конетроллео для оработы с отделами")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("departments")
    public List<Department> showAllDepartment() {
        return departmentService.showAllDepartment();
    }

    @GetMapping("department/{id}")
    public Department getDepartmentById(@PathVariable int id) {
        return departmentService.getDepartmentById(id);
    }

    @DeleteMapping("department/{id}}")
    public void deleteDepartmentById(@PathVariable int id) {
        departmentService.deleteDepartmentById(id);
    }

    @PutMapping("department")
    public void saveDepartment(Department department) {
        departmentService.saveDepartment(department);

    }


}
