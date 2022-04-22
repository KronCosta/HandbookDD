package com.qmis.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employee")
@Getter
@Setter
@Accessors(chain = true)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "fio", length = 50, nullable = false)
    private String fio;

    @Column(name = "emp_date", nullable = false)
    private LocalDate employedDate;

    @Column(name = "email", length = 50, unique = true)
    private String email;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "position_id", nullable = false, updatable = false)
    private Position position;

}
