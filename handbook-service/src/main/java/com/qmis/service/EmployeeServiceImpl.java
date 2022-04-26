package com.qmis.service;

import com.qmis.dao.DepartmentRepository;
import com.qmis.dao.EmployeeRepository;
import com.qmis.dao.PositionRepository;
import com.qmis.dto.EmployeeDto;
import com.qmis.entity.Employee;
import com.qmis.exception.ResourceNotFoundException;
import com.qmis.mapper.EmployeeMapper;
import com.qmis.service.interfces.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    private final PositionRepository positionRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public Employee saveEmployee(EmployeeDto employeeDto) {
        return employeeRepository.save(employeeMapper.createDtoEmployee(employeeDto));
    }

    public List<Employee> showAllEmployees() { return employeeRepository.findAll(); }

    @Override
    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee","Id" ,id));

    }

    @Override
    public Employee updateEmployeeById(EmployeeDto employeeDto,long id){
        // check
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee","Id" ,id));
        // update
        existingEmployee.setFio(employeeDto.getFio());;
        existingEmployee.setEmail(employeeDto.getEmail());
        existingEmployee.setDepartment(departmentRepository.getById(employeeDto.getDepartmentId()));
        existingEmployee.setPosition(positionRepository.getById(employeeDto.getPositionId()));
        // save
        employeeRepository.save(existingEmployee);

        return existingEmployee;
    }


    public void deleteEmployeeById(long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findByEmail(String email) {
       return employeeRepository.findByEMail(email).orElseThrow(() ->
               new ResourceNotFoundException("Employee","email", email)) ;
    }
}
