package com.siscon.employees.controller;

import static com.siscon.employees.util.Util.MSG_EMPLOYEE_NOT_FOUND;
import static com.siscon.employees.util.Util.NOT_FOUND_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siscon.employees.model.Employee;
import com.siscon.employees.response.EmployeeResponse;
import com.siscon.employees.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/employees")
@CrossOrigin("*")
@Tag(name = "Employee", description = "CRUD operations related to the employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/getAllEmployees")
	@Operation(summary = "Employee list", description = "Retrieves all registered employees")
	public EmployeeResponse getAllEmployees() {
		return new EmployeeResponse(HttpStatus.OK.name(), employeeService.getAllEmployees());
	}

	@DeleteMapping("/deleteEmployee/{id}")
	@Operation(summary = "Delete employee", description = "Delete employee by Id")
	public EmployeeResponse deleteEmployee(@PathVariable(required = true) Long id) {
		int response = employeeService.deleteEmployee(id);

		if (response == NOT_FOUND_VALUE) {
			return new EmployeeResponse(HttpStatus.NOT_FOUND.name(), MSG_EMPLOYEE_NOT_FOUND);
		}
		return new EmployeeResponse(HttpStatus.OK.name(), "The employee was eliminated");
	}

	@PutMapping("/updateEmployee/{id}")
	@Operation(summary = "Update employee", description = "Update employee by Id")
	public EmployeeResponse updateEmployee(@PathVariable(required = true) Long id, @RequestBody Employee updatedEmployee) {
		int response = employeeService.updateEmployee(id, updatedEmployee);
		if (response == NOT_FOUND_VALUE) {
			return new EmployeeResponse(HttpStatus.NOT_FOUND.name(), MSG_EMPLOYEE_NOT_FOUND);
		}
		return new EmployeeResponse(HttpStatus.OK.name(), "The employee was updated");
	}

	@PostMapping("/createEmployees")
	@Operation(summary = "Create employees", description = "Insert one or more employees")
	public EmployeeResponse createEmployees(@RequestBody List<Employee> employees) {
		return new EmployeeResponse(HttpStatus.CREATED.name(), employeeService.createEmployees(employees));
	}
}
