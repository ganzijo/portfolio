package com.ke.css.cimp.ffr.ffr8;
/* -----------------------------------------------------------------------------
 * XmlDisplayer.java
 * -----------------------------------------------------------------------------
 *
 * Producer : com.parse2.aparse.Parser 2.5
 * Produced : Fri Feb 23 14:32:20 KST 2018
 *
 * -----------------------------------------------------------------------------
 */

import java.util.ArrayList;
import com.ke.css.cimp.common.XML_Maker;

public class XmlDisplayer implements Visitor
{
  private boolean terminal = true;

	private XML_Maker xmlMaker;

	public XmlDisplayer(XML_Maker XML_Maker) {
		this.xmlMaker = XML_Maker;
	}

  public Object visit(Rule_MESSAGE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MESSAGE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MESSAGE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_FFR rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<FFR>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</FFR>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_HEADER rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<HEADER>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</HEADER>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_SMI rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<SMI>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</SMI>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_AWB rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<AWB>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</AWB>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_AWB_NUMBER rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<AWB_NUMBER>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</AWB_NUMBER>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_Quantity_Detail rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_Quantity_Detail>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_Quantity_Detail>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_Volume_Detail rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_Volume_Detail>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_Volume_Detail>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_Density_Group rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_Density_Group>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_Density_Group>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_Total_Consignment_Pieces rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_Total_Consignment_Pieces>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_Total_Consignment_Pieces>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_Nature_of_Goods rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_Nature_of_Goods>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_Nature_of_Goods>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_Special_Handling_Requirements rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_Special_Handling_Requirements>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_Special_Handling_Requirements>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_FLT rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<FLT>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</FLT>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_Flight_Identification rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_Flight_Identification>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_Flight_Identification>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_FLIGHT_NUMBER rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<FLIGHT_NUMBER>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</FLIGHT_NUMBER>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_Allotment_Identification rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_Allotment_Identification>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_Allotment_Identification>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_ULD rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<ULD>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</ULD>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_ULD_Repeated rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_ULD_Repeated>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_ULD_Repeated>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_ULDS rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<ULDS>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</ULDS>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_ULD_Position_Information rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_ULD_Position_Information>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_ULD_Position_Information>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_Weight_of_ULD_Contents rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_Weight_of_ULD_Contents>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_Weight_of_ULD_Contents>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_SSR rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<SSR>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</SSR>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_SSR_Details_1stLine rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_SSR_Details_1stLine>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_SSR_Details_1stLine>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_SSR_Details_2ndLine rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_SSR_Details_2ndLine>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_SSR_Details_2ndLine>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_OSI rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<OSI>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</OSI>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_OSI_Details_1stLine rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_OSI_Details_1stLine>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_OSI_Details_1stLine>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_OSI_Details_2ndLine rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_OSI_Details_2ndLine>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_OSI_Details_2ndLine>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_REF rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<REF>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</REF>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_Requesting_Office_Message_Address rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_Requesting_Office_Message_Address>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_Requesting_Office_Message_Address>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_Requesting_Participant_Identification rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_Requesting_Participant_Identification>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_Requesting_Participant_Identification>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_DIM rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<DIM>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</DIM>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_DIMS rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<DIMS>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</DIMS>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_PID rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<PID>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</PID>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_SHP rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<SHP>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</SHP>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_Account_Detail_SHP rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_Account_Detail_SHP>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_Account_Detail_SHP>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_Name_SHP rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_Name_SHP>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_Name_SHP>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_Street_Address_SHP rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_Street_Address_SHP>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_Street_Address_SHP>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_Location_SHP rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_Location_SHP>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_Location_SHP>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_Coded_Location_SHP rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_Coded_Location_SHP>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_Coded_Location_SHP>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_CONTACTS rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<CONTACTS>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</CONTACTS>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_CNE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<CNE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</CNE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_Account_Detail_CNE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_Account_Detail_CNE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_Account_Detail_CNE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_Name_CNE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_Name_CNE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_Name_CNE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_Street_Address_CNE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_Street_Address_CNE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_Street_Address_CNE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_Location_CNE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_Location_CNE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_Location_CNE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_Coded_Location_CNE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_Coded_Location_CNE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_Coded_Location_CNE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_CUS rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<CUS>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</CUS>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_Account_Detail_CUS rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_Account_Detail_CUS>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_Account_Detail_CUS>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_IATA_CARGO_AGENT_CODE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<IATA_CARGO_AGENT_CODE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</IATA_CARGO_AGENT_CODE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_Name_CUS rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_Name_CUS>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_Name_CUS>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_Place_CUS rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_Place_CUS>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_Place_CUS>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_SRI rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<SRI>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</SRI>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_STANDARD_MESSAGE_IDENTIFIER rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<STANDARD_MESSAGE_IDENTIFIER>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</STANDARD_MESSAGE_IDENTIFIER>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_MId_ULD rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MId_ULD>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MId_ULD>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_MId_SSR rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MId_SSR>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MId_SSR>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_MId_OSI rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MId_OSI>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MId_OSI>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_MId_REF rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MId_REF>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MId_REF>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_MId_DIM rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MId_DIM>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MId_DIM>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_MId_PID rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MId_PID>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MId_PID>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_MId_SHP rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MId_SHP>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MId_SHP>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_MId_CNE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MId_CNE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MId_CNE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_MId_CUS rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MId_CUS>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MId_CUS>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_MId_SRI rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MId_SRI>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MId_SRI>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_IF_HUB_REFERENCE_KEY rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<IF_HUB_REFERENCE_KEY>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</IF_HUB_REFERENCE_KEY>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_MESSAGE_TYPE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MESSAGE_TYPE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MESSAGE_TYPE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_MESSAGE_SUBTYPE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MESSAGE_SUBTYPE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MESSAGE_SUBTYPE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_MESSAGE_RECEIVER rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MESSAGE_RECEIVER>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MESSAGE_RECEIVER>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_MESSAGE_SENDER rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MESSAGE_SENDER>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MESSAGE_SENDER>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_MESSAGE_TYPE_VERSION_NUMBER rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MESSAGE_TYPE_VERSION_NUMBER>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MESSAGE_TYPE_VERSION_NUMBER>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Sub_AWB_Prefix rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Sub_AWB_Prefix>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Sub_AWB_Prefix>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Sub_AWB_SerialNum rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Sub_AWB_SerialNum>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Sub_AWB_SerialNum>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_AIRPORT_CITY_CODE_OF_ORIGIN rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<AIRPORT_CITY_CODE_OF_ORIGIN>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</AIRPORT_CITY_CODE_OF_ORIGIN>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_AIRPORT_CITY_CODE_OF_DEST rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<AIRPORT_CITY_CODE_OF_DEST>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</AIRPORT_CITY_CODE_OF_DEST>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Hid_Shipment_Description_Code_T_P rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Hid_Shipment_Description_Code_T_P>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Hid_Shipment_Description_Code_T_P>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_NUMBER_OF_PIECES rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<NUMBER_OF_PIECES>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</NUMBER_OF_PIECES>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_WEIGHT_CODE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<WEIGHT_CODE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</WEIGHT_CODE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_WEIGHT rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<WEIGHT>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</WEIGHT>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_VOLUME_CODE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<VOLUME_CODE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</VOLUME_CODE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_VOLUME_AMOUNT rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<VOLUME_AMOUNT>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</VOLUME_AMOUNT>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Hid_Density_Indicator rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Hid_Density_Indicator>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Hid_Density_Indicator>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_DENSITY_GROUP rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<DENSITY_GROUP>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</DENSITY_GROUP>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Hid_Shipment_Description_Code_T rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Hid_Shipment_Description_Code_T>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Hid_Shipment_Description_Code_T>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_NUMBER_OF_PIECES_T rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<NUMBER_OF_PIECES_T>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</NUMBER_OF_PIECES_T>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_MANIFEST_DESC_OF_GOODS rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MANIFEST_DESC_OF_GOODS>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MANIFEST_DESC_OF_GOODS>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_SPECIAL_HANDLING_CODE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<SPECIAL_HANDLING_CODE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</SPECIAL_HANDLING_CODE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Sub_Carrier_Code rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Sub_Carrier_Code>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Sub_Carrier_Code>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Sub_Flight_Number rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Sub_Flight_Number>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Sub_Flight_Number>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_DAY_OF_SCHEDULED_DPRT rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<DAY_OF_SCHEDULED_DPRT>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</DAY_OF_SCHEDULED_DPRT>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_MONTH_OF_SCHEDULED_DPRT rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MONTH_OF_SCHEDULED_DPRT>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MONTH_OF_SCHEDULED_DPRT>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_AIRPORT_CODE_OF_DEPARTURE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<AIRPORT_CODE_OF_DEPARTURE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</AIRPORT_CODE_OF_DEPARTURE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_AIRPORT_CODE_OF_ARRIVAL rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<AIRPORT_CODE_OF_ARRIVAL>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</AIRPORT_CODE_OF_ARRIVAL>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_SPACE_ALLOCATION_CODE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<SPACE_ALLOCATION_CODE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</SPACE_ALLOCATION_CODE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_ALLOTMENT_IDENTIFICATION rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<ALLOTMENT_IDENTIFICATION>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</ALLOTMENT_IDENTIFICATION>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_NUMBER_OF_ULDS_TOTAL rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<NUMBER_OF_ULDS_TOTAL>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</NUMBER_OF_ULDS_TOTAL>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_ULD_TYPE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<ULD_TYPE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</ULD_TYPE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_ULD_SERIAL_NUMBER rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<ULD_SERIAL_NUMBER>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</ULD_SERIAL_NUMBER>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_ULD_OWNER_CODE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<ULD_OWNER_CODE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</ULD_OWNER_CODE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_ULD_LOADING_INDICATOR rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<ULD_LOADING_INDICATOR>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</ULD_LOADING_INDICATOR>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_SPECIAL_SERVICE_REQUEST_1 rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<SPECIAL_SERVICE_REQUEST_1>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</SPECIAL_SERVICE_REQUEST_1>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_SPECIAL_SERVICE_REQUEST_2 rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<SPECIAL_SERVICE_REQUEST_2>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</SPECIAL_SERVICE_REQUEST_2>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_OTHER_SERVICE_INFORMATION_1 rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<OTHER_SERVICE_INFORMATION_1>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</OTHER_SERVICE_INFORMATION_1>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_OTHER_SERVICE_INFORMATION_2 rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<OTHER_SERVICE_INFORMATION_2>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</OTHER_SERVICE_INFORMATION_2>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_RQST_OFC_AIRPORT_CITY_CODE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<RQST_OFC_AIRPORT_CITY_CODE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</RQST_OFC_AIRPORT_CITY_CODE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_OFFICE_FUNCTION_DESIGNATOR rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<OFFICE_FUNCTION_DESIGNATOR>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</OFFICE_FUNCTION_DESIGNATOR>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_COMPANY_DESIGNATOR rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<COMPANY_DESIGNATOR>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</COMPANY_DESIGNATOR>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_BOOKING_FILE_REFERENCE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<BOOKING_FILE_REFERENCE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</BOOKING_FILE_REFERENCE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_PARTICIPANT_IDENTIFIER rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<PARTICIPANT_IDENTIFIER>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</PARTICIPANT_IDENTIFIER>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_PARTICIPANT_CODE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<PARTICIPANT_CODE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</PARTICIPANT_CODE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_PARTI_AIRPORT_CITY_CODE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<PARTI_AIRPORT_CITY_CODE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</PARTI_AIRPORT_CITY_CODE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_MEASUREMENT_UNIT_CODE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MEASUREMENT_UNIT_CODE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MEASUREMENT_UNIT_CODE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_LENGTH_DIMENSION rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<LENGTH_DIMENSION>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</LENGTH_DIMENSION>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_WIDTH_DIMENSION rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<WIDTH_DIMENSION>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</WIDTH_DIMENSION>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_HEIGHT_DIMENSION rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<HEIGHT_DIMENSION>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</HEIGHT_DIMENSION>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_NUMBERS_OF_PIECES rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<NUMBERS_OF_PIECES>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</NUMBERS_OF_PIECES>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_SERVICE_CODE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<SERVICE_CODE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</SERVICE_CODE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_RATE_CLASS_CODE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<RATE_CLASS_CODE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</RATE_CLASS_CODE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_COMMODITY_ITEM_NUMBER rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<COMMODITY_ITEM_NUMBER>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</COMMODITY_ITEM_NUMBER>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Hid_InformID_NAM rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Hid_InformID_NAM>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Hid_InformID_NAM>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Hid_InformID_ADR rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Hid_InformID_ADR>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Hid_InformID_ADR>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Hid_InformID_LOC rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Hid_InformID_LOC>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Hid_InformID_LOC>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_SHIPPER_ACCOUNT_NUMBER rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<SHIPPER_ACCOUNT_NUMBER>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</SHIPPER_ACCOUNT_NUMBER>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_SHIPPER_NAME rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<SHIPPER_NAME>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</SHIPPER_NAME>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_SHIPPER_STREET_ADDRESS rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<SHIPPER_STREET_ADDRESS>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</SHIPPER_STREET_ADDRESS>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_SHIPPER_PLACE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<SHIPPER_PLACE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</SHIPPER_PLACE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_SHIPPER_STATE_PROVINCE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<SHIPPER_STATE_PROVINCE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</SHIPPER_STATE_PROVINCE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_SHIPPER_ISO_COUNTRY_CODE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<SHIPPER_ISO_COUNTRY_CODE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</SHIPPER_ISO_COUNTRY_CODE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_SHIPPER_POST_CODE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<SHIPPER_POST_CODE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</SHIPPER_POST_CODE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_CONTACT_IDENTIFIER rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<CONTACT_IDENTIFIER>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</CONTACT_IDENTIFIER>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_CONTACT_NUMBER rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<CONTACT_NUMBER>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</CONTACT_NUMBER>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_CONSIGNEE_ACCOUNT_NUMBER rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<CONSIGNEE_ACCOUNT_NUMBER>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</CONSIGNEE_ACCOUNT_NUMBER>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_CONSIGNEE_NAME rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<CONSIGNEE_NAME>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</CONSIGNEE_NAME>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_CONSIGNEE_STREET_ADDRESS rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<CONSIGNEE_STREET_ADDRESS>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</CONSIGNEE_STREET_ADDRESS>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_CONSIGNEE_PLACE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<CONSIGNEE_PLACE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</CONSIGNEE_PLACE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_CONSIGNEE_STATE_PROVINCE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<CONSIGNEE_STATE_PROVINCE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</CONSIGNEE_STATE_PROVINCE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_CONSIGNEE_ISO_COUNTRY_CODE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<CONSIGNEE_ISO_COUNTRY_CODE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</CONSIGNEE_ISO_COUNTRY_CODE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_CONSIGNEE_POST_CODE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<CONSIGNEE_POST_CODE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</CONSIGNEE_POST_CODE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_AGENT_ACCOUNT_NUMBER rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<AGENT_ACCOUNT_NUMBER>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</AGENT_ACCOUNT_NUMBER>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Sub_IATA_Cargo_Agent_Numeric_Code rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Sub_IATA_Cargo_Agent_Numeric_Code>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Sub_IATA_Cargo_Agent_Numeric_Code>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Sub_Cargo_Agent_CASS_Address rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Sub_Cargo_Agent_CASS_Address>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Sub_Cargo_Agent_CASS_Address>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_AGENT_PARTICIPANT_IDENTIFIER rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<AGENT_PARTICIPANT_IDENTIFIER>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</AGENT_PARTICIPANT_IDENTIFIER>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_AGENT_NAME rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<AGENT_NAME>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</AGENT_NAME>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_AGENT_PLACE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<AGENT_PLACE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</AGENT_PLACE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_SHIPMENT_REFERENCE_NUMBER rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<SHIPMENT_REFERENCE_NUMBER>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</SHIPMENT_REFERENCE_NUMBER>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_SHIPMENT_INFORMATION_1 rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<SHIPMENT_INFORMATION_1>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</SHIPMENT_INFORMATION_1>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_SHIPMENT_INFORMATION_2 rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<SHIPMENT_INFORMATION_2>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</SHIPMENT_INFORMATION_2>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Sep_CRLF rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Sep_CRLF>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Sep_CRLF>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_CR rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<CR>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</CR>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_LF rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<LF>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</LF>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Sep_Slant rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Sep_Slant>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Sep_Slant>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Sep_Bar rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Sep_Bar>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Sep_Bar>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Typ_Alpha rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Typ_Alpha>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Typ_Alpha>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Typ_Numeric rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Typ_Numeric>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Typ_Numeric>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Typ_Decimal rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Typ_Decimal>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Typ_Decimal>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Typ_Mixed rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Typ_Mixed>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Typ_Mixed>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Typ_Text rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Typ_Text>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Typ_Text>");
    terminal = false;
    return null;
  }

  public Object visit(Terminal_StringValue value)
  {
    xmlMaker.addXmlData(value.spelling);
    terminal = true;
    return null;
  }

  public Object visit(Terminal_NumericValue value)
  {
    xmlMaker.addXmlData(value.spelling);
    terminal = true;
    return null;
  }

private Boolean visitRules(ArrayList<Rule> rules) {
		for (Rule rule : rules) {
			String ruleName = rule.getClass().toString();
			if (xmlMaker.checkData(ruleName)) {
				rule.accept(this);
			}
		}
		return null;
	}
}

/* -----------------------------------------------------------------------------
 * eof
 * -----------------------------------------------------------------------------
 */
