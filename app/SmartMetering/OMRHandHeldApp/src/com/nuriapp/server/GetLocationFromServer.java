package com.nuriapp.server;

import java.util.ArrayList;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.Activity;
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

public class GetLocationFromServer extends AsyncTask<String, Void, String> {

	private static final String NAMESPACE = "http://aimir.com/services/";
//	private static final String URL = "http://172.16.10.20:9085/aimir-web/services/AppService?wsdl";
	private static final String METHOD_NAME = "ser:getLocationList";
//	private static final String SOAP_ACTION = NAMESPACE + METHOD_NAME;
	
	private String URL = "http://";//211.232.103.234:8085/aimir-web/services/AppService";
	private String IP=null;
	private String PORT=null;
	private static final String TAIL="/aimir-web/services/AppService";

	private String resultValues = null;
	Cursor cursor;
	DBHelper dbHelper;
	ArrayList<GetLocationInfoVO>  server_modemList;
	
	Activity activity;

	public GetLocationFromServer(Activity activity)
	{
		this.activity = activity;
		//////////////////////////////////////////////////////////////////////////
		dbHelper = DBHelper.getInstance(activity.getApplicationContext());
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery("select *from server_config", null);
		cursor.moveToFirst();
		for(int i=0;i<cursor.getColumnCount();i++){
			IP = cursor.getString(0)+"."+cursor.getString(1)+"."+cursor.getString(2)+"."+cursor.getString(3);
			PORT =":"+ cursor.getString(4);
		}
		cursor.close();
		
		URL = URL+IP+PORT+TAIL;
		Log.d("GetLocationFromServer", "URL = " + URL);
		//////////////////////////////////////////////////////////////////////////
	}
	
	@Override
	protected String doInBackground(String... params) {
		// TODO Auto-generated method stub
			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME); // 네임스페이스와 메소드명을 담고 있는 SoapObject 생성 
			// Soap전문에 대한 틀 생성  
			SoapSerializationEnvelope envelope = new CustomSoapSerializationEnvelope(SoapEnvelope.VER11);	 
			// 환경구성 설정 Start
			envelope.dotNet = true;
			envelope.implicitTypes = true;
			envelope.setAddAdornments(false);
			envelope.setOutputSoapObject(request);
			// 환경구성 설정 End 
			
			// VO와 연결 
			envelope.addMapping(NAMESPACE, "GetLocationInfoVO",  new GetMeterDataVOFromServer().getClass());

			// URL 설정 
			HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
			androidHttpTransport.debug = true; // 디버깅모드 활성화 
			
			try {
				androidHttpTransport.call("", envelope); // 환경구성이 완료된 상태에서 Http 호출 

				 Log.d("", "HTTP REQUEST:\n" + androidHttpTransport.requestDump); // Request 보낸 내용이 실제로 어떻게 가는지 Dump 뜬 로그 
				 Log.d("", "HTTP RESPONSE:\n"  + androidHttpTransport.responseDump); // Response 받은 내용이 실제로 어떻게 넘어왔는지 Dump 뜬 로그 

				if (envelope.bodyIn instanceof SoapObject) { // SoapObject = SUCCESS 시 들어감 
					SoapObject response = (SoapObject) envelope.getResponse(); // 받아온 내용을 저장함. 
					ArrayList<GetLocationInfoVO> server_LocationList = new ArrayList<GetLocationInfoVO>();
					
					for (int i = 0; i < response.getPropertyCount(); i++) {
						Object property = response.getProperty(i); // 받아온 내용을 Object로 변환 
						SoapObject dataList = (SoapObject) property; // 받아온 내용을 SoapObject 형태로 변환 
						
						GetLocationInfoVO dataVO = new GetLocationInfoVO(); // VO 생성 및 값 저장 
						dataVO.setName(dataList.getProperty("name").toString());
						dataVO.setLocationId(dataList.getProperty("id").toString());
						dataVO.setSupplierId(dataList.getProperty("supplierId").toString());
						
						Log.d("dataVO", "address : " + dataVO.getName() +"/ locationID: " + dataVO.getLocationId()+ "/ supplierID : " + dataVO.getSupplierId());
						//Log.d("dataVO", "locationID: " + dataVO.getLocationId()+ "/ supplierID : " + dataVO.getSupplierId());
						
						server_LocationList.add(new GetLocationInfoVO( dataVO.getSupplierId(), dataVO.getLocationId(), dataVO.getName()));
					}
					
					
					/*dbHelper = DBHelper.getInstance(activity.getApplicationContext());
					
					ArrayList<ModemVO> sqlliteDB_ModemList = selectModemList();
					
					SQLiteDatabase db = dbHelper.getWritableDatabase(); // DB를 쓸 경우에는 getWritableDatabase, 읽을 경우에는 getReadableDatabases를 선언한다.  
					
					for(int i = 0; i < sqlliteDB_ModemList.size(); i++)
					{
						for (int j = 0; j < server_modemList.size(); j++)  {
							if(sqlliteDB_ModemList.get(i).getmModemId().equals(server_modemList.get(j).getmModemId()))
							{
								// db에 업데이트 하는 코드 작성.
								ModemVO sql_modem = sqlliteDB_ModemList.get(i);
								ModemVO server_modem = server_modemList.get(j);
								
								db.execSQL(DBConfig.UPDATE_MODEM(server_modem.getmModemId(), server_modem.getmMeterSerialNo(),
												server_modem.getmAddress(), sql_modem.getmState(), server_modem.getmDate(), server_modem.getmValue(), sql_modem.isChecked())); // Query 
								
								server_modemList.remove(j);
							}
						}
					}
					
					
					
					for (int i = 0; i < server_modemList.size(); i++)  {
						ModemVO modem = server_modemList.get(i);
						db.execSQL(DBConfig.INSERT_MODEM(modem.getmModemId(), modem.getmMeterSerialNo(),
								modem.getmAddress(), modem.getmState(), modem.getmDate(), modem.getmValue(), modem.isChecked())); // Query 
					}*/
					
					resultValues = response.toString();
				} else if (envelope.bodyIn instanceof SoapFault) { // SoapFault = FAILURE 시 들어감 
					SoapFault responseFault = (SoapFault) envelope.bodyIn;	// 실패 이유를 출력한다.
					throw new Exception(responseFault.getMessage());
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println(e);
			}
		
		return resultValues;
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
