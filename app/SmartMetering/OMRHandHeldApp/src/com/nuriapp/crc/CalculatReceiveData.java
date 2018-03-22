package com.nuriapp.crc;

import java.math.BigInteger;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.nuriapp.database.DBConfig;
import com.nuriapp.database.DBHelper;
import com.nuriapp.omrhandheldapp.ReadListFragment;
import com.nuriapp.serial.SerialReceiveConfig;
import com.nuriapp.vo.ModemVO;

public class CalculatReceiveData {
	public static String mSerialNum;
	
	public static void startCalculate(byte[][] receiveData, int clickBtn){
		Cursor cursor;
		DBHelper dbHelper;
		SiExCalculator siexCalc = new SiExCalculator();
		double Value_Siex = 0;
		byte[] siEx = new byte[2];
		siEx[0] = receiveData[1][SerialReceiveConfig.SIEX0];
		siEx[1] = receiveData[1][SerialReceiveConfig.SIEX1];
//			Value_Siex[0] = siexCalc.calculateSiEx(siexCalc.convertBit(Integer.toHexString(siEx[0]&0xff)));
			Value_Siex = siexCalc.calculateSiEx(siexCalc.convertBit(Integer.toHexString(siEx[1]&0xff)));
//			Log.i("RTC_Siex", siEx[0]+","+siEx[1]);
//			Log.i("Value_Siex",Value_Siex+"");
			
			byte [] Value_input = new byte[4];
			byte[] hex_value = new byte[4];
			for(int i = 0; i < 4; i++){
				Value_input[i] = receiveData[1][SerialReceiveConfig.VALUE_INDEX + i];
				hex_value[i] = (byte) (Value_input[i]&0xff);
//				Log.i("value", Value_input[i]+"");
			}
			BigInteger bigIntNum = new BigInteger(hex_value); // BigInteger로 넣는거 테스트 하기
			String mMonthlyValue = String.valueOf(bigIntNum);
			
//			BigDecimal d = new BigDecimal(String.valueOf(Value_Siex));
//			System.out.println("New BigDecimal : " + d);
			
			double calc = bigIntNum.doubleValue() * Value_Siex;
			System.out.println("bigIntNum.doubleValue() * Value_Siex : " + calc);
			String mValues = String.valueOf(calc);
			
			
			byte[] logId = new byte[4];
			
			for(int i=0; i<4; i++){
				logId[i] = receiveData[0][SerialReceiveConfig.LOGID_INDEX+i];
				hex_value[i] = (byte)(logId[i]&0xff);
			}
			BigInteger getLogId = new BigInteger(hex_value);
			String mLogId = String.valueOf(getLogId);
			// getLogId End
			
			// getRtc Start						
			byte [] input = new byte[4];
			for(int i = 0; i < 4; i++){
				input[i] = receiveData[1][SerialReceiveConfig.RTC_INDEX + i];
				//Log.i("date_Test", input[i] +"");
			}
			String mRtcValue = GetRtcValue.getRtc(input);
			//String mRtcValue = "2015-07-15 00:00:00";
			// getRtc End
			
			// getMeterSerialValue Start
			byte [] getSerialByte = new byte[10];
			for(int i=0; i<10;i++){
				getSerialByte[i] = receiveData[2][SerialReceiveConfig.METER_SERIAL_INDEX+i];
			}
			mSerialNum = GetMeterSerialValue.GetMeterSerialNum(getSerialByte);
			// getMeterSerialValue End
			
			
			
			dbHelper = DBHelper.getInstance(ReadListFragment.context);
			SQLiteDatabase db = dbHelper.getWritableDatabase();
			
			cursor = db.rawQuery(DBConfig.SELECT_MODEM_BY_SERIAL(mSerialNum), null);
			cursor.moveToFirst();
			
			if(cursor.getCount() > 0) {
				//ModemVO modemVO = new ModemVO(cursor.getString(0), mSerialNum, cursor.getString(2),"통신 가능", mRtcValue, mValues, false);
				
				for (int i = 0; i < cursor.getCount(); i++) {
					String modemID = cursor.getString(0);
					String address = cursor.getString(2);
					String state = cursor.getString(3);
					String date = cursor.getString(4);
					String value = cursor.getString(5);
					
					if(clickBtn == 1){
						boolean isCheck = (cursor.getInt(6) == 0) ? true : true;
						db.execSQL(DBConfig.UPDATE_MODEM(modemID, mSerialNum, address, "통신 가능", date, value, true));
						//Log.i("sqlTest",DBConfig.UPDATE_MODEM(modemID, mSerialNum, address, "통신 가능", date, value, true));
						try{
							db.execSQL(DBConfig.DELETE_MODEMID_RECOLLECT_MODEMLIST + modemID + "';");
						}catch(Exception e){
							//
						}
					}
					else if(clickBtn == 2) {
						// modem list table에 갱신을 해준다. 실제 데이터 넣어줘야함
						db.execSQL(DBConfig.UPDATE_MODEM(modemID, mSerialNum,address, "수집 성공", mRtcValue, mValues, false));
						// storage table에 갱신을 한다.
						try {
							//insert를 시도한다.
							db.execSQL(DBConfig.get_INSERT_MODEMLIST_STORAGE(modemID, mSerialNum, address,  "수집 성공", mRtcValue, mValues, false));
						}catch(Exception e){
							//insert 실패시 update한다. 
							db.execSQL(DBConfig.get_UPDATE_MODEMLIST_STORAGE(modemID, mSerialNum,address, "수집 성공", mRtcValue, mValues, false));
						}

						try{
							db.execSQL(DBConfig.DELETE_MODEMID_RECOLLECT_MODEMLIST + modemID + "';");
						}catch(Exception e){
							//
						}
						/*// recollect ,  collect 처리 
							Log.i("recollect_State Test", state);
							if(state.equals("통신 가능")){
								try {
									//insert 시도
									db.execSQL(DBConfig.INSERT_RECOLLECTMODEM(modemID, mSerialNum, address, "수집 실패", date, value, false));
								}catch(Exception e){
									//insert 실패시 
									db.execSQL(DBConfig.UPDATE_MODEM(modemID, mSerialNum,address, state, mRtcValue, mValues, false));
								}
						}*/
					// 모뎀 스캔 후 CRC 에러 일경우에는 통신은 가능한 경우 이므로 추가	
					}else if(clickBtn == 3){
						db.execSQL("update modemlist set modem_state = '통신 가능', isChecked = 'true' where modem_id = '" + modemID + "';");
						//Log.i("sqlTest",DBConfig.UPDATE_MODEM(modemID, mSerialNum, address, "통신 가능", date, value, true));
						try{
							db.execSQL(DBConfig.DELETE_MODEMID_RECOLLECT_MODEMLIST + modemID + "';");
						}catch(Exception e){
							//
						}
					}
					cursor.moveToNext();
				}
				cursor.close();
			}else {
				//  삽입 불가능.
			}
			
			
			/*MeterDataVO dataVo = new MeterDataVO(mSerialNum, mLogId, mRtcValue, mValues);
			Log.e("meterValue_mValues : ",mValues);
			Log.e("meterValue_mSerialNum :", mSerialNum);
			//Log.e("mMonthlyValue : ", mMonthlyValue);
			Log.e("meterValue_mLodId : ", mLogId);
			Log.e("meterValue_mRtcValues : ", mRtcValue);
			
			dbHelper = DBHelper.getInstance(ReadListFragment.context);
			SQLiteDatabase db = dbHelper.getWritableDatabase();
			
			Log.i("meterValue", "mValues="+mValues+"mSerialNum="+mSerialNum+"mLogId="+mLogId+"mRtcValues="+mRtcValue);
			String test = "Insert into GetMeterValues values (\'" + dataVo.getMeterSerialNo() + "\', \'" + dataVo.getLogId() + "\', \'" + dataVo.getMeterDate() + "\', \'" + dataVo.getMonthlyBilingData() + "\')";
			Log.e("Query : ", test);*/
			//cursor = db.rawQuery("Insert into GetMeterValues values (\'" + dataVo.getMeterSerialNo() + "\', \'" + dataVo.getLogId() + "\', \'" + dataVo.getMeterDate() + "\', \'" + dataVo.getMonthlyBilingData() + "\')", null);
			//cursor.moveToFirst();
			
	}
	
	public static int Value_Calculator(byte[] input) {
		int multNum = 1;
		int res = 0;

		for (int i = 3 ;i >= 0; i--) {
			res += (int) (input[i] & (byte) 0x0F) * multNum;
			multNum *= 16;

			res += ((input[i] & (byte) 0xF0) >> 4) * multNum;
			multNum *= 16;
		}
		return res;
	}
}
