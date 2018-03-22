package com.ke.css.cimp.fhl.fhl4;
/* -----------------------------------------------------------------------------
 * Displayer.java
 * -----------------------------------------------------------------------------
 *
 * Producer : com.parse2.aparse.Parser 2.5
 * Produced : Thu Feb 22 17:12:45 KST 2018
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

  public Object visit(Rule_TXT rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_FREE_TEXT_DESCRIPTION_OF_GOODS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_TXT_COM rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_TXT_FLT rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_TXT_DCS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_TXT_SNM rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_TXT_SCC rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_TXT_SAR rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_TXT_CNM rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_TXT_CCC rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_TXT_CAR rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_HTS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_HARMONISED_COMMODITY_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_OCI rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_OCIS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_ISO_COUNTRY_CODE_KR rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_EXPIMP_IDENTIFIER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_KR_EXP rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_KR_IMP rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_ISO_COUNTRY_CODE_OTHER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_SHP rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_SHIPPER_STATE_PROVINCE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_SHIPPER_POST_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_SHIPPER_CONTACT rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_CNE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_CONSIGNEE_STATE_PROVINCE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_CONSIGNEE_POST_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_CONSIGNEE_CONTACT rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_CVD rule)
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

  public Object visit(Rule_MId_TXT rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_HTS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_OCI rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_SHP rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_CNE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_CVD rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_COM rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_FLT rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_DCS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_SNM rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_SCC rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_SAR rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_CNM rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_CCC rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_CAR rule)
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

  public Object visit(Rule_SPECIAL_HANDLING_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_FREE_TEXT_DESCRIPTION_OF_GOODS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_COMMODITY_DETAIL_FOR_KCUS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_DPRT_ARRV_DATE_FOR_KCUS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_FLIGHT_NUMBER_FOR_KCUS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_FORWARDER_CODE_FOR_KCUS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_ASSIGN_PLACE_FOR_KCUS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_LOAD_PLACE_FOR_KCUS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_FORWARDER_NAME_FOR_KCUS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_SHIPPER_NAME_FOR_KCUS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_SHIPPER_ADDRESS_FOR_KCUS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_CONSIGNEE_NAME_FOR_KCUS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_CONSIGNEE_POST_CODE_FOR_KUS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_CONSIGNEE_ADDRESS_FOR_KCUS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_SHIPPER_POST_CODE_FOR_KCUS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_HARMONISED_COMMODITY_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_ISO_COUNTRY_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_EXPIMP_IDENTIFIER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_TRANSPORT_IDENTIFIER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_HSN_NUMBER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_EPN_NUMBER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_EXP_PACKING_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_EXP_NUMBER_OF_PIECES rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_EXP_PACKING_TYPE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_EPN_SEQ rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_EPN_NUMBER_OF_PIECES rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_EPN_WEIGHT rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_EPN_DIVISION_IDENTIFIER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_EPN_DIVISION_DIMENSION rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_LOAD_COMMODITY_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_SYSTEM_IDENTIFIER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_OCI_DESCRIPTION rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_SHIPPER_NAME rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_SHIPPER_STREET_ADDRESS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_SHIPPER_PLACE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_SHIPPER_STATE_PROVINCE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_SHIPPER_ISO_COUNTRY_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_SHIPPER_POST_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_SHIPPER_CONTACT_IDENTIFIER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_SHIPPER_CONTACT_NUMBER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_CONSIGNEE_NAME rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_CONSIGNEE_STREET_ADDRESS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_CONSIGNEE_PLACE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_CONSIGNEE_STATE_PROVINCE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_CONSIGNEE_ISO_COUNTRY_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_CONSIGNEE_POST_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_CONSIGNEE_CONTACT_IDENTIFIER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_CONSIGNEE_CONTACT_NUMBER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_ISO_CURRENCY_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_P_C_IND_WEIGHT_VALUATION rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_P_C_IND_OTHER_CHARGES rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_DECLARED_VALUE_FOR_CARRIAGE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_DECLARED_VALUE_FOR_CUSTOMS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_DECLARE_VALUE_FOR_INSURANCE rule)
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
