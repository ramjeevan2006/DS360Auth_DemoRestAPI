package com.itc.bean;

import java.util.Date;

public class IncedentVO {
	
	
	private int id; 
    private String typeInc; 
    private String details; 
    private String status; 
    private String createdBy;
    private String service;
    private String subtype;
    private String escLevel;
    private String submisionDate;
    private String createdOn; 
    private boolean isDeleted; 
    private String closedOn; 
    private String complexity;
    private String dept;
    public IncedentVO() {
		super();
	}
	
	public IncedentVO(int id, String typeInc, String details, String status, String createdBy, String service,
			String subtype, String escLevel, String submisionDate, String createdOn, boolean isDeleted, String closedOn,
			String complexity, String dept) {
		super();
		this.id = id;
		this.typeInc = typeInc;
		this.details = details;
		this.status = status;
		this.createdBy = createdBy;
		this.service = service;
		this.subtype = subtype;
		this.escLevel = escLevel;
		this.submisionDate = submisionDate;
		this.createdOn = createdOn;
		this.isDeleted = isDeleted;
		this.closedOn = closedOn;
		this.complexity = complexity;
		this.dept = dept;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeInc() {
		return typeInc;
	}

	public void setTypeInc(String typeInc) {
		this.typeInc = typeInc;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public String getEscLevel() {
		return escLevel;
	}

	public void setEscLevel(String escLevel) {
		this.escLevel = escLevel;
	}

	public String getSubmisionDate() {
		return submisionDate;
	}

	public void setSubmisionDate(String submisionDate) {
		this.submisionDate = submisionDate;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getClosedOn() {
		return closedOn;
	}

	public void setClosedOn(String closedOn) {
		this.closedOn = closedOn;
	}

	public String getComplexity() {
		return complexity;
	}

	public void setComplexity(String complexity) {
		this.complexity = complexity;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

}
