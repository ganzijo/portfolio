package com.nuriapp.vo;

public class ModemVO {

	private String mModemId;
	public String mMeterSerialNo;
	private String mAddress;
	private String mState;
	private String mDate;
	private String mValue;
	private boolean mIsChecked;
	
	
	public ModemVO(String mModemId, String mMeterSerialNo, String mAddress,String mState, String mDate, String mValue, boolean mIsChecked) {
		this.mModemId = mModemId;
		this.mMeterSerialNo = mMeterSerialNo;
		this.mAddress = mAddress;
		this.mState = mState;
		this.mDate = mDate;
		this.mValue = mValue;
		this.mIsChecked = mIsChecked;
	}
	
	//detail info Success
	public ModemVO(String mMeterSerialNo, String mAddress, String mDate, String mValue) {
		// TODO Auto-generated constructor stub	this.mModemId = mModemId;
		this.mMeterSerialNo = mMeterSerialNo;
		this.mAddress = mAddress;
		this.mDate = mDate;
		this.mValue = mValue;
	}


	public String getModemId() {
		return mModemId;
	}
	public void setModemId(String mModemId) {
		this.mModemId = mModemId;
	}
	public String getMeterSerialNo() {
		return mMeterSerialNo;
	}
	public void setMeterSerialNo(String mMeterSerialNo) {
		this.mMeterSerialNo = mMeterSerialNo;
	}
	public String getAddress() {
		return mAddress;
	}
	public void setAddress(String mAddress) {
		this.mAddress = mAddress;
	}
	public String getState() {
		return mState;
	}
	public void setState(String mState) {
		this.mState = mState;
	}
	public String getDate() {
		return mDate;
	}
	public void setDate(String mDate) {
		this.mDate = mDate;
	}
	public String getValue() {
		return mValue;
	}
	public void setValue(String mValue) {
		this.mValue = mValue;
	}

	public boolean isChecked() {
		return mIsChecked;
	}
	public void setChecked(boolean mIsChecked) {
		this.mIsChecked = mIsChecked;
	}
	
}
