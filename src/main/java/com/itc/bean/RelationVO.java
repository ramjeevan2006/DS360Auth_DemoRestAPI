package com.itc.bean;

public class RelationVO {
	
	 private Integer relId;
	 private String relName;
	 private String relType; 
	 private String status; 
	 private String cardNum;
	 private String relImg;

	public RelationVO() {
		super();
	}

	public RelationVO(Integer relId, String relName, String relType, String status, String cardNum, String relImg) {
		super();
		this.relId = relId;
		this.relName = relName;
		this.relType = relType;
		this.status = status;
		this.cardNum = cardNum;
		this.relImg = relImg;
	}

	public Integer getRelId() {
		return relId;
	}

	public void setRelId(Integer relId) {
		this.relId = relId;
	}

	public String getRelName() {
		return relName;
	}

	public void setRelName(String relName) {
		this.relName = relName;
	}

	public String getRelType() {
		return relType;
	}

	public void setRelType(String relType) {
		this.relType = relType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getRelImg() {
		return relImg;
	}

	public void setRelImg(String relImg) {
		this.relImg = relImg;
	} 
	
}
