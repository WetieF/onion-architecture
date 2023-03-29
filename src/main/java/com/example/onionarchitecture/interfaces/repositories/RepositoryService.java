package com.example.onionarchitecture.interfaces.repositories;

import com.example.onionarchitecture.domain.exceptions.EmployeeNotFoundException;
import com.example.onionarchitecture.domain.employee.model.EmployeeProject;
import com.example.onionarchitecture.domain.employee.repositoryaccess.EmployeeEditierenService;
import com.example.onionarchitecture.domain.employee.repositoryaccess.LadenEmployeeService;
import com.example.onionarchitecture.domain.exceptions.SollStundenNotFoundException;
import com.example.onionarchitecture.domain.sollstunden.model.BeraterSollStunden;
import com.example.onionarchitecture.domain.sollstunden.repositoryaccess.EditSollstundenService;
import com.example.onionarchitecture.domain.sollstunden.repositoryaccess.LadenSollstundenService;
import com.example.onionarchitecture.interfaces.repositories.data.EmployeeRepository;
import com.example.onionarchitecture.interfaces.repositories.data.SollstundenRepository;
import com.example.onionarchitecture.interfaces.repositories.data.entities.Employee;
import com.example.onionarchitecture.interfaces.repositories.data.entities.Sollstunden;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RepositoryService implements
        EmployeeEditierenService,
        LadenEmployeeService,
        EditSollstundenService,
        LadenSollstundenService {

    EmployeeRepository employeeRepository;
    SollstundenRepository sollstundenRepository;

    @Override
    public void employeeErstellen(EmployeeProject employeeProject) {
        employeeRepository.save(DbMapper.mapToEmployee(employeeProject));
    }

    @Override
    public EmployeeProject ladeEmployee(Long employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        EmployeeProject employeeProject = EmployeeProject.builder()
                .id(employee.get().getId())
                .firstName(employee.get().getFirstName())
                .lastName(employee.get().getLastName())
                .age(employee.get().getAge()).build();

        return employeeProject;
    }

    @Override
   public Employee getEmployeeByEmployeeId(Long employeeId) {

        Optional<Employee> emplOpt = Optional.ofNullable(employeeRepository.findById(employeeId).orElseThrow(
                () -> new EmployeeNotFoundException("Employee with Id " + employeeId + " is not found")));

        Employee employee = Employee.builder()
                .id(emplOpt.get().getId())
                .firstName(emplOpt.get().getFirstName())
                .lastName(emplOpt.get().getLastName())
                .age(emplOpt.get().getAge()).build();
        return employee;
    }

    @Override
    public void employeeLoeschen(Long employeeId) {
        Employee employee = findEmployee(employeeId);
        employeeRepository.delete(employee);
    }

    @Override
    public void updateEmployee(EmployeeProject employeeProject) {
        employeeRepository.save(employeeProject.toEmployee());
    }

    public Employee findEmployee(Long id) {
       return employeeRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Employee not found"));
    }

    @Override
    public List<EmployeeProject> getAllEmployees() {
        List<Employee> allEmployees = employeeRepository.findAll();
        return allEmployees.stream()
                .map(DbMapper::mapToEmployeeProject)
                .collect(Collectors.toList());

    }

    @Override
    public BeraterSollStunden erstellenSollstunden(BeraterSollStunden beraterSollStunden) {
        System.out.println(beraterSollStunden.getId());
        Sollstunden sollstunden = sollstundenRepository.save(DbMapper.mapToSollstunden(beraterSollStunden));
        return DbMapper.mapSollstundenToBeraterSollstunden(sollstunden);
    }

    @Override
    public void deleteSollstunden(Long sollId) {
        sollstundenRepository.deleteById(sollId);
    }

    @Override
    public void updateSollstunden(BeraterSollStunden beraterSollStunden, Long id) {
        sollstundenRepository.findById(id).orElseThrow(
                () -> new SollStundenNotFoundException("Sollstunden with id " + id + " is not found"));

        Sollstunden saveSollstunden = DbMapper.mapToSollstunden(beraterSollStunden);
        saveSollstunden.setId(id);
        sollstundenRepository.save(saveSollstunden);
    }

    @Override
    public List<BeraterSollStunden> getListBeraterSollstunden() {
        return sollstundenRepository.findAll().stream()
                .map(DbMapper::mapSollstundenToBeraterSollstunden).collect(Collectors.toList());
    }

    @Override
    public BeraterSollStunden findByBeraternameAndMonat(String beratername, YearMonth monat) {
        Sollstunden sollstunden = sollstundenRepository.findByBeraternameAndMonat(beratername, monat);
        if (sollstunden == null) {
            return null;
        }
        return DbMapper.mapSollstundenToBeraterSollstunden(sollstunden);
        //return sollstunden.mapSollstundenToBeraterSollstunden();  // vient de Sollstunden
    }

    @Override
    public BeraterSollStunden getBeraterSollstundenById(Long id) {

        Optional<Sollstunden> sollstundenId = Optional.ofNullable(sollstundenRepository.findById(id)
                .orElseThrow(() -> new SollStundenNotFoundException("Sollstunden with " + id + " not found.")));

        BeraterSollStunden beraterSollStunden1 = DbMapper.mapSollstundenToBeraterSollstunden(sollstundenId.get());
        return beraterSollStunden1;
    }

}






























