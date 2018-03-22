package parserValidCheck;

import java.io.IOException;
import java.io.StringReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


public class HeaderParseTest {
	private static String[] getMsgId;
	private static String msgName;
	private static String msgVer;
	private static String msgId;
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		String test = "<FHL>\r\n" + 
				"<SMI>\r\n" + 
				"<STANDARD_MESSAGE_IDENTIFIER>FHL</STANDARD_MESSAGE_IDENTIFIER>\r\n" + 
				"<MESSAGE_TYPE_VERSION_NUMBER>5</MESSAGE_TYPE_VERSION_NUMBER>\r\n" + 
				"</SMI>\r\n" + 
				"<MBI>\r\n" + 
				"<MAWB_NUMBER>18019901431</MAWB_NUMBER>\r\n" + 
				"<MAWB_AIRPORT_CODE_OF_ORIGIN>ICN</MAWB_AIRPORT_CODE_OF_ORIGIN>\r\n" + 
				"<MAWB_AIRPORT_CODE_OF_DEST>TSN</MAWB_AIRPORT_CODE_OF_DEST>\r\n" + 
				"<MAWB_NUMBER_OF_PIECES>23</MAWB_NUMBER_OF_PIECES>\r\n" + 
				"<MAWB_WEIGHT_CODE>K</MAWB_WEIGHT_CODE>\r\n" + 
				"<MAWB_WEIGHT>2923</MAWB_WEIGHT>\r\n" + 
				"</MBI>\r\n" + 
				"<HBS_MASTER>\r\n" + 
				"<HBS>\r\n" + 
				"<HAWB_NUMBER>DGL080888</HAWB_NUMBER>\r\n" + 
				"<HAWB_AIRPORT_CODE_OF_ORIGIN>ICN</HAWB_AIRPORT_CODE_OF_ORIGIN>\r\n" + 
				"<HAWB_AIRPORT_CODE_OF_DEST>TSN</HAWB_AIRPORT_CODE_OF_DEST>\r\n" + 
				"<HAWB_NUMBER_OF_PIECES>16</HAWB_NUMBER_OF_PIECES>\r\n" + 
				"<HAWB_WEIGHT_CODE>K</HAWB_WEIGHT_CODE>\r\n" + 
				"<HAWB_WEIGHT>1747</HAWB_WEIGHT>\r\n" + 
				"<SLAC>4</SLAC>\r\n" + 
				"<MANIFEST_DESC_OF_GOODS>LENS LINER</MANIFEST_DESC_OF_GOODS>\r\n" + 
				"<SPECIAL_HANDLING_CODE>AVI</SPECIAL_HANDLING_CODE>\r\n" + 
				"<SPECIAL_HANDLING_CODE>PER</SPECIAL_HANDLING_CODE>\r\n" + 
				"</HBS>\r\n" + 
				"<TXT>\r\n" + 
				"<FREE_TEXT_DESCRIPTION_OF_GOODS>.COM.LENS LINER</FREE_TEXT_DESCRIPTION_OF_GOODS>\r\n" + 
				"<DPRT_ARRV_DATE_FOR_KCUS>20171031</DPRT_ARRV_DATE_FOR_KCUS>\r\n" + 
				"<FLIGHT_NUMBER_FOR_KCUS>KE0317</FLIGHT_NUMBER_FOR_KCUS>\r\n" + 
				"<FORWARDER_CODE_FOR_KCUS>DITL</FORWARDER_CODE_FOR_KCUS>\r\n" + 
				"<ASSIGN_PLACE_FOR_KCUS>TK</ASSIGN_PLACE_FOR_KCUS>\r\n" + 
				"<LOAD_PLACE_FOR_KCUS>AK</LOAD_PLACE_FOR_KCUS>\r\n" + 
				"<FORWARDER_NAME_FOR_KCUS>DONGYANG4.ENC</FORWARDER_NAME_FOR_KCUS>\r\n" + 
				"<SHIPPER_NAME_FOR_KCUS>SONG HA</SHIPPER_NAME_FOR_KCUS>\r\n" + 
				"<SHIPPER_POST_CODE_FOR_KCUS>10005</SHIPPER_POST_CODE_FOR_KCUS>\r\n" + 
				"<SHIPPER_ADDRESS_FOR_KCUS>SONG HA ADDR</SHIPPER_ADDRESS_FOR_KCUS>\r\n" + 
				"<CONSIGNEE_NAME_FOR_KCUS>SU HA</CONSIGNEE_NAME_FOR_KCUS>\r\n" + 
				"<CONSIGNEE_POST_CODE_FOR_KUS>10005</CONSIGNEE_POST_CODE_FOR_KUS>\r\n" + 
				"<CONSIGNEE_ADDRESS_FOR_KCUS>SU HA ADDR</CONSIGNEE_ADDRESS_FOR_KCUS>\r\n" + 
				"</TXT>\r\n" + 
				"<HTS>\r\n" + 
				"<HARMONISED_COMMODITY_CODE>730890</HARMONISED_COMMODITY_CODE>\r\n" + 
				"</HTS>\r\n" + 
				"<OCI>\r\n" + 
				"<ISO_COUNTRY_CODE>KR</ISO_COUNTRY_CODE>\r\n" + 
				"<EXPIMP_IDENTIFIER>EXP</EXPIMP_IDENTIFIER>\r\n" + 
				"<SYSTEM_IDENTIFIER>A</SYSTEM_IDENTIFIER>\r\n" + 
				"<TRANSPORT_IDENTIFIER>E</TRANSPORT_IDENTIFIER>\r\n" + 
				"<HSN_NUMBER>001</HSN_NUMBER>\r\n" + 
				"<EPN_NUMBER>4251617100640X</EPN_NUMBER>\r\n" + 
				"<EXP_PACKING_CODE>A</EXP_PACKING_CODE>\r\n" + 
				"<EXP_NUMBER_OF_PIECES>1</EXP_NUMBER_OF_PIECES>\r\n" + 
				"<EXP_PACKING_TYPE>CT</EXP_PACKING_TYPE>\r\n" + 
				"<ISO_COUNTRY_CODE>KR</ISO_COUNTRY_CODE>\r\n" + 
				"<EXPIMP_IDENTIFIER>EXP</EXPIMP_IDENTIFIER>\r\n" + 
				"<SYSTEM_IDENTIFIER>A</SYSTEM_IDENTIFIER>\r\n" + 
				"<EPN_SEQ>S001</EPN_SEQ>\r\n" + 
				"<EPN_NUMBER_OF_PIECES>16</EPN_NUMBER_OF_PIECES>\r\n" + 
				"<EPN_WEIGHT>1747</EPN_WEIGHT>\r\n" + 
				"<EPN_DIVISION_IDENTIFIER>N</EPN_DIVISION_IDENTIFIER>\r\n" + 
				"<EPN_DIVISION_DIMENSION>0</EPN_DIVISION_DIMENSION>\r\n" + 
				"</OCI>\r\n" + 
				"<SHP>\r\n" + 
				"<SHIPPER_NAME>AIR EXPRESS INTL</SHIPPER_NAME>\r\n" + 
				"<SHIPPER_STREET_ADDRESS>CARGO COMPLEX BULDG B</SHIPPER_STREET_ADDRESS>\r\n" + 
				"<SHIPPER_PLACE>AIRLINES ROAD</SHIPPER_PLACE>\r\n" + 
				"<SHIPPER_STATE_PROVINCE>KOREA</SHIPPER_STATE_PROVINCE>\r\n" + 
				"<SHIPPER_ISO_COUNTRY_CODE>SG</SHIPPER_ISO_COUNTRY_CODE>\r\n" + 
				"<SHIPPER_POST_CODE>1738</SHIPPER_POST_CODE>\r\n" + 
				"<SHIPPER_CONTACT>\r\n" + 
				"<SHIPPER_CONTACT_IDENTIFIER>FX</SHIPPER_CONTACT_IDENTIFIER>\r\n" + 
				"<SHIPPER_CONTACT_NUMBER>651234567</SHIPPER_CONTACT_NUMBER>\r\n" + 
				"</SHIPPER_CONTACT>\r\n" + 
				"</SHP>\r\n" + 
				"<CNE>\r\n" + 
				"<CONSIGNEE_NAME>AIE EXPRESS INTL</CONSIGNEE_NAME>\r\n" + 
				"<CONSIGNEE_STREET_ADDRESS>CENTRAL STREET 13</CONSIGNEE_STREET_ADDRESS>\r\n" + 
				"<CONSIGNEE_PLACE>JAMAICA</CONSIGNEE_PLACE>\r\n" + 
				"<CONSIGNEE_STATE_PROVINCE>NY</CONSIGNEE_STATE_PROVINCE>\r\n" + 
				"<CONSIGNEE_ISO_COUNTRY_CODE>US</CONSIGNEE_ISO_COUNTRY_CODE>\r\n" + 
				"<CONSIGNEE_POST_CODE>22330</CONSIGNEE_POST_CODE>\r\n" + 
				"<CONSIGNEE_CONTACT>\r\n" + 
				"<CONSIGNEE_CONTACT_IDENTIFIER>TE</CONSIGNEE_CONTACT_IDENTIFIER>\r\n" + 
				"<CONSIGNEE_CONTACT_NUMBER>171812344566</CONSIGNEE_CONTACT_NUMBER>\r\n" + 
				"</CONSIGNEE_CONTACT>\r\n" + 
				"</CNE>\r\n" + 
				"<CVD>\r\n" + 
				"<ISO_CURRENCY_CODE>KRW</ISO_CURRENCY_CODE>\r\n" + 
				"<P_C_IND_WEIGHT_VALUATION>P</P_C_IND_WEIGHT_VALUATION>\r\n" + 
				"<P_C_IND_OTHER_CHARGES>P</P_C_IND_OTHER_CHARGES>\r\n" + 
				"<DECLARED_VALUE_FOR_CARRIAGE>NVD</DECLARED_VALUE_FOR_CARRIAGE>\r\n" + 
				"<DECLARED_VALUE_FOR_CUSTOMS>NCV</DECLARED_VALUE_FOR_CUSTOMS>\r\n" + 
				"<DECLARE_VALUE_FOR_INSURANCE>XXX</DECLARE_VALUE_FOR_INSURANCE>\r\n" + 
				"</CVD>\r\n" + 
				"</HBS_MASTER>\r\n" + 
				"</FHL>";
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(test));
        Document document = documentBuilder.parse(test);
        Element root = document.getDocumentElement();
	}

	public String HeaderParsing(String data) {
		String parsedData = "";
		// String data ="QK XXDUMMY\r\n" +
		// "QK XXDUMMY\r\n" +
		// "QK XXDUMMY\r\n" +
		// ".XXDUMMY abc\r\n" +
		// "FHL/5\r\n" +
		// "MBI/180-19901431ICNTSN/T23K2923\r\n" +
		// "HBS/DGL080888/ICNTSN/16/K1747/4/LENS LINER\r\n" +
		// "/AVI/PER\r\n" +
		// "TXT/.COM.LENS LINER\r\n" +
		// "/.FLT.20171031-KE0317-DITL-TK-AK\r\n" +
		// "/.DCS.DONGYANG4.ENC\r\n" +
		// "/.SNM.SONG HA\r\n" +
		// "/.SCC.10005\r\n" +
		// "/.SAR.SONG HA ADDR\r\n" +
		// "/.CNM.SU HA\r\n" +
		// "/.CCC.10005\r\n" +
		// "/.CAR.SU HA ADDR\r\n" +
		// "HTS/730890\r\n" +
		// "OCI/KR/EXP/A/E001-4251617100640X-A-1-CT\r\n" +
		// "/KR/EXP/A/S001-16-1747-N-0\r\n" +
		// "SHP\r\n" +
		// "NAM/AIR EXPRESS INTL\r\n" +
		// "ADR/CARGO COMPLEX BULDG B\r\n" +
		// "LOC/AIRLINES ROAD/KOREA\r\n" +
		// "/SG/1738/FX/651234567\r\n" +
		// "CNE\r\n" +
		// "NAM/AIE EXPRESS INTL\r\n" +
		// "ADR/CENTRAL STREET 13\r\n" +
		// "LOC/JAMAICA/NY\r\n" +
		// "/US/22330/TE/171812344566\r\n" +
		// "CVD/KRW/PP/NVD/NCV/XXX\r\n";
		// String data = "FHL/5\r\n" + "MBI/180-19901431ICNTSN/T23K2923\r\n"
		// + "HBS/DGL080888/ICNTSN/16/K1747/4/LENS LINER\r\n" + "/AVI/PER\r\n" +
		// "TXT/.COM.LENS LINER\r\n"
		// + "/.FLT.20171031-KE0317-DITL-TK-AK\r\n" + "/.DCS.DONGYANG4.ENC\r\n" +
		// "/.SNM.SONG HA\r\n"
		// + "/.SCC.10005\r\n" + "/.SAR.SONG HA ADDR\r\n" + "/.CNM.SU HA\r\n" +
		// "/.CCC.10005\r\n"
		// + "/.CAR.SU HA ADDR\r\n" + "HTS/730890\r\n" +
		// "OCI/KR/EXP/A/E001-4251617100640X-A-1-CT\r\n"
		// + "/KR/EXP/A/S001-16-1747-N-0\r\n" + "SHP\r\n" + "NAM/AIR EXPRESS INTL\r\n"
		// + "ADR/CARGO COMPLEX BULDG B\r\n" + "LOC/AIRLINES ROAD/KOREA\r\n" +
		// "/SG/1738/FX/651234567\r\n"
		// + "CNE\r\n" + "NAM/AIE EXPRESS INTL\r\n" + "ADR/CENTRAL STREET 13\r\n" +
		// "LOC/JAMAICA/NY\r\n"
		// + "/US/22330/TE/171812344566\r\n" + "CVD/KRW/PP/NVD/NCV/XXX\r\n";
		
		// String data = "QK XXDUMMY\r\n" +
		// ".XXDUMMY abc\r\n"
		// + "ABCDE";
		String[] dataArr = data.split("\r\n");
		// String[] getMsgId = dataArr[0].split("/");
		// String msgName = getMsgId[0].toLowerCase();
		// String msgVer = getMsgId[1].toLowerCase();
		// String msgId = msgName + msgVer;
		// System.out.println("msgId" + msgId);

		// System.out.println(data);
		Pattern pattern = Pattern.compile("(^\\.[a-zA-Z0-9]{7})");

		for (int i = 0; i < dataArr.length; i++) {
			System.out.println(dataArr[i]);
			Matcher matcher = pattern.matcher(dataArr[i]);
			if (matcher.lookingAt()) {
				System.out.println("true");
				System.out.println(matcher.group(1));
				if (i == 1) { // 일반적인 헤더일 경우
					// parsedData =generalHeader(dataArr);
					break;
				} else {
					parsedData = multiRowHeader(dataArr, i);
					break;
				}
			}
		}
		parsedData = dummyHeader(dataArr);
		
		return parsedData;

	}

	public static void generalHeader(String[] dataArr) {
		getMsgId = dataArr[3].split("/");
		msgName = getMsgId[0].toLowerCase();
		msgVer = getMsgId[1].toLowerCase();
		msgId = msgName + msgVer;
		System.out.println("msgId : " + msgId);
		// return
	}

	public static String multiRowHeader(String[] dataArr, int lastLine) {
		getMsgId = dataArr[lastLine + 1].split("/");
		msgName = getMsgId[0].toLowerCase();
		msgVer = getMsgId[1].toLowerCase();
		msgId = msgName + msgVer;
		System.out.println("msgId : " + msgId);
		String modify = dataArr[0] + "\r\n" + dataArr[lastLine];
		for (int i = lastLine + 1; i < dataArr.length; i++) {
			modify = modify + "\r\n" + dataArr[i];
		}
		return modify;
	}

	public static String dummyHeader(String[] dataArr) {
		getMsgId = dataArr[0].split("/");
		msgName = getMsgId[0].toLowerCase();
		msgVer = getMsgId[1].toLowerCase();
		msgId = msgName + msgVer;
		System.out.println("msgId : " + msgId);
		String dummyData = "QK XXDUMMY" + "\r\n" + ".XXDUMMY";
		String modify = dummyData;
		for (int i = 0; i < dataArr.length; i++) {
			modify = modify + "\r\n" + dataArr[i];
		}
		return modify;
	}
}
