package com.nuriapp.vo_dontuse;
/*package com.nuriapp.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.nuriapp.omrhandheldapp.R;
import com.nuriapp.vo.ModemVO;

public class DetailInfoAdapter extends BaseAdapter{
	
	private Context context;
	private ArrayList<ModemVO> modemList;

	//생성자의 인자로 넘어온 리스트객체(ArrayList items)를 DetailInfoVO내부의 리스트객체와 연결
	public DetailInfoAdapter(Context context, ArrayList<ModemVO> arrayList) {
		super();
		this.context = context;
		this.modemList = arrayList;
	
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return modemList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return modemList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		DetailInfoCustomHolder customHolder = null;
		

		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.detailinfo_list_item,null);
			customHolder = new DetailInfoCustomHolder();
			customHolder.mModemId = (TextView)convertView.findViewById(R.id.tv_DetailInfo_modemIdValues);
			convertView.setTag(customHolder); 

		} else {
			customHolder = (DetailInfoCustomHolder) convertView.getTag();
		}
	
		
		customHolder.mModemId.setText(modemList.get(position).getState());
		customHolder.mModemId.setTag(modemList.get(position));
	
		
		return convertView;
		
		
	}
	public void updateReadModelList(ArrayList<ModemVO> _detailInfoList) {
		// TODO Auto-generated method stub
		modemList = _detailInfoList;
		this.notifyDataSetChanged(); //getview호출
	}
	public void add(ArrayList<ModemVO> list) {
		// TODO Auto-generated method stub

	}
}
*/