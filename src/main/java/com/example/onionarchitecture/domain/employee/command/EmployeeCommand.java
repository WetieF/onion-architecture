package com.example.onionarchitecture.domain.employee.command;

import com.example.onionarchitecture.domain.employee.model.EmployeeProject;
import lombok.*;

//@Value
@Builder  //Using @Builder can help reduce the amount of boilerplate code required to create instances
          //of a class, and can make your code more readable and maintainable.
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeCommand {
    EmployeeProject employeeProject;

}
