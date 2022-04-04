package service;

import entyti.Department;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repository.DepartmentRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    public List<Department> showAllDepartment() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(int id) {
        return departmentRepository.getById(id);
    }

    public void deleteDepartmentById(int id) {
        departmentRepository.deleteById(id);
    }

    public void saveDepartment(Department department) {
        departmentRepository.save(department);

    }
}
