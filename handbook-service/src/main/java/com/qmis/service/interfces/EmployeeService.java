package com.qmis.service.interfces;

import com.qmis.dto.EmployeeDto;
import com.qmis.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(EmployeeDto employeeDto);
    List<Employee> showAllEmployees();
    Employee getEmployeeById(long id);
    Employee updateEmployeeById(EmployeeDto employeeDto,long id);
    void deleteEmployeeById(long id);

    Employee findByEmail(String email);

}
