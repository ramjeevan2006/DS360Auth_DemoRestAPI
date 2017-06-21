package com.itc.bean;

public class CardVo {
	
	private Integer id;
	private String policyNum;
	private String status;
	private String effectiveDate;
	private String expiryDate;
	private String network;
	private String cancelDate;
	private String holderName;
	private String location;
	private String benifits;
	private String limits;
	private String opDed;
	private String coIns;
	private String oopLimit;
	private String nwInUae;
	private String nwOutUae;
	
	public CardVo() {
		super();
	}

	public CardVo(Integer id, String policyNum, String status, String effectiveDate, String expiryDate, String network,
			String cancelDate, String holderName, String location, String benifits, String limits, String opDed,
			String coIns, String oopLimit, String nwInUae, String nwOutUae) {
		super();
		this.id = id;
		this.policyNum = policyNum;
		this.status = status;
		this.effectiveDate = effectiveDate;
		this.expiryDate = expiryDate;
		this.network = network;
		this.cancelDate = cancelDate;
		this.holderName = holderName;
		this.location = location;
		this.benifits = benifits;
		this.limits = limits;
		this.opDed = opDed;
		this.coIns = coIns;
		this.oopLimit = oopLimit;
		this.nwInUae = nwInUae;
		this.nwOutUae = nwOutUae;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPolicyNum() {
		return policyNum;
	}

	public void setPolicyNum(String policyNum) {
		this.policyNum = policyNum;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public String getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(String cancelDate) {
		this.cancelDate = cancelDate;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBenifits() {
		return benifits;
	}

	public void setBenifits(String benifits) {
		this.benifits = benifits;
	}

	public String getLimits() {
		return limits;
	}

	public void setLimits(String limits) {
		this.limits = limits;
	}

	public String getOpDed() {
		return opDed;
	}

	public void setOpDed(String opDed) {
		this.opDed = opDed;
	}

	public String getCoIns() {
		return coIns;
	}

	public void setCoIns(String coIns) {
		this.coIns = coIns;
	}

	public String getOopLimit() {
		return oopLimit;
	}

	public void setOopLimit(String oopLimit) {
		this.oopLimit = oopLimit;
	}

	public String getNwInUae() {
		return nwInUae;
	}

	public void setNwInUae(String nwInUae) {
		this.nwInUae = nwInUae;
	}

	public String getNwOutUae() {
		return nwOutUae;
	}

	public void setNwOutUae(String nwOutUae) {
		this.nwOutUae = nwOutUae;
	}


	
	
}
