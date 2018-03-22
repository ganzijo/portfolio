package com.nuriapp.omrhandheldapp;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.text.InputType;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.nuriapp.database.DBConfig;
import com.nuriapp.database.DBHelper;
import com.nuriapp.server.GetDataFromServer;
import com.nuriapp.utils.BackPressCloseSystem;
import com.nuriapp.utils.CustomDialog;
import com.nuriapp.utils.LoginTaskProgress;

public class LoginActivity extends Activity {
	private EditText loginIdEt, loginPasswordEt;
	private Button confirmBtn, tempBtn;
	private CheckBox saveIdCheck, autoLoginCheck;
	private InputMethodManager imm; // keyboard hide or show
	private ProgressDialog pDialog;
	private BackPressCloseSystem backPressCloseSystem;
	private AlertDialog.Builder alert;
	private TextView versionTv;

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		// tempBtn.setOnClickListener(new OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		// // TODO Auto-generated method stub
		// Intent i = new Intent(LoginActivity.this, TempPage.class);
		// startActivity(i);
		// finish();
		// }
		// });

		DBHelper dbHelper = new DBHelper(LoginActivity.this);
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery(DBConfig.SELECT_USER_INFO, null);
		
		if (cursor.getCount() != 0 && cursor != null) {

			cursor.moveToFirst();
			if (cursor.getString(1).equals("admin")&& cursor.getString(4).equals("true")) {
				// ID is Admin && autoLogin is true
				// Intent i = new Intent(LoginActivity.this, MainActivity.class);
				
				
				
				Intent i = new Intent(LoginActivity.this,MainFragmentActivity.class);
				startActivity(i);
				finish();
				Log.i("", "자동로그인 상태입니다.");
			} else if (cursor.getString(1).equals("admin")
					&& cursor.getString(3).equals("true")) {
				// Saved Id
				loginIdEt.setText(cursor.getString(1));
				saveIdCheck.setChecked(true);
				Log.i("", "아이디 저장 상태입니다.");
			}
			Log.i(cursor.getString(4), "OnResume !!! cursor.getString(4)");
		}
		loginIdEt.setImeOptions(EditorInfo.IME_ACTION_NEXT);
		loginIdEt.setInputType(InputType.TYPE_CLASS_TEXT);
		loginPasswordEt.setImeOptions(EditorInfo.IME_ACTION_DONE);
		
		

