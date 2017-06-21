package com.itc.bean;

public class AuthorisationVO {

	public AuthorisationVO() {
		super();
	}
	public AuthorisationVO(Integer id, String authName, String authDesc, String submissionDate, String status,
			String provider, String eta) {
		super();
		this.id = id;
		this.authName = authName;
		this.authDesc = authDesc;
		this.submissionDate = submissionDate;
		this.status = status;
		this.provider = provider;
		this.eta = eta;
	}
	private Integer id;
	private String authName;
	private String authDesc;
	private String submissionDate;
	private String status;
	private String provider;
	private String eta;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAuthName() {
		return authName;
	}
	public void setAuthName(String authName) {
		this.authName = authName;
	}
	public String getAuthDesc() {
		return authDesc;
	}
	public void setAuthDesc(String authDesc) {
		this.authDesc = authDesc;
	}
	public String getSubmissionDate() {
		return submissionDate;
	}
	public void setSubmissionDate(String submissionDate) {
		this.submissionDate = submissionDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String getEta() {
		return eta;
	}
	public void setEta(String eta) {
		this.eta = eta;
	}
}
