package com.nuriapp.test;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ChartDataVO {
	public String type = "mscolumn2d";
	public String renderAt = "chartContainer";
	public String width = "750";
	public String height = "600";
	public String dataFormat = "json";
	public DataSource dataSource = new DataSource();

	public static class DataSource {
		public Chart chart = new Chart();
		public List<Categories> categories = new ArrayList<Categories>();
		public List<Dataset> dataset = new ArrayList<Dataset>();
	}

	public static class Chart {
		public String caption = "Energy Consumption Information";
		public String xAxisname = "Monthly";
		public String yAxisName = "Usage";
		public String formatNumber = "1";
		public String formatNumberScale = "0";
		public String plotFillAlpha = "80";
		public String paletteColors = "#0000FF;#FFA500;#00FF00";
		public String baseFontColor = "#333333";
		public String baseFont = "Helvetica Neue;Arial";
		public String baseFontSize = "24";
		public String captionFontSize = "24";
		public String subcaptionFontSize = "14";
		public String subcaptionFontBold = "0";
		public String showBorder = "1";
		public String bgColor = "#ffffff";
		public String showShadow = "0";
		public String canvasBgColor = "#ffffff";
		public String canvasBorderAlpha = "0";
		public String divlineAlpha = "100";
		public String divlineColor = "#999999";
		public String divlineThickness = "1";
		public String divLineDashed = "1";
		public String divLineDashLen = "1";
		public String divLineGapLen = "1";
		public String usePlotGradientColor = "0";
		public String showplotborder = "0";
		public String valueFontColor = "#ffffff";
		public String placeValuesInside = "1";
		public String showHoverEffect = "1";
		public String rotateValues = "1";
		public String showXAxisLine = "1";
		public String xAxisLineThickness = "1";
		public String xAxisLineColor = "#999999";
		public String showAlternateHGridColor = "0";
		public String legendPosition = "RIGHT";
		public String legendBgAlpha = "0";
		public String legendBorderAlpha = "0";
		public String legendShadow = "0";
		public String legendItemFontSize = "24";
		public String legendItemFontColor = "#666666";
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
		public String seriesname;
		public List<Data> data = new ArrayList<Data>();

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
		public String value;

		public Data(String value) {
			super();
			this.value = value;
		}

	}

	public static void main(String[] args) {
		// ChartDataVO vo = new ChartDataVO();
		// Categories categories = new Categories();
		// categories.category.add(new Category("1"));
		// vo.dataSource.categories.add(categories);
		// Dataset dataset = new Dataset("11");
		// dataset.data.add(new Data("data1"));
		// vo.dataSource.dataset.add(dataset);

		Categories categories = new Categories();
		for (int i = 0; i < 12; i++) {
			categories.getCategory().add(new Category(String.valueOf(i)));
		}
		// List<Dataset> dataset = new ArrayList<ChartDataVO.Dataset>();
		// Dataset loop = new Dataset("");
		// for(int i=0; i<12; i++){
		// loop.data.add(new Data(String.valueOf(i)));
		// }
		// dataset.add(loop);

		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "{}";

		try {
			jsonString = mapper.writeValueAsString(categories);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		System.out.println(jsonString);

	}
}
