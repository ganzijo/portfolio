package com.ke.css.cimp.fhl.fhl2;
/* -----------------------------------------------------------------------------
 * Parser.java
 * -----------------------------------------------------------------------------
 *
 * Producer : com.parse2.aparse.Parser 2.5
 * Produced : Thu Feb 22 17:14:24 KST 2018
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
    else if (rulename.equalsIgnoreCase("FHL")) rule = Rule_FHL.parse(context);
    else if (rulename.equalsIgnoreCase("HEADER")) rule = Rule_HEADER.parse(context);
    else if (rulename.equalsIgnoreCase("SMI")) rule = Rule_SMI.parse(context);
    else if (rulename.equalsIgnoreCase("MBI")) rule = Rule_MBI.parse(context);
    else if (rulename.equalsIgnoreCase("MAWB_NUMBER")) rule = Rule_MAWB_NUMBER.parse(context);
    else if (rulename.equalsIgnoreCase("HBS")) rule = Rule_HBS.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_Grp_SPECIAL_HANDLING_CODE")) rule = Rule_Grp_Grp_SPECIAL_HANDLING_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("TXT")) rule = Rule_TXT.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_FREE_TEXT_DESCRIPTION_OF_GOODS")) rule = Rule_Grp_FREE_TEXT_DESCRIPTION_OF_GOODS.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_TXT_COM")) rule = Rule_Grp_TXT_COM.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_TXT_FLT")) rule = Rule_Grp_TXT_FLT.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_TXT_DCS")) rule = Rule_Grp_TXT_DCS.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_TXT_SNM")) rule = Rule_Grp_TXT_SNM.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_TXT_SCC")) rule = Rule_Grp_TXT_SCC.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_TXT_SAR")) rule = Rule_Grp_TXT_SAR.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_TXT_CNM")) rule = Rule_Grp_TXT_CNM.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_TXT_CCC")) rule = Rule_Grp_TXT_CCC.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_TXT_CAR")) rule = Rule_Grp_TXT_CAR.parse(context);
    else if (rulename.equalsIgnoreCase("SHP")) rule = Rule_SHP.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_SHIPPER_STATE_PROVINCE")) rule = Rule_Grp_SHIPPER_STATE_PROVINCE.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_SHIPPER_POST_CODE")) rule = Rule_Grp_SHIPPER_POST_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("SHIPPER_CONTACT")) rule = Rule_SHIPPER_CONTACT.parse(context);
    else if (rulename.equalsIgnoreCase("CNE")) rule = Rule_CNE.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_CONSIGNEE_STATE_PROVINCE")) rule = Rule_Grp_CONSIGNEE_STATE_PROVINCE.parse(context);
    else if (rulename.equalsIgnoreCase("Grp_CONSIGNEE_POST_CODE")) rule = Rule_Grp_CONSIGNEE_POST_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("CONSIGNEE_CONTACT")) rule = Rule_CONSIGNEE_CONTACT.parse(context);
    else if (rulename.equalsIgnoreCase("CVD")) rule = Rule_CVD.parse(context);
    else if (rulename.equalsIgnoreCase("STANDARD_MESSAGE_IDENTIFIER")) rule = Rule_STANDARD_MESSAGE_IDENTIFIER.parse(context);
    else if (rulename.equalsIgnoreCase("MId_MBI")) rule = Rule_MId_MBI.parse(context);
    else if (rulename.equalsIgnoreCase("MId_HBS")) rule = Rule_MId_HBS.parse(context);
    else if (rulename.equalsIgnoreCase("MId_TXT")) rule = Rule_MId_TXT.parse(context);
    else if (rulename.equalsIgnoreCase("MId_SHP")) rule = Rule_MId_SHP.parse(context);
    else if (rulename.equalsIgnoreCase("MId_CNE")) rule = Rule_MId_CNE.parse(context);
    else if (rulename.equalsIgnoreCase("MId_CVD")) rule = Rule_MId_CVD.parse(context);
    else if (rulename.equalsIgnoreCase("MId_COM")) rule = Rule_MId_COM.parse(context);
    else if (rulename.equalsIgnoreCase("MId_FLT")) rule = Rule_MId_FLT.parse(context);
    else if (rulename.equalsIgnoreCase("MId_DCS")) rule = Rule_MId_DCS.parse(context);
    else if (rulename.equalsIgnoreCase("MId_SNM")) rule = Rule_MId_SNM.parse(context);
    else if (rulename.equalsIgnoreCase("MId_SCC")) rule = Rule_MId_SCC.parse(context);
    else if (rulename.equalsIgnoreCase("MId_SAR")) rule = Rule_MId_SAR.parse(context);
    else if (rulename.equalsIgnoreCase("MId_CNM")) rule = Rule_MId_CNM.parse(context);
    else if (rulename.equalsIgnoreCase("MId_CCC")) rule = Rule_MId_CCC.parse(context);
    else if (rulename.equalsIgnoreCase("MId_CAR")) rule = Rule_MId_CAR.parse(context);
    else if (rulename.equalsIgnoreCase("IF_HUB_REFERENCE_KEY")) rule = Rule_IF_HUB_REFERENCE_KEY.parse(context);
    else if (rulename.equalsIgnoreCase("MESSAGE_TYPE")) rule = Rule_MESSAGE_TYPE.parse(context);
    else if (rulename.equalsIgnoreCase("MESSAGE_SUBTYPE")) rule = Rule_MESSAGE_SUBTYPE.parse(context);
    else if (rulename.equalsIgnoreCase("MESSAGE_RECEIVER")) rule = Rule_MESSAGE_RECEIVER.parse(context);
    else if (rulename.equalsIgnoreCase("MESSAGE_SENDER")) rule = Rule_MESSAGE_SENDER.parse(context);
    else if (rulename.equalsIgnoreCase("MESSAGE_TYPE_VERSION_NUMBER")) rule = Rule_MESSAGE_TYPE_VERSION_NUMBER.parse(context);
    else if (rulename.equalsIgnoreCase("Sub_AWB_Prefix")) rule = Rule_Sub_AWB_Prefix.parse(context);
    else if (rulename.equalsIgnoreCase("Sub_AWB_SerialNum")) rule = Rule_Sub_AWB_SerialNum.parse(context);
    else if (rulename.equalsIgnoreCase("MAWB_AIRPORT_CODE_OF_ORIGIN")) rule = Rule_MAWB_AIRPORT_CODE_OF_ORIGIN.parse(context);
    else if (rulename.equalsIgnoreCase("MAWB_AIRPORT_CODE_OF_DEST")) rule = Rule_MAWB_AIRPORT_CODE_OF_DEST.parse(context);
    else if (rulename.equalsIgnoreCase("Hid_AWB_ShipCode")) rule = Rule_Hid_AWB_ShipCode.parse(context);
    else if (rulename.equalsIgnoreCase("MAWB_NUMBER_OF_PIECES")) rule = Rule_MAWB_NUMBER_OF_PIECES.parse(context);
    else if (rulename.equalsIgnoreCase("MAWB_WEIGHT_CODE")) rule = Rule_MAWB_WEIGHT_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("MAWB_WEIGHT")) rule = Rule_MAWB_WEIGHT.parse(context);
    else if (rulename.equalsIgnoreCase("HAWB_NUMBER")) rule = Rule_HAWB_NUMBER.parse(context);
    else if (rulename.equalsIgnoreCase("HAWB_AIRPORT_CODE_OF_ORIGIN")) rule = Rule_HAWB_AIRPORT_CODE_OF_ORIGIN.parse(context);
    else if (rulename.equalsIgnoreCase("HAWB_AIRPORT_CODE_OF_DEST")) rule = Rule_HAWB_AIRPORT_CODE_OF_DEST.parse(context);
    else if (rulename.equalsIgnoreCase("HAWB_NUMBER_OF_PIECES")) rule = Rule_HAWB_NUMBER_OF_PIECES.parse(context);
    else if (rulename.equalsIgnoreCase("HAWB_WEIGHT_CODE")) rule = Rule_HAWB_WEIGHT_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("HAWB_WEIGHT")) rule = Rule_HAWB_WEIGHT.parse(context);
    else if (rulename.equalsIgnoreCase("SLAC")) rule = Rule_SLAC.parse(context);
    else if (rulename.equalsIgnoreCase("MANIFEST_DESC_OF_GOODS")) rule = Rule_MANIFEST_DESC_OF_GOODS.parse(context);
    else if (rulename.equalsIgnoreCase("SPECIAL_HANDLING_CODE_1")) rule = Rule_SPECIAL_HANDLING_CODE_1.parse(context);
    else if (rulename.equalsIgnoreCase("SPECIAL_HANDLING_CODE_2")) rule = Rule_SPECIAL_HANDLING_CODE_2.parse(context);
    else if (rulename.equalsIgnoreCase("FREE_TEXT_DESCRIPTION_OF_GOODS")) rule = Rule_FREE_TEXT_DESCRIPTION_OF_GOODS.parse(context);
    else if (rulename.equalsIgnoreCase("COMMODITY_DETAIL_FOR_KCUS")) rule = Rule_COMMODITY_DETAIL_FOR_KCUS.parse(context);
    else if (rulename.equalsIgnoreCase("DPRT_ARRV_DATE_FOR_KCUS")) rule = Rule_DPRT_ARRV_DATE_FOR_KCUS.parse(context);
    else if (rulename.equalsIgnoreCase("FLIGHT_NUMBER_FOR_KCUS")) rule = Rule_FLIGHT_NUMBER_FOR_KCUS.parse(context);
    else if (rulename.equalsIgnoreCase("FORWARDER_CODE_FOR_KCUS")) rule = Rule_FORWARDER_CODE_FOR_KCUS.parse(context);
    else if (rulename.equalsIgnoreCase("ASSIGN_PLACE_FOR_KCUS")) rule = Rule_ASSIGN_PLACE_FOR_KCUS.parse(context);
    else if (rulename.equalsIgnoreCase("LOAD_PLACE_FOR_KCUS")) rule = Rule_LOAD_PLACE_FOR_KCUS.parse(context);
    else if (rulename.equalsIgnoreCase("FORWARDER_NAME_FOR_KCUS")) rule = Rule_FORWARDER_NAME_FOR_KCUS.parse(context);
    else if (rulename.equalsIgnoreCase("SHIPPER_NAME_FOR_KCUS")) rule = Rule_SHIPPER_NAME_FOR_KCUS.parse(context);
    else if (rulename.equalsIgnoreCase("SHIPPER_ADDRESS_FOR_KCUS")) rule = Rule_SHIPPER_ADDRESS_FOR_KCUS.parse(context);
    else if (rulename.equalsIgnoreCase("CONSIGNEE_NAME_FOR_KCUS")) rule = Rule_CONSIGNEE_NAME_FOR_KCUS.parse(context);
    else if (rulename.equalsIgnoreCase("CONSIGNEE_POST_CODE_FOR_KUS")) rule = Rule_CONSIGNEE_POST_CODE_FOR_KUS.parse(context);
    else if (rulename.equalsIgnoreCase("CONSIGNEE_ADDRESS_FOR_KCUS")) rule = Rule_CONSIGNEE_ADDRESS_FOR_KCUS.parse(context);
    else if (rulename.equalsIgnoreCase("SHIPPER_POST_CODE_FOR_KCUS")) rule = Rule_SHIPPER_POST_CODE_FOR_KCUS.parse(context);
    else if (rulename.equalsIgnoreCase("SHIPPER_NAME")) rule = Rule_SHIPPER_NAME.parse(context);
    else if (rulename.equalsIgnoreCase("SHIPPER_STREET_ADDRESS")) rule = Rule_SHIPPER_STREET_ADDRESS.parse(context);
    else if (rulename.equalsIgnoreCase("SHIPPER_PLACE")) rule = Rule_SHIPPER_PLACE.parse(context);
    else if (rulename.equalsIgnoreCase("SHIPPER_STATE_PROVINCE")) rule = Rule_SHIPPER_STATE_PROVINCE.parse(context);
    else if (rulename.equalsIgnoreCase("SHIPPER_ISO_COUNTRY_CODE")) rule = Rule_SHIPPER_ISO_COUNTRY_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("SHIPPER_POST_CODE")) rule = Rule_SHIPPER_POST_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("SHIPPER_CONTACT_IDENTIFIER")) rule = Rule_SHIPPER_CONTACT_IDENTIFIER.parse(context);
    else if (rulename.equalsIgnoreCase("SHIPPER_CONTACT_NUMBER")) rule = Rule_SHIPPER_CONTACT_NUMBER.parse(context);
    else if (rulename.equalsIgnoreCase("CONSIGNEE_NAME")) rule = Rule_CONSIGNEE_NAME.parse(context);
    else if (rulename.equalsIgnoreCase("CONSIGNEE_STREET_ADDRESS")) rule = Rule_CONSIGNEE_STREET_ADDRESS.parse(context);
    else if (rulename.equalsIgnoreCase("CONSIGNEE_PLACE")) rule = Rule_CONSIGNEE_PLACE.parse(context);
    else if (rulename.equalsIgnoreCase("CONSIGNEE_STATE_PROVINCE")) rule = Rule_CONSIGNEE_STATE_PROVINCE.parse(context);
    else if (rulename.equalsIgnoreCase("CONSIGNEE_ISO_COUNTRY_CODE")) rule = Rule_CONSIGNEE_ISO_COUNTRY_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("CONSIGNEE_POST_CODE")) rule = Rule_CONSIGNEE_POST_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("CONSIGNEE_CONTACT_IDENTIFIER")) rule = Rule_CONSIGNEE_CONTACT_IDENTIFIER.parse(context);
    else if (rulename.equalsIgnoreCase("CONSIGNEE_CONTACT_NUMBER")) rule = Rule_CONSIGNEE_CONTACT_NUMBER.parse(context);
    else if (rulename.equalsIgnoreCase("ISO_CURRENCY_CODE")) rule = Rule_ISO_CURRENCY_CODE.parse(context);
    else if (rulename.equalsIgnoreCase("P_C_IND_WEIGHT_VALUATION")) rule = Rule_P_C_IND_WEIGHT_VALUATION.parse(context);
    else if (rulename.equalsIgnoreCase("P_C_IND_OTHER_CHARGES")) rule = Rule_P_C_IND_OTHER_CHARGES.parse(context);
    else if (rulename.equalsIgnoreCase("DECLARED_VALUE_FOR_CARRIAGE")) rule = Rule_DECLARED_VALUE_FOR_CARRIAGE.parse(context);
    else if (rulename.equalsIgnoreCase("DECLARED_VALUE_FOR_CUSTOMS")) rule = Rule_DECLARED_VALUE_FOR_CUSTOMS.parse(context);
    else if (rulename.equalsIgnoreCase("DECLARE_VALUE_FOR_INSURANCE")) rule = Rule_DECLARE_VALUE_FOR_INSURANCE.parse(context);
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
