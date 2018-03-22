package com.nuriapp.crc;

import java.math.BigInteger;

public class GetMeterSerialValue {
	
	public static void main(String[] args) {
//		byte[] test = {0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x01, 0x23, (byte)0xe3, 0x0e};
//		GetMeterSerialNum(test);
		
	}
	public static String GetMeterSerialNum(byte[] bytes){
		BigInteger serialNum = new BigInteger(bytes);
		System.out.println(serialNum);
		return String.valueOf(serialNum);
	}
}
