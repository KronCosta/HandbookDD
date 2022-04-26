package com.qmis.mapper;

import com.qmis.dto.EmployeeDto;
import com.qmis.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    @Mapping(source = "departmentId", target = "department.id")
    @Mapping(source = "positionId", target = "position.id")
    Employee createDtoEmployee(EmployeeDto employeeDto);
}
