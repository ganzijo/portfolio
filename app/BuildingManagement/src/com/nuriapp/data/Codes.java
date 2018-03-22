package com.nuriapp.data;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class Codes {

	public static class Building {
		public static final String[] ALL = { "1", "2", "3" };
		public static final String[] ETRI = { "1" };
		public static final String[] NURI = { "2" };
		public static final String[] SPRODUCE = { "3" };
	}

	public static class ObjectType {
		public static final String[] TEMPERATURE = { "1" };
		public static final String[] HUMIDITY = { "2" };
		public static final String[] ELECTRICITY = { "5", "6", "7" };
		public static final String[] WATER = { "8" };
		public static final String[] GAS = { "9" };
		public static final String[] ALL = ArrayUtils.addAll(
				ArrayUtils.addAll(ELECTRICITY, WATER), GAS);

	}

	public class Detail {
		private double electricity;
		private double gas;
		private double water;
		private double benchmarkAvg;
		private double avg;
		private double using;

		public double getBenchmarkAvg() {
			return benchmarkAvg;
		}

		public void setBenchmarkAvg(double benchmarkAvg) {
			this.benchmarkAvg = benchmarkAvg;
		}

		public double getAvg() {
			return avg;
		}

		public void setAvg(double avg) {
			this.avg = avg;
		}

		public double getUsing() {
			return using;
		}

		public void setUsing(double using) {
			this.using = using;
		}

		public double getElectricity() {
			return electricity;
		}

		public void setElectricity(double electricity) {
			this.electricity = electricity;
		}

		public double getGas() {
			return gas;
		}

		public void setGas(double gas) {
			this.gas = gas;
		}

		public double getWater() {
			return water;
		}

		public void setWater(double water) {
			this.water = water;
		}

		public void setup(String objectTypeId, String sumData) {
			if (ArrayUtils.contains(Codes.ObjectType.ELECTRICITY, objectTypeId)) {
				this.electricity += NumberUtils.toDouble(sumData);
			} else if (ArrayUtils.contains(Codes.ObjectType.GAS, objectTypeId)) {
				this.gas += NumberUtils.toDouble(sumData);
			} else if (ArrayUtils
					.contains(Codes.ObjectType.WATER, objectTypeId)) {
				this.water += NumberUtils.toDouble(sumData);
			}
		}
	}

	public static class Data {
		private String dateValue;
		private String objectTypeId;
		private String sumData;

		public String getDateValue() {
			return dateValue;
		}

		public void setDateValue(String dateValue) {
			this.dateValue = dateValue;
		}

		public String getObjectTypeId() {
			return objectTypeId;
		}

		public void setObjectTypeId(String objectTypeId) {
			this.objectTypeId = objectTypeId;
		}

		public String getSumData() {
			return sumData;
		}

		public void setSumData(String sumData) {
			this.sumData = sumData;
		}

		public Data(String dateValue, String objectTypeId, String sumData) {
			super();
			this.dateValue = dateValue;
			this.objectTypeId = objectTypeId;
			this.sumData = sumData;
		}

		@Override
		public String toString() {
			return "Data [dateValue=" + dateValue + ", objectTypeId="
					+ objectTypeId + ", sumData=" + sumData + "]";
		}

	}

}
