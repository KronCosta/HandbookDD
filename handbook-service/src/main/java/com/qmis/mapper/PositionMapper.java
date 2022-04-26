package com.qmis.mapper;

import com.qmis.dto.PositionDto;
import com.qmis.entity.Position;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PositionMapper {
    Position createDtoPosition(PositionDto positionDto);
}
