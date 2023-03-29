package com.example.onionarchitecture.domain.employee.repositoryaccess;

import com.example.onionarchitecture.domain.employee.model.EmployeeProject;
import com.example.onionarchitecture.interfaces.repositories.data.entities.Employee;

import java.util.List;

public interface LadenEmployeeService {
    EmployeeProject ladeEmployee(Long employeeId);
    Employee getEmployeeByEmployeeId(Long employeeId);
    List<EmployeeProject> getAllEmployees();
}


/*
public interface OrderQueryService {
    List<PurchaseOrderSummaryDto> getSaleSummaryGroupByState();
    PurchaseOrderSummaryDto getSaleSummaryByState(String state);
    double getTotalSale();
}*/
