package com.siscon.employees.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.siscon.employees.model.Employee;
import com.siscon.employees.response.EmployeeResponse;
import com.siscon.employees.service.EmployeeService;

class EmployeeControllerTest {
	@Mock
	private EmployeeService employeeService;

	@InjectMocks
	private EmployeeController employeeController;

	private static final int NOT_FOUND_VALUE = 0;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testGetAllEmployees() {
		Employee emp = Employee.builder().id(1L).firstName("Nayeli").secondName("Karen").paternalSurname("Beltran")
				.maternalSurname("Flores").age(20).sex("F").dateBirth(LocalDate.of(1995, 5, 20)).jobTitle("QA").build();

		List<Employee> mockList = Collections.singletonList(emp);
		when(employeeService.getAllEmployees()).thenReturn(mockList);

		EmployeeResponse response = employeeController.getAllEmployees();

		assertNotNull(response);
		assertEquals("OK", response.getResult());

		verify(employeeService, times(1)).getAllEmployees();
	}

	@Test
	void testDeleteEmployeeSuccess() {
		Long employeeId = 1L;

		when(employeeService.deleteEmployee(employeeId)).thenReturn(1);

		EmployeeResponse response = employeeController.deleteEmployee(employeeId);

		assertNotNull(response);
		verify(employeeService, times(1)).deleteEmployee(employeeId);
	}

	@Test
	void testDeleteEmployeeNotFound() {
		Long employeeId = 11L;

		when(employeeService.deleteEmployee(employeeId)).thenReturn(NOT_FOUND_VALUE);

		EmployeeResponse response = employeeController.deleteEmployee(employeeId);

		assertNotNull(response);
		verify(employeeService, times(1)).deleteEmployee(employeeId);
	}

	@Test
	void testUpdateEmployeeSuccess() {
		Long employeeId = 1L;
		Employee updatedEmployee = Employee.builder().id(1L).firstName("Nayeli").secondName("Karen")
				.paternalSurname("Beltran").maternalSurname("Flores").age(20).sex("F")
				.dateBirth(LocalDate.of(1995, 5, 20)).jobTitle("QA").build();

		when(employeeService.updateEmployee(employeeId, updatedEmployee)).thenReturn(1);

		EmployeeResponse response = employeeController.updateEmployee(employeeId, updatedEmployee);

		assertNotNull(response);
		verify(employeeService, times(1)).updateEmployee(employeeId, updatedEmployee);
	}

	@Test
	void testUpdateEmployeeNotFound() {
		Long employeeId = 11L;
		Employee updatedEmployee = new Employee();

		when(employeeService.updateEmployee(employeeId, updatedEmployee)).thenReturn(NOT_FOUND_VALUE);

		EmployeeResponse response = employeeController.updateEmployee(employeeId, updatedEmployee);

		assertNotNull(response);
		verify(employeeService, times(1)).updateEmployee(employeeId, updatedEmployee);
	}

	@Test
	void testCreateEmployeesSuccess() {
		Employee emp1 = Employee.builder().id(1L).firstName("Nayeli").secondName("Karen").paternalSurname("Beltran")
				.maternalSurname("Flores").age(20).sex("F").dateBirth(LocalDate.of(1995, 5, 20)).jobTitle("QA").build();

		Employee emp2 = Employee.builder().id(7L).firstName("Ana").secondName("Luisa").paternalSurname("Beltran")
				.maternalSurname("Flores").age(20).sex("F").dateBirth(LocalDate.of(1995, 5, 20)).jobTitle("QA").build();

		List<Employee> inputList = Arrays.asList(emp1, emp2);

		when(employeeService.createEmployees(inputList)).thenReturn(inputList);

		EmployeeResponse response = employeeController.createEmployees(inputList);

		assertNotNull(response);
		assertTrue(response.getData() instanceof List);
		verify(employeeService, times(1)).createEmployees(inputList);
	}
}
