package com.qmis.mapper;

import com.qmis.dto.DepartmentDto;
import com.qmis.entity.Department;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-26T22:57:05+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class DepartmentMapperImpl implements DepartmentMapper {

    @Override
    public Department createDtoToModel(DepartmentDto dto) {
        if ( dto == null ) {
            return null;
        }

        Department department = new Department();

        department.setParentId( dto.getParentId() );
        department.setName( dto.getName() );
        department.setChiefId( dto.getChiefId() );

        return department;
    }
}
