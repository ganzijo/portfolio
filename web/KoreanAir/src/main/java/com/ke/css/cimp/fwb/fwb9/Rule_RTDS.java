package com.ke.css.cimp.fwb.fwb9;
/* -----------------------------------------------------------------------------
 * Rule_RTDS.java
 * -----------------------------------------------------------------------------
 *
 * Producer : com.parse2.aparse.Parser 2.5
 * Produced : Tue Mar 06 10:38:42 KST 2018
 *
 * -----------------------------------------------------------------------------
 */

import java.util.ArrayList;

final public class Rule_RTDS extends Rule
{
  public Rule_RTDS(String spelling, ArrayList<Rule> rules)
  {
    super(spelling, rules);
  }

  public Object accept(Visitor visitor)
  {
    return visitor.visit(this);
  }

  public static Rule_RTDS parse(ParserContext context)
  {
    context.push("RTDS");

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
                      Rule rule = Rule_Hid_AWB_Rate_Line_Number.parse(context);
                      if ((f3 = rule != null))
                      {
                        a3.add(rule, context.index);
                        c3++;
                      }
                    }
                    parsed = c3 == 1;
                  }
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
                            int g4 = context.index;
                            ArrayList<ParserAlternative> as5 = new ArrayList<ParserAlternative>();
                            parsed = false;
                            {
                              int s5 = context.index;
                              ParserAlternative a5 = new ParserAlternative(s5);
                              parsed = true;
                              if (parsed)
                              {
                                boolean f5 = true;
                                int c5 = 0;
                                for (int i5 = 0; i5 < 1 && f5; i5++)
                                {
                                  Rule rule = Rule_Grp_First.parse(context);
                                  if ((f5 = rule != null))
                                  {
                                    a5.add(rule, context.index);
                                    c5++;
                                  }
                                }
                                parsed = c5 == 1;
                              }
                              if (parsed)
                              {
                                boolean f5 = true;
                                int c5 = 0;
                                for (int i5 = 0; i5 < 1 && f5; i5++)
                                {
                                  Rule rule = Rule_Sep_CRLF.parse(context);
                                  if ((f5 = rule != null))
                                  {
                                    a5.add(rule, context.index);
                                    c5++;
                                  }
                                }
                                parsed = c5 == 1;
                              }
                              if (parsed)
                              {
                                boolean f5 = true;
                                int c5 = 0;
                                for (int i5 = 0; i5 < 1 && f5; i5++)
                                {
                                  Rule rule = Rule_Grp_Second.parse(context);
                                  if ((f5 = rule != null))
                                  {
                                    a5.add(rule, context.index);
                                    c5++;
                                  }
                                }
                                parsed = c5 == 1;
                              }
                              if (parsed)
                              {
                                boolean f5 = true;
                                int c5 = 0;
                                for (int i5 = 0; i5 < 1 && f5; i5++)
                                {
                                  Rule rule = Rule_Sep_CRLF.parse(context);
                                  if ((f5 = rule != null))
                                  {
                                    a5.add(rule, context.index);
                                    c5++;
                                  }
                                }
                                parsed = c5 == 1;
                              }
                              if (parsed)
                              {
                                as5.add(a5);
                              }
                              context.index = s5;
                            }

                            ParserAlternative b = ParserAlternative.getBest(as5);

                            parsed = b != null;

                            if (parsed)
                            {
                              a4.add(b.rules, b.end);
                              context.index = b.end;
                            }

                            f4 = context.index > g4;
                            if (parsed) c4++;
                          }
                          parsed = c4 == 1;
                        }
                        if (parsed)
                        {
                          as4.add(a4);
                        }
                        context.index = s4;
                      }
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
                            int g4 = context.index;
                            ArrayList<ParserAlternative> as5 = new ArrayList<ParserAlternative>();
                            parsed = false;
                            {
                              int s5 = context.index;
                              ParserAlternative a5 = new ParserAlternative(s5);
                              parsed = true;
                              if (parsed)
                              {
                                boolean f5 = true;
                                int c5 = 0;
                                for (int i5 = 0; i5 < 1 && f5; i5++)
                                {
                                  Rule rule = Rule_Grp_First.parse(context);
                                  if ((f5 = rule != null))
                                  {
                                    a5.add(rule, context.index);
                                    c5++;
                                  }
                                }
                                parsed = c5 == 1;
                              }
                              if (parsed)
                              {
                                boolean f5 = true;
                                int c5 = 0;
                                for (int i5 = 0; i5 < 1 && f5; i5++)
                                {
                                  Rule rule = Rule_Sep_CRLF.parse(context);
                                  if ((f5 = rule != null))
                                  {
                                    a5.add(rule, context.index);
                                    c5++;
                                  }
                                }
                                parsed = c5 == 1;
                              }
                              if (parsed)
                              {
                                as5.add(a5);
                              }
                              context.index = s5;
                            }

                            ParserAlternative b = ParserAlternative.getBest(as5);

                            parsed = b != null;

                            if (parsed)
                            {
                              a4.add(b.rules, b.end);
                              context.index = b.end;
                            }

                            f4 = context.index > g4;
                            if (parsed) c4++;
                          }
                          parsed = c4 == 1;
                        }
                        if (parsed)
                        {
                          as4.add(a4);
                        }
                        context.index = s4;
                      }
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
                            int g4 = context.index;
                            ArrayList<ParserAlternative> as5 = new ArrayList<ParserAlternative>();
                            parsed = false;
                            {
                              int s5 = context.index;
                              ParserAlternative a5 = new ParserAlternative(s5);
                              parsed = true;
                              if (parsed)
                              {
                                boolean f5 = true;
                                int c5 = 0;
                                for (int i5 = 0; i5 < 1 && f5; i5++)
                                {
                                  Rule rule = Rule_Grp_Second.parse(context);
                                  if ((f5 = rule != null))
                                  {
                                    a5.add(rule, context.index);
                                    c5++;
                                  }
                                }
                                parsed = c5 == 1;
                              }
                              if (parsed)
                              {
                                boolean f5 = true;
                                int c5 = 0;
                                for (int i5 = 0; i5 < 1 && f5; i5++)
                                {
                                  Rule rule = Rule_Sep_CRLF.parse(context);
                                  if ((f5 = rule != null))
                                  {
                                    a5.add(rule, context.index);
                                    c5++;
                                  }
                                }
                                parsed = c5 == 1;
                              }
                              if (parsed)
                              {
                                as5.add(a5);
                              }
                              context.index = s5;
                            }

                            ParserAlternative b = ParserAlternative.getBest(as5);

                            parsed = b != null;

                            if (parsed)
                            {
                              a4.add(b.rules, b.end);
                              context.index = b.end;
                            }

                            f4 = context.index > g4;
                            if (parsed) c4++;
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
                      Rule rule = Rule_Hid_AWB_Rate_Line_Number_12.parse(context);
                      if ((f3 = rule != null))
                      {
                        a3.add(rule, context.index);
                        c3++;
                      }
                    }
                    parsed = c3 == 1;
                  }
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
                            Rule rule = Rule_Grp_Goods_Description.parse(context);
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
                            Rule rule = Rule_Grp_Consolidation.parse(context);
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
                            Rule rule = Rule_Grp_Dimensions.parse(context);
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
                            Rule rule = Rule_Grp_Volume.parse(context);
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
                            Rule rule = Rule_Grp_ULD_Number.parse(context);
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
                            Rule rule = Rule_Grp_Shippers_Load_and_Count.parse(context);
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
                            Rule rule = Rule_Grp_Harmonised_Commodity_Code.parse(context);
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
                            Rule rule = Rule_Grp_Country_of_Origin_of_Goods.parse(context);
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
                            Rule rule = Rule_Grp_Service_Code_Details.parse(context);
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
                    boolean f3 = true;
                    int c3 = 0;
                    for (int i3 = 0; i3 < 1 && f3; i3++)
                    {
                      Rule rule = Rule_Sep_CRLF.parse(context);
                      if ((f3 = rule != null))
                      {
                        a3.add(rule, context.index);
                        c3++;
                      }
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
        rule = new Rule_RTDS(context.text.substring(a0.start, a0.end), a0.rules);
    }
    else
    {
        context.index = s0;
    }

    context.pop("RTDS", parsed);

    return (Rule_RTDS)rule;
  }
}

/* -----------------------------------------------------------------------------
 * eof
 * -----------------------------------------------------------------------------
 */
