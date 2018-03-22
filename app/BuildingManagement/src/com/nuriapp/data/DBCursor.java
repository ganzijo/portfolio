package com.nuriapp.data;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

public class DBCursor {

	public static final String SELECT_QUERY_MONTH = "SELECT sum(SUM_DATA) FROM dw_building_month WHERE _id IN (%s)";
	public static final String SELECT_QUERY_MONTH_TOTAL = "SELECT _id, OBJECT_TYPE_ID, SUM_DATA FROM dw_building_month WHERE _id IN (%s)";
	public static final String SELECT_QUERY_DAY_TOTAL = "SELECT _id, OBJECT_TYPE_ID, SUM_DATA, AVG_DATA FROM dw_building_day WHERE _id IN (%s)";
	public static final String SELECT_QUERY_DAY = "SELECT sum(SUM_DATA) FROM dw_building_day WHERE _id IN (%s)";
	public static final String SELECT_QUERY_AVG_TOTAL = "SELECT _id, OBJECT_TYPE_ID, SUM_DATA FROM dw_building_day WHERE _id IN (%s)";
	public static final String SELECT_QUERY_AREA = "SELECT _id, TOTAL_FLOOR_AREA FROM ocx_s_building WHERE _id IN (%s)";
	public static final String SELECT_QUERY_ENERGY_COST = "SELECT _id, energy_code, cost FROM ocx_s_energy_cost WHERE _id IN (%s)";
	public static final String SELECT_QUERY_BENCH_AREA = "SELECT code, area, si, gu, dong FROM ocx_s_g_building";
	public static final String SELECT_BUILDING_LIST = "SELECT A.building_name, A.amount, A.address, A.area FROM ocx_s_g_building A, ecas_object_code B";
	public static final String SELECT_BUILDING_DEFAULT_LIST = "SELECT building_name, amount, address, area FROM ocx_s_g_building";
	public static final String SELECT_BUILDING_AREA_VALUE = "SELECT min(area), max(area) FROM ocx_s_g_building";
	public static final String SELECT_USER_BUILDING_LIST = "SELECT * FROM ocx_s_building";
	public static final String SELECT_COMPARE_AMOUNT = "SELECT avg(amount) FROM ocx_s_g_building";
	public static final String SELECT_SAME_TYPE_AMOUNT = "SELECT avg(A.amount) FROM ocx_s_g_building A, ecas_object_code B WHERE A.code = substr(B.CODE,4)";
	public static final String SELECT_ENVIRONMENT_BUILDING_AMOUNT = "SELECT avg(A.amount) FROM ocx_s_g_building A, ecas_object_code B WHERE A.code = substr(B.CODE,4)";
	public static final String SELECT_KWHPER_AREA = "SELECT TOTAL_FLOOR_AREA FROM ocx_s_building";
	public static final String SELECT_MIN_DATE = "SELECT min(substr(_id,3)) FROM dw_building_month";
	public static final String SELECT_BENCH_AVG_QUERY = "SELECT avg(amount) FROM ocx_s_g_building WHERE date = '%s'";

	


	public static String getEnergyCostQuery(String[] objectTypes,
			String[] buildings, String date, String selectQuery) {
		List<String> ids = new ArrayList<String>();
		for (String objectType : objectTypes) {
			for (String building : buildings) {
				ids.add(String.format("'%s%s'", date, objectType));

			}
		}
		String joinStr = StringUtils.join(ids, ",");
		String query = String.format(selectQuery, joinStr);
		return query;
	}

	public static String getQuery(String date, String selectQuery,
			String[] objectTypes, String[] buildings) {
		List<String> ids = new ArrayList<String>();
		for (String objectType : objectTypes) {
			for (String building : buildings) {
				ids.add(String.format("'%s%s%s'", building, objectType, date));
			}
		}
		String joinStr = StringUtils.join(ids, ",");
		return String.format(selectQuery, joinStr);
	}

	public static String getDayAvgQuery(String date, String selectQuery,
			String[] objectTypes, String[] buildings) {
		List<String> ids = new ArrayList<String>();
		for (String objectType : objectTypes) {
			for (String building : buildings) {
				ids.add(String.format("'%s%s%s'", building, objectType, date));
			}
		}
		String joinStr = StringUtils.join(ids, ",");
		return String.format(selectQuery, joinStr);
	}

	public static String getMonthTotalQuery(String[] objectTypes,
			String[] buildings, String dates) {
		List<String> ids = new ArrayList<String>();
		for (String objectType : objectTypes) {
			for (String building : buildings) {
				for (String date : getDateList(dates)) {
					ids.add(String.format("'%s%s%s'", building, objectType,
							date));
				}
			}
		}

		String joinStr = StringUtils.join(ids, ",");
		String query = String
				.format(DBCursor.SELECT_QUERY_MONTH_TOTAL, joinStr);

		return query;
	}

	public static String[] getDateList(String date) {
		Date compare = null;
		try {
			compare = DateUtils.parseDate(date, "yyyyMM");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		DateFormat df = new SimpleDateFormat("yyyyMM");
		List<String> dateList = new ArrayList<String>();
		dateList.add(df.format(compare.getTime()));
		dateList.add(df.format(DateUtils.addMonths(compare, -1)));
		dateList.add(df.format(DateUtils.addMonths(compare, -2)));
		dateList.add(df.format(DateUtils.addYears(compare, -1)));
		return dateList.toArray(new String[dateList.size()]);
	}

}
