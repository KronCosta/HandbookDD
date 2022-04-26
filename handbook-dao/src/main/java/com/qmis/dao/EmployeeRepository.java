package com.qmis.dao;

import com.qmis.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT p FROM Employee p " +
            "WHERE p.email = ?1")
    Optional<Employee> findByEMail(String email);
}
