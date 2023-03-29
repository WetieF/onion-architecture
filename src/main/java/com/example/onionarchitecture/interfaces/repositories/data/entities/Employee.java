package com.example.onionarchitecture.interfaces.repositories.data.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @SequenceGenerator(
            name = "EMPLOYEE_ID_GENERATOR",
            sequenceName = "EMPLOYEE_SEQ",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "EMPLOYEE_ID_GENERATOR")
    Long id;

    @Column(length = 64, nullable = false)
    String firstName;

    @Column(length = 64, nullable = false)
    String lastName;

    @Column(length = 10)
    Double age;
}
