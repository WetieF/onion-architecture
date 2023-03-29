package com.example.onionarchitecture.interfaces.repositories;

import com.example.onionarchitecture.domain.employee.model.EmployeeProject;
import com.example.onionarchitecture.domain.sollstunden.model.BeraterSollStunden;
import com.example.onionarchitecture.interfaces.in.rest.controller.dto.SollstundenDto;
import com.example.onionarchitecture.interfaces.repositories.data.entities.Employee;
import com.example.onionarchitecture.interfaces.repositories.data.entities.Sollstunden;

public class DbMapper {

    public static Employee mapToEmployee(EmployeeProject employeeProject) {
        return Employee.builder()
                .id(employeeProject.getId())
                .firstName(employeeProject.getFirstName())
                .lastName(employeeProject.getLastName())
                .age(employeeProject.getAge())
                .build();
    }

    public static EmployeeProject mapToEmployeeProject(Employee employee) {
        return EmployeeProject.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .age(employee.getAge()).build();
    }

    public static Sollstunden mapToSollstunden(BeraterSollStunden beraterSollStunden) {
        return Sollstunden.builder()
                .id(beraterSollStunden.getId())
                .beratername(beraterSollStunden.getBeratername())
                .monat(beraterSollStunden.getMonat())
                .arbeitstage(beraterSollStunden.getArbeitstage())
                .taeglicheArbeitsstunden(beraterSollStunden.getTaeglicheArbeitsstunden())
                .urlaubstage(beraterSollStunden.getUrlaubstage())
                .sollstunden(beraterSollStunden.getSollstunden())
                .schulungstage(beraterSollStunden.getSchulungstage())
                .krankheitstage(beraterSollStunden.getKrankheitstage())
                .sonstiges(beraterSollStunden.getSonstiges())
                .build();
    }

    public static  SollstundenDto mapBeraterSollstundenToSollstundenDto(BeraterSollStunden beraterSollStunden) {
        return SollstundenDto.builder()
                .id(beraterSollStunden.getId())
                .beratername(beraterSollStunden.getBeratername())
                .monat(beraterSollStunden.getMonat())
                .arbeitstage(beraterSollStunden.getArbeitstage())
                .taeglicheArbeitsstunden(beraterSollStunden.getTaeglicheArbeitsstunden())
                .urlaubstage(beraterSollStunden.getUrlaubstage())
                .sollstunden(beraterSollStunden.getSollstunden())
                .schulungstage(beraterSollStunden.getSchulungstage())
                .krankheitstage(beraterSollStunden.getKrankheitstage())
                .sonstiges(beraterSollStunden.getSonstiges())
                .build();
    }

    public static BeraterSollStunden mapSollstundenDtoToBeraterSollstunden(SollstundenDto sollstundenDto) {
        return  new BeraterSollStunden(sollstundenDto.getId(),
                sollstundenDto.getBeratername(),
                sollstundenDto.getMonat(),
                sollstundenDto.getArbeitstage(),
                sollstundenDto.getTaeglicheArbeitsstunden(),
                sollstundenDto.getUrlaubstage(),
                sollstundenDto.getSollstunden(),
                sollstundenDto.getSchulungstage(),
                sollstundenDto.getKrankheitstage(),
                sollstundenDto.getSonstiges());
    }

    public static BeraterSollStunden mapSollstundenToBeraterSollstunden(Sollstunden sollstunden) {
        return BeraterSollStunden.builder()
                .id(sollstunden.getId())
                .beratername(sollstunden.getBeratername())
                .monat(sollstunden.getMonat())
                .arbeitstage(sollstunden.getArbeitstage())
                .taeglicheArbeitsstunden(sollstunden.getTaeglicheArbeitsstunden())
                .urlaubstage(sollstunden.getUrlaubstage())
                .sollstunden(sollstunden.getSollstunden())
                .schulungstage(sollstunden.getSchulungstage())
                .krankheitstage(sollstunden.getKrankheitstage())
                .sonstiges(sollstunden.getSonstiges())
                .build();
    }

}
