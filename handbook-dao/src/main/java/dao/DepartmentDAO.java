package dao;

import entyti.Department;

import java.util.List;

public interface DepartmentDAO {

    public List<Department> getDepartments();

    public void saveDepartment(Department department);

    public void  getDepartment(int id);

    public void  deleteDepartment(int id);


}
