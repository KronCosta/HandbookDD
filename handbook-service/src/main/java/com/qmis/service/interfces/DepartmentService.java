package com.qmis.service.interfces;

import com.qmis.dto.DepartmentDto;
import com.qmis.entity.Department;
import com.qmis.entity.Employee;

import java.util.List;

public interface DepartmentService {
        Department saveDepartment(DepartmentDto department);
        List<Department> showAllDepartment();
        Department getDepartmentById(long id);
        Department updateDepartmentById(DepartmentDto departmentDto,long id);
        void deleteDepartmentById(long id);

}
