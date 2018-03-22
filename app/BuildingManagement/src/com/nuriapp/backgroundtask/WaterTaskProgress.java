package com.nuriapp.backgroundtask;

import android.app.ProgressDialog;
import android.database.Cursor;
import android.os.AsyncTask;
import android.widget.ListView;

import com.nuriapp.activitiy.R;
import com.nuriapp.activity.DetailInfo;
import com.nuriapp.activity.DetailWater;
import com.nuriapp.adapter.BenchAdapter;
import com.nuriapp.data.BenchData;

public class WaterTaskProgress extends AsyncTask<Cursor, Void, BenchAdapter> {

	private ProgressDialog dialog;

	@Override
	protected void onPreExecute() {
		dialog = new ProgressDialog(DetailInfo.con);
		dialog.setTitle("데이터 로딩중");
		dialog.setMessage("잠시만 기다리세요...");
		dialog.setIndeterminate(true);
		dialog.setCancelable(false);
		dialog.show();
		super.onPreExecute();
	}

	@Override
	protected void onPostExecute(BenchAdapter result) {
		
		ListView benchListView = (ListView) DetailWater.context
				.findViewById(R.id.WaterBenchList);
		benchListView.setAdapter(result);
		dialog.dismiss();
		super.onPostExecute(result);
	}

	@Override
	protected BenchAdapter doInBackground(Cursor... params) {
		BenchAdapter benchAdapter = new BenchAdapter();
		for (Cursor cursor : params) {
			cursor.moveToFirst();
			try {
				if (cursor.getCount() > 0) {
					for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor
							.moveToNext()) {

						benchAdapter.add(new BenchData(cursor.getString(0),
								cursor.getString(1), cursor.getString(2),
								cursor.getString(3)));
					}
				} else {
					benchAdapter.add(BenchData.empty());
				}
			} finally {
				cursor.close();
			}
		}
		return benchAdapter;
	}

}
