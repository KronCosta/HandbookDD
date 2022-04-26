package com.qmis.controller;

import com.qmis.dto.PositionDto;
import com.qmis.entity.Position;
import com.qmis.exception.ResourceNotFoundException;
import com.qmis.service.interfces.PositionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/v1/positions")
@Tag(name = "Контроллер для работы с должностями")
@RequiredArgsConstructor
public class PositionController {

    private final PositionService positionService;

    @Operation(description = "save a new employee | сохранение новой должности")
    @PostMapping
    @PreAuthorize("hasAuthority('user:moderate')")
    public ResponseEntity<Position> savePosition(@RequestBody PositionDto positionDto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(positionService.savePosition(positionDto));
    }

    @Operation(description = "show all positions | получения списка всех должномтей")
    @GetMapping
    @PreAuthorize("hasAuthority('user:moderate')")
    public List<Position> getAllPositions() {
        return positionService.showAllPosition();
    }

    @Operation(description = "get position by ID | получение должности по ID")
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('user:moderate')")
    public ResponseEntity<Position> getPositionById(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(positionService.getPositionById(id));
    }


    @Operation(description = "update position by ID / обновление должности по ID")
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('user:moderate')")
    public ResponseEntity<Position> updatePositionById(@RequestBody PositionDto positionDto, @PathVariable int id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(positionService.updatePositionById(positionDto, id));
    }

    @Operation(description = "delete position by ID / удаление должности по ID")
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('user:administrate')")
    public void deletePositionById(@PathVariable long id) {
        positionService.deletePositionById(id);
    }
}
