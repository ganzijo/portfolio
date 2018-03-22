package com.nuriapp.database;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.nuriapp.omrhandheldapp.ReadListFragment;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DBConfig {
	// USER_INFO
	public static final String SELECT_USER_INFO = "SELECT * FROM user_info";
	public static final String UPDATE_AUTOLOGIN_TRUE = "UPDATE user_info SET autologin = 'true' WHERE username = 'admin'";
	public static final String UPDATE_AUTOLOGIN_FALSE = "UPDATE user_info SET autologin = 'false' WHERE username = 'admin'";
	public static final String UPDATE_SAVEID_TRUE = "UPDATE user_info SET saveid = 'true' WHERE username = 'admin'";
	public static final String UPDATE_SAVEID_FALSE = "UPDATE user_info SET saveid = 'false' WHERE username = 'admin'";
	public static final String UPDATE_USER_LOGOUT = "UPDATE user_info SET autologin = 'false', saveid = 'false' WHERE username = 'admin'";


	// modem list
	public static final String TABLENAME_MODEMLIST = "readModem";
	public static final String SELECT_MODEMLIST = "select * from modemlist order by modem_id asc;";
	public static final String DELETE_MODEM = "delete from modemlist;";
	
	public static String SELECT_MODEM_BY_SERIAL(String serialNum)
	{
		return "select * from modemlist where modem_serialnum = '" + serialNum + "';";
	}
	
	public static String UPDATE_MODEM(String modem_id, String serialNum, String addr, String state, String date, String value, Boolean isChecked) {
		String strChecked = (isChecked==true)?"true":"false";
		
		return "update modemlist set modem_id = '" + modem_id + "', modem_serialnum = '" + serialNum + "', modem_address = '" + addr +
				"', modem_state = '" +  state + "', modem_date = '" +  date + "', modem_value = '" + value + "', isChecked = '" + strChecked +  "' where modem_id = '" + modem_id + "';";  
	}
	
	public static String INSERT_MODEM(String modem_id, String serialNum, String addr, String state, String date, String value, Boolean isChecked) {
		String strChecked = (isChecked==true)?"true":"false";
		return "insert into modemlist values('" + modem_id + "', '" + serialNum + "', '" + addr + "', '" + state + "', '" + date + "', '" + value + "', '" + strChecked  + "');"; 
	}

	// ele meter list
	public static final String TABLENAME_ELECMETER = "elecMeter";

	// recollect modem list
	public static final String TABLENAME_RECOLLECT_MODEMLIST = "recollect";
	public static final String SELECT_RECOLLECT_MODEMLIST = "select * from recollect_modemlist";
	public static final String DELETE_RECOLLECT_MODEMLIST = "delete from recollect_modemlist";
	public static final String DELETE_MODEMID_RECOLLECT_MODEMLIST = "delete from recollect_modemlist where modem_id ='";

	public static String INSERT_RECOLLECTMODEM(String modem_id, String serialNum, String addr, String state, String date, String value, Boolean isChecked) {
		String strChecked = (isChecked==true)?"true":"false";
		return "insert into recollect_modemlist values('" + modem_id + "', '" + serialNum + "', '" + addr + "', '" + state + "', '" + date + "', '" + value + "', '" + strChecked  + "');"; 
	}
	
	public static String UPDATE_RECOLLECTMODEM(String modem_id, String serialNum, String addr, String state, String date, String value, Boolean isChecked) {
		String strChecked = (isChecked==true)?"true":"false";
		return "update recollect_modemlist set modem_id = '" + modem_id + "', modem_serialnum = '" + serialNum + "', modem_address = '" + addr +
				"', modem_state = '" +  state + "', modem_date = '" +  date + "', modem_value = '" + value + "', isChecked = '" + strChecked +  "' where modem_id = '" + modem_id + "';";  
	}
	
	// collect modem list
	public static final String TABLENAME_STORAGE_MODEMLIST = "modemlist_storage";
	public static final String SELECT_STORAGE_MODEMLIST = "select * from modemlist_storage;";
	
	/*	public static String INSERT_COLLECT_MODEM(String modem_id, String serialNum, String addr, String state, String date, String value, Boolean isChecked) {
		String strChecked = (isChecked==true)?"true":"false";
		return "insert into modemlist values('" + modem_id + "', '" + serialNum + "', '" + addr + "', '" + state + "', '" + date + "', '" + value + "', '" + strChecked  + "');"; 
	}
	public static String UPDATE_COLLECT_MODEM(String modem_id, String serialNum, String addr, String state, String date, String value, Boolean isChecked) {
		String strChecked = (isChecked==true)?"true":"false";
		return "update modemlist_storage set modem_id = '" + modem_id + "', modem_serialnum = '" + serialNum + "', modem_address = '" + addr +
				"', modem_state = '" +  state + "', modem_date = '" +  date + "', modem_value = '" + value + "', isChecked = '" + strChecked +  "' where modem_id = '" + modem_id + "';";  
	}*/
	//Insert modemlist_storage
	 public static String get_INSERT_MODEMLIST_STORAGE(String modem_id, String modem_serialnum, String modem_address, String modem_state, String modem_date, String modem_value, Boolean isChecked){
	  String strChecked = (isChecked==true)?"true":"false";
	  // Today
	  Calendar calendar = Calendar.getInstance();
	  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
	  String collect_date =  dateFormat.format(calendar.getTime());
	  
	  String INSERT_MODEMLIST_STORAGE = "insert into modemlist_storage(modem_id, modem_serialnum, modem_address, modem_state, modem_date, modem_value, isCheckd, collect_date) values('" + modem_id + "', '" + modem_serialnum + "', '" + modem_address + "', '" + modem_state + "', '" + modem_date + "', '" + modem_value + "', '" + strChecked + "', '" + collect_date +"');";
	  return INSERT_MODEMLIST_STORAGE;
	 }
	 
	 //Update modemlist_storage
	 public static String get_UPDATE_MODEMLIST_STORAGE(String modem_id, String modem_serialnum, String modem_address, String modem_state, String modem_date, String modem_value, Boolean isChecked){
	  String strChecked = (isChecked==true)?"true":"false";
	  
	  // Today
	  Calendar calendar = Calendar.getInstance();
	  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
	  String collect_date =  dateFormat.format(calendar.getTime());
	  
	  String INSERT_MODEMLIST_STORAGE = "update modemlist_storage set modem_id = '" + modem_id  + "', modem_serialnum ='" + modem_serialnum + "', modem_address = '" + modem_address + "', modem_state = '"+ modem_state + "', modem_date ='" + modem_date + "', modem_value = '" + modem_value + "', isCheckd='" + strChecked + "' , collect_date = '" + collect_date + "', isDeleted = 'false' where modem_serialnum = '" + modem_serialnum + "';";
	  return INSERT_MODEMLIST_STORAGE;
	 }
	 // isDeleted Update Query
	  public static String get_EXPRITY_UPDATE_ISDELETED(
	   /* String whereDate */String save_period) {
	  // 유효기간 날짜 구하기
	  Calendar calendar = Calendar.getInstance();
	  calendar.add(Calendar.DAY_OF_MONTH, /*-7*/-1 * Integer.parseInt(save_period));
	  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
	  String whereDate = dateFormat.format(calendar.getTime());
	  String UPDATE_IS_DELETED = "update modemlist_storage set isDeleted = 'true' where collect_date < '" + whereDate + "'";
	  return UPDATE_IS_DELETED;
	 }
	
	// setting - location
	public static final String SELECT_LOCATION = "select * from location;";
	
	//setting - serverConfig
	public static final String UPDATE_SERVER_CONFIG = "UPDATE  server_config SET ";
	
	//1:N Scan Query
	public static final String SELECT_SCAN_MODEM_ID_LIST = "select modem_id from modemlist where modem_id is not null order by modem_id asc;";
	//1:N Collect Query
	public static final String SELECT_COLLECT_MODEM_ID_LIST = "select modem_id from modemlist where isChecked = 'true' order by modem_id asc;";
	
	//TimeOut Recollect Query
	public static final String SELECT_RECOLLECT_MODEM_ID_LIST = "select * from modemlist where modem_id = '";
	//TimeOut 통신불가 Recollect Delete Query
	public static final String DELETE_RECOLLECT_MODEM_ID_LIST = "delete from recollect_modemlist where modem_id = '";
	
	// Detail 검침실패 Query
	public static final String DETAIL_FAIL = "select * from modemlist where modem_state = '통신 불가능'"; 
	
	// ElectMeter Search Query
	public static final String ELECMETER_SEARCH = "select * from modemlist where ";
	
	
	//TEST
	//public static final String SELECT_READMODEMSTORAGE_TEST = "select *from readModemStorage;";

	// STORAGE_INFO
	//public static final String SELECT_MODEMTEST_LIST= "select *from storageTest order by lastLinkTime asc ;";

	/*
	//MODEM_INFO TEST

	//public static final String tablename_readModemDataStorage = "ModemData_Collect";
	public static final String SELECT_MODEM_LIST= "select *from modem order by lastLinkTime desc;";
	public static final String SELECT_MODEMDATA_COLLECT = "select *from ModemData_Collect order by lastLinkTime desc;";

	//TEST
	public static final String SELECT_READMODEM_TEST = "select * from readModemTest;";
	public static final String SELECT_ELECMETER_TEST="select *from elecMeter;";
	
	 
	public static String get_INSERT_readModemStorage(String mDate,String mState, String mModemId, String mAddress) {
		// TODO Auto-generated method stub
		String sql = "insert into ModemData_Collect values ('" + mDate + "','" + mState +"','" +mModemId + "', '" + mAddress + "');";
		Log.i("sqlTest", sql);

		return sql;
	}
	*/



}
