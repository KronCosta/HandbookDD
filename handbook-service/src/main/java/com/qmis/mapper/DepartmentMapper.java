package com.qmis.mapper;

import com.qmis.dto.DepartmentDto;
import com.qmis.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    Department createDtoToModel(DepartmentDto dto);

}
