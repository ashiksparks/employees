package com.siscon.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siscon.employees.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
