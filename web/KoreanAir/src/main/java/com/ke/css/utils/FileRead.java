package com.ke.css.utils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileRead {
	public static void main(String[] args) {
		String FilePath = "C:\\ParserTest\\FHL5\\XmlDisplayer.java";
		
		try {
			File file = new File(FilePath);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line ="";
			String oldContent = "";
			
			while ((line = reader.readLine()) != null) {
				oldContent += line + System.lineSeparator();
			}
			
			reader.close();		
			
			String newContent = oldContent.replace("import java.util.ArrayList;", "import java.util.ArrayList;\r\nimport com.ke.css.cimp.common.XML_Maker;");
			newContent = newContent.replace("private boolean terminal = true;", "private boolean terminal = true;\r\n" + 
					"\r\n" + 
					"	private XML_Maker xmlMaker;\r\n" + 
					"\r\n" + 
					"	public XmlDisplayer(XML_Maker XML_Maker) {\r\n" + 
					"		this.xmlMaker = XML_Maker;\r\n" + 
					"	}");
			
			newContent = newContent.replace("  private Boolean visitRules(ArrayList<Rule> rules)\r\n" + 
					"  {\r\n" + 
					"    for (Rule rule : rules)\r\n" + 
					"      rule.accept(this);\r\n" + 
					"    return null;\r\n" + 
					"  }", "private Boolean visitRules(ArrayList<Rule> rules) {\r\n" + 
							"		for (Rule rule : rules) {\r\n" + 
							"			String ruleName = rule.getClass().toString();\r\n" + 
							"			if (xmlMaker.checkData(ruleName)) {\r\n" + 
							"				rule.accept(this);\r\n" + 
							"			}\r\n" + 
							"		}\r\n" + 
							"		return null;\r\n" + 
							"	}");
			
			newContent = newContent.replace("System.out.print(value.spelling);", "xmlMaker.addXmlData(value.spelling);");
			newContent = newContent.replace("System.out.println();", "xmlMaker.addXmlData(rule.getClass().toString(), \"\\n\");");
			newContent = newContent.replace("System.out.print(", "xmlMaker.addXmlData(rule.getClass().toString(),");
			
			FileWriter writer = new FileWriter(FilePath);
			writer.write(newContent);
			writer.close();
			System.out.println("Done");
			
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
