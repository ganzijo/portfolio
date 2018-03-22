package com.nuriapp.test;

import java.util.ArrayList;
import java.util.List;

public class LineDataVO {

	public static class Categories {
		public List<Category> category = new ArrayList<Category>();

		public List<Category> getCategories() {
			return category;
		}

		public void setCategories(List<Category> categories) {
			this.category = categories;
		}
	}

	public static class Category {
		private String label;

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		public Category(String label) {
			super();
			this.label = label;
		}
	}

	public class Dataset {
		private String seriesname;

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

		public List<Data> data = new ArrayList<Data>();
	}

	public class Data {
		private String value;

		public Data(String value) {
			super();
			this.value = value;
		}
	}

}
