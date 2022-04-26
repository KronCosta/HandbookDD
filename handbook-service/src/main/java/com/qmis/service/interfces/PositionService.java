package com.qmis.service.interfces;

import com.qmis.dto.PositionDto;
import com.qmis.entity.Position;

import java.util.List;

public interface PositionService {

    Position savePosition(PositionDto positionDto);
    List<Position> showAllPosition();
    Position getPositionById(long id);
    Position updatePositionById(PositionDto positionDto,long id);
    void deletePositionById(long id);
}
