package com.mystudy.cafetest.vo;

public class StampVO {
	private String stampId;
	private String stampCnt;
	private String custId;

	
	public StampVO() {}


	public StampVO(String stampId, String stampCnt, String custId) {
		super();
		this.stampId = stampId;
		this.stampCnt = stampCnt;
		this.custId = custId;
	}


	public String getStampId() {
		return stampId;
	}


	public void setStampId(String stampId) {
		this.stampId = stampId;
	}


	public String getStampCnt() {
		return stampCnt;
	}


	public void setStampCnt(String stampCnt) {
		this.stampCnt = stampCnt;
	}


	public String getCustId() {
		return custId;
	}


	public void setCustId(String custId) {
		this.custId = custId;
	}


	@Override
	public String toString() {
		return "StampVO [stampId=" + stampId + ", stampCnt=" + stampCnt + ", custId=" + custId + "]";
	}

	
}
