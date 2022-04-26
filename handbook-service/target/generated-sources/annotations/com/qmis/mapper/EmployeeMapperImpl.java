package com.qmis.mapper;

import com.qmis.dto.EmployeeDto;
import com.qmis.entity.Department;
import com.qmis.entity.Employee;
import com.qmis.entity.Position;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-26T22:57:05+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public Employee createDtoEmployee(EmployeeDto employeeDto) {
        if ( employeeDto == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setDepartment( employeeDtoToDepartment( employeeDto ) );
        employee.setPosition( employeeDtoToPosition( employeeDto ) );
        employee.setFio( employeeDto.getFio() );
        employee.setEmail( employeeDto.getEmail() );

        return employee;
    }

    protected Department employeeDtoToDepartment(EmployeeDto employeeDto) {
        if ( employeeDto == null ) {
            return null;
        }

        Department department = new Department();

        department.setId( employeeDto.getDepartmentId() );

        return department;
    }

    protected Position employeeDtoToPosition(EmployeeDto employeeDto) {
        if ( employeeDto == null ) {
            return null;
        }

        Position position = new Position();

        position.setId( employeeDto.getPositionId() );

        return position;
    }
}
