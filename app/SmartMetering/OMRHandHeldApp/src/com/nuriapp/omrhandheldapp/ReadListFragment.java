package com.nuriapp.omrhandheldapp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.nuriapp.adapter.ElecMeterAdapter;
import com.nuriapp.adapter.ModemAdapter;
import com.nuriapp.crc.CalculatReceiveData;
import com.nuriapp.database.DBConfig;
import com.nuriapp.database.DBHelper;
import com.nuriapp.popup.SettingSubmitPopup;
import com.nuriapp.serial.SerialCommandConfig;
import com.nuriapp.serial.SerialReceiveConfig;
import com.nuriapp.server.GetDataFromServer;
import com.nuriapp.utils.CustomDialog;
import com.nuriapp.utils.NoticeDialog;
import com.nuriapp.vo.ModemVO;
import com.physicaloid.lib.Physicaloid;
import com.physicaloid.lib.usb.driver.uart.UartConfig;

public class ReadListFragment extends Fragment implements OnClickListener {

	Button readModemBtn, eleMeterBtn, reCollectModemBtn,
	readmodem_modemScanBtn, readmodem_readDataCollectBtn,readModem_ReGetDataFromServer,
	eleMeter_SearchBtn,
	recollect_ListDeleteBtn,
	recollect_readDataCollectBtn;
	RadioGroup eleMeterRadioGroup;
	ListView readModemLV, elecMeterLV, recollectLV;
	View readModemPg, elecMeterPg, recollecPg;
	TextView readModem_Num, elecMeter_Num, reCollect_Num, modemId, ReadModem_AllCollectTV, Server_Title;
	EditText elecMeterInputData_Edit;
	CheckBox readModem_AllCollect, recollect_AllCollect;

	private TextView tvText;

	public static Context context;
	public static ModemAdapter mModemAdapter;
	public static ModemAdapter mRecollectModemAdapter;
	ElecMeterAdapter mElecMeterAdapter;

	ArrayList<ModemVO> mModemList;
	ArrayList<ModemVO> mElecMeterList;
	ArrayList<ModemVO> mRecollectModemist;

	DBHelper dbHelper;

	//Current Date get 
	Calendar calender;
	Date date;
	SimpleDateFormat sdfNow;

	NoticeDialog noticeDialog;
	CustomDialog customDialog;

	public static final int LIST_STATE_DEF = 0;
	public static final int LIST_STATE_SCAN = 1;
	public static final int LIST_STATE_COLLECT = 2;
	public static final int LIST_STATE_RE_SCAN = 3;
	public static int cur_ListState = LIST_STATE_DEF;
	public static final String DAY_TODAY= "TODAY";

	//모뎀 스캔 버튼 클릭시 통신 가능 불가능 상태 
	//public static String MeterConnect = "통신불가능";

	/////////////////////////////////////////////////////////////////Server Create Start//////////////////////////////////////////////////////////////
	//환경설정 -서버전송
	private String IP=null;
	private String PORT=null;
	private String RETRY_NUM;
	private String RETRY_SEC;
	private String TIMEOUT_SEC;
	private String LOCATION_ID;
	private String SUPLIER_ID;
	
	//////////////////////////////////////////////////////////////////Serial Create Start////////////////////////////////////////////////////////////////
	
	boolean verifySendId0 = false, verifySendId1 = false ,verifySendId2 = false;
	//private int onCreateCnt = 0;
	int currentBtnClick = 0;
	private int currentSendDataID;

	//private static final boolean USE_WRITE_BUTTON_FOR_DEBUG = false;

	public final byte CTRBYTE = 0x1b;

	String TAG = "AndroidSerialTerminal";
	Physicaloid mSerial;

	private boolean mStop = false;
	private boolean mRunningMainLoop = false;

	private static final String ACTION_USB_PERMISSION = "com.example.serialtest.USB_PERMISSION";
	private static final String BUNDLEKEY_LOADTEXTVIEW = "bundlekey.LoadTextView";

	private int mBaudrate = 9600;
	private int mDataBits = UartConfig.DATA_BITS8;
	private int mParity = UartConfig.PARITY_NONE;
	private int mStopBits = UartConfig.STOP_BITS2;
	private int mFlowControl = UartConfig.FLOW_CONTROL_OFF;

	//private int mDisplayType = DISP_HEX;

	// Defines of Display Settings
	private static final int DISP_CHAR = 0;
	private static final int DISP_DEC = 1;
	private static final int DISP_HEX = 2;

	// Linefeed Code Settings
	private static final int LINEFEED_CODE_CR   = 0;
	private static final int LINEFEED_CODE_CRLF = 1;
	private static final int LINEFEED_CODE_LF   = 2;

	//private static final int TEXT_MAX_SIZE = 8192;

	Handler mHandler = new Handler();

	private StringBuilder mText = new StringBuilder();

	static String value;

	private int mReadLinefeedCode = LINEFEED_CODE_LF;

	// Linefeed
	private final static String BR = System.getProperty("line.separator");
	//KmpCrcCheck kcc;
	
	// 1:N MODEM ID LIST
	private ArrayList<String> modemIdList;
	private int currentModemIdCnt;
	private int totalModemIdCnt;
	private short destination;
	
	// TimeOut
	private boolean TimeOut = false;
	private long startTime = 0;
	private long endTime = 0;
	private final int TIMEOUT_MILLISECOND = 5000;
	ReadListFragment rlf;
	//PopupCommFinish popupFinish = new PopupCommFinish(this, "통신완료");

	//////////////////////////////////////////////////////////////////Serial Create End////////////////////////////////////////////////////////////////

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		dbHelper = DBHelper.getInstance(this.getActivity());
		SQLiteDatabase db = dbHelper.getReadableDatabase();

	/*	if(mSerial == null) {
			mSerial = new Physicaloid(getActivity());
		}

		// listen for new devices
		IntentFilter filter = new IntentFilter();
		filter.addAction(UsbManager.ACTION_USB_DEVICE_ATTACHED);
		filter.addAction(UsbManager.ACTION_USB_DEVICE_DETACHED);
		getActivity().registerReceiver(mUsbReceiver, filter);
		openUsbSerial();

		ModemListsUpdate();*/

	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		// TODO Auto-generated method stub


		Typeface typeFaceBody = Typeface.createFromAsset(getActivity().getAssets(), "fonts/sangsang_font/SangSangBodyL.ttf");
		View rootView = inflater.inflate(R.layout.main_tab_page_readlist_fragmentpage, container, false);
		//View customView = inflater.inflate(R.layout.custom_actionbar, null);

