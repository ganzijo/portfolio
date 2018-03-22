package com.nuriapp.activity;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateUtils;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nuriapp.activitiy.R;
import com.nuriapp.adapter.BenchAdapter;
import com.nuriapp.backgroundtask.GasTaskProgress;
import com.nuriapp.data.BenchData;
import com.nuriapp.data.Codes;
import com.nuriapp.data.Config;
import com.nuriapp.data.DBCursor;
import com.nuriapp.data.DataSource;
import com.nuriapp.data.DataSource.Categories;
import com.nuriapp.data.DataSource.Category;
import com.nuriapp.data.DataSource.Data;
import com.nuriapp.data.DataSource.Dataset;
import com.nuriapp.data.DataSource.LineChartData;
import com.nuriapp.utils.DBHelper;
import com.nuriapp.utils.NumberUtil;

public class DetailGas extends Fragment {
	private ListView benchListView;
	private BenchAdapter benchAdapter;
	private DBHelper dbHelper;
	private Cursor cursor;
	private WebView gasChart;
	private Button benchmarking;
	private DecimalFormat decimalFormat;
	private SimpleDateFormat currentDateFormat, compareDateFormat, currentMonthDateFormat;
	private Button gasBeforeBtn, gasAfterBtn;
	private String currentFormattedDate, compareFormattedDate, lastMonthFormattedDate, maxFormattedDate, currentMonthFormattedDate;
	private TextView guNow, guCurrentMonthTextView,
			guCurrentMonth, guAvg, guLastMonth, guArea, guTemperatureHumidity,
			guType, guCost, gasCurrentDate;
	private Calendar calendar, lastMonthCalendar;
	private StringBuffer benchmarkQuery;
	private String currentBuildingId;
	private LineChartData lineChartData;
	public static FragmentActivity context;
	private double minDate, maxDate;

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Config config = Config.getInstance();
		currentBuildingId = config.getBuildingID();

		gasChart.loadDataWithBaseURL(
				null,
				getTemplate(compareFormattedDate, Codes.ObjectType.GAS, Config
						.getInstance().getBuildingID()), "text/html", "utf-8",
				null);

		StringBuffer compareQuery = new StringBuffer(
				DBCursor.SELECT_COMPARE_AMOUNT);

		compareQuery.append(" WHERE unit = 'MJ'");
		compareQuery.append(" AND area between ");
		compareQuery.append(config.getBuildingFloatArea() - 100);
		compareQuery.append(" AND ");
		compareQuery.append(config.getBuildingFloatArea() + 100);

		dbHelper = new DBHelper(getActivity());
		benchAdapter = new BenchAdapter();
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		cursor = db.rawQuery(compareQuery.toString(), null);
		cursor.moveToFirst();
		guArea.setText(cursor.getString(0) == null ? "-" : decimalFormat
				.format(NumberUtils.toDouble(cursor.getString(0))));

		StringBuffer sameTypeQuery = new StringBuffer(
				DBCursor.SELECT_SAME_TYPE_AMOUNT);
		sameTypeQuery.append(" AND A.unit = 'MJ'");
		cursor = db.rawQuery(sameTypeQuery.toString(), null);
		cursor.moveToFirst();
		guType.setText(cursor.getString(0) == null ? "-" : decimalFormat
				.format(NumberUtils.toDouble(cursor.getString(0))));

		StringBuffer environmentBuildingQuery = new StringBuffer(
				DBCursor.SELECT_ENVIRONMENT_BUILDING_AMOUNT);
		environmentBuildingQuery.append(" AND A.unit = 'MJ'");
		environmentBuildingQuery.append(" AND A.si = '" + config.getSiValue()
				+ "'");
		environmentBuildingQuery.append(" AND A.gu = '" + config.getGuValue()
				+ "'");
		environmentBuildingQuery.append(" AND A.dong = '"
				+ config.getDongValue() + "'");
		cursor = db.rawQuery(environmentBuildingQuery.toString(), null);
		cursor.moveToFirst();
		guAvg.setText(cursor.getString(0) == null ? "-" : decimalFormat
				.format(NumberUtils.toDouble(cursor.getString(0))));

