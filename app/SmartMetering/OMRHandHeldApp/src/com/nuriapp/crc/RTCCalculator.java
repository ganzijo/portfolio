package com.nuriapp.crc;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.util.Log;

public class RTCCalculator {

	// 5개의 byte 데이터로부터 elapsedTime을 추출한다.
		static int RTC_Calculator(byte[] input) {
			int multNum = 1;
			int res = 0;

			for (int i = 4 ;i >= 0; i--) {
				res += (int) (input[i] & (byte) 0x0F) * multNum;
				multNum *= 16;

				res += Math.abs((int)((input[i] & (byte) 0xF0) >> 4)) * multNum;
				multNum *= 16;
			}

			return res;
		}

		@SuppressWarnings("deprecation")
		public static Date RTC_GetDay(byte[] input) {

			final int secForOneDay = 86400;
			final int year = 365;
			final int month = 12;
			int elapsedTime = RTC_Calculator(input);
			System.out.println(elapsedTime);
			// 지금 여기   elapsedTime = 469656784
			// int         elapsedTime = 473781600;

			int resultForSec = elapsedTime / secForOneDay;
			
			System.out.println(elapsedTime);
			// 474366600
			
		
			String pattern = "yy-MM-dd HH:mm:ss";
			SimpleDateFormat formatter = new SimpleDateFormat(pattern);
			//String date = (String)formatter.format(new Timestamp(elapsedTime/1000));
			
			Date date = new Date(0, 0, 0, 0, 0, 0);
			date.setSeconds(elapsedTime);
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date(100, 1, 1));
			cal.add(Calendar.YEAR, date.getYear());
			cal.add(Calendar.MONTH, date.getMonth());
			cal.add(Calendar.DATE, date.getDate());
			cal.add(Calendar.HOUR, date.getHours());
			cal.add(Calendar.MINUTE, date.getMinutes());
			cal.add(Calendar.SECOND, date.getSeconds());
			
			return cal.getTime();
			
		}
		
		public static String getDateString(String year, String month, String day, String hours, String minutes, String second)
		{
			int _year = Integer.parseInt(year);
			int _month = Integer.parseInt(month);
			int _day = Integer.parseInt(day);
			int _hours = Integer.parseInt(hours);
			int _minutes = Integer.parseInt(minutes);
			int _second = Integer.parseInt(second);
			Date date = new Date(_year, _month, _day, _hours, _minutes, _second);
			
			SimpleDateFormat testFormat = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
			return testFormat.format(date);
		}
		

}
