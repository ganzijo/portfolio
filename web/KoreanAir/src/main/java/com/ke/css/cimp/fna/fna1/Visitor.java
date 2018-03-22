package com.ke.css.cimp.fna.fna1;
/* -----------------------------------------------------------------------------
 * Visitor.java
 * -----------------------------------------------------------------------------
 *
 * Producer : com.parse2.aparse.Parser 2.5
 * Produced : Tue Feb 27 09:51:44 KST 2018
 *
 * -----------------------------------------------------------------------------
 */

public interface Visitor
{
  public Object visit(Rule_MESSAGE rule);
  public Object visit(Rule_FNA rule);
  public Object visit(Rule_HEADER rule);
  public Object visit(Rule_SMI rule);
  public Object visit(Rule_ACK rule);
  public Object visit(Rule_Grp_REASON_FOR_REJECTION_ERROR rule);
  public Object visit(Rule_STANDARD_MESSAGE_IDENTIFIER rule);
  public Object visit(Rule_MId_ACK rule);
  public Object visit(Rule_IF_HUB_REFERENCE_KEY rule);
  public Object visit(Rule_MESSAGE_TYPE rule);
  public Object visit(Rule_MESSAGE_SUBTYPE rule);
  public Object visit(Rule_MESSAGE_RECEIVER rule);
  public Object visit(Rule_MESSAGE_SENDER rule);
  public Object visit(Rule_MESSAGE_TYPE_VERSION_NUMBER rule);
  public Object visit(Rule_REASON_FOR_REJECTION_ERROR rule);
  public Object visit(Rule_RECEIVED_MESSAGE_DETAIL rule);
  public Object visit(Rule_RECEIVED_MESSAGE_TYPE rule);
  public Object visit(Rule_RECEIVED_MESSAGE_VERSION rule);
  public Object visit(Rule_MAWB_NUMBER rule);
  public Object visit(Rule_HAWB_NUMBER rule);
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
  public Object visit(Rule_Typ_ErrorMsg rule);

  public Object visit(Terminal_StringValue value);
  public Object visit(Terminal_NumericValue value);
}

/* -----------------------------------------------------------------------------
 * eof
 * -----------------------------------------------------------------------------
 */
