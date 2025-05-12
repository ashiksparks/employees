package com.siscon.employees.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class EmployeeTest {
	@Test
	void testEmployeeBuilderAndFields() {
		LocalDate birthDate = LocalDate.of(1990, 5, 20);

		Employee employee = Employee.builder().id(1L).firstName("Juan").secondName("Carlos").paternalSurname("Ramirez")
				.maternalSurname("Gomez").age(34).sex("M").dateBirth(birthDate).jobTitle("Tech Lead").build();

		assertEquals("Juan", employee.getFirstName());
		assertEquals("Carlos", employee.getSecondName());
		assertEquals("Ramirez", employee.getPaternalSurname());
		assertEquals("Gomez", employee.getMaternalSurname());
		assertEquals(34, employee.getAge());
		assertEquals("M", employee.getSex());
		assertEquals(birthDate, employee.getDateBirth());
		assertEquals("Tech Lead", employee.getJobTitle());
	}
}
