package com.nuriapp.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.nuriapp.activitiy.R;
import com.nuriapp.adapter.Adapter;
import com.nuriapp.data.Config;
import com.nuriapp.data.DBCursor;
import com.nuriapp.utils.DBHelper;

public class BuildingList extends Activity {
	private Button saveUserBuilding, cancelUserBuilding;
	private ListView buildingListView;
	private Adapter buildinglistAdapter = null;
	private DBHelper dbHelper;
	private Cursor cursor;
	private String buildingName;
	public static int selectedListItem = -1;
	public static Context context;

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		final AlertDialog.Builder alert = new AlertDialog.Builder(
				BuildingList.this);
		saveUserBuilding.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if (Config.getInstance().getBuildingID() == null) {
					alert.setPositiveButton("확인",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									dialog.dismiss();
								}
							});
					alert.setMessage("건물을 선택하십시오.");
					alert.show();
				} else {
					Config.sharedPreferences = getSharedPreferences(Config.StatesPref, MODE_PRIVATE);
					Config.editor = Config.sharedPreferences.edit();
					Config.editor.putString(Config.Building, Config.getInstance().getBuildingID());
					Config.editor.commit();
					Log.i(Config.sharedPreferences.getString(Config.Building, ""), "Config.sharedPreferences.getString(Config.Building,");
					Intent intent = new Intent(BuildingList.this,
							DetailInfo.class);
					startActivity(intent);
				}
			}
		});

		cancelUserBuilding.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				onBackPressed();
			}
		});
		
		buildingListView.setSelector(R.drawable.listitem_selector);

	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.buildinglist);
		
		ActionBar actionBar = getActionBar();
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.RED));
		actionBar.show();
		
		dbHelper = new DBHelper(this);
		buildinglistAdapter = new Adapter();

		SQLiteDatabase db = dbHelper.getReadableDatabase();
		cursor = db.rawQuery(DBCursor.SELECT_USER_BUILDING_LIST, null);
		cursor.moveToFirst();

		saveUserBuilding = (Button) findViewById(R.id.SaveUserBuilding);
		cancelUserBuilding = (Button) findViewById(R.id.CancelUserBuilding);
		buildingListView = (ListView) findViewById(R.id.BuildingLV);
		
		buildingListView.setAdapter(buildinglistAdapter);
		
		while (!cursor.isAfterLast()) {
			buildingName = cursor.getString(1);
			switch (buildingName) {
			case "ETRI 12":
				buildingName = "ETRI빌딩";
				break;
			case "NURI":
				buildingName = "누리빌딩";
				break;
			case "S물산":
				buildingName = "삼성물산";
				break;

			}
			buildinglistAdapter.add(buildingName);
			cursor.moveToNext();
		}
		buildingListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
//				Object pickedItem = buildingListView.getItemAtPosition(position);
				
			}
		});
		
		context = this;

	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int itemId = item.getItemId();
		if (itemId == R.id.action_home) {
			Intent intent = new Intent(this, MainActivity.class);
			Config.sharedPreferences = getSharedPreferences(Config.StatesPref, MODE_PRIVATE);
			Config.editor = Config.sharedPreferences.edit();
			Config.editor.putString(Config.Id, MainActivity.userId);
			MainActivity.loginTextView.setText("사용자 : "+ MainActivity.loginId.getText());
			Config.editor.commit();
			startActivity(intent);
			return true;
		}
		if (itemId == R.id.action_settingicon) {
			Intent intent = new Intent(this, Settings.class);
			startActivity(intent);
			return true;
		}
		return (super.onOptionsItemSelected(item));
	}

}
