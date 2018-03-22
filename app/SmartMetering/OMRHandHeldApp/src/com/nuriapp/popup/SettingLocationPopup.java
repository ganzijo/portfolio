package com.nuriapp.popup;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import android.R.drawable;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

import com.nuriapp.database.DBConfig;
import com.nuriapp.database.DBHelper;
import com.nuriapp.omrhandheldapp.R;
import com.nuriapp.server.GetDataFromServer;
import com.nuriapp.vo.GetLocationInfoVO;

public class SettingLocationPopup extends Activity implements OnClickListener,OnCheckedChangeListener {

	TextView title;
	Button locationConfirmBtn, locationCancelBtn;
	RadioGroup radiogroup;
	ArrayList<String> LocationNameAL;
	ArrayList<Boolean> TrueFalseAL;
	SQLiteDatabase db;
	Cursor cursor;
	DBHelper dbHelper;
	Context contex;
	GetLocationInfoVO getLocationVo = new GetLocationInfoVO();

	 
	//환경설정 -서버전송
	private static String IP=null;
	private static String PORT=null;
	private static String RETRY_NUM;
	private static String RETRY_SEC;
	private static String TIMEOUT_SEC;
		
	//
	public static String locationId;
	public static String suplierId;
	
	// 클릭된 locationCode
	public static String locationCode;
	public String trueFalse;
	
	
	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.popup_setting_location);
		this.setFinishOnTouchOutside(false);

		Typeface typeFaceBody = Typeface.createFromAsset(this.getAssets(),"fonts/sangsang_font/SangSangBodyL.ttf");

		title = (TextView) findViewById(R.id.tv_Title);
		title.setTypeface(typeFaceBody);
		locationConfirmBtn = (Button) findViewById(R.id.btn_Location_Popup_Confirm);
		locationConfirmBtn.setOnClickListener(this);
		locationCancelBtn = (Button) findViewById(R.id.btn_Location_Popup_cancel);
		locationCancelBtn.setOnClickListener(this);

		LocationNameAL = new ArrayList<String>();
		TrueFalseAL = new ArrayList<Boolean>();
		radiogroup = (RadioGroup) findViewById(R.id.radiogruop);
		radiogroup.setOnCheckedChangeListener(this);
	/*	radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				if(Ch)
			}
		});*/

		
		// DB Setting
		dbHelper = DBHelper.getInstance(this);
		loadDB();
		initRadioButton();
		
		
		/*	GetLocationId();
		Log.i("LocationId ",locationId+"");
		GetSuplierId();
		Log.i("SuplierId ",suplierId+"");*/
		
		//서버설정값 가져오기
		
		dbHelper = DBHelper.getInstance(contex);
		db = dbHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery("select *from server_config", null);
		cursor.moveToFirst();
			for(int i=0;i<cursor.getColumnCount();i++){
				IP = cursor.getString(0)+"."+cursor.getString(1)+"."+cursor.getString(2)+"."+cursor.getString(3);
				PORT =":"+ cursor.getString(4);
				RETRY_SEC = cursor.getString(5);
				RETRY_NUM = cursor.getString(6);
				TIMEOUT_SEC = cursor.getString(7);
			}
		}

	private void loadDB() {
		// TODO Auto-generated method stub
		LocationNameAL.clear();
		TrueFalseAL.clear();

		SQLiteDatabase db = dbHelper.getReadableDatabase();
		cursor = db.rawQuery(DBConfig.SELECT_LOCATION, null);
		cursor.moveToFirst();

		for (int i = 0; i < cursor.getCount(); i++) {
			boolean isCheck = (cursor.getString(3).equals("false")) ? false: true;
			LocationNameAL.add(cursor.getString(2));
			Log.i("DBTEST_LocationNameAL ",cursor.getString(0) + "," + cursor.getString(1)+ "," + cursor.getString(2)+ "," + cursor.getString(3));
			TrueFalseAL.add(isCheck);
			Log.i("DBTEST_TrueFalseAL ", cursor.getString(2));
			cursor.moveToNext();
		}

	}

	private void initRadioButton() {
		// TODO Auto-generated method stub
		final float scale = getResources().getDisplayMetrics().density;
		int padding_10dp = (int) (10 * scale + 0.5f);
		String j;


		for (int i = 0; i < LocationNameAL.size(); i++) {
			RadioButton radiobtn = new RadioButton(this);
			Drawable draw = getApplicationContext().getResources().getDrawable(drawable.btn_radio);

			radiobtn.setId(i);
			radiobtn.setTextColor(Color.rgb(0, 0, 0));
			radiobtn.setGravity(Gravity.LEFT);
			radiobtn.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
			radiobtn.setTextSize(25);
			radiobtn.setButtonDrawable(null);
			radiobtn.setBackground(null);
			radiobtn.setCompoundDrawablesWithIntrinsicBounds(null, null, draw,null);
			radiobtn.setPadding(padding_10dp, padding_10dp, padding_10dp,padding_10dp);
			
			Log.i("DBTEST_TrueFalseALGet ", TrueFalseAL.get(i).toString());
			radiogroup.addView(radiobtn);
			if (TrueFalseAL.get(i) == true) {
				radiobtn.setChecked(true);
				locationCode = LocationNameAL.get(i).toString();
			}
		}
		// 라디오버튼들의 텍스트를 설정
		setTextRadioButton();
	}

	public void setTextRadioButton() {
		final float scale = getResources().getDisplayMetrics().density;
		int padding_10dp = (int) (10 * scale + 0.5f);
		int padding_300dp = (int) (20 * scale + 0.5f);

		for (int i = 0; i < LocationNameAL.size(); i++) {
			RadioButton btn = (RadioButton) radiogroup.getChildAt(i);
			btn.setText(LocationNameAL.get(i));
			btn.setPadding(padding_300dp, padding_10dp, padding_10dp,
					padding_10dp);
			// btn.setGravity(Gravity.CENTER);
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {

		case R.id.btn_Location_Popup_Confirm:
			SQLiteDatabase db = dbHelper.getWritableDatabase();
			db.execSQL("update location set 'ischeck' = 'false';");
			db.execSQL("update location set 'ischeck' = 'true' where address ='"+locationCode+"';");
			Log.i("locationcode",locationCode+"");
			
			runOnUiThread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					handler.post(getInfoFromServer);
				}
			});
			
			finish();
			break;
			
		case R.id.btn_Location_Popup_cancel:
			finish();
			break;
		}
	}

	Handler handler = new Handler();
	Runnable getInfoFromServer = new Runnable() {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			//GetLocationFromServer getLocationFromServer = new GetLocationFromServer(getActivity());
			db.execSQL(DBConfig.DELETE_MODEM); 
			db.execSQL(DBConfig.DELETE_RECOLLECT_MODEMLIST);
			loadLocationId();
			loadSuplierId();
			
			GetDataFromServer getDataFromServer = new GetDataFromServer(contex, IP, PORT, RETRY_SEC, RETRY_NUM, TIMEOUT_SEC, suplierId, locationId);

			try {
				//getLocationFromServer.execute("").get(5000, TimeUnit.MILLISECONDS);
				getDataFromServer.execute("").get(1000, TimeUnit.MILLISECONDS); // 폴링시간 
			}  catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	};
	
	
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		RadioButton radioButton = (RadioButton) findViewById(checkedId);
		boolean isChecked = radioButton.isChecked(); 
		// 체크된 라디오버튼 값
		if(checkedId != -1){
		}
		if(isChecked){
			locationCode = radioButton.getText().toString();
		}else{
			radioButton.setChecked(true);
		}
		
		Log.i("DBTEST_locationCode", locationCode);
		
	}
	

	public void loadLocationId(){
		dbHelper = DBHelper.getInstance(getApplicationContext());
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery(DBConfig.SELECT_LOCATION, null);
		cursor.moveToFirst();
		for (int i = 0; i < cursor.getCount(); i++) {
			if(cursor.getString(3).equals("true")){
				locationId = cursor.getString(0);
			}
			cursor.moveToNext();
		}
	}
	
	
	public void loadSuplierId(){
		dbHelper = DBHelper.getInstance(getApplicationContext());
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery(DBConfig.SELECT_LOCATION, null);
		cursor.moveToFirst();
		
		for (int i = 0; i < cursor.getCount(); i++) {
			if(cursor.getString(3).equals("true")){
				suplierId = cursor.getString(1);
			}
			cursor.moveToNext();
		}
	}
}



