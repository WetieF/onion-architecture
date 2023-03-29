package com.example.onionarchitecture.interfaces.in.rest.controller;

import com.example.onionarchitecture.application.commands.EmployeeCommandService;
import com.example.onionarchitecture.interfaces.in.rest.controller.dto.EmployeeDto;
import com.example.onionarchitecture.interfaces.repositories.data.entities.Employee;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/v1/employees")
@AllArgsConstructor
public class EmployeeController {

    EmployeeCommandService employeeCommandService;

    @PostMapping
    public ResponseEntity<Void> erstelleEmployees(@Valid @RequestBody EmployeeDto employeeDto) {
        //employeeCommandService.erstellenEmployee(employeeDto);
        employeeCommandService.employeeErstellen(employeeDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{emplId}")
    public ResponseEntity<Void> loeschenEmployee(@PathVariable Long emplId) {
        employeeCommandService.loescheEmployee(emplId);
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity<Void> updateEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        employeeCommandService.updateEmployee(employeeDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{employeeid}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(value = "employeeid") Long id) {
       return ResponseEntity.ok().body(employeeCommandService.getEmployeeById(id));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> findAllEmployees() {
        List<EmployeeDto> listEmployees = employeeCommandService.getListEmployees();
        return ResponseEntity.ok().body(listEmployees);
    }

}
