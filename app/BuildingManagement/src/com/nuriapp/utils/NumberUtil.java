package com.nuriapp.utils;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.apache.commons.lang3.math.NumberUtils;

public class NumberUtil extends NumberUtils {
	  public static String random(int size) {
	    DecimalFormat decimalFormat = new DecimalFormat(size(size));
	    decimalFormat.setRoundingMode(RoundingMode.DOWN);
	    return decimalFormat.format(Math.random() * Math.pow(10, size));
	  }

	  public static String format(double input, int size) {
	    DecimalFormat decimalFormat = new DecimalFormat(size(size));
	    return decimalFormat.format(input);
	  }

	  private static String size(int size) {
	    StringBuilder sb = new StringBuilder("0");
	    while (sb.length() < size) {
	      sb.append('0');
	    }
	    return sb.toString();
	  }
	}