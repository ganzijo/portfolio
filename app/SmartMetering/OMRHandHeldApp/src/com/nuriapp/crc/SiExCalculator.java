package com.nuriapp.crc;

import org.apache.commons.lang3.StringUtils;

public class SiExCalculator {

	public String convertBit(String value) {
		int convertHexValue = Integer.parseInt(value, 16);
		String getBit = Integer.toBinaryString(convertHexValue);
		if (getBit.length() == 8) {
			return getBit;
		} else {
			int lengthCnt = 8 - getBit.length();
			for (int num = 0; num < lengthCnt; num++) {
				getBit = "0" + getBit;
			}
			return getBit;
		}
	}

	public double calculateSiEx(String getBit) {
		int signInt = Integer.parseInt(StringUtils.substring(getBit, 0, 1));
		int signExp = Integer.parseInt(StringUtils.substring(getBit, 1, 2));
		int exponent = Integer.parseInt(StringUtils.substring(getBit, 3, 8), 2);

		double calValue = 0.0;
		calValue = Math.pow(-1, signInt)* (Math.pow(10, Math.pow(-1, signExp) * exponent));
		//System.out.println("calValue is : " + calValue * 12345);
		return calValue;
	}

	/*public static void main(String[] args) {

		calculateSiEx(convertBit("C2"));
	}*/
}
