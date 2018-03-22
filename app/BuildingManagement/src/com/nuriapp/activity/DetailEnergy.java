package com.nuriapp.activity;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import com.nuriapp.activitiy.R;
import com.nuriapp.data.Codes;
import com.nuriapp.data.Codes.Detail;
import com.nuriapp.data.Config;
import com.nuriapp.data.DBCursor;
import com.nuriapp.data.DataSource.QueryData;
import com.nuriapp.utils.DBHelper;
import com.nuriapp.utils.NumberUtil;

public class DetailEnergy extends Fragment {
	private TextView euTextView1, euTextView2, euTextView3, euTextView4,
			guTextView1, guTextView2, guTextView3, guTextView4, wuTextView1,
			wuTextView2, wuTextView3, wuTextView4, currentDateTextView,
			sumTextView;
	private DBHelper dbHelper;
	private WebView electricityChart, gasChart, waterChart;
	private Button beforeBtn, afterBtn, electricityChartBtn, gasChartBtn,
			waterChartBtn;
	private Calendar calendar, lastMonthCalendar;
	private SimpleDateFormat currentDateFormat, compareDateFormat,
			currentDayDateFormat;
	private DecimalFormat decimalFormat;
	private String currentFormattedDate, compareFormattedDate,
			currentFormattedDayDate, lastMonthFormattedDate, maxFormattedDate;
	private String currentBuildingId = "";
	private double electricityCaloricValue = 2150;
	private double gasCaloricValue = 9550;
	private double waterEmissionFactor = 0.783;
	private double crude = 10000000;
	private double amount = 0;
	private double electricityEmissionFactor = 0.000215;
	private double minDate, maxDate;
	private int sumEnergyCost;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		currentBuildingId = Config.getInstance().getBuildingID();
		if (currentBuildingId == "1") {
			cursorStart();
		} else if (currentBuildingId == "2") {
			cursorStart();
		} else if (currentBuildingId == "3") {
			cursorStart();
		}

	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		final AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
		Config.getInstance().defaultSettting();
		electricityChart = new WebView(getActivity());
		dbHelper = new DBHelper(getActivity());

		currentBuildingId = Config.getInstance().getBuildingID();

		calendar = Calendar.getInstance();
		lastMonthCalendar = Calendar.getInstance();
		currentDateFormat = new SimpleDateFormat("yyyy" + "년" + "MM" + "월");
		currentFormattedDate = currentDateFormat.format(calendar.getTime());

		compareDateFormat = new SimpleDateFormat("yyyyMM");
		compareFormattedDate = compareDateFormat.format(calendar.getTime());

		currentDayDateFormat = new SimpleDateFormat("yyyyMMdd");
		currentFormattedDayDate = currentDayDateFormat.format(calendar
				.getTime());

		lastMonthFormattedDate = compareDateFormat.format(lastMonthCalendar
				.getTime());
		maxFormattedDate = compareDateFormat.format(calendar.getTime());

		decimalFormat = new DecimalFormat("###,###,###,###,###,###.###");

		beforeBtn = (Button) getActivity().findViewById(R.id.BeforeBtn);
		afterBtn = (Button) getActivity().findViewById(R.id.AfterBtn);

		electricityChartBtn = (Button) getActivity().findViewById(
				R.id.ElectricityChartBtn);
		gasChartBtn = (Button) getActivity().findViewById(R.id.GasChartBtn);
		waterChartBtn = (Button) getActivity().findViewById(R.id.WaterChartBtn);
		currentDateTextView = (TextView) getActivity().findViewById(
				R.id.CurrentDate);
		sumTextView = (TextView) getActivity().findViewById(R.id.SumTextView);
		euTextView1 = (TextView) getActivity().findViewById(R.id.EUTextView1);
		euTextView2 = (TextView) getActivity().findViewById(R.id.EUTextView2);
		euTextView3 = (TextView) getActivity().findViewById(R.id.EUTextView3);
		euTextView4 = (TextView) getActivity().findViewById(R.id.EUTextView4);
		guTextView1 = (TextView) getActivity().findViewById(R.id.GUTextView1);
		guTextView2 = (TextView) getActivity().findViewById(R.id.GUTextView2);
		guTextView3 = (TextView) getActivity().findViewById(R.id.GUTextView3);
		guTextView4 = (TextView) getActivity().findViewById(R.id.GUTextView4);
		wuTextView1 = (TextView) getActivity().findViewById(R.id.WUTextView1);
		wuTextView2 = (TextView) getActivity().findViewById(R.id.WUTextView2);
		wuTextView3 = (TextView) getActivity().findViewById(R.id.WUTextView3);
		wuTextView4 = (TextView) getActivity().findViewById(R.id.WUTextView4);
		electricityChart = (WebView) getActivity().findViewById(
				R.id.ElectricityChart);
		gasChart = (WebView) getActivity().findViewById(R.id.GasChart);
		waterChart = (WebView) getActivity().findViewById(R.id.WaterChart);

		electricityChart.setVisibility(View.VISIBLE);
		gasChart.setVisibility(View.GONE);
		waterChart.setVisibility(View.GONE);
		currentDateTextView.setText(currentFormattedDate + " ");

		DBHelper db = new DBHelper(getActivity());

		Cursor cursor = dbHelper.getReadableDatabase().rawQuery(
				DBCursor.SELECT_MIN_DATE, null);
		cursor.moveToFirst();
		minDate = Double.parseDouble(cursor.getString(0));
		maxDate = Double.parseDouble(maxFormattedDate);
		cursor.close();

		
		
		cursorStart();

		beforeBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				if (minDate < Double.parseDouble(compareFormattedDate)) {
					calendar.add(Calendar.MONTH, -1);
					lastMonthCalendar.add(Calendar.MONTH, -2);
					currentFormattedDate = currentDateFormat.format(calendar
							.getTime());
					compareFormattedDate = compareDateFormat.format(calendar
							.getTime());
					currentFormattedDayDate = currentDayDateFormat
							.format(calendar.getTime());
					lastMonthFormattedDate = compareDateFormat
							.format(lastMonthCalendar.getTime());
					sumEnergyCost = 0;

					currentDateTextView.setText(currentFormattedDate + " ");

					double electricityData = getData(compareFormattedDate,
							Codes.ObjectType.ELECTRICITY,
							ArrayUtils.toArray(currentBuildingId));
					amount = electricityData;
					if (Double.isNaN(electricityData) || electricityData == 0) {
						euTextView1.setText("현월 : -");
					} else {
						euTextView1.setText("현월 : "
								+ String.valueOf(decimalFormat
										.format(electricityData)) + "(kW)");
					}
					DBHelper db = new DBHelper(getActivity());
					String query = getEnergyCost(compareFormattedDate,
							Codes.ObjectType.ELECTRICITY,
							ArrayUtils.toArray(currentBuildingId));
					Cursor cursor = dbHelper.getReadableDatabase().rawQuery(
							query, null);
					cursor.moveToFirst();
					for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor
							.moveToNext()) {
						sumEnergyCost += (amount * (Double.parseDouble(cursor
								.getString(0))));
					}
					electricityData = getDayAvgData(currentFormattedDayDate,
							Codes.ObjectType.ELECTRICITY,
							ArrayUtils.toArray(currentBuildingId));
					if (Double.isNaN(electricityData) || electricityData == 0) {
						euTextView2.setText("일 평균 : -");
					} else {
						euTextView2.setText("일 평균 : "
								+ String.valueOf(decimalFormat
										.format(electricityData)) + "(kW)");
					}

					electricityData = getData(lastMonthFormattedDate,
							Codes.ObjectType.ELECTRICITY,
							ArrayUtils.toArray(currentBuildingId));
					if (Double.isNaN(electricityData) || electricityData == 0) {
						euTextView3.setText("전월 : -");
					} else {
						euTextView3.setText("전월 : "
								+ String.valueOf(decimalFormat
										.format(electricityData)) + "(kW)");
					}
					electricityData = (amount * electricityCaloricValue)
							/ crude;
					if (Double.isNaN(electricityData) || electricityData == 0) {
						euTextView4.setText("TOE 환산 : -");
					} else {
						euTextView4.setText("TOE 환산 : "
								+ String.valueOf(decimalFormat
										.format(electricityData)));
					}
					double gasData = getData(compareFormattedDate,
							Codes.ObjectType.GAS,
							ArrayUtils.toArray(currentBuildingId));
					amount = gasData;
					if (Double.isNaN(gasData) || gasData == 0) {
						guTextView1.setText("현월 : -");
					} else {
						guTextView1.setText("현월 : "
								+ String.valueOf(decimalFormat.format(gasData))
								+ "(Nm3)");
					}

