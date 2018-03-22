package com.nuriapp.server;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.util.Log;

import com.nuriapp.database.DBConfig;
import com.nuriapp.database.DBHelper;
import com.nuriapp.utils.CustomSoapSerializationEnvelope;
import com.nuriapp.utils.MarshalDouble;
import com.nuriapp.vo.SaveMeterDataVO;

public class SavedMeterDataToServer extends AsyncTask<String, Void, String> {
	private static final String NAMESPACE = "http://aimir.com/services/";	
	private  String URL = "http://";//211.232.103.234:8085/aimir-web/services/AppService";
	private  String IP=null;
	private  String PORT=null;
	private  final String TAIL="/aimir-web/services/AppService";
	private  String RETRY_NUM;
	private  String RETRY_SEC;
	private  String TIMEOUT_SEC;
	private static final String METHOD_NAME = "ser:saveMeterData";
	//	private static final String SOAP_ACTION = NAMESPACE + METHOD_NAME;

	//public static Activity activity;
	public Context context;
	private String resultValues = null;
	SQLiteDatabase db;
	
	private String modem_serial;
	private String modem_date;
	private String modem_DataType= "Month";
	private String modem_value;
	
	public SavedMeterDataToServer(Context context, String _ip, String _port, String _rety_sec, String _retry_num, String _timeout, String _modem_serial, String _modem_date, String _modem_value)
	{
		this.context = context;
		this.IP = _ip;
		this.PORT = _port;
		this.RETRY_SEC = _rety_sec;
		this.RETRY_NUM = _retry_num;
		this.TIMEOUT_SEC = _timeout;
		
		URL = URL+IP+":"+PORT+TAIL;
		this.modem_serial = _modem_serial;
		this.modem_date = _modem_date.replaceAll("-", "").replaceAll(":", "").replaceAll(" ", "").substring(0,8);
		this.modem_value = _modem_value;		
	}
	
	Cursor cursor;
	DBHelper dbHelper;
	
	
//	SaveMeterDataVO meterDataArray[];
	@Override
	protected String doInBackground(String... params) {
		
		Log.i("~~~~~~~~~","~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

//		Log.i("~~~~~URL  ~~~",URL+"");
		// TODO Auto-generated method stub
			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
			//Double meterValues = 16.25;
			SoapObject parentValues = new SoapObject("", "ser:arg3"); // 인터페이스 정의서를 보면 한 스탭 안으로 들어가는 부분이 있어서 별도로 생성하여 그 하위 개념에 집어넣기 위함. 

			request.addProperty("ser:arg0",this.modem_serial);
			request.addProperty("ser:arg1",this.modem_date);
			request.addProperty("ser:arg2","Month");
			parentValues.addProperty("ser:double",this.modem_value);
//			request.addProperty("ser:arg0",this.modem_serial);
//			request.addProperty("ser:arg1","20150701");
//			request.addProperty("ser:arg2","Month");
//			parentValues.addProperty("ser:double",16.56);
			
			request.addSoapObject(parentValues);
			
			SoapSerializationEnvelope envelope = new CustomSoapSerializationEnvelope(
					SoapEnvelope.VER11);
			MarshalDouble marshal = new MarshalDouble(); // Double형을 서버로 전송하기 위해서는 별도의 Serializing 하기 위해 사용하는 메소드  
			marshal.register(envelope); // marshal을 이용한 환경 등록 
			
			
			envelope.dotNet = true;
			envelope.implicitTypes = true;
			envelope.setAddAdornments(false);
			envelope.setOutputSoapObject(request);
			
			envelope.addMapping(NAMESPACE, "SaveMeterDataVO",
				     new SaveMeterDataVO().getClass());

			HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
			androidHttpTransport.debug = true;
			

			try { // ResponseDump를 통해 true값 나오면 성공 (인터페이스정의서 참고) 
				androidHttpTransport.call("", envelope);

				 Log.d("", "HTTP REQUEST:\n" + androidHttpTransport.requestDump);
				 Log.d("", "HTTP RESPONSE:\n" + androidHttpTransport.responseDump);

				if (envelope.bodyIn instanceof SoapObject) { // SoapObject = SUCCESS
					SoapObject response = (SoapObject) envelope.getResponse();
//					Log.d("", "HTTP RESPONSE: response.getProperty(0) \n" + response.getProperty(0));
					String res = response.getPropertyAsString(0);
//					Log.d("", "HTTP RESPONSE: res \n" + res);
					if(res.equalsIgnoreCase("true")){
						// 수집 응답 True 일때
						dbHelper = DBHelper.getInstance(context);
						SQLiteDatabase db = dbHelper.getWritableDatabase();
						db.execSQL("update modemlist_storage set modem_state = '전송완료', isCheckd = 'false' where modem_serialnum = '" + modem_serial + "';"); // Query 
						Log.i("sqlite", "update modemlist_storage set modem_state = '전송완료' where modem_serialnum = '" + modem_serial + "';");
					}else{
						// 수집 응답 false
						/*dbHelper = DBHelper.getInstance(context);
						SQLiteDatabase db = dbHelper.getWritableDatabase();
						db.execSQL("update modemlist_storage set modem_state = '전송완료', isCheckd = 'false' where modem_serialnum = '" + modem_serial + "';"); // Query 
						Log.i("sqlite", "update modemlist_storage set modem_state = '전송완료' where modem_serialnum = '" + modem_serial + "';");*/
					}
					
					//resultValues = response.toString();
				} else if (envelope.bodyIn instanceof SoapFault) { // SoapFault = FAILURE
					SoapFault responseFault = (SoapFault) envelope.bodyIn;
					throw new Exception(responseFault.getMessage());
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		
		return resultValues;
	}
}




