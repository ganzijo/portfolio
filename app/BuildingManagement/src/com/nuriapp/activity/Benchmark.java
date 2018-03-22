package com.nuriapp.activity;

import java.text.DecimalFormat;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.nuriapp.activitiy.R;
import com.nuriapp.data.Config;
import com.nuriapp.data.DBCursor;
import com.nuriapp.data.Search;
import com.nuriapp.utils.DBHelper;
import com.nuriapp.utils.ToggleButtonGroupTableLayout;

public class Benchmark extends Activity {

	private CheckBox buildingTypeCheckBox, buildingApplicationCheckBox,
			addressCheckBox, siCheckBox, guCheckBox, dongCheckBox,
			areaCheckBox;
	private EditText areaMinValueEditText, areaMaxValueEditText;
	private RadioButton buildingUse1, buildingUse2, buildingUse3, buildingUse4,
			buildingUse5, buildingUse6, buildingUse7, buildingUse8,
			buildingUse9, buildingUse10, buildingUse11, buildingUse12,
			buildingUse13, buildingUse14, buildingUse15, buildingUse16,
			buildingUse17, buildingUse18, buildingSetRadioBtn,
			generalBuildingRadioBtn;
	private ToggleButtonGroupTableLayout toggleButtonGroupTableLayout;
	private Button resetBtn, saveBtn, cancelBtn;
	private Config config;
	private TextView currentBuildingAreaTextView, minmaxAreaTextView;
	private DecimalFormat decimalFormat = new DecimalFormat(
			"###,###,###,###.###");
	private Boolean resetState = false;

