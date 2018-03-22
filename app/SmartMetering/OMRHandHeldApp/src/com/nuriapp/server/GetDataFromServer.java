package com.nuriapp.server;

import java.util.ArrayList;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.util.Log;

import com.nuriapp.database.DBConfig;
import com.nuriapp.database.DBHelper;
import com.nuriapp.utils.CustomSoapSerializationEnvelope;
import com.nuriapp.vo.GetLocationInfoVO;
import com.nuriapp.vo.GetMeterDataVOFromServer;
import com.nuriapp.vo.ModemVO;

public class GetDataFromServer extends AsyncTask<String, Void, String> {

	private static final String NAMESPACE = "http://aimir.com/services/";
	private String URL = "http://";//211.232.103.234:8085/aimir-web/services/AppService";
	private String IP=null;
	private String PORT=null;
	private static final String TAIL="/aimir-web/services/AppService";
	private String RETRY_NUM;
	private String RETRY_SEC;
	private String TIMEOUT_SEC;
	private static final String METHOD_NAME = "ser:getMeterList";
	//	private static final String SOAP_ACTION = NAMESPACE + METHOD_NAME;
	Cursor cursor;
	DBHelper dbHelper;
	SQLiteDatabase db;

	private String resultValues = null;

	public String LocationId;
	public String SuplierId;

	ArrayList<GetLocationInfoVO> locationList = new ArrayList<GetLocationInfoVO>();
	ArrayList<ModemVO>  server_modemList;
	Context context;

	GetLocationInfoVO locationDataVO;

	public GetDataFromServer(Context context, String _ip, String _port, String _rety_sec, String _retry_num, String _timeout, String suplierID, String locationId)
	{
		this.context = context;
		this.IP = _ip;
		this.PORT = _port;
		this.RETRY_SEC = _rety_sec;
		this.RETRY_NUM = _retry_num;
		this.TIMEOUT_SEC = _timeout;

		URL = URL+IP+PORT+TAIL;

		this.SuplierId = suplierID;
		this.LocationId = locationId;
	}

	/*
	public GetDataFromServer(Context context)
	{
		this.context = context;
	}*/

	@Override
	protected String doInBackground(String... params) {
		locationDataVO = new GetLocationInfoVO(SuplierId,LocationId);
		// TODO Auto-generated method stub
		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME); // 네임스페이스와 메소드명을 담고 있는 SoapObject 생성 
		// getMeterList에 대한 메소드 호출 시 필요한 파라미터 정의 (인터페이스 정의서 참고)
		Log.i("doInBackgroundTest ", LocationId+","+SuplierId);
		
		if(LocationId == null){  
			LocationId = "1";
			locationDataVO.setLocationId(LocationId);
			updateLocationIdChecked(LocationId);
			Log.i("doInBackgroundTest_locationidTest",LocationId+"");
		}
		if(SuplierId == null){ 
			SuplierId = "1";
			locationDataVO.setSupplierId(SuplierId);
			Log.i("doInBackgroundTest_suplierIdTest", SuplierId+"");
		}
		request.addProperty("ser:arg0", Integer.parseInt(locationDataVO.getSupplierId())); 
		request.addProperty("ser:arg1", Integer.parseInt(locationDataVO.getLocationId()));
		// Soap전문에 대한 틀 생성  
		SoapSerializationEnvelope envelope = new CustomSoapSerializationEnvelope(SoapEnvelope.VER11);	 
		// 환경구성 설정 Start
		envelope.dotNet = true;
		envelope.implicitTypes = true;
		envelope.setAddAdornments(false);
		envelope.setOutputSoapObject(request);
		// 환경구성 설정 End 

		// VO와 연결 
		envelope.addMapping(NAMESPACE, "GetMeterDataVOFromServer", new GetMeterDataVOFromServer().getClass());

		// URL 설정 
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
		androidHttpTransport.debug = true; // 디버깅모드 활성화 
		
