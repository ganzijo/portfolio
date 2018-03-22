package com.ke.css.cimp.ffr.ffr1;
/* -----------------------------------------------------------------------------
 * Visitor.java
 * -----------------------------------------------------------------------------
 *
 * Producer : com.parse2.aparse.Parser 2.5
 * Produced : Fri Feb 23 14:21:26 KST 2018
 *
 * -----------------------------------------------------------------------------
 */

public interface Visitor
{
  public Object visit(Rule_MESSAGE rule);
  public Object visit(Rule_FFR rule);
  public Object visit(Rule_HEADER rule);
  public Object visit(Rule_SMI rule);
  public Object visit(Rule_AWB rule);
  public Object visit(Rule_AWB_NUMBER rule);
  public Object visit(Rule_Grp_Quantity_Detail rule);
  public Object visit(Rule_Grp_Volume_Detail rule);
  public Object visit(Rule_Grp_Density_Group rule);
  public Object visit(Rule_Grp_Total_Consignment_Pieces rule);
  public Object visit(Rule_Grp_Nature_of_Goods rule);
  public Object visit(Rule_Grp_Special_Handling_Requirements rule);
  public Object visit(Rule_FLT rule);
  public Object visit(Rule_Grp_Flight_Identification rule);
  public Object visit(Rule_FLIGHT_NUMBER rule);
  public Object visit(Rule_Grp_Allotment_Identification rule);
  public Object visit(Rule_ULD rule);
  public Object visit(Rule_Grp_ULD_Repeated rule);
  public Object visit(Rule_ULDS rule);
  public Object visit(Rule_Grp_ULD_Position_Information rule);
  public Object visit(Rule_Grp_Weight_of_ULD_Contents rule);
  public Object visit(Rule_SSR rule);
  public Object visit(Rule_Grp_SSR_Details_1stLine rule);
  public Object visit(Rule_Grp_SSR_Details_2ndLine rule);
  public Object visit(Rule_OSI rule);
  public Object visit(Rule_Grp_OSI_Details_1stLine rule);
  public Object visit(Rule_Grp_OSI_Details_2ndLine rule);
  public Object visit(Rule_REF rule);
  public Object visit(Rule_Grp_Requesting_Office_Message_Address rule);
  public Object visit(Rule_STANDARD_MESSAGE_IDENTIFIER rule);
  public Object visit(Rule_MId_ULD rule);
  public Object visit(Rule_MId_SSR rule);
  public Object visit(Rule_MId_OSI rule);
  public Object visit(Rule_MId_REF rule);
  public Object visit(Rule_IF_HUB_REFERENCE_KEY rule);
  public Object visit(Rule_MESSAGE_TYPE rule);
  public Object visit(Rule_MESSAGE_SUBTYPE rule);
  public Object visit(Rule_MESSAGE_RECEIVER rule);
  public Object visit(Rule_MESSAGE_SENDER rule);
  public Object visit(Rule_MESSAGE_TYPE_VERSION_NUMBER rule);
  public Object visit(Rule_Sub_AWB_Prefix rule);
  public Object visit(Rule_Sub_AWB_SerialNum rule);
  public Object visit(Rule_AIRPORT_CITY_CODE_OF_ORIGIN rule);
  public Object visit(Rule_AIRPORT_CITY_CODE_OF_DEST rule);
  public Object visit(Rule_Hid_Shipment_Description_Code_T_P rule);
  public Object visit(Rule_NUMBER_OF_PIECES rule);
  public Object visit(Rule_WEIGHT_CODE rule);
  public Object visit(Rule_WEIGHT rule);
  public Object visit(Rule_VOLUME_CODE rule);
  public Object visit(Rule_VOLUME_AMOUNT rule);
  public Object visit(Rule_Hid_Density_Indicator rule);
  public Object visit(Rule_DENSITY_GROUP rule);
  public Object visit(Rule_Hid_Shipment_Description_Code_T rule);
  public Object visit(Rule_NUMBER_OF_PIECES_T rule);
  public Object visit(Rule_MANIFEST_DESC_OF_GOODS rule);
  public Object visit(Rule_SPECIAL_HANDLING_CODE rule);
  public Object visit(Rule_Sub_Carrier_Code rule);
  public Object visit(Rule_Sub_Flight_Number rule);
  public Object visit(Rule_DAY_OF_SCHEDULED_DPRT rule);
  public Object visit(Rule_MONTH_OF_SCHEDULED_DPRT rule);
  public Object visit(Rule_AIRPORT_CODE_OF_DEPARTURE rule);
  public Object visit(Rule_AIRPORT_CODE_OF_ARRIVAL rule);
  public Object visit(Rule_SPACE_ALLOCATION_CODE rule);
  public Object visit(Rule_ALLOTMENT_IDENTIFICATION rule);
  public Object visit(Rule_NUMBER_OF_ULDS_TOTAL rule);
  public Object visit(Rule_ULD_TYPE rule);
  public Object visit(Rule_ULD_SERIAL_NUMBER rule);
  public Object visit(Rule_ULD_OWNER_CODE rule);
  public Object visit(Rule_ULD_LOADING_INDICATOR rule);
  public Object visit(Rule_SPECIAL_SERVICE_REQUEST_1 rule);
  public Object visit(Rule_SPECIAL_SERVICE_REQUEST_2 rule);
  public Object visit(Rule_OTHER_SERVICE_INFORMATION_1 rule);
  public Object visit(Rule_OTHER_SERVICE_INFORMATION_2 rule);
  public Object visit(Rule_RQST_OFC_AIRPORT_CITY_CODE rule);
  public Object visit(Rule_OFFICE_FUNCTION_DESIGNATOR rule);
  public Object visit(Rule_COMPANY_DESIGNATOR rule);
  public Object visit(Rule_BOOKING_FILE_REFERENCE rule);
  public Object visit(Rule_PARTICIPANT_IDENTIFIER rule);
  public Object visit(Rule_PARTICIPANT_CODE rule);
  public Object visit(Rule_PARTI_AIRPORT_CITY_CODE rule);
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