					db = new DBHelper(getActivity());
					query = getEnergyCost(compareFormattedDate,
							Codes.ObjectType.GAS,
							ArrayUtils.toArray(currentBuildingId));
					cursor = dbHelper.getReadableDatabase().rawQuery(query,
							null);
					cursor.moveToFirst();
					for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor
							.moveToNext()) {
						sumEnergyCost += (amount * (Double.parseDouble(cursor
								.getString(0))));
					}
					gasData = getDayAvgData(currentFormattedDayDate,
							Codes.ObjectType.GAS,
							ArrayUtils.toArray(currentBuildingId));
					if (Double.isNaN(gasData) || gasData == 0) {
						guTextView2.setText("일 평균 : -");
					} else {
						guTextView2.setText("일 평균 : "
								+ String.valueOf(decimalFormat.format(gasData))
								+ "(Nm3)");
					}
					gasData = getData(lastMonthFormattedDate,
							Codes.ObjectType.GAS,
							ArrayUtils.toArray(currentBuildingId));
					if (Double.isNaN(gasData) || gasData == 0) {
						guTextView3.setText("전월 : -");
					} else {
						guTextView3.setText("전월 : "
								+ String.valueOf(decimalFormat.format(gasData))
								+ "(Nm3)");
					}
					gasData = (amount * gasCaloricValue) / crude;
					if (Double.isNaN(gasData) || gasData == 0) {
						guTextView4.setText("TOE 환산 : -");
					} else {
						guTextView4.setText("TOE 환산 : "
								+ String.valueOf(decimalFormat.format(gasData)));
					}

					double waterData = getData(compareFormattedDate,
							Codes.ObjectType.WATER,
							ArrayUtils.toArray(currentBuildingId));
					amount = waterData;
					if (Double.isNaN(waterData) || waterData == 0) {
						wuTextView1.setText("현월 : -");
					} else {
						wuTextView1.setText("현월 : "
								+ String.valueOf(decimalFormat
										.format(waterData)) + "(Gcal)");
					}

					db = new DBHelper(getActivity());
					query = getEnergyCost(compareFormattedDate,
							Codes.ObjectType.WATER,
							ArrayUtils.toArray(currentBuildingId));
					cursor = dbHelper.getReadableDatabase().rawQuery(query,
							null);
					cursor.moveToFirst();
					for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor
							.moveToNext()) {
						sumEnergyCost += (amount * (Double.parseDouble(cursor
								.getString(0))));
					}
					waterData = getDayAvgData(currentFormattedDayDate,
							Codes.ObjectType.WATER,
							ArrayUtils.toArray(currentBuildingId));
					if (Double.isNaN(waterData) || waterData == 0) {
						wuTextView2.setText("일 평균 : -");
					} else {
						wuTextView2.setText("일 평균 : "
								+ String.valueOf(decimalFormat
										.format(waterData)) + "(Gcal)");
					}

					waterData = getData(lastMonthFormattedDate,
							Codes.ObjectType.WATER,
							ArrayUtils.toArray(currentBuildingId));

					if (Double.isNaN(waterData) || waterData == 0) {
						wuTextView3.setText("전월 : -");
					} else {
						wuTextView3.setText("전월 : "
								+ String.valueOf(decimalFormat
										.format(waterData)) + "(Gcal)");
					}
					waterData = amount * electricityEmissionFactor
							* waterEmissionFactor;
					if (Double.isNaN(waterData) || waterData == 0) {
						wuTextView4.setText("TOE 환산 : -");
					} else {
						wuTextView4.setText("TOE 환산 : "
								+ String.valueOf(decimalFormat
										.format(waterData)));
					}

					if (Double.isNaN(sumEnergyCost) || sumEnergyCost == 0) {
						sumTextView.setText(" -(원)");
					} else {
						sumTextView.setText(" "
								+ String.valueOf(decimalFormat
										.format(sumEnergyCost) + "(원)"));
					}
					electricityChart.getSettings().setJavaScriptEnabled(true);
					gasChart.getSettings().setJavaScriptEnabled(true);
					waterChart.getSettings().setJavaScriptEnabled(true);
					electricityChart.loadDataWithBaseURL(null,
							getTemplate(compareFormattedDate, "electricity"),
							"text/html", "utf-8", null);
					gasChart.loadDataWithBaseURL(null,
							getTemplate(compareFormattedDate, "gas"),
							"text/html", "utf-8", null);
					waterChart.loadDataWithBaseURL(null,
							getTemplate(compareFormattedDate, "water"),
							"text/html", "utf-8", null);
					lastMonthCalendar.add(Calendar.MONTH, 1);
				} else {
					alert.setPositiveButton("확인",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									dialog.dismiss();
								}
							});
					alert.setMessage("데이터가 없습니다.");
					alert.show();
				}

			}
		});

		afterBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (Double.parseDouble(compareFormattedDate) < maxDate) {
					calendar.add(Calendar.MONTH, 1);

					currentFormattedDate = currentDateFormat.format(calendar
							.getTime());
					compareFormattedDate = compareDateFormat.format(calendar
							.getTime());
					currentFormattedDayDate = currentDayDateFormat
							.format(calendar.getTime());
					lastMonthFormattedDate = compareDateFormat
							.format(lastMonthCalendar.getTime());
					sumEnergyCost = 0;

					currentDateTextView.setText(currentFormattedDate + " ");
					double electricityData = getData(compareFormattedDate,
							Codes.ObjectType.ELECTRICITY,
							ArrayUtils.toArray(currentBuildingId));
					amount = electricityData;
					if (Double.isNaN(electricityData) || electricityData == 0) {
						euTextView1.setText("현월 : -");
					} else {
						euTextView1.setText("현월 : "
								+ String.valueOf(decimalFormat
										.format(electricityData)) + "(kW)");
					}

					DBHelper db = new DBHelper(getActivity());
					String query = getEnergyCost(compareFormattedDate,
							Codes.ObjectType.ELECTRICITY,
							ArrayUtils.toArray(currentBuildingId));
					Cursor cursor = dbHelper.getReadableDatabase().rawQuery(
							query, null);
					cursor.moveToFirst();
					for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor
							.moveToNext()) {
						sumEnergyCost += (amount * (Double.parseDouble(cursor
								.getString(0))));
					}
					electricityData = getDayAvgData(currentFormattedDayDate,
							Codes.ObjectType.ELECTRICITY,
							ArrayUtils.toArray(currentBuildingId));
					if (Double.isNaN(electricityData) || electricityData == 0) {
						euTextView2.setText("일 평균 : -");
					} else {
						euTextView2.setText("일 평균 : "
								+ String.valueOf(decimalFormat
										.format(electricityData)) + "(kW)");
					}

					electricityData = getData(lastMonthFormattedDate,
							Codes.ObjectType.ELECTRICITY,
							ArrayUtils.toArray(currentBuildingId));
					if (Double.isNaN(electricityData) || electricityData == 0) {
						euTextView3.setText("전월 : -");
					} else {
						euTextView3.setText("전월 : "
								+ String.valueOf(decimalFormat
										.format(electricityData)) + "(kW)");
					}

					electricityData = (amount * electricityCaloricValue)
							/ crude;
					if (Double.isNaN(electricityData) || electricityData == 0) {
						euTextView4.setText("TOE 환산 : -");
					} else {
						euTextView4.setText("TOE 환산 : "
								+ String.valueOf(decimalFormat
										.format(electricityData)));
					}

					double gasData = getData(compareFormattedDate,
							Codes.ObjectType.GAS,
							ArrayUtils.toArray(currentBuildingId));
					amount = gasData;
					if (Double.isNaN(gasData) || gasData == 0) {
						guTextView1.setText("현월 : -");
					} else {
						guTextView1.setText("현월 : "
								+ String.valueOf(decimalFormat.format(gasData))
								+ "(Nm3)");
					}

					db = new DBHelper(getActivity());
					query = getEnergyCost(compareFormattedDate,
							Codes.ObjectType.GAS,
							ArrayUtils.toArray(currentBuildingId));
					cursor = dbHelper.getReadableDatabase().rawQuery(query,
							null);
					cursor.moveToFirst();
					for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor
							.moveToNext()) {
						sumEnergyCost += (amount * (Double.parseDouble(cursor
								.getString(0))));
					}
					gasData = getDayAvgData(currentFormattedDayDate,
							Codes.ObjectType.GAS,
							ArrayUtils.toArray(currentBuildingId));
					if (Double.isNaN(gasData) || gasData == 0) {
						guTextView2.setText("일 평균 : -");
					} else {
						guTextView2.setText("일 평균 : "
								+ String.valueOf(decimalFormat.format(gasData))
								+ "(Nm3)");
					}

					gasData = getData(lastMonthFormattedDate,
							Codes.ObjectType.GAS,
							ArrayUtils.toArray(currentBuildingId));
					if (Double.isNaN(gasData) || gasData == 0) {
						guTextView3.setText("전월 : -");
					} else {
						guTextView3.setText("전월 : "
								+ String.valueOf(decimalFormat.format(gasData))
								+ "(Nm3)");
					}

					gasData = (amount * gasCaloricValue) / crude;
					if (Double.isNaN(gasData) || gasData == 0) {
						guTextView4.setText("TOE 환산 : -");
					} else {
						guTextView4.setText("TOE 환산 : "
								+ String.valueOf(decimalFormat.format(gasData)));
					}

					double waterData = getData(compareFormattedDate,
							Codes.ObjectType.WATER,
							ArrayUtils.toArray(currentBuildingId));
					amount = waterData;
					if (Double.isNaN(waterData) || waterData == 0) {
						wuTextView1.setText("현월 : -");
					} else {
						wuTextView1.setText("현월 : "
								+ String.valueOf(decimalFormat
										.format(waterData)) + "(Gcal)");
					}

					db = new DBHelper(getActivity());
					query = getEnergyCost(compareFormattedDate,
							Codes.ObjectType.WATER,
							ArrayUtils.toArray(currentBuildingId));
					cursor = dbHelper.getReadableDatabase().rawQuery(query,
							null);
					cursor.moveToFirst();
					for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor
							.moveToNext()) {
						sumEnergyCost += (amount * (Double.parseDouble(cursor
								.getString(0))));
					}
					waterData = getDayAvgData(currentFormattedDayDate,
							Codes.ObjectType.WATER,
							ArrayUtils.toArray(currentBuildingId));
					if (Double.isNaN(waterData) || waterData == 0) {
						wuTextView2.setText("일 평균 : -");
					} else {
						wuTextView2.setText("일 평균 : "
								+ String.valueOf(decimalFormat
										.format(waterData)) + "(Gcal)");
					}

					waterData = getData(lastMonthFormattedDate,
							Codes.ObjectType.WATER,
							ArrayUtils.toArray(currentBuildingId));
					if (Double.isNaN(waterData) || waterData == 0) {
						wuTextView3.setText("전월 : -");
					} else {
						wuTextView3.setText("전월 : "
								+ String.valueOf(decimalFormat
										.format(waterData)) + "(Gcal)");
					}

					waterData = amount * electricityEmissionFactor
							* waterEmissionFactor;
					if (Double.isNaN(waterData) || waterData == 0) {
						wuTextView4.setText("TOE 환산 : -");
					} else {
						wuTextView4.setText("TOE 환산 : "
								+ String.valueOf(decimalFormat
										.format(waterData)));
					}

					if (Double.isNaN(sumEnergyCost)) {
						sumTextView.setText(" -(원)");
					} else {
						sumTextView.setText(" "
								+ String.valueOf(decimalFormat
										.format(sumEnergyCost) + "(원)"));
					}

					electricityChart.getSettings().setJavaScriptEnabled(true);
					gasChart.getSettings().setJavaScriptEnabled(true);
					waterChart.getSettings().setJavaScriptEnabled(true);
					electricityChart.loadDataWithBaseURL(null,
							getTemplate(compareFormattedDate, "electricity"),
							"text/html", "utf-8", null);
					gasChart.loadDataWithBaseURL(null,
							getTemplate(compareFormattedDate, "gas"),
							"text/html", "utf-8", null);
					waterChart.loadDataWithBaseURL(null,
							getTemplate(compareFormattedDate, "water"),
							"text/html", "utf-8", null);
					lastMonthCalendar.add(Calendar.MONTH, 1);

				} else {
					alert.setPositiveButton("확인",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									dialog.dismiss();
								}
							});
					alert.setMessage("데이터가 없습니다.");
					alert.show();
				}
			}
		});
		//

		electricityChartBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				electricityChartBtn.setSelected(true);
				gasChartBtn.setSelected(false);
				waterChartBtn.setSelected(false);
				electricityChart.setVisibility(View.VISIBLE);
				gasChart.setVisibility(View.GONE);
				waterChart.setVisibility(View.GONE);

			}

		});

		gasChartBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				electricityChartBtn.setSelected(false);
				gasChartBtn.setSelected(true);
				waterChartBtn.setSelected(false);
				electricityChart.setVisibility(View.GONE);
				gasChart.setVisibility(View.VISIBLE);
				waterChart.setVisibility(View.GONE);
			}

		});

		waterChartBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				electricityChartBtn.setSelected(false);
				gasChartBtn.setSelected(false);
				waterChartBtn.setSelected(true);
				electricityChart.setVisibility(View.GONE);
				gasChart.setVisibility(View.GONE);
				waterChart.setVisibility(View.VISIBLE);
			}

		});
	}

	public List<Codes.Data> getTotalData(String date, String[] buildingType) {
		List<Codes.Data> list = new ArrayList<Codes.Data>();
		String query = DBCursor.getMonthTotalQuery(Codes.ObjectType.ALL,
				buildingType, date);
		Cursor cursor = dbHelper.getReadableDatabase().rawQuery(query, null);

		cursor.moveToFirst();
		for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
			list.add(new com.nuriapp.data.Codes.Data(cursor.getString(0), cursor
					.getString(1), cursor.getString(2)));
		}
		return list;
	}

	public double getData(String date, String[] objectType, String[] buildings) {
		String query = DBCursor.getQuery(date, DBCursor.SELECT_QUERY_MONTH,
				objectType, buildings);
		Cursor cursor = dbHelper.getReadableDatabase().rawQuery(query, null);

		cursor.moveToFirst();
		double result = 0;
		for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
			result = NumberUtils.toDouble(cursor.getString(0));
		}
		return result;
	}

	public double getDayAvgData(String date, String[] objectType,
			String[] buildings) {
		String query = getQuery(objectType, Codes.Building.ETRI);

		Cursor cursor = dbHelper.getReadableDatabase().rawQuery(query, null);
		cursor.moveToFirst();
		List<QueryData> queryDataList = new ArrayList<QueryData>();
		double result = 0;
		for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
			QueryData queryData = new QueryData(cursor.getString(0),
					cursor.getString(1), cursor.getString(2),
					cursor.getString(3));
			queryDataList.add(queryData);
		}
		for (int d = 0; d < queryDataList.size(); d++) {
			result += NumberUtils.toDouble(queryDataList.get(d).getSumData());
		}
		if (objectType.equals("ELECTRICITY")) {
			return result / (queryDataList.size() / 3);
		} else
			return result / queryDataList.size();

	}

	public String getQuery(String[] objectTypes, String[] buildings) {
		List<String> ids = new ArrayList<String>();
		int max = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		for (int i = 1; i <= max; i++) {
			for (String objectType : objectTypes) {
				for (String building : buildings) {
					ids.add(String.format("'%s%s%s%s'", building, objectType,
							compareFormattedDate, NumberUtil.format(i, 2)));
				}
			}
		}

		String joinStr = StringUtils.join(ids, ",");
		String query = String.format(DBCursor.SELECT_QUERY_DAY_TOTAL, joinStr);
		return query;
	}

	public String getEnergyCost(String date, String[] objectTypes,
			String[] buildings) {
		List<String> ids = new ArrayList<String>();
		for (String objectType : objectTypes) {
			for (String building : buildings) {
				ids.add(String.format("'%s%s'", compareFormattedDate,
						objectType));
			}
		}
		String joinStr = StringUtils.join(ids, ",");
		String query = String
				.format(DBCursor.SELECT_QUERY_ENERGY_COST, joinStr);
		return query;
	}

	private void cursorStart() { // Starting Default Display
		currentBuildingId = Config.getInstance().getBuildingID();
		electricityChartBtn.setSelected(true);
		lastMonthCalendar.add(Calendar.MONTH, -1);
		lastMonthFormattedDate = compareDateFormat.format(lastMonthCalendar
				.getTime());
		if (currentBuildingId == "1") {
			double electricityData = getData(compareFormattedDate,
					Codes.ObjectType.ELECTRICITY, Codes.Building.ETRI);
			amount = electricityData;
			if (Double.isNaN(electricityData) || electricityData == 0) {
				euTextView1.setText("현월 : -");
			} else {
				euTextView1.setText("현월 : "
						+ String.valueOf(decimalFormat.format(electricityData))
						+ "(kW)");
			}

			DBHelper db = new DBHelper(getActivity());
			String query = getEnergyCost(compareFormattedDate,
					Codes.ObjectType.ELECTRICITY, Codes.Building.ETRI);
			Cursor cursor = dbHelper.getReadableDatabase()
					.rawQuery(query, null);
			cursor.moveToFirst();
			for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor
					.moveToNext()) {
				sumEnergyCost += (amount * (Double.parseDouble(cursor
						.getString(0))));
			}
			electricityData = getDayAvgData(currentFormattedDayDate,
					Codes.ObjectType.ELECTRICITY, Codes.Building.ETRI);
			if (Double.isNaN(electricityData) || electricityData == 0) {
				euTextView2.setText("일 평균 : -");
			} else {
				euTextView2.setText("일 평균 : "
						+ String.valueOf(decimalFormat.format(electricityData))
						+ "(kW)");
			}
			electricityData = getData(lastMonthFormattedDate,
					Codes.ObjectType.ELECTRICITY, Codes.Building.ETRI);
			if (Double.isNaN(electricityData) || electricityData == 0) {
				euTextView3.setText("전월 : -");
			} else {
				euTextView3.setText("전월 : "
						+ String.valueOf(decimalFormat.format(electricityData))
						+ "(kW)");
			}

			electricityData = (amount * electricityCaloricValue) / crude;
			if (Double.isNaN(electricityData) || electricityData == 0) {
				euTextView4.setText("TOE 환산 : -");
			} else {
				euTextView4
						.setText("TOE 환산 : "
								+ String.valueOf(decimalFormat
										.format(electricityData)));
			}

			double gasData = getData(compareFormattedDate,
					Codes.ObjectType.GAS, Codes.Building.ETRI);
			amount = gasData;
			if (Double.isNaN(gasData) || gasData == 0) {
				guTextView1.setText("현월 : -");
			} else {
				guTextView1.setText("현월 : "
						+ String.valueOf(decimalFormat.format(gasData))
						+ "(Nm3)");
			}

			db = new DBHelper(getActivity());
			query = getEnergyCost(compareFormattedDate, Codes.ObjectType.GAS,
					Codes.Building.ETRI);
			cursor = dbHelper.getReadableDatabase().rawQuery(query, null);
			cursor.moveToFirst();
			for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor
					.moveToNext()) {
				sumEnergyCost += (amount * (Double.parseDouble(cursor
						.getString(0))));
			}
			gasData = getDayAvgData(currentFormattedDayDate,
					Codes.ObjectType.GAS, Codes.Building.ETRI);
			if (Double.isNaN(gasData) || gasData == 0) {
				guTextView2.setText("일 평균 : -");
			} else {
				guTextView2.setText("일 평균 : "
						+ String.valueOf(decimalFormat.format(gasData))
						+ "(Nm3)");
			}

			gasData = getData(lastMonthFormattedDate, Codes.ObjectType.GAS,
					Codes.Building.ETRI);
			if (Double.isNaN(gasData) || gasData == 0) {
				guTextView3.setText("전월 : -");
			} else {
				guTextView3.setText("전월 : "
						+ String.valueOf(decimalFormat.format(gasData))
						+ "(Nm3)");
			}

			gasData = (amount * gasCaloricValue) / crude;
			if (Double.isNaN(gasData) || gasData == 0) {
				guTextView4.setText("TOE 환산 : -");
			} else {
				guTextView4.setText("TOE 환산 : "
						+ String.valueOf(decimalFormat.format(gasData)));
			}

			double waterData = getData(compareFormattedDate,
					Codes.ObjectType.WATER, Codes.Building.ETRI);
			amount = waterData;
			if (Double.isNaN(waterData) || waterData == 0) {
				wuTextView1.setText("현월 : -");
			} else {
				wuTextView1.setText("현월 : "
						+ String.valueOf(decimalFormat.format(waterData))
						+ "(Gcal)");
			}

			db = new DBHelper(getActivity());
			query = getEnergyCost(compareFormattedDate, Codes.ObjectType.WATER,
					Codes.Building.ETRI);
			cursor = dbHelper.getReadableDatabase().rawQuery(query, null);
			cursor.moveToFirst();
			for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor
					.moveToNext()) {
				sumEnergyCost += (amount * (Double.parseDouble(cursor
						.getString(0))));
			}
			waterData = getDayAvgData(currentFormattedDayDate,
					Codes.ObjectType.WATER, Codes.Building.ETRI);
			if (Double.isNaN(waterData) || waterData == 0) {
				wuTextView2.setText("일 평균 : -");
			} else {
				wuTextView2.setText("일 평균 : "
						+ String.valueOf(decimalFormat.format(waterData))
						+ "(Gcal)");
			}

			waterData = getData(lastMonthFormattedDate, Codes.ObjectType.WATER,
					Codes.Building.ETRI);

			if (Double.isNaN(waterData) || waterData == 0) {
				wuTextView3.setText("전월 : -");
			} else {
				wuTextView3.setText("전월 : "
						+ String.valueOf(decimalFormat.format(waterData))
						+ "(Gcal)");
			}

			waterData = amount * electricityEmissionFactor
					* waterEmissionFactor;
			if (Double.isNaN(waterData) || waterData == 0) {
				wuTextView4.setText("TOE 환산 : -");
			} else {
				wuTextView4.setText("TOE 환산 : "
						+ String.valueOf(decimalFormat.format(waterData)));
			}

			electricityChart.getSettings().setJavaScriptEnabled(true);
			gasChart.getSettings().setJavaScriptEnabled(true);
			waterChart.getSettings().setJavaScriptEnabled(true);
			electricityChart.loadDataWithBaseURL(null,
					getTemplate(compareFormattedDate, "electricity"),
					"text/html", "utf-8", null);
			gasChart.loadDataWithBaseURL(null,
					getTemplate(compareFormattedDate, "gas"), "text/html",
					"utf-8", null);
			waterChart.loadDataWithBaseURL(null,
					getTemplate(compareFormattedDate, "water"), "text/html",
					"utf-8", null);

		} else if (currentBuildingId == "2") {
			double electricityData = getData(compareFormattedDate,
					Codes.ObjectType.ELECTRICITY, Codes.Building.NURI);
			amount = electricityData;
			if (Double.isNaN(electricityData) || electricityData == 0) {
				euTextView1.setText("현월 : -");
			} else {
				euTextView1.setText("현월 : "
						+ String.valueOf(decimalFormat.format(electricityData))
						+ "(kW)");
			}
			DBHelper db = new DBHelper(getActivity());
			String query = getEnergyCost(compareFormattedDate,
					Codes.ObjectType.ELECTRICITY, Codes.Building.NURI);
			Cursor cursor = dbHelper.getReadableDatabase()
					.rawQuery(query, null);
			cursor.moveToFirst();
			for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor
					.moveToNext()) {
				sumEnergyCost += (amount * (Double.parseDouble(cursor
						.getString(0))));
			}
			electricityData = getData(currentFormattedDayDate,
					Codes.ObjectType.ELECTRICITY, Codes.Building.NURI);
			if (Double.isNaN(electricityData) || electricityData == 0) {
				euTextView2.setText("일 평균 : -");
			} else {
				euTextView2.setText("일 평균 : "
						+ String.valueOf(decimalFormat.format(electricityData))
						+ "(kW)");
			}
			electricityData = getData(lastMonthFormattedDate,
					Codes.ObjectType.ELECTRICITY, Codes.Building.NURI);
			if (Double.isNaN(electricityData) || electricityData == 0) {
				euTextView3.setText("전월 : -");
			} else {
				euTextView3.setText("전월 : "
						+ String.valueOf(decimalFormat.format(electricityData))
						+ "(kW)");
			}

			electricityData = (amount * electricityCaloricValue) / crude;
			if (Double.isNaN(electricityData) || electricityData == 0) {
				euTextView4.setText("TOE 환산 : -");
			} else {
				euTextView4
						.setText("TOE 환산 : "
								+ String.valueOf(decimalFormat
										.format(electricityData)));
			}

			double gasData = getData(compareFormattedDate,
					Codes.ObjectType.GAS, Codes.Building.NURI);
			amount = gasData;
			if (Double.isNaN(gasData) || gasData == 0) {
				guTextView1.setText("현월 : -");
				db = new DBHelper(getActivity());
			} else {
				guTextView1.setText("현월 : "
						+ String.valueOf(decimalFormat.format(gasData))
						+ "(Nm3)");
				db = new DBHelper(getActivity());
			}

			query = getEnergyCost(compareFormattedDate, Codes.ObjectType.GAS,
					Codes.Building.NURI);
			cursor = dbHelper.getReadableDatabase().rawQuery(query, null);
			cursor.moveToFirst();
			for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor
					.moveToNext()) {
				sumEnergyCost += (amount * (Double.parseDouble(cursor
						.getString(0))));
			}
			gasData = getData(currentFormattedDayDate, Codes.ObjectType.GAS,
					Codes.Building.NURI);
			if (Double.isNaN(gasData) || gasData == 0) {
				guTextView2.setText("일 평균 : -");
			} else {
				guTextView2.setText("일 평균 : "
						+ String.valueOf(decimalFormat.format(gasData))
						+ "(Nm3)");
			}
			gasData = getData(lastMonthFormattedDate, Codes.ObjectType.GAS,
					Codes.Building.NURI);
			if (Double.isNaN(gasData) || gasData == 0) {
				guTextView3.setText("전월 : -");
			} else {
				guTextView3.setText("전월 : "
						+ String.valueOf(decimalFormat.format(gasData))
						+ "(Nm3)");
			}

			gasData = (amount * gasCaloricValue) / crude;
			if (Double.isNaN(gasData) || gasData == 0) {
				guTextView4.setText("TOE 환산 : -");
			} else {
				guTextView4.setText("TOE 환산 : "
						+ String.valueOf(decimalFormat.format(gasData)));
			}

			double waterData = getData(compareFormattedDate,
					Codes.ObjectType.WATER, Codes.Building.NURI);
			amount = waterData;
			if (Double.isNaN(waterData) || waterData == 0) {
				wuTextView1.setText("현월 : -");
			} else {
				wuTextView1.setText("현월 : "
						+ String.valueOf(decimalFormat.format(waterData))
						+ "(Gcal)");
			}

			db = new DBHelper(getActivity());
			query = getEnergyCost(compareFormattedDate, Codes.ObjectType.WATER,
					Codes.Building.NURI);
			cursor = dbHelper.getReadableDatabase().rawQuery(query, null);
			cursor.moveToFirst();
			for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor
					.moveToNext()) {
				sumEnergyCost += (amount * (Double.parseDouble(cursor
						.getString(0))));
			}
			waterData = getData(currentFormattedDayDate,
					Codes.ObjectType.WATER, Codes.Building.NURI);
			if (Double.isNaN(waterData) || waterData == 0) {
				wuTextView2.setText("일 평균 : -");
			} else {
				wuTextView2.setText("일 평균 : "
						+ String.valueOf(decimalFormat.format(waterData))
						+ "(Gcal)");
			}
			waterData = getData(lastMonthFormattedDate, Codes.ObjectType.WATER,
					Codes.Building.NURI);
			if (Double.isNaN(waterData) || waterData == 0) {
				wuTextView3.setText("전월 : -");
			} else {
				wuTextView3.setText("전월 : "
						+ String.valueOf(decimalFormat.format(waterData))
						+ "(Gcal)");
			}

			waterData = amount * electricityEmissionFactor
					* waterEmissionFactor;
			if (Double.isNaN(waterData) || waterData == 0) {
				wuTextView4.setText("TOE 환산 : -");
			} else {
				wuTextView4.setText("TOE 환산 : "
						+ String.valueOf(decimalFormat.format(waterData)));
			}

			electricityChart.getSettings().setJavaScriptEnabled(true);
			gasChart.getSettings().setJavaScriptEnabled(true);
			waterChart.getSettings().setJavaScriptEnabled(true);
			electricityChart.loadDataWithBaseURL(null,
					getTemplate(compareFormattedDate, "electricity"),
					"text/html", "utf-8", null);
			gasChart.loadDataWithBaseURL(null,
					getTemplate(compareFormattedDate, "gas"), "text/html",
					"utf-8", null);
			waterChart.loadDataWithBaseURL(null,
					getTemplate(compareFormattedDate, "water"), "text/html",
					"utf-8", null);

		} else if (currentBuildingId == "3") {
			double electricityData = getData(compareFormattedDate,
					Codes.ObjectType.ELECTRICITY, Codes.Building.SPRODUCE);
			amount = electricityData;
			if (Double.isNaN(electricityData) || electricityData == 0) {
				euTextView1.setText("현월 : -");
			} else {
				euTextView1.setText("현월 : "
						+ String.valueOf(decimalFormat.format(electricityData))
						+ "(kW)");
			}

			DBHelper db = new DBHelper(getActivity());
			String query = getEnergyCost(compareFormattedDate,
					Codes.ObjectType.ELECTRICITY, Codes.Building.SPRODUCE);
			Cursor cursor = dbHelper.getReadableDatabase()
					.rawQuery(query, null);
			cursor.moveToFirst();
			for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor
					.moveToNext()) {
				sumEnergyCost += (amount * (Double.parseDouble(cursor
						.getString(0))));
			}
			electricityData = getData(currentFormattedDayDate,
					Codes.ObjectType.ELECTRICITY, Codes.Building.SPRODUCE);
			if (Double.isNaN(electricityData) || electricityData == 0) {
				euTextView2.setText("일 평균 : -");
			} else {
				euTextView2.setText("일 평균 : "
						+ String.valueOf(decimalFormat.format(electricityData))
						+ "(kW)");
			}
			electricityData = getData(lastMonthFormattedDate,
					Codes.ObjectType.ELECTRICITY, Codes.Building.SPRODUCE);
			if (Double.isNaN(electricityData) || electricityData == 0) {
				euTextView3.setText("전월 : -");
			} else {
				euTextView3.setText("전월 : "
						+ String.valueOf(decimalFormat.format(electricityData))
						+ "(kW)");
			}

			electricityData = (amount * electricityCaloricValue) / crude;
			if (Double.isNaN(electricityData) || electricityData == 0) {
				euTextView4.setText("TOE 환산 : -");
			} else {
				euTextView4
						.setText("TOE 환산 : "
								+ String.valueOf(decimalFormat
										.format(electricityData)));
			}

			double gasData = getData(compareFormattedDate,
					Codes.ObjectType.GAS, Codes.Building.SPRODUCE);
			amount = gasData;
			if (Double.isNaN(gasData) || gasData == 0) {
				guTextView1.setText("현월 : -");
			} else {
				guTextView1.setText("현월 : "
						+ String.valueOf(decimalFormat.format(gasData))
						+ "(Nm3)");
			}

			db = new DBHelper(getActivity());
			query = getEnergyCost(compareFormattedDate, Codes.ObjectType.GAS,
					Codes.Building.SPRODUCE);
			cursor = dbHelper.getReadableDatabase().rawQuery(query, null);
			cursor.moveToFirst();
			for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor
					.moveToNext()) {
				sumEnergyCost += (amount * (Double.parseDouble(cursor
						.getString(0))));
			}
			gasData = getData(currentFormattedDayDate, Codes.ObjectType.GAS,
					Codes.Building.SPRODUCE);
			if (Double.isNaN(gasData) || gasData == 0) {
				guTextView2.setText("일 평균 : -");
			} else {
				guTextView2.setText("일 평균 : "
						+ String.valueOf(decimalFormat.format(gasData))
						+ "(Nm3)");
			}
			gasData = getData(lastMonthFormattedDate, Codes.ObjectType.GAS,
					Codes.Building.SPRODUCE);
			if (Double.isNaN(gasData) || gasData == 0) {
				guTextView3.setText("전월 : -");
			} else {
				guTextView3.setText("전월 : "
						+ String.valueOf(decimalFormat.format(gasData))
						+ "(Nm3)");
			}

			gasData = (amount * gasCaloricValue) / crude;
			if (Double.isNaN(gasData) || gasData == 0) {
				guTextView4.setText("TOE 환산 : -");
			} else {
				guTextView4.setText("TOE 환산 : "
						+ String.valueOf(decimalFormat.format(gasData)));
			}

			double waterData = getData(compareFormattedDate,
					Codes.ObjectType.WATER, Codes.Building.SPRODUCE);
			amount = waterData;
			if (Double.isNaN(waterData) || waterData == 0) {
				wuTextView1.setText("현월 : -");
			} else {
				wuTextView1.setText("현월 : "
						+ String.valueOf(decimalFormat.format(waterData))
						+ "(Gcal)");
			}

			db = new DBHelper(getActivity());
			query = getEnergyCost(compareFormattedDate, Codes.ObjectType.WATER,
					Codes.Building.SPRODUCE);
			cursor = dbHelper.getReadableDatabase().rawQuery(query, null);
			cursor.moveToFirst();
			for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor
					.moveToNext()) {
				sumEnergyCost += (amount * (Double.parseDouble(cursor
						.getString(0))));
			}
			waterData = getData(currentFormattedDayDate,
					Codes.ObjectType.WATER, Codes.Building.SPRODUCE);
			if (Double.isNaN(waterData) || waterData == 0) {
				wuTextView2.setText("일 평균 : -");
			} else {
				wuTextView2.setText("일 평균 : "
						+ String.valueOf(decimalFormat.format(waterData))
						+ "(Gcal)");
			}
			waterData = getData(lastMonthFormattedDate, Codes.ObjectType.WATER,
					Codes.Building.SPRODUCE);
			if (Double.isNaN(waterData) || waterData == 0) {
				wuTextView3.setText("전월 : -");
			} else {
				wuTextView3.setText("전월 : "
						+ String.valueOf(decimalFormat.format(waterData))
						+ "(Gcal)");
			}

			waterData = amount * electricityEmissionFactor
					* waterEmissionFactor;
			if (Double.isNaN(waterData) || waterData == 0) {
				wuTextView4.setText("TOE 환산 : -");
			} else {
				wuTextView4.setText("TOE 환산 : "
						+ String.valueOf(decimalFormat.format(waterData)));
			}

			electricityChart.getSettings().setJavaScriptEnabled(true);
			gasChart.getSettings().setJavaScriptEnabled(true);
			waterChart.getSettings().setJavaScriptEnabled(true);
			electricityChart.loadDataWithBaseURL(null,
					getTemplate(compareFormattedDate, "electricity"),
					"text/html", "utf-8", null);
			gasChart.loadDataWithBaseURL(null,
					getTemplate(compareFormattedDate, "gas"), "text/html",
					"utf-8", null);
			waterChart.loadDataWithBaseURL(null,
					getTemplate(compareFormattedDate, "water"), "text/html",
					"utf-8", null);

		}
		if (Double.isNaN(sumEnergyCost) || sumEnergyCost == 0) {
			sumTextView.setText(" -(원)");
		} else {
			sumTextView.setText(" "
					+ String.valueOf(decimalFormat.format(sumEnergyCost)
							+ "(원)"));
		}

		lastMonthCalendar.add(Calendar.MONTH, 1);
	}

	public String getTemplate(String compareFormattedDate, String webview) {
		final String[] dates = DBCursor.getDateList(compareFormattedDate);
		final Map<String, Codes.Detail> map = new HashMap<String, Codes.Detail>();
		String template = "";
		String currentBuildingId = Config.getInstance().getBuildingID();
		String[] buildingType =null;
		if (currentBuildingId.equals("1")) {
			buildingType = Codes.Building.ETRI;
		}
		if (currentBuildingId.equals("2")) {
			buildingType = Codes.Building.NURI;
		}
		if (currentBuildingId.equals("3")) {
			buildingType = Codes.Building.SPRODUCE;
		}
		// getTotalData(compareFormattedDate) : SELECT _id, OBJECT_TYPE_ID, SUM_DATA FROM dw_building_month WHERE _id IN ('15201502','15201501','15201412','15201402','25201502','25201501','25201412','25201402','35201502','35201501','35201412','35201402','16201502','16201501','16201412','16201402','26201502','26201501','26201412','26201402','36201502','36201501','36201412','36201402','17201502','17201501','17201412','17201402','27201502','27201501','27201412','27201402','37201502','37201501','37201412','37201402','18201502','18201501','18201412','18201402','28201502','28201501','28201412','28201402','38201502','38201501','38201412','38201402','19201502','19201501','19201412','19201402','29201502','29201501','29201412','29201402','39201502','39201501','39201412','39201402')
		for (Codes.Data data : getTotalData(compareFormattedDate, buildingType)) {
			String buildingId = StringUtils.substring(data.getDateValue(), 0, 1);
			String dateValue = StringUtils.substring(data.getDateValue(), 2);
			Codes.Detail detail = map.get(dateValue);
			if (detail == null) {
				detail = new Codes().new Detail();
			}
			detail.setup(data.getObjectTypeId(), data.getSumData());
			map.put(dateValue, detail);
		}
		// buildingId 별로 나눠야 함 webview
		if (webview == "electricity") {

			try {
				template = IOUtils.toString(getActivity().getAssets().open(
						"chart/ElectricityChart.html"));
				int i = 1;
				for (String date : dates) {
					Detail detail = map.get(date);
					if (detail == null) {
						detail = new Codes().new Detail();
					}
					template = StringUtils.replace(template,
							String.format("dataSet_electricity_value_%s", i),
							String.valueOf(detail.getElectricity()));
					i++;

				}
			} catch (IOException e) {
				Log.i("error but ignore", e.getMessage());
			}
		}
		if (webview == "gas") {
			try {
				template = IOUtils.toString(getActivity().getAssets().open(
						"chart/GasChart.html"));
				int i = 1;
				for (String date : dates) {
					Detail detail = map.get(date);
					if (detail == null) {
						detail = new Codes().new Detail();
					}
					template = StringUtils.replace(template,
							String.format("dataSet_gas_value_%s", i),
							String.valueOf(detail.getGas()));
					i++;

				}
			} catch (IOException e) {
				Log.i("error but ignore", e.getMessage());
			}
		}
		if (webview == "water") {
			try {
				template = IOUtils.toString(getActivity().getAssets().open(
						"chart/WaterChart.html"));
				int i = 1;
				for (String date : dates) {
					Detail detail = map.get(date);
					if (detail == null) {
						detail = new Codes().new Detail();
					}
					template = StringUtils.replace(template,
							String.format("dataSet_water_value_%s", i),
							String.valueOf(detail.getWater()));
					i++;

				}
			} catch (IOException e) {
				Log.i("error but ignore", e.getMessage());
			}
		}
		return template;
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.detailenergy, container,
				false);
		return rootView;
	}

}