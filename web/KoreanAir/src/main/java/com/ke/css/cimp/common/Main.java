//package com.ke.css.cimp.common;
//
//import com.ke.css.cimp.fhl.fhl5.*;
//
//public class Main {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Parser paser = new Parser();
//
//		String data = "FHL/5\r\n" + "MBI/180-00052456NRTJFK/T243K309\r\n"
//				+ "HBS/8183674660/NRTJFK/1/K1.6//AIR PURIFIER C\r\n" + "TXT/.COM.AIR PURIFIER\r\n"
//				+ "/.FLT.20171107-KE552-HJTC-TIC-TIC\r\n" + "/.DCS.HANCO. LTD.\r\n" + "OCI/KR/IMP/I/I0011-GD\r\n"
//				+ "SHP\r\n" + "NAM/AIR EXPRESS INTL\r\n" + "ADR/CARGO COMPLEX BULDG B\r\n" + "LOC/AIRLINES ROAD\r\n"
//				+ "/SG/1738/FAX/651234567\r\n" + "CNE\r\n" + "NAM/AIE EXPRESS INTL\r\n" + "ADR/CENTRAL STREET 13\r\n"
//				+ "LOC/JAMAICA/NY\r\n" + "/US/22330/TEL/171812344566\r\n" + "CVD/SGD/PP/NVD/NCV/XXX\r\n";
//
//		try {
//			// set MsgId
//			String MsgId = "FHL5";
//
//			// set rule
//			Rule rule = Parser.parse(MsgId, data);
//
//			// xmlData 저장객체
//			XML_Maker XML_FHL = new XML_Maker();
//
//			// xmlDisplayer를 통한 xmlData make
//			XmlDisplayer xmlDisplayer = new XmlDisplayer(XML_FHL);
//			rule.accept((Visitor) xmlDisplayer);
//
//			System.out.println(XML_FHL.getXmlData());
//
//		} catch (IllegalArgumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ParserException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		// paser.ParserTest(input);
//
//	}
//
//}