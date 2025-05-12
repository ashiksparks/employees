package com.siscon.employees.service;

import static com.siscon.employees.util.Util.NOT_FOUND_VALUE;
import static com.siscon.employees.util.Util.OK_VALUE;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.siscon.employees.exception.CustomResourceException;
import com.siscon.employees.model.Employee;
import com.siscon.employees.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

	@Transactional(readOnly = true)
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Transactional
	public int deleteEmployee(Long id) {
		try {
			if (employeeRepository.existsById(id)) {
				employeeRepository.deleteById(id);
				logger.info("Employee with ID {} ​​successfully deleted", id);
				return OK_VALUE;
			}
		} catch (Exception e) {
			throw new CustomResourceException(e.getLocalizedMessage());
		}
		logger.warn("Attempt to delete employee with ID: {}", id);
		return NOT_FOUND_VALUE;
	}

	@Transactional
	public int updateEmployee(Long id, Employee updatedEmployee) {
		Optional<Employee> existingEmployee = employeeRepository.findById(id);
		if (existingEmployee.isEmpty()) {
			logger.warn("Attempt to updated employee with ID: {}", id);
			return NOT_FOUND_VALUE;
		}

		Employee employee = existingEmployee.get();
		employee.setSecondName(updatedEmployee.getSecondName());
		employee.setAge(updatedEmployee.getAge());
		employee.setJobTitle(updatedEmployee.getJobTitle());

		try {
			employeeRepository.save(employee);
			logger.info("Employee with ID {} ​​successfully updated", id);
		} catch (Exception e) {
			throw new CustomResourceException(e.getLocalizedMessage());
		}
		return OK_VALUE;
	}

	@Transactional
	public List<Employee> createEmployees(List<Employee> employees) {
		try {
			logger.info("The employees were successfully recorded");
			return employeeRepository.saveAll(employees);
		} catch (Exception e) {
			throw new CustomResourceException(e.getLocalizedMessage());
		}
	}
}
