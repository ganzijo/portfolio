package com.ke.css.controller;

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
public class ThreadTestController {
	@RequestMapping(value = "/threadvalidcheck", method = RequestMethod.POST)
	@ResponseBody
	public HttpEntity<byte[]>  getData(@RequestBody String data)
			throws NoSuchMethodException, NumberFormatException, ClassNotFoundException, InstantiationException,
			IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
		FindMethod findMethod = new FindMethod();
		String xmlData = "";
		@SuppressWarnings("unused")
		String srcData = data;
		data = data.replaceAll("\n", "\r\n");
		xmlData = findMethod.callMethod(data);
		
		xmlData = XmlWordWrap.prettyFormat(xmlData);
		System.out.println("xmlData : " + xmlData);

		byte[] documentBody = xmlData.getBytes();

	    HttpHeaders header = new HttpHeaders();
	    header.setContentType(new MediaType("application", "xml"));
	    header.setContentLength(documentBody.length);
		
	    
	    return new HttpEntity<byte[]>(documentBody, header);
	}
}
