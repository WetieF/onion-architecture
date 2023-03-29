package com.example.onionarchitecture.domain.employee.command;

import com.example.onionarchitecture.domain.employee.model.EmployeeProject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UpdateEmployeeCommnad {
    EmployeeProject employeeProject;
}
