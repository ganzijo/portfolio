package com.nuriapp.data;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DataSource {
	private List<Categories> categories = new ArrayList<Categories>();
	private List<Dataset> dataset = new ArrayList<Dataset>();
	private List<QueryData> queryDataList = new ArrayList<QueryData>();

	public List<QueryData> getQueryDataList() {
		return queryDataList;
	}

	public void setQueryDataList(List<QueryData> queryDataList) {
		this.queryDataList = queryDataList;
	}

	public List<Categories> getCategories() {
		return categories;
	}

	public void setCategories(List<Categories> categories) {
		this.categories = categories;
	}

	public List<Dataset> getDataset() {
		return dataset;
	}

	public void setDataset(List<Dataset> dataset) {
		this.dataset = dataset;
	}

	public static class Categories {
		private List<Category> category = new ArrayList<Category>();

		public List<Category> getCategory() {
			return category;
		}

		public void setCategory(List<Category> category) {
			this.category = category;
		}

	}

	public static class Category {
		private String label;

		public Category(String label) {
			super();
			this.label = label;
		}

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

	}

	public static class Dataset {
		private String seriesname;
		private List<Data> data = new ArrayList<Data>();

		public Dataset(String seriesname) {
			super();
			this.seriesname = seriesname;
		}

		public String getSeriesname() {
			return seriesname;
		}

		public void setSeriesname(String seriesname) {
			this.seriesname = seriesname;
		}

		public List<Data> getData() {
			return data;
		}

		public void setData(List<Data> data) {
			this.data = data;
		}

	}

	public static class Data {
		private String value;

		public Data(String value) {
			super();
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

	}

	public class LineChartData {
		private String id;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getObjectTypeId() {
			return objectTypeId;
		}

		public void setObjectTypeId(String objectTypeId) {
			this.objectTypeId = objectTypeId;
		}

		public String getSumData() {
			return sumData;
		}

		public void setSumData(String sumData) {
			this.sumData = sumData;
		}

		public double getAvgData() {
			return avgData;
		}

		public void setAvgData(double avgData) {
			this.avgData = avgData;
		}

		public double getElectricity() {
			return electricity;
		}

		public void setElectricity(double electricity) {
			this.electricity = electricity;
		}

		public double getGas() {
			return gas;
		}

		public void setGas(double gas) {
			this.gas = gas;
		}

		public double getWater() {
			return water;
		}

		public void setWater(double water) {
			this.water = water;
		}

		private String objectTypeId;
		private String sumData;
		private double avgData;
		private double electricity;
		private double gas;
		private double water;

		public void setup(String objectTypeId, String sumData, double avgData) {
			if (ArrayUtils.contains(Codes.ObjectType.ELECTRICITY, objectTypeId)) {
				this.electricity += NumberUtils.toDouble(sumData);
				this.avgData += avgData;
			} else if (ArrayUtils.contains(Codes.ObjectType.GAS, objectTypeId)) {
				this.gas += NumberUtils.toDouble(sumData);
				this.avgData += avgData;
			} else if (ArrayUtils
					.contains(Codes.ObjectType.WATER, objectTypeId)) {
				this.water += NumberUtils.toDouble(sumData);
				this.avgData += avgData;
			}
		}
	}

	public static class QueryData {

		private String id;
		private String objectTypeId;
		private String sumData;
		private String avgData;
		private double electricity;

		public double getElectricity() {
			return electricity;
		}

		public void setElectricity(double electricity) {
			this.electricity = electricity;
		}

		public double getGas() {
			return gas;
		}

		public void setGas(double gas) {
			this.gas = gas;
		}

		public double getWater() {
			return water;
		}

		public void setWater(double water) {
			this.water = water;
		}

		private double gas;
		private double water;

		public String getAvgData() {
			return avgData;
		}

		public void setAvgData(String avgData) {
			this.avgData = avgData;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getObjectTypeId() {
			return objectTypeId;
		}

		public void setObjectTypeId(String objectTypeId) {
			this.objectTypeId = objectTypeId;
		}

		public String getSumData() {
			return sumData;
		}

		public void setSumData(String sumData) {
			this.sumData = sumData;
		}

		public QueryData(String id, String objectTypeId, String sumData,
				String avgData) {
			super();
			this.id = id;
			this.objectTypeId = objectTypeId;
			this.sumData = sumData;
			this.avgData = avgData;
		}

		public void setup(String objectTypeId, String sumData) {
			if (ArrayUtils.contains(Codes.ObjectType.ELECTRICITY, objectTypeId)) {
				this.electricity += NumberUtils.toDouble(sumData);
			} else if (ArrayUtils.contains(Codes.ObjectType.GAS, objectTypeId)) {
				this.gas += NumberUtils.toDouble(sumData);
			} else if (ArrayUtils
					.contains(Codes.ObjectType.WATER, objectTypeId)) {
				this.water += NumberUtils.toDouble(sumData);
			}
		}

	}

	public class DayData {
		private String id;

		public DayData(String id, String objectTypeid, String sumData,
				String avgData) {
			super();
			this.id = id;
			this.objectTypeid = objectTypeid;
			this.sumData = sumData;
			this.avgData = avgData;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getObjectTypeid() {
			return objectTypeid;
		}

		public void setObjectTypeid(String objectTypeid) {
			this.objectTypeid = objectTypeid;
		}

		public String getSumData() {
			return sumData;
		}

		public void setSumData(String sumData) {
			this.sumData = sumData;
		}

		public String getAvgData() {
			return avgData;
		}

		public void setAvgData(String avgData) {
			this.avgData = avgData;
		}

		private String objectTypeid;
		private String sumData;
		private String avgData;
	}

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();

		// 라벨 넣어줄 부
		Categories categories = new Categories();
		for (int i = 0; i < 12; i++) {
			categories.getCategory().add(new Category(String.valueOf(i)));
		}

		// 데이터 셋 넣어줄 부
		List<Dataset> dataset = new ArrayList<Dataset>();
		for (int i = 0; i < 4; i++) {
			// 데이터 셋 타이틀 ( 평균,, 등등)
			Dataset loop = new Dataset(String.valueOf(i));

			// 데이터셋 세부 데이터 ( 라벨의 갯 수만큼 반복 )
			for (int y = 0; y < 12; y++) {
				loop.getData().add(new Data(String.valueOf(y)));
			}
			dataset.add(loop);
		}

		// 실제 파싱할 데이터 클래스에 위에서 입력한 데이터 선
		DataSource datasource = new DataSource();
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
		System.out.println(jsonString);

	}
}
