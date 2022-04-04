package service;

import entyti.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repository.EmployeeRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id){
        return employeeRepository.getById(id);
    }

    public void deleteEmployeeById(int id){
        employeeRepository.deleteById(id);
    }

    public void saveEmployee(Employee employee){
        employeeRepository.save(employee);
    }

}
