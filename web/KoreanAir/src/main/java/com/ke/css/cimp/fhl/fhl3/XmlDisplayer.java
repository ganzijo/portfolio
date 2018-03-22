package com.ke.css.cimp.fhl.fhl3;
/* -----------------------------------------------------------------------------
 * XmlDisplayer.java
 * -----------------------------------------------------------------------------
 *
 * Producer : com.parse2.aparse.Parser 2.5
 * Produced : Thu Feb 22 17:13:36 KST 2018
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

  public Object visit(Rule_FHL rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<FHL>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</FHL>");
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

  public Object visit(Rule_MBI rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MBI>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MBI>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_MAWB_NUMBER rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MAWB_NUMBER>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MAWB_NUMBER>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_HBS rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<HBS>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</HBS>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_Grp_SPECIAL_HANDLING_CODE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_Grp_SPECIAL_HANDLING_CODE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_Grp_SPECIAL_HANDLING_CODE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_TXT rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<TXT>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</TXT>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_FREE_TEXT_DESCRIPTION_OF_GOODS rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_FREE_TEXT_DESCRIPTION_OF_GOODS>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_FREE_TEXT_DESCRIPTION_OF_GOODS>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_TXT_COM rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_TXT_COM>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_TXT_COM>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_TXT_FLT rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_TXT_FLT>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_TXT_FLT>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_TXT_DCS rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_TXT_DCS>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_TXT_DCS>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_TXT_SNM rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_TXT_SNM>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_TXT_SNM>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_TXT_SCC rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_TXT_SCC>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_TXT_SCC>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_TXT_SAR rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_TXT_SAR>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_TXT_SAR>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_TXT_CNM rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_TXT_CNM>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_TXT_CNM>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_TXT_CCC rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_TXT_CCC>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_TXT_CCC>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_TXT_CAR rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_TXT_CAR>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_TXT_CAR>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_HTS rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<HTS>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</HTS>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_HARMONISED_COMMODITY_CODE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_HARMONISED_COMMODITY_CODE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_HARMONISED_COMMODITY_CODE>");
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

  public Object visit(Rule_Grp_SHIPPER_STATE_PROVINCE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_SHIPPER_STATE_PROVINCE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_SHIPPER_STATE_PROVINCE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_SHIPPER_POST_CODE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_SHIPPER_POST_CODE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_SHIPPER_POST_CODE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_SHIPPER_CONTACT rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<SHIPPER_CONTACT>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</SHIPPER_CONTACT>");
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

  public Object visit(Rule_Grp_CONSIGNEE_STATE_PROVINCE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_CONSIGNEE_STATE_PROVINCE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_CONSIGNEE_STATE_PROVINCE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Grp_CONSIGNEE_POST_CODE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Grp_CONSIGNEE_POST_CODE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Grp_CONSIGNEE_POST_CODE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_CONSIGNEE_CONTACT rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<CONSIGNEE_CONTACT>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</CONSIGNEE_CONTACT>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_CVD rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<CVD>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</CVD>");
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

  public Object visit(Rule_MId_MBI rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MId_MBI>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MId_MBI>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_MId_HBS rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MId_HBS>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MId_HBS>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_MId_TXT rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MId_TXT>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MId_TXT>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_MId_HTS rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MId_HTS>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MId_HTS>");
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

  public Object visit(Rule_MId_CVD rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MId_CVD>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MId_CVD>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_MId_COM rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MId_COM>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MId_COM>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_MId_FLT rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MId_FLT>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MId_FLT>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_MId_DCS rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MId_DCS>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MId_DCS>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_MId_SNM rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MId_SNM>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MId_SNM>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_MId_SCC rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MId_SCC>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MId_SCC>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_MId_SAR rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MId_SAR>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MId_SAR>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_MId_CNM rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MId_CNM>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MId_CNM>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_MId_CCC rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MId_CCC>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MId_CCC>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_MId_CAR rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MId_CAR>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MId_CAR>");
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

  public Object visit(Rule_MAWB_AIRPORT_CODE_OF_ORIGIN rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MAWB_AIRPORT_CODE_OF_ORIGIN>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MAWB_AIRPORT_CODE_OF_ORIGIN>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_MAWB_AIRPORT_CODE_OF_DEST rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MAWB_AIRPORT_CODE_OF_DEST>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MAWB_AIRPORT_CODE_OF_DEST>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_Hid_AWB_ShipCode rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<Hid_AWB_ShipCode>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</Hid_AWB_ShipCode>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_MAWB_NUMBER_OF_PIECES rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MAWB_NUMBER_OF_PIECES>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MAWB_NUMBER_OF_PIECES>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_MAWB_WEIGHT_CODE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MAWB_WEIGHT_CODE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MAWB_WEIGHT_CODE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_MAWB_WEIGHT rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<MAWB_WEIGHT>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</MAWB_WEIGHT>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_HAWB_NUMBER rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<HAWB_NUMBER>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</HAWB_NUMBER>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_HAWB_AIRPORT_CODE_OF_ORIGIN rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<HAWB_AIRPORT_CODE_OF_ORIGIN>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</HAWB_AIRPORT_CODE_OF_ORIGIN>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_HAWB_AIRPORT_CODE_OF_DEST rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<HAWB_AIRPORT_CODE_OF_DEST>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</HAWB_AIRPORT_CODE_OF_DEST>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_HAWB_NUMBER_OF_PIECES rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<HAWB_NUMBER_OF_PIECES>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</HAWB_NUMBER_OF_PIECES>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_HAWB_WEIGHT_CODE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<HAWB_WEIGHT_CODE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</HAWB_WEIGHT_CODE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_HAWB_WEIGHT rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<HAWB_WEIGHT>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</HAWB_WEIGHT>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_SLAC rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<SLAC>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</SLAC>");
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

  public Object visit(Rule_SPECIAL_HANDLING_CODE_1 rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<SPECIAL_HANDLING_CODE_1>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</SPECIAL_HANDLING_CODE_1>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_SPECIAL_HANDLING_CODE_2 rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<SPECIAL_HANDLING_CODE_2>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</SPECIAL_HANDLING_CODE_2>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_FREE_TEXT_DESCRIPTION_OF_GOODS rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<FREE_TEXT_DESCRIPTION_OF_GOODS>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</FREE_TEXT_DESCRIPTION_OF_GOODS>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_COMMODITY_DETAIL_FOR_KCUS rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<COMMODITY_DETAIL_FOR_KCUS>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</COMMODITY_DETAIL_FOR_KCUS>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_DPRT_ARRV_DATE_FOR_KCUS rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<DPRT_ARRV_DATE_FOR_KCUS>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</DPRT_ARRV_DATE_FOR_KCUS>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_FLIGHT_NUMBER_FOR_KCUS rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<FLIGHT_NUMBER_FOR_KCUS>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</FLIGHT_NUMBER_FOR_KCUS>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_FORWARDER_CODE_FOR_KCUS rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<FORWARDER_CODE_FOR_KCUS>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</FORWARDER_CODE_FOR_KCUS>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_ASSIGN_PLACE_FOR_KCUS rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<ASSIGN_PLACE_FOR_KCUS>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</ASSIGN_PLACE_FOR_KCUS>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_LOAD_PLACE_FOR_KCUS rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<LOAD_PLACE_FOR_KCUS>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</LOAD_PLACE_FOR_KCUS>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_FORWARDER_NAME_FOR_KCUS rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<FORWARDER_NAME_FOR_KCUS>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</FORWARDER_NAME_FOR_KCUS>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_SHIPPER_NAME_FOR_KCUS rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<SHIPPER_NAME_FOR_KCUS>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</SHIPPER_NAME_FOR_KCUS>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_SHIPPER_ADDRESS_FOR_KCUS rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<SHIPPER_ADDRESS_FOR_KCUS>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</SHIPPER_ADDRESS_FOR_KCUS>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_CONSIGNEE_NAME_FOR_KCUS rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<CONSIGNEE_NAME_FOR_KCUS>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</CONSIGNEE_NAME_FOR_KCUS>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_CONSIGNEE_POST_CODE_FOR_KUS rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<CONSIGNEE_POST_CODE_FOR_KUS>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</CONSIGNEE_POST_CODE_FOR_KUS>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_CONSIGNEE_ADDRESS_FOR_KCUS rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<CONSIGNEE_ADDRESS_FOR_KCUS>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</CONSIGNEE_ADDRESS_FOR_KCUS>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_SHIPPER_POST_CODE_FOR_KCUS rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<SHIPPER_POST_CODE_FOR_KCUS>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</SHIPPER_POST_CODE_FOR_KCUS>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_HARMONISED_COMMODITY_CODE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<HARMONISED_COMMODITY_CODE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</HARMONISED_COMMODITY_CODE>");
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

  public Object visit(Rule_SHIPPER_CONTACT_IDENTIFIER rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<SHIPPER_CONTACT_IDENTIFIER>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</SHIPPER_CONTACT_IDENTIFIER>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_SHIPPER_CONTACT_NUMBER rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<SHIPPER_CONTACT_NUMBER>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</SHIPPER_CONTACT_NUMBER>");
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

  public Object visit(Rule_CONSIGNEE_CONTACT_IDENTIFIER rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<CONSIGNEE_CONTACT_IDENTIFIER>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</CONSIGNEE_CONTACT_IDENTIFIER>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_CONSIGNEE_CONTACT_NUMBER rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<CONSIGNEE_CONTACT_NUMBER>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</CONSIGNEE_CONTACT_NUMBER>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_ISO_CURRENCY_CODE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<ISO_CURRENCY_CODE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</ISO_CURRENCY_CODE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_P_C_IND_WEIGHT_VALUATION rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<P_C_IND_WEIGHT_VALUATION>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</P_C_IND_WEIGHT_VALUATION>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_P_C_IND_OTHER_CHARGES rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<P_C_IND_OTHER_CHARGES>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</P_C_IND_OTHER_CHARGES>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_DECLARED_VALUE_FOR_CARRIAGE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<DECLARED_VALUE_FOR_CARRIAGE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</DECLARED_VALUE_FOR_CARRIAGE>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_DECLARED_VALUE_FOR_CUSTOMS rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<DECLARED_VALUE_FOR_CUSTOMS>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</DECLARED_VALUE_FOR_CUSTOMS>");
    terminal = false;
    return null;
  }

  public Object visit(Rule_DECLARE_VALUE_FOR_INSURANCE rule)
  {
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "\n");
    xmlMaker.addXmlData(rule.getClass().toString(),"<DECLARE_VALUE_FOR_INSURANCE>");
    terminal = false;
    visitRules(rule.rules);
    if (!terminal) xmlMaker.addXmlData(rule.getClass().toString(), "");
    xmlMaker.addXmlData(rule.getClass().toString(),"</DECLARE_VALUE_FOR_INSURANCE>");
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
