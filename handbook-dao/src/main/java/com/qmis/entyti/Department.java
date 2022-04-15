package com.qmis.entyti;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "department")
@Setter
@Getter
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;


    @Column(name = "parent_id")
    private Integer parentId;


    @Column(name = "name")
    private String name;

    @Column(name = "chief_id")
    private Integer chiefId;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Employee> employeeList;

}
