package com.itc.service;

import com.itc.model.Employee;

public interface EmployeeService {

	Employee authenticateEmployee(String username, String password);

	Employee getEmployeeByUserName(String username, String password);
	 
}
