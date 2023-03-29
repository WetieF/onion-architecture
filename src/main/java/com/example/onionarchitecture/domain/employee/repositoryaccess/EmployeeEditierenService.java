package com.example.onionarchitecture.domain.employee.repositoryaccess;

import com.example.onionarchitecture.domain.employee.model.EmployeeProject;

public interface EmployeeEditierenService {
    //void erstellenEmployee(EmployeeProject employeeProject);
    void employeeLoeschen(Long employeeId);
    void updateEmployee(EmployeeProject employeeProject);
    void employeeErstellen(EmployeeProject employeeProject);
}


/*
public interface OrderCommandService {
    void createOrder(int userIndex, int productIndex);
    void cancelOrder(long orderId);
}*/
