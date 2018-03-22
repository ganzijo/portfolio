package com.nuriapp.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.nuriapp.omrhandheldapp.DetailInfo;
import com.nuriapp.omrhandheldapp.R;
import com.nuriapp.vo.ModemStorageVO;
import com.nuriapp.vo.ModemVO;

public class ModemStorageAdapter extends BaseAdapter{
	
	
	final private Context context;
	private ArrayList<ModemStorageVO> readModemStorageList;
	
	//생성자의 인자로 넘어온 리스트객체(ArrayList items)를 ReadModemStorageVO내부의 리스트객체와 연결
	public ModemStorageAdapter(Context context, ArrayList<ModemStorageVO> list) {
		super();
		this.context = context;
		this.readModemStorageList = list;
	
	}

	// CheckBox를 모두 선택하는 메서드
	public void setAllChecked(boolean ischeked) {
			int tempSize = this.getCount() ;
			for(int i = 0 ; i < tempSize ; i++){
				
				ModemStorageVO vo = (ModemStorageVO)this.getItem(i);
				vo.setChecked(ischeked);
			}
		}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		ReadStorageCustomHolder customHolder = null;

		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.readmodem_storage_list_item,null);
			
			customHolder = new ReadStorageCustomHolder();
			
			customHolder.mModemId = (TextView)convertView.findViewById(R.id.tv_readModemStorage_modemIdValue);
			customHolder.mAddress = (TextView)convertView.findViewById(R.id.tv_readModemStorage_modemAddressValue);
			customHolder.mLastLinkTime = (TextView) convertView.findViewById(R.id.tv_readModemStorage_lastLinkTimeValue);
			customHolder.mStatesValue = (TextView)convertView.findViewById(R.id.tv_readModemStorage_statesValue);
			customHolder.mAllCheck = (CheckBox)convertView.findViewById(R.id.ck_AllCollect);
			customHolder.mInformation = (Button)convertView.findViewById(R.id.btn_readModemStorage_Infromation);
			customHolder.mInformation.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					 Log.i("tEST", "label click position=" + position);
					 
					 Intent i = new Intent(context, DetailInfo.class);
					 i.putExtra("serial_no", readModemStorageList.get(position).getMeterSerialNo());
					 i.putExtra("address", readModemStorageList.get(position).getAddress());
					 i.putExtra("date", readModemStorageList.get(position).getCollectDate());
					 i.putExtra("state", readModemStorageList.get(position).getState());
					 context.startActivity(i);
				}
			});
			customHolder.mCheck = (CheckBox)convertView.findViewById(R.id.ck_readModemStorage_collect);
			customHolder.mCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    int getPosition = (Integer) buttonView.getTag();  // Here we get the position that we have set for the checkbox using setTag.
                    readModemStorageList.get(getPosition).setChecked(buttonView.isChecked());// Set the value of checkbox to maintain its state.
                }
            });
			convertView.setTag(customHolder); 


		} else {
			customHolder = (ReadStorageCustomHolder) convertView.getTag();
		}
	
		customHolder.mCheck.setTag(position);
		
		customHolder.mModemId.setText(readModemStorageList.get(position).getModemId());
		customHolder.mAddress.setText(readModemStorageList.get(position).getAddress());
		customHolder.mStatesValue.setText(readModemStorageList.get(position).getState());
		customHolder.mLastLinkTime.setText(readModemStorageList.get(position)./*getDate*/getCollectDate());
		
		
		customHolder.mLastLinkTime.setTag(readModemStorageList.get(position));
		customHolder.mStatesValue.setTag(readModemStorageList.get(position));
		customHolder.mModemId.setTag(readModemStorageList.get(position));
		customHolder.mAddress.setTag(readModemStorageList.get(position));
		
		// isCheckedConfrim
		
		customHolder.mCheck.setChecked(readModemStorageList.get(position).isChecked()); 
	
		
		return convertView;
	}

	private  class ReadStorageCustomHolder {
		TextView mLastLinkTime;
		TextView mStatesValue;
		TextView mModemId;
		TextView mAddress;
		CheckBox mCheck;
		CheckBox mAllCheck;
		Button mInformation;
	}
	
	public void updateReadModelList(ArrayList<ModemStorageVO> _readModemList) {
		// TODO Auto-generated method stub
		readModemStorageList = _readModemList;
		this.notifyDataSetChanged(); //getview호출
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return readModemStorageList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return readModemStorageList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}


	
}
