package com.ke.css.cimp.fhl.fhl5;
/* -----------------------------------------------------------------------------
 * Rule_HAWB_AIRPORT_CODE_OF_ORIGIN.java
 * -----------------------------------------------------------------------------
 *
 * Producer : com.parse2.aparse.Parser 2.5
 * Produced : Thu Feb 22 17:11:51 KST 2018
 *
 * -----------------------------------------------------------------------------
 */

import java.util.ArrayList;

final public class Rule_HAWB_AIRPORT_CODE_OF_ORIGIN extends Rule
{
  public Rule_HAWB_AIRPORT_CODE_OF_ORIGIN(String spelling, ArrayList<Rule> rules)
  {
    super(spelling, rules);
  }

  public Object accept(Visitor visitor)
  {
    return visitor.visit(this);
  }

  public static Rule_HAWB_AIRPORT_CODE_OF_ORIGIN parse(ParserContext context)
  {
    context.push("HAWB_AIRPORT_CODE_OF_ORIGIN");

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
        for (int i1 = 0; i1 < 3 && f1; i1++)
        {
          Rule rule = Rule_Typ_Alpha.parse(context);
          if ((f1 = rule != null))
          {
            a1.add(rule, context.index);
            c1++;
          }
        }
        parsed = c1 == 3;
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
        rule = new Rule_HAWB_AIRPORT_CODE_OF_ORIGIN(context.text.substring(a0.start, a0.end), a0.rules);
    }
    else
    {
        context.index = s0;
    }

    context.pop("HAWB_AIRPORT_CODE_OF_ORIGIN", parsed);

    return (Rule_HAWB_AIRPORT_CODE_OF_ORIGIN)rule;
  }
}

/* -----------------------------------------------------------------------------
 * eof
 * -----------------------------------------------------------------------------
 */
