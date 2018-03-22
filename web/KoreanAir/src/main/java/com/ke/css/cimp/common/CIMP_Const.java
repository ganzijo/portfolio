package com.ke.css.cimp.common;

import java.util.HashMap;

public class CIMP_Const {
	public static final HashMap<String, String> nonTagMap;
	static {
		nonTagMap = new HashMap<String, String>();	
		nonTagMap.put("_Sep", "_Sep");
		nonTagMap.put("_Typ", "_Typ");
		nonTagMap.put("_MId", "_MId");
		nonTagMap.put("_Sub", "_Sub");
		nonTagMap.put("_Grp", "_Grp");
		nonTagMap.put("_Hid", "_Hid");
		nonTagMap.put("_Had", "_Had");
	}
	
	public static final HashMap<String, String> nonDataMap;
	static {
		nonDataMap = new HashMap<String, String>();
		nonDataMap.put("_Sep", "_Sep");
		nonDataMap.put("_MId", "_MId");
		nonDataMap.put("_Hid", "_Hid");
		nonDataMap.put("_Had", "_Had");
		
	}
}
