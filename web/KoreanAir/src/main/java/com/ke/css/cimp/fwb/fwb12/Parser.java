package com.ke.css.cimp.fwb.fwb12;
/* -----------------------------------------------------------------------------
 * Parser.java
 * -----------------------------------------------------------------------------
 *
 * Producer : com.parse2.aparse.Parser 2.5
 * Produced : Tue Mar 06 10:36:09 KST 2018
 *
 * -----------------------------------------------------------------------------
 */

import java.util.Stack;
import java.util.Properties;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.IOException;

public class Parser
{
  public Parser() {}

  static public void main(String[] args)
  {
    Properties arguments = new Properties();
    String error = "";
    boolean ok = args.length > 0;

    if (ok)
    {
      arguments.setProperty("Trace", "Off");
      arguments.setProperty("Rule", "MESSAGE");

      for (int i = 0; i < args.length; i++)
      {
        if (args[i].equals("-trace"))
          arguments.setProperty("Trace", "On");
        else if (args[i].equals("-visitor"))
          arguments.setProperty("Visitor", args[++i]);
        else if (args[i].equals("-file"))
          arguments.setProperty("File", args[++i]);
        else if (args[i].equals("-string"))
          arguments.setProperty("String", args[++i]);
        else if (args[i].equals("-rule"))
          arguments.setProperty("Rule", args[++i]);
        else
        {
          error = "unknown argument: " + args[i];
          ok = false;
        }
      }
    }

    if (ok)
    {
      if (arguments.getProperty("File") == null &&
          arguments.getProperty("String") == null)
      {
        error = "insufficient arguments: -file or -string required";
        ok = false;
      }
    }

    if (!ok)
    {
      System.out.println("error: " + error);
      System.out.println("usage: Parser [-rule rulename] [-trace] <-file file | -string string> [-visitor visitor]");
    }
    else
    {
      try
      {
        Rule rule = null;

        if (arguments.getProperty("File") != null)
        {
          rule = 
            parse(
              arguments.getProperty("Rule"), 
              new File(arguments.getProperty("File")), 
              arguments.getProperty("Trace").equals("On"));
        }
        else if (arguments.getProperty("String") != null)
        {
          rule = 
            parse(
              arguments.getProperty("Rule"), 
              arguments.getProperty("String"), 
              arguments.getProperty("Trace").equals("On"));
        }

        if (arguments.getProperty("Visitor") != null)
        {
          Visitor visitor = 
            (Visitor)Class.forName(arguments.getProperty("Visitor")).newInstance();
          rule.accept(visitor);
        }
      }
      catch (IllegalArgumentException e)
      {
        System.out.println("argument error: " + e.getMessage());
      }
      catch (IOException e)
      {
        System.out.println("io error: " + e.getMessage());
      }
      catch (ParserException e)
      {
        System.out.println("parser error: " + e.getMessage());
      }
      catch (ClassNotFoundException e)
      {
        System.out.println("visitor error: class not found - " + e.getMessage());
      }
      catch (IllegalAccessException e)
      {
        System.out.println("visitor error: illegal access - " + e.getMessage());
      }
      catch (InstantiationException e)
      {
        System.out.println("visitor error: instantiation failure - " + e.getMessage());
      }
    }
  }

  static public Rule parse(String rulename, String string)
  throws IllegalArgumentException,
         ParserException
  {
    return parse(rulename, string, false);
  }

  static public Rule parse(String rulename, InputStream in)
  throws IllegalArgumentException,
         IOException,
         ParserException
  {
    return parse(rulename, in, false);
  }

  static public Rule parse(String rulename, File file)
  throws IllegalArgumentException,
         IOException,
         ParserException
  {
    return parse(rulename, file, false);
  }

