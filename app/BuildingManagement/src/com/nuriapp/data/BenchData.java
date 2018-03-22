package com.nuriapp.data;

import java.text.DecimalFormat;

import org.apache.commons.lang3.math.NumberUtils;

public class BenchData {
	private String buildingName;
	private String usingAmount;
	private String address;
	private String area;

	public BenchData(String buildingName, String usingAmount, String address,
			String area) {
		super();
		DecimalFormat decimalFormat = new DecimalFormat(
				"#,###.##");
		this.buildingName = convertBuildingName(buildingName);
		this.usingAmount = decimalFormat.format(NumberUtils
				.toDouble(usingAmount));
		this.address = address;
		this.area = decimalFormat.format(NumberUtils.toDouble(area));
	}
	private BenchData() {
	}
	public static BenchData empty(){
		BenchData benchData = new BenchData();
		benchData.setAddress("-");
		benchData.setArea("-");
		benchData.setBuildingName("-");
		benchData.setUsingAmount("-");
		return benchData;
	}

	private String convertBuildingName(String buildingName) {
		if (buildingName.length() > 3) {
			buildingName = "**"
					+ buildingName.substring(1, (buildingName.length() / 2))
					+ "**";
		} else {
			buildingName = "**"
					+ buildingName.substring(0, (buildingName.length() - 1))
					+ "**";
		}
		return buildingName;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getUsingAmount() {
		return usingAmount;
	}

	public void setUsingAmount(String usingAmount) {
		this.usingAmount = usingAmount;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