		benchmarkQuery = new StringBuffer(DBCursor.SELECT_BUILDING_LIST);
		benchmarkQuery
				.append(" WHERE A.code = substr(B.CODE,4) AND A.unit = 'MJ'");
		if (config.isBuildingTypeEnabled()) {
			// 다른 값이 있을 경우
			// benchmarkQuery.append(" WHERE A.code =");
			// benchmarkQuery.append(" substr(B.CODE,4)");
			// benchmarkQuery.append(" AND B.NAME = " +
			// searchDataVO.getBenchmarkBuildingType());
			// benchmarkQuery.append("('" +
			// searchDataVO.getBenchmarkBuildingType() + "')");
			//
			benchmarkQuery.append(" AND A.object_code = 1"); // 다른 값이 없어 기본값으
																// 설정함 ( 원래 컬럼은
																// code 이나, 별도의
																// 데이터 구분이 없는
																// 관계로 )
		}
		if (config.isBuildingUseEnabled()) {
			benchmarkQuery.append(" AND B.NAME = '" + config.getBuildingUse()
					+ "'");
		}
		if (config.isAddressEnabled()) {
			if (config.isSiEnabled()) {
				benchmarkQuery.append(" AND A.si = '" + config.getSiValue()
						+ "'");
			}
			if (config.isGuEnabled()) {
				benchmarkQuery.append(" AND A.gu = '" + config.getGuValue()
						+ "'");
			}
			if (config.isDongEnabled()) {
				benchmarkQuery.append(" AND A.dong = '" + config.getDongValue()
						+ "'");
			}
		}
		if (config.isAreaEnabled()) {
			benchmarkQuery.append(" AND A.area between ");
			benchmarkQuery.append(config.getMinValue());
			benchmarkQuery.append(" AND ");
			benchmarkQuery.append(config.getMaxValue());
		}

		Log.i("benchmarkQuery", benchmarkQuery.toString());

