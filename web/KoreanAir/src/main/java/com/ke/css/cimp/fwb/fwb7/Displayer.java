package com.ke.css.cimp.fwb.fwb7;
/* -----------------------------------------------------------------------------
 * Displayer.java
 * -----------------------------------------------------------------------------
 *
 * Producer : com.parse2.aparse.Parser 2.5
 * Produced : Tue Mar 06 10:38:08 KST 2018
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

  public Object visit(Rule_FWB rule)
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

  public Object visit(Rule_FLT rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_FLIGHT_BOOKINGS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_RTG rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_ROUTING rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Onward_Destination_Carrier rule)
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

  public Object visit(Rule_SHIPPER_CONTACT rule)
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

  public Object visit(Rule_CONSIGNEE_CONTACT rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_AGT rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_AGT_AccountDetail rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_IATA_CARGO_AGENT_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_SSR rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_SPECIAL_SERVICE_REQUEST rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_NFY rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Name_NFY rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Street_Address_NFY rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Location_NFY rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Coded_Location_NFY rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_NOTIFY_CONTACT rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_ACC rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_ACCS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_CVD rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Prepaid_Collect_Charge_Declarations rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_RTD rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_RTDS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_First rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Second rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Number_of_Pieces_RCP_Details rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Gross_Weight_Details rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Rate_Class_Details rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_COMMODITY_ITEM_NUMBER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Chargeable_Weight_Details rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Rate_Charge_Details rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Total_Details rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Goods_Description rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Consolidation rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Dimensions rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Volume rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_ULD_Number rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Shippers_Load_and_Count rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Harmonised_Commodity_Code rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Country_of_Origin_of_Goods rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Service_Code_Details rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_OTH rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_OTHS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_OTHER_CHARGES rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_OTHER_CHARGE_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_CSD rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Total_Weight_Charge rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Valuation_Charge rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Taxes rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Total_Other_Charges_Due_Agent rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Total_Other_Charges_Due_Carrier rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Charge_Summary_Total rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_CER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_ISU rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_ISSUE_DATE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Authorisation rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_OSI rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Other_Service_Information rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_CDC rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_REF rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Sender_Office_Message_Address rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Sender_Office_File_Reference rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Grp_Sender_Participant_Identification rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_COR rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_COI rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_SII rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_ARD rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_STANDARD_MESSAGE_IDENTIFIER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_FLT rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_RTG rule)
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

  public Object visit(Rule_MId_AGT rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_SSR rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_NFY rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_ACC rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_CVD rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_RTD rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_OTH rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_PPD_COL_COND rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_CER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_ISU rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_OSI rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_CDC rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_REF rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_COR rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_COI rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_SII rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_MId_ARD rule)
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

  public Object visit(Rule_Hid_AWB_ShipCode rule)
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

  public Object visit(Rule_Sub_Carrier_Code rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Sub_Flight_Number rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Sub_Day rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Sub_Airport_City_Code rule)
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

  public Object visit(Rule_SHIPPER_CONTACT_IDENTIFIER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_SHIPPER_CONTACT_NUMBER rule)
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

  public Object visit(Rule_CONSIGNEE_CONTACT_IDENTIFIER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_CONSIGNEE_CONTACT_NUMBER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_AGENT_ACCOUNT_NUMBER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Sub_IATA_CARGO_AGENT_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Sub_IATA_Cargo_Agent_CASS_Address rule)
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

  public Object visit(Rule_SPECIAL_SERVICE_REQUEST rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_NOTIFY_NAME rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_NOTIFY_STREET_ADDRESS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_NOTIFY_PLACE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_NOTIFY_STATE_PROVINCE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_NOTIFY_ISO_COUNTRY_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_NOTIFY_POST_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_NOTIFY_CONTACT_IDENTIFIER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_NOTIFY_CONTACT_NUMBER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_ACCOUNTING_INFORMATION_ID rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_ACCOUNTING_INFORMATION rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_ISO_CURRENCY_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_CHARGE_CODE rule)
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

  public Object visit(Rule_AMOUNT_OF_INSURANCE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Hid_AWB_Rate_Line_Number rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Hid_AWB_Rate_Line_Number_12 rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Hid_AWB_Column_Identifier_P rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Hid_AWB_Column_Identifier_C rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Hid_AWB_Column_Identifier_S rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Hid_AWB_Column_Identifier_W rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Hid_AWB_Column_Identifier_R rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Hid_AWB_Column_Identifier_T rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Hid_AWB_Column_Identifier_N rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Hid_Goods_data_Identifier_G rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Hid_Goods_data_Identifier_C rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Hid_Goods_data_Identifier_D rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Hid_Goods_data_Identifier_V rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Hid_Goods_data_Identifier_U rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Hid_Goods_data_Identifier_S rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Hid_Goods_data_Identifier_H rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Hid_Goods_data_Identifier_O rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_GROSS_WEIGHT rule)
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

  public Object visit(Rule_CHARGEABLE_WEIGHT rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_RATE_CHARGE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_CHARGE_AMOUNT rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_NATURE_AND_QUANTITY_OF_GOODS rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_NATURE_AND_QUANTITY_CONSOL rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_VOLUME_WEIGHT_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_VOLUME_WEIGHT rule)
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

  public Object visit(Rule_VOLUME_NUMBERS_OF_PIECES rule)
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

  public Object visit(Rule_SLAC rule)
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

  public Object visit(Rule_SERVICE_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Sub_Other_Charge_Code rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Sub_Entitlement_Code rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Hid_Change_Identifier_WT rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Hid_Change_Identifier_VC rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Hid_Change_Identifier_TX rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Hid_Change_Identifier_OA rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Hid_Change_Identifier_OC rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Hid_Change_Identifier_CT rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_WT_CHARGE_AMOUNT rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_VC_CHARGE_AMOUNT rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_TX_CHARGE_AMOUNT rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_OA_CHARGE_AMOUNT rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_OC_CHARGE_AMOUNT rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_CT_CHARGE_AMOUNT rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_SIGNATURE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Sub_Month rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_Sub_Year rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_ISSUE_PLACE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_ISSUE_SIGNATURE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_OTHER_SERVICE_INFORMATION rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_DESTINATION_ISO_CURRENCY_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_RATE_OF_EXCHANGE_IN_DEST_CURR rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_CHARGE_AMOUNT_IN_DEST_CURR rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_CHARGE_AMOUNT_AT_DEST rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_TOTAL_COLLECT_CHARGE_AMOUNT rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_SENDER_AIRPORT_CITY_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_SENDER_OFFICE_FUNC_DESIGNATOR rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_SENDER_COMPANY_DESIGNATOR rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_SENDER_FILE_REFERENCE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_SENDER_PARTICIPANT_IDENTIFIER rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_SENDER_PARTICIPANT_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_SENDER_PART_AIRPORT_CITY_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_CUSTOMS_ORIGIN_CODE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_CASS_INDICATOR rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_CASS_COMMISSION_AMOUNT rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_CASS_COMMISSION_PERCENTAGE rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_INCENTIVE_CHARGE_AMOUNT rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_INCENTIVE_CASS_INDICATOR rule)
  {
    return visitRules(rule.rules);
  }

  public Object visit(Rule_AGENT_FILE_REFERENCE rule)
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
