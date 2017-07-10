/**
 * 
 */
package com.leetcode;

import java.awt.AlphaComposite;

/**
 * @author aahu
 * Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
 *
 */
public class ValidNumber {
  
  
  public boolean isNumber(String s) {
    int i = 0, n = s.length();
    boolean isNumberic = false;
    while (i < n && Character.isWhitespace(s.charAt(i))) {
      i++;
    }
    if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
      i++;
    }
    while (i < n && Character.isDigit(s.charAt(i))) {
      i++;
      isNumberic = true;
    }
    if (i < n && s.charAt(i) == '.') {
      i++;
      while (i < n && Character.isDigit(s.charAt(i))) {
        i++;
        isNumberic = true;
      }
    }
    if (isNumberic && i < n && s.charAt(i) == 'e') {
      i++;
      isNumberic = false;
      if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
        i++;
      }
      while (i < n && Character.isDigit(s.charAt(i))) {
        i++;
        isNumberic = true;
      }

    }
    while (i < n && Character.isWhitespace(s.charAt(i)))
      i++;
    return isNumberic && i == n;
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    
  ValidNumber vd = new ValidNumber();
    System.out.println(vd.isNumber("1"));
    System.out.println(vd.isNumber(" 1"));

    System.out.println(vd.isNumber("."));
    System.out.println(vd.isNumber(".1"));
    System.out.println(vd.isNumber("1e-10"));
    System.out.println(vd.isNumber("1efea"));


  }

}
