package com.example.onionarchitecture.interfaces.repositories.data;

import com.example.onionarchitecture.interfaces.repositories.data.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