  static private Rule parse(String rulename, String string, boolean trace)
  throws IllegalArgumentException,
         ParserException
  {
    if (rulename == null)
      throw new IllegalArgumentException("null rulename");
    if (string == null)
      throw new IllegalArgumentException("null string");

    ParserContext context = new ParserContext(string, trace);

    Rule rule = null;
    if (rulename.equalsIgnoreCase("MESSAGE")) rule = Rule_MESSAGE.parse(context);
    else if (rulename.equalsIgnoreCase("FWB")) rule = Rule_FWB.parse(context);
    else if (rulename.equalsIgnoreCase("HEADER")) rule = Rule_HEADER.parse(context);
    else if (rulename.equalsIgnoreCase("SMI")) rule = Rule_SMI.parse(context);
    else if (rulename.equalsIgnoreCase("AWB")) rule = Rule_AWB.parse(context);
    else if (rulename.equalsIgnoreCase("AWB_NUMBER")) rule = Rule_AWB_NUMBER.parse(context);
    else if (rulename.equalsIgnoreCase("FLT")) rule = Rule_FLT.parse(context);
    else if (rulename.equalsIgnoreCase("FLIGHT_BOOKINGS")) rule = Rule_FLIGHT_BOOKINGS.parse(context);
    else if (rulename.equalsIgnoreCase("RTG")) rule = Rule_RTG.parse(context);
    else if (rulename.equalsIgnoreCase("ROUTING")) rule = Rule_ROUTING.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Onward_Destination_Carrier")) rule = Rule_Grp_Onward_Destination_Carrier.parse(context);
    else if (rulename.equalsIgnoreCase("SHP")) rule = Rule_SHP.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Account_Detail_SHP")) rule = Rule_Grp_Account_Detail_SHP.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Name_SHP")) rule = Rule_Grp_Name_SHP.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Street_Address_SHP")) rule = Rule_Grp_Street_Address_SHP.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Location_SHP")) rule = Rule_Grp_Location_SHP.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Coded_Location_SHP")) rule = Rule_Grp_Coded_Location_SHP.parse(context);
    else if (rulename.equalsIgnoreCase("SHIPPER_CONTACT")) rule = Rule_SHIPPER_CONTACT.parse(context);
    else if (rulename.equalsIgnoreCase("CNE")) rule = Rule_CNE.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Account_Detail_CNE")) rule = Rule_Grp_Account_Detail_CNE.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Name_CNE")) rule = Rule_Grp_Name_CNE.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Street_Address_CNE")) rule = Rule_Grp_Street_Address_CNE.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Location_CNE")) rule = Rule_Grp_Location_CNE.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Coded_Location_CNE")) rule = Rule_Grp_Coded_Location_CNE.parse(context);
    else if (rulename.equalsIgnoreCase("CONSIGNEE_CONTACT")) rule = Rule_CONSIGNEE_CONTACT.parse(context);
    else if (rulename.equalsIgnoreCase("AGT")) rule = Rule_AGT.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_AGT_AccountDetail")) rule = Rule_Grp_AGT_AccountDetail.parse(context);
    else if (rulename.equalsIgnoreCase("IATA_CARGO_AGENT_CODE")) rule = Rule_IATA_CARGO_AGENT_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("SSR")) rule = Rule_SSR.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_SPECIAL_SERVICE_REQUEST")) rule = Rule_Grp_SPECIAL_SERVICE_REQUEST.parse(context);
    else if (rulename.equalsIgnoreCase("NFY")) rule = Rule_NFY.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Name_NFY")) rule = Rule_Grp_Name_NFY.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Street_Address_NFY")) rule = Rule_Grp_Street_Address_NFY.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Location_NFY")) rule = Rule_Grp_Location_NFY.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Coded_Location_NFY")) rule = Rule_Grp_Coded_Location_NFY.parse(context);
    else if (rulename.equalsIgnoreCase("NOTIFY_CONTACT")) rule = Rule_NOTIFY_CONTACT.parse(context);
    else if (rulename.equalsIgnoreCase("ACC")) rule = Rule_ACC.parse(context);
    else if (rulename.equalsIgnoreCase("ACCS")) rule = Rule_ACCS.parse(context);
    else if (rulename.equalsIgnoreCase("CVD")) rule = Rule_CVD.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Prepaid_Collect_Charge_Declarations")) rule = Rule_Grp_Prepaid_Collect_Charge_Declarations.parse(context);
    else if (rulename.equalsIgnoreCase("RTD")) rule = Rule_RTD.parse(context);
    else if (rulename.equalsIgnoreCase("RTDS")) rule = Rule_RTDS.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_First")) rule = Rule_Grp_First.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Second")) rule = Rule_Grp_Second.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Number_of_Pieces_RCP_Details")) rule = Rule_Grp_Number_of_Pieces_RCP_Details.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Gross_Weight_Details")) rule = Rule_Grp_Gross_Weight_Details.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Rate_Class_Details")) rule = Rule_Grp_Rate_Class_Details.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_COMMODITY_ITEM_NUMBER")) rule = Rule_Grp_COMMODITY_ITEM_NUMBER.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Chargeable_Weight_Details")) rule = Rule_Grp_Chargeable_Weight_Details.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Rate_Charge_Details")) rule = Rule_Grp_Rate_Charge_Details.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Total_Details")) rule = Rule_Grp_Total_Details.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Goods_Description")) rule = Rule_Grp_Goods_Description.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Consolidation")) rule = Rule_Grp_Consolidation.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Dimensions")) rule = Rule_Grp_Dimensions.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Volume")) rule = Rule_Grp_Volume.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_ULD_Number")) rule = Rule_Grp_ULD_Number.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Shippers_Load_and_Count")) rule = Rule_Grp_Shippers_Load_and_Count.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Harmonised_Commodity_Code")) rule = Rule_Grp_Harmonised_Commodity_Code.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Country_of_Origin_of_Goods")) rule = Rule_Grp_Country_of_Origin_of_Goods.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Service_Code_Details")) rule = Rule_Grp_Service_Code_Details.parse(context);
    else if (rulename.equalsIgnoreCase("OTH")) rule = Rule_OTH.parse(context);
    else if (rulename.equalsIgnoreCase("OTHS")) rule = Rule_OTHS.parse(context);
    else if (rulename.equalsIgnoreCase("OTHER_CHARGES")) rule = Rule_OTHER_CHARGES.parse(context);
    else if (rulename.equalsIgnoreCase("OTHER_CHARGE_CODE")) rule = Rule_OTHER_CHARGE_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("CSD")) rule = Rule_CSD.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Total_Weight_Charge")) rule = Rule_Grp_Total_Weight_Charge.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Valuation_Charge")) rule = Rule_Grp_Valuation_Charge.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Taxes")) rule = Rule_Grp_Taxes.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Total_Other_Charges_Due_Agent")) rule = Rule_Grp_Total_Other_Charges_Due_Agent.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Total_Other_Charges_Due_Carrier")) rule = Rule_Grp_Total_Other_Charges_Due_Carrier.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Charge_Summary_Total")) rule = Rule_Grp_Charge_Summary_Total.parse(context);
    else if (rulename.equalsIgnoreCase("CER")) rule = Rule_CER.parse(context);
    else if (rulename.equalsIgnoreCase("ISU")) rule = Rule_ISU.parse(context);
    else if (rulename.equalsIgnoreCase("ISSUE_DATE")) rule = Rule_ISSUE_DATE.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Authorisation")) rule = Rule_Grp_Authorisation.parse(context);
    else if (rulename.equalsIgnoreCase("OSI")) rule = Rule_OSI.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Other_Service_Information")) rule = Rule_Grp_Other_Service_Information.parse(context);
    else if (rulename.equalsIgnoreCase("CDC")) rule = Rule_CDC.parse(context);
    else if (rulename.equalsIgnoreCase("REF")) rule = Rule_REF.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Sender_Office_Message_Address")) rule = Rule_Grp_Sender_Office_Message_Address.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Sender_Office_File_Reference")) rule = Rule_Grp_Sender_Office_File_Reference.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Sender_Participant_Identification")) rule = Rule_Grp_Sender_Participant_Identification.parse(context);
    else if (rulename.equalsIgnoreCase("COR")) rule = Rule_COR.parse(context);
    else if (rulename.equalsIgnoreCase("COI")) rule = Rule_COI.parse(context);
    else if (rulename.equalsIgnoreCase("SII")) rule = Rule_SII.parse(context);
    else if (rulename.equalsIgnoreCase("ARD")) rule = Rule_ARD.parse(context);
    else if (rulename.equalsIgnoreCase("SPH")) rule = Rule_SPH.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Special_Handling_Requirements")) rule = Rule_Grp_Special_Handling_Requirements.parse(context);
    else if (rulename.equalsIgnoreCase("NOM")) rule = Rule_NOM.parse(context);
    else if (rulename.equalsIgnoreCase("SRI")) rule = Rule_SRI.parse(context);
    else if (rulename.equalsIgnoreCase("OPI")) rule = Rule_OPI.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Other_Participant_Office_Message_Address")) rule = Rule_Grp_Other_Participant_Office_Message_Address.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Other_Participant_Identification")) rule = Rule_Grp_Other_Participant_Identification.parse(context);
    else if (rulename.equalsIgnoreCase("STANDARD_MESSAGE_IDENTIFIER")) rule = Rule_STANDARD_MESSAGE_IDENTIFIER.parse(context);
    else if (rulename.equalsIgnoreCase("MId_FLT")) rule = Rule_MId_FLT.parse(context);
    else if (rulename.equalsIgnoreCase("MId_RTG")) rule = Rule_MId_RTG.parse(context);
    else if (rulename.equalsIgnoreCase("MId_SHP")) rule = Rule_MId_SHP.parse(context);
    else if (rulename.equalsIgnoreCase("MId_CNE")) rule = Rule_MId_CNE.parse(context);
    else if (rulename.equalsIgnoreCase("MId_AGT")) rule = Rule_MId_AGT.parse(context);
    else if (rulename.equalsIgnoreCase("MId_SSR")) rule = Rule_MId_SSR.parse(context);
    else if (rulename.equalsIgnoreCase("MId_NFY")) rule = Rule_MId_NFY.parse(context);
    else if (rulename.equalsIgnoreCase("MId_ACC")) rule = Rule_MId_ACC.parse(context);
    else if (rulename.equalsIgnoreCase("MId_CVD")) rule = Rule_MId_CVD.parse(context);
    else if (rulename.equalsIgnoreCase("MId_RTD")) rule = Rule_MId_RTD.parse(context);
    else if (rulename.equalsIgnoreCase("MId_OTH")) rule = Rule_MId_OTH.parse(context);
    else if (rulename.equalsIgnoreCase("PPD_COL_COND")) rule = Rule_PPD_COL_COND.parse(context);
    else if (rulename.equalsIgnoreCase("MId_CER")) rule = Rule_MId_CER.parse(context);
    else if (rulename.equalsIgnoreCase("MId_ISU")) rule = Rule_MId_ISU.parse(context);
    else if (rulename.equalsIgnoreCase("MId_OSI")) rule = Rule_MId_OSI.parse(context);
    else if (rulename.equalsIgnoreCase("MId_CDC")) rule = Rule_MId_CDC.parse(context);
    else if (rulename.equalsIgnoreCase("MId_REF")) rule = Rule_MId_REF.parse(context);
    else if (rulename.equalsIgnoreCase("MId_COR")) rule = Rule_MId_COR.parse(context);
    else if (rulename.equalsIgnoreCase("MId_COI")) rule = Rule_MId_COI.parse(context);
    else if (rulename.equalsIgnoreCase("MId_SII")) rule = Rule_MId_SII.parse(context);
    else if (rulename.equalsIgnoreCase("MId_ARD")) rule = Rule_MId_ARD.parse(context);
    else if (rulename.equalsIgnoreCase("MId_SPH")) rule = Rule_MId_SPH.parse(context);
    else if (rulename.equalsIgnoreCase("MId_NOM")) rule = Rule_MId_NOM.parse(context);
    else if (rulename.equalsIgnoreCase("MId_SRI")) rule = Rule_MId_SRI.parse(context);
    else if (rulename.equalsIgnoreCase("MId_OPI")) rule = Rule_MId_OPI.parse(context);
    else if (rulename.equalsIgnoreCase("IF_HUB_REFERENCE_KEY")) rule = Rule_IF_HUB_REFERENCE_KEY.parse(context);
    else if (rulename.equalsIgnoreCase("MESSAGE_TYPE")) rule = Rule_MESSAGE_TYPE.parse(context);
    else if (rulename.equalsIgnoreCase("MESSAGE_SUBTYPE")) rule = Rule_MESSAGE_SUBTYPE.parse(context);
    else if (rulename.equalsIgnoreCase("MESSAGE_RECEIVER")) rule = Rule_MESSAGE_RECEIVER.parse(context);
    else if (rulename.equalsIgnoreCase("MESSAGE_SENDER")) rule = Rule_MESSAGE_SENDER.parse(context);
    else if (rulename.equalsIgnoreCase("MESSAGE_TYPE_VERSION_NUMBER")) rule = Rule_MESSAGE_TYPE_VERSION_NUMBER.parse(context);
    else if (rulename.equalsIgnoreCase("Sub_AWB_Prefix")) rule = Rule_Sub_AWB_Prefix.parse(context);
    else if (rulename.equalsIgnoreCase("Sub_AWB_SerialNum")) rule = Rule_Sub_AWB_SerialNum.parse(context);
    else if (rulename.equalsIgnoreCase("AIRPORT_CITY_CODE_OF_ORIGIN")) rule = Rule_AIRPORT_CITY_CODE_OF_ORIGIN.parse(context);
    else if (rulename.equalsIgnoreCase("AIRPORT_CITY_CODE_OF_DEST")) rule = Rule_AIRPORT_CITY_CODE_OF_DEST.parse(context);
    else if (rulename.equalsIgnoreCase("Hid_AWB_ShipCode")) rule = Rule_Hid_AWB_ShipCode.parse(context);
    else if (rulename.equalsIgnoreCase("NUMBER_OF_PIECES")) rule = Rule_NUMBER_OF_PIECES.parse(context);
    else if (rulename.equalsIgnoreCase("WEIGHT_CODE")) rule = Rule_WEIGHT_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("WEIGHT")) rule = Rule_WEIGHT.parse(context);
    else if (rulename.equalsIgnoreCase("VOLUME_CODE")) rule = Rule_VOLUME_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("VOLUME_AMOUNT")) rule = Rule_VOLUME_AMOUNT.parse(context);
    else if (rulename.equalsIgnoreCase("Sub_Carrier_Code")) rule = Rule_Sub_Carrier_Code.parse(context);
    else if (rulename.equalsIgnoreCase("Sub_Flight_Number")) rule = Rule_Sub_Flight_Number.parse(context);
    else if (rulename.equalsIgnoreCase("Sub_Day")) rule = Rule_Sub_Day.parse(context);
    else if (rulename.equalsIgnoreCase("Sub_Airport_City_Code")) rule = Rule_Sub_Airport_City_Code.parse(context);
    else if (rulename.equalsIgnoreCase("SHIPPER_ACCOUNT_NUMBER")) rule = Rule_SHIPPER_ACCOUNT_NUMBER.parse(context);
    else if (rulename.equalsIgnoreCase("SHIPPER_NAME")) rule = Rule_SHIPPER_NAME.parse(context);
    else if (rulename.equalsIgnoreCase("SHIPPER_STREET_ADDRESS")) rule = Rule_SHIPPER_STREET_ADDRESS.parse(context);
    else if (rulename.equalsIgnoreCase("SHIPPER_PLACE")) rule = Rule_SHIPPER_PLACE.parse(context);
    else if (rulename.equalsIgnoreCase("SHIPPER_STATE_PROVINCE")) rule = Rule_SHIPPER_STATE_PROVINCE.parse(context);
    else if (rulename.equalsIgnoreCase("SHIPPER_ISO_COUNTRY_CODE")) rule = Rule_SHIPPER_ISO_COUNTRY_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("SHIPPER_POST_CODE")) rule = Rule_SHIPPER_POST_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("SHIPPER_CONTACT_IDENTIFIER")) rule = Rule_SHIPPER_CONTACT_IDENTIFIER.parse(context);
    else if (rulename.equalsIgnoreCase("SHIPPER_CONTACT_NUMBER")) rule = Rule_SHIPPER_CONTACT_NUMBER.parse(context);
    else if (rulename.equalsIgnoreCase("CONSIGNEE_ACCOUNT_NUMBER")) rule = Rule_CONSIGNEE_ACCOUNT_NUMBER.parse(context);
    else if (rulename.equalsIgnoreCase("CONSIGNEE_NAME")) rule = Rule_CONSIGNEE_NAME.parse(context);
    else if (rulename.equalsIgnoreCase("CONSIGNEE_STREET_ADDRESS")) rule = Rule_CONSIGNEE_STREET_ADDRESS.parse(context);
    else if (rulename.equalsIgnoreCase("CONSIGNEE_PLACE")) rule = Rule_CONSIGNEE_PLACE.parse(context);
    else if (rulename.equalsIgnoreCase("CONSIGNEE_STATE_PROVINCE")) rule = Rule_CONSIGNEE_STATE_PROVINCE.parse(context);
    else if (rulename.equalsIgnoreCase("CONSIGNEE_ISO_COUNTRY_CODE")) rule = Rule_CONSIGNEE_ISO_COUNTRY_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("CONSIGNEE_POST_CODE")) rule = Rule_CONSIGNEE_POST_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("CONSIGNEE_CONTACT_IDENTIFIER")) rule = Rule_CONSIGNEE_CONTACT_IDENTIFIER.parse(context);
    else if (rulename.equalsIgnoreCase("CONSIGNEE_CONTACT_NUMBER")) rule = Rule_CONSIGNEE_CONTACT_NUMBER.parse(context);
    else if (rulename.equalsIgnoreCase("AGENT_ACCOUNT_NUMBER")) rule = Rule_AGENT_ACCOUNT_NUMBER.parse(context);
    else if (rulename.equalsIgnoreCase("Sub_IATA_CARGO_AGENT_CODE")) rule = Rule_Sub_IATA_CARGO_AGENT_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("Sub_IATA_Cargo_Agent_CASS_Address")) rule = Rule_Sub_IATA_Cargo_Agent_CASS_Address.parse(context);
    else if (rulename.equalsIgnoreCase("AGENT_PARTICIPANT_IDENTIFIER")) rule = Rule_AGENT_PARTICIPANT_IDENTIFIER.parse(context);
    else if (rulename.equalsIgnoreCase("AGENT_NAME")) rule = Rule_AGENT_NAME.parse(context);
    else if (rulename.equalsIgnoreCase("AGENT_PLACE")) rule = Rule_AGENT_PLACE.parse(context);
    else if (rulename.equalsIgnoreCase("SPECIAL_SERVICE_REQUEST")) rule = Rule_SPECIAL_SERVICE_REQUEST.parse(context);
    else if (rulename.equalsIgnoreCase("NOTIFY_NAME")) rule = Rule_NOTIFY_NAME.parse(context);
    else if (rulename.equalsIgnoreCase("NOTIFY_STREET_ADDRESS")) rule = Rule_NOTIFY_STREET_ADDRESS.parse(context);
    else if (rulename.equalsIgnoreCase("NOTIFY_PLACE")) rule = Rule_NOTIFY_PLACE.parse(context);
    else if (rulename.equalsIgnoreCase("NOTIFY_STATE_PROVINCE")) rule = Rule_NOTIFY_STATE_PROVINCE.parse(context);
    else if (rulename.equalsIgnoreCase("NOTIFY_ISO_COUNTRY_CODE")) rule = Rule_NOTIFY_ISO_COUNTRY_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("NOTIFY_POST_CODE")) rule = Rule_NOTIFY_POST_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("NOTIFY_CONTACT_IDENTIFIER")) rule = Rule_NOTIFY_CONTACT_IDENTIFIER.parse(context);
    else if (rulename.equalsIgnoreCase("NOTIFY_CONTACT_NUMBER")) rule = Rule_NOTIFY_CONTACT_NUMBER.parse(context);
    else if (rulename.equalsIgnoreCase("ACCOUNTING_INFORMATION_ID")) rule = Rule_ACCOUNTING_INFORMATION_ID.parse(context);
    else if (rulename.equalsIgnoreCase("ACCOUNTING_INFORMATION")) rule = Rule_ACCOUNTING_INFORMATION.parse(context);
    else if (rulename.equalsIgnoreCase("ISO_CURRENCY_CODE")) rule = Rule_ISO_CURRENCY_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("CHARGE_CODE")) rule = Rule_CHARGE_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("P_C_IND_WEIGHT_VALUATION")) rule = Rule_P_C_IND_WEIGHT_VALUATION.parse(context);
    else if (rulename.equalsIgnoreCase("P_C_IND_OTHER_CHARGES")) rule = Rule_P_C_IND_OTHER_CHARGES.parse(context);
    else if (rulename.equalsIgnoreCase("DECLARED_VALUE_FOR_CARRIAGE")) rule = Rule_DECLARED_VALUE_FOR_CARRIAGE.parse(context);
    else if (rulename.equalsIgnoreCase("DECLARED_VALUE_FOR_CUSTOMS")) rule = Rule_DECLARED_VALUE_FOR_CUSTOMS.parse(context);
    else if (rulename.equalsIgnoreCase("AMOUNT_OF_INSURANCE")) rule = Rule_AMOUNT_OF_INSURANCE.parse(context);
    else if (rulename.equalsIgnoreCase("Hid_AWB_Rate_Line_Number")) rule = Rule_Hid_AWB_Rate_Line_Number.parse(context);
    else if (rulename.equalsIgnoreCase("Hid_AWB_Rate_Line_Number_12")) rule = Rule_Hid_AWB_Rate_Line_Number_12.parse(context);
    else if (rulename.equalsIgnoreCase("Hid_AWB_Column_Identifier_P")) rule = Rule_Hid_AWB_Column_Identifier_P.parse(context);
    else if (rulename.equalsIgnoreCase("Hid_AWB_Column_Identifier_C")) rule = Rule_Hid_AWB_Column_Identifier_C.parse(context);
    else if (rulename.equalsIgnoreCase("Hid_AWB_Column_Identifier_S")) rule = Rule_Hid_AWB_Column_Identifier_S.parse(context);
    else if (rulename.equalsIgnoreCase("Hid_AWB_Column_Identifier_W")) rule = Rule_Hid_AWB_Column_Identifier_W.parse(context);
    else if (rulename.equalsIgnoreCase("Hid_AWB_Column_Identifier_R")) rule = Rule_Hid_AWB_Column_Identifier_R.parse(context);
    else if (rulename.equalsIgnoreCase("Hid_AWB_Column_Identifier_T")) rule = Rule_Hid_AWB_Column_Identifier_T.parse(context);
    else if (rulename.equalsIgnoreCase("Hid_AWB_Column_Identifier_N")) rule = Rule_Hid_AWB_Column_Identifier_N.parse(context);
    else if (rulename.equalsIgnoreCase("Hid_Goods_data_Identifier_G")) rule = Rule_Hid_Goods_data_Identifier_G.parse(context);
    else if (rulename.equalsIgnoreCase("Hid_Goods_data_Identifier_C")) rule = Rule_Hid_Goods_data_Identifier_C.parse(context);
    else if (rulename.equalsIgnoreCase("Hid_Goods_data_Identifier_D")) rule = Rule_Hid_Goods_data_Identifier_D.parse(context);
    else if (rulename.equalsIgnoreCase("Hid_Goods_data_Identifier_V")) rule = Rule_Hid_Goods_data_Identifier_V.parse(context);
    else if (rulename.equalsIgnoreCase("Hid_Goods_data_Identifier_U")) rule = Rule_Hid_Goods_data_Identifier_U.parse(context);
    else if (rulename.equalsIgnoreCase("Hid_Goods_data_Identifier_S")) rule = Rule_Hid_Goods_data_Identifier_S.parse(context);
    else if (rulename.equalsIgnoreCase("Hid_Goods_data_Identifier_H")) rule = Rule_Hid_Goods_data_Identifier_H.parse(context);
    else if (rulename.equalsIgnoreCase("Hid_Goods_data_Identifier_O")) rule = Rule_Hid_Goods_data_Identifier_O.parse(context);
    else if (rulename.equalsIgnoreCase("GROSS_WEIGHT")) rule = Rule_GROSS_WEIGHT.parse(context);
    else if (rulename.equalsIgnoreCase("RATE_CLASS_CODE")) rule = Rule_RATE_CLASS_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("COMMODITY_ITEM_NUMBER")) rule = Rule_COMMODITY_ITEM_NUMBER.parse(context);
    else if (rulename.equalsIgnoreCase("CHARGEABLE_WEIGHT")) rule = Rule_CHARGEABLE_WEIGHT.parse(context);
    else if (rulename.equalsIgnoreCase("RATE_CHARGE")) rule = Rule_RATE_CHARGE.parse(context);
    else if (rulename.equalsIgnoreCase("CHARGE_AMOUNT")) rule = Rule_CHARGE_AMOUNT.parse(context);
    else if (rulename.equalsIgnoreCase("NATURE_AND_QUANTITY_OF_GOODS")) rule = Rule_NATURE_AND_QUANTITY_OF_GOODS.parse(context);
    else if (rulename.equalsIgnoreCase("NATURE_AND_QUANTITY_CONSOL")) rule = Rule_NATURE_AND_QUANTITY_CONSOL.parse(context);
    else if (rulename.equalsIgnoreCase("VOLUME_WEIGHT_CODE")) rule = Rule_VOLUME_WEIGHT_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("VOLUME_WEIGHT")) rule = Rule_VOLUME_WEIGHT.parse(context);
    else if (rulename.equalsIgnoreCase("MEASUREMENT_UNIT_CODE")) rule = Rule_MEASUREMENT_UNIT_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("LENGTH_DIMENSION")) rule = Rule_LENGTH_DIMENSION.parse(context);
    else if (rulename.equalsIgnoreCase("WIDTH_DIMENSION")) rule = Rule_WIDTH_DIMENSION.parse(context);
    else if (rulename.equalsIgnoreCase("HEIGHT_DIMENSION")) rule = Rule_HEIGHT_DIMENSION.parse(context);
    else if (rulename.equalsIgnoreCase("VOLUME_NUMBERS_OF_PIECES")) rule = Rule_VOLUME_NUMBERS_OF_PIECES.parse(context);
    else if (rulename.equalsIgnoreCase("ULD_TYPE")) rule = Rule_ULD_TYPE.parse(context);
    else if (rulename.equalsIgnoreCase("ULD_SERIAL_NUMBER")) rule = Rule_ULD_SERIAL_NUMBER.parse(context);
    else if (rulename.equalsIgnoreCase("ULD_OWNER_CODE")) rule = Rule_ULD_OWNER_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("SLAC")) rule = Rule_SLAC.parse(context);
    else if (rulename.equalsIgnoreCase("HARMONISED_COMMODITY_CODE")) rule = Rule_HARMONISED_COMMODITY_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("ISO_COUNTRY_CODE")) rule = Rule_ISO_COUNTRY_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("SERVICE_CODE")) rule = Rule_SERVICE_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("Sub_Other_Charge_Code")) rule = Rule_Sub_Other_Charge_Code.parse(context);
    else if (rulename.equalsIgnoreCase("Sub_Entitlement_Code")) rule = Rule_Sub_Entitlement_Code.parse(context);
    else if (rulename.equalsIgnoreCase("Hid_Change_Identifier_WT")) rule = Rule_Hid_Change_Identifier_WT.parse(context);
    else if (rulename.equalsIgnoreCase("Hid_Change_Identifier_VC")) rule = Rule_Hid_Change_Identifier_VC.parse(context);
    else if (rulename.equalsIgnoreCase("Hid_Change_Identifier_TX")) rule = Rule_Hid_Change_Identifier_TX.parse(context);
    else if (rulename.equalsIgnoreCase("Hid_Change_Identifier_OA")) rule = Rule_Hid_Change_Identifier_OA.parse(context);
    else if (rulename.equalsIgnoreCase("Hid_Change_Identifier_OC")) rule = Rule_Hid_Change_Identifier_OC.parse(context);
    else if (rulename.equalsIgnoreCase("Hid_Change_Identifier_CT")) rule = Rule_Hid_Change_Identifier_CT.parse(context);
    else if (rulename.equalsIgnoreCase("WT_CHARGE_AMOUNT")) rule = Rule_WT_CHARGE_AMOUNT.parse(context);
    else if (rulename.equalsIgnoreCase("VC_CHARGE_AMOUNT")) rule = Rule_VC_CHARGE_AMOUNT.parse(context);
    else if (rulename.equalsIgnoreCase("TX_CHARGE_AMOUNT")) rule = Rule_TX_CHARGE_AMOUNT.parse(context);
    else if (rulename.equalsIgnoreCase("OA_CHARGE_AMOUNT")) rule = Rule_OA_CHARGE_AMOUNT.parse(context);
    else if (rulename.equalsIgnoreCase("OC_CHARGE_AMOUNT")) rule = Rule_OC_CHARGE_AMOUNT.parse(context);
    else if (rulename.equalsIgnoreCase("CT_CHARGE_AMOUNT")) rule = Rule_CT_CHARGE_AMOUNT.parse(context);
    else if (rulename.equalsIgnoreCase("SIGNATURE")) rule = Rule_SIGNATURE.parse(context);
    else if (rulename.equalsIgnoreCase("Sub_Month")) rule = Rule_Sub_Month.parse(context);
    else if (rulename.equalsIgnoreCase("Sub_Year")) rule = Rule_Sub_Year.parse(context);
    else if (rulename.equalsIgnoreCase("ISSUE_PLACE")) rule = Rule_ISSUE_PLACE.parse(context);
    else if (rulename.equalsIgnoreCase("ISSUE_SIGNATURE")) rule = Rule_ISSUE_SIGNATURE.parse(context);
    else if (rulename.equalsIgnoreCase("OTHER_SERVICE_INFORMATION")) rule = Rule_OTHER_SERVICE_INFORMATION.parse(context);
    else if (rulename.equalsIgnoreCase("DESTINATION_ISO_CURRENCY_CODE")) rule = Rule_DESTINATION_ISO_CURRENCY_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("RATE_OF_EXCHANGE_IN_DEST_CURR")) rule = Rule_RATE_OF_EXCHANGE_IN_DEST_CURR.parse(context);
    else if (rulename.equalsIgnoreCase("CHARGE_AMOUNT_IN_DEST_CURR")) rule = Rule_CHARGE_AMOUNT_IN_DEST_CURR.parse(context);
    else if (rulename.equalsIgnoreCase("CHARGE_AMOUNT_AT_DEST")) rule = Rule_CHARGE_AMOUNT_AT_DEST.parse(context);
    else if (rulename.equalsIgnoreCase("TOTAL_COLLECT_CHARGE_AMOUNT")) rule = Rule_TOTAL_COLLECT_CHARGE_AMOUNT.parse(context);
    else if (rulename.equalsIgnoreCase("SENDER_AIRPORT_CITY_CODE")) rule = Rule_SENDER_AIRPORT_CITY_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("SENDER_OFFICE_FUNC_DESIGNATOR")) rule = Rule_SENDER_OFFICE_FUNC_DESIGNATOR.parse(context);
    else if (rulename.equalsIgnoreCase("SENDER_COMPANY_DESIGNATOR")) rule = Rule_SENDER_COMPANY_DESIGNATOR.parse(context);
    else if (rulename.equalsIgnoreCase("SENDER_FILE_REFERENCE")) rule = Rule_SENDER_FILE_REFERENCE.parse(context);
    else if (rulename.equalsIgnoreCase("SENDER_PARTICIPANT_IDENTIFIER")) rule = Rule_SENDER_PARTICIPANT_IDENTIFIER.parse(context);
    else if (rulename.equalsIgnoreCase("SENDER_PARTICIPANT_CODE")) rule = Rule_SENDER_PARTICIPANT_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("SENDER_PART_AIRPORT_CITY_CODE")) rule = Rule_SENDER_PART_AIRPORT_CITY_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("CUSTOMS_ORIGIN_CODE")) rule = Rule_CUSTOMS_ORIGIN_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("CASS_INDICATOR")) rule = Rule_CASS_INDICATOR.parse(context);
    else if (rulename.equalsIgnoreCase("CASS_COMMISSION_AMOUNT")) rule = Rule_CASS_COMMISSION_AMOUNT.parse(context);
    else if (rulename.equalsIgnoreCase("CASS_COMMISSION_PERCENTAGE")) rule = Rule_CASS_COMMISSION_PERCENTAGE.parse(context);
    else if (rulename.equalsIgnoreCase("INCENTIVE_CHARGE_AMOUNT")) rule = Rule_INCENTIVE_CHARGE_AMOUNT.parse(context);
    else if (rulename.equalsIgnoreCase("INCENTIVE_CASS_INDICATOR")) rule = Rule_INCENTIVE_CASS_INDICATOR.parse(context);
    else if (rulename.equalsIgnoreCase("AGENT_FILE_REFERENCE")) rule = Rule_AGENT_FILE_REFERENCE.parse(context);
    else if (rulename.equalsIgnoreCase("SPECIAL_HANDLING_CODE")) rule = Rule_SPECIAL_HANDLING_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("NOMINATED_HANDLING_PARTY_NAME")) rule = Rule_NOMINATED_HANDLING_PARTY_NAME.parse(context);
    else if (rulename.equalsIgnoreCase("NOMINATED_HANDLING_PARTY_PLACE")) rule = Rule_NOMINATED_HANDLING_PARTY_PLACE.parse(context);
    else if (rulename.equalsIgnoreCase("SHIPMENT_REFERENCE_NUMBER")) rule = Rule_SHIPMENT_REFERENCE_NUMBER.parse(context);
    else if (rulename.equalsIgnoreCase("SHIPMENT_INFORMATION_1")) rule = Rule_SHIPMENT_INFORMATION_1.parse(context);
    else if (rulename.equalsIgnoreCase("SHIPMENT_INFORMATION_2")) rule = Rule_SHIPMENT_INFORMATION_2.parse(context);
    else if (rulename.equalsIgnoreCase("OTHER_PARTY_NAME")) rule = Rule_OTHER_PARTY_NAME.parse(context);
    else if (rulename.equalsIgnoreCase("OTHER_PARTY_MSG_AIRPORT_CODE")) rule = Rule_OTHER_PARTY_MSG_AIRPORT_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("OTHER_PARTY_MSG_OFFICE_DESIG")) rule = Rule_OTHER_PARTY_MSG_OFFICE_DESIG.parse(context);
    else if (rulename.equalsIgnoreCase("OTHER_PARTY_MSG_COMPANY_DESIG")) rule = Rule_OTHER_PARTY_MSG_COMPANY_DESIG.parse(context);
    else if (rulename.equalsIgnoreCase("OTHER_PARTY_FILE_REFERENCE")) rule = Rule_OTHER_PARTY_FILE_REFERENCE.parse(context);
    else if (rulename.equalsIgnoreCase("OTHER_PARTY_IDENTIFIER")) rule = Rule_OTHER_PARTY_IDENTIFIER.parse(context);
    else if (rulename.equalsIgnoreCase("OTHER_PARTY_CODE")) rule = Rule_OTHER_PARTY_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("OTHER_PARTY_AIRPORT_CITY_CODE")) rule = Rule_OTHER_PARTY_AIRPORT_CITY_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("Sep_CRLF")) rule = Rule_Sep_CRLF.parse(context);
    else if (rulename.equalsIgnoreCase("CR")) rule = Rule_CR.parse(context);
    else if (rulename.equalsIgnoreCase("LF")) rule = Rule_LF.parse(context);
    else if (rulename.equalsIgnoreCase("Sep_Slant")) rule = Rule_Sep_Slant.parse(context);
    else if (rulename.equalsIgnoreCase("Sep_Bar")) rule = Rule_Sep_Bar.parse(context);
    else if (rulename.equalsIgnoreCase("Typ_Alpha")) rule = Rule_Typ_Alpha.parse(context);
    else if (rulename.equalsIgnoreCase("Typ_Numeric")) rule = Rule_Typ_Numeric.parse(context);
    else if (rulename.equalsIgnoreCase("Typ_Decimal")) rule = Rule_Typ_Decimal.parse(context);
    else if (rulename.equalsIgnoreCase("Typ_Mixed")) rule = Rule_Typ_Mixed.parse(context);
    else if (rulename.equalsIgnoreCase("Typ_Text")) rule = Rule_Typ_Text.parse(context);
    else throw new IllegalArgumentException("unknown rule");

    if (rule == null)
    {
      throw new ParserException(
        "rule \"" + (String)context.getErrorStack().peek() + "\" failed",
        context.text,
        context.getErrorIndex(),
        context.getErrorStack());
    }

    if (context.text.length() > context.index)
    {
      ParserException primaryError = 
        new ParserException(
          "extra data found",
          context.text,
          context.index,
          new Stack<String>());

      if (context.getErrorIndex() > context.index)
      {
        ParserException secondaryError = 
          new ParserException(
            "rule \"" + (String)context.getErrorStack().peek() + "\" failed",
            context.text,
            context.getErrorIndex(),
            context.getErrorStack());

        primaryError.initCause(secondaryError);
      }

      throw primaryError;
    }

    return rule;
  }

  static private Rule parse(String rulename, InputStream in, boolean trace)
  throws IllegalArgumentException,
         IOException,
         ParserException
  {
    if (rulename == null)
      throw new IllegalArgumentException("null rulename");
    if (in == null)
      throw new IllegalArgumentException("null input stream");

    int ch = 0;
    StringBuffer out = new StringBuffer();
    while ((ch = in.read()) != -1)
      out.append((char)ch);

    return parse(rulename, out.toString(), trace);
  }

  static private Rule parse(String rulename, File file, boolean trace)
  throws IllegalArgumentException,
         IOException,
         ParserException
  {
    if (rulename == null)
      throw new IllegalArgumentException("null rulename");
    if (file == null)
      throw new IllegalArgumentException("null file");

    BufferedReader in = new BufferedReader(new FileReader(file));
    int ch = 0;
    StringBuffer out = new StringBuffer();
    while ((ch = in.read()) != -1)
      out.append((char)ch);

    in.close();

    return parse(rulename, out.toString(), trace);
  }
}

/* -----------------------------------------------------------------------------
 * eof
 * -----------------------------------------------------------------------------
 */
