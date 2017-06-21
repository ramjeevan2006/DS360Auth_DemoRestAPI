package com.itc.bean;

public class ServiceVO {
	
	private Integer id;
	private String serviceNum;
	private String imgServ;
	private String servPerson;
	private String serviceAffect;
	
	public ServiceVO(Integer id, String serviceNum, String imgServ, String servPerson, String serviceAffect) {
		super();
		this.id = id;
		this.serviceNum = serviceNum;
		this.imgServ = imgServ;
		this.servPerson = servPerson;
		this.serviceAffect = serviceAffect;
	}
	public ServiceVO() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getServiceNum() {
		return serviceNum;
	}
	public void setServiceNum(String serviceNum) {
		this.serviceNum = serviceNum;
	}
	public String getImgServ() {
		return imgServ;
	}
	public void setImgServ(String imgServ) {
		this.imgServ = imgServ;
	}
	public String getServPerson() {
		return servPerson;
	}
	public void setServPerson(String servPerson) {
		this.servPerson = servPerson;
	}
	public String getServiceAffect() {
		return serviceAffect;
	}
	public void setServiceAffect(String serviceAffect) {
		this.serviceAffect = serviceAffect;
	}
	
	
}
