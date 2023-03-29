package com.example.onionarchitecture.interfaces.in.rest.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    Long id;

    @NotBlank(message = "Firstname muss angegeben werden.")
    String firstName;

    @NotBlank(message = "Firstname muss angegeben werden.")
    String lastName;

    Double age;
}
