package com.ke.css.cimp.fwb.fwb13;
/* -----------------------------------------------------------------------------
 * Rule_Hid_AWB_Column_Identifier_S.java
 * -----------------------------------------------------------------------------
 *
 * Producer : com.parse2.aparse.Parser 2.5
 * Produced : Tue Mar 06 10:35:29 KST 2018
 *
 * -----------------------------------------------------------------------------
 */

import java.util.ArrayList;

final public class Rule_Hid_AWB_Column_Identifier_S extends Rule
{
  public Rule_Hid_AWB_Column_Identifier_S(String spelling, ArrayList<Rule> rules)
  {
    super(spelling, rules);
  }

  public Object accept(Visitor visitor)
  {
    return visitor.visit(this);
  }

  public static Rule_Hid_AWB_Column_Identifier_S parse(ParserContext context)
  {
    context.push("Hid_AWB_Column_Identifier_S");

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
          Rule rule = Terminal_StringValue.parse(context, "S");
          if ((f1 = rule != null))
          {
            a1.add(rule, context.index);
            c1++;
          }
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
        rule = new Rule_Hid_AWB_Column_Identifier_S(context.text.substring(a0.start, a0.end), a0.rules);
    }
    else
    {
        context.index = s0;
    }

    context.pop("Hid_AWB_Column_Identifier_S", parsed);

    return (Rule_Hid_AWB_Column_Identifier_S)rule;
  }
}

/* -----------------------------------------------------------------------------
 * eof
 * -----------------------------------------------------------------------------
 */
