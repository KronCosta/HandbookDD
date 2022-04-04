package dao.impl;

import dao.DepartmentDAO;
import entyti.Department;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Department> getDepartments() {

        Session session = entityManager.unwrap(Session.class);
        List<Department> departments = session.createQuery("from Department", Department.class).getResultList();
        return departments;
    }

    @Override
    public void saveDepartment(Department department) {

    }

    @Override
    public void getDepartment(int id) {

    }

    @Override
    public void deleteDepartment(int id) {

    }
}
