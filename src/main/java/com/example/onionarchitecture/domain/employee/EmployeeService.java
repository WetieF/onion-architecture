package com.example.onionarchitecture.domain.employee;

import com.example.onionarchitecture.domain.employee.command.DeleteEmployeeCommand;
import com.example.onionarchitecture.domain.employee.command.EmployeeCommand;
import com.example.onionarchitecture.domain.employee.command.UpdateEmployeeCommnad;
import com.example.onionarchitecture.domain.employee.model.EmployeeProject;
import com.example.onionarchitecture.domain.employee.repositoryaccess.EmployeeEditierenService;
import com.example.onionarchitecture.domain.employee.repositoryaccess.LadenEmployeeService;
import com.example.onionarchitecture.interfaces.repositories.data.entities.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {

    EmployeeEditierenService employeeEditierenService;
    LadenEmployeeService ladenEmployeeService;

    /*public void erstellenEmployee(EmployeeCommand cmd) {
        EmployeeProject employeeProject = cmd.getEmployeeProject();
        if (Objects.nonNull(employeeProject.getId()) && employeeProject.getId() > 0) {
            throw new KeineEmployeeIdErluabtException();
        }
        employeeEditierenService.erstellenEmployee(employeeProject);
    }*/

    public void employeeErstellen(EmployeeCommand cmd) {
        EmployeeProject employeeProject = cmd.getEmployeeProject();
        employeeEditierenService.employeeErstellen(employeeProject);
    }

    public void loescheEmployee(DeleteEmployeeCommand cmd) {
        employeeEditierenService.employeeLoeschen(cmd.getEmplId());
    }

    public void updateEmployee(UpdateEmployeeCommnad updateCommand) {
        employeeEditierenService.updateEmployee(updateCommand.getEmployeeProject());
    }

    public EmployeeProject getEmployeeById(Long id) {

        Employee employeeByEmployeeId = ladenEmployeeService.getEmployeeByEmployeeId(id);

        EmployeeProject employeeProject = EmployeeProject.builder()
                .id(employeeByEmployeeId.getId())
                .firstName(employeeByEmployeeId.getFirstName())
                .lastName(employeeByEmployeeId.getLastName())
                .age(employeeByEmployeeId.getAge()).build();

        return employeeProject;
    }

    public List<EmployeeProject> getEmployeesList() {
        List<EmployeeProject> allEmployees = ladenEmployeeService.getAllEmployees();
        return allEmployees;
    }

}

































