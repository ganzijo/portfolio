package com.ke.css.cimp.fhl.fhl1;
/* -----------------------------------------------------------------------------
 * Visitor.java
 * -----------------------------------------------------------------------------
 *
 * Producer : com.parse2.aparse.Parser 2.5
 * Produced : Thu Feb 22 17:15:08 KST 2018
 *
 * -----------------------------------------------------------------------------
 */

public interface Visitor
{
  public Object visit(Rule_MESSAGE rule);
  public Object visit(Rule_FHL rule);
  public Object visit(Rule_HEADER rule);
  public Object visit(Rule_SMI rule);
  public Object visit(Rule_MBI rule);
  public Object visit(Rule_MAWB_NUMBER rule);
  public Object visit(Rule_HBS rule);
  public Object visit(Rule_Grp_Grp_SPECIAL_HANDLING_CODE rule);
  public Object visit(Rule_STANDARD_MESSAGE_IDENTIFIER rule);
  public Object visit(Rule_MId_MBI rule);
  public Object visit(Rule_MId_HBS rule);
  public Object visit(Rule_IF_HUB_REFERENCE_KEY rule);
  public Object visit(Rule_MESSAGE_TYPE rule);
  public Object visit(Rule_MESSAGE_SUBTYPE rule);
  public Object visit(Rule_MESSAGE_RECEIVER rule);
  public Object visit(Rule_MESSAGE_SENDER rule);
  public Object visit(Rule_MESSAGE_TYPE_VERSION_NUMBER rule);
  public Object visit(Rule_Sub_AWB_Prefix rule);
  public Object visit(Rule_Sub_AWB_SerialNum rule);
  public Object visit(Rule_MAWB_AIRPORT_CODE_OF_ORIGIN rule);
  public Object visit(Rule_MAWB_AIRPORT_CODE_OF_DEST rule);
  public Object visit(Rule_Hid_AWB_ShipCode rule);
  public Object visit(Rule_MAWB_NUMBER_OF_PIECES rule);
  public Object visit(Rule_MAWB_WEIGHT_CODE rule);
  public Object visit(Rule_MAWB_WEIGHT rule);
  public Object visit(Rule_HAWB_NUMBER rule);
  public Object visit(Rule_HAWB_AIRPORT_CODE_OF_ORIGIN rule);
  public Object visit(Rule_HAWB_AIRPORT_CODE_OF_DEST rule);
  public Object visit(Rule_HAWB_NUMBER_OF_PIECES rule);
  public Object visit(Rule_HAWB_WEIGHT_CODE rule);
  public Object visit(Rule_HAWB_WEIGHT rule);
  public Object visit(Rule_SLAC rule);
  public Object visit(Rule_MANIFEST_DESC_OF_GOODS rule);
  public Object visit(Rule_SPECIAL_HANDLING_CODE_1 rule);
  public Object visit(Rule_SPECIAL_HANDLING_CODE_2 rule);
  public Object visit(Rule_Sep_CRLF rule);
  public Object visit(Rule_CR rule);
  public Object visit(Rule_LF rule);
  public Object visit(Rule_Sep_Slant rule);
  public Object visit(Rule_Sep_Bar rule);
  public Object visit(Rule_Typ_Alpha rule);
  public Object visit(Rule_Typ_Numeric rule);
  public Object visit(Rule_Typ_Decimal rule);
  public Object visit(Rule_Typ_Mixed rule);
  public Object visit(Rule_Typ_Text rule);

  public Object visit(Terminal_StringValue value);
  public Object visit(Terminal_NumericValue value);
}

/* -----------------------------------------------------------------------------
 * eof
 * -----------------------------------------------------------------------------
 */
