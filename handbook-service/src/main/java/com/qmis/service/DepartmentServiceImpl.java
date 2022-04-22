package com.qmis.service;

import com.qmis.dao.DepartmentRepository;
import com.qmis.entity.Department;
import com.qmis.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DepartmentServiceImpl implements DepartmentService {


    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public List<Department> showAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(long id) {
        return departmentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Department","Id" ,id));
    }

    @Override
    public Department updateDepartmentById(Department department, long id){
        // check
        Department existingDepartment = departmentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Department","Id" ,id));
        // update
        existingDepartment.setName(department.getName());
        existingDepartment.setParentId(department.getParentId());
        existingDepartment.setChiefId(department.getChiefId());
        existingDepartment.setEmployeeList(department.getEmployeeList());
        //save
        departmentRepository.save(existingDepartment);

        return existingDepartment;
    }

    public void deleteDepartmentById(long id) {
        departmentRepository.deleteById(id);
    }

}
