package com.qmis.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@Setter
@Getter
@Jacksonized
public class DepartmentDto {

    private long parentId;
    private String name;
    private long chiefId;

}
