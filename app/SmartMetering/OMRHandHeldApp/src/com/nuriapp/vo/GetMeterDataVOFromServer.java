package com.nuriapp.vo;

import java.util.Hashtable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class GetMeterDataVOFromServer implements KvmSerializable {
	public String mdsId;
	public String address;
	public String date;
	public String Value;
	public String modemId;

	public String getValue() {
		return Value;
	}

	public void setValue(String value) {
		Value = value;
	}

	public String getMdsId() {
		return mdsId;
	}

	public void setMdsId(String mdsId) {
		this.mdsId = mdsId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getModemId() {
		return modemId;
	}

	public void setModemId(String modemId) {
		this.modemId = modemId;
	}

	@Override
	public Object getProperty(int pid) {
		// TODO Auto-generated method stub
		switch (pid) {
		case 0:
			return this.mdsId;
		case 1:
			return this.address;
		case 2:
			return this.date;
		case 3:
			return this.modemId;
		case 4:
			return this.Value;
		default:
			break;
		}
		return null;
	}

	@Override
	public int getPropertyCount() {
		// TODO Auto-generated method stub
		return 5;
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
			info.name = "address";
			break;
		case 2:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "date";
			break;
		case 3:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "modemId";
			break;
		case 4:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "lastMeteringValue";
			break;
		}
	}

	@Override
	public void setProperty(int index, Object value) {
		// TODO Auto-generated method stub
		switch (index) {
		case 0:
			this.mdsId = value.toString();
			break;
		case 1:
			this.address = value.toString();
			break;
		case 2:
			this.date = value.toString();
			break;
		case 3:
			this.modemId = value.toString();
			break;
		case 4:
			this.Value = value.toString();
			break;
		}
	}

	@Override
	public String getInnerText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInnerText(String arg0) {
		// TODO Auto-generated method stub

	}

	public GetMeterDataVOFromServer() {
		super();
	}

}
