package com.qmis.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.qmis.entity.enums.Role;
import com.qmis.entity.enums.Status;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.jackson.Jacksonized;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@Getter
@Setter
@Accessors(chain = true)
@Jacksonized
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "fio", nullable = false)
    private String fio;


    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "status", columnDefinition = "enum(''ACTIVE, 'BANNED')")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "role" , columnDefinition = "enum('USER', 'MODERATOR', 'ADMIN')")
    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "position_id")
    private Position position;
}
