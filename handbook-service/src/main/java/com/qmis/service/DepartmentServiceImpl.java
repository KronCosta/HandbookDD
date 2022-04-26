package com.qmis.service;

import com.qmis.dao.DepartmentRepository;
import com.qmis.dto.DepartmentDto;
import com.qmis.entity.Department;
import com.qmis.exception.ResourceNotFoundException;
import com.qmis.mapper.DepartmentMapper;
import com.qmis.service.interfces.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    @Override
    public Department saveDepartment(DepartmentDto departmentDto) {
        return departmentRepository.save(departmentMapper.createDtoToModel(departmentDto));
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
    public Department updateDepartmentById(DepartmentDto departmentDto, long id){
        // check
        Department existingDepartment = departmentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Department","Id" ,id));
        // update
        existingDepartment.setName(departmentDto.getName());
        existingDepartment.setParentId(departmentDto.getParentId());
        existingDepartment.setChiefId(departmentDto.getChiefId());
        //save
        departmentRepository.save(existingDepartment);

        return existingDepartment;
    }

    public void deleteDepartmentById(long id) {
        departmentRepository.deleteById(id);
    }


}
