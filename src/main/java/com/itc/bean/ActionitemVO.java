package com.itc.bean;

public class ActionitemVO {
	
	private Integer actionId;
	private String actionImg;
	private String actionItem;
	private String cardNum;
	private String policyNum;
	private String type;
	private String date;
	
	public ActionitemVO() {
		super();
	}

	public ActionitemVO(Integer actionId, String actionImg, String actionItem, String cardNum, String policyNum,
			String type, String date) {
		super();
		this.actionId = actionId;
		this.actionImg = actionImg;
		this.actionItem = actionItem;
		this.cardNum = cardNum;
		this.policyNum = policyNum;
		this.type = type;
		this.date = date;
	}



	public Integer getActionId() {
		return actionId;
	}

	public void setActionId(Integer actionId) {
		this.actionId = actionId;
	}

	public String getActionItem() {
		return actionItem;
	}

	public void setActionItem(String actionItem) {
		this.actionItem = actionItem;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getPolicyNum() {
		return policyNum;
	}

	public void setPolicyNum(String policyNum) {
		this.policyNum = policyNum;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getActionImg() {
		return actionImg;
	}

	public void setActionImg(String actionImg) {
		this.actionImg = actionImg;
	}
	
	
}
