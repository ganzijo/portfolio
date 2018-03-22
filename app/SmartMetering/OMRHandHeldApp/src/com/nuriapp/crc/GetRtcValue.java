package com.nuriapp.crc;

import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GetRtcValue {
	
	public static String getRtc(byte[] bytes){
		byte daylight = 0x2;
		String resultStr = "";

		int val = ByteBuffer.wrap(bytes).getInt();
//		System.out.println("val = " + val); // 받아온 Seconds

		Calendar cal = Calendar.getInstance();
		// Set 2000/1/1 0:0:0
		cal.set(2000, 0, 1, 0, 0, 0);
		// Calc Day
		cal.add(Calendar.SECOND, val);
		Date date = cal.getTime();
		
		if (daylight == 0 || daylight == 1){
			System.out.println("Not Vaild");
		}
		else {
			if (daylight == 1 || daylight == 3)
				cal.add(Calendar.HOUR_OF_DAY, 1);
			
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
//			System.out.println(format.format(date));
			resultStr = format.format(date);
			System.out.println(resultStr);
		}
		return resultStr;
	}

	static public void main(String[] args) {
		byte[] test = { 0x1c, (byte) 0xfe, 0x5d, 0x0 };
		getRtc(test);
	}

}