		try {
			androidHttpTransport.call("", envelope); // 환경구성이 완료된 상태에서 Http 호출 

			Log.d("", "HTTP REQUEST:\n" + androidHttpTransport.requestDump); // Request 보낸 내용이 실제로 어떻게 가는지 Dump 뜬 로그 
			Log.d("", "HTTP RESPONSE:\n"  + androidHttpTransport.responseDump); // Response 받은 내용이 실제로 어떻게 넘어왔는지 Dump 뜬 로그 

			if (envelope.bodyIn instanceof SoapObject) { // SoapObject = SUCCESS 시 들어감 
				SoapObject response = (SoapObject) envelope.getResponse(); // 받아온 내용을 저장함. 

				//meterDataArray = new GetMeterDataVOFromServer[response.getPropertyCount()]; // Response 받은 내용을 VO배열에 담는다. 

				ArrayList<ModemVO> server_modemList = new ArrayList<ModemVO>();
				Log.i("soapTest Success", response.getPropertyCount()+"");
				for (int i = 0; i < response.getPropertyCount(); i++) {
					Object property = response.getProperty(i); // 받아온 내용을 Object로 변환 
					SoapObject dataList = (SoapObject) property; // 받아온 내용을 SoapObject 형태로 변환 
					GetMeterDataVOFromServer dataVO = new GetMeterDataVOFromServer(); // VO 생성 및 값 저장 
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					/* 2016.10.15 modemId 파싱 변경으로 SoapObject 추가 */
					SoapObject modemList = (SoapObject) dataList.getProperty("modem");
					/* 2016.10.15 modemId 파싱 변경 주석 */
					//if(dataList.getProperty("modemId") != null)
						//dataVO.setModemId(dataList.getProperty("modemId").toString());
					/* 2016.10.15 modemId 파싱 변경 */
					if(modemList.getProperty("deviceSerial") != null)
						dataVO.setModemId(modemList.getProperty("deviceSerial").toString());
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					if(dataList.getProperty("mdsId") != null)
						dataVO.setMdsId(dataList.getProperty("mdsId").toString());
					if(dataList.getProperty("address") != null)
						dataVO.setAddress(dataList.getProperty("address").toString());
					if(dataList.getProperty("lastReadDate") != null)
						dataVO.setDate(dataList.getProperty("lastReadDate").toString());
					if(dataList.getProperty("lastMeteringValue") != null)
						dataVO.setValue(dataList.getProperty("lastMeteringValue").toString());

					Log.d("dataVO", "mdsid : " + dataVO.getMdsId() +"/ addr : " + dataVO.getAddress() + "/ date : " + dataVO.getDate() + "/ getModemID : " + dataVO.getModemId() + "/ value : " + dataVO.getValue());

					String date = convertServerDateToClientDate(dataVO.getDate());


					server_modemList.add(new ModemVO(dataVO.getModemId(), dataVO.getMdsId(), dataVO.getAddress(), 
							"통신 불가능", date, dataVO.getValue(), false));
				}



				/*	
				 * 
					ArrayList<ModemVO> sqlliteDB_ModemList = selectModemList();
					for(int i = 0; i < sqlliteDB_ModemList.size(); i++)
					{
						for (int j = 0; j < server_modemList.size(); j++)  {
							if(sqlliteDB_ModemList.get(i).getmModemId().equals(server_modemList.get(j).getmModemId()))
							{
								// db에 업데이트 하는 코드 작성.
								ModemVO sql_modem = sqlliteDB_ModemList.get(i);
								ModemVO server_modem = server_modemList.get(j);

								String modemID = server_modem.getmModemId();
								String meterSerialNum = server_modem.getmMeterSerialNo();
								String address = server_modem.getmAddress();
								String date =  server_modem.getmDate();
								String value = server_modem.getmValue();
								if(isValidData(modemID, meterSerialNum, address, date, value, LocationId) == true) {
									db.execSQL(DBConfig.UPDATE_MODEM(modemID, meterSerialNum,
											address, sql_modem.getmState(), date, value, sql_modem.isChecked(), LocationId)); // Query 
									server_modemList.remove(j);
									Log.d("errLog", "server download data update success / id : " + modemID);
								}else {
									Log.d("errLog", "server download data update fail / id : " + modemID);
								}

							}
						}
					}
				 */

				dbHelper = DBHelper.getInstance(context);

				SQLiteDatabase db = dbHelper.getWritableDatabase(); // DB를 쓸 경우에는 getWritableDatabase, 읽을 경우에는 getReadableDatabases를 선언한다.  

				for (int i = 0; i < server_modemList.size(); i++)  {
					ModemVO modem = server_modemList.get(i);
					String modemID = modem.getModemId();
					String meterSerialNum = modem.getMeterSerialNo();
					String address = modem.getAddress();
					String date =  modem.getDate();
					String value = modem.getValue();
					if(isValidData(modemID, meterSerialNum, address, date, value, LocationId) == true) {
						try {
						db.execSQL(DBConfig.INSERT_MODEM(modemID, meterSerialNum,
								address, modem.getState(), date, value, modem.isChecked())); // Query 
						}catch(Exception e)
						{
							
						}
						Log.d("errLog", "server download data update success / id : " + modemID);
					}else {
						Log.d("errLog", "server download data insert fail / id : " + modemID);
					}
				}

				resultValues = response.toString();
			} else if (envelope.bodyIn instanceof SoapFault) { // SoapFault = FAILURE 시 들어감 
				SoapFault responseFault = (SoapFault) envelope.bodyIn;	// 실패 이유를 출력한다.
				throw new Exception(responseFault.getMessage());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e);
			return null;
		}

		return resultValues;
	}


	public boolean isValidData(String modemId, String mdsId, String address, String lastReadDate, String lastMeteringValue, String LocationId)
	{
		boolean ret = true;

		if(modemId == null || mdsId == null || address == null || LocationId == null)
		{
			ret = false;
		}
		return ret;
	}

	private void updateLocationIdChecked(String location_id){
		dbHelper = DBHelper.getInstance(context);
		SQLiteDatabase db = dbHelper.getWritableDatabase(); // DB를 쓸 경우에는 getWritableDatabase, 읽을 경우에는 getReadableDatabases를 선언한다.  
		
		String sql = "update location set ischeck ='true' where location_id = '" + location_id + "';";
		db.execSQL(sql);
	}

	private String convertServerDateToClientDate(String serverDate){
		String clientDate = null;

		if(serverDate != null && serverDate.length() > 13)
			clientDate = serverDate.substring(0, 4) + "-" + serverDate.substring(4, 6) + "-" + serverDate.substring(6, 8) + " " + serverDate.substring(8, 10) + ":" + serverDate.substring(10, 12)+":" + serverDate.substring(12, 14);

		return clientDate;
	}



	private ArrayList<ModemVO> selectModemList() {

		ArrayList<ModemVO> list = new ArrayList<ModemVO>();

		// TODO Auto-generated method stub
		list.clear();
		SQLiteDatabase db = dbHelper.getReadableDatabase();

		cursor = db.rawQuery(DBConfig.SELECT_MODEMLIST, null);
		cursor.moveToFirst();
		// List input DBdata
		for (int i = 0; i < cursor.getCount(); i++) {
			boolean isCheck = (cursor.getInt(6) == 0) ? false : true;
			list.add(new ModemVO(cursor.getString(0), cursor.getString(1), cursor.getString(2),
					cursor.getString(3), cursor.getString(4), cursor.getString(5), isCheck));

			cursor.moveToNext();
		}
		return list;
	}

}
