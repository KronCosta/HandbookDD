package com.qmis.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@Setter
@Getter
@Jacksonized
public class EmployeeDto {

    private String fio;
    private String email;
    private long departmentId;
    private long positionId;

}
