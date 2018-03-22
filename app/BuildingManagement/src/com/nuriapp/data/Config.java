package com.nuriapp.data;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class Config extends Application {

	private static Config CONFIG;
	private String currentUserId;
	private boolean currentAutoLoginEnabled;
	public static SharedPreferences sharedPreferences;
	public static Editor editor;
	
	public static final String StatesPref = "statesPref";
	public static final String Id = "idKey";
	public static final String Pw = "pwKey";
	public static final String Building = "currentBuilding";
	public static final String AutoLoginEnabled = "autoLoginEnabled";
	public static final String SaveIdEnabled = "saveIdEnabled";
	//
	public static final String RadioBtnState1 = "buildingUse1";
	public static final String RadioBtnState2 = "buildingUse2";
	public static final String RadioBtnState3 = "buildingUse3";
	public static final String RadioBtnState4 = "buildingUse4";
	public static final String RadioBtnState5 = "buildingUse5";
	public static final String RadioBtnState6 = "buildingUse6";
	public static final String RadioBtnState7 = "buildingUse7";
	public static final String RadioBtnState8 = "buildingUse8";
	public static final String RadioBtnState9 = "buildingUse9";
	public static final String RadioBtnState10 = "buildingUse10";
	public static final String RadioBtnState11 = "buildingUse11";
	public static final String RadioBtnState12 = "buildingUse12";
	public static final String RadioBtnState13 = "buildingUse13";
	public static final String RadioBtnState14 = "buildingUse14";
	public static final String RadioBtnState15 = "buildingUse15";
	public static final String RadioBtnState16 = "buildingUse16";
	public static final String RadioBtnState17 = "buildingUse17";
	public static final String RadioBtnState18 = "buildingUse18";
	//
	public static final String Address = "address";
	public static final String Si = "si";
	public static final String Gu = "gu";
	public static final String Dong = "dong";
	//
	public static final String Area = "area";
	public static final String MinValue = "minValue";
	public static final String MaxValue = "maxValue";
	//
	
	private String buildingID;
	private double buildingFloatArea;

	private boolean buildingTypeEnabled;
	private String buildingType; // 집합건물, 일반건물
	private boolean buildingUseEnabled; // 용도 CheckBox 유무에 따라 true or false
	private String buildingUse; // RadioBtns
	private boolean addressEnabled; // 주소 CheckBox
	private boolean siEnabled;
	private boolean guEnabled;
	private boolean dongEnabled;
	private boolean areaEnabled;
	private String siValue;
	private String guValue;
	private String dongValue;
	private double minValue;
	private double maxValue;

	public String getCurrentUserId() {
		return currentUserId;
	}

	public void setCurrentUserId(String currentUserId) {
		this.currentUserId = currentUserId;
	}

	public boolean isCurrentAutoLoginEnabled() {
		return currentAutoLoginEnabled;
	}

	public void setCurrentAutoLoginEnabled(boolean currentAutoLoginEnabled) {
		this.currentAutoLoginEnabled = currentAutoLoginEnabled;
	}

	public String getSiValue() {
		return siValue;
	}

	public void setSiValue(String siValue) {
		this.siValue = siValue;
	}

	public String getGuValue() {
		return guValue;
	}

	public void setGuValue(String guValue) {
		this.guValue = guValue;
	}

	public String getDongValue() {
		return dongValue;
	}

	public void setDongValue(String dongValue) {
		this.dongValue = dongValue;
	}

	public boolean isBuildingTypeEnabled() {
		return buildingTypeEnabled;
	}

	public void setBuildingTypeEnabled(boolean buildingTypeEnabled) {
		this.buildingTypeEnabled = buildingTypeEnabled;
	}

	public String getBuildingType() {
		return buildingType;
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

	public double getMinValue() {
		return minValue;
	}

	public void setMinValue(double minValue) {
		this.minValue = minValue;
	}

	public double getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(double maxValue) {
		this.maxValue = maxValue;
	}

	public String getBuildingID() {
		return buildingID;
	}

	public void setBuildingID(String buildingID) {
		this.buildingID = buildingID;
	}
	
	public double getBuildingFloatArea() {
		return buildingFloatArea;
	}

	public void setBuildingFloatArea(double buildingFloatArea) {
		this.buildingFloatArea = buildingFloatArea;
	}

	public static synchronized Config getInstance() {
		if (CONFIG == null) {
			CONFIG = new Config();
		}
		return CONFIG;
	}

	public static synchronized void setInstance(Config config) {
		CONFIG = config;
	}
	public void defaultSettting(){
		if (this.buildingID.equals("1")) {
			this.setSiValue("대전시");
			this.setGuValue("유성구");
			this.setDongValue("가정동");
			this.setBuildingFloatArea(3206.0);
		}
		if (this.buildingID.equals("2")) {
			this.setSiValue("서울특별시");
			this.setGuValue("강남구");
			this.setDongValue("삼성1동");
			this.setBuildingFloatArea(3206.0);
		}
		if (this.buildingID.equals("3")) {
			this.setSiValue("서울특별시");
			this.setGuValue("서초구");
			this.setDongValue("서초2동");
			this.setBuildingFloatArea(3206.0);
		}
	}
}
