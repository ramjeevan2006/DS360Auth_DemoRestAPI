package com.itc.bean;

public class Customer {
	
	public Customer(String name, String gender, String dob, String country, String fmlybook, long emId,
			String residence, String custImg, String[] incList, boolean radiaBtn, String email, String phNum,
			String address, String poBox, String city, String district, String region, String website) {
		super();
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.country = country;
		this.fmlybook = fmlybook;
		this.emId = emId;
		this.residence = residence;
		this.custImg = custImg;
		IncList = incList;
		this.radiaBtn = radiaBtn;
		this.email = email;
		this.phNum = phNum;
		this.address = address;
		this.poBox = poBox;
		this.city = city;
		this.district = district;
		this.region = region;
		this.website = website;
	}
	public Customer(String[] incList, boolean radiaBtn) {
		super();
		IncList = incList;
		this.radiaBtn = radiaBtn;
	}

	
	private String name;
	private String gender;
	private String dob;
	private String country;
	private String fmlybook;
	private long emId;
	private String residence;
	private String custImg;
	private String[] IncList;
	private boolean radiaBtn;
	private String email;
	private String phNum;
	private String address;
	private String poBox;
	private String city;
	private String district;
	private String region;
	private String website;
	
	public Customer() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getFmlybook() {
		return fmlybook;
	}
	public void setFmlybook(String fmlybook) {
		this.fmlybook = fmlybook;
	}
	public long getEmId() {
		return emId;
	}
	public void setEmId(long emId) {
		this.emId = emId;
	}
	public String getResidence() {
		return residence;
	}
	public void setResidence(String residence) {
		this.residence = residence;
	}
	public String getCustImg() {
		return custImg;
	}
	public void setCustImg(String custImg) {
		this.custImg = custImg;
	}
	public String[] getIncList() {
		return IncList;
	}
	public void setIncList(String[] incList) {
		IncList = incList;
	}
	public boolean isRadiaBtn() {
		return radiaBtn;
	}
	public void setRadiaBtn(boolean radiaBtn) {
		this.radiaBtn = radiaBtn;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhNum() {
		return phNum;
	}
	public void setPhNum(String phNum) {
		this.phNum = phNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPoBox() {
		return poBox;
	}
	public void setPoBox(String poBox) {
		this.poBox = poBox;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}

}
