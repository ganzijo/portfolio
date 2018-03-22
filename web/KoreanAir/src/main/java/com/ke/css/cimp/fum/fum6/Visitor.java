package com.ke.css.cimp.fum.fum6;
/* -----------------------------------------------------------------------------
 * Visitor.java
 * -----------------------------------------------------------------------------
 *
 * Producer : com.parse2.aparse.Parser 2.5
 * Produced : Mon Mar 05 14:07:52 KST 2018
 *
 * -----------------------------------------------------------------------------
 */

public interface Visitor
{
  public Object visit(Rule_MESSAGE rule);
  public Object visit(Rule_FUM rule);
  public Object visit(Rule_HEADER rule);
  public Object visit(Rule_SMI rule);
  public Object visit(Rule_MSU rule);
  public Object visit(Rule_ULD rule);
  public Object visit(Rule_Grp_ULD_Position_Information rule);
  public Object visit(Rule_Grp_ULD_Gross_Weight rule);
  public Object visit(Rule_Grp_ULD_Remarks rule);
  public Object visit(Rule_UMI rule);
  public Object visit(Rule_UMIS rule);
  public Object visit(Rule_Grp_ULD_Onward_Routing_Detail rule);
  public Object visit(Rule_Grp_ULD_Onward_Booking_Detail rule);
  public Object visit(Rule_Grp_ULD_Utilisation_Detail rule);
  public Object visit(Rule_UDI rule);
  public Object visit(Rule_UII rule);
  public Object visit(Rule_UCI rule);
  public Object visit(Rule_EIC rule);
  public Object visit(Rule_Grp_ULD_Identification_of_empty_EIC rule);
  public Object visit(Rule_ACD rule);
  public Object visit(Rule_AWB_NUMBER rule);
  public Object visit(Rule_Grp_Quantity_Detail rule);
  public Object visit(Rule_Grp_Volume_Detail rule);
  public Object visit(Rule_Grp_Density_Group rule);
  public Object visit(Rule_Grp_Total_Consignment_Pieces rule);
  public Object visit(Rule_Grp_ACD rule);
  public Object visit(Rule_Grp_ACD_1st rule);
  public Object visit(Rule_Grp_ACD_2nd rule);
  public Object visit(Rule_DIM rule);
  public Object visit(Rule_DIMS rule);
  public Object visit(Rule_CMI rule);
  public Object visit(Rule_CMIS rule);
  public Object visit(Rule_Grp_Onward_Routing_Detail rule);
  public Object visit(Rule_Grp_Onward_Booking_Detail rule);
  public Object visit(Rule_MPI rule);
  public Object visit(Rule_SPH rule);
  public Object visit(Rule_Grp_Special_Handling_Code rule);
  public Object visit(Rule_OSI rule);
  public Object visit(Rule_Grp_OSI_Details_1st_Line rule);
  public Object visit(Rule_Grp_OSI_Details_2nd_Line rule);
  public Object visit(Rule_COR rule);
  public Object visit(Rule_OCI rule);
  public Object visit(Rule_OCIS rule);
  public Object visit(Rule_HBS rule);
  public Object visit(Rule_MCI rule);
  public Object visit(Rule_STANDARD_MESSAGE_IDENTIFIER rule);
  public Object visit(Rule_MId_MSU rule);
  public Object visit(Rule_MId_ULD rule);
  public Object visit(Rule_MId_UMI rule);
  public Object visit(Rule_MId_UDI rule);
  public Object visit(Rule_MId_UII rule);
  public Object visit(Rule_MId_UCI rule);
  public Object visit(Rule_MId_EIC rule);
  public Object visit(Rule_MId_ACD rule);
  public Object visit(Rule_MId_DIM rule);
  public Object visit(Rule_MId_CMI rule);
  public Object visit(Rule_MId_MPI rule);
  public Object visit(Rule_MId_SPH rule);
  public Object visit(Rule_MId_OSI rule);
  public Object visit(Rule_MId_COR rule);
  public Object visit(Rule_MId_OCI rule);
  public Object visit(Rule_MId_HBS rule);
  public Object visit(Rule_IF_HUB_REFERENCE_KEY rule);
  public Object visit(Rule_MESSAGE_TYPE rule);
  public Object visit(Rule_MESSAGE_SUBTYPE rule);
  public Object visit(Rule_MESSAGE_RECEIVER rule);
  public Object visit(Rule_MESSAGE_SENDER rule);
  public Object visit(Rule_MESSAGE_TYPE_VERSION_NUMBER rule);
  public Object visit(Rule_MESSAGE_SEQUENCE_NUMBER rule);
  public Object visit(Rule_AIRPORT_CODE_OF_ULD_ORIGIN rule);
  public Object visit(Rule_DATE_OF_ULD_PREPARATION rule);
  public Object visit(Rule_ACTUAL_TIME_OF_ULD_PREPARATION rule);
  public Object visit(Rule_ULD_NUMBER rule);
  public Object visit(Rule_ULD_LOADING_INDICATOR rule);
  public Object visit(Rule_ULD_CONTOUR_CODE rule);
  public Object visit(Rule_ULD_GROSS_WEIGHT_CODE rule);
  public Object visit(Rule_ULD_GROSS_WEIGHT rule);
  public Object visit(Rule_ULD_REMARKS rule);
  public Object visit(Rule_AIRPORT_CODE_OF_NEXT_DEST rule);
  public Object visit(Rule_CARRIER_CODE rule);
  public Object visit(Rule_FLIGHT_NUMBER rule);
  public Object visit(Rule_DAY_OF_SCHEDULED_DPRT rule);
  public Object visit(Rule_MONTH_OF_SCHEDULED_DPRT rule);
  public Object visit(Rule_ULD_VOLUME_AVAILABLE_CODE rule);
  public Object visit(Rule_AIRPORT_CODE_OF_ULD_DEST rule);
  public Object visit(Rule_ULD_NUMBER_OF_THE_MAIN_ULD rule);
  public Object visit(Rule_ULD_NUMBER_OF_CONNECTED_ULD rule);
  public Object visit(Rule_ULD_NUMBER_OF_EMPTY_EIC rule);
  public Object visit(Rule_Sub_Airline_Prefix rule);
  public Object visit(Rule_Sub_AWB_Serial_Number rule);
  public Object visit(Rule_AIRPORT_CITY_CODE_OF_ORIGIN rule);
  public Object visit(Rule_AIRPORT_CITY_CODE_OF_DEST rule);
  public Object visit(Rule_SHIPMENT_DESCRIPTION_CODE rule);
  public Object visit(Rule_NUMBER_OF_PIECES rule);
  public Object visit(Rule_WEIGHT_CODE rule);
  public Object visit(Rule_WEIGHT rule);
  public Object visit(Rule_VOLUME_CODE rule);
  public Object visit(Rule_VOLUME_AMOUNT rule);
  public Object visit(Rule_DENSITY_INDICATOR rule);
  public Object visit(Rule_DENSITY_GROUP rule);
  public Object visit(Rule_Hid_Shipment_Description_Code_T rule);
  public Object visit(Rule_NUMBER_OF_TOTAL_PIECES rule);
  public Object visit(Rule_MANIFEST_DESC_OF_GOODS rule);
  public Object visit(Rule_MEASUREMENT_UNIT_CODE rule);
  public Object visit(Rule_LENGTH_DIMENSION rule);
  public Object visit(Rule_WIDTH_DIMENSION rule);
  public Object visit(Rule_HEIGHT_DIMENSION rule);
  public Object visit(Rule_NUMBERS_OF_PIECES rule);
  public Object visit(Rule_MOVEMENT_PRIORITY_CODE rule);
  public Object visit(Rule_SPECIAL_HANDLING_CODE rule);
  public Object visit(Rule_OTHER_SERVICE_INFORMATION_1 rule);
  public Object visit(Rule_OTHER_SERVICE_INFORMATION_2 rule);
  public Object visit(Rule_CUSTOMS_ORIGIN_CODE rule);
  public Object visit(Rule_ISO_COUNTRY_CODE rule);
  public Object visit(Rule_EXPIMP_IDENTIFIER rule);
  public Object visit(Rule_SYSTEM_IDENTIFIER rule);
  public Object visit(Rule_CUSTOMS_INFORMATION rule);
  public Object visit(Rule_HAWB_NUMBER rule);
  public Object visit(Rule_HAWB_AIRPORT_CODE_OF_ORIGIN rule);
  public Object visit(Rule_HAWB_AIRPORT_CODE_OF_DEST rule);
  public Object visit(Rule_HAWB_NUMBER_OF_PIECES rule);
  public Object visit(Rule_HAWB_WEIGHT_CODE rule);
  public Object visit(Rule_HAWB_WEIGHT rule);
  public Object visit(Rule_SLAC rule);
  public Object visit(Rule_M_NUMBER_OF_PIECES rule);
  public Object visit(Rule_M_WEIGHT_CODE rule);
  public Object visit(Rule_M_WEIGHT rule);
  public Object visit(Rule_END_OF_MESSAGE_CODE rule);
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
