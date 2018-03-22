package com.nuriapp.vo;

public class ModemStorageVO extends ModemVO{

	String mCollectDate;
	boolean isDeleted;
	
	public ModemStorageVO(String modemId, String meterSerialNo,
			String address, String state, String date, String value,
			boolean isChecked, String collectDate, boolean isDeleted) {
		super(modemId, meterSerialNo, address, state, date, value, isChecked);
		// TODO Auto-generated constructor stub
		
		this.mCollectDate = collectDate;
		this.isDeleted = isDeleted;
	}

	public String getCollectDate() {
		return mCollectDate;
	}
	public void setCollectDate(String collectDate) {
		this.mCollectDate = collectDate;
	}
	
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean mIsChecked) {
		this.isDeleted = isDeleted;
	}
}
