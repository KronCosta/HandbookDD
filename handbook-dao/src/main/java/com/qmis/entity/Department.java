package com.qmis.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "department")
@Jacksonized
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "parent_id")
    private long parentId;

    @Column(name = "name")
    private String name;

    @Column(name = "chief_id")
    private long chiefId;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Employee> employeeList;
}
