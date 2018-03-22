package com.ke.css.cimp.fhl.fhl1;
/* -----------------------------------------------------------------------------
 * XmlDisplayer.java
 * -----------------------------------------------------------------------------
 *
 * Producer : com.parse2.aparse.Parser 2.5
 * Produced : Thu Feb 22 17:15:08 KST 2018
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
