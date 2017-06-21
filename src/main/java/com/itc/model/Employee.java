package com.itc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Employee implements Serializable { 

	private static final long serialVersionUID = 4655925091845967147L;
	@Id
	@Column(name = "EMP_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;

	@Column(name = "EMP_NAME")
	private String employeeName;

	@Column(name = "EMP_SUPERVISOR_ID")
	private Long employeeSupervisorId;

	@Column(name = "EMP_ROLE")
	private String employeeRole;

	@Column(name = "EMP_JOIN_DATE")
	@Temporal(TemporalType.DATE)
	private Date employeeJoinDate;

	@Column(name = "USER_NAME")
	private String userName;
	
	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "EMP_DESIGNATION")
	private String designation;

	
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Employee() {

	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Long getEmployeeSupervisorId() {
		return employeeSupervisorId;
	}

	public void setEmployeeSupervisorId(Long employeeSupervisorId) {
		this.employeeSupervisorId = employeeSupervisorId;
	}

	public String getEmployeeRole() {
		return employeeRole;
	}

	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}

	public Date getEmployeeJoinDate() {
		return employeeJoinDate;
	}

	public void setEmployeeJoinDate(Date employeeJoinDate) {
		this.employeeJoinDate = employeeJoinDate;
	}

}
