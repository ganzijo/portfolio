package com.ke.css.utils;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XML11Serializer;

public class XmlWordWrap {

	public static String prettyFormat(String xml){
		// TODO Auto-generated method stub
		String formattedString = null;
	     try {
	         final InputSource src = new InputSource(new StringReader(xml));
	         final Node document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(src).getDocumentElement();

	         // the last parameter sets indenting/pretty-printing to true
	         OutputFormat outputFormat = new OutputFormat("WHATEVER", "UTF-8", true);
	         // line width = 0 means no line wrapping
	         outputFormat.setLineWidth(0);
	         StringWriter sw = new StringWriter();
	         XML11Serializer writer = new XML11Serializer(sw, outputFormat);
	         writer.serialize((Element)document);
	         formattedString = sw.toString(); 

	     } catch (Exception e) {
	         throw new RuntimeException(e);
	     }
	     return formattedString;
	}

}
