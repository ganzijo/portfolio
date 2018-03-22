package com.nuriapp.vo;

import java.util.Hashtable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class GetLocationInfoVO implements KvmSerializable {
	public String supplierId;
	public String locationId;
	public String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public GetLocationInfoVO() {
		super();
	}

	public GetLocationInfoVO(String supplierId, String locationId, String name) {
		super();
		this.supplierId = supplierId;
		this.locationId = locationId;
		this.name = name;
	}
	public GetLocationInfoVO(String supplierId, String locationId) {
		super();
		this.supplierId = supplierId;
		this.locationId = locationId;
	}

	@Override
	public String getInnerText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getProperty(int pid) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		switch (pid) {
		case 0:
			return this.supplierId;
		case 1:
			return this.locationId;
		case 2:
			return this.name;
		default:
			break;
		}
		return null;
	}

	@Override
	public int getPropertyCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public void getPropertyInfo(int index, Hashtable hTable, PropertyInfo info) {
		// TODO Auto-generated method stub
		switch (index) {
		case 0:
			info.type = PropertyInfo.INTEGER_CLASS;
			info.name = "supplierId";
			break;
		case 1:
			info.type = PropertyInfo.INTEGER_CLASS;
			info.name = "locationId";
			break;
		case 2:
			info.type = PropertyInfo.INTEGER_CLASS;
			info.name = "name";
			break;
		}
	}

	@Override
	public void setInnerText(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setProperty(int arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

}
