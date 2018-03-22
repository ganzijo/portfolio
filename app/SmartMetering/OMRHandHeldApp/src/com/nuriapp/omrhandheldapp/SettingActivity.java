package com.nuriapp.omrhandheldapp;

import com.nuriapp.database.DBConfig;
import com.nuriapp.database.DBHelper;
import com.nuriapp.popup.SettingEncodingPopup;
import com.nuriapp.popup.SettingLocationPopup;
import com.nuriapp.popup.SettingStoragePopup;
import com.nuriapp.popup.SettingSubmitPopup;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageButton;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.ToggleButton;

public class SettingActivity extends Activity implements OnClickListener {
	private ImageButton backPageBtn, switchAutoLogin;
	private TextView titleTV, userIdTV, logoutTV, autoLoginTV, otherLoginTV,
			encodingTV, locationInfoTV, transmissionServerTV, storageDeleteTV,
			verInfoTV, appInfo;
	private TableRow logoutTR, autoLoginTR, otherLoginTR, encodingTR,
			locationInfoTR, transmissionServerTR, storageDeleteTR, verInfoTR,
			appHelpTR;

	boolean isSwitchAutoLogin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);

		// DB
		// DBHelper dbHelper = new DBHelper(SettingActivity.this);
		// SQLiteDatabase db = dbHelper.getReadableDatabase();

		// FONT
		Typeface typeFaceBody = Typeface.createFromAsset(getAssets(),
				"fonts/sangsang_font/SangSangBodyL.ttf");
		Typeface typeFaceHead = Typeface.createFromAsset(getAssets(),
				"fonts/sangsang_font/SangSangBodyM.ttf");

		// setting for action bar start
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(false);
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setDisplayShowTitleEnabled(false);
		LayoutInflater inflater = LayoutInflater.from(this);
		View customView = inflater.inflate(R.layout.custom_actionbar, null);
		TextView titleTV = (TextView) customView.findViewById(R.id.tv_Title);
		titleTV.setText("OMR HandHeld App");
		titleTV.setTextColor(Color.WHITE);
		titleTV.setTypeface(typeFaceBody);
		backPageBtn = (ImageButton) customView.findViewById(R.id.btn_Back);
		backPageBtn.setOnClickListener(this);
		actionBar.setCustomView(customView);
		actionBar.setDisplayShowCustomEnabled(true);
		// setting for action bar end

		titleTV = (TextView) findViewById(R.id.tv_Title);
		userIdTV = (TextView) findViewById(R.id.tv_UserId);
		logoutTV = (TextView) findViewById(R.id.tv_Logout);
		autoLoginTV = (TextView) findViewById(R.id.tv_AutoLogin);
		otherLoginTV = (TextView) findViewById(R.id.tv_OtherLogin);
		encodingTV = (TextView) findViewById(R.id.tv_Encoding);

		locationInfoTV = (TextView) findViewById(R.id.tv_LocationInfo);
		transmissionServerTV = (TextView) findViewById(R.id.tv_Transmission_Server);
		storageDeleteTV = (TextView) findViewById(R.id.tv_StorageDelete);
		verInfoTV = (TextView) findViewById(R.id.tv_VerInfo);
		appInfo = (TextView) findViewById(R.id.tv_AppInfo);

		logoutTR = (TableRow) findViewById(R.id.tr_Logout);
		logoutTR.setOnClickListener(this);
		autoLoginTR = (TableRow) findViewById(R.id.tr_AutoLogin);
		autoLoginTR.setOnClickListener(this);
		otherLoginTR = (TableRow) findViewById(R.id.tr_OtherLogin);
		otherLoginTR.setOnClickListener(this);
		encodingTR = (TableRow) findViewById(R.id.tr_Encoding);
		encodingTR.setOnClickListener(this);
		locationInfoTR = (TableRow) findViewById(R.id.tr_LocationInfo);
		locationInfoTR.setOnClickListener(this);
		transmissionServerTR = (TableRow) findViewById(R.id.tr_Transmission_Server);
		transmissionServerTR.setOnClickListener(this);
		storageDeleteTR = (TableRow) findViewById(R.id.tr_StorageDelete);
		storageDeleteTR.setOnClickListener(this);
		verInfoTR = (TableRow) findViewById(R.id.tr_VerInfo);
		verInfoTR.setOnClickListener(this);
		appHelpTR = (TableRow) findViewById(R.id.tr_AppHelp);
		appHelpTR.setOnClickListener(this);

		switchAutoLogin = (ImageButton) findViewById(R.id.switch_AutoLogin);
		switchAutoLogin.setOnClickListener(this);

		// DB에서 로드하는 코드를 적는다.
		DBHelper dbHelper = new DBHelper(SettingActivity.this);
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery(DBConfig.SELECT_USER_INFO, null);
		cursor.moveToFirst();

		userIdTV.setText(cursor.getString(1));
		isSwitchAutoLogin = Boolean.valueOf(cursor.getString(4));
		setSwitchAutoLogin(isSwitchAutoLogin);
		Log.i(cursor.getString(4), "cursor.getString(4)");

		titleTV.setTypeface(typeFaceBody);
		userIdTV.setTypeface(typeFaceBody);
		logoutTV.setTypeface(typeFaceBody);
		autoLoginTV.setTypeface(typeFaceBody);
		otherLoginTV.setTypeface(typeFaceBody);
		encodingTV.setTypeface(typeFaceBody);
		appInfo.setTypeface(typeFaceBody);

		locationInfoTV.setTypeface(typeFaceBody);
		transmissionServerTV.setTypeface(typeFaceBody);
		storageDeleteTV.setTypeface(typeFaceBody);
		verInfoTV.setTypeface(typeFaceBody);

	}

	// 매게변수 값에 따라 온 오프를 하는 함수.
	// isSwitch -> 단순하게 true면 키고 false면 끔.
	@SuppressWarnings("resource")
	public void setSwitchAutoLogin(boolean isSwitch) {

		// Log.i(cursor.getString(4), "cursor.getString(4)");
		DBHelper dbHelper = new DBHelper(SettingActivity.this);
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery(DBConfig.SELECT_USER_INFO, null);
		cursor.moveToFirst();

		db = dbHelper.getWritableDatabase();
		if (isSwitch) {
			switchAutoLogin.setSelected(true);
			isSwitchAutoLogin = true;
			// Log.i(cursor.getString(4), "cursor.getString(4)");

			cursor = db.rawQuery(DBConfig.UPDATE_AUTOLOGIN_TRUE, null);
			cursor.moveToFirst();
			cursor.close();
		} else {
			switchAutoLogin.setSelected(false);
			isSwitchAutoLogin = false;

			// Log.i(cursor.getString(4), "cursor.getString(4) ");
			cursor = db.rawQuery(DBConfig.UPDATE_AUTOLOGIN_FALSE, null);
			cursor.moveToFirst();
			cursor.close();

		}

	}

	@SuppressWarnings({ "resource", "null" })
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		DBHelper dbHelper = new DBHelper(SettingActivity.this);
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery(DBConfig.SELECT_USER_INFO, null);
		Intent i = null;
		
		switch (v.getId()) {

		case R.id.tr_Logout:
			
			logoutTR.setBackgroundResource(R.drawable.selector_setting_tablerow);

			cursor.moveToFirst();
			db = dbHelper.getWritableDatabase();
			cursor = db.rawQuery(DBConfig.UPDATE_AUTOLOGIN_FALSE, null);

			cursor.moveToFirst();
			cursor.close();
			i = new Intent(SettingActivity.this, LoginActivity.class);

			// http://mydevromance.tistory.com/40
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(i);
			finish();

			break;
		case R.id.tr_AutoLogin:
			autoLoginTR.setBackgroundResource(R.drawable.selector_setting_tablerow);
			break;
			
		case R.id.tr_OtherLogin:
			otherLoginTR.setBackgroundResource(R.drawable.selector_setting_tablerow);

			cursor.moveToFirst();
			db = dbHelper.getWritableDatabase();
			cursor = db.rawQuery(DBConfig.UPDATE_SAVEID_FALSE, null);
			
			cursor.moveToFirst();
			db = dbHelper.getWritableDatabase();
			cursor = db.rawQuery(DBConfig.UPDATE_AUTOLOGIN_FALSE, null);

			cursor.moveToFirst();
			cursor.close();
			i = new Intent(SettingActivity.this, LoginActivity.class);
			
			
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(i);
			finish();
			break;
			
		case R.id.tr_Encoding:
			encodingTR.setBackgroundResource(R.drawable.selector_setting_tablerow);
			i = new Intent(SettingActivity.this, SettingEncodingPopup.class);
			startActivity(i);
			break;
		case R.id.tr_LocationInfo:
			locationInfoTR.setBackgroundResource(R.drawable.selector_setting_tablerow);
			i = new Intent(SettingActivity.this, SettingLocationPopup.class);
			startActivity(i);			
			break;
		case R.id.tr_Transmission_Server:
			transmissionServerTR
					.setBackgroundResource(R.drawable.selector_setting_tablerow);
			i = new Intent(SettingActivity.this, SettingSubmitPopup.class);
			startActivity(i);
			break;
		case R.id.tr_StorageDelete:
			storageDeleteTR
					.setBackgroundResource(R.drawable.selector_setting_tablerow);
			i = new Intent(SettingActivity.this, SettingStoragePopup.class);
			startActivity(i);
			break;
		case R.id.tr_VerInfo:
			verInfoTR
					.setBackgroundResource(R.drawable.selector_setting_tablerow);
			break;
		case R.id.switch_AutoLogin:

			setSwitchAutoLogin(!isSwitchAutoLogin);
			break;
		case R.id.btn_Back:
			onBackPressed();
			break;
		case R.id.tr_AppHelp:
			appHelpTR
					.setBackgroundResource(R.drawable.selector_setting_tablerow);
			i = new Intent(SettingActivity.this, AppHelpActivity.class);
			startActivity(i);
		default:
			break;
		}
	}
}
