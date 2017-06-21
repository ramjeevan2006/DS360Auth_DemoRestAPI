/**
 * 
 */
package com.itc.persistence;

import java.util.List;

import com.itc.model.Employee;


/**
 * @author 16945
 *
 */
public interface EmployeePersistence {

	Employee authenticateEmployee(String username, String password);

	Employee getEmployeeByUserName(String username, String password);

	 
	
}