		confirmBtn.setOnClickListener(new OnClickListener() {

			@SuppressWarnings("resource")
			@Override
			public void onClick(View v) {
				String userId = loginIdEt.getText().toString();
				String userPw = loginPasswordEt.getText().toString();
				DBHelper dbHelper = new DBHelper(LoginActivity.this);
				SQLiteDatabase db = dbHelper.getReadableDatabase();
				Cursor cursor = db.rawQuery(DBConfig.SELECT_USER_INFO, null);
				cursor.moveToFirst();

				if (cursor != null && cursor.moveToFirst()) {

					Log.i(cursor.getString(1), "Here~~~~~~~~~~");
					Log.i(cursor.getString(4), "cursor.getString(4)");
					if (userId.equals(cursor.getString(1).toString())
							&& userPw.equals(cursor.getString(2).toString())) { // login success
						db = dbHelper.getWritableDatabase();
						if (autoLoginCheck.isChecked()) { // autologin check state
							cursor = db.rawQuery(DBConfig.UPDATE_AUTOLOGIN_TRUE, null);
							cursor.moveToFirst();
							cursor.close();
						} else {
							cursor = db.rawQuery(DBConfig.UPDATE_AUTOLOGIN_FALSE, null);
							cursor.moveToFirst();
							cursor.close();
						}
						if (saveIdCheck.isChecked()) { // saveid check state
							cursor = db.rawQuery(DBConfig.UPDATE_SAVEID_TRUE,null);
							cursor.moveToFirst();
							cursor.close();
						} else {
							cursor = db.rawQuery(DBConfig.UPDATE_SAVEID_FALSE,null);
							cursor.moveToFirst();
							cursor.close();
						}
						db = dbHelper.getReadableDatabase();
						cursor = db.rawQuery(DBConfig.SELECT_USER_INFO, null);
						cursor.moveToFirst();
						cursor.close();

						new LoginTaskProgress(LoginActivity.this).execute(30);
						Intent i = new Intent(LoginActivity.this,MainFragmentActivity.class);
						startActivity(i);
						
					} else if (userId.equals("")) {
						final CustomDialog dialoge = new CustomDialog(LoginActivity.this);
						dialoge.show();
						dialoge.tv_Message.setText("id를 입력해주세요");
						dialoge.tv_Title.setText("로그인");
					} else if (userPw.equals("")) {
						final CustomDialog dialoge = new CustomDialog(LoginActivity.this);
						dialoge.show();
						dialoge.tv_Message.setText("pwd를 입력해주세요");
						dialoge.tv_Title.setText("로그인");

					} else if (!userId.equals("admin") && userPw.equals("1")) {
						final CustomDialog dialoge = new CustomDialog(LoginActivity.this);
						dialoge.show();
						dialoge.tv_Message.setText("사용자 정보가 일치하지 않습니다.");
						dialoge.tv_Title.setText("로그인");
						
					} else if (userId.equals("admin") && !userPw.equals("1")) {
						final CustomDialog dialoge = new CustomDialog(LoginActivity.this);
						dialoge.show();
						dialoge.tv_Message.setText("사용자 정보가 일치하지 않습니다.");
						dialoge.tv_Title.setText("로그인");

					} else {
						final CustomDialog dialoge = new CustomDialog(LoginActivity.this);
						dialoge.show();
						dialoge.tv_Message.setText("사용자 정보가 일치하지 않습니다.");
						dialoge.tv_Title.setText("로그인");
					}
				}else {
					final CustomDialog dialoge = new CustomDialog(LoginActivity.this);
					dialoge.show();
					dialoge.tv_Message.setText("데이터베이스를 로드할 수 없습니다.");
					dialoge.tv_Title.setText("로그인");
				}
				
				imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(loginPasswordEt.getWindowToken(), 0);
			}
		});

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_activity);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		alert = new AlertDialog.Builder(LoginActivity.this);

		loginIdEt = (EditText) findViewById(R.id.et_LoginId);
		loginPasswordEt = (EditText) findViewById(R.id.et_LoginPw);
		saveIdCheck = (CheckBox) findViewById(R.id.chk_SaveId);
		autoLoginCheck = (CheckBox) findViewById(R.id.chk_AutoLogin);
		confirmBtn = (Button) findViewById(R.id.btn_Login);
		versionTv = (TextView)findViewById(R.id.tv_Version);
		
		 backPressCloseSystem = new BackPressCloseSystem(this); // 뒤로 가기 버튼  이벤트

		pDialog = new ProgressDialog(this);
		pDialog.setCancelable(false);

		setupUI(findViewById(R.id.login_page_main_linear));

		Typeface typeFaceBody = Typeface.createFromAsset(getAssets(),"fonts/sangsang_font/SangSangBodyL.ttf");

		loginIdEt.setTypeface(typeFaceBody);
		loginPasswordEt.setTypeface(typeFaceBody);
		saveIdCheck.setTypeface(typeFaceBody);
		autoLoginCheck.setTypeface(typeFaceBody);
		confirmBtn.setTypeface(typeFaceBody);
		versionTv.setTypeface(typeFaceBody);

	}

	private void hideSoftKeyboard(Activity activity) {
		imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);// activity.INPUT_METHOD_SERVICE
		imm.hideSoftInputFromWindow(
				activity.getCurrentFocus().getWindowToken(), 0);
	}

	public void setupUI(View view) { // 화면 밖 터치 시 키보드 숨김 이벤트

		// Set up touch listener for non-text box views to hide keyboard.
		if (!(view instanceof EditText)) {

			view.setOnTouchListener(new OnTouchListener() {

				public boolean onTouch(View v, MotionEvent event) {
					hideSoftKeyboard(LoginActivity.this);
					return false;
				}

			});
		}

		// If a layout container, iterate over children and seed recursion.
		if (view instanceof ViewGroup) {

			for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {

				View innerView = ((ViewGroup) view).getChildAt(i);

				setupUI(innerView);
			}
		}
	}

	    // @Override
	    public void onBackPressed() {
		backPressCloseSystem.onBackPressed();
	 }
	    
	    
	    
}
