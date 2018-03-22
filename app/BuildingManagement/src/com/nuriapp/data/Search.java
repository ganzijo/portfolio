package com.nuriapp.data;

import java.util.Properties;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import android.util.Log;

public class Search {
	public enum Radio {
		업무시설(14000), 단독주택(1000), 공동주택(2000), 제1종_근린생활시설(3000), 제2종_근린생활시설(4000), 종교시설(6000), 문화_및_집회시설(5000), 판매시설(7000), 운수시설(8000), 의료시설(9000), 교육연구시설(10000), 노유자시설(11000), 수련시설(12000), 운동시설(13000), 숙박시설(15000), 위탁시설(16000), 공장(17000), 창고시설(18000);
		private int code;
		private String codeName;
		private Radio(int code){
			this.code = code;
		}
		int codeNum(){
			return code;
		}
		private Radio(String codeName){
			this.codeName = codeName;
		}
		String codeNames(){
			return codeName;
		}
	}

	private String buildingId; // 현재 선택된(저장된) buildingId
	private boolean buildingTypeEnabled; // 빌딩타입 CheckBox 유무에 따라 true or false
	private String buildingType; // 집합건물, 일반건물
	private boolean buildingUseEnabled; // 용도 CheckBox 유무에 따라 true or false
	private String buildingUse; // RadioBtns
	private boolean addressEnabled; // 주소 CheckBox
	private boolean siEnabled;
	private boolean guEnabled;
	private boolean dongEnabled;
	private boolean areaEnabled;
	private String minValue;
	private String maxValue;
	

	public String getMinValue() {
		return minValue;
	}

	public void setMinValue(String minValue) {
		this.minValue = minValue;
	}

	public String getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(String maxValue) {
		this.maxValue = maxValue;
	}

	
	public boolean isBuildingTypeEnabled() {
		return buildingTypeEnabled;
	}

	public void setBuildingTypeEnabled(boolean buildingTypeEnabled) {
		this.buildingTypeEnabled = buildingTypeEnabled;
	}

	public String getBuildingType() {
		String result = "";
		try {
			result = String
					.valueOf(Radio.valueOf(
							StringUtils.replace(this.buildingType, " ", "_"))
							.ordinal());
		} catch (IllegalArgumentException e) {
			Log.i("ignore...", "ignore");
		}
		return result;
	}

	public boolean isAddressEnabled() {
		return addressEnabled;
	}

	public void setAddressEnabled(boolean addressEnabled) {
		this.addressEnabled = addressEnabled;
	}

	public boolean isSiEnabled() {
		return siEnabled;
	}

	public void setSiEnabled(boolean siEnabled) {
		this.siEnabled = siEnabled;
	}

	public boolean isGuEnabled() {
		return guEnabled;
	}

	public void setGuEnabled(boolean guEnabled) {
		this.guEnabled = guEnabled;
	}

	public boolean isDongEnabled() {
		return dongEnabled;
	}

	public void setDongEnabled(boolean dongEnabled) {
		this.dongEnabled = dongEnabled;
	}

	public boolean isAreaEnabled() {
		return areaEnabled;
	}

	public void setAreaEnabled(boolean areaEnabled) {
		this.areaEnabled = areaEnabled;
	}

	public void setBuildingType(String buildingType) {
		this.buildingType = buildingType;
	}


	public boolean isBuildingUseEnabled() {
		return buildingUseEnabled;
	}

	public void setBuildingUseEnabled(boolean buildingUseEnabled) {
		this.buildingUseEnabled = buildingUseEnabled;
	}

	public String getBuildingUse() {
		return buildingUse;
	}

	public void setBuildingUse(String buildingUse) {
		this.buildingUse = buildingUse;
	}

	public String getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}

	public Search getInstance(Properties properties) {
		Search search = new Search();
		search.setBuildingTypeEnabled(BooleanUtils.toBoolean(properties
				.getProperty("buildingTypeEnabled")));
		return search;
	}

}
