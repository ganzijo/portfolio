package parserValidCheck;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PackageGet {
	static Pattern pattern = Pattern.compile(".*[a-z]{3}[0-9]{2}.*");
	
	static Matcher matcher;
	public static void main(String[] args) {
//		String ruleName = ".abc11";
		String ruleName = "class com.ke.css.cimp.fwb.fwb12.Rule_Typ_Text";
		
		matcher = pattern.matcher(ruleName);
		System.out.println(matcher.find());
		String key = "";
		System.out.println(matcher.lookingAt());
		if(matcher.lookingAt()) {
			key = ruleName.substring(36, 40);
		}else
			key = ruleName.substring(35, 39);
	}
}
//(^class \\.[a-z]{3}\\.[a-z]{2}\\.[a-z]{3}\\.[a-z]{4}\\.[a-z]{3}\\.[a-z]{3}[0-9]{2}\\.*[a-zA-Z0-9])