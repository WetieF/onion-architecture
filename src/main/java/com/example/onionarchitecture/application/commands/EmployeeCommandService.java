package com.example.onionarchitecture.application.commands;

import com.example.onionarchitecture.domain.employee.EmployeeService;
import com.example.onionarchitecture.domain.employee.command.DeleteEmployeeCommand;
import com.example.onionarchitecture.domain.employee.command.EmployeeCommand;
import com.example.onionarchitecture.domain.employee.command.UpdateEmployeeCommnad;
import com.example.onionarchitecture.domain.employee.model.EmployeeProject;
import com.example.onionarchitecture.interfaces.in.rest.controller.dto.EmployeeDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class EmployeeCommandService {

    EmployeeService employeeService;

   /* public void erstellenEmployee(EmployeeDto employeeDto) {
        EmployeeProject employee = createEmployee(employeeDto);
        EmployeeCommand cmd = EmployeeCommand.builder().employeeProject(employee).build();
        employeeService.erstellenEmployee(cmd);}
    private EmployeeProject createEmployee(EmployeeDto employeeDto) {
        EmployeeProject employeeProject = new EmployeeProject(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getAge());
        return employeeProject;
    }*/

    public void employeeErstellen(EmployeeDto employeeDto) {
        EmployeeProject employeeProject = EmployeeProject.builder()
                .id(employeeDto.getId())
                .firstName(employeeDto.getFirstName())
                .lastName(employeeDto.getLastName())
                .age(employeeDto.getAge())
                .build();

        //EmployeeCommand cmd1 = EmployeeCommand.builder().employeeProject(employeeProject).build();
        EmployeeCommand cmd = new EmployeeCommand(employeeProject);
        employeeService.employeeErstellen(cmd);
    }

    public void loescheEmployee(Long id) {
        DeleteEmployeeCommand cmd = new DeleteEmployeeCommand(id);

        employeeService.loescheEmployee(cmd);
    }

    public void updateEmployee(EmployeeDto employeeDto) {
        EmployeeProject employeeProject = EmployeeProject.builder()
                .id(employeeDto.getId())
                .firstName(employeeDto.getFirstName())
                .lastName(employeeDto.getLastName())
                .age(employeeDto.getAge())
                .build();

        UpdateEmployeeCommnad updateCommand = new UpdateEmployeeCommnad(employeeProject);
        employeeService.updateEmployee(updateCommand);
    }

    public EmployeeDto getEmployeeById(Long emplId) {

        EmployeeProject employeeById = employeeService.getEmployeeById(emplId);

        EmployeeDto employeeDto = EmployeeDto.builder()
                .id(employeeById.getId())
                .firstName(employeeById.getFirstName())
                .lastName(employeeById.getLastName())
                .age(employeeById.getAge()).build();

        return employeeDto;
    }

    public List<EmployeeDto> getListEmployees() {
        List<EmployeeProject> employeesList = employeeService.getEmployeesList();

        List<EmployeeDto> employeeDtos = employeesList.stream().map(empl ->
            fromEmplyeeToEmployeeDto(empl)
        ).collect(Collectors.toList());

        return employeeDtos;
    }

    public EmployeeDto fromEmplyeeToEmployeeDto(EmployeeProject employee) {
        return EmployeeDto.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .age(employee.getAge()).build();
    }

}





// ABBA - I Still Have Faith In You

























