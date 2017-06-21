package com.itc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itc.model.Employee;
import com.itc.persistence.EmployeePersistence;

@Component
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeePersistence employeePersistence;

	@Override
	public Employee authenticateEmployee(String username, String password) {
		// TODO Auto-generated method stub
		return employeePersistence.authenticateEmployee(username,password);
	}

	@Override
	public Employee getEmployeeByUserName(String username, String password) {
		// TODO Auto-generated method stub
		return employeePersistence.getEmployeeByUserName(username, password);
	}


}
