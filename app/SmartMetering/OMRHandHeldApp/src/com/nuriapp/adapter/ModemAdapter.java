package com.nuriapp.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.nuriapp.omrhandheldapp.R;
import com.nuriapp.omrhandheldapp.ReadListFragment;
import com.nuriapp.vo.ModemVO;
public class ModemAdapter extends BaseAdapter {
	
	
	final private Context context;
	private ArrayList<ModemVO> readModemList;

	
	
	//생성자의 인자로 넘어온 리스트객체(ArrayList items)를 MeterCollectAdapter내부의 리스트객체와 연결
	public ModemAdapter(Context context, ArrayList<ModemVO> list) {
		super();
		this.context = context;
		this.readModemList = list;
	}
	
	// CheckBox를 모두 선택하는 메서드
	public void setAllChecked(boolean ischeked) {
				int tempSize = this.getCount() ;
				for(int i = 0 ; i < tempSize ; i++){
					ModemVO vo = (ModemVO)this.getItem(i);
					vo.setChecked(ischeked);
				}
			}
			
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		CustomHolder customHolder = null;

		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.readmodem_list_item,null);
			
			customHolder = new CustomHolder();
			customHolder.mModemidValue = (TextView) convertView.findViewById(R.id.tv_modemIdValues);

			customHolder.mAddress = (TextView)convertView.findViewById(R.id.tv_modemAddress);
			customHolder.mAddressValue = (TextView)convertView.findViewById(R.id.tv_modemAddressValues);

			customHolder.mLastLinkTime = (TextView) convertView.findViewById(R.id.tv_modemFinalReadDate);
			customHolder.mLastLinkTimeValue = (TextView) convertView.findViewById(R.id.tv_modemFinalReadDateValues);
			
			customHolder.mModemStates = (TextView)convertView.findViewById(R.id.tv_modemStates);
			customHolder.mModemStatesValue = (TextView)convertView.findViewById(R.id.tv_modemStatesValues);

			customHolder.mReadModemList_Allcheck = (CheckBox)convertView.findViewById(R.id.ck_ReadModem_AllCollect);
			
			customHolder.mCheck = (CheckBox)convertView.findViewById(R.id.ck_collect);
			customHolder.mCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    int getPosition = (Integer) buttonView.getTag();  // Here we get the position that we have set for the checkbox using setTag.
                    readModemList.get(getPosition).setChecked(buttonView.isChecked());// Set the value of checkbox to maintain its state.
                 
                }
            });
			convertView.setTag(customHolder); 


		} else {
			customHolder = (CustomHolder) convertView.getTag();
		}
		
		customHolder.mCheck.setTag(position);
		customHolder.mModemidValue.setText(readModemList.get(position).getModemId());
		customHolder.mAddressValue.setText(readModemList.get(position).getAddress());
		customHolder.mLastLinkTimeValue.setText(readModemList.get(position).getDate());
		customHolder.mModemStatesValue.setText(readModemList.get(position).getState());
	
		if(ReadListFragment.cur_ListState == ReadListFragment.LIST_STATE_DEF){ // 초기화면 or ScanBtn눌렀을 때 서버에서 얻어오는 데이터가 없음
			customHolder.mCheck.setVisibility(View.GONE);
			customHolder.mModemStates.setVisibility(View.GONE);
			customHolder.mModemStatesValue.setVisibility(View.GONE);			
		}else if(ReadListFragment.cur_ListState == ReadListFragment.LIST_STATE_SCAN){ //ScanBtn 클릭시 상태 (통신가능 , 불가능 )
			customHolder.mCheck.setVisibility(View.VISIBLE);
			customHolder.mModemStates.setVisibility(View.VISIBLE);
			customHolder.mModemStatesValue.setVisibility(View.VISIBLE);
		}else if(ReadListFragment.cur_ListState == ReadListFragment.LIST_STATE_COLLECT ){ //CollectBtn 클릭시 상태(20개중 15개 통신가능)
			customHolder.mCheck.setVisibility(View.VISIBLE);
			customHolder.mModemStates.setVisibility(View.VISIBLE);
			customHolder.mModemStatesValue.setVisibility(View.VISIBLE);
		}else if(ReadListFragment.cur_ListState == ReadListFragment.LIST_STATE_RE_SCAN ){ //CollectBtn 클릭시 상태(20개중 15개 통신가능)
			customHolder.mCheck.setVisibility(View.GONE);
//			if(customHolder.mModemStates.)
		}
		
		customHolder.mModemidValue.setTag(readModemList.get(position));
		customHolder.mAddressValue.setTag(readModemList.get(position));
		customHolder.mLastLinkTimeValue.setTag(readModemList.get(position));
		customHolder.mModemStatesValue.setTag(readModemList.get(position));
		Log.i("isChecked2!!",readModemList.get(position).isChecked() +"");
		customHolder.mCheck.setChecked(readModemList.get(position).isChecked());
		return convertView;
	}

	private  class CustomHolder {
		TextView mModemStates;
		TextView mModemStatesValue;
		TextView mModemidValue;
		TextView mLastLinkTime;
		TextView mLastLinkTimeValue;
		TextView mAddress;
		TextView mAddressValue;
		CheckBox mCheck;
		CheckBox mReadModemList_Allcheck;
	}
	public void add(ArrayList<ModemVO> list) {
		// TODO Auto-generated method stub

	}
	public void updateReadModelList(ArrayList<ModemVO> _readModemList) {
		// TODO Auto-generated method stub
		readModemList = _readModemList;
		this.notifyDataSetChanged(); //getview호출
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return readModemList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return readModemList.get(position);
	}
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}



}
