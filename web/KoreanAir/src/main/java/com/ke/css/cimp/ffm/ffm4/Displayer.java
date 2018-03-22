package com.ke.css.cimp.ffm.ffm4;
/* -----------------------------------------------------------------------------
 * Displayer.java
 * -----------------------------------------------------------------------------
 *
 * Producer : com.parse2.aparse.Parser 2.5
 * Produced : Fri Feb 23 10:53:57 KST 2018
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

  public Object visit(Rule_FFM rule)
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

  public Object visit(Rule_MFH rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_FLIGHT_NUMBER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_FLIGHT_DATE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_AIRCRAFT_REGISTRATION rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_First_Point_of_Arrival_Information rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_DST rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_AWB rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_AWB rule)
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

  public Object visit(Rule_DIM rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_DIMS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_CMI rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_CMIS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Onward_Routing_Detail rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Onward_Booking_Detail rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Movement_Priority rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_OSI rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_OSI_Details_1st_Line rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_OSI_Details_2nd_Line rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_SCI rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_ULD rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_ULD_INFORMATION rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_ULD_Position_Information rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_ULD_Remarks rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_UMI rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_UMIS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_ULD_Onward_Routing_Detail rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_ULD_Onward_Booking_Detail rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_ULD_Utilisation_Detail rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MCI rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_STANDARD_MESSAGE_IDENTIFIER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_MFH rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_DIM rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_OSI rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_SCI rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_ULD rule)
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

  public Object visit(Rule_MESSAGE_SEQUENCE_NUMBER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Sub_Day_of_Scheduled_Departure rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Sub_Month_of_Scheduled_Departure rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_AIRPORT_CODE_OF_LOADING rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_AIRCRAFT_REGISTRATION rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_ISO_COUNTRY_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_DAY_OF_SCHEDULED_ARRIVAL rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MONTH_OF_SCHEDULED_ARRIVAL rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_TIME_OF_SCHEDULED_ARRIVAL rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_AIRPORT_CITY_CODE_OF_ARRV rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_AIRPORT_CODE_OF_UNLOADING rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_NIL_CARGO_CODE rule)
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

  public Object visit(Rule_TIME_OF_SCHEDULED_DPRT rule)
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

  public Object visit(Rule_SHIPMENT_DESCRIPTION_CODE rule)
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

  public Object visit(Rule_NUMBER_OF_TOTAL_PIECES rule)
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

  public Object visit(Rule_AIRPORT_CODE_OF_NEXT_DEST rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_CARRIER_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MOVEMENT_PRIORITY_CODE rule)
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

  public Object visit(Rule_Hid_Customs_Reference rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_CUSTOMS_ORIGIN_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Sub_ULD_Type rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Sub_ULD_Serial_Number rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Sub_ULD_Owner_Code rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_ULD_LOADING_INDICATOR rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_ULD_REMARKS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_ULD_VOLUME_AVAILABLE_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_END_OF_MESSAGE_CODE rule)
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
