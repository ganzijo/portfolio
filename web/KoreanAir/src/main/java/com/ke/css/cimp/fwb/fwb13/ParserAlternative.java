package com.ke.css.cimp.fwb.fwb13;
/* -----------------------------------------------------------------------------
 * ParserAlternative.java
 * -----------------------------------------------------------------------------
 *
 * Producer : com.parse2.aparse.Parser 2.5
 * Produced : Tue Mar 06 10:35:29 KST 2018
 *
 * -----------------------------------------------------------------------------
 */

import java.util.ArrayList;

import java.util.List;

public class ParserAlternative
{
  public ArrayList<Rule> rules;
  public int start;
  public int end;

  public ParserAlternative(int start)
  {
    this.rules = new ArrayList<Rule>();
    this.start = start;
    this.end = start;
  }

  public void add(Rule rule, int end)
  {
    this.rules.add(rule);
    this.end = end;
  }

  public void add(ArrayList<Rule> rules, int end)
  {
    this.rules.addAll(rules);
    this.end = end;
  }

  static public ParserAlternative getBest(List<ParserAlternative> alternatives)
  {
    ParserAlternative best = null;

    for (ParserAlternative alternative : alternatives)
    {
      if (best == null || alternative.end > best.end)
        best = alternative;
    }

    return best;
  }
}

/* -----------------------------------------------------------------------------
 * eof
 * -----------------------------------------------------------------------------
 */
