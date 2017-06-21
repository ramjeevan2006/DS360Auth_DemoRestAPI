package com.itc.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.itc.model.Employee;

@Transactional
@Component
public class EmployeePersistenceImpl implements EmployeePersistence {

	@PersistenceContext
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public Employee authenticateEmployee(String username, String password) {
		//Employee employee = em.find(Employee.class, username);
		//Query query = em.createQuery("select count(e.employeeId) from Employee e WHERE e.userName = :userName AND e.password = :password");
		Query query = em.createQuery("SELECT e FROM Employee e WHERE e.userName = :username AND e.password = :password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		Employee employee = (Employee) query.getSingleResult();
		return employee;
	}

	@Override
	public Employee getEmployeeByUserName(String username, String password) {
		
		Query query = em.createQuery("SELECT e FROM Employee e WHERE e.userName = :username AND e.password = :password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		Employee employee = (Employee) query.getSingleResult();
		return employee;
	}

	
}
