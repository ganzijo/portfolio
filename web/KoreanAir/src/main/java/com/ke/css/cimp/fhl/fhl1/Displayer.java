package com.ke.css.cimp.fhl.fhl1;
/* -----------------------------------------------------------------------------
 * Displayer.java
 * -----------------------------------------------------------------------------
 *
 * Producer : com.parse2.aparse.Parser 2.5
 * Produced : Thu Feb 22 17:15:08 KST 2018
 *
 * -----------------------------------------------------------------------------
 */

import java.util.ArrayList;

public class Displayer implements Visitor
{

  public Object visit(Rule_MESSAGE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_FHL rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_HEADER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_SMI rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MBI rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MAWB_NUMBER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_HBS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Grp_SPECIAL_HANDLING_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_STANDARD_MESSAGE_IDENTIFIER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_MBI rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_HBS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_IF_HUB_REFERENCE_KEY rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MESSAGE_TYPE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MESSAGE_SUBTYPE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MESSAGE_RECEIVER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MESSAGE_SENDER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MESSAGE_TYPE_VERSION_NUMBER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Sub_AWB_Prefix rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Sub_AWB_SerialNum rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MAWB_AIRPORT_CODE_OF_ORIGIN rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MAWB_AIRPORT_CODE_OF_DEST rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Hid_AWB_ShipCode rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MAWB_NUMBER_OF_PIECES rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MAWB_WEIGHT_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MAWB_WEIGHT rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_HAWB_NUMBER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_HAWB_AIRPORT_CODE_OF_ORIGIN rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_HAWB_AIRPORT_CODE_OF_DEST rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_HAWB_NUMBER_OF_PIECES rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_HAWB_WEIGHT_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_HAWB_WEIGHT rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_SLAC rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MANIFEST_DESC_OF_GOODS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_SPECIAL_HANDLING_CODE_1 rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_SPECIAL_HANDLING_CODE_2 rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Sep_CRLF rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_CR rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_LF rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Sep_Slant rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Sep_Bar rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Typ_Alpha rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Typ_Numeric rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Typ_Decimal rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Typ_Mixed rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Typ_Text rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Terminal_StringValue value)
  {
    System.out.print(value.spelling);
    return null;
  }

  public Object visit(Terminal_NumericValue value)
  {
    System.out.print(value.spelling);
    return null;
  }

  private Object visitRules(ArrayList<Rule> rules)
  {
    for (Rule rule : rules)
      rule.accept(this);
    return null;
  }
}

/* -----------------------------------------------------------------------------
 * eof
 * -----------------------------------------------------------------------------
 */
