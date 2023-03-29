package com.example.onionarchitecture.domain.employee.command;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeleteEmployeeCommand {
    Long emplId;
}
