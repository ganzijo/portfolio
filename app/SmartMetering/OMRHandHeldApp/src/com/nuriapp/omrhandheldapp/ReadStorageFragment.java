package com.nuriapp.omrhandheldapp;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.BatteryManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.ContactsContract.Contacts.Data;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import au.com.bytecode.opencsv.CSVWriter;

import com.nuriapp.adapter.ModemStorageAdapter;
import com.nuriapp.database.DBConfig;
import com.nuriapp.database.DBHelper;
import com.nuriapp.server.SavedMeterDataToServer;
import com.nuriapp.utils.CustomDialog;
import com.nuriapp.utils.NetworkUtil;
import com.nuriapp.utils.NoticeDialog;
import com.nuriapp.utils.ReadStorageTaskProgress;
import com.nuriapp.vo.ModemStorageVO;

public class ReadStorageFragment extends Fragment implements OnClickListener {

	private Button btn_today, btn_3day, btn_weekly, btn_monthly,
	btn_DayBack, btn_DayAfter,
	btn_ReadStorage_Network_Submit, btn_ReadStorage_USB_Submit,
	btn_ReadStorage_Delete, btn_Period_Search_Btn;
	private TextView  readStorageListNum,endDay,startDay;

	private CheckBox ck_AllCollect;
	
	NoticeDialog usb_NoticeDialog;
	CustomDialog usb_CustomDialog;
	NoticeDialog delete_NoticeDialog;
	CustomDialog delete_CustomDialog;
	CustomDialog networkDialog;

	FragmentTabHost fragmentTabHost;
	//private MeterCollectAdapter adapter;
	ListView ReadmodemStorage_ModemList;
	ModemStorageAdapter  mReadModemStorageAdapter;
	ArrayList<ModemStorageVO> mReadModemStorageList;
	ArrayList<String> CSVAL;
	
	
	DBHelper dbHelper;
	

	Handler handler = new Handler();
	
	public static Context con;
	
	//Current Date get 
	Calendar calender;
	Date date;
	SimpleDateFormat sdfNow;
	String str_search_end_day;
	String str_search_start_day;

	public static final String DAY_TODAY= "TODAY";
	public static final String DAY_3DAYS = "3DYAS";
	public static final String DAY_WEEKLY = "WEEKLY";
	public static final String DAY_MONTH ="MONTH";
	public static String SELECT_DAY = DAY_TODAY;
	
	/////////////////////////////////////////////////////////////////Server Create Start//////////////////////////////////////////////////////////////
	//환경설정 -서버전송
	private String IP=null;
	private String PORT=null;
	private String RETRY_NUM;
	private String RETRY_SEC;
	private String TIMEOUT_SEC;
//	private String LOCATION_ID;
//	private String SUPLIER_ID;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Typeface typeFaceBody = Typeface.createFromAsset(getActivity().getAssets(), "fonts/sangsang_font/SangSangBodyL.ttf");
		View rootView = inflater.inflate(R.layout.main_tab_page_readstorage_fragmentpage, container,false);

		// 1일, 3일, 7일, 한달 버튼 
		btn_today = (Button) rootView.findViewById(R.id.btn_today);
		btn_today.setTypeface(typeFaceBody);
		btn_today.setOnClickListener(this);
		btn_3day = (Button) rootView.findViewById(R.id.btn_3day);
		btn_3day.setTypeface(typeFaceBody);
		btn_3day.setOnClickListener(this);
		btn_weekly = (Button) rootView.findViewById(R.id.btn_weekly);
		btn_weekly.setTypeface(typeFaceBody);
		btn_weekly.setOnClickListener(this);
		btn_monthly = (Button) rootView.findViewById(R.id.btn_monthly);
		btn_monthly.setTypeface(typeFaceBody);
		btn_monthly.setOnClickListener(this);
		btn_Period_Search_Btn = (Button)rootView.findViewById(R.id.btn_period_search_btn);
		btn_Period_Search_Btn.setTypeface(typeFaceBody);
		btn_Period_Search_Btn.setOnClickListener(this);
		

		//모뎀목록 리스트
		ReadmodemStorage_ModemList = (ListView) rootView.findViewById(R.id.lv_ReadmodemStorage_ModemList);

