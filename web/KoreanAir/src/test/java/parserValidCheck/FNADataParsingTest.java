package parserValidCheck;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FNADataParsingTest {

	private static Object parserObj = new Object();
	private static Object xmlDisplayerObj = new Object();
	private static Method parserMethod = null;
	private static Method ruleMethod = null;
	private static String[] getMsgId = null;
	private static String msgName = "";
	private static String msgVer = "";
	private static String msgId = "";
	private static String msgHeader = "";
	private static String msgBody = "";
	private static String fullMsg = "";
	private static String[] propertiesData = new String[2];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data = "QK XXDUMMY\r\n" + ".XXDUMMY\r\n" + "FNA/1\r\n" + "ACK/INVALID AWB NO\r\n"
				+ "/INVALID STATUS CODE\r\n" + "FHL/5\r\n" + "MBI/180-19901431ICNTSN/T23K2923\r\n"
				+ "HBS/DGL080888/ICNTSN/16/K1747/4/LENS LINER\r\n" + "/AVI/PER\r\n" + "TXT/.COM.LENS LINER\r\n"
				+ "/.FLT.20171031-KE0317-DITL-TK-AK\r\n" + "/.DCS.DONGYANG4.ENC\r\n" + "/.SNM.SONG HA\r\n"
				+ "/.SCC.10005\r\n" + "/.SAR.SONG HA ADDR\r\n" + "/.CNM.SU HA\r\n" + "/.CCC.10005\r\n"
				+ "/.CAR.SU HA ADDR\r\n" + "HTS/730890\r\n" + "OCI/KR/EXP/A/E001-4251617100640X-A-1-CT\r\n"
				+ "/KR/EXP/A/S001-16-1747-N-0\r\n" + "SHP\r\n" + "NAM/AIR EXPRESS INTL\r\n"
				+ "ADR/CARGO COMPLEX BULDG B\r\n" + "LOC/AIRLINES ROAD/KOREA\r\n" + "/SG/1738/FX/651234567\r\n"
				+ "CNE\r\n" + "NAM/AIE EXPRESS INTL\r\n" + "ADR/CENTRAL STREET 13\r\n" + "LOC/JAMAICA/NY\r\n"
				+ "/US/22330/TE/171812344566\r\n" + "CVD/KRW/PP/NVD/NCV/XXX\r\n" + "";
		String[] dataArr = data.split("\r\n");
		String parsedData = headerParsing(dataArr);
		String[] parsedArr = data.split("\r\n");
		String ifHubRefKey = getGUID();
		String msgType = getMsgType(msgName);
		String msgSubType = msgName;
		String msgReceiver = parsedArr[0];
		String msgSender = parsedArr[1].substring(1, 8);
		String sep_slant = "/";
		String[] getErrMsg = null;
		String recvFnaErrMsgType = "";
		String recvFnaMsgVer = "";
		String recvMsgDetail = "";
		String recvFnaMawbNumber = "";
		String recvFnaHawbNumber = "";
		System.out.println("msgSubType :" + msgSubType);
		String[] dataAccessIndex = null;
		if (msgSubType.equals("fna")) {
			for (int i = 0; i < parsedArr.length; i++) {
				if (i < 2) {
				} else if (i == 2) {
					msgBody = parsedArr[i];
				} else if (i > 2 && i < 5) {
					msgBody = msgBody + "\r\n" + parsedArr[i];
				} else if (i == 5) {
					getErrMsg = parsedArr[i].split("/");
					recvFnaErrMsgType = getErrMsg[0];
					recvFnaMsgVer = getErrMsg[1];
					recvMsgDetail = recvMsgDetail + parsedArr[i] + "\r\n";
					propertiesData = getProperties("fhl");
				} else if (i == 6) {
					dataAccessIndex = propertiesData[0].split(",");
					recvFnaMawbNumber = parsedArr[i].substring(Integer.parseInt(dataAccessIndex[0]),
							Integer.parseInt(dataAccessIndex[1]));
					recvMsgDetail = recvMsgDetail + parsedArr[i] + "\r\n";
				} else if (i == 7) {
					dataAccessIndex = propertiesData[1].split(",");
					recvFnaHawbNumber = parsedArr[i].substring(Integer.parseInt(dataAccessIndex[0]),
							Integer.parseInt(dataAccessIndex[1]));
					recvMsgDetail = recvMsgDetail + parsedArr[i] + "\r\n";
				} else if (i > 5) {
					recvMsgDetail = recvMsgDetail + parsedArr[i] + "\r\n";
				}
			}
			msgBody = msgBody + "\r\n" + recvFnaErrMsgType + sep_slant + recvFnaMsgVer + sep_slant + recvFnaMawbNumber
					+ sep_slant + recvFnaHawbNumber + "\r\n" + recvMsgDetail;
			System.out.println("msgBody : " + msgBody);
		} else {
			for (int i = 0; i < parsedArr.length; i++) {
				if (i < 2) {
				} else if (i == 2) {
					msgBody = parsedArr[i];
				} else
					msgBody = msgBody + "\r\n" + parsedArr[i];
			}
		}
	}

	public static String headerParsing(String[] dataArr) {
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

	public static void generalHeader(String[] dataArr) {
		getMsgId = dataArr[2].split("/");
		msgName = getMsgId[0].toLowerCase();
		msgVer = getMsgId[1].toLowerCase();
		msgId = msgName + msgVer;
		System.out.println("msgId : " + msgId);
		System.out.println("General Header");
	}

	public static String multiRowHeader(String[] dataArr, int lastLine) {
		getMsgId = dataArr[lastLine + 1].split("/");
		msgName = getMsgId[0].toLowerCase();
		msgVer = getMsgId[1].toLowerCase();
		msgId = msgName + msgVer;
		System.out.println("msgId : " + msgId);
		System.out.println("MultiRow Header");
		String modify = dataArr[0] + "\r\n" + dataArr[lastLine];
		for (int i = lastLine + 1; i < dataArr.length; i++) {
			modify = modify + "\r\n" + dataArr[i];
		}
		System.out.println(modify);
		return modify;
	}

	public static String dummyHeader(String[] dataArr) {
		getMsgId = dataArr[0].split("/");
		msgName = getMsgId[0].toLowerCase();
		msgVer = getMsgId[1].toLowerCase();
		msgId = msgName + msgVer;
		System.out.println("msgId : " + msgId);
		System.out.println("Dummy Header");
		String dummyData = "QK XXDUMMY" + "\r\n" + ".XXDUMMY";

		String modify = dummyData;
		for (int i = 0; i < dataArr.length; i++) {
			modify = modify + "\r\n" + dataArr[i];
		}
		System.out.println(modify);
		return modify;
	}

	public static String getMsgType(String msgName) {
		if (msgName.equals("fhl") || msgName.equals("fwb") || msgName.equals("ffm") || msgName.equals("ffr")
				|| msgName.equals("fbl") || msgName.equals("fna")) {
			return "CIMP";
		} else if (msgName.equals("")) {
			return "AHM";
		} else if (msgName.equals("")) {
			return "AMS";
		}
		return null;
	}

	public static String getGUID() {
		return "12345123451234512345123451234512345";
	}

	public static String[] getProperties(String errMsgType) {
		String path = FNADataParsingTest.class.getResource("").getPath();
		String filePath = path + "config.properties";
		System.out.println(filePath);
		Properties prop = new Properties();
		String[] getPropData = new String[2];
		try (InputStream inputStream = new FileInputStream(filePath)) {

			// Loading the properties.
			prop.load(inputStream);

			// Getting properties
			getPropData[0] = prop.getProperty(errMsgType + ".mawb_number");
			getPropData[1] = prop.getProperty(errMsgType + ".hawb_number");
		} catch (IOException ex) {
			System.out.println("Problem occurs when reading file !");
			ex.printStackTrace();
		}
		return getPropData;
	}

}
