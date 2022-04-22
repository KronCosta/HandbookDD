package com.qmis.service;

import com.qmis.dao.EmployeeRepository;
import com.qmis.entity.Employee;
import com.qmis.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> showAllEmployees() { return employeeRepository.findAll(); }

    @Override
    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee","Id" ,id));

    }

    @Override
    public Employee updateEmployeeById(Employee employee,long id){
        // check
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee","Id" ,id));
        // update
        existingEmployee.setFio(employee.getFio());;
        existingEmployee.setEmployedDate(employee.getEmployedDate());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setPosition(employee.getPosition());
        // save
        employeeRepository.save(existingEmployee);

        return existingEmployee;
    }


    public void deleteEmployeeById(long id) {
        employeeRepository.deleteById(id);
    }
}
