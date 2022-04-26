package com.qmis.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
//todo: на случай передачи id в Dto проверять соответсвие
@Getter
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NotMatchingIdException extends RuntimeException {
    private final long bodyId;
    private final long pathId;

    public NotMatchingIdException(long bodyId, long pathId) {
        super(String.format("Id in body '%n' not equals id in path '%n'",bodyId ,pathId));
        this.bodyId = bodyId;
        this.pathId = pathId;

    }
}
