package com.itc.bean;

public class InteractionLog {
	
	private Integer id;
	private String interactionType;
	private String custName;
	private String custImg;
	private String loginPerson;
	private String loginImg;
	private String DateTime;
	private String comments;
	
	public InteractionLog(Integer id, String interactionType, String custName, String custImg, String loginPerson,
			String loginImg, String dateTime, String comments) {
		super();
		this.id = id;
		this.interactionType = interactionType;
		this.custName = custName;
		this.custImg = custImg;
		this.loginPerson = loginPerson;
		this.loginImg = loginImg;
		DateTime = dateTime;
		this.comments = comments;
	}
	public InteractionLog() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getInteractionType() {
		return interactionType;
	}
	public void setInteractionType(String interactionType) {
		this.interactionType = interactionType;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getLoginPerson() {
		return loginPerson;
	}
	public void setLoginPerson(String loginPerson) {
		this.loginPerson = loginPerson;
	}
	public String getDateTime() {
		return DateTime;
	}
	public void setDateTime(String dateTime) {
		DateTime = dateTime;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
}
