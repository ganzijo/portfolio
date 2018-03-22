package com.ke.css.cimp.fhl.fhl2;
/* -----------------------------------------------------------------------------
 * Visitor.java
 * -----------------------------------------------------------------------------
 *
 * Producer : com.parse2.aparse.Parser 2.5
 * Produced : Thu Feb 22 17:14:24 KST 2018
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
  public Object visit(Rule_TXT rule);
  public Object visit(Rule_Grp_FREE_TEXT_DESCRIPTION_OF_GOODS rule);
  public Object visit(Rule_Grp_TXT_COM rule);
  public Object visit(Rule_Grp_TXT_FLT rule);
  public Object visit(Rule_Grp_TXT_DCS rule);
  public Object visit(Rule_Grp_TXT_SNM rule);
  public Object visit(Rule_Grp_TXT_SCC rule);
  public Object visit(Rule_Grp_TXT_SAR rule);
  public Object visit(Rule_Grp_TXT_CNM rule);
  public Object visit(Rule_Grp_TXT_CCC rule);
  public Object visit(Rule_Grp_TXT_CAR rule);
  public Object visit(Rule_SHP rule);
  public Object visit(Rule_Grp_SHIPPER_STATE_PROVINCE rule);
  public Object visit(Rule_Grp_SHIPPER_POST_CODE rule);
  public Object visit(Rule_SHIPPER_CONTACT rule);
  public Object visit(Rule_CNE rule);
  public Object visit(Rule_Grp_CONSIGNEE_STATE_PROVINCE rule);
  public Object visit(Rule_Grp_CONSIGNEE_POST_CODE rule);
  public Object visit(Rule_CONSIGNEE_CONTACT rule);
  public Object visit(Rule_CVD rule);
  public Object visit(Rule_STANDARD_MESSAGE_IDENTIFIER rule);
  public Object visit(Rule_MId_MBI rule);
  public Object visit(Rule_MId_HBS rule);
  public Object visit(Rule_MId_TXT rule);
  public Object visit(Rule_MId_SHP rule);
  public Object visit(Rule_MId_CNE rule);
  public Object visit(Rule_MId_CVD rule);
  public Object visit(Rule_MId_COM rule);
  public Object visit(Rule_MId_FLT rule);
  public Object visit(Rule_MId_DCS rule);
  public Object visit(Rule_MId_SNM rule);
  public Object visit(Rule_MId_SCC rule);
  public Object visit(Rule_MId_SAR rule);
  public Object visit(Rule_MId_CNM rule);
  public Object visit(Rule_MId_CCC rule);
  public Object visit(Rule_MId_CAR rule);
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
  public Object visit(Rule_FREE_TEXT_DESCRIPTION_OF_GOODS rule);
  public Object visit(Rule_COMMODITY_DETAIL_FOR_KCUS rule);
  public Object visit(Rule_DPRT_ARRV_DATE_FOR_KCUS rule);
  public Object visit(Rule_FLIGHT_NUMBER_FOR_KCUS rule);
  public Object visit(Rule_FORWARDER_CODE_FOR_KCUS rule);
  public Object visit(Rule_ASSIGN_PLACE_FOR_KCUS rule);
  public Object visit(Rule_LOAD_PLACE_FOR_KCUS rule);
  public Object visit(Rule_FORWARDER_NAME_FOR_KCUS rule);
  public Object visit(Rule_SHIPPER_NAME_FOR_KCUS rule);
  public Object visit(Rule_SHIPPER_ADDRESS_FOR_KCUS rule);
  public Object visit(Rule_CONSIGNEE_NAME_FOR_KCUS rule);
  public Object visit(Rule_CONSIGNEE_POST_CODE_FOR_KUS rule);
  public Object visit(Rule_CONSIGNEE_ADDRESS_FOR_KCUS rule);
  public Object visit(Rule_SHIPPER_POST_CODE_FOR_KCUS rule);
  public Object visit(Rule_SHIPPER_NAME rule);
  public Object visit(Rule_SHIPPER_STREET_ADDRESS rule);
  public Object visit(Rule_SHIPPER_PLACE rule);
  public Object visit(Rule_SHIPPER_STATE_PROVINCE rule);
  public Object visit(Rule_SHIPPER_ISO_COUNTRY_CODE rule);
  public Object visit(Rule_SHIPPER_POST_CODE rule);
  public Object visit(Rule_SHIPPER_CONTACT_IDENTIFIER rule);
  public Object visit(Rule_SHIPPER_CONTACT_NUMBER rule);
  public Object visit(Rule_CONSIGNEE_NAME rule);
  public Object visit(Rule_CONSIGNEE_STREET_ADDRESS rule);
  public Object visit(Rule_CONSIGNEE_PLACE rule);
  public Object visit(Rule_CONSIGNEE_STATE_PROVINCE rule);
  public Object visit(Rule_CONSIGNEE_ISO_COUNTRY_CODE rule);
  public Object visit(Rule_CONSIGNEE_POST_CODE rule);
  public Object visit(Rule_CONSIGNEE_CONTACT_IDENTIFIER rule);
  public Object visit(Rule_CONSIGNEE_CONTACT_NUMBER rule);
  public Object visit(Rule_ISO_CURRENCY_CODE rule);
  public Object visit(Rule_P_C_IND_WEIGHT_VALUATION rule);
  public Object visit(Rule_P_C_IND_OTHER_CHARGES rule);
  public Object visit(Rule_DECLARED_VALUE_FOR_CARRIAGE rule);
  public Object visit(Rule_DECLARED_VALUE_FOR_CUSTOMS rule);
  public Object visit(Rule_DECLARE_VALUE_FOR_INSURANCE rule);
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
