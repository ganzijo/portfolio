package com.nuriapp.popup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.nuriapp.database.DBConfig;
import com.nuriapp.database.DBHelper;
import com.nuriapp.omrhandheldapp.R;
import com.nuriapp.utils.CustomDialog;
import com.nuriapp.vo.ServerConfigVO;

public class SettingSubmitPopup extends Activity implements OnClickListener,
		OnFocusChangeListener {

	Button btn_Transmission_Popup_Confirm, btn_Transmission_Popup_cancel;
	EditText et_Ip1, et_Ip2, et_Ip3, et_Ip4, et_Portnum, et_RetrySec,
			et_RetryNum, et_TimeoutSec;
	String ipCombine, ip1, ip2, ip3, ip4, portNum, retrySec, retryNum,
			timeoutSec;
	CustomDialog dialog;
	boolean ipValidate = false;
	DBHelper dbHelper;
	DBConfig dbConfig;
	SQLiteDatabase db;
	Cursor cursor;
	Context context;
	
	//환경설정 -서버전송


	// DecimalFormat decimalFormat = new DecimalFormat("###.###.###.###.###");

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.popup_setting_submit);
		this.setFinishOnTouchOutside(false);

		
		// 변수선언
		setLayout();

	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		dbHelper = new DBHelper(getApplicationContext());
		db = dbHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery("select *from server_config", null);
		cursor.moveToFirst();
		Log.i("Test","test");
		Log.i("get.Count",""+cursor.getCount());
		
		if(((cursor != null) && (cursor.getCount() > 0))){
			
			ServerConfigVO ServerConfigDataVO = new ServerConfigVO(
					cursor.getString(0), cursor.getString(1),cursor.getString(2), cursor.getString(3), 
					cursor.getString(4),cursor.getString(5), cursor.getString(6), cursor.getString(7));
					et_Ip1.setText(ServerConfigDataVO.getIp1());
					et_Ip2.setText(ServerConfigDataVO.getIp2());
					et_Ip3.setText(ServerConfigDataVO.getIp3());
					et_Ip4.setText(ServerConfigDataVO.getIp4());
					et_Portnum.setText(ServerConfigDataVO.getPortNum());
					et_RetrySec.setText(ServerConfigDataVO.getRetrySec());
					et_RetryNum.setText(ServerConfigDataVO.getRetryNum());
					et_TimeoutSec.setText(ServerConfigDataVO.getTimeoutSec());
		}

		
	}

	private void setLayout() {
		// TODO Auto-generated method stub
		et_Ip1 = (EditText) findViewById(R.id.et_Ip1);
		et_Ip2 = (EditText) findViewById(R.id.et_Ip2);
		et_Ip3 = (EditText) findViewById(R.id.et_Ip3);
		et_Ip4 = (EditText) findViewById(R.id.et_Ip4);
		et_Portnum = (EditText) findViewById(R.id.et_Portnum);
		et_RetrySec = (EditText) findViewById(R.id.et_RetrySec);
		et_RetryNum = (EditText) findViewById(R.id.et_RetryNum);
		et_TimeoutSec = (EditText) findViewById(R.id.et_TimeoutSec);
		et_Ip1.setOnFocusChangeListener(this);
		et_Ip2.setOnFocusChangeListener(this);
		et_Ip3.setOnFocusChangeListener(this);
		et_Ip4.setOnFocusChangeListener(this);
		et_Portnum.setOnFocusChangeListener(this);
		et_RetrySec.setOnFocusChangeListener(this);
		et_RetryNum.setOnFocusChangeListener(this);
		et_TimeoutSec.setOnFocusChangeListener(this);
		btn_Transmission_Popup_Confirm = (Button) findViewById(R.id.btn_Transmission_Popup_Confirm);
		btn_Transmission_Popup_Confirm.setOnClickListener(this);
		btn_Transmission_Popup_cancel = (Button) findViewById(R.id.btn_Transmission_Popup_cancel);
		btn_Transmission_Popup_cancel.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {
		case R.id.btn_Transmission_Popup_Confirm:
			/*// 이부분 필요 없는것 같다... 시작
			if (ipValidate == true) {
				ipCombine = ip1 + "." + ip2 + "." + ip3 + "." + ip4;
				// shared 또는 database 로 update
			} else {
				ipCombine = ip1 + "." + ip2 + "." + ip3 + "." + ip4;
				// default Ip 로
			}
			// 이부분 필요 없는것 같다... 끝*/
			ip1 = et_Ip1.getText().toString();
			ip2 = et_Ip2.getText().toString();
			ip3 = et_Ip3.getText().toString();
			ip4 = et_Ip4.getText().toString();
			
			portNum = et_Portnum.getText().toString();
			retryNum = et_RetryNum.getText().toString();
			retrySec = et_RetrySec.getText().toString();
			timeoutSec = et_TimeoutSec.getText().toString();
			Log.i("DBConfig.UPDATE_SERVER_CONFIG", DBConfig.UPDATE_SERVER_CONFIG + "ip1 =" + ip1
					+ ", ip2 =" + ip2 + ", ip3 =" + ip3 + ", ip4 =" + ip4
					+ ", port =" + portNum + ", retry_sec =" + retrySec
					+ ", retry_num =" + retryNum + ", timeout_sec ="
					+ timeoutSec + ";");
			dbHelper = new DBHelper(getApplicationContext());
			db = dbHelper.getWritableDatabase();
			cursor = db.rawQuery(DBConfig.UPDATE_SERVER_CONFIG + "ip1 =" + ip1
					+ ", ip2 =" + ip2 + ", ip3 =" + ip3 + ", ip4 =" + ip4
					+ ", port =" + portNum + ", retry_sec =" + retrySec
					+ ", retry_num =" + retryNum + ", timeout_sec ="
					+ timeoutSec + ";", null);
			
			cursor.moveToFirst();
			cursor.close();
			
			
			Intent intent = new Intent();
			intent.putExtra("key", 1);
			//ReadListFragment --> onActivityResult가 실행 됨
			setResult(1, intent);
			

			finish();
		
			break;
			
		case R.id.btn_Transmission_Popup_cancel:
//			Intent intent1 = new Intent();
//			intent1.putExtra("key", 0);
//			setResult(1, intent1);
			finish();
			break;
		}
	}

	// 유진씨가 Dialog 넣기
	@Override
	public void onFocusChange(View v, boolean hasFocus) {
		// TODO Auto-generated method stub
		dialog = new CustomDialog(SettingSubmitPopup.this);

		switch (v.getId()) {
		case R.id.et_Ip1:
			if (hasFocus == false) {
				if (Integer.parseInt(et_Ip1.getText().toString()) < 1
						|| Integer.parseInt(et_Ip1.getText().toString()) > 233) {
					dialog.show();
					dialog.tv_Title.setText("IP 설정 오류");
					dialog.tv_Message
							.setText("항목이 올바르지 않습니다.\n 1~233 사이의 값을 지정하십시오.");
					ipValidate = false;
			//		et_Ip1.setText("233");
					//ip1 = et_Ip1.getText().toString();
					hasFocus = true;
					et_Ip1.requestFocus();
				} else {
					ipValidate = true;
					//ip1 = et_Ip1.getText().toString();
				}
			}
			break;

		case R.id.et_Ip2:
			if (hasFocus == false) {
				if (Integer.parseInt(et_Ip2.getText().toString()) < 0
						|| Integer.parseInt(et_Ip2.getText().toString()) > 255) {
					dialog.show();
					dialog.tv_Title.setText("IP 설정 오류");
					dialog.tv_Message
							.setText("항목이 올바르지 않습니다.\n 0~255 사이의 값을 지정하십시오.");
					ipValidate = false;
					//et_Ip2.setText("255");
					ip2 = et_Ip2.getText().toString();
					hasFocus = true;
				} else {
					ipValidate = true;
					//ip2 = et_Ip2.getText().toString();
				}
			}
			break;
		case R.id.et_Ip3:
			if (hasFocus == false) {
				if (Integer.parseInt(et_Ip3.getText().toString()) < 0
						|| Integer.parseInt(et_Ip3.getText().toString()) > 255) {
					dialog.show();
					dialog.tv_Title.setText("IP 설정 오류");
					dialog.tv_Message
							.setText("항목이 올바르지 않습니다.\n 0~255 사이의 값을 지정하십시오.");
					ipValidate = false;
					//et_Ip3.setText("255");
					//ip3 = et_Ip3.getText().toString();
					hasFocus = true;
				} else {
					ipValidate = true;
					//ip3 = et_Ip3.getText().toString();
				}
			}
			break;
		case R.id.et_Ip4:
			if (hasFocus == false) {
				if (Integer.parseInt(et_Ip4.getText().toString()) < 0
						|| Integer.parseInt(et_Ip4.getText().toString()) > 255) {
					dialog.show();
					dialog.tv_Title.setText("IP 설정 오류");
					dialog.tv_Message
							.setText("항목이 올바르지 않습니다.\n 0~255 사이의 값을 지정하십시오.");
					ipValidate = false;
					//et_Ip4.setText("255");
					//ip4 = et_Ip4.getText().toString();
					hasFocus = true;
				} else {
					ipValidate = true;
					//ip4 = et_Ip4.getText().toString();
				}
			}
			break;
		case R.id.et_Portnum:
			if (hasFocus == false) {
				if (Integer.parseInt(et_Portnum.getText().toString()) > 9999) {
					dialog.show();
					dialog.tv_Title.setText("PORT 설정 오류");
					dialog.tv_Message
							.setText("최대 범위를 초과하였습니다.\n9999 이하의 값을 지정하십시오.");
					et_Portnum.setText("8085");
					//portNum = et_Portnum.getText().toString();
					hasFocus = true;
				} else {
					//portNum = et_Portnum.getText().toString();
				}
			}
			break;
		case R.id.et_RetrySec:
			if (hasFocus == false) {
				if (Integer.parseInt(et_RetrySec.getText().toString()) > 10) {
					dialog.show();
					dialog.tv_Title.setText("재시도 설정 오류");
					dialog.tv_Message
							.setText("최대 범위를 초과하였습니다.\n10 이하의 값을 지정하십시오.");
					et_RetrySec.setText("10");
					//retrySec = et_RetrySec.getText().toString();
					hasFocus = true;
				} else {
					//retrySec = et_RetrySec.getText().toString();
				}
			}
			break;
		case R.id.et_RetryNum:
			if (hasFocus == false) {
				if (Integer.parseInt(et_RetryNum.getText().toString()) > 5) {
					dialog.show();
					dialog.tv_Title.setText("재시도 설정 오류");
					dialog.tv_Message.setText("최대 범위를 초과하였습니다.\n5 이하의 값을 지정하십시오.");
					et_RetryNum.setText("5");
					//retryNum = et_RetryNum.getText().toString();
					hasFocus = true;
				} else {
					//retryNum = et_RetryNum.getText().toString();
				}
			}
			break;
		case R.id.et_TimeoutSec:
			if (hasFocus == false) {
				if (Integer.parseInt(et_TimeoutSec.getText().toString()) > 180) {
					dialog.show();
					dialog.tv_Title.setText("타임아웃 설정 오류");
					dialog.tv_Message
							.setText("최대 범위를 초과하였습니다.\n180 이하의 값을 지정하십시오.");
					et_TimeoutSec.setText("60");
					//timeoutSec = et_TimeoutSec.getText().toString();
					hasFocus = true;
				} else {
					//timeoutSec = et_TimeoutSec.getText().toString();
				}
			}
			break;
		}

	}
	
	
}
