package com.ke.css.cimp.ffm.ffm4;
/* -----------------------------------------------------------------------------
 * Parser.java
 * -----------------------------------------------------------------------------
 *
 * Producer : com.parse2.aparse.Parser 2.5
 * Produced : Fri Feb 23 10:53:57 KST 2018
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
    else if (rulename.equalsIgnoreCase("FFM")) rule = Rule_FFM.parse(context);
    else if (rulename.equalsIgnoreCase("HEADER")) rule = Rule_HEADER.parse(context);
    else if (rulename.equalsIgnoreCase("SMI")) rule = Rule_SMI.parse(context);
    else if (rulename.equalsIgnoreCase("MFH")) rule = Rule_MFH.parse(context);
    else if (rulename.equalsIgnoreCase("FLIGHT_NUMBER")) rule = Rule_FLIGHT_NUMBER.parse(context);
    else if (rulename.equalsIgnoreCase("FLIGHT_DATE")) rule = Rule_FLIGHT_DATE.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_AIRCRAFT_REGISTRATION")) rule = Rule_Grp_AIRCRAFT_REGISTRATION.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_First_Point_of_Arrival_Information")) rule = Rule_Grp_First_Point_of_Arrival_Information.parse(context);
    else if (rulename.equalsIgnoreCase("DST")) rule = Rule_DST.parse(context);
    else if (rulename.equalsIgnoreCase("AWB")) rule = Rule_AWB.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_AWB")) rule = Rule_Grp_AWB.parse(context);
    else if (rulename.equalsIgnoreCase("AWB_NUMBER")) rule = Rule_AWB_NUMBER.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Quantity_Detail")) rule = Rule_Grp_Quantity_Detail.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Volume_Detail")) rule = Rule_Grp_Volume_Detail.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Density_Group")) rule = Rule_Grp_Density_Group.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Total_Consignment_Pieces")) rule = Rule_Grp_Total_Consignment_Pieces.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Nature_of_Goods")) rule = Rule_Grp_Nature_of_Goods.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Special_Handling_Requirements")) rule = Rule_Grp_Special_Handling_Requirements.parse(context);
    else if (rulename.equalsIgnoreCase("DIM")) rule = Rule_DIM.parse(context);
    else if (rulename.equalsIgnoreCase("DIMS")) rule = Rule_DIMS.parse(context);
    else if (rulename.equalsIgnoreCase("CMI")) rule = Rule_CMI.parse(context);
    else if (rulename.equalsIgnoreCase("CMIS")) rule = Rule_CMIS.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Onward_Routing_Detail")) rule = Rule_Grp_Onward_Routing_Detail.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Onward_Booking_Detail")) rule = Rule_Grp_Onward_Booking_Detail.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Movement_Priority")) rule = Rule_Grp_Movement_Priority.parse(context);
    else if (rulename.equalsIgnoreCase("OSI")) rule = Rule_OSI.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_OSI_Details_1st_Line")) rule = Rule_Grp_OSI_Details_1st_Line.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_OSI_Details_2nd_Line")) rule = Rule_Grp_OSI_Details_2nd_Line.parse(context);
    else if (rulename.equalsIgnoreCase("SCI")) rule = Rule_SCI.parse(context);
    else if (rulename.equalsIgnoreCase("ULD")) rule = Rule_ULD.parse(context);
    else if (rulename.equalsIgnoreCase("ULD_INFORMATION")) rule = Rule_ULD_INFORMATION.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_ULD_Position_Information")) rule = Rule_Grp_ULD_Position_Information.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_ULD_Remarks")) rule = Rule_Grp_ULD_Remarks.parse(context);
    else if (rulename.equalsIgnoreCase("UMI")) rule = Rule_UMI.parse(context);
    else if (rulename.equalsIgnoreCase("UMIS")) rule = Rule_UMIS.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_ULD_Onward_Routing_Detail")) rule = Rule_Grp_ULD_Onward_Routing_Detail.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_ULD_Onward_Booking_Detail")) rule = Rule_Grp_ULD_Onward_Booking_Detail.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_ULD_Utilisation_Detail")) rule = Rule_Grp_ULD_Utilisation_Detail.parse(context);
    else if (rulename.equalsIgnoreCase("MCI")) rule = Rule_MCI.parse(context);
    else if (rulename.equalsIgnoreCase("STANDARD_MESSAGE_IDENTIFIER")) rule = Rule_STANDARD_MESSAGE_IDENTIFIER.parse(context);
    else if (rulename.equalsIgnoreCase("MId_MFH")) rule = Rule_MId_MFH.parse(context);
    else if (rulename.equalsIgnoreCase("MId_DIM")) rule = Rule_MId_DIM.parse(context);
    else if (rulename.equalsIgnoreCase("MId_OSI")) rule = Rule_MId_OSI.parse(context);
    else if (rulename.equalsIgnoreCase("MId_SCI")) rule = Rule_MId_SCI.parse(context);
    else if (rulename.equalsIgnoreCase("MId_ULD")) rule = Rule_MId_ULD.parse(context);
    else if (rulename.equalsIgnoreCase("IF_HUB_REFERENCE_KEY")) rule = Rule_IF_HUB_REFERENCE_KEY.parse(context);
    else if (rulename.equalsIgnoreCase("MESSAGE_TYPE")) rule = Rule_MESSAGE_TYPE.parse(context);
    else if (rulename.equalsIgnoreCase("MESSAGE_SUBTYPE")) rule = Rule_MESSAGE_SUBTYPE.parse(context);
    else if (rulename.equalsIgnoreCase("MESSAGE_RECEIVER")) rule = Rule_MESSAGE_RECEIVER.parse(context);
    else if (rulename.equalsIgnoreCase("MESSAGE_SENDER")) rule = Rule_MESSAGE_SENDER.parse(context);
    else if (rulename.equalsIgnoreCase("MESSAGE_TYPE_VERSION_NUMBER")) rule = Rule_MESSAGE_TYPE_VERSION_NUMBER.parse(context);
    else if (rulename.equalsIgnoreCase("MESSAGE_SEQUENCE_NUMBER")) rule = Rule_MESSAGE_SEQUENCE_NUMBER.parse(context);
    else if (rulename.equalsIgnoreCase("Sub_Day_of_Scheduled_Departure")) rule = Rule_Sub_Day_of_Scheduled_Departure.parse(context);
    else if (rulename.equalsIgnoreCase("Sub_Month_of_Scheduled_Departure")) rule = Rule_Sub_Month_of_Scheduled_Departure.parse(context);
    else if (rulename.equalsIgnoreCase("AIRPORT_CODE_OF_LOADING")) rule = Rule_AIRPORT_CODE_OF_LOADING.parse(context);
    else if (rulename.equalsIgnoreCase("AIRCRAFT_REGISTRATION")) rule = Rule_AIRCRAFT_REGISTRATION.parse(context);
    else if (rulename.equalsIgnoreCase("ISO_COUNTRY_CODE")) rule = Rule_ISO_COUNTRY_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("DAY_OF_SCHEDULED_ARRIVAL")) rule = Rule_DAY_OF_SCHEDULED_ARRIVAL.parse(context);
    else if (rulename.equalsIgnoreCase("MONTH_OF_SCHEDULED_ARRIVAL")) rule = Rule_MONTH_OF_SCHEDULED_ARRIVAL.parse(context);
    else if (rulename.equalsIgnoreCase("TIME_OF_SCHEDULED_ARRIVAL")) rule = Rule_TIME_OF_SCHEDULED_ARRIVAL.parse(context);
    else if (rulename.equalsIgnoreCase("AIRPORT_CITY_CODE_OF_ARRV")) rule = Rule_AIRPORT_CITY_CODE_OF_ARRV.parse(context);
    else if (rulename.equalsIgnoreCase("AIRPORT_CODE_OF_UNLOADING")) rule = Rule_AIRPORT_CODE_OF_UNLOADING.parse(context);
    else if (rulename.equalsIgnoreCase("NIL_CARGO_CODE")) rule = Rule_NIL_CARGO_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("DAY_OF_SCHEDULED_DPRT")) rule = Rule_DAY_OF_SCHEDULED_DPRT.parse(context);
    else if (rulename.equalsIgnoreCase("MONTH_OF_SCHEDULED_DPRT")) rule = Rule_MONTH_OF_SCHEDULED_DPRT.parse(context);
    else if (rulename.equalsIgnoreCase("TIME_OF_SCHEDULED_DPRT")) rule = Rule_TIME_OF_SCHEDULED_DPRT.parse(context);
    else if (rulename.equalsIgnoreCase("Sub_AWB_Prefix")) rule = Rule_Sub_AWB_Prefix.parse(context);
    else if (rulename.equalsIgnoreCase("Sub_AWB_SerialNum")) rule = Rule_Sub_AWB_SerialNum.parse(context);
    else if (rulename.equalsIgnoreCase("AIRPORT_CITY_CODE_OF_ORIGIN")) rule = Rule_AIRPORT_CITY_CODE_OF_ORIGIN.parse(context);
    else if (rulename.equalsIgnoreCase("AIRPORT_CITY_CODE_OF_DEST")) rule = Rule_AIRPORT_CITY_CODE_OF_DEST.parse(context);
    else if (rulename.equalsIgnoreCase("SHIPMENT_DESCRIPTION_CODE")) rule = Rule_SHIPMENT_DESCRIPTION_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("NUMBER_OF_PIECES")) rule = Rule_NUMBER_OF_PIECES.parse(context);
    else if (rulename.equalsIgnoreCase("WEIGHT_CODE")) rule = Rule_WEIGHT_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("WEIGHT")) rule = Rule_WEIGHT.parse(context);
    else if (rulename.equalsIgnoreCase("VOLUME_CODE")) rule = Rule_VOLUME_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("VOLUME_AMOUNT")) rule = Rule_VOLUME_AMOUNT.parse(context);
    else if (rulename.equalsIgnoreCase("Hid_Density_Indicator")) rule = Rule_Hid_Density_Indicator.parse(context);
    else if (rulename.equalsIgnoreCase("DENSITY_GROUP")) rule = Rule_DENSITY_GROUP.parse(context);
    else if (rulename.equalsIgnoreCase("Hid_Shipment_Description_Code_T")) rule = Rule_Hid_Shipment_Description_Code_T.parse(context);
    else if (rulename.equalsIgnoreCase("NUMBER_OF_TOTAL_PIECES")) rule = Rule_NUMBER_OF_TOTAL_PIECES.parse(context);
    else if (rulename.equalsIgnoreCase("MANIFEST_DESC_OF_GOODS")) rule = Rule_MANIFEST_DESC_OF_GOODS.parse(context);
    else if (rulename.equalsIgnoreCase("SPECIAL_HANDLING_CODE")) rule = Rule_SPECIAL_HANDLING_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("MEASUREMENT_UNIT_CODE")) rule = Rule_MEASUREMENT_UNIT_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("LENGTH_DIMENSION")) rule = Rule_LENGTH_DIMENSION.parse(context);
    else if (rulename.equalsIgnoreCase("WIDTH_DIMENSION")) rule = Rule_WIDTH_DIMENSION.parse(context);
    else if (rulename.equalsIgnoreCase("HEIGHT_DIMENSION")) rule = Rule_HEIGHT_DIMENSION.parse(context);
    else if (rulename.equalsIgnoreCase("NUMBERS_OF_PIECES")) rule = Rule_NUMBERS_OF_PIECES.parse(context);
    else if (rulename.equalsIgnoreCase("AIRPORT_CODE_OF_NEXT_DEST")) rule = Rule_AIRPORT_CODE_OF_NEXT_DEST.parse(context);
    else if (rulename.equalsIgnoreCase("CARRIER_CODE")) rule = Rule_CARRIER_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("MOVEMENT_PRIORITY_CODE")) rule = Rule_MOVEMENT_PRIORITY_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("OTHER_SERVICE_INFORMATION_1")) rule = Rule_OTHER_SERVICE_INFORMATION_1.parse(context);
    else if (rulename.equalsIgnoreCase("OTHER_SERVICE_INFORMATION_2")) rule = Rule_OTHER_SERVICE_INFORMATION_2.parse(context);
    else if (rulename.equalsIgnoreCase("Hid_Customs_Reference")) rule = Rule_Hid_Customs_Reference.parse(context);
    else if (rulename.equalsIgnoreCase("CUSTOMS_ORIGIN_CODE")) rule = Rule_CUSTOMS_ORIGIN_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("Sub_ULD_Type")) rule = Rule_Sub_ULD_Type.parse(context);
    else if (rulename.equalsIgnoreCase("Sub_ULD_Serial_Number")) rule = Rule_Sub_ULD_Serial_Number.parse(context);
    else if (rulename.equalsIgnoreCase("Sub_ULD_Owner_Code")) rule = Rule_Sub_ULD_Owner_Code.parse(context);
    else if (rulename.equalsIgnoreCase("ULD_LOADING_INDICATOR")) rule = Rule_ULD_LOADING_INDICATOR.parse(context);
    else if (rulename.equalsIgnoreCase("ULD_REMARKS")) rule = Rule_ULD_REMARKS.parse(context);
    else if (rulename.equalsIgnoreCase("ULD_VOLUME_AVAILABLE_CODE")) rule = Rule_ULD_VOLUME_AVAILABLE_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("END_OF_MESSAGE_CODE")) rule = Rule_END_OF_MESSAGE_CODE.parse(context);
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