		//검침보관함 List개수 출력 text
		readStorageListNum = (TextView)rootView.findViewById(R.id.tv_readStorageListNum);
		endDay = (TextView)rootView.findViewById(R.id.tv_EndDay);
		endDay.setTypeface(typeFaceBody);
		startDay = (TextView)rootView.findViewById(R.id.tv_StartDay);
		startDay.setTypeface(typeFaceBody);

		//네트워크, usb, 삭제 버튼
		btn_ReadStorage_Network_Submit = (Button) rootView.findViewById(R.id.btn_NetworkSubmit);
		btn_ReadStorage_Network_Submit.setTypeface(typeFaceBody);
		btn_ReadStorage_Network_Submit.setOnClickListener(this);
		btn_ReadStorage_USB_Submit = (Button) rootView.findViewById(R.id.btn_USBSubmit);
		btn_ReadStorage_USB_Submit.setOnClickListener(this);
		btn_ReadStorage_USB_Submit.setTypeface(typeFaceBody);
		btn_ReadStorage_Delete = (Button) rootView.findViewById(R.id.btn_Storagedelete);
		btn_ReadStorage_Delete.setTypeface(typeFaceBody);
		btn_ReadStorage_Delete.setOnClickListener(this);
		
		
		btn_DayBack = (Button)rootView.findViewById(R.id.btn_DayBack);
		btn_DayBack.setOnClickListener(this);
		btn_DayAfter = (Button)rootView.findViewById(R.id.btn_DayAfter);
		btn_DayAfter.setOnClickListener(this);
		ck_AllCollect = (CheckBox)rootView.findViewById(R.id.ck_AllCollect);
		ck_AllCollect.setOnClickListener(this);

		// Initial Loading
		btn_today.setSelected(true);
		mReadModemStorageList = new ArrayList<ModemStorageVO>();

		// DB Setting
		dbHelper = DBHelper.getInstance(this.getActivity());

		// Adapter Create
		mReadModemStorageAdapter = new ModemStorageAdapter(this.getActivity(),selectStorageModemList());
		ReadmodemStorage_ModemList.setAdapter(mReadModemStorageAdapter);
		
		//default startDay, end Day
		calender = Calendar.getInstance();
		sdfNow = new SimpleDateFormat("yyyy-MM-dd" );
		date = calender.getTime();
		
		
		str_search_start_day = sdfNow.format(date);
		str_search_end_day = sdfNow.format(date);
		endDay.setText(str_search_end_day);
		startDay.setText(str_search_start_day);
		mReadModemStorageAdapter.updateReadModelList(selectStorageModemList());
		readStorageListNum.setText("" + Integer.toString(mReadModemStorageAdapter.getCount()));
		
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery("select *from server_config", null);
		cursor.moveToFirst();
		for(int i=0;i<cursor.getColumnCount();i++){
		IP = cursor.getString(0)+"."+cursor.getString(1)+"."+cursor.getString(2)+"."+cursor.getString(3);
		PORT = cursor.getString(4);
		RETRY_SEC = cursor.getString(5);
		RETRY_NUM = cursor.getString(6);
		TIMEOUT_SEC = cursor.getString(7);
		}

