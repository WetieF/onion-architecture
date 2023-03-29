package com.example.onionarchitecture.domain.employee.model;

import com.example.onionarchitecture.domain.exceptions.KeinFirstUndLastNameException;
import com.example.onionarchitecture.domain.exceptions.AgeException;
import com.example.onionarchitecture.interfaces.repositories.data.entities.Employee;
import lombok.*;
import org.springframework.util.StringUtils;

@Value
@Builder
public class EmployeeProject {
    Long id;
    @NonNull String firstName;
    @NonNull String lastName;
    @NonNull Double age;

    public EmployeeProject(Long id, String firstName, String lastName, Double age) {

        if (!StringUtils.hasText(firstName) && !StringUtils.hasText(lastName)) {
            throw new KeinFirstUndLastNameException();
        }

        if (age < 0 || age > 200) {
            throw new AgeException();
        }

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Employee toEmployee() {
        return Employee.builder()
                .id(getId())
                .firstName(getFirstName())
                .lastName(getLastName())
                .age(getAge())
                .build();
    }
}






























