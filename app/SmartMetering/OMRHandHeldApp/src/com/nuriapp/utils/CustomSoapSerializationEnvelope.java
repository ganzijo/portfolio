	package com.nuriapp.utils;

import java.io.IOException;

import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.xmlpull.v1.XmlSerializer;

public class CustomSoapSerializationEnvelope extends SoapSerializationEnvelope{
	public CustomSoapSerializationEnvelope(int version) {
		super(version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void write(XmlSerializer writer) throws IOException {
		writer.setPrefix("soapenv", env); // <-- changed line
		writer.setPrefix("ser", "http://aimir.com/services");
		writer.startTag(env, "Envelope");
		writer.startTag(env, "Header");
		writeHeader(writer);
		writer.endTag(env, "Header");
		writer.startTag(env, "Body");
		writeBody(writer);
		writer.endTag(env, "Body");
		writer.endTag(env, "Envelope");
	}
}
