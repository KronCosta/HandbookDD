package com.qmis.service;

import com.qmis.dao.EmployeeRepository;
import com.qmis.entyti.Employee;
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
    public Employee getEmployeeById(Integer id) {

        return employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee","Id" ,id));
    }

    @Override
    public Employee updateEmployeeById(Employee employee,Integer id){
        // check
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee","Id" ,id));
        // update
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmployedDate(employee.getEmployedDate());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setPosition(employee.getPosition());
        existingEmployee.setRole(employee.getRole());
        // save
        employeeRepository.save(existingEmployee);

        return existingEmployee;
    }


    public void deleteEmployeeById(Integer id) {
        employeeRepository.deleteById(id);
    }
}
