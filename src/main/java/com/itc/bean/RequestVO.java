package com.itc.bean;

public class RequestVO {
	
	public RequestVO(Integer id, String type, String subType, String dueDate, String createdBy, String status) {
		super();
		Id = id;
		this.type = type;
		this.subType = subType;
		this.dueDate = dueDate;
		this.createdBy = createdBy;
		this.status = status;
	}
	public RequestVO() {
		super();
	}
	private Integer Id;
	private String type;
	private String subType;
	private String dueDate;
	private String createdBy;
	private String status;
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSubType() {
		return subType;
	}
	public void setSubType(String subType) {
		this.subType = subType;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
