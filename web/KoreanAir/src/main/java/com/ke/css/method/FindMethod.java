package com.ke.css.method;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ke.css.cimp.common.XML_Maker;
import com.ke.css.cimp.vo.DocVo;
import com.ke.css.cimp.vo.ObjectVo;

import parserValidCheck.FNADataParsingTest;

public class FindMethod {
	private DocVo docVo = new DocVo();
	private ObjectVo objVo = new ObjectVo();

	public String callMethod(String data) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		String[] dataArr = data.split("\r\n");
		String parsedData = headerParsing(dataArr);
		if (parsedData == null) {
			divideData(data);
		} else
			divideData(parsedData);
		Class<?> ruleCls = Class.forName("com.ke.css.cimp." + docVo.getDocName() + "." + docVo.getDocIdArr() + ".Rule");
		Class<?> parserCls = Class
				.forName("com.ke.css.cimp." + docVo.getDocName() + "." + docVo.getDocIdArr() + ".Parser");
		Class<?> xmlDisplayerCls = Class
				.forName("com.ke.css.cimp." + docVo.getDocName() + "." + docVo.getDocIdArr() + ".XmlDisplayer");
		Class<?> visitorCls = Class
				.forName("com.ke.css.cimp." + docVo.getDocName() + "." + docVo.getDocIdArr() + ".Visitor");
		objVo.setParserMethod(parserCls.getMethod("parse", String.class, String.class));
		objVo.setParserObj(objVo.getParserMethod().invoke(parserCls, "MESSAGE", docVo.getDocFull()));

		XML_Maker XML_FHL = new XML_Maker();

		// xmlDisplayer를 통한 xmlData make
		Constructor<?>[] constructors = xmlDisplayerCls.getDeclaredConstructors();
		for (Constructor<?> constructor : constructors) {
			objVo.setXmlDisplayerObj(constructor.newInstance(XML_FHL));
		}

		objVo.setRuleMethod(ruleCls.getMethod("accept", visitorCls));
		objVo.getRuleMethod().invoke(objVo.getParserObj(), objVo.getXmlDisplayerObj());
		// System.out.println(XML_FHL.getXmlData());

