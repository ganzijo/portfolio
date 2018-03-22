package com.ke.css.cimp.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XML_Maker {
	private String xmlData = "";
	StringBuffer sf = new StringBuffer(xmlData);
	static Pattern pattern = Pattern.compile(".*[a-z]{3}[0-9]{2}.*");
	Matcher matcher;
	/** XML add (data) **/
	public void addXmlData(String data) {
		sf.append(data);
	}

	/** XML add (tag) **/
	public void addXmlData(String ruleName, String data) {
		if (checkTag(ruleName)) {
			sf.append(data);
		}
	}

	/** return XML **/
	public String getXmlData() {
		return sf.toString();
	}

	/** check_nonTag **/
	public boolean checkTag(String ruleName) {
		boolean result = false;
		matcher = pattern.matcher(ruleName);
		String key = "";
		if(matcher.lookingAt()) {
			key = ruleName.substring(36, 40);
		}else
			key = ruleName.substring(35, 39);
		
		if(CIMP_Const.nonTagMap.get(key) != null)
			result = true;
		
		return !result;
	}

	/** check_nonData **/
	public boolean checkData(String ruleName) {
		boolean result = false;
		matcher = pattern.matcher(ruleName);
		String key = "";
		if(matcher.lookingAt()) {
			key = ruleName.substring(36, 40);
		}else
			key = ruleName.substring(35, 39);
		
		if (CIMP_Const.nonDataMap.get(key) != null)
			result = true;

		return !result;
	}
}