		return rootView;

	}
	
	
	private ArrayList<ModemStorageVO> selectStorageModemList() {
		// TODO Auto-generated method stub
		mReadModemStorageList.clear();
		SQLiteDatabase db = dbHelper.getReadableDatabase();

		//Cursor cursor = db.rawQuery(DBConfig.SELECT_STORAGE_MODEMLIST, null);
		Log.i("str_search_start_day", str_search_start_day+"");
		Log.i("str_search_end_day", str_search_end_day+"");
		str_search_start_day += " 00:00:00";
		str_search_end_day += " 23:59:59";
		
		String query;
		query = "select *from modemlist_storage where collect_date between'" +str_search_start_day + "' and '" +str_search_end_day + "' ;" ;

		Cursor cursor = db.rawQuery(query, null);
		Log.i("sqlTest", "select *from modemlist_storage where collect_date >='" +str_search_start_day + "' and collect_date <='" +str_search_end_day + "' ;");
		cursor.moveToFirst();
		// List input DBdata
		for (int i = 0; i < cursor.getCount(); i++) {
			boolean isDeleted =  (cursor.getString(8).equals("false")) ? false : true;
			if(isDeleted == true)
				continue;
			
			Log.i("sqlTest",cursor.getCount()+"");
			boolean isCheck = (cursor.getString(6).equals("false")) ? false : true;
			Log.i("cursor.getString(7)",cursor.getString(7)+"");
			mReadModemStorageList.add(new ModemStorageVO(cursor.getString(0), cursor.getString(1), cursor.getString(2),
					cursor.getString(3), cursor.getString(4), cursor.getString(5), isCheck, cursor.getString(7), false));
			Log.i("sqlTest",  cursor.getString(7)+"");
			cursor.moveToNext();
		}
		cursor.close();
		return mReadModemStorageList;
	}
	

	// 0 default // -1 back // +1 front
	private void daySetting(String day, int front_back) {

		if(front_back == 0) {
			// 같은 탭을 다시 누른 경우 초기화 안되게 하기 위해.
			if (day.equals(SELECT_DAY))
				return;
			else {
				calender = Calendar.getInstance();
				if(day.equals(DAY_3DAYS)) {
					calender.add(Calendar.DATE, - 2);
					ck_AllCollect.setChecked(false);
				}else if(day.equals(DAY_WEEKLY)) {

					ck_AllCollect.setChecked(false);
					calender.add(Calendar.DATE, - 6);
				}else if(day.equals(DAY_MONTH)) {

					ck_AllCollect.setChecked(false);
					calender.add(Calendar.DATE, - 29);
				}
			}
		}

		// 하루 단위는 이전의 end날짜가 start날짜와 같으므로 영향을 안끼치기 때문에 임의로 조정한다.
		if(front_back != 0 && day.equals(DAY_TODAY))
			calender.add(Calendar.DATE, +front_back);


		// back btn -  날짜 재조정을 위해
		if( front_back == -1) {
			if(day.equals(DAY_3DAYS)) {
				calender.add(Calendar.DATE, + ( front_back * 2 * 2 ) - 1);
			}else if(day.equals(DAY_WEEKLY)) {
				calender.add(Calendar.DATE, + ( front_back * 2 * 6 ) - 1);
			}else if(day.equals(DAY_MONTH)) {
				calender.add(Calendar.DATE, + ( front_back * 2 * 29 ) - 1);
			}
		}else if ( front_back == 1) { 
			if(day.equals(DAY_TODAY) == false)
				calender.add(Calendar.DATE, +1);
		}

		// start day
		date = calender.getTime();
		str_search_start_day = sdfNow.format(date);

		// end day
		if(day.equals(DAY_TODAY)) {
			ReadStorageFragment.SELECT_DAY = DAY_TODAY;
		}else if(day.equals(DAY_3DAYS)) {
			ReadStorageFragment.SELECT_DAY = DAY_3DAYS;
			calender.add(Calendar.DATE, + 2);
		}else if(day.equals(DAY_WEEKLY)) {
			ReadStorageFragment.SELECT_DAY = DAY_WEEKLY;
			calender.add(Calendar.DATE, + 6);
		}else if(day.equals(DAY_MONTH)) {
			ReadStorageFragment.SELECT_DAY = DAY_MONTH;
			calender.add(Calendar.DATE, + 29);
		}

		date = calender.getTime();
		str_search_end_day = sdfNow.format(date);

		endDay.setText(str_search_end_day);
		startDay.setText(str_search_start_day);
		
		if(front_back==0) {
			mReadModemStorageAdapter.updateReadModelList(selectStorageModemList());
			readStorageListNum.setText("" + Integer.toString(mReadModemStorageAdapter.getCount()));
		}
	}
	
	
	
	
	public void USB(){
		
		SQLiteDatabase CSV_db = dbHelper.getWritableDatabase();
		CSVAL = new ArrayList<String>();
		for (int i = 0; i < mReadModemStorageAdapter.getCount(); i++) {
			ModemStorageVO data = (ModemStorageVO) mReadModemStorageAdapter.getItem(i);
			if (data.isChecked()) {
				String mModemId = data.getModemId().toString();
				CSVAL.add(mModemId);
				//Log.i("string ", CSVAL.get(i).toString());
				try {
					//db.execSQL("delete from readModemStorage where modemId = '" + mModemId + "';");
				} catch (Exception e) {
					Log.d("error", e.getMessage());
				}
			}
		}
		
		//Current Date get 
		Calendar cvs_calender;
		Date cvs_date;
		SimpleDateFormat cvs_sdfNow;
		//default startDay, end Day
		cvs_calender = Calendar.getInstance();
		cvs_sdfNow = new SimpleDateFormat("yyyyMMdd_hh시mm분ss초" );
		cvs_date = calender.getTime();
		String str_csv_date = cvs_sdfNow.format(cvs_date);
		
		//File dbFile = this.getActivity().getDatabasePath("smartmetering.db");
		File dbFile = this.getActivity().getDatabasePath("nurismartmeteringdb.db");
		//dbHelper = DBHelper.getInstance(this.getActivity());
		//DBHelper dbhelper = new DB(getApplicationContext());
		//외부 저장소의 최상위 경로를 반환
		File exportDir = new File(Environment.getExternalStorageDirectory(), "/Temp");
		if (!exportDir.exists()) {
			exportDir.mkdirs();
		}
		File file = new File(exportDir, str_csv_date+ ".csv");
		try {
			file.createNewFile();
			CSVWriter csvWrite=new CSVWriter(new OutputStreamWriter(new FileOutputStream(file), "EUC-KR"));
			//CSVWriter csvWrite = new CSVWriter(new FileWriter(file));
			SQLiteDatabase db = dbHelper.getReadableDatabase();
			//Cursor curCSV = db.rawQuery( "select *from readModemStorage;", null);
			//csvWrite.writeNext(curCSV.getColumnNames());
			
			Cursor curCSV = db.rawQuery( "select *from modemlist_storage;", null);
			csvWrite.writeNext("모뎀 ID", "미터 시리얼","주소","업로드 상태","검침 시간", "검침 값");
			Log.i(" CSVAL.size()", ""+CSVAL.size());
			while (curCSV.moveToNext()) {
				// Which column you want to exprort
				for (int i = 0; i < CSVAL.size(); i++) {
					Log.i("curCSV_test", ""+curCSV.getString(1));
					Log.i("curCSV_test", ""+CSVAL.get(i));
					if(curCSV.getString(0).equals(CSVAL.get(i))){
						//CSVAL.get(i)
						String arrStr[] = { curCSV.getString(0), curCSV.getString(1),curCSV.getString(2),curCSV.getString(3),curCSV.getString(4),curCSV.getString(5)};
						Log.i("curCSV.getString()", curCSV.getString(0)+","+curCSV.getString(1) +","+curCSV.getString(2)+","+curCSV.getString(3)+","+curCSV.getString(4)+","+curCSV.getString(5));
						csvWrite.writeNext(arrStr);
					}
				}
				
			}
			//file.
			csvWrite.close();
			curCSV.close();
			Toast.makeText(getActivity().getApplicationContext(), "USB전송 및 백업 완료", Toast.LENGTH_SHORT).show();
		} catch (Exception sqlEx) {
			Log.e("MainActivity", sqlEx.getMessage(), sqlEx);
			Toast.makeText(getActivity().getApplicationContext(), "USB전송 및 백업 실패", Toast.LENGTH_SHORT).show();
		}
	}
	
	
	public void  checkListDelete()
	{
		final SQLiteDatabase readStorage_deleteDB = dbHelper.getWritableDatabase();
		for (int i = 0; i < mReadModemStorageAdapter.getCount(); i++) {
			ModemStorageVO data = (ModemStorageVO) mReadModemStorageAdapter.getItem(i);
			if(data.isChecked())
				readStorage_deleteDB.execSQL("delete from modemlist_storage where modem_id = '" + data.getModemId() + "';");
		}
		mReadModemStorageAdapter.updateReadModelList(selectStorageModemList());
		readStorageListNum.setText("" + Integer.toString(mReadModemStorageAdapter.getCount()));
		mReadModemStorageAdapter.notifyDataSetChanged(); 
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_today:
			btn_today.setSelected(true);
			btn_3day.setSelected(false);
			btn_weekly.setSelected(false);
			btn_monthly.setSelected(false);
			daySetting(DAY_TODAY, 0);
			//new ReadStorageTaskProgress(this.getActivity()).execute(mReadModemStorageAdapter.getCount());
			
			break;

		case R.id.btn_3day:
			btn_today.setSelected(false);
			btn_3day.setSelected(true);
			btn_weekly.setSelected(false);
			btn_monthly.setSelected(false);
			daySetting(DAY_3DAYS, 0);
			//new ReadStorageTaskProgress(this.getActivity()).execute(mReadModemStorageAdapter.getCount());
			break;

		case R.id.btn_weekly:
			btn_today.setSelected(false);
			btn_3day.setSelected(false);
			btn_weekly.setSelected(true);
			btn_monthly.setSelected(false);
			daySetting(DAY_WEEKLY, 0);
			//new ReadStorageTaskProgress(this.getActivity()).execute(mReadModemStorageAdapter.getCount());

			break;

		case R.id.btn_monthly:
			btn_today.setSelected(false);
			btn_3day.setSelected(false);
			btn_weekly.setSelected(false);
			btn_monthly.setSelected(true);
			daySetting(DAY_MONTH, 0);
			//new ReadStorageTaskProgress(this.getActivity()).execute(mReadModemStorageAdapter.getCount());
			break;

		case R.id.btn_DayBack:
			Log.i("currnet Select Day,DAY_BACK ,DAY_AFTER ",ReadStorageFragment.SELECT_DAY);
			daySetting(ReadStorageFragment.SELECT_DAY, -1);
			break;

		case R.id.btn_DayAfter:
			Log.i("currnet Select Day,DAY_BACK ,DAY_AFTER ",ReadStorageFragment.SELECT_DAY );
			daySetting(ReadStorageFragment.SELECT_DAY, 1);
			break;

		case R.id.btn_period_search_btn:
			mReadModemStorageAdapter.updateReadModelList(selectStorageModemList());
			ck_AllCollect.setChecked(false);
			readStorageListNum.setText("" + Integer.toString(mReadModemStorageAdapter.getCount()));
			//new ReadStorageTaskProgress(this.getActivity()).execute(mReadModemStorageAdapter.getCount());
			break;
			
		case R.id.ck_AllCollect:
			mReadModemStorageAdapter.setAllChecked(ck_AllCollect.isChecked());
			mReadModemStorageAdapter.notifyDataSetChanged(); 
			break;
			
		case R.id.btn_USBSubmit:
			boolean Check = false;
			/*NetworkUtil networkUtil = new NetworkUtil();
			con = getActivity().getApplicationContext();
			int networkStates = networkUtil.getConnectivityStatus(con);
			Intent intent = con.registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
			int plugged = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
			int state = intent.getIntExtra(
					String.valueOf(BatteryManager.BATTERY_PLUGGED_USB), -1);
			Log.i("plugged : ", String.valueOf(plugged));
			Log.i("state : ", String.valueOf(state));
			if (plugged != 2) {
				Log.i("USB연결 실패", "USB를 연결해 주세요.");
				networkDialog = new CustomDialog(this, "USB연결 실패", "USB를 연결해 주세요", false, false);
				networkDialog.show();
			}*/
			
			for (int i = 0; i < mReadModemStorageAdapter.getCount(); i++) {
				ModemStorageVO data = (ModemStorageVO) mReadModemStorageAdapter.getItem(i);
				if (data.isChecked()) {
					Check = true;
					break;
				}
			}
			if(Check == true) {
				usb_NoticeDialog = new NoticeDialog(this, "USB전송", "선택한 목록을 정말로 전송할까요?", false, true, "USB");
				usb_NoticeDialog.show();
			}else{
				usb_CustomDialog = new CustomDialog(this, "USB전송",  "선택된 항목이 없습니다. \n\n항목을 선택해주세요.", false, false);
				usb_CustomDialog.show();
			}
			
			break;
			
	
		case R.id.btn_Storagedelete:
		/*	// DB에 저장
			SQLiteDatabase db = dbHelper.getWritableDatabase();
			for (int i = 0; i < mReadModemStorageAdapter.getCount(); i++) {
				ReadModemStorageVO data = (ReadModemStorageVO) mReadModemStorageAdapter.getItem(i);
				if (data.isCheck()) {
					
					String mModemId = data.getModemId().toString();
					
					try {
						db.execSQL("delete from readModemStorage where modemId = '" + mModemId + "';");
					} catch (Exception e) {
						Log.d("error", e.getMessage());
					}
				}
			}
			mReadModemStorageAdapter.updateReadModelList(selectList());
			readStorageListNum.setText("" + Integer.toString(mReadModemStorageAdapter.getCount()));
			
			mReadModemStorageAdapter.notifyDataSetChanged(); 
			*/

			boolean is_Check = false;
			for (int i = 0; i < mReadModemStorageAdapter.getCount(); i++) {
				ModemStorageVO data = (ModemStorageVO) mReadModemStorageAdapter.getItem(i);
				if (data.isChecked()) {
					is_Check = true;
					break;
				}
			}
			if(is_Check == true) {
				delete_NoticeDialog = new NoticeDialog(this, "선택 목록 삭제", "선택한 목록을 정말로 삭제할까요?", false, true,"DELETE");
				delete_NoticeDialog.show();
			}else {
				delete_CustomDialog = new CustomDialog(this, "선택 목록 삭제", "선택된 항목이 없습니다. \n\n항목을 선택해주세요.", false, false);
				delete_CustomDialog.show();
			}
			
			readStorageListNum.setText("" + Integer.toString(mReadModemStorageAdapter.getCount()));
			mReadModemStorageAdapter.notifyDataSetChanged(); 
			break;
			
		case R.id.btn_NetworkSubmit:
			NetworkUtil networkUtil = new NetworkUtil();
			con = getActivity().getApplicationContext();
			int networkStates = networkUtil.getConnectivityStatus(con);
		/*	Intent intent = con.registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
			int plugged = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
			int state = intent.getIntExtra(
					String.valueOf(BatteryManager.BATTERY_PLUGGED_USB), -1);
			Log.i("plugged : ", String.valueOf(plugged));
			Log.i("state : ", String.valueOf(state));
			if (plugged != 2) {
				Log.i("USB연결 실패", "USB를 연결해 주세요.");
				networkDialog = new CustomDialog(this, "USB연결 실패", "USB를 연결해 주세요", false, false);
				networkDialog.show();
			}*/
			if (networkStates == 1 || networkStates == 2) {
				// submit code
				getActivity().runOnUiThread(new Runnable(){
					@Override
					public void run() {
						// TODO Auto-generated method stub
						handler.post(postServerFromElecmeter);
					}
				});
				Log.i("Network ", "Connected");
				break;
				
			}else
			Log.i("네트워크에 연결할 수 없습니다.", "네트워크를 확인해 주세요.");
			networkDialog = new CustomDialog(this, "네트워크에 연결할 수 없습니다.", "네트워크를 확인해 주세요.", false, false);
			networkDialog.show();
			// network not connected
			break;
		default:
			break;
		}
	}
	
	
	Runnable postServerFromElecmeter = new Runnable() {
		@Override
		public void run() {
			for(int i=0;i<mReadModemStorageAdapter.getCount();i++){
				ModemStorageVO data = (ModemStorageVO)mReadModemStorageAdapter.getItem(i);
				if(data.isChecked()){
					SavedMeterDataToServer smdts = new SavedMeterDataToServer(getActivity(), IP, PORT, RETRY_SEC, RETRY_NUM, TIMEOUT_SEC, data.getMeterSerialNo(), data.getDate(), data.getValue());
					String ret = null;
					try{
//						ret = smdts.execute("").get(5000,TimeUnit.MILLISECONDS);
						ret = smdts.execute("").get(Long.valueOf(TIMEOUT_SEC) * 1000,TimeUnit.MILLISECONDS);
						// UpdateAdapter
						ModemListUpdate();
						Log.i("networkSubmit","Success");
						handler.removeCallbacks(postServerFromElecmeter);
					}catch(Exception e){
						Log.i("networkSubmit","Fail ");
						handler.removeCallbacks(postServerFromElecmeter);
					}
					
				}
			}
		}
	};

	private void ModemListUpdate()
	   {
	      
	      new Thread(new Runnable() {
	          @Override
	          public void run() {    
	              getActivity().runOnUiThread(new Runnable(){
	                  @Override
	                   public void run() {
	                     if(mReadModemStorageAdapter != null) { 
	                        mReadModemStorageAdapter.updateReadModelList(selectStorageModemList());
	                    }
	                   }
	              });
	          }
	      }).start();
	   }

}
