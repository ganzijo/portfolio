package com.ke.css.cimp.ffr.ffr7;
/* -----------------------------------------------------------------------------
 * Displayer.java
 * -----------------------------------------------------------------------------
 *
 * Producer : com.parse2.aparse.Parser 2.5
 * Produced : Fri Feb 23 14:31:14 KST 2018
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

  public Object visit(Rule_FFR rule)
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

  public Object visit(Rule_AWB rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_AWB_NUMBER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Quantity_Detail rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Volume_Detail rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Density_Group rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Total_Consignment_Pieces rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Nature_of_Goods rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Special_Handling_Requirements rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_FLT rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Flight_Identification rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_FLIGHT_NUMBER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Allotment_Identification rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_ULD rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_ULD_Repeated rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_ULDS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_ULD_Position_Information rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Weight_of_ULD_Contents rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_SSR rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_SSR_Details_1stLine rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_SSR_Details_2ndLine rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_OSI rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_OSI_Details_1stLine rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_OSI_Details_2ndLine rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_REF rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Requesting_Office_Message_Address rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Requesting_Participant_Identification rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_DIM rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_DIMS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_PID rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_SHP rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Account_Detail_SHP rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Name_SHP rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Street_Address_SHP rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Location_SHP rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Coded_Location_SHP rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_CONTACTS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_CNE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Account_Detail_CNE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Name_CNE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Street_Address_CNE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Location_CNE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Coded_Location_CNE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_CUS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Account_Detail_CUS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_IATA_CARGO_AGENT_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Name_CUS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Place_CUS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_SRI rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_STANDARD_MESSAGE_IDENTIFIER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_ULD rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_SSR rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_OSI rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_REF rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_DIM rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_PID rule)
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

  public Object visit(Rule_MId_CUS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_SRI rule)
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

  public Object visit(Rule_AIRPORT_CITY_CODE_OF_ORIGIN rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_AIRPORT_CITY_CODE_OF_DEST rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Hid_Shipment_Description_Code_T_P rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_NUMBER_OF_PIECES rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_WEIGHT_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_WEIGHT rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_VOLUME_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_VOLUME_AMOUNT rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Hid_Density_Indicator rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_DENSITY_GROUP rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Hid_Shipment_Description_Code_T rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_NUMBER_OF_PIECES_T rule)
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

  public Object visit(Rule_Sub_Carrier_Code rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Sub_Flight_Number rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_DAY_OF_SCHEDULED_DPRT rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MONTH_OF_SCHEDULED_DPRT rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_AIRPORT_CODE_OF_DEPARTURE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_AIRPORT_CODE_OF_ARRIVAL rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_SPACE_ALLOCATION_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_ALLOTMENT_IDENTIFICATION rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_NUMBER_OF_ULDS_TOTAL rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_ULD_TYPE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_ULD_SERIAL_NUMBER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_ULD_OWNER_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_ULD_LOADING_INDICATOR rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_SPECIAL_SERVICE_REQUEST_1 rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_SPECIAL_SERVICE_REQUEST_2 rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_OTHER_SERVICE_INFORMATION_1 rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_OTHER_SERVICE_INFORMATION_2 rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_RQST_OFC_AIRPORT_CITY_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_OFFICE_FUNCTION_DESIGNATOR rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_COMPANY_DESIGNATOR rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_BOOKING_FILE_REFERENCE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_PARTICIPANT_IDENTIFIER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_PARTICIPANT_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_PARTI_AIRPORT_CITY_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MEASUREMENT_UNIT_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_LENGTH_DIMENSION rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_WIDTH_DIMENSION rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_HEIGHT_DIMENSION rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_NUMBERS_OF_PIECES rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_SERVICE_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_RATE_CLASS_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_COMMODITY_ITEM_NUMBER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Hid_InformID_NAM rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Hid_InformID_ADR rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Hid_InformID_LOC rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_SHIPPER_ACCOUNT_NUMBER rule)
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

  public Object visit(Rule_CONTACT_IDENTIFIER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_CONTACT_NUMBER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_CONSIGNEE_ACCOUNT_NUMBER rule)
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

  public Object visit(Rule_AGENT_ACCOUNT_NUMBER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Sub_IATA_Cargo_Agent_Numeric_Code rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Sub_Cargo_Agent_CASS_Address rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_AGENT_PARTICIPANT_IDENTIFIER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_AGENT_NAME rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_AGENT_PLACE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_SHIPMENT_REFERENCE_NUMBER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_SHIPMENT_INFORMATION_1 rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_SHIPMENT_INFORMATION_2 rule)
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
