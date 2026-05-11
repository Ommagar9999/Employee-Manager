package com.omizon.IronManager.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "emp_db")
@Data
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String phone;
    private String email;
}