		Server_Title = (TextView)rootView.findViewById(R.id.server_title);

		// Sub Tab
		readModemBtn = (Button) rootView.findViewById(R.id.btn_ReadModem);
		readModemBtn.setTypeface(typeFaceBody);
		readModemBtn.setOnClickListener(this);
		eleMeterBtn = (Button) rootView.findViewById(R.id.btn_EleMeter);
		eleMeterBtn.setTypeface(typeFaceBody);
		eleMeterBtn.setOnClickListener(this);
		reCollectModemBtn = (Button) rootView.findViewById(R.id.btn_ReCollectModem);
		reCollectModemBtn.setTypeface(typeFaceBody);
		reCollectModemBtn.setOnClickListener(this);

		// Read MODEM Btn
		readmodem_modemScanBtn = (Button) rootView.findViewById(R.id.btn_ReadModem_ModemScan);
		readmodem_modemScanBtn.setTypeface(typeFaceBody);
		readmodem_modemScanBtn.setOnClickListener(this);
		readmodem_readDataCollectBtn = (Button) rootView.findViewById(R.id.btn_ReadModem_ReadDataCollect);
		readmodem_readDataCollectBtn.setTypeface(typeFaceBody);
		readmodem_readDataCollectBtn.setOnClickListener(this);
		readModem_ReGetDataFromServer = (Button)rootView.findViewById(R.id.btn_ReadModem_ReGetDataFromServer);
		readModem_ReGetDataFromServer.setTypeface(typeFaceBody);
		readModem_ReGetDataFromServer.setOnClickListener(this);
		ReadModem_AllCollectTV = (TextView) rootView.findViewById(R.id.tv_ReadModem_AllCollect);
		ReadModem_AllCollectTV.setOnClickListener(this);
		readModem_AllCollect = (CheckBox)rootView.findViewById(R.id.ck_ReadModem_AllCollect);
		readModem_AllCollect.setOnClickListener(this);
		readModem_Num = (TextView)rootView.findViewById(R.id.tv_Readmodem_Num);
		
		// ElectMeter 
		eleMeterRadioGroup = (RadioGroup)rootView.findViewById(R.id.rg_elecMeter);
		eleMeterRadioGroup.setOnClickListener(this);
		elecMeterInputData_Edit = (EditText)rootView.findViewById(R.id.et_ElectMeter_Data);
		elecMeterInputData_Edit.setOnClickListener(this);
		eleMeter_SearchBtn = (Button)rootView.findViewById(R.id.btn_ElectMeter_Search);
		eleMeter_SearchBtn.setOnClickListener(this);
		//readmoemdPageDown.setOnClickListener(this);
		elecMeter_Num = (TextView)rootView.findViewById(R.id.tv_electMeter_num);

		
		
		// Recollect Btn
		recollect_ListDeleteBtn = (Button) rootView.findViewById(R.id.btn_Recollect_ListDelete);
		recollect_ListDeleteBtn.setOnClickListener(this);
		recollect_readDataCollectBtn = (Button) rootView.findViewById(R.id.btn_Recollect_ReadDataCollec);
		recollect_readDataCollectBtn.setOnClickListener(this);
		recollect_AllCollect = (CheckBox)rootView.findViewById(R.id.ck_Recollect_AllCollect);
		recollect_AllCollect.setOnClickListener(this);
		reCollect_Num = (TextView)rootView.findViewById(R.id.tv_reCollec_Num);
		
		
		// Sub Tab LinearLayout
		readModemPg = (LinearLayout) rootView.findViewById(R.id.ll_ReadModem);
		elecMeterPg = (LinearLayout) rootView.findViewById(R.id.ll_ElecMeter);
		recollecPg = (LinearLayout) rootView.findViewById(R.id.ll_Recollect);

		
		// ListView
		readModemLV = (ListView) rootView.findViewById(R.id.lv_ReadModem_ModemList);
		elecMeterLV = (ListView) rootView.findViewById(R.id.lv_ElecMeter_ModemList);
		recollectLV = (ListView) rootView.findViewById(R.id.lv_Recollect_Modemlist);
		
		//얘 어디서 쓰는거지........................
		modemId = (TextView)rootView.findViewById(R.id.tv_modemId);

		
		// Initial Loading
		readModemBtn.setSelected(true);
		elecMeterPg.setVisibility(View.GONE);
		recollecPg.setVisibility(View.GONE);

		mModemList = new ArrayList<ModemVO>();
		mElecMeterList = new ArrayList<ModemVO>();
		mRecollectModemist = new ArrayList<ModemVO>();

		// DB Setting
		dbHelper = DBHelper.getInstance(this.getActivity());
		SQLiteDatabase db = dbHelper.getReadableDatabase();

		// Adapter Create
		mModemAdapter = new ModemAdapter(this.getActivity(),selectModemList());
		mElecMeterAdapter = new ElecMeterAdapter(this.getActivity(),selectMeterList());
		mRecollectModemAdapter = new ModemAdapter(this.getActivity(),selectRecollectList());

		readModemLV.setAdapter(mModemAdapter);
		elecMeterLV.setAdapter(mElecMeterAdapter);
		recollectLV.setAdapter(mRecollectModemAdapter);

		readModem_Num.setText("" + Integer.toString(mModemAdapter.getCount()));		
		///////////////////////////////////////////////////////Serial Oncreate Start/////////////////////////////////////////////////////////////

		// get service
		Log.i("oncreatView serialtest", "oncreatView serialtest");
		if(mSerial == null) {
			mSerial = new Physicaloid(getActivity());
		}

		// listen for new devices
		IntentFilter filter = new IntentFilter();
		filter.addAction(UsbManager.ACTION_USB_DEVICE_ATTACHED);
		filter.addAction(UsbManager.ACTION_USB_DEVICE_DETACHED);
		getActivity().registerReceiver(mUsbReceiver, filter);
		openUsbSerial();

//		kcc = new KmpCrcCheck();

		final SQLiteDatabase initList = dbHelper.getWritableDatabase();
		for (int i = 0; i < mModemAdapter.getCount(); i++) {
			ModemVO data = (ModemVO) mModemAdapter.getItem(i);
			if(data.isChecked())
				initList.execSQL("update modemlist set modem_state = '통신 불가능', isChecked = 'false';");
		}
		try{
			initList.execSQL(DBConfig.DELETE_RECOLLECT_MODEMLIST);
		}catch(Exception e){
			
		}
		
		// 1:N 리스트
		modemIdList = new ArrayList<String>();
		
