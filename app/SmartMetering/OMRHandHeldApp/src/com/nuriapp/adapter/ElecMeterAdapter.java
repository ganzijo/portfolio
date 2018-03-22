package com.nuriapp.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.nuriapp.database.DBConfig;
import com.nuriapp.database.DBHelper;
import com.nuriapp.omrhandheldapp.R;
import com.nuriapp.vo.ModemVO;

public class ElecMeterAdapter extends BaseAdapter {

	final private Context context;
	private ArrayList<ModemVO> eleMeterList;
	
	// 생성자의 인자로 넘어온 리스트객체(ArrayList items)를 MeterCollectAdapter내부의 리스트객체와 연결
	public ElecMeterAdapter(Context context, ArrayList<ModemVO> list) {
		super();
		this.context = context;
		this.eleMeterList = list;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		CustomHolder customHolder = null;

		
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.elecmeter_list_item,null);
			
			customHolder = new CustomHolder();
			customHolder.mCustomId = (TextView) convertView.findViewById(R.id.tv_elecMeterSerialValue);
			customHolder.melecMeterAddressValues = (TextView)convertView.findViewById(R.id.tv_elecMeterAddressValues);
			customHolder.melecMeterFinalReadDateValues = (TextView)convertView.findViewById(R.id.tv_elecMeterFinalReadDateValues);
			customHolder.melecMeterValueValues = (TextView)convertView.findViewById(R.id.tv_elecMeterValueValues);
			
			convertView.setTag(customHolder); 

		} else {
			customHolder = (CustomHolder) convertView.getTag();
		}
	
	
		customHolder.mCustomId.setText(eleMeterList.get(position).getMeterSerialNo());
		customHolder.melecMeterAddressValues.setText(eleMeterList.get(position).getAddress());
		customHolder.melecMeterFinalReadDateValues.setText(eleMeterList.get(position).getDate());
		customHolder.melecMeterValueValues.setText(eleMeterList.get(position).getValue());
	

		customHolder.mCustomId.setTag(eleMeterList.get(position));
		customHolder.melecMeterAddressValues.setTag(eleMeterList.get(position));
		customHolder.melecMeterFinalReadDateValues.setTag(eleMeterList.get(position));
		customHolder.melecMeterValueValues.setTag(eleMeterList.get(position));
		return convertView;
	}

	private  class CustomHolder {
		TextView mCustomId;
		TextView melecMeterAddressValues;
		TextView melecMeterFinalReadDateValues;
		TextView melecMeterValueValues;
	}
	
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return eleMeterList.size();
	}

	public void updateElecMeterlList(ArrayList<ModemVO> selectList) {
		// TODO Auto-generated method stub
		eleMeterList = selectList;
		this.notifyDataSetChanged(); //getview호출
	}
	
	

}
