package com.ke.css.cimp.fbl.fbl1;
/* -----------------------------------------------------------------------------
 * Rule_FORWRDING_AGT_ABBREVIATED_NAME.java
 * -----------------------------------------------------------------------------
 *
 * Producer : com.parse2.aparse.Parser 2.5
 * Produced : Fri Feb 23 16:04:23 KST 2018
 *
 * -----------------------------------------------------------------------------
 */

import java.util.ArrayList;

final public class Rule_FORWRDING_AGT_ABBREVIATED_NAME extends Rule
{
  public Rule_FORWRDING_AGT_ABBREVIATED_NAME(String spelling, ArrayList<Rule> rules)
  {
    super(spelling, rules);
  }

  public Object accept(Visitor visitor)
  {
    return visitor.visit(this);
  }

  public static Rule_FORWRDING_AGT_ABBREVIATED_NAME parse(ParserContext context)
  {
    context.push("FORWRDING_AGT_ABBREVIATED_NAME");

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
        @SuppressWarnings("unused")
        int c1 = 0;
        for (int i1 = 0; i1 < 17 && f1; i1++)
        {
          Rule rule = Rule_Typ_Text.parse(context);
          if ((f1 = rule != null))
          {
            a1.add(rule, context.index);
            c1++;
          }
        }
        parsed = true;
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
        rule = new Rule_FORWRDING_AGT_ABBREVIATED_NAME(context.text.substring(a0.start, a0.end), a0.rules);
    }
    else
    {
        context.index = s0;
    }

    context.pop("FORWRDING_AGT_ABBREVIATED_NAME", parsed);

    return (Rule_FORWRDING_AGT_ABBREVIATED_NAME)rule;
  }
}

/* -----------------------------------------------------------------------------
 * eof
 * -----------------------------------------------------------------------------
 */