		return XML_FHL.getXmlData();
	}

	public String headerParsing(String[] dataArr) {
		String parsedData = null;
		Pattern pattern = Pattern.compile("(^\\.[a-zA-Z0-9]{7})");

		for (int i = 0; i < dataArr.length; i++) {
			// System.out.println(dataArr[i]);
			Matcher matcher = pattern.matcher(dataArr[i]);
			if (matcher.lookingAt() && i == 1) {// 일반적인 헤더일 경우
				generalHeader(dataArr);
				return parsedData;
			} else if (matcher.lookingAt() && i > 1) {
				return parsedData = multiRowHeader(dataArr, i);
			}

		}
		parsedData = dummyHeader(dataArr);

		return parsedData;

	}

	public void generalHeader(String[] dataArr) {
		docVo.setDocIdArr(dataArr[2].split("/"));
		docVo.setDocName(docVo.getDocIdArr()[0].toLowerCase());
		docVo.setDocVer(docVo.getDocIdArr()[1].toLowerCase());
		docVo.setDocId(docVo.getDocName() + docVo.getDocVer());
		System.out.println("DocId : " + docVo.getDocIdArr());
		System.out.println("General Header");
	}

	public String multiRowHeader(String[] dataArr, int lastLine) {
		docVo.setDocIdArr(dataArr[lastLine + 1].split("/"));
		docVo.setDocName(docVo.getDocIdArr()[0].toLowerCase());
		docVo.setDocVer(docVo.getDocIdArr()[1].toLowerCase());
		docVo.setDocId(docVo.getDocName() + docVo.getDocVer());
		System.out.println("DocId : " + docVo.getDocIdArr());
		System.out.println("MultiRow Header");
		String modify = dataArr[0] + "\r\n" + dataArr[lastLine];
		for (int i = lastLine + 1; i < dataArr.length; i++) {
			modify = modify + "\r\n" + dataArr[i];
		}
		System.out.println(modify);
		return modify;
	}

	public String dummyHeader(String[] dataArr) {
		docVo.setDocIdArr(dataArr[0].split("/"));
		docVo.setDocName(docVo.getDocIdArr()[0].toLowerCase());
		docVo.setDocVer(docVo.getDocIdArr()[1].toLowerCase());
		docVo.setDocId(docVo.getDocName() + docVo.getDocVer());
		System.out.println("DocId : " + docVo.getDocIdArr());
		System.out.println("Dummy Header");
		String dummyData = "QK XXDUMMY" + "\r\n" + ".XXDUMMY";

		String modify = dummyData;
		for (int i = 0; i < dataArr.length; i++) {
			modify = modify + "\r\n" + dataArr[i];
		}
		System.out.println(modify);
		return modify;
	}

	public String getDocType(String DocName) {
		if (DocName.equals("fhl") || DocName.equals("fwb") || DocName.equals("ffm") || DocName.equals("ffr")
				|| DocName.equals("fbl") || DocName.equals("fna") || DocName.equals("fum")) {
			return "CIMP";
		} else if (DocName.equals("")) {
			return "AHM";
		} else if (DocName.equals("")) {
			return "AMS";
		}
		return null;
	}

	public String getGUID() {
		return "12345123451234512345123451234512345";
	}

	public void divideData(String data) {
		String[] parsedArr = data.split("\r\n");
		String ifHubRefKey = getGUID();
		String DocType = getDocType(docVo.getDocName());
		String DocSubType = docVo.getDocName();
		String DocReceiver = parsedArr[0];
		System.out.println("DocReceiver : " + DocReceiver);
		String DocSender = parsedArr[1].substring(1, 8);
		String sep_slant = "/";
		String[] getErrDoc = null;
		String recvDocDetail = "";
		String recvFnaErrDocType = "";
		String recvFnaDocVer = "";
		String recvFnaMawbNumber = "";
		String recvFnaHawbNumber = "";
		docVo.setDocHeader(ifHubRefKey + sep_slant + DocType + sep_slant + DocSubType.toUpperCase() + sep_slant
				+ DocReceiver + sep_slant + DocSender + "\r\n");

		if (DocSubType.equals("fna")) {
			for (int i = 0; i < parsedArr.length; i++) {
				if (i < 2) {
				} else if (i == 2) {
					docVo.setDocBody(parsedArr[i]);
				} else if (i > 2 && i < 5) {
					docVo.setDocBody(docVo.getDocVer() + "\r\n" + parsedArr[i]);
				} else if (i == 5) {
					getErrDoc = parsedArr[i].split("/");
					recvFnaErrDocType = getErrDoc[0];
					recvFnaDocVer = getErrDoc[1];
					recvDocDetail = recvDocDetail + parsedArr[i] + "\r\n";
				} else if (i == 6) {
					if (recvFnaErrDocType.equals("FHL")) {
						recvFnaMawbNumber = parsedArr[i].substring(4, 16);
						recvDocDetail = recvDocDetail + parsedArr[i] + "\r\n";
					} else {
						recvFnaMawbNumber = parsedArr[i].substring(0, 12);
						recvDocDetail = recvDocDetail + parsedArr[i] + "\r\n";
					}
				} else if (i == 7) {
					if (recvFnaErrDocType.equals("FHL")) {
						recvFnaHawbNumber = parsedArr[i].substring(4, 13);
						recvDocDetail = recvDocDetail + parsedArr[i] + "\r\n";
					} else {
						recvFnaHawbNumber = "";
						recvDocDetail = recvDocDetail + parsedArr[i] + "\r\n";
					}
				} else if (i > 5) {
					recvDocDetail = recvDocDetail + parsedArr[i] + "\r\n";
				}
			}

			if (recvFnaHawbNumber.equals("")) {
				docVo.setDocBody(docVo.getDocBody() + "\r\n" + recvFnaErrDocType + sep_slant + recvFnaDocVer + sep_slant
						+ recvFnaMawbNumber + "\r\n" + recvDocDetail);
			} else {
				docVo.setDocBody(docVo.getDocBody() + "\r\n" + recvFnaErrDocType + sep_slant + recvFnaDocVer + sep_slant
						+ recvFnaMawbNumber + sep_slant + recvFnaHawbNumber + "\r\n" + recvDocDetail);
			}
		} else {
			for (int i = 0; i < parsedArr.length; i++) {
				if (i < 2) {
				} else if (i == 2) {
					docVo.setDocBody(parsedArr[i]);
				} else
					docVo.setDocBody(docVo.getDocBody() + "\r\n" + parsedArr[i]);
			}
		}
		docVo.setDocBody(docVo.getDocBody() + "\r\n");
		docVo.setDocFull(docVo.getDocHeader() + docVo.getDocBody());
		System.out.println("DocHeader : " + docVo.getDocHeader());
		System.out.println("DocBody : " + docVo.getDocBody());
	}

	public String[] getProperties(String errDocType) {
		String path = FNADataParsingTest.class.getResource("").getPath();
		String filePath = path + "config.properties";
		String[] getPropData = new String[2];
		Properties prop = new Properties();

		try (InputStream inputStream = new FileInputStream(filePath)) {

			// Loading the properties.
			prop.load(inputStream);

			// Getting properties
			getPropData[0] = prop.getProperty(errDocType + ".mawb_number");
			getPropData[1] = prop.getProperty(errDocType + ".hawb_number");
		} catch (IOException ex) {
			System.out.println("Problem occurs when reading file !");
			ex.printStackTrace();
		}
		return getPropData;
	}

}
