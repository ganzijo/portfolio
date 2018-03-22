package com.nuriapp.vo;

public class MeterDataVO {
	public String meterSerialNo;
	public String logId;
	public String meterDate;
	public String monthlyBilingData;

	public String getMeterSerialNo() {
		return meterSerialNo;
	}

	public void setMeterSerialNo(String meterSerialNo) {
		this.meterSerialNo = meterSerialNo;
	}

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public String getMeterDate() {
		return meterDate;
	}

	public void setMeterDate(String meterDate) {
		this.meterDate = meterDate;
	}

	public String getMonthlyBilingData() {
		return monthlyBilingData;
	}

	public void setMonthlyBilingData(String monthlyBilingData) {
		this.monthlyBilingData = monthlyBilingData;
	}

	public MeterDataVO(String meterSerialNo, String logId, String meterDate,
			String monthlyBilingData) {
		super();
		this.meterSerialNo = meterSerialNo;
		this.logId = logId;
		this.meterDate = meterDate;
		this.monthlyBilingData = monthlyBilingData;
	}
	
	

}