		rlf = this;
		///////////////////////////////////////////////////////Serial Oncreate End//////////////////////////////////////////////////////////////
		return rootView;

	}

	void loadServerConfig()
	{
		dbHelper = DBHelper.getInstance(context);
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery("select *from server_config", null);
		cursor.moveToFirst();
		for(int i=0;i<cursor.getColumnCount();i++){
			IP = cursor.getString(0)+"."+cursor.getString(1)+"."+cursor.getString(2)+"."+cursor.getString(3);
			PORT =":"+ cursor.getString(4);
			RETRY_SEC = cursor.getString(5);
			RETRY_NUM = cursor.getString(6);
			TIMEOUT_SEC = cursor.getString(7);
		}
		cursor.close();
	}


	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		switch (resultCode) {
		case 1:
			loadServerConfig();
			getActivity().runOnUiThread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					handler.post(getInfoFromServer);
				}
			});
			break;
		default:
			Toast.makeText(getActivity(), "서버 연결 설정을 확인해주세요", Toast.LENGTH_SHORT).show();
			break;
		}
	}


	private ArrayList<ModemVO> selectModemList() {
		selectModemList_query(mModemList, DBConfig.SELECT_MODEMLIST);
		return mModemList;
	}

	private ArrayList<ModemVO> selectMeterList() {
		selectModemList_query(mElecMeterList, DBConfig.SELECT_MODEMLIST);
		return mElecMeterList;
	}

	private ArrayList<ModemVO> selectRecollectList() {
		selectModemList_query(mRecollectModemist, DBConfig.SELECT_RECOLLECT_MODEMLIST);
		return mRecollectModemist;
	}
	
	private ArrayList<String> getScanModemIdList(){
		ArrayList<String> list = new ArrayList<String>();
		SQLiteDatabase db = null;
		
		list.clear();
		if(dbHelper != null) {
			db = dbHelper.getReadableDatabase();
		}else {
			dbHelper = DBHelper.getInstance(this.getActivity());
			db = dbHelper.getReadableDatabase();
		}
		
		Cursor cursor = db.rawQuery(DBConfig.SELECT_SCAN_MODEM_ID_LIST, null);
		cursor.moveToFirst();
		// List input DBdata
		for (int i = 0; i < cursor.getCount(); i++) {
			list.add(cursor.getString(0));
			cursor.moveToNext();
		}
		cursor.close();
		
		return list;
	}

	private ArrayList<String> getCollectModemIdList(){
		ArrayList<String> list = new ArrayList<String>();
		SQLiteDatabase db = null;
		
		list.clear();
		if(dbHelper != null) {
			db = dbHelper.getReadableDatabase();
		}else {
			dbHelper = DBHelper.getInstance(this.getActivity());
			db = dbHelper.getReadableDatabase();
		}
		
		Cursor cursor = db.rawQuery(DBConfig.SELECT_COLLECT_MODEM_ID_LIST, null);
		cursor.moveToFirst();
		// List input DBdata
		for (int i = 0; i < cursor.getCount(); i++) {
			list.add(cursor.getString(0));
			cursor.moveToNext();
		}
		cursor.close();
		
		return list;
	}
	
	private ArrayList<ModemVO> selectModemList_query(ArrayList<ModemVO> list, String Query) {
		// TODO Auto-generated method stub
		list.clear();
		SQLiteDatabase db = null;

		if(dbHelper != null) {
			db = dbHelper.getReadableDatabase();
		}else {
			dbHelper = DBHelper.getInstance(this.getActivity());
			db = dbHelper.getReadableDatabase();
		}


		Cursor cursor = db.rawQuery(Query, null);
		cursor.moveToFirst();
		// List input DBdata
		for (int i = 0; i < cursor.getCount(); i++) {
			Log.i("cursor.getString(6) ",cursor.getString(6) +"");
			boolean isCheck = (cursor.getString(6).equals("false")) ? false : true;
			list.add(new ModemVO(cursor.getString(0), cursor.getString(1), cursor.getString(2),
					cursor.getString(3), cursor.getString(4), cursor.getString(5), isCheck));

			Log.i("isChecked1!!", "i=" +i+ " "+isCheck +"");
			cursor.moveToNext();
		}
		cursor.close();
		
		return list;
	}
	
	private void excuteInsertRecollect_query(short modem_id) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = null;

		if(dbHelper != null) {
			db = dbHelper.getWritableDatabase();
		}else {
			dbHelper = DBHelper.getInstance(this.getActivity());
			db = dbHelper.getWritableDatabase();
		}

		ArrayList<ModemVO> list = new ArrayList<ModemVO>();
		String query = DBConfig.SELECT_RECOLLECT_MODEM_ID_LIST + String.valueOf(modem_id) + "';";
		Log.d("SELECT RECOLLECT", query);
		list = selectModemList_query(list, query);
		for(int i=0; i<list.size(); i++){
			try{
				query = DBConfig.INSERT_RECOLLECTMODEM(list.get(i).getModemId(), list.get(i).getMeterSerialNo(), list.get(i).getAddress(), "통신 가능", list.get(i).getDate(), list.get(i).getValue(), false);
				db.execSQL(query);
				query = "update modemlist set modem_state = '통신 가능' where modem_id = '" + list.get(i).getState() + "';";
				db.execSQL(query);
			}catch(Exception e){
				query = DBConfig.UPDATE_RECOLLECTMODEM(list.get(i).getModemId(), list.get(i).getMeterSerialNo(), list.get(i).getAddress(), "통신 가능", list.get(i).getDate(), list.get(i).getValue(), false);
				db.execSQL(query);
				query = "update modemlist set modem_state = '통신 가능' where modem_id = '" + list.get(i).getState() + "';";
				db.execSQL(query);
			}
		}
	}
	
	private void excuteDeleteRecollect_query(short modem_id){
		// TODO Auto-generated method stub
		SQLiteDatabase db = null;

		if (dbHelper != null) {
			db = dbHelper.getWritableDatabase();
		} else {
			dbHelper = DBHelper.getInstance(this.getActivity());
			db = dbHelper.getWritableDatabase();
		}

		ArrayList<ModemVO> list = new ArrayList<ModemVO>();
		String query = DBConfig.DELETE_RECOLLECT_MODEM_ID_LIST + String.valueOf(modem_id) + "';";
		Log.d("DELETE RECOLLECT", query);

		try {
			db.execSQL(query);
		} catch (Exception e) {

		}
	}
	
	private void executeReadModemStateInit(){
		SQLiteDatabase db = null;

		if (dbHelper != null) {
			db = dbHelper.getWritableDatabase();
		} else {
			dbHelper = DBHelper.getInstance(this.getActivity());
			db = dbHelper.getWritableDatabase();
		}

		ArrayList<ModemVO> list = new ArrayList<ModemVO>();
		String query = "update modemlist set modem_state = '통신 불가능';";
		Log.d("executeReadModemStateInit", query);

		try {
			db.execSQL(query);
		} catch (Exception e) {

		}
		ModemListsUpdate();
	}
	
	private void executeUpdateModemState(String modem_id, String modem_state){
		SQLiteDatabase db = null;

		if (dbHelper != null) {
			db = dbHelper.getWritableDatabase();
		} else {
			dbHelper = DBHelper.getInstance(this.getActivity());
			db = dbHelper.getWritableDatabase();
		}

		ArrayList<ModemVO> list = new ArrayList<ModemVO>();
		String query = "update modemlist set modem_state = '" + modem_state+ "', isChecked = 'false' where modem_id = '"+ modem_id +"';";
		Log.d("executeUpdateModemState", query);

		try {
			db.execSQL(query);
		} catch (Exception e) {

		}
		ModemListsUpdate();
	}

	public void  checkListDelete()
	{
		final SQLiteDatabase reCollect_Delete_db = dbHelper.getWritableDatabase();
		for (int i = 0; i < mRecollectModemAdapter.getCount(); i++) {
			ModemVO data = (ModemVO) mRecollectModemAdapter.getItem(i);
			if(data.isChecked())
				try{
					reCollect_Delete_db.execSQL("delete from recollect_modemlist where modem_id = '" + data.getModemId() + "';");
				}catch (Exception e) {
					// TODO: handle exception
				}
				
		}
		ModemListsUpdate();
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_ReadModem: // modemScan
//			ReadListFragment.cur_ListState = LIST_STATE_RE_SCAN;
			//executeReadModemStateInit();
			readModemBtn.setSelected(true);
			eleMeterBtn.setSelected(false);
			reCollectModemBtn.setSelected(false);

			readModemPg.setVisibility(View.VISIBLE);
			elecMeterPg.setVisibility(View.GONE);
			recollecPg.setVisibility(View.GONE);

			ModemListsUpdate();
			recollect_AllCollect.setChecked(false);

			break;

		case R.id.btn_ReadModem_ModemScan:
			executeReadModemStateInit();
			ModemListsUpdate();
			
			ReadListFragment.cur_ListState = LIST_STATE_SCAN;				
			currentBtnClick = 1;//스레드 내에서 버튼에 따라 통신이 달라짐

			// 1:N List 작성
			modemIdList = getScanModemIdList();
//			modemIdList.clear();
//			modemIdList.add("2");
//			modemIdList.add("3");
			totalModemIdCnt = modemIdList.size();
			Log.d("totalModemIdCnt", "totalModemIdCnt = " + totalModemIdCnt);
//			writeDataToSerial(1, (short)3); // TEST
			destination = Short.parseShort(modemIdList.get(currentModemIdCnt));
			writeDataToSerial(SerialCommandConfig.startCommand, destination);
			//new ModemScanTaskProgress(this.getActivity()).execute(mModemAdapter.getCount());
			
			ModemListsUpdate();
			readModem_AllCollect.setChecked(false);
			mModemAdapter.updateReadModelList(selectModemList());
			break;

		case R.id.btn_ReadModem_ReadDataCollect:
			ReadListFragment.cur_ListState = LIST_STATE_COLLECT;			
			//검침데이터 수집 버튼 클릭 
			currentBtnClick = 2; //스레드 내에서 버튼에 따라 통신이 달라짐
			
			int CheckCount = 0;
			// 검침 보관함 DB에 update
			SQLiteDatabase db = dbHelper.getWritableDatabase();
			int reaModem_Check_Num = 0;
			
			modemIdList.clear();
			for (int i = 0; i < mModemAdapter.getCount(); i++) {
				ModemVO data = (ModemVO) mModemAdapter.getItem(i);
				if (data.isChecked()) {
					if (data.getState().equals("통신 불가능")) {
						reaModem_Check_Num = -9999;
						break;
					} else if(data.getState().equals("수집 성공")){
						// 1:N 리스트 작성
						modemIdList.add(data.getModemId());
						reaModem_Check_Num++;
					}					
					else {
						// 체크된것만 수집하기
						modemIdList.add(data.getModemId());
						reaModem_Check_Num++;
					}
				}
			}			
			
			// 수집 완료 후 다시 수집하면 죽는 경우를 위한 modemIdList 재생성 후 실행
			if(reaModem_Check_Num>0 && modemIdList.size() > 0){				
				// modemIdList.clear();
				// modemIdList.add("2");
				// modemIdList.add("3");
				totalModemIdCnt = modemIdList.size();
				// writeDataToSerial(1, (short)2); // Test
				
				destination = Short.parseShort(modemIdList.get(currentModemIdCnt));
				writeDataToSerial(SerialCommandConfig.startCommand, (short) destination);
			}else if(reaModem_Check_Num  == 0){
				//Toast.makeText(getActivity().getApplicationContext(), "선택된 항목이 없습니다. \n\n항목을 선택해주세요.", Toast.LENGTH_SHORT).show();
				customDialog = new CustomDialog(this, "검침데이터 수집", "선택된 항목이 없습니다. \n\n항목을 선택해주세요.", false, false);
				customDialog.show();	
			}else if(reaModem_Check_Num == -9999){
				//Toast.makeText(getActivity().getApplicationContext(), "선택된 항목 중 통신 불가능이 있습니다. \n\n항목을 확인해주세요.", Toast.LENGTH_SHORT).show();
				customDialog = new CustomDialog(this, "검침데이터 수집", "선택된 항목 중 통신 불가능이 있습니다. \n\n항목을 확인해주세요.", false, false);
				customDialog.show();	
			}else{
				
			}
		
			/*if(reaModem_Check_Num>0){
				customDialog = new CustomDialog(this, "검침데이터 수집", "전체 "+mModemAdapter.getCount()+"개중"+reaModem_Check_Num+"개 성공", false, false);
				customDialog.show();	
			}else if(reaModem_Check_Num  == 0){
				customDialog = new CustomDialog(this, "검침데이터 수집", "선택된 항목이 없습니다. \n\n항목을 선택해주세요.", false, false);
				customDialog.show();	
			}else if(reaModem_Check_Num == -9999){
				customDialog = new CustomDialog(this, "검침데이터 수집", "선택된 항목 중 통신 불가능이 있습니다. \n\n항목을 확인해주세요.", false, false);
				customDialog.show();	
			}*/
			//mModemAdapter.updateReadModelList(selectList(DBConfig.tablename_modem));
			//new ModemDataCollectTaskProgress(this.getActivity()).execute(CheckCount); 
			readModem_Num.setText("" + Integer.toString(mModemAdapter.getCount()));	
			break;

			
		case R.id.btn_ReadModem_ReGetDataFromServer:
			//서버설정값 가져오기
			loadServerConfig();
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		getActivity().runOnUiThread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				handler.post(getInfoFromServer);
			}
		});			
			
			break;
			
			
			
		case R.id.ck_ReadModem_AllCollect:
			mModemAdapter.setAllChecked(readModem_AllCollect.isChecked());
			mModemAdapter.notifyDataSetChanged(); 
			break;

		case R.id.btn_EleMeter:

			readModemBtn.setSelected(false);
			eleMeterBtn.setSelected(true);
			reCollectModemBtn.setSelected(false);

			readModemPg.setVisibility(View.GONE);
			elecMeterPg.setVisibility(View.VISIBLE);
			recollecPg.setVisibility(View.GONE);

			ReadListFragment.cur_ListState = LIST_STATE_COLLECT;
			ModemListsUpdate(); 
			elecMeter_Num.setText("" + Integer.toString(mElecMeterAdapter.getCount()));
			break;
			
		case R.id.btn_ElectMeter_Search:
			int checkRadioButton = eleMeterRadioGroup.getCheckedRadioButtonId();
			Log.d("checkRadioButton", checkRadioButton+"");
			String keyword = elecMeterInputData_Edit.getText().toString();
			Log.d("EDIT String", keyword);
			
			String query = "select * from modemlist;";
			if(checkRadioButton == R.id.rb_Name){
				query = DBConfig.ELECMETER_SEARCH + "modem_serialnum LIKE '%%" + keyword + "%%';";
			}else if(checkRadioButton == R.id.rb_Address){
				query = DBConfig.ELECMETER_SEARCH + "modem_address LIKE '%%" + keyword + "%%';";
			}else{
				;
			}
			
			Log.d("mElecMeterList Query", query);
			mElecMeterList = selectModemList_query(mElecMeterList, query);
			Log.d("mElecMeterList", "mElecMeterList.size = " + mElecMeterList.size());
			
			if(mElecMeterAdapter != null) {
    			mElecMeterAdapter.updateElecMeterlList(mElecMeterList);
    			elecMeter_Num.setText("" + Integer.toString(mElecMeterAdapter.getCount()));
			}
			
			break;
						
		case R.id.btn_ReCollectModem:
			ReadListFragment.cur_ListState = LIST_STATE_COLLECT;
			ModemListsUpdate();
			reCollect_Num.setText("" + Integer.toString(mRecollectModemAdapter.getCount()));

			readModemBtn.setSelected(false);
			eleMeterBtn.setSelected(false);
			reCollectModemBtn.setSelected(true);

			readModemPg.setVisibility(View.GONE);
			elecMeterPg.setVisibility(View.GONE);
			recollecPg.setVisibility(View.VISIBLE);

			recollect_AllCollect.setChecked(false);
			ModemListsUpdate(); 
			mRecollectModemAdapter.updateReadModelList(selectRecollectList());
			break;

		case R.id.ck_Recollect_AllCollect:
			mRecollectModemAdapter.setAllChecked(recollect_AllCollect.isChecked());
			mRecollectModemAdapter.notifyDataSetChanged(); 
			break;

		case R.id.btn_Recollect_ListDelete:
			boolean is_Check = false;
			String modem_id;
			for (int i = 0; i < mRecollectModemAdapter.getCount(); i++) {
				ModemVO data = (ModemVO) mRecollectModemAdapter.getItem(i);
				if (data.isChecked()) {
					is_Check = true;
					modem_id = data.getModemId();
					break;
				}
			}
			if(is_Check == true) {
				noticeDialog = new NoticeDialog(this, "선택 목록 삭제", "선택한 목록을 정말로 삭제할까요?", false, true);
			}else {
				noticeDialog = new NoticeDialog(this, "선택 목록 삭제", "선택된 항목이 없습니다. \n\n항목을 선택해주세요.", false, false);
			}
			noticeDialog.show();
			break;

		case R.id.btn_Recollect_ReadDataCollec:
			currentBtnClick = 2;
			ReadListFragment.cur_ListState = LIST_STATE_COLLECT;

			// checked list data is update!!!!
			SQLiteDatabase reCollect_Collec_db = dbHelper.getWritableDatabase();
			int Recollect_Check_Num = 0;
			/*
			 * customDialog = new CustomDialog(this, "검침데이터 재수집",
			 * "전체 "+mModemAdapter.getCount()+"개중"+Recollect_Check_Num+"개 성공",
			 * false, false); customDialog.show();
			 */
			modemIdList.clear();
			for (int i = 0; i < mRecollectModemAdapter.getCount(); i++) {
				ModemVO data = (ModemVO) mRecollectModemAdapter.getItem(i);

				if (data.isChecked()) {
					modemIdList.add(data.getModemId());
					Recollect_Check_Num++;
				}
			}
			
			if(Recollect_Check_Num>0){				
				// modemIdList.clear();81
				// modemIdList.add("2");
				// modemIdList.add("3");
				totalModemIdCnt = modemIdList.size();
				// writeDataToSerial(1, (short)2); // Test
				currentModemIdCnt = 0;
					
				destination = Short.parseShort(modemIdList.get(currentModemIdCnt));
				writeDataToSerial(SerialCommandConfig.startCommand, (short) destination);				
			}else if(Recollect_Check_Num  == 0){
				customDialog = new CustomDialog(this, "검침데이터 재수집", "선택된 항목이 없습니다. \n\n항목을 선택해주세요.", false, false);
				customDialog.show();	
			}
			mRecollectModemAdapter.updateReadModelList(selectRecollectList());
			break;
			

		default:
			break;
		}

		context = this.getActivity().getApplicationContext();
	}



	/////////////////////////////////////////////////////////Serial Test Function///////////////////////////////////////////////////////////////////////
	BroadcastReceiver mUsbReceiver = new BroadcastReceiver() {
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();

			if (UsbManager.ACTION_USB_DEVICE_ATTACHED.equals(action)) {
				if (!mSerial.isOpened()) {
					openUsbSerial();
				}
				/*if (!mRunningMainLoop) {
					mainloop();
				}*/
			} else if (UsbManager.ACTION_USB_DEVICE_DETACHED.equals(action)) {
				mStop = true;
				//detachedUi();
				// mSerial.usbDetached(intent);
				mSerial.close();
			}else if (ACTION_USB_PERMISSION.equals(action)) {
				synchronized (this) {
					if (!mSerial.isOpened()) {
						openUsbSerial();
					}
				}
				if (!mRunningMainLoop) {
					mainloop();
				}
			}
		}
	};

	private void openUsbSerial() {
		// TODO Auto-generated method stub
		if (mSerial == null) {
			Toast.makeText(getActivity().getApplicationContext(), "cannot open. mSerial is null", Toast.LENGTH_SHORT).show();
			return;
		}
		if (mSerial.isOpened() == false) {
			if (mSerial.open() == false) {
				Toast.makeText(getActivity().getApplicationContext(), "open fail.", Toast.LENGTH_SHORT).show();
				return;
			} else {
				// loadDefaultSettingValues();

				boolean dtrOn = false;
				boolean rtsOn = false;
				if (mFlowControl == UartConfig.FLOW_CONTROL_ON) {
					dtrOn = true;
					rtsOn = true;
				}
				mSerial.setConfig(new UartConfig(mBaudrate, mDataBits,mStopBits, mParity, dtrOn, rtsOn));


				//edText.setTextSize(mTextFontSize);

				Toast.makeText(getActivity().getApplicationContext(), "open success", Toast.LENGTH_SHORT).show();
			}
		}

		if (!mRunningMainLoop) {
			mainloop();
		}

	}
	private void mainloop() {
		mStop = false;
		mRunningMainLoop = true;
		Toast.makeText(getActivity().getApplicationContext(), "connected", Toast.LENGTH_SHORT).show();

		new Thread(mLoop).start();
	}
	
	private void writeTransaction(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SerialReceiveConfig.InitReceiveBuffer();
		
		if (modemIdList.size() > 0) {
			currentModemIdCnt++;
			if (totalModemIdCnt > currentModemIdCnt) {
				Log.i("currentModemIdCntl = ", " currentModemIdCnt = " + currentModemIdCnt);
				destination = Short.valueOf(modemIdList.get(currentModemIdCnt));
				writeDataToSerial(SerialCommandConfig.startCommand, destination);
			} else {
				Log.i("1:N", "N List End, total = " + totalModemIdCnt + ", current = " + currentModemIdCnt);
				currentModemIdCnt = 0;
				
				new Thread(new Runnable() {
				    @Override
				    public void run() {    
				        getActivity().runOnUiThread(new Runnable(){
				        	@Override
							public void run() {
								// TODO Auto-generated method stub
				        		if(currentBtnClick == 1){
				        			customDialog = new CustomDialog(rlf, "통신 완료", "모뎀 스캔이 완료되었습니다. \n", false, false);
				        			customDialog.show();
				        		}else if(currentBtnClick == 2){
				        			customDialog = new CustomDialog(rlf, "통신 완료", "검침데이터 수집이 완료되었습니다. \n", false, false);
				        			customDialog.show();
				        		}else{
				        			
				        		}
							}		
				        });
				    }
				}).start();
				
			}
		} else {

		}
	}

	private Runnable mLoop = new Runnable() {
		@Override
		public void run() {
			int len;
			int currentReadIndex = 0;
			byte[] rbuf = new byte[4096];
			//boolean receiveStart = false;

			//boolean verifySendId0 = false, verifySendId1 = false ,verifySendId2 = false;

			SerialReceiveConfig.InitReceiveBuffer();

			while(true) {
				// ////////////////////////////////////////////////////////// Read and Display to Terminal// /////////////////////////////////////	
				len = mSerial.read(rbuf);
				rbuf[len] = 0;
				//TimeoutTask timeoutTask = null;
				//Timer timer = null;
				//////////////////////////////////////////////////////////// TimeOut Check ///////////////////////////////////////////////////////
				endTime = System.currentTimeMillis();
				if((TimeOut) && (endTime - startTime >= TIMEOUT_MILLISECOND) ){
					TimeOut = false;
					SerialReceiveConfig.InitReceiveBuffer();
					Log.d("TimeOut", "TimeOut!!!");
					// 재수집 대상은 통신 성공인데, 못받았을때만
					if(currentBtnClick==2){
						excuteInsertRecollect_query(destination);						
					}
					
					if(currentBtnClick == 1){
						excuteDeleteRecollect_query(destination);
						executeUpdateModemState(String.valueOf(destination), "통신 불가능");
					}
					
					writeTransaction();					
				}

				if (len > 0) {
					//TimeOut 해제
					TimeOut = false;
					startTime = System.currentTimeMillis();
					
					Log.d("receiveTest", rbuf + "");
					if(currentSendDataID == 3) {
						continue;
					}else{
						/*	//첫데이터를 받는 순간에만 타이머를 동작시킴
						if(receiveStart ==false){
							receiveStart = true;
							timeoutTask = new TimeoutTask();
							timer = new Timer();
							timer.schedule(timeoutTask, 10000);
						}*/
					}
					// stuffing
					boolean stuffingFlag = false;
					for(int i = 0; i < len; i++) {
						if(stuffingFlag == true)
						{
//							Log.i("Stuffing1", "Stuffing = " + SerialReceiveConfig.receiveData[currentSendDataID][currentReadIndex-1]);
							SerialReceiveConfig.receiveData[currentSendDataID][currentReadIndex-1] = (byte) ~rbuf[i];
//							Log.i("Stuffing2", "Stuffing = " + SerialReceiveConfig.receiveData[currentSendDataID][currentReadIndex-1]);
							Log.i("yes !!!!!  Stuffing",   i+"="+SerialReceiveConfig.receiveData[currentSendDataID][currentReadIndex-1] );
							stuffingFlag = false;
						}else {
							SerialReceiveConfig.receiveData[currentSendDataID][currentReadIndex++] = rbuf[i];
							if(rbuf[i] == CTRBYTE){
								stuffingFlag = true;
							}
						}
					}
					// 하나의 데이터 셋이 완료 되었을 때
					if(currentReadIndex >= SerialReceiveConfig.length_ReceiveData[currentSendDataID]-1) {
						/*if(timer != null) {
							timer.cancel();
							receiveStart = false;
						}*/
						/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
						Log.i("rbuf", "-------------reveive start -----------------------");
						for(int i = 0; i < currentReadIndex; i++)
							Log.d("rbuf","rbuf["+i+"]"+(SerialReceiveConfig.receiveData[currentSendDataID][i])+"");
						Log.i("rbuf", "--------------reveive end --------------------");

						//////////////////////////////////////////////////////////verify test //////////////////////////////////////////////////////////
						if(currentSendDataID==0){
							byte[] payload = SerialReceiveConfig.getPayload(currentSendDataID);
							byte[] verifyCrc = new byte[SerialReceiveConfig.length_Receive_Payload[currentSendDataID]-SerialReceiveConfig.LAST_WITH_CRC_INDEX];
							for(int i=1; i<=SerialReceiveConfig.length_Receive_Payload[currentSendDataID]-SerialReceiveConfig.LAST_WITH_CRC_INDEX; i++){
								verifyCrc[i-1] = payload[i];
							}
							verifySendId0 = SerialCommandConfig.kcc.KmpVerifyCrc(verifyCrc, verifyCrc.length);
							Log.d("rbuf", "verifyTest0 : " + Boolean.toString(verifySendId0));
						}
						else if(currentSendDataID==1){
							byte[] payload = SerialReceiveConfig.getPayload(currentSendDataID);
							byte[] verifyCrc = new byte[SerialReceiveConfig.length_Receive_Payload[currentSendDataID]-SerialReceiveConfig.LAST_WITH_CRC_INDEX];
							for(int i=1; i<=SerialReceiveConfig.length_Receive_Payload[currentSendDataID]-SerialReceiveConfig.LAST_WITH_CRC_INDEX; i++){
								verifyCrc[i-1] = payload[i];
							}
							verifySendId1 = SerialCommandConfig.kcc.KmpVerifyCrc(verifyCrc, verifyCrc.length);
							Log.d("rbuf", "verifyTest1 : " + Boolean.toString(verifySendId1));
						}else if(currentSendDataID==2){
							byte[] payload = SerialReceiveConfig.getPayload(currentSendDataID);
							byte[] verifyCrc = new byte[SerialReceiveConfig.length_Receive_Payload[currentSendDataID]-SerialReceiveConfig.LAST_WITH_CRC_INDEX];
							for(int i=1; i<=SerialReceiveConfig.length_Receive_Payload[currentSendDataID]-SerialReceiveConfig.LAST_WITH_CRC_INDEX; i++){
								verifyCrc[i-1] = payload[i];
							}
							verifySendId2 = SerialCommandConfig.kcc.KmpVerifyCrc(verifyCrc, verifyCrc.length);
							Log.d("rbuf", "verifyTest2 : " + Boolean.toString(verifySendId2));
						}
						/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

						currentSendDataID++;
						currentReadIndex = 0;

						if(currentSendDataID < 3) {
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							// 0번 데이터셋 수신 LogID -> 1번 데이터셋 송신 LogID로 복사
							if(currentSendDataID == 1)
							{
								int src_copy_Start = SerialCommandConfig.src_copy_Start;
								int dest_copy_start = SerialCommandConfig.dest_copy_start;

								for(int j = 0; j < 4; j++)
								{
									SerialCommandConfig.sendData[1][dest_copy_start++] = SerialReceiveConfig.receiveData[0][src_copy_Start++];
								}				
							}
							//Log.i("test_currentSendDataID",currentSendDataID+"");
//							writeDataToSerial(currentSendDataID, (short)3);
							writeDataToSerial(currentSendDataID, destination);
						} else {
							if(currentBtnClick ==1){
								if(verifySendId0==true && verifySendId1==true && verifySendId2==true){
									CalculatReceiveData.startCalculate(SerialReceiveConfig.receiveData, currentBtnClick);
									ModemListsUpdate();
								}else{
									//CalculatReceiveData.ConnectFail();
									Log.i("update_db","state = 통신은 가능");
									CalculatReceiveData.startCalculate(SerialReceiveConfig.receiveData, 3);
									ModemListsUpdate();
								}
							}
							if(currentBtnClick==2){
								if(verifySendId0==true && verifySendId1==true && verifySendId2==true){
									CalculatReceiveData.startCalculate(SerialReceiveConfig.receiveData, currentBtnClick);
									ModemListsUpdate();
								}else{
									//Recollect //
									//CalculatReceiveData.CollectFail();
									Log.i("update_db","state = 수집불가능");
									excuteInsertRecollect_query(destination);
								}
							}
//							SerialReceiveConfig.InitReceiveBuffer();
							writeTransaction();
						}
					}
				}
				if (mStop) {
					mRunningMainLoop = false;
					return;
				}
			}
		}
	};


	boolean lastDataIs0x0D = false;

	void setSerialDataToTextView(int disp, byte[] rbuf, int len, String sCr,String sLf) {
		int tmpbuf;
		for (int i = 0; i < len; ++i) {

			// "\r":CR(0x0D) "\n":LF(0x0A)
			if ((mReadLinefeedCode == LINEFEED_CODE_CR) && (rbuf[i] == 0x0D)) {
				mText.append(sCr);
				mText.append(BR);
			} else if ((mReadLinefeedCode == LINEFEED_CODE_LF)
					&& (rbuf[i] == 0x0A)) {
				mText.append(sLf);
				mText.append(BR);
			} else if ((mReadLinefeedCode == LINEFEED_CODE_CRLF)
					&& (rbuf[i] == 0x0D) && (rbuf[i + 1] == 0x0A)) {
				mText.append(sCr);
				if (disp != DISP_CHAR) {
					mText.append(" ");
				}
				mText.append(sLf);
				mText.append(BR);
				++i;
			} else if ((mReadLinefeedCode == LINEFEED_CODE_CRLF)
					&& (rbuf[i] == 0x0D)) {
				// case of rbuf[last] == 0x0D and rbuf[0] == 0x0A
				mText.append(sCr);
				lastDataIs0x0D = true;
			} else if (lastDataIs0x0D && (rbuf[0] == 0x0A)) {
				if (disp != DISP_CHAR) {
					mText.append(" ");
				}
				mText.append(sLf);
				mText.append(BR);
				lastDataIs0x0D = false;
			} else if (lastDataIs0x0D && (i != 0)) {
				// only disable flag
				lastDataIs0x0D = false;
				--i;
			} else {
				switch (disp) {
				case DISP_CHAR:
					mText.append((char) rbuf[i]);
					break;
				case DISP_DEC:
					tmpbuf = rbuf[i];
					if (tmpbuf < 0) {
						tmpbuf += 256;
					}
					mText.append(String.format("%1$03d", tmpbuf));
					mText.append(" ");
					break;
				case DISP_HEX:
					mText.append(IntToHex2((int) rbuf[i]));
					mText.append(" ");
					break;
				default:
					break;
				}
			}
		}
	}
	private String IntToHex2(int Value) {
		char HEX2[] = {
				Character.forDigit((Value >> 4) & 0x0F, 16),
				Character.forDigit(Value & 0x0F, 16)
		};
		String Hex2Str = new String(HEX2);
		return Hex2Str;
	}

	


	private void writeDataToSerial(int sendDataID, short modemId) {
//		byte[] sendBuffer = SerialCommandConfig.get_SendBuffer(SerialCommandConfig.sendData[sendDataID] );
		byte[] sendBuffer = SerialCommandConfig.getCommand(sendDataID, (short)modemId);

		Log.d("send_rbuf", "---------------sendStart----------------");
		for(int i = 0; i <sendBuffer.length; i++)
		{
			Log.d("rbuf", i+"=" +Byte.toString(sendBuffer[i]));
			//Log.i("rbuf", i+"="+sendBuffer[i]+"");
		}
		Log.d("send_rbuf", "---------------sendEnd----------------");


		currentSendDataID = sendDataID;
		try {
			mSerial.write(sendBuffer, sendBuffer.length);
			Thread.sleep(500);
			startTime = System.currentTimeMillis();
			TimeOut = true;
		}
		catch(Exception e)
		{
			Toast.makeText(getActivity(),  "모뎀을 연결을 확인하세요.", Toast.LENGTH_SHORT).show();
			return;
		}
	}


	/**
	 * Saves values for view switching
	 */
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		//outState.putString(BUNDLEKEY_LOADTEXTVIEW, tvText.getText().toString());
	}

	/**
	 * Loads values for view switching
	 */

	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onSaveInstanceState(savedInstanceState);
		tvText.setText(savedInstanceState.getString(BUNDLEKEY_LOADTEXTVIEW));
	}

	@Override
	public void onDestroy() {
		mSerial.close();
		mStop = true;
		getActivity().unregisterReceiver(mUsbReceiver);
		super.onDestroy();
	}

	private void ModemListsUpdate()
	{
		
		new Thread(new Runnable() {
		    @Override
		    public void run() {    
		        getActivity().runOnUiThread(new Runnable(){
		            @Override
		             public void run() {
		            	if(mModemAdapter != null) { 
		        			mModemAdapter.updateReadModelList(selectModemList());
		        			readModem_Num.setText("" + Integer.toString(mModemAdapter.getCount()));
		        		}
		        		if(mElecMeterAdapter != null) {
		        			mElecMeterAdapter.updateElecMeterlList(selectMeterList());
		        			elecMeter_Num.setText("" + Integer.toString(mElecMeterAdapter.getCount()));
		        		}
		        		if(mRecollectModemAdapter != null) {
		        			mRecollectModemAdapter.updateReadModelList(selectRecollectList());
		        			reCollect_Num.setText("" + Integer.toString(mRecollectModemAdapter.getCount()));
		        		}
		             }
		        });
		    }
		}).start();
	}
	

	Handler handler = new Handler();
	Runnable getInfoFromServer = new Runnable() {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			//GetLocationFromServer getLocationFromServer = new GetLocationFromServer(getActivity());
			SQLiteDatabase db = dbHelper.getWritableDatabase();
			db.execSQL(DBConfig.DELETE_MODEM); 
			db.execSQL(DBConfig.DELETE_RECOLLECT_MODEMLIST);

			loadLocationId();
			loadSuplierId();


			GetDataFromServer getDataFromServer = new GetDataFromServer(getActivity(), IP, PORT, RETRY_SEC, RETRY_NUM, TIMEOUT_SEC, SUPLIER_ID, LOCATION_ID);

			try {
				//getLocationFromServer.execute("").get(5000, TimeUnit.MILLISECONDS);
//				String ret = getDataFromServer.execute("").get(5000, TimeUnit.MILLISECONDS); // 폴링시간 
				Log.d("TIMEOUT_SEC", Long.valueOf(TIMEOUT_SEC) + "");
				String ret = getDataFromServer.execute("").get(Long.valueOf(TIMEOUT_SEC) * 1000, TimeUnit.MILLISECONDS); // 폴링시간 				
//				Thread.sleep(1000);
				
				ModemListsUpdate();

				if(ret == null)
				{
					ModemListsUpdate();

					Toast.makeText(getActivity(), "연결설정을 확인하세요", Toast.LENGTH_LONG).show();
					Intent i = new Intent(getActivity(), SettingSubmitPopup.class);
					startActivityForResult(i, 0);
				}
			}catch (Exception e)
			{
				e.printStackTrace();
				handler.removeCallbacks(getInfoFromServer);
				
				ModemListsUpdate();
				Toast.makeText(getActivity(), "연결설정을 확인하세요", Toast.LENGTH_LONG).show();
				Intent i = new Intent(getActivity(), SettingSubmitPopup.class);
				
				startActivityForResult(i, 0);	
				/*
				boolean post = handler.postDelayed(getInfoFromServer, Integer.parseInt(RETRY_SEC) *1000); // 재시도 시간
				Log.i("POST VALUE",post+"");
				long start = System.currentTimeMillis();
				if(!post){
					for(int i=0; i<Integer.getInteger(RETRY_NUM); i++){
						handler.postDelayed(getInfoFromServer, Integer.parseInt(RETRY_SEC) *1000); // 재시도 시간
					}
				}
				long end = System.currentTimeMillis();
				Log.i("POST TicToc",(end-start)+"");
				 */
			}
		}
	};

	/*Runnable popFinish = new Runnable(){

		@Override
		public void run() {
			try {
				popupFinish.execute("").get();
			} catch (Exception e){
				Log.d("popupFinish", "Fail");
			}
		}
		
	};*/

	public void loadLocationId(){
		dbHelper = DBHelper.getInstance(context);
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery(DBConfig.SELECT_LOCATION, null);
		cursor.moveToFirst();
		for (int i = 0; i < cursor.getCount(); i++) {
			if(cursor.getString(3).equals("true")){
				LOCATION_ID = cursor.getString(0);
			}
			cursor.moveToNext();
		}
	}


	public void loadSuplierId(){
		dbHelper = DBHelper.getInstance(context);
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery(DBConfig.SELECT_LOCATION, null);
		cursor.moveToFirst();

		for (int i = 0; i < cursor.getCount(); i++) {
			if(cursor.getString(3).equals("true")){
				SUPLIER_ID = cursor.getString(1);
			}
			cursor.moveToNext();
		}
	}
}
