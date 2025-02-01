package com.optimagrowth.license.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.Data;

@Entity
@Table(name = "person")
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String major;
    private String dept;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    private String phone;

    @Column(unique = true)
    private String email;
}