		dbHelper = new DBHelper(getActivity());
		benchAdapter = new BenchAdapter();
		db = dbHelper.getReadableDatabase();
		cursor = db.rawQuery(benchmarkQuery.toString(), null);
		benchListView = (ListView) getActivity()
				.findViewById(R.id.GasBenchList);
		context = getActivity();
		new GasTaskProgress().execute(cursor);
	}

	/** Called when the activity is first created. */
	@SuppressLint("SetJavaScriptEnabled")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	public void onStart() {
		super.onStart();
		final Config config = Config.getInstance();
		final AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
		currentBuildingId = config.getBuildingID();
		benchmarking = (Button) getActivity()
				.findViewById(R.id.GasBenchmarking);
		guNow = (TextView) getActivity().findViewById(R.id.GUNow);
		guCurrentMonthTextView = (TextView) getActivity().findViewById(
				R.id.GUCurrentMonthTextView);
		guCurrentMonth = (TextView) getActivity().findViewById(
				R.id.GUCurrentMonth);
		guAvg = (TextView) getActivity().findViewById(R.id.GUAvg);
		guLastMonth = (TextView) getActivity().findViewById(R.id.GULastMonth);
		guArea = (TextView) getActivity().findViewById(R.id.GUArea);
		guTemperatureHumidity = (TextView) getActivity().findViewById(
				R.id.GUTemperatureHumidity);
		guType = (TextView) getActivity().findViewById(R.id.GUType);
		guCost = (TextView) getActivity().findViewById(R.id.GUCost);
		gasCurrentDate = (TextView)getActivity().findViewById(R.id.GasCurrentDateTextView);
		gasBeforeBtn = (Button)getActivity().findViewById(R.id.GasBeforeBtn);
		gasAfterBtn = (Button)getActivity().findViewById(R.id.GasAfterBtn);

		calendar = Calendar.getInstance();
		lastMonthCalendar = Calendar.getInstance();
		currentDateFormat = new SimpleDateFormat("yyyy" + "년" + "MM" + "월");
		currentFormattedDate = currentDateFormat.format(calendar.getTime());
		
		currentMonthDateFormat = new SimpleDateFormat("MM" + "월");
		currentMonthFormattedDate = currentMonthDateFormat.format(calendar
				.getTime());

		compareDateFormat = new SimpleDateFormat("yyyyMM");
		compareFormattedDate = compareDateFormat.format(calendar.getTime());
		
		lastMonthFormattedDate = compareDateFormat.format(lastMonthCalendar
				.getTime());
		maxFormattedDate = compareDateFormat.format(calendar.getTime());

		decimalFormat = new DecimalFormat("#,###.##");

		gasChart = new WebView(getActivity());

		gasChart = (WebView) getActivity().findViewById(R.id.GasChart);
		
		gasCurrentDate.setText(currentFormattedDate + " ");

		gasChart.getSettings().setJavaScriptEnabled(true);

		gasChart.loadDataWithBaseURL(
				null,
				getTemplate(compareFormattedDate, Codes.ObjectType.GAS, Config
						.getInstance().getBuildingID()), "text/html", "utf-8",
				null);
		
		
		dbHelper = new DBHelper(getActivity());
		Cursor cursor = dbHelper.getReadableDatabase().rawQuery(
				DBCursor.SELECT_MIN_DATE, null);
		cursor.moveToFirst();
		minDate = Double.parseDouble(cursor.getString(0));
		maxDate = Double.parseDouble(maxFormattedDate);
		cursor.close();
		
		

		guCurrentMonthTextView.setText("현월(" + currentMonthFormattedDate + ") :");

		double gasNow = NumberUtils.toDouble((getQuery(Codes.ObjectType.GAS,
				ArrayUtils.toArray(currentBuildingId))));
		if (gasNow != 0) {
			guNow.setText(String.valueOf(decimalFormat.format(gasNow)));
		} else
			guNow.setText("-");

		double gasMonth = getData(compareFormattedDate, Codes.ObjectType.GAS,
				ArrayUtils.toArray(currentBuildingId));
		if(Double.isNaN(gasMonth)||gasMonth==0){
			guCurrentMonth.setText("-");
		}else{
			guCurrentMonth.setText(String.valueOf(decimalFormat.format(gasMonth)));
		}
		

		compareFormattedDate = compareDateFormat.format(DateUtils.addMonths(
				calendar.getTime(), -1));
		double gasLastMonth = getData(compareFormattedDate,
				Codes.ObjectType.GAS, ArrayUtils.toArray(currentBuildingId));
		if(Double.isNaN(gasLastMonth)||gasLastMonth==0){
			guLastMonth.setText("-");
		}else{
			guLastMonth.setText(String.valueOf(decimalFormat.format(gasLastMonth)));
		}
		

		compareFormattedDate = compareDateFormat.format(calendar.getTime());

		// SELECT_QUERY_DAY_TOTAL
		dbHelper = new DBHelper(getActivity());
		
		String query = getQuery(Codes.ObjectType.TEMPERATURE,
				Codes.Building.ETRI); // default
		;
		if (currentBuildingId.equals("1")) {
			query = getQuery(Codes.ObjectType.TEMPERATURE, Codes.Building.ETRI);
		}
		if (currentBuildingId.equals("2")) {
			query = getQuery(Codes.ObjectType.TEMPERATURE, Codes.Building.NURI);
		}
		if (currentBuildingId.equals("3")) {
			query = getQuery(Codes.ObjectType.TEMPERATURE,
					Codes.Building.SPRODUCE);
		}
		cursor = dbHelper.getReadableDatabase().rawQuery(query, null);
		cursor.moveToFirst();
		if (cursor.getCount() != 0) {
			for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor
					.moveToNext()) {
				guTemperatureHumidity.setText(cursor.getString(3));
			}
		} else
			guTemperatureHumidity.setText("-");

		// 201401 -> compareFormattedDate
		double guCostValue = getEnergyCostData(compareFormattedDate,
				Codes.ObjectType.GAS);
		guCost.setText(String.valueOf(NumberUtils.toInt(String.valueOf(gasNow * guCostValue))) + "(원)");
		// 기존
		benchmarking.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				config.setAddressEnabled(false);
				config.setAreaEnabled(false);
				config.setBuildingTypeEnabled(false);
				config.setBuildingUseEnabled(false);
				config.setSiEnabled(false);
				config.setGuEnabled(false);
				config.setDongEnabled(false);
				Intent intent = new Intent(getActivity(), Benchmark.class);
				startActivity(intent);
			}
		});

		dbHelper = new DBHelper(getActivity());
		benchAdapter = new BenchAdapter();
		cursor = dbHelper.getReadableDatabase().rawQuery(DBCursor.SELECT_BUILDING_LIST
				+ " WHERE A.code = substr(B.CODE, 4) AND A.unit = 'MJ'", null);
		benchListView = (ListView) getActivity()
				.findViewById(R.id.GasBenchList);
		context = getActivity();
		new GasTaskProgress().execute(cursor);
		
		
		
		gasBeforeBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if (minDate <= Double.parseDouble(compareFormattedDate)) {
					calendar.add(Calendar.MONTH, -1);
					lastMonthCalendar.add(Calendar.MONTH, -2);
					currentFormattedDate = currentDateFormat.format(calendar
							.getTime());
					compareFormattedDate = compareDateFormat.format(calendar
							.getTime());
					currentMonthFormattedDate = currentMonthDateFormat.format(calendar.getTime());
//					currentFormattedDayDate = currentDayDateFormat
//							.format(calendar.getTime());
					lastMonthFormattedDate = compareDateFormat
							.format(lastMonthCalendar.getTime());
					gasCurrentDate.setText(currentFormattedDate + " ");//상단에 찍히는 날짜 (2015년02월)
					//여기부터 현월
					guCurrentMonthTextView.setText("현월(" + currentMonthFormattedDate
							+ ") :");
					
					double gasMonth = getData(compareFormattedDate, Codes.ObjectType.GAS,
							ArrayUtils.toArray(currentBuildingId));
					if(Double.isNaN(gasMonth)||gasMonth==0){
						guCurrentMonth.setText("-");
					}else{
						guCurrentMonth.setText(String.valueOf(decimalFormat.format(gasMonth)));
					}
					//여기부터 전월
					lastMonthFormattedDate = compareDateFormat.format(DateUtils.addMonths(
							lastMonthCalendar.getTime(), 0));
					double gasLastMonth = getData(lastMonthFormattedDate,
							Codes.ObjectType.GAS, ArrayUtils.toArray(currentBuildingId));
					if(Double.isNaN(gasLastMonth)||gasLastMonth==0){
						guLastMonth.setText("-");
					}else{
						guLastMonth.setText(String.valueOf(decimalFormat.format(gasLastMonth)));
					}
					///////////// 지금부터 차트
					gasChart.loadDataWithBaseURL(
							null,
							getTemplate(compareFormattedDate,
									Codes.ObjectType.GAS, Config
											.getInstance().getBuildingID()),
							"text/html", "utf-8", null);
					/////////////
					
					
					lastMonthCalendar.add(Calendar.MONTH, 1);
				}else {
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
		
		gasAfterBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (Double.parseDouble(compareFormattedDate) < maxDate) {
					calendar.add(Calendar.MONTH, 1);

					currentFormattedDate = currentDateFormat.format(calendar
							.getTime());
					compareFormattedDate = compareDateFormat.format(calendar
							.getTime());
					currentMonthFormattedDate = currentMonthDateFormat.format(calendar.getTime());
//					currentFormattedDayDate = currentDayDateFormat
//							.format(calendar.getTime());
					lastMonthFormattedDate = compareDateFormat
							.format(lastMonthCalendar.getTime());
					gasCurrentDate.setText(currentFormattedDate + " ");//상단에 찍히는 날짜 (2015년02월)
					
					//여기부터 현월
					guCurrentMonthTextView.setText("현월(" + currentMonthFormattedDate
							+ ") :");
					
					double gasMonth = getData(compareFormattedDate, Codes.ObjectType.GAS,
							ArrayUtils.toArray(currentBuildingId));
					if(Double.isNaN(gasMonth)||gasMonth==0){
						guCurrentMonth.setText("-");
					}else{
						guCurrentMonth.setText(String.valueOf(decimalFormat.format(gasMonth)));
					}
					//여기부터 전월
					lastMonthFormattedDate = compareDateFormat.format(DateUtils.addMonths(
							lastMonthCalendar.getTime(), 0));
					double gasLastMonth = getData(lastMonthFormattedDate,
							Codes.ObjectType.GAS, ArrayUtils.toArray(currentBuildingId));
					if(Double.isNaN(gasLastMonth)||gasLastMonth==0){
						guLastMonth.setText("-");
					}else{
						guLastMonth.setText(String.valueOf(decimalFormat.format(gasLastMonth)));
					}
					///////////// 지금부터 차트
					gasChart.loadDataWithBaseURL(
							null,
							getTemplate(compareFormattedDate,
									Codes.ObjectType.GAS, Config
											.getInstance().getBuildingID()),
							"text/html", "utf-8", null);
					/////////////
					
					
					
					
					lastMonthCalendar.add(Calendar.MONTH, 1);

				}else {
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

	public double getEnergyCostData(String date, String[] objectType) {
		dbHelper = new DBHelper(getActivity());
		String query = DBCursor.getEnergyCostQuery(objectType,
				Codes.Building.ALL, date, DBCursor.SELECT_QUERY_ENERGY_COST);
		Cursor cursor = dbHelper.getReadableDatabase().rawQuery(query, null);

		cursor.moveToFirst();
		double result = 0;
		for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
			result = NumberUtils.toDouble(cursor.getString(2));
		}
		return result;
	}

	public List<Codes.Data> getTotalData(String date) {
		List<Codes.Data> list = new ArrayList<Codes.Data>();
		String query = DBCursor.getMonthTotalQuery(Codes.ObjectType.ALL,
				Codes.Building.ALL, date);
		Cursor cursor = dbHelper.getReadableDatabase().rawQuery(query, null);

		cursor.moveToFirst();

		for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
			list.add(new com.nuriapp.data.Codes.Data(cursor.getString(0), cursor
					.getString(1), cursor.getString(2)));
		}

		return list;
	}

	public String getTemplate(String compareFormattedDate, String[] energyType,
			String building) {
		int dayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		ObjectMapper mapper = new ObjectMapper();
		Categories categories = new Categories();
		DataSource datasource = new DataSource();
		String query = "";
		// String benchAvgQuery = String.format(DBCursor.SELECT_BENCH_AVG_QUERY,
		// "201304");
		String benchAvgQuery = String.format(DBCursor.SELECT_BENCH_AVG_QUERY,
				compareFormattedDate);
		dbHelper = new DBHelper(getActivity());
		Cursor benchCursor = dbHelper.getReadableDatabase().rawQuery(
				benchAvgQuery, null);
		benchCursor.moveToFirst();

		dbHelper = new DBHelper(getActivity());
		if (building.equals("1")) {
			query = getQuery(energyType, Codes.Building.ETRI);
		} else if (building.equals("2")) {
			query = getQuery(energyType, Codes.Building.NURI);
		} else if (building.equals("3")) {
			query = getQuery(energyType, Codes.Building.SPRODUCE);
		}

		// SELECT _id, OBJECT_TYPE_ID, SUM_DATA, AVG_DATA FROM dw_building_day
		// WHERE _id IN
		// ('1520150201','1620150201','1720150201','1520150202','1620150202','1720150202','1520150203','1620150203','1720150203','1520150204','1620150204','1720150204','1520150205','1620150205','1720150205','1520150206','1620150206','1720150206','1520150207','1620150207','1720150207','1520150208','1620150208','1720150208','1520150209','1620150209','1720150209','1520150210','1620150210','1720150210','1520150211','1620150211','1720150211','1520150212','1620150212','1720150212','1520150213','1620150213','1720150213','1520150214','1620150214','1720150214','1520150215','1620150215','1720150215','1520150216','1620150216','1720150216','1520150217','1620150217','1720150217','1520150218','1620150218','1720150218','1520150219','1620150219','1720150219','1520150220','1620150220','1720150220','1520150221','1620150221','1720150221','1520150222','1620150222','1720150222','1520150223','1620150223','1720150223','1520150224','1620150224','1720150224','1520150225','1620150225','1720150225','1520150226','1620150226','1720150226','1520150227','1620150227','1720150227','1520150228','1620150228','1720150228')
		Cursor cursor = dbHelper.getReadableDatabase().rawQuery(query, null);
		cursor.moveToFirst();
		Map<String, DataSource.LineChartData> maps = new HashMap<String, DataSource.LineChartData>();
		List<String> idList = new ArrayList<String>();
		String id = "";
		for (DataSource.DayData dayData : getDayTotalData(compareFormattedDate,
				query)) {
			int countId = 0;
			id = StringUtils.substring(dayData.getId(), dayData.getId()
					.length() - 2);
			idList.add(id);
			DataSource.LineChartData lineChartData = maps.get(id);
			if (lineChartData == null) {
				lineChartData = new DataSource().new LineChartData();
			}
			lineChartData.setup(dayData.getObjectTypeid(),
					dayData.getSumData(),
					Double.parseDouble(dayData.getAvgData()));
			maps.put(id, lineChartData);
			countId++;
		}

		HashSet hashSetList = new HashSet(idList);
		// ArrayList 형태로 다시 생성

		ArrayList<String> distinctIdList = new ArrayList<String>(hashSetList);
		Collections.sort(distinctIdList);

		List<String> dateList = new ArrayList<String>();
		for (int i = 1; i < calendar.getActualMaximum(Calendar.DAY_OF_MONTH) + 1; i++) {
			categories.getCategory().add(new Category(String.valueOf(i)));
			dateList.add(NumberUtil.format(i, 2));
		}

		// 사용량(Nm3)
		List<Dataset> dataset = new ArrayList<Dataset>();
		String[] seriesnames = { "사용량(Nm3)", "평균", "벤치마크 평균" };
		for (int i = 0; i < 3; i++) {
			Dataset loop = new Dataset(seriesnames[i]);

			if (i == 0) {
				for (String date : dateList) {
					LineChartData data = maps.get(date);
					if (data == null) {
						loop.getData().add(new Data("0"));
					} else {
						loop.getData()
								.add(new Data(String.valueOf(data
										.getGas())));
					}
				}
				dataset.add(loop);

			}
			if (i == 1) {
				int count = 0;
				for (String date : dateList) {
					LineChartData data = maps.get(date);
					if (data == null) {
						loop.getData().add(new Data("0"));
					} else {
						loop.getData().add(
								new Data(String.valueOf(data.getAvgData())));
					}
				}
				dataset.add(loop);
			}
			if (i == 2) {
				if (benchCursor.getCount() != 0 && benchCursor != null) {
					for (String date : dateList) {
						try {
							loop.getData().add(
									new Data(String.valueOf(Integer
											.parseInt(benchCursor.getString(0))
											/ dayOfMonth)));
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					}
				} else {
					for (String date : dateList) {
						loop.getData().add(new Data("0"));
					}
				}
				dataset.add(loop);
			}
		}

		// 실제 파싱할 데이터 클래스에 위에서 입력한 데이터 선택

		datasource.getCategories().add(categories);
		datasource.setDataset(dataset);

		String jsonString = "";
		try {
			jsonString = mapper.writeValueAsString(datasource);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		// 앞 뒤 {} 짜르기 위한 로직
		jsonString = StringUtils.removeStart(jsonString, "{");
		jsonString = StringUtils.removeEnd(jsonString, "}");

		// Data 바꿔치기
		String template = "";
		try {
			template = IOUtils.toString(getActivity().getAssets().open(
					"chart/GasUsingStatus.html"));
			template = StringUtils.replace(template, "<inputData>", jsonString);
		} catch (IOException e) {
			Log.i("error but ignore", e.getMessage());
		}

		return template;
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

	public List<DataSource.DayData> getDayTotalData(String date,
			String selectQuery) {
		List<DataSource.DayData> list = new ArrayList<DataSource.DayData>();
		Cursor cursor = dbHelper.getReadableDatabase().rawQuery(selectQuery,
				null);

		cursor.moveToFirst();
		for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
			list.add(new DataSource().new DayData(cursor.getString(0), cursor
					.getString(1), cursor.getString(2), cursor.getString(3)));
		}
		return list;
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.detailgas, container, false);
		return rootView;
	}

}