	@Override
	protected void onResume() {
		super.onResume();
		generalBuildingRadioBtn
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						if (generalBuildingRadioBtn.isChecked()) {
							buildingSetRadioBtn.setChecked(false);
						}
					}
				});
		// toggleButtonGroupTableLayout.activeRadioButton.set

		buildingUse1.setChecked(config.sharedPreferences.getBoolean(
				config.RadioBtnState1, true));
		buildingUse1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (buildingUse1.isChecked()) {
					buildingUse2.setChecked(false);
					buildingUse3.setChecked(false);
					buildingUse4.setChecked(false);
					buildingUse5.setChecked(false);
					buildingUse6.setChecked(false);
					buildingUse7.setChecked(false);
					buildingUse8.setChecked(false);
					buildingUse9.setChecked(false);
					buildingUse10.setChecked(false);
					buildingUse11.setChecked(false);
					buildingUse12.setChecked(false);
					buildingUse13.setChecked(false);
					buildingUse14.setChecked(false);
					buildingUse15.setChecked(false);
					buildingUse16.setChecked(false);
					buildingUse17.setChecked(false);
					buildingUse18.setChecked(false);
				}

			}
		});
		buildingUse2.setChecked(config.sharedPreferences.getBoolean(
				config.RadioBtnState2, false));
		buildingUse2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (buildingUse2.isChecked()) {
					buildingUse1.setChecked(false);
					buildingUse3.setChecked(false);
					buildingUse4.setChecked(false);
					buildingUse5.setChecked(false);
					buildingUse6.setChecked(false);
					buildingUse7.setChecked(false);
					buildingUse8.setChecked(false);
					buildingUse9.setChecked(false);
					buildingUse10.setChecked(false);
					buildingUse11.setChecked(false);
					buildingUse12.setChecked(false);
					buildingUse13.setChecked(false);
					buildingUse14.setChecked(false);
					buildingUse15.setChecked(false);
					buildingUse16.setChecked(false);
					buildingUse17.setChecked(false);
					buildingUse18.setChecked(false);
				}
			}
		});
		buildingUse3.setChecked(config.sharedPreferences.getBoolean(
				config.RadioBtnState3, false));
		buildingUse3.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (buildingUse3.isChecked()) {
					buildingUse1.setChecked(false);
					buildingUse2.setChecked(false);
					buildingUse4.setChecked(false);
					buildingUse5.setChecked(false);
					buildingUse6.setChecked(false);
					buildingUse7.setChecked(false);
					buildingUse8.setChecked(false);
					buildingUse9.setChecked(false);
					buildingUse10.setChecked(false);
					buildingUse11.setChecked(false);
					buildingUse12.setChecked(false);
					buildingUse13.setChecked(false);
					buildingUse14.setChecked(false);
					buildingUse15.setChecked(false);
					buildingUse16.setChecked(false);
					buildingUse17.setChecked(false);
					buildingUse18.setChecked(false);
				}
			}
		});
		buildingUse4.setChecked(config.sharedPreferences.getBoolean(
				config.RadioBtnState4, false));
		buildingUse4.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (buildingUse4.isChecked()) {
					buildingUse1.setChecked(false);
					buildingUse2.setChecked(false);
					buildingUse3.setChecked(false);
					buildingUse5.setChecked(false);
					buildingUse6.setChecked(false);
					buildingUse7.setChecked(false);
					buildingUse8.setChecked(false);
					buildingUse9.setChecked(false);
					buildingUse10.setChecked(false);
					buildingUse11.setChecked(false);
					buildingUse12.setChecked(false);
					buildingUse13.setChecked(false);
					buildingUse14.setChecked(false);
					buildingUse15.setChecked(false);
					buildingUse16.setChecked(false);
					buildingUse17.setChecked(false);
					buildingUse18.setChecked(false);
				}
			}
		});
		buildingUse5.setChecked(config.sharedPreferences.getBoolean(
				config.RadioBtnState5, false));
		buildingUse5.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (buildingUse5.isChecked()) {
					buildingUse1.setChecked(false);
					buildingUse2.setChecked(false);
					buildingUse3.setChecked(false);
					buildingUse4.setChecked(false);
					buildingUse6.setChecked(false);
					buildingUse7.setChecked(false);
					buildingUse8.setChecked(false);
					buildingUse9.setChecked(false);
					buildingUse10.setChecked(false);
					buildingUse11.setChecked(false);
					buildingUse12.setChecked(false);
					buildingUse13.setChecked(false);
					buildingUse14.setChecked(false);
					buildingUse15.setChecked(false);
					buildingUse16.setChecked(false);
					buildingUse17.setChecked(false);
					buildingUse18.setChecked(false);
				}

			}
		});
		buildingUse6.setChecked(config.sharedPreferences.getBoolean(
				config.RadioBtnState6, false));
		buildingUse6.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (buildingUse6.isChecked()) {
					buildingUse1.setChecked(false);
					buildingUse2.setChecked(false);
					buildingUse3.setChecked(false);
					buildingUse4.setChecked(false);
					buildingUse5.setChecked(false);
					buildingUse7.setChecked(false);
					buildingUse8.setChecked(false);
					buildingUse9.setChecked(false);
					buildingUse10.setChecked(false);
					buildingUse11.setChecked(false);
					buildingUse12.setChecked(false);
					buildingUse13.setChecked(false);
					buildingUse14.setChecked(false);
					buildingUse15.setChecked(false);
					buildingUse16.setChecked(false);
					buildingUse17.setChecked(false);
					buildingUse18.setChecked(false);
				}

			}
		});
		buildingUse7.setChecked(config.sharedPreferences.getBoolean(
				config.RadioBtnState7, false));
		buildingUse7.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (buildingUse7.isChecked()) {
					buildingUse1.setChecked(false);
					buildingUse2.setChecked(false);
					buildingUse3.setChecked(false);
					buildingUse4.setChecked(false);
					buildingUse5.setChecked(false);
					buildingUse6.setChecked(false);
					buildingUse8.setChecked(false);
					buildingUse9.setChecked(false);
					buildingUse10.setChecked(false);
					buildingUse11.setChecked(false);
					buildingUse12.setChecked(false);
					buildingUse13.setChecked(false);
					buildingUse14.setChecked(false);
					buildingUse15.setChecked(false);
					buildingUse16.setChecked(false);
					buildingUse17.setChecked(false);
					buildingUse18.setChecked(false);
				}

			}
		});
		buildingUse8.setChecked(config.sharedPreferences.getBoolean(
				config.RadioBtnState8, false));
		buildingUse8.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (buildingUse8.isChecked()) {
					buildingUse1.setChecked(false);
					buildingUse2.setChecked(false);
					buildingUse3.setChecked(false);
					buildingUse4.setChecked(false);
					buildingUse5.setChecked(false);
					buildingUse6.setChecked(false);
					buildingUse7.setChecked(false);
					buildingUse9.setChecked(false);
					buildingUse10.setChecked(false);
					buildingUse11.setChecked(false);
					buildingUse12.setChecked(false);
					buildingUse13.setChecked(false);
					buildingUse14.setChecked(false);
					buildingUse15.setChecked(false);
					buildingUse16.setChecked(false);
					buildingUse17.setChecked(false);
					buildingUse18.setChecked(false);
				}


			}
		});
		buildingUse9.setChecked(config.sharedPreferences.getBoolean(
				config.RadioBtnState9, false));
		buildingUse9.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (buildingUse9.isChecked()) {
					buildingUse1.setChecked(false);
					buildingUse2.setChecked(false);
					buildingUse3.setChecked(false);
					buildingUse4.setChecked(false);
					buildingUse5.setChecked(false);
					buildingUse6.setChecked(false);
					buildingUse7.setChecked(false);
					buildingUse8.setChecked(false);
					buildingUse10.setChecked(false);
					buildingUse11.setChecked(false);
					buildingUse12.setChecked(false);
					buildingUse13.setChecked(false);
					buildingUse14.setChecked(false);
					buildingUse15.setChecked(false);
					buildingUse16.setChecked(false);
					buildingUse17.setChecked(false);
					buildingUse18.setChecked(false);
				}

			}
		});
		buildingUse10.setChecked(config.sharedPreferences.getBoolean(
				config.RadioBtnState10, false));
		buildingUse10.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (buildingUse10.isChecked()) {
					buildingUse1.setChecked(false);
					buildingUse2.setChecked(false);
					buildingUse3.setChecked(false);
					buildingUse4.setChecked(false);
					buildingUse5.setChecked(false);
					buildingUse6.setChecked(false);
					buildingUse7.setChecked(false);
					buildingUse8.setChecked(false);
					buildingUse9.setChecked(false);
					buildingUse11.setChecked(false);
					buildingUse12.setChecked(false);
					buildingUse13.setChecked(false);
					buildingUse14.setChecked(false);
					buildingUse15.setChecked(false);
					buildingUse16.setChecked(false);
					buildingUse17.setChecked(false);
					buildingUse18.setChecked(false);
				}

			}
		});
		buildingUse11.setChecked(config.sharedPreferences.getBoolean(
				config.RadioBtnState11, false));
		buildingUse11.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (buildingUse11.isChecked()) {
					buildingUse1.setChecked(false);
					buildingUse2.setChecked(false);
					buildingUse3.setChecked(false);
					buildingUse4.setChecked(false);
					buildingUse5.setChecked(false);
					buildingUse6.setChecked(false);
					buildingUse7.setChecked(false);
					buildingUse8.setChecked(false);
					buildingUse9.setChecked(false);
					buildingUse10.setChecked(false);
					buildingUse12.setChecked(false);
					buildingUse13.setChecked(false);
					buildingUse14.setChecked(false);
					buildingUse15.setChecked(false);
					buildingUse16.setChecked(false);
					buildingUse17.setChecked(false);
					buildingUse18.setChecked(false);
				}
			}
		});
		buildingUse12.setChecked(config.sharedPreferences.getBoolean(
				config.RadioBtnState12, false));
		buildingUse12.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (buildingUse12.isChecked()) {
					buildingUse1.setChecked(false);
					buildingUse2.setChecked(false);
					buildingUse3.setChecked(false);
					buildingUse4.setChecked(false);
					buildingUse5.setChecked(false);
					buildingUse6.setChecked(false);
					buildingUse7.setChecked(false);
					buildingUse8.setChecked(false);
					buildingUse9.setChecked(false);
					buildingUse10.setChecked(false);
					buildingUse11.setChecked(false);
					buildingUse13.setChecked(false);
					buildingUse14.setChecked(false);
					buildingUse15.setChecked(false);
					buildingUse16.setChecked(false);
					buildingUse17.setChecked(false);
					buildingUse18.setChecked(false);
				}
			}
		});
		buildingUse13.setChecked(config.sharedPreferences.getBoolean(
				config.RadioBtnState13, false));
		buildingUse13.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (buildingUse13.isChecked()) {
					buildingUse1.setChecked(false);
					buildingUse2.setChecked(false);
					buildingUse3.setChecked(false);
					buildingUse4.setChecked(false);
					buildingUse5.setChecked(false);
					buildingUse6.setChecked(false);
					buildingUse7.setChecked(false);
					buildingUse8.setChecked(false);
					buildingUse9.setChecked(false);
					buildingUse10.setChecked(false);
					buildingUse11.setChecked(false);
					buildingUse12.setChecked(false);
					buildingUse14.setChecked(false);
					buildingUse15.setChecked(false);
					buildingUse16.setChecked(false);
					buildingUse17.setChecked(false);
					buildingUse18.setChecked(false);
				}
			}
		});
		buildingUse14.setChecked(config.sharedPreferences.getBoolean(
				config.RadioBtnState14, false));
		buildingUse14.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (buildingUse14.isChecked()) {
					buildingUse1.setChecked(false);
					buildingUse2.setChecked(false);
					buildingUse3.setChecked(false);
					buildingUse4.setChecked(false);
					buildingUse5.setChecked(false);
					buildingUse6.setChecked(false);
					buildingUse7.setChecked(false);
					buildingUse8.setChecked(false);
					buildingUse9.setChecked(false);
					buildingUse10.setChecked(false);
					buildingUse11.setChecked(false);
					buildingUse12.setChecked(false);
					buildingUse13.setChecked(false);
					buildingUse15.setChecked(false);
					buildingUse16.setChecked(false);
					buildingUse17.setChecked(false);
					buildingUse18.setChecked(false);
				}
			}
		});
		buildingUse15.setChecked(config.sharedPreferences.getBoolean(
				config.RadioBtnState15, false));
		buildingUse15.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (buildingUse15.isChecked()) {
					buildingUse1.setChecked(false);
					buildingUse2.setChecked(false);
					buildingUse3.setChecked(false);
					buildingUse4.setChecked(false);
					buildingUse5.setChecked(false);
					buildingUse6.setChecked(false);
					buildingUse7.setChecked(false);
					buildingUse8.setChecked(false);
					buildingUse9.setChecked(false);
					buildingUse10.setChecked(false);
					buildingUse11.setChecked(false);
					buildingUse12.setChecked(false);
					buildingUse13.setChecked(false);
					buildingUse14.setChecked(false);
					buildingUse16.setChecked(false);
					buildingUse17.setChecked(false);
					buildingUse18.setChecked(false);
				}
			}
		});
		buildingUse16.setChecked(config.sharedPreferences.getBoolean(
				config.RadioBtnState16, false));
		buildingUse16.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (buildingUse16.isChecked()) {
					buildingUse1.setChecked(false);
					buildingUse2.setChecked(false);
					buildingUse3.setChecked(false);
					buildingUse4.setChecked(false);
					buildingUse5.setChecked(false);
					buildingUse6.setChecked(false);
					buildingUse7.setChecked(false);
					buildingUse8.setChecked(false);
					buildingUse9.setChecked(false);
					buildingUse10.setChecked(false);
					buildingUse11.setChecked(false);
					buildingUse12.setChecked(false);
					buildingUse13.setChecked(false);
					buildingUse14.setChecked(false);
					buildingUse15.setChecked(false);
					buildingUse17.setChecked(false);
					buildingUse18.setChecked(false);
				}
			}
		});
		buildingUse17.setChecked(config.sharedPreferences.getBoolean(
				config.RadioBtnState17, false));
		buildingUse17.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (buildingUse17.isChecked()) {
					buildingUse1.setChecked(false);
					buildingUse2.setChecked(false);
					buildingUse3.setChecked(false);
					buildingUse4.setChecked(false);
					buildingUse5.setChecked(false);
					buildingUse6.setChecked(false);
					buildingUse7.setChecked(false);
					buildingUse8.setChecked(false);
					buildingUse9.setChecked(false);
					buildingUse10.setChecked(false);
					buildingUse11.setChecked(false);
					buildingUse12.setChecked(false);
					buildingUse13.setChecked(false);
					buildingUse14.setChecked(false);
					buildingUse15.setChecked(false);
					buildingUse16.setChecked(false);
					buildingUse18.setChecked(false);
				}
			}
		});
		buildingUse18.setChecked(config.sharedPreferences.getBoolean(
				config.RadioBtnState18, false));
		buildingUse18.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (buildingUse18.isChecked()) {
					buildingUse1.setChecked(false);
					buildingUse2.setChecked(false);
					buildingUse3.setChecked(false);
					buildingUse4.setChecked(false);
					buildingUse5.setChecked(false);
					buildingUse6.setChecked(false);
					buildingUse7.setChecked(false);
					buildingUse8.setChecked(false);
					buildingUse9.setChecked(false);
					buildingUse10.setChecked(false);
					buildingUse11.setChecked(false);
					buildingUse12.setChecked(false);
					buildingUse13.setChecked(false);
					buildingUse14.setChecked(false);
					buildingUse15.setChecked(false);
					buildingUse16.setChecked(false);
					buildingUse17.setChecked(false);
				}
			}
		});
		addressCheckBox.setChecked(config.sharedPreferences.getBoolean(
				config.Address, false));
		areaCheckBox.setChecked(config.sharedPreferences.getBoolean(
				config.Area, false));
		siCheckBox.setChecked(config.sharedPreferences.getBoolean(config.Si,
				false));
		guCheckBox.setChecked(config.sharedPreferences.getBoolean(config.Gu,
				false));
		dongCheckBox.setChecked(config.sharedPreferences.getBoolean(
				config.Dong, false));
		if (addressCheckBox.isChecked()) {
			siCheckBox.setEnabled(true);
			guCheckBox.setEnabled(true);
			dongCheckBox.setEnabled(true);
		}
		// if(areaCheckBox.isChecked()){
		// areaMinValueEditText.setText(config.sharedPreferences.getInt(config.MinValue,
		// 0));
		// areaMaxValueEditText.setText(config.sharedPreferences.getInt(config.MaxValue,
		// 0));
		// }
		//
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		config = Config.getInstance();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.benchmark);

		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
		// ActionBar Settings Start
		// ActionBar actionBar = getActionBar();
		// actionBar.setBackgroundDrawable(new ColorDrawable(Color.RED));
		// actionBar.setIcon(R.drawable.ic_action_settings);
		// ActionBar Settings End
		buildingTypeCheckBox = (CheckBox) findViewById(R.id.BuildingTypeCheckBox);
		buildingSetRadioBtn = (RadioButton) findViewById(R.id.BuildingSet);
		generalBuildingRadioBtn = (RadioButton) findViewById(R.id.GeneralBuilding);
		buildingApplicationCheckBox = (CheckBox) findViewById(R.id.BuildingApplicationCheckBox);
		addressCheckBox = (CheckBox) findViewById(R.id.AddressCheckBox);
		siCheckBox = (CheckBox) findViewById(R.id.SiCheckBox);
		guCheckBox = (CheckBox) findViewById(R.id.GuCheckBox);
		dongCheckBox = (CheckBox) findViewById(R.id.DongCheckBox);
		areaCheckBox = (CheckBox) findViewById(R.id.AreaCheckBox);
		currentBuildingAreaTextView = (TextView) findViewById(R.id.CurrentBuildingAreaTextView);
		minmaxAreaTextView = (TextView) findViewById(R.id.MinMaxAreaTextView);

		areaMinValueEditText = (EditText) findViewById(R.id.AreaMinValueEditText);
		areaMaxValueEditText = (EditText) findViewById(R.id.AreaMaxValueEditText);
		// Radio Group Declear Start
		buildingUse1 = (RadioButton) findViewById(R.id.BuildingUse1);
		buildingUse2 = (RadioButton) findViewById(R.id.BuildingUse2);
		buildingUse3 = (RadioButton) findViewById(R.id.BuildingUse3);
		buildingUse4 = (RadioButton) findViewById(R.id.BuildingUse4);
		buildingUse5 = (RadioButton) findViewById(R.id.BuildingUse5);
		buildingUse6 = (RadioButton) findViewById(R.id.BuildingUse6);
		buildingUse7 = (RadioButton) findViewById(R.id.BuildingUse7);
		buildingUse8 = (RadioButton) findViewById(R.id.BuildingUse8);
		buildingUse9 = (RadioButton) findViewById(R.id.BuildingUse9);
		buildingUse10 = (RadioButton) findViewById(R.id.BuildingUse10);
		buildingUse11 = (RadioButton) findViewById(R.id.BuildingUse11);
		buildingUse12 = (RadioButton) findViewById(R.id.BuildingUse12);
		buildingUse13 = (RadioButton) findViewById(R.id.BuildingUse13);
		buildingUse14 = (RadioButton) findViewById(R.id.BuildingUse14);
		buildingUse15 = (RadioButton) findViewById(R.id.BuildingUse15);
		buildingUse16 = (RadioButton) findViewById(R.id.BuildingUse16);
		buildingUse17 = (RadioButton) findViewById(R.id.BuildingUse17);
		buildingUse18 = (RadioButton) findViewById(R.id.BuildingUse18);
		// Radio Group Declear End
		resetBtn = (Button) findViewById(R.id.ResetBtn);
		saveBtn = (Button) findViewById(R.id.SaveBtn);
		cancelBtn = (Button) findViewById(R.id.CancelBtn);

		toggleButtonGroupTableLayout = new ToggleButtonGroupTableLayout(this);
		toggleButtonGroupTableLayout = (ToggleButtonGroupTableLayout) findViewById(R.id.UseTableLayout);
		Log.i("tbgtl.getCheckedRadioButtonId()",
				String.valueOf(toggleButtonGroupTableLayout
						.getCheckedRadioButtonId()));

		// buildingSetRadioBtn.setChecked(true);
		// buildingUse1.setChecked(true);

		if (config.getBuildingID().equals("1")) {
			currentBuildingAreaTextView.setText("※ ETRI의 면적(m2) : "
					+ decimalFormat.format(config.getBuildingFloatArea()));
		} else if (config.getBuildingID().equals("2")) {
			currentBuildingAreaTextView.setText("※ 누리빌딩의 면적(m2) : "
					+ decimalFormat.format(config.getBuildingFloatArea()));
		} else if (config.getBuildingID().equals("3")) {
			currentBuildingAreaTextView.setText("※ 삼성물산의 면적(m2) : "
					+ decimalFormat.format(config.getBuildingFloatArea()));
		}

		DBHelper dbHelper = new DBHelper(Benchmark.this);
		String query = DBCursor.SELECT_BUILDING_AREA_VALUE;
		Cursor cursor = dbHelper.getReadableDatabase().rawQuery(query, null);
		cursor.moveToFirst();
		minmaxAreaTextView
				.setText("※ 벤치마크 빌딩의 면적 범위는 "
						+ decimalFormat.format(Double.parseDouble(cursor
								.getString(0)))
						+ " ~ "
						+ decimalFormat.format(Double.parseDouble(cursor
								.getString(1)) + 1) + " 입니다.");

		buildingTypeCheckBox.setChecked(true);
		buildingApplicationCheckBox.setChecked(true);
		buildingTypeCheckBox
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						// TODO Auto-generated method stub
						if (isChecked == true) {

							if (buildingSetRadioBtn.isChecked()) {
								config.setBuildingType(String
										.valueOf(buildingSetRadioBtn.getText()));

							} else if (generalBuildingRadioBtn.isChecked()) {
								config.setBuildingType(String
										.valueOf(generalBuildingRadioBtn
												.getText()));
							}
						} else if (isChecked == false) {
							// ------------------------------//
						}
						config.setBuildingTypeEnabled(buildingTypeCheckBox
								.isChecked());
						// ------------------------------//
					}
				});

		buildingApplicationCheckBox
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						// TODO Auto-generated method stub
						if (isChecked == true) {
							buildingUse1.setEnabled(isChecked);
							buildingUse2.setEnabled(isChecked);
							buildingUse3.setEnabled(isChecked);
							buildingUse4.setEnabled(isChecked);
							buildingUse5.setEnabled(isChecked);
							buildingUse6.setEnabled(isChecked);
							buildingUse7.setEnabled(isChecked);
							buildingUse8.setEnabled(isChecked);
							buildingUse9.setEnabled(isChecked);
							buildingUse10.setEnabled(isChecked);
							buildingUse11.setEnabled(isChecked);
							buildingUse12.setEnabled(isChecked);
							buildingUse13.setEnabled(isChecked);
							buildingUse14.setEnabled(isChecked);
							buildingUse15.setEnabled(isChecked);
							buildingUse16.setEnabled(isChecked);
							buildingUse17.setEnabled(isChecked);
							buildingUse18.setEnabled(isChecked);

						} else if (isChecked == false) {
							buildingUse1.setEnabled(isChecked);
							buildingUse2.setEnabled(isChecked);
							buildingUse3.setEnabled(isChecked);
							buildingUse4.setEnabled(isChecked);
							buildingUse5.setEnabled(isChecked);
							buildingUse6.setEnabled(isChecked);
							buildingUse7.setEnabled(isChecked);
							buildingUse8.setEnabled(isChecked);
							buildingUse9.setEnabled(isChecked);
							buildingUse10.setEnabled(isChecked);
							buildingUse11.setEnabled(isChecked);
							buildingUse12.setEnabled(isChecked);
							buildingUse13.setEnabled(isChecked);
							buildingUse14.setEnabled(isChecked);
							buildingUse15.setEnabled(isChecked);
							buildingUse16.setEnabled(isChecked);
							buildingUse17.setEnabled(isChecked);
							buildingUse18.setEnabled(isChecked);
						}
					}
				});

		// Address Check Start
		addressCheckBox
				.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						config.setAddressEnabled(isChecked);
						// TODO Auto-generated method stub
						if (isChecked == true) {
							siCheckBox.setEnabled(true);
							guCheckBox.setEnabled(true);
							dongCheckBox.setEnabled(true);
							siCheckBox
									.setOnCheckedChangeListener(new OnCheckedChangeListener() {

										@Override
										public void onCheckedChanged(
												CompoundButton buttonView,
												boolean isChecked) {
											config.setSiEnabled(isChecked);
										}
									});

							guCheckBox
									.setOnCheckedChangeListener(new OnCheckedChangeListener() {

										@Override
										public void onCheckedChanged(
												CompoundButton buttonView,
												boolean isChecked) {
											siCheckBox.setChecked(true);
											config.setSiEnabled(isChecked);
											config.setGuEnabled(isChecked);
										}
									});

							dongCheckBox
									.setOnCheckedChangeListener(new OnCheckedChangeListener() {

										@Override
										public void onCheckedChanged(
												CompoundButton buttonView,
												boolean isChecked) {
											siCheckBox.setChecked(true);
											guCheckBox.setChecked(true);
											config.setSiEnabled(isChecked);
											config.setGuEnabled(isChecked);
											config.setDongEnabled(isChecked);
										}
									});
						} else {
							siCheckBox.setChecked(false);
							guCheckBox.setChecked(false);
							dongCheckBox.setChecked(false);
							siCheckBox.setEnabled(false);
							guCheckBox.setEnabled(false);
							dongCheckBox.setEnabled(false);

						}
					}
				});
		// Address Check End

		// Area Check Start
		areaCheckBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked == true) {
					config.setAreaEnabled(isChecked);

					areaMinValueEditText.setEnabled(true);
					areaMaxValueEditText.setEnabled(true);

					DBHelper dbHelper = new DBHelper(Benchmark.this);
					String query = DBCursor.SELECT_BUILDING_AREA_VALUE;
					Cursor cursor = dbHelper.getReadableDatabase().rawQuery(
							query, null);
					cursor.moveToFirst();
					areaMinValueEditText
							.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
					areaMinValueEditText
							.setInputType(InputType.TYPE_CLASS_NUMBER);
					areaMaxValueEditText
							.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
					areaMaxValueEditText
							.setInputType(InputType.TYPE_CLASS_NUMBER);

					decimalFormat.format(config.getBuildingFloatArea());

					areaMinValueEditText.setText(String.valueOf(config
							.getBuildingFloatArea()));

					areaMaxValueEditText.setText(String.valueOf(Double
							.parseDouble(cursor.getString(1)) + 1));

					Config.setInstance(config);

				} else {
					areaMinValueEditText.setText("");
					areaMaxValueEditText.setText("");
					areaMinValueEditText.setEnabled(false);
					areaMaxValueEditText.setEnabled(false);
					// ------------------------------//
				}

			}
		});
		// Area Check End

		resetBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				resetState = true;
				config.setBuildingUse(Search.Radio.업무시설.toString());
				buildingUse1.setChecked(false);
				buildingUse2.setChecked(false);
				buildingUse3.setChecked(false);
				buildingUse4.setChecked(false);
				buildingUse5.setChecked(false);
				buildingUse6.setChecked(false);
				buildingUse7.setChecked(false);
				buildingUse8.setChecked(false);
				buildingUse9.setChecked(false);
				buildingUse10.setChecked(false);
				buildingUse11.setChecked(false);
				buildingUse12.setChecked(false);
				buildingUse13.setChecked(false);
				buildingUse14.setChecked(false);
				buildingUse15.setChecked(false);
				buildingUse16.setChecked(false);
				buildingUse17.setChecked(false);
				buildingUse18.setChecked(false);
				addressCheckBox.setChecked(false);
				areaCheckBox.setChecked(false);
				siCheckBox.setChecked(false);
				guCheckBox.setChecked(false);
				dongCheckBox.setChecked(false);
				siCheckBox.setEnabled(false);
				guCheckBox.setEnabled(false);
				dongCheckBox.setEnabled(false);
				areaMinValueEditText.setText("");
				areaMaxValueEditText.setText("");
				areaMinValueEditText.setEnabled(false);
				areaMaxValueEditText.setEnabled(false);
				Config.setInstance(config);

			}
		});

		saveBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.i("tbgtl.getCurrentRadioButton()", String
						.valueOf(toggleButtonGroupTableLayout
								.getCurrentRadioButton()));
				config.setBuildingTypeEnabled(true);
				config.setBuildingUseEnabled(true);
				if (resetState == true) {
					config.setBuildingUse(Search.Radio.업무시설.toString());
					resetState = false;
				} else {
					config.setBuildingUse(toggleButtonGroupTableLayout
							.getCurrentRadioButton());
				}
				if (areaCheckBox.isChecked()) {
					config.setMinValue(Double.parseDouble(areaMinValueEditText
							.getText().toString()));
					config.setMaxValue(Double.parseDouble(areaMaxValueEditText
							.getText().toString()));
				}

				Log.i("toggleButtonGroupTableLayout.getId()",
						String.valueOf(toggleButtonGroupTableLayout.getId()));
				Log.i("toggleButtonGroupTableLayout.getId()", String
						.valueOf(toggleButtonGroupTableLayout
								.getCheckedRadioButtonId()));

				config.sharedPreferences = getSharedPreferences(
						Config.StatesPref, MODE_PRIVATE);
				config.editor = config.sharedPreferences.edit();
				config.editor.putBoolean(config.RadioBtnState1,
						buildingUse1.isChecked());
				config.editor.putBoolean(config.RadioBtnState2,
						buildingUse2.isChecked());
				config.editor.putBoolean(config.RadioBtnState3,
						buildingUse3.isChecked());
				config.editor.putBoolean(config.RadioBtnState4,
						buildingUse4.isChecked());
				config.editor.putBoolean(config.RadioBtnState5,
						buildingUse5.isChecked());
				config.editor.putBoolean(config.RadioBtnState6,
						buildingUse6.isChecked());
				config.editor.putBoolean(config.RadioBtnState7,
						buildingUse7.isChecked());
				config.editor.putBoolean(config.RadioBtnState8,
						buildingUse8.isChecked());
				config.editor.putBoolean(config.RadioBtnState9,
						buildingUse9.isChecked());
				config.editor.putBoolean(config.RadioBtnState10,
						buildingUse10.isChecked());
				config.editor.putBoolean(config.RadioBtnState11,
						buildingUse11.isChecked());
				config.editor.putBoolean(config.RadioBtnState12,
						buildingUse12.isChecked());
				config.editor.putBoolean(config.RadioBtnState13,
						buildingUse13.isChecked());
				config.editor.putBoolean(config.RadioBtnState14,
						buildingUse14.isChecked());
				config.editor.putBoolean(config.RadioBtnState15,
						buildingUse15.isChecked());
				config.editor.putBoolean(config.RadioBtnState16,
						buildingUse16.isChecked());
				config.editor.putBoolean(config.RadioBtnState17,
						buildingUse17.isChecked());
				config.editor.putBoolean(config.RadioBtnState18,
						buildingUse18.isChecked());
				config.editor.putBoolean(config.Address,
						addressCheckBox.isChecked());
				config.editor.putBoolean(config.Si, siCheckBox.isChecked());
				config.editor.putBoolean(config.Gu, guCheckBox.isChecked());
				config.editor.putBoolean(config.Dong, dongCheckBox.isChecked());
				config.editor.putBoolean(config.Area, areaCheckBox.isChecked());
				config.editor.commit();

				config.defaultSettting();
				Config.setInstance(config);
				onBackPressed();

			}
		});

		cancelBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				onBackPressed();
			}
		});

	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		finish();
	}

}
