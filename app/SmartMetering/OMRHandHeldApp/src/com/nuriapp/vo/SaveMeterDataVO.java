package com.nuriapp.vo;

import java.util.Hashtable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class SaveMeterDataVO implements KvmSerializable {
	public String mdsId;
	public String mdsDate;
	public String mdsDataType;
	public String mdsValues;
	
	public String getMdsId() {
		return mdsId;
	}
	public void setMdsId(String mdsId) {
		this.mdsId = mdsId;
	}
	public String getMdsDate() {
		return mdsDate;
	}
	public void setMdsDate(String mdsDate) {
		this.mdsDate = mdsDate;
	}
	public String getMdsDataType() {
		return mdsDataType;
	}
	public void setMdsDataType(String mdsDataType) {
		this.mdsDataType = mdsDataType;
	}
	public String getMdsValues() {
		return mdsValues;
	}
	public void setMdsValues(String mdsValues) {
		this.mdsValues = mdsValues;
	}
	
	public SaveMeterDataVO() {
		super();
	}
	@Override
	public String getInnerText() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object getProperty(int pid) {
		// TODO Auto-generated method stub
		switch (pid) {
		case 0:
			return this.mdsId;
		case 1:
			return this.mdsDate;
		case 2:
			return this.mdsDataType;
		case 3:
			return this.mdsValues;
		default:
			break;
		}
		return null;
	}
	@Override
	public int getPropertyCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void getPropertyInfo(int index, Hashtable hTable, PropertyInfo info) {
		// TODO Auto-generated method stub
		switch (index) {
		case 0:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "mdsId";
			break;
		case 1:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "mdsDate";
			break;
		case 2:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "mdsDataType";
			break;
		case 3:
			info.type = PropertyInfo.LONG_CLASS;
			info.name = "mdsValues";
			break;
		}
	}
	@Override
	public void setInnerText(String arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setProperty(int index, Object value) {
		// TODO Auto-generated method stub
		switch (index) {
		case 0:
			this.mdsId = value.toString();
			break;
		case 1:
			this.mdsDate = value.toString();
			break;
		case 2:
			this.mdsDataType = value.toString();
			break;
		case 3:
			this.mdsValues = value.toString();
			break;
		}
	}
	
	
}
