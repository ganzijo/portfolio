package com.ke.css.cimp.ffm.ffm2;
/* -----------------------------------------------------------------------------
 * XmlDisplayer.java
 * -----------------------------------------------------------------------------
 *
 * Producer : com.parse2.aparse.Parser 2.5
 * Produced : Fri Feb 23 10:52:50 KST 2018
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

  public Object visit(Rule_FFM rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<FFM>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</FFM>");
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

  public Object visit(Rule_MFH rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MFH>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MFH>");
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

  public Object visit(Rule_FLIGHT_DATE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<FLIGHT_DATE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</FLIGHT_DATE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_AIRCRAFT_REGISTRATION rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_AIRCRAFT_REGISTRATION>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_AIRCRAFT_REGISTRATION>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_First_Point_of_Arrival_Information rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_First_Point_of_Arrival_Information>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_First_Point_of_Arrival_Information>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_DST rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<DST>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</DST>");
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

  public Object visit(Rule_Grp_AWB rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_AWB>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_AWB>");
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

  public Object visit(Rule_CMI rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<CMI>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</CMI>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_CMIS rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<CMIS>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</CMIS>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_Onward_Routing_Detail rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_Onward_Routing_Detail>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_Onward_Routing_Detail>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_Onward_Booking_Detail rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_Onward_Booking_Detail>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_Onward_Booking_Detail>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_Movement_Priority rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_Movement_Priority>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_Movement_Priority>");
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

  public Object visit(Rule_Grp_OSI_Details_1st_Line rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_OSI_Details_1st_Line>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_OSI_Details_1st_Line>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_OSI_Details_2nd_Line rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_OSI_Details_2nd_Line>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_OSI_Details_2nd_Line>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_SCI rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<SCI>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</SCI>");
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

  public Object visit(Rule_ULD_INFORMATION rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<ULD_INFORMATION>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</ULD_INFORMATION>");
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

  public Object visit(Rule_Grp_ULD_Remarks rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_ULD_Remarks>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_ULD_Remarks>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_UMI rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<UMI>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</UMI>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_UMIS rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<UMIS>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</UMIS>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_ULD_Onward_Routing_Detail rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_ULD_Onward_Routing_Detail>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_ULD_Onward_Routing_Detail>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_ULD_Onward_Booking_Detail rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_ULD_Onward_Booking_Detail>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_ULD_Onward_Booking_Detail>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_ULD_Utilisation_Detail rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_ULD_Utilisation_Detail>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_ULD_Utilisation_Detail>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_MCI rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MCI>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MCI>");
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

  public Object visit(Rule_MId_MFH rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MId_MFH>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MId_MFH>");
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

  public Object visit(Rule_MId_SCI rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MId_SCI>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MId_SCI>");
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

  public Object visit(Rule_MESSAGE_SEQUENCE_NUMBER rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MESSAGE_SEQUENCE_NUMBER>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MESSAGE_SEQUENCE_NUMBER>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Sub_Day_of_Scheduled_Departure rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Sub_Day_of_Scheduled_Departure>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Sub_Day_of_Scheduled_Departure>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Sub_Month_of_Scheduled_Departure rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Sub_Month_of_Scheduled_Departure>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Sub_Month_of_Scheduled_Departure>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_AIRPORT_CODE_OF_LOADING rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<AIRPORT_CODE_OF_LOADING>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</AIRPORT_CODE_OF_LOADING>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_AIRCRAFT_REGISTRATION rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<AIRCRAFT_REGISTRATION>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</AIRCRAFT_REGISTRATION>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_ISO_COUNTRY_CODE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<ISO_COUNTRY_CODE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</ISO_COUNTRY_CODE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_DAY_OF_SCHEDULED_ARRIVAL rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<DAY_OF_SCHEDULED_ARRIVAL>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</DAY_OF_SCHEDULED_ARRIVAL>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_MONTH_OF_SCHEDULED_ARRIVAL rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MONTH_OF_SCHEDULED_ARRIVAL>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MONTH_OF_SCHEDULED_ARRIVAL>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_TIME_OF_SCHEDULED_ARRIVAL rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<TIME_OF_SCHEDULED_ARRIVAL>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</TIME_OF_SCHEDULED_ARRIVAL>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_AIRPORT_CITY_CODE_OF_ARRV rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<AIRPORT_CITY_CODE_OF_ARRV>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</AIRPORT_CITY_CODE_OF_ARRV>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_AIRPORT_CODE_OF_UNLOADING rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<AIRPORT_CODE_OF_UNLOADING>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</AIRPORT_CODE_OF_UNLOADING>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_NIL_CARGO_CODE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<NIL_CARGO_CODE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</NIL_CARGO_CODE>");
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

  public Object visit(Rule_TIME_OF_SCHEDULED_DPRT rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<TIME_OF_SCHEDULED_DPRT>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</TIME_OF_SCHEDULED_DPRT>");
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

  public Object visit(Rule_SHIPMENT_DESCRIPTION_CODE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<SHIPMENT_DESCRIPTION_CODE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</SHIPMENT_DESCRIPTION_CODE>");
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

  public Object visit(Rule_NUMBER_OF_TOTAL_PIECES rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<NUMBER_OF_TOTAL_PIECES>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</NUMBER_OF_TOTAL_PIECES>");
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

  public Object visit(Rule_AIRPORT_CODE_OF_NEXT_DEST rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<AIRPORT_CODE_OF_NEXT_DEST>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</AIRPORT_CODE_OF_NEXT_DEST>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_CARRIER_CODE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<CARRIER_CODE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</CARRIER_CODE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_MOVEMENT_PRIORITY_CODE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MOVEMENT_PRIORITY_CODE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MOVEMENT_PRIORITY_CODE>");
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

  public Object visit(Rule_Hid_Customs_Reference rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Hid_Customs_Reference>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Hid_Customs_Reference>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_CUSTOMS_ORIGIN_CODE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<CUSTOMS_ORIGIN_CODE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</CUSTOMS_ORIGIN_CODE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Sub_ULD_Type rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Sub_ULD_Type>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Sub_ULD_Type>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Sub_ULD_Serial_Number rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Sub_ULD_Serial_Number>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Sub_ULD_Serial_Number>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Sub_ULD_Owner_Code rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Sub_ULD_Owner_Code>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Sub_ULD_Owner_Code>");
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

  public Object visit(Rule_ULD_REMARKS rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<ULD_REMARKS>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</ULD_REMARKS>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_ULD_VOLUME_AVAILABLE_CODE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<ULD_VOLUME_AVAILABLE_CODE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</ULD_VOLUME_AVAILABLE_CODE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_END_OF_MESSAGE_CODE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<END_OF_MESSAGE_CODE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</END_OF_MESSAGE_CODE>");
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
