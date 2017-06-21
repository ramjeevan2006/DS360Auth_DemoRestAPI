package com.itc.bean;

public class ContactInfoVo {

	private Integer id;
	private String personName;
	private Integer phoneNum;
	private String email;
	private String notes;
	private String priority;
	
	public ContactInfoVo() {
		super();
	}

	public ContactInfoVo(Integer id, String personName, Integer phoneNum, String email, String notes, String priority) {
		super();
		this.id = id;
		this.personName = personName;
		this.phoneNum = phoneNum;
		this.email = email;
		this.notes = notes;
		this.priority = priority;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public Integer getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(Integer phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	
}
