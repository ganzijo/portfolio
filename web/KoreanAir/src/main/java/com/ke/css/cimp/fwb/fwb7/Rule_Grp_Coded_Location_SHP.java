package com.ke.css.cimp.fwb.fwb7;
/* -----------------------------------------------------------------------------
 * Rule_Grp_Coded_Location_SHP.java
 * -----------------------------------------------------------------------------
 *
 * Producer : com.parse2.aparse.Parser 2.5
 * Produced : Tue Mar 06 10:38:08 KST 2018
 *
 * -----------------------------------------------------------------------------
 */

import java.util.ArrayList;

final public class Rule_Grp_Coded_Location_SHP extends Rule
{
  public Rule_Grp_Coded_Location_SHP(String spelling, ArrayList<Rule> rules)
  {
    super(spelling, rules);
  }

  public Object accept(Visitor visitor)
  {
    return visitor.visit(this);
  }

  public static Rule_Grp_Coded_Location_SHP parse(ParserContext context)
  {
    context.push("Grp_Coded_Location_SHP");

    boolean parsed = true;
    int s0 = context.index;
    ParserAlternative a0 = new ParserAlternative(s0);

    ArrayList<ParserAlternative> as1 = new ArrayList<ParserAlternative>();
    parsed = false;
    {
      int s1 = context.index;
      ParserAlternative a1 = new ParserAlternative(s1);
      parsed = true;
      if (parsed)
      {
        boolean f1 = true;
        int c1 = 0;
        for (int i1 = 0; i1 < 1 && f1; i1++)
        {
          int g1 = context.index;
          ArrayList<ParserAlternative> as2 = new ArrayList<ParserAlternative>();
          parsed = false;
          {
            int s2 = context.index;
            ParserAlternative a2 = new ParserAlternative(s2);
            parsed = true;
            if (parsed)
            {
              boolean f2 = true;
              int c2 = 0;
              for (int i2 = 0; i2 < 1 && f2; i2++)
              {
                Rule rule = Rule_Sep_Slant.parse(context);
                if ((f2 = rule != null))
                {
                  a2.add(rule, context.index);
                  c2++;
                }
              }
              parsed = c2 == 1;
            }
            if (parsed)
            {
              boolean f2 = true;
              int c2 = 0;
              for (int i2 = 0; i2 < 1 && f2; i2++)
              {
                Rule rule = Rule_SHIPPER_ISO_COUNTRY_CODE.parse(context);
                if ((f2 = rule != null))
                {
                  a2.add(rule, context.index);
                  c2++;
                }
              }
              parsed = c2 == 1;
            }
            if (parsed)
            {
              boolean f2 = true;
              int c2 = 0;
              for (int i2 = 0; i2 < 1 && f2; i2++)
              {
                int g2 = context.index;
                ArrayList<ParserAlternative> as3 = new ArrayList<ParserAlternative>();
                parsed = false;
                {
                  int s3 = context.index;
                  ParserAlternative a3 = new ParserAlternative(s3);
                  parsed = true;
                  if (parsed)
                  {
                    boolean f3 = true;
                    int c3 = 0;
                    for (int i3 = 0; i3 < 1 && f3; i3++)
                    {
                      int g3 = context.index;
                      ArrayList<ParserAlternative> as4 = new ArrayList<ParserAlternative>();
                      parsed = false;
                      {
                        int s4 = context.index;
                        ParserAlternative a4 = new ParserAlternative(s4);
                        parsed = true;
                        if (parsed)
                        {
                          boolean f4 = true;
                          int c4 = 0;
                          for (int i4 = 0; i4 < 1 && f4; i4++)
                          {
                            Rule rule = Rule_Sep_Slant.parse(context);
                            if ((f4 = rule != null))
                            {
                              a4.add(rule, context.index);
                              c4++;
                            }
                          }
                          parsed = c4 == 1;
                        }
                        if (parsed)
                        {
                          boolean f4 = true;
                          int c4 = 0;
                          for (int i4 = 0; i4 < 1 && f4; i4++)
                          {
                            Rule rule = Rule_SHIPPER_POST_CODE.parse(context);
                            if ((f4 = rule != null))
                            {
                              a4.add(rule, context.index);
                              c4++;
                            }
                          }
                          parsed = c4 == 1;
                        }
                        if (parsed)
                        {
                          boolean f4 = true;
                          int c4 = 0;
                          for (int i4 = 0; i4 < 1 && f4; i4++)
                          {
                            Rule rule = Rule_SHIPPER_CONTACT.parse(context);
                            if ((f4 = rule != null))
                            {
                              a4.add(rule, context.index);
                              c4++;
                            }
                          }
                          while (f4)
                          {
                            Rule rule = Rule_SHIPPER_CONTACT.parse(context);
                            if ((f4 = rule != null))
                            {
                              a4.add(rule, context.index);
                              c4++;
                            }
                          }
                          parsed = c4 >= 1;
                        }
                        if (parsed)
                        {
                          boolean f4 = true;
                          int c4 = 0;
                          for (int i4 = 0; i4 < 1 && f4; i4++)
                          {
                            Rule rule = Rule_Sep_CRLF.parse(context);
                            if ((f4 = rule != null))
                            {
                              a4.add(rule, context.index);
                              c4++;
                            }
                          }
                          parsed = c4 == 1;
                        }
                        if (parsed)
                        {
                          as4.add(a4);
                        }
                        context.index = s4;
                      }

                      ParserAlternative b = ParserAlternative.getBest(as4);

                      parsed = b != null;

                      if (parsed)
                      {
                        a3.add(b.rules, b.end);
                        context.index = b.end;
                      }

                      f3 = context.index > g3;
                      if (parsed) c3++;
                    }
                    parsed = c3 == 1;
                  }
                  if (parsed)
                  {
                    as3.add(a3);
                  }
                  context.index = s3;
                }
                {
                  int s3 = context.index;
                  ParserAlternative a3 = new ParserAlternative(s3);
                  parsed = true;
                  if (parsed)
                  {
                    boolean f3 = true;
                    int c3 = 0;
                    for (int i3 = 0; i3 < 1 && f3; i3++)
                    {
                      int g3 = context.index;
                      ArrayList<ParserAlternative> as4 = new ArrayList<ParserAlternative>();
                      parsed = false;
                      {
                        int s4 = context.index;
                        ParserAlternative a4 = new ParserAlternative(s4);
                        parsed = true;
                        if (parsed)
                        {
                          boolean f4 = true;
                          int c4 = 0;
                          for (int i4 = 0; i4 < 1 && f4; i4++)
                          {
                            Rule rule = Rule_Sep_Slant.parse(context);
                            if ((f4 = rule != null))
                            {
                              a4.add(rule, context.index);
                              c4++;
                            }
                          }
                          parsed = c4 == 1;
                        }
                        if (parsed)
                        {
                          boolean f4 = true;
                          int c4 = 0;
                          for (int i4 = 0; i4 < 1 && f4; i4++)
                          {
                            Rule rule = Rule_SHIPPER_CONTACT.parse(context);
                            if ((f4 = rule != null))
                            {
                              a4.add(rule, context.index);
                              c4++;
                            }
                          }
                          while (f4)
                          {
                            Rule rule = Rule_SHIPPER_CONTACT.parse(context);
                            if ((f4 = rule != null))
                            {
                              a4.add(rule, context.index);
                              c4++;
                            }
                          }
                          parsed = c4 >= 1;
                        }
                        if (parsed)
                        {
                          boolean f4 = true;
                          int c4 = 0;
                          for (int i4 = 0; i4 < 1 && f4; i4++)
                          {
                            Rule rule = Rule_Sep_CRLF.parse(context);
                            if ((f4 = rule != null))
                            {
                              a4.add(rule, context.index);
                              c4++;
                            }
                          }
                          parsed = c4 == 1;
                        }
                        if (parsed)
                        {
                          as4.add(a4);
                        }
                        context.index = s4;
                      }

                      ParserAlternative b = ParserAlternative.getBest(as4);

                      parsed = b != null;

                      if (parsed)
                      {
                        a3.add(b.rules, b.end);
                        context.index = b.end;
                      }

                      f3 = context.index > g3;
                      if (parsed) c3++;
                    }
                    parsed = c3 == 1;
                  }
                  if (parsed)
                  {
                    as3.add(a3);
                  }
                  context.index = s3;
                }
                {
                  int s3 = context.index;
                  ParserAlternative a3 = new ParserAlternative(s3);
                  parsed = true;
                  if (parsed)
                  {
                    boolean f3 = true;
                    int c3 = 0;
                    for (int i3 = 0; i3 < 1 && f3; i3++)
                    {
                      int g3 = context.index;
                      ArrayList<ParserAlternative> as4 = new ArrayList<ParserAlternative>();
                      parsed = false;
                      {
                        int s4 = context.index;
                        ParserAlternative a4 = new ParserAlternative(s4);
                        parsed = true;
                        if (parsed)
                        {
                          boolean f4 = true;
                          int c4 = 0;
                          for (int i4 = 0; i4 < 1 && f4; i4++)
                          {
                            Rule rule = Rule_Sep_Slant.parse(context);
                            if ((f4 = rule != null))
                            {
                              a4.add(rule, context.index);
                              c4++;
                            }
                          }
                          parsed = c4 == 1;
                        }
                        if (parsed)
                        {
                          boolean f4 = true;
                          int c4 = 0;
                          for (int i4 = 0; i4 < 1 && f4; i4++)
                          {
                            Rule rule = Rule_SHIPPER_POST_CODE.parse(context);
                            if ((f4 = rule != null))
                            {
                              a4.add(rule, context.index);
                              c4++;
                            }
                          }
                          parsed = c4 == 1;
                        }
                        if (parsed)
                        {
                          boolean f4 = true;
                          int c4 = 0;
                          for (int i4 = 0; i4 < 1 && f4; i4++)
                          {
                            Rule rule = Rule_Sep_CRLF.parse(context);
                            if ((f4 = rule != null))
                            {
                              a4.add(rule, context.index);
                              c4++;
                            }
                          }
                          parsed = c4 == 1;
                        }
                        if (parsed)
                        {
                          as4.add(a4);
                        }
                        context.index = s4;
                      }

                      ParserAlternative b = ParserAlternative.getBest(as4);

                      parsed = b != null;

                      if (parsed)
                      {
                        a3.add(b.rules, b.end);
                        context.index = b.end;
                      }

                      f3 = context.index > g3;
                      if (parsed) c3++;
                    }
                    parsed = c3 == 1;
                  }
                  if (parsed)
                  {
                    as3.add(a3);
                  }
                  context.index = s3;
                }
                {
                  int s3 = context.index;
                  ParserAlternative a3 = new ParserAlternative(s3);
                  parsed = true;
                  if (parsed)
                  {
                    boolean f3 = true;
                    int c3 = 0;
                    for (int i3 = 0; i3 < 1 && f3; i3++)
                    {
                      int g3 = context.index;
                      ArrayList<ParserAlternative> as4 = new ArrayList<ParserAlternative>();
                      parsed = false;
                      {
                        int s4 = context.index;
                        ParserAlternative a4 = new ParserAlternative(s4);
                        parsed = true;
                        if (parsed)
                        {
                          boolean f4 = true;
                          int c4 = 0;
                          for (int i4 = 0; i4 < 1 && f4; i4++)
                          {
                            Rule rule = Rule_Sep_CRLF.parse(context);
                            if ((f4 = rule != null))
                            {
                              a4.add(rule, context.index);
                              c4++;
                            }
                          }
                          parsed = c4 == 1;
                        }
                        if (parsed)
                        {
                          as4.add(a4);
                        }
                        context.index = s4;
                      }

                      ParserAlternative b = ParserAlternative.getBest(as4);

                      parsed = b != null;

                      if (parsed)
                      {
                        a3.add(b.rules, b.end);
                        context.index = b.end;
                      }

                      f3 = context.index > g3;
                      if (parsed) c3++;
                    }
                    parsed = c3 == 1;
                  }
                  if (parsed)
                  {
                    as3.add(a3);
                  }
                  context.index = s3;
                }

                ParserAlternative b = ParserAlternative.getBest(as3);

                parsed = b != null;

                if (parsed)
                {
                  a2.add(b.rules, b.end);
                  context.index = b.end;
                }

                f2 = context.index > g2;
                if (parsed) c2++;
              }
              parsed = c2 == 1;
            }
            if (parsed)
            {
              as2.add(a2);
            }
            context.index = s2;
          }

          ParserAlternative b = ParserAlternative.getBest(as2);

          parsed = b != null;

          if (parsed)
          {
            a1.add(b.rules, b.end);
            context.index = b.end;
          }

          f1 = context.index > g1;
          if (parsed) c1++;
        }
        parsed = c1 == 1;
      }
      if (parsed)
      {
        as1.add(a1);
      }
      context.index = s1;
    }

    ParserAlternative b = ParserAlternative.getBest(as1);

    parsed = b != null;

    if (parsed)
    {
      a0.add(b.rules, b.end);
      context.index = b.end;
    }

    Rule rule = null;
    if (parsed)
    {
        rule = new Rule_Grp_Coded_Location_SHP(context.text.substring(a0.start, a0.end), a0.rules);
    }
    else
    {
        context.index = s0;
    }

    context.pop("Grp_Coded_Location_SHP", parsed);

    return (Rule_Grp_Coded_Location_SHP)rule;
  }
}

/* -----------------------------------------------------------------------------
 * eof
 * -----------------------------------------------------------------------------
 */
