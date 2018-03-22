package com.ke.css.cimp.ffr.ffr7;
/* -----------------------------------------------------------------------------
 * Rule_Sub_IATA_Cargo_Agent_Numeric_Code.java
 * -----------------------------------------------------------------------------
 *
 * Producer : com.parse2.aparse.Parser 2.5
 * Produced : Fri Feb 23 14:31:14 KST 2018
 *
 * -----------------------------------------------------------------------------
 */

import java.util.ArrayList;

final public class Rule_Sub_IATA_Cargo_Agent_Numeric_Code extends Rule
{
  public Rule_Sub_IATA_Cargo_Agent_Numeric_Code(String spelling, ArrayList<Rule> rules)
  {
    super(spelling, rules);
  }

  public Object accept(Visitor visitor)
  {
    return visitor.visit(this);
  }

  public static Rule_Sub_IATA_Cargo_Agent_Numeric_Code parse(ParserContext context)
  {
    context.push("Sub_IATA_Cargo_Agent_Numeric_Code");

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
        for (int i1 = 0; i1 < 7 && f1; i1++)
        {
          Rule rule = Rule_Typ_Numeric.parse(context);
          if ((f1 = rule != null))
          {
            a1.add(rule, context.index);
            c1++;
          }
        }
        parsed = c1 == 7;
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
        rule = new Rule_Sub_IATA_Cargo_Agent_Numeric_Code(context.text.substring(a0.start, a0.end), a0.rules);
    }
    else
    {
        context.index = s0;
    }

    context.pop("Sub_IATA_Cargo_Agent_Numeric_Code", parsed);

    return (Rule_Sub_IATA_Cargo_Agent_Numeric_Code)rule;
  }
}

/* -----------------------------------------------------------------------------
 * eof
 * -----------------------------------------------------------------------------
 */
