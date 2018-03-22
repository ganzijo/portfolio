package com.nuriapp.popup;

import java.io.File;

import org.apache.commons.lang3.StringUtils;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.format.Formatter;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.nuriapp.database.DBConfig;
import com.nuriapp.database.DBHelper;
import com.nuriapp.omrhandheldapp.R;
import com.nuriapp.omrhandheldapp.R.id;
import com.nuriapp.omrhandheldapp.R.layout;
import com.nuriapp.utils.CustomDialog;

public class SettingStoragePopup extends Activity implements OnClickListener,
		OnFocusChangeListener {
	Button btn_Storage_Popup_Confirm, btn_Storage_Popup_Cancel;
	private TextView tv_UseCapacity, tv_Delete_Data;
	private EditText et_Save_Period;
	String savePeriod;
	CustomDialog dialog;
	Cursor cursor;
	DBConfig dbConfig;
	DBHelper dbHelper;
	SQLiteDatabase db;
	CustomDialog customDialog;

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		File path = Environment.getDataDirectory();
		StatFs stat = new StatFs(path.getPath());
		long blockSize = stat.getBlockSize();
		long availableBlocks = stat.getAvailableBlocks();
		long totalSize = stat.getBlockCount() * blockSize;
		long remainSize = totalSize - (availableBlocks * blockSize);
		String availableStorage = Formatter.formatFileSize(this,
				availableBlocks * blockSize);
		String totalStorage = Formatter.formatFileSize(this, totalSize);
		String remainStorage = Formatter.formatFileSize(this, remainSize);
		Log.i("Available Storage Size : ", availableStorage);
		Log.i("Total Storage Size : ", totalStorage);
		tv_UseCapacity.setText(remainStorage + "/" + availableStorage);

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.popup_setting_storage);
		this.setFinishOnTouchOutside(false);

		btn_Storage_Popup_Confirm = (Button) findViewById(R.id.btn_Storage_Popup_Confirm);
		btn_Storage_Popup_Confirm.setOnClickListener(this);
		btn_Storage_Popup_Cancel = (Button) findViewById(R.id.btn_Storage_Popup_Cancel);
		btn_Storage_Popup_Cancel.setOnClickListener(this);

		tv_UseCapacity = (TextView) findViewById(R.id.tv_UseCapacity);
		et_Save_Period = (EditText) findViewById(R.id.et_Save_Period);
		et_Save_Period.setOnFocusChangeListener(this);
		tv_Delete_Data = (TextView) findViewById(R.id.tv_Delete_Data);
		tv_Delete_Data.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {

		case R.id.btn_Storage_Popup_Confirm:
			SQLiteDatabase update_Savae_Period = dbHelper.getWritableDatabase();
			savePeriod = et_Save_Period.getText().toString();
			Log.i("savePeriod", "현재 savePeriod" +"="+savePeriod);
			if(Integer.parseInt(savePeriod) > 30){
				Toast.makeText(getApplicationContext(), "최대 보관일수를 초과했습니다.", Toast.LENGTH_SHORT).show();
				break;
			}else{
				update_Savae_Period.execSQL("update StorageStates set save_period = '"+savePeriod+"';");
				Log.i("savePeriod", savePeriod+"");
			}
			
			finish();
			break;
		case R.id.btn_Storage_Popup_Cancel:
			finish();
			break;
		case R.id.tv_Delete_Data:
			dbHelper = new DBHelper(getApplicationContext());
			db = dbHelper.getWritableDatabase();
			cursor = db.rawQuery("", null);
			// 관련 테이블 데이터 삭제
			// Drop Table 후 초기에 생성을 할지, 데이터만 삭제할지 결정필요
			break;
		}

	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		dbHelper = new DBHelper(getApplicationContext());
		db = dbHelper.getReadableDatabase();
		cursor = db.rawQuery("SELECT *from StorageStates;", null);
		cursor.moveToFirst();
		if (StringUtils.isNotBlank(cursor.getString(0))) {
			et_Save_Period.setText(cursor.getString(0));
		} else
			et_Save_Period.setText("5");
	}

	@Override
	public void onFocusChange(View v, boolean hasFocus) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.et_Save_Period:
			if (hasFocus == false) {
				if (StringUtils.isNotBlank(et_Save_Period.getText())) {
					// 이 부분에서 DB에 저장기간 값 저장해서 짜기

					Log.i("savePeriod", "here~~~~~~~~~~~~");
					if (Integer.parseInt(et_Save_Period.getText().toString()) > 30) {

						Log.i("savePeriod", "here2~~~~~~~~~~~~");
						dialog.show();
						dialog.tv_Title.setText("보관주기 설정 실패");
						dialog.tv_Message.setText("최대 보관일수를 초과했습니다.");
						cursor.moveToFirst();
						et_Save_Period.setText(cursor.getString(0));
						savePeriod = et_Save_Period.getText().toString();
					} else {
						savePeriod = et_Save_Period.getText().toString();
						Log.i("savePeriod", "here3~~~~~~~~~~~~");
						// 입력받은 텍스트로 쿼리문 날리기
					}

				} else
					et_Save_Period.setText("5");
			}
		}
	}

}
