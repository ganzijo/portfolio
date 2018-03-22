package com.nuriapp.omrhandheldapp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.nuriapp.adapter.ElecMeterAdapter;
import com.nuriapp.database.DBConfig;
import com.nuriapp.database.DBHelper;
import com.nuriapp.vo.ModemVO;

public class DetailInfo extends Activity implements OnClickListener {

	Button successBtn , failBtn;
	ImageButton cancelBtn;
	TextView modemId, address, lastTime, state;
	View ll_Success, ll_Fail;
	//ListView DetailInfo_LV;
	ListView DetailInfo_Success_LV ,DetailInfo_Fail_LV;
	
	//DetailInfoAdapter  mDetailInfoAdapter;
	public ElecMeterAdapter mDetailInfoSuccessAdapter;
	public ElecMeterAdapter mDetailInfoFailAdapter;
	
	//ArrayList<ModemVO> DetailInfoArrayList;
	ArrayList<ModemVO> DetailInfo_Success_ArrayList;
	ArrayList<ModemVO> DetailInfo_Fail_ArrayList;
	
	
	Cursor cursor;
	DBHelper dbHelper;
	
	private String id, addresss, lastLinkTime, States;
	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		/*dbHelper = DBHelper.getInstance(this);
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		cursor = db.rawQuery(DBConfig.SELECT_STORAGE_MODEMLIST, null);
		cursor.moveToFirst();*/
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_info);

		Typeface typeFaceBody = Typeface.createFromAsset(getAssets(),"fonts/sangsang_font/SangSangBodyL.ttf");
		Typeface typeFaceHead = Typeface.createFromAsset(getAssets(),"fonts/sangsang_font/SangSangBodyM.ttf");

		// setting for action bar start
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(false);
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setDisplayShowTitleEnabled(false);
		LayoutInflater inflater = LayoutInflater.from(this);
		View customView = inflater.inflate(R.layout.custom_actionbar_detailinfo, null);
		TextView titleTV = (TextView) customView.findViewById(R.id.tv_Title);
		titleTV.setText("검침결과");
		titleTV.setTextColor(Color.WHITE);
		titleTV.setTypeface(typeFaceBody);
		//setting for action bar end
		
		actionBar.setCustomView(customView);
		actionBar.setDisplayShowCustomEnabled(true);
		
		cancelBtn = (ImageButton)customView.findViewById(R.id.btn_Cancel);
		cancelBtn.setOnClickListener(this);
		
		successBtn = (Button)findViewById(R.id.btn_detailInfo_Success);
		successBtn.setOnClickListener(this);
		successBtn.setTypeface(typeFaceBody);
		
		failBtn = (Button)findViewById(R.id.btn_detailInfo_Fail);
		failBtn.setOnClickListener(this);
		failBtn.setTypeface(typeFaceBody);
		
		modemId = (TextView)findViewById(R.id.tv_detailInfoActivity_modemIdValues);
		address = (TextView)findViewById(R.id.tv_detailInfoActivity_modemAddressValue);
		lastTime = (TextView)findViewById(R.id.tv_detailInfoActivity_LastTimeValue);
		state = (TextView)findViewById(R.id.tv_detailInfoActivity_stateValue);
		
		ll_Success = (LinearLayout)findViewById(R.id.ll_detailInfo_Success);
		ll_Fail = (LinearLayout)findViewById(R.id.ll_detailInfo_fail);
		
		//DetailInfo_LV  = (ListView)findViewById(R.id.lv_detailInfo);
		DetailInfo_Success_LV = (ListView)findViewById(R.id.lv_detailInfo_Success);
		DetailInfo_Fail_LV = (ListView)findViewById(R.id.lv_detailInfo_fail);
		
		//SuccessOrFailTV = (TextView)findViewById(R.id.tv_SuccessOrFail);
		//i.putExtra("serial_no", readModemStorageList.get(position).getmMeterSerialNo());
		//i.putExtra("meter_value", readModemStorageList.get(position).getmValue());
		
		Intent i = getIntent();
		 id = i.getStringExtra("serial_no");
		 addresss = i.getStringExtra("address");
		 lastLinkTime = i.getStringExtra("date");
		 States = i.getStringExtra("state");
		
		 modemId.setText(id);
		 address.setText(addresss);
		 lastTime.setText(lastLinkTime);
		 state.setText(States);
		 
		 Log.d("TEST", id +","+ addresss +","+ lastLinkTime + ","+state);
		
		// Initial Loading
		//DetailInfoArrayList = new ArrayList<ModemVO>();
		 DetailInfo_Success_ArrayList = new ArrayList<ModemVO>();
		 DetailInfo_Fail_ArrayList = new ArrayList<ModemVO>();
		 Log.i("Success lentg1", DetailInfo_Success_ArrayList.size() + "");
		// DB Setting
		dbHelper = DBHelper.getInstance(this);
		
		// Adapter Create
		//mDetailInfoAdapter = new DetailInfoAdapter(this,selectList());
		mDetailInfoSuccessAdapter = new ElecMeterAdapter(this,selectList_DetailInfoSuccess());
		Log.i("Success lentg2", DetailInfo_Success_ArrayList.size() + "");
		mDetailInfoFailAdapter = new ElecMeterAdapter(this,selectList_DetailInfoFail());
		
		Log.i("test", "test");
		//DetailInfo_LV.setAdapter(mDetailInfoAdapter);
		DetailInfo_Success_LV.setAdapter(mDetailInfoSuccessAdapter);
		DetailInfo_Fail_LV.setAdapter(mDetailInfoFailAdapter);
		
		
		//ListView Test
		/*ArrayAdapter<String> Adapter;
		String[] arrlist = {"11", "22", "33", "44"};
		Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrlist);
		DetailInfo_Success_LV.setAdapter(Adapter);*/
		
		//mDetailInfoAdapter.updateReadModelList(selectList());
		//mDetailInfoSuccessAdapter.update_DetailInfoSuccessList(selectList_DetailInfoSuccess());
		//mDetailInfoFailAdapter.update_DetailInfoFailList(selectList_DetailInfoFail());
		successBtn.setSelected(true);
		
		//SuccessOrFailTV.setText("성공목록");
		successBtn.setClickable(true);
		ll_Success.setVisibility(View.VISIBLE);
		ll_Fail.setVisibility(View.GONE);
	}
	
	// Modem Info 
	//Adapter input Data
	private ArrayList<ModemVO> selectList_DetailInfoSuccess() {
		// TODO Auto-generated method stub

		DetailInfo_Success_ArrayList.clear();
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		
		cursor = db.rawQuery("select *from modemlist_storage;" , null);
		cursor.moveToFirst();
		Log.i("cursorSize", cursor.getCount()+"");
		// List input DBdata
		for (int i = 0; i < cursor.getCount(); i++) {
			//String mModemId, String mMeterSerialNo, String mAddress,String mState, String mDate, String mValue, boolean mIsChecked
			DetailInfo_Success_ArrayList.add(new ModemVO(cursor.getString(1),cursor.getString(2),cursor.getString(4), cursor.getString(5)));
			Log.i("DetailInfo_Success_ArrayList", cursor.getString(1)+","+cursor.getInt(2)+","+cursor.getString(4)+","+cursor.getString(5));
			Log.i("DetailInfo_Success_ArrayList", DetailInfo_Success_ArrayList.size()+"");
			
			cursor.moveToNext();
		}
		cursor.close();
		return DetailInfo_Success_ArrayList;
		
	}
	private ArrayList<ModemVO> selectList_DetailInfoFail() {
		// TODO Auto-generated method stub

		DetailInfo_Fail_ArrayList.clear();
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		
		Calendar calender  = Calendar.getInstance();
		SimpleDateFormat dataformat = new SimpleDateFormat("yyyy-MM");
		String Month = dataformat.format(calender.getTime());
//		cursor = db.rawQuery("select * from modemlist where modem_date <  '" + Month + "' or modem_date = 'null' ;", null);
		cursor = db.rawQuery(DBConfig.DETAIL_FAIL, null);
		
		//cursor = db.rawQuery("select *from modemlist", null);
		cursor.moveToFirst();

		// List input DBdata
		for (int i = 0; i < cursor.getCount(); i++) {
			//String mModemId, String mMeterSerialNo, String mAddress,String mState, String mDate, String mValue, boolean mIsChecked
			DetailInfo_Fail_ArrayList.add(new ModemVO(cursor.getString(1),cursor.getString(2),cursor.getString(4), cursor.getString(5)));
			Log.i("DetailInfo_Fail_ArrayList", cursor.getString(1)+","+cursor.getInt(2)+","+cursor.getString(4)+","+cursor.getString(5));
			Log.i("DetailInfo_Fail_ArrayList", DetailInfo_Success_ArrayList.size()+"");
			cursor.moveToNext();
		}
		cursor.close();
		return DetailInfo_Fail_ArrayList;
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_Cancel:
			finish();
			break;
		case R.id.btn_detailInfo_Success:
			successBtn.setSelected(true);
			failBtn.setSelected(false);
			//SuccessOrFailTV.setText("성공목록");
			ll_Success.setVisibility(View.VISIBLE);
			ll_Fail.setVisibility(View.GONE);
			//mDetailInfoSuccessAdapter.update_DetailInfoSuccessList(selectList_DetailInfoSuccess());
			
			break;
		case R.id.btn_detailInfo_Fail:
			successBtn.setSelected(false);
			failBtn.setSelected(true);
			//SuccessOrFailTV.setText("실패목록");
			ll_Success.setVisibility(View.GONE);
			ll_Fail.setVisibility(View.VISIBLE);
			//mDetailInfoFailAdapter.update_DetailInfoFailList(selectList_DetailInfoFail());
			
			break;
		default:
			break;
		
		
		}
	}
}
