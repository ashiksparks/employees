package com.siscon.employees.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.siscon.employees.model.Employee;
import com.siscon.employees.repository.EmployeeRepository;

class EmployeeServiceTest {

	@Mock
	private EmployeeRepository employeeRepository;
	@InjectMocks
	private EmployeeService employeeService;

	private static final int NOT_FOUND_VALUE = 0;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testGetAllEmployees() {
		Employee emp = new Employee(9L, "Senaida", "Blanca", "Garza", "Morales", 25, "F", LocalDate.of(19989, 5, 20), "Scrum master");
		when(employeeRepository.findAll()).thenReturn(Collections.singletonList(emp));

		List<Employee> result = employeeService.getAllEmployees();

		assertEquals(1, result.size());
		verify(employeeRepository, times(1)).findAll();
	}

	@Test
	void testDeleteEmployeeExists() {
		Long id = 1L;
		when(employeeRepository.existsById(id)).thenReturn(true);
		doNothing().when(employeeRepository).deleteById(id);

		int result = employeeService.deleteEmployee(id);

		assertEquals(1, result);
		verify(employeeRepository).existsById(id);
		verify(employeeRepository).deleteById(id);
	}

	@Test
	void testDeleteEmployeeNotFound() {
		Long id = 11L;
		when(employeeRepository.existsById(id)).thenReturn(false);

		int result = employeeService.deleteEmployee(id);
		assertNotEquals(NOT_FOUND_VALUE, result);
	}

	@Test
	void testUpdateEmployeeExists() {
		Long id = 1L;
		Employee existing = new Employee(9L, "Senaida", "Blanca", "Garza", "Morales", 25, "F", LocalDate.of(19989, 5, 20), "Scrum master");
		Employee updated = new Employee(9L, "Senaida", "", "Garza", "Morales", 30, "F", LocalDate.of(19989, 5, 20),
				"Sr. Scrum master");

		when(employeeRepository.findById(id)).thenReturn(Optional.of(existing));
		when(employeeRepository.save(any(Employee.class))).thenReturn(existing);

		int result = employeeService.updateEmployee(id, updated);

		assertEquals(1, result);
		verify(employeeRepository).findById(id);
		verify(employeeRepository).save(existing);
	}

	@Test
	void testUpdateEmployeeNotFound() {
		Long id = 404L;
		when(employeeRepository.findById(id)).thenReturn(Optional.empty());

		int result = employeeService.updateEmployee(id, new Employee());

		assertNotEquals(NOT_FOUND_VALUE, result);
		verify(employeeRepository).findById(id);
		verify(employeeRepository, never()).save(any());
	}

	@Test
	void testCreateEmployees() {
		List<Employee> input = Arrays.asList(new Employee(9L, "Senaida", "Blanca", "Garza", "Morales", 25, "F", LocalDate.of(19989, 5, 20), "Scrum master"));
		when(employeeRepository.saveAll(input)).thenReturn(input);

		List<Employee> saved = employeeService.createEmployees(input);

		assertEquals(1, saved.size());
		verify(employeeRepository, times(1)).saveAll(input);
	}
}
