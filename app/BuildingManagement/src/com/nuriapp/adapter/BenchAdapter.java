package com.nuriapp.adapter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnScrollListener;
import android.widget.TextView;

import com.nuriapp.activitiy.R;
import com.nuriapp.data.BenchData;

public class BenchAdapter extends BaseAdapter implements OnScrollListener {

	private List<BenchData> benchList = new ArrayList<BenchData>();
	
	public static Context con;

	@Override
	public int getCount() {
		return benchList.size();
	}

	@Override
	public Object getItem(int position) {
		return benchList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final Context context = parent.getContext();

		CustomHolder holder = null;

		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.benchitem, parent, false);
			holder = new CustomHolder();
			holder.hBuildingNameTV = (TextView) convertView
					.findViewById(R.id.BuildingNameTV);
			holder.hUsingAmountTV = (TextView) convertView
					.findViewById(R.id.UsingAmountTV);
			holder.hAddressTV = (TextView) convertView
					.findViewById(R.id.AddressTV);
			holder.hAreaTV = (TextView) convertView.findViewById(R.id.AreaTV);

			convertView.setTag(holder); // 뷰는 setTag로 Object타입의 인스턴스를 저장할 수 있음
										// ViewHolder 패턴을 구성하는 핵심원리

		} else {

			holder = (CustomHolder) convertView.getTag(); // setTag로 넣어두었던
															// ViewHolder 인스턴스를
															// 가져온다.
		}

		holder.hUsingAmountTV.setText(benchList.get(position).getUsingAmount());
		holder.hAreaTV.setText(benchList.get(position).getArea());

		String buildingNameTV = benchList.get(position).getBuildingName();
		if (StringUtils.equals(buildingNameTV, "-")) {
			holder.hBuildingNameTV.setGravity(Gravity.CENTER);
		}
		holder.hBuildingNameTV.setText(buildingNameTV);

		String addressTV = benchList.get(position).getAddress();
		if (StringUtils.equals(addressTV, "-")) {
			holder.hAddressTV.setGravity(Gravity.CENTER);
		}
		holder.hAddressTV.setText(addressTV);

		return convertView;
	}

	private static class CustomHolder {
		private TextView hBuildingNameTV;
		private TextView hUsingAmountTV;
		private TextView hAddressTV;
		private TextView hAreaTV;
	}

	public void add(BenchData data) {
		benchList.add(data);
	}

	public void remove(int _position) {
		benchList.remove(_position);

	}

	@Override
	public void onScrollStateChange(NumberPicker view, int scrollState) {
	}

}
