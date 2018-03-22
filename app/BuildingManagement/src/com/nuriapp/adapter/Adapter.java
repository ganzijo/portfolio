package com.nuriapp.adapter;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nuriapp.activitiy.R;
import com.nuriapp.activity.BuildingList;
import com.nuriapp.data.Config;

public class Adapter extends BaseAdapter {
	private ArrayList<String> interestBuildingList = new ArrayList<String>();
	private TextView textview = null;
	private RelativeLayout relativeLayout = null;
	private AlertDialog.Builder alert;
	

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return interestBuildingList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return interestBuildingList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final int pos = position;
		final Context context = parent.getContext();
		alert = new AlertDialog.Builder(BuildingList.context);
		
		CustomHolder holder = null;

		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.buildinglistitem, parent,
					false);
			relativeLayout = (RelativeLayout) convertView
					.findViewById(R.id.ListLayout);
			relativeLayout.setClickable(true);
			textview = (TextView) convertView
					.findViewById(R.id.SelectUserBuildingTextView);
			textview.setText(interestBuildingList.get(pos));
			textview.setTextSize(30);

			holder = new CustomHolder();
			holder.selectUserBuildingtextview = textview;
			convertView.setTag(holder);
		} else {

			holder = (CustomHolder) convertView.getTag();
			textview = holder.selectUserBuildingtextview;
		}

		// 리스트 아이템을 터치 했을 때 이벤트 발생
		convertView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				v.setBackgroundResource(R.drawable.listitem_selector);
				// 터치 시 해당 아이템 이름 출력
				Toast.makeText(
						context,
						interestBuildingList.get(pos).toString()
								+ "이/가 선택되었습니다.", Toast.LENGTH_LONG).show();
				if (interestBuildingList.get(pos).equals("ETRI빌딩")) {
					Config.getInstance().setBuildingID("1");
				} else if (interestBuildingList.get(pos).equals("누리빌딩")) {
					Config.getInstance().setBuildingID("2");
				} else if (interestBuildingList.get(pos).equals("삼성물산")) {
					Config.getInstance().setBuildingID("3");
				}
				

				alert.setPositiveButton("취소",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								
								dialog.cancel();
							}
						});
				alert.setNegativeButton("확인", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
						
						dialog.dismiss();
					}
				});
				alert.setTitle("관심빌딩군 선택 확인");
				alert.setMessage(interestBuildingList.get(pos).toString()
						+ "이/가 선택되었습니다.");
				alert.setCancelable(false);
				
				alert.show();
			}
		});

		return convertView;
	}

	private class CustomHolder {
		TextView selectUserBuildingtextview;

	}

	public void add(String msg) {
		interestBuildingList.add(msg);
	}

	public void remove(int position) {
		interestBuildingList.remove(position);
	}

}
