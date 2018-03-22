package com.ke.css.controller;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ke.css.method.FindMethod;
import com.ke.css.utils.XmlWordWrap;

@RestController
public class MethodController {
	@RequestMapping(value = "/validcheck", method = RequestMethod.POST)
	@ResponseBody
	public HttpEntity<byte[]>  getData(@RequestBody String data)
			throws NoSuchMethodException, NumberFormatException, ClassNotFoundException, InstantiationException,
			IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
		FindMethod findMethod = new FindMethod();
		String xmlData = "";
		data = data.split("=")[1];
		data = data.replaceAll("%0D", "\r");
		data = data.replaceAll("%0A", "\n");
		data = data.replace('+', ' ');
		data = data.replaceAll("%2F", "/");
		//System.out.println("data = " + data);
		String srcData = data;
		try
		{
		xmlData = findMethod.callMethod(data);
		}
		catch (Exception e)
		{
			try {
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				PrintStream pinrtStream = new PrintStream(out);
				e.printStackTrace(pinrtStream);

				xmlData = "<ERROR><ERRORMessage>" + out.toString() + "</ERRORMessage>" + 
						"<InputData>" + srcData + "</InputData></ERROR>";

			}
			catch (Exception ee)
			{
				ee.printStackTrace();
				xmlData = "<ERROR><ERRORMessage>" + "Parsing Module Error!" + "</ERRORMessage>" + 
						"<InputData>" + srcData + "</InputData></ERROR>";
			}
		}
		xmlData = XmlWordWrap.prettyFormat(xmlData);
		System.out.println("xmlData : " + xmlData);
		byte[] documentBody = xmlData.getBytes();

	    HttpHeaders header = new HttpHeaders();
	    header.setContentType(new MediaType("application", "xml"));
	    header.setContentLength(documentBody.length);
		
	    return new HttpEntity<byte[]>(documentBody, header);
	}
}
