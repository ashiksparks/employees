package com.siscon.employees.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponse {
	private String result;
	private String message;
	private Object data;

	public EmployeeResponse(String result, Object data) {
		super();
		this.result = result;
		this.data = data;
	}

	public EmployeeResponse(String result, String message) {
		super();
		this.result = result;
		this.message = message;
	}

}
