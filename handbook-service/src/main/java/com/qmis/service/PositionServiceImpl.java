package com.qmis.service;

import com.qmis.dao.PositionRepository;
import com.qmis.dto.PositionDto;
import com.qmis.entity.Position;
import com.qmis.exception.ResourceNotFoundException;
import com.qmis.mapper.PositionMapper;
import com.qmis.service.interfces.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;
    private final PositionMapper positionMapper;


    @Override
    public Position savePosition(PositionDto positionDto) {
        return positionRepository.save(positionMapper.createDtoPosition(positionDto));
    }

    @Override
    public List<Position> showAllPosition() {
        return positionRepository.findAll();
    }

    @Override
    public Position getPositionById(long id) {
        return positionRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Position", "Id", id));
    }

    @Override
    public Position updatePositionById(PositionDto positionDto, long id) {
        Position existingPosition = positionRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Position", "Id", id));
        existingPosition.setName(positionDto.getName());
        return positionRepository.save(existingPosition);
    }

    @Override
    public void deletePositionById(long id) {
        positionRepository.deleteById(id);
    }
}
