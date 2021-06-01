/**
 * 
 */
package com.leetcode;

import java.util.Stack;

//import junit.framework.Assert;

/**
 * @author aahu
 *Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. 
Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, 
k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class DecodeStrings {
  public String decodeString(String s) {
    Stack<String> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    StringBuilder innerSB = new StringBuilder();

    int i = 0, len = s.length();
    String t;
    int loop = 0;
    String tmp = "";
    String loops = "";

    while (i < len) {
      if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != '['
          && s.charAt(i) != ']' && stack.isEmpty()) {
        sb.append(s.charAt(i));
        i++;

      } else {
        if (s.charAt(i) != ']') {
          stack.push(s.substring(i, i + 1));
          i++;

        } else {

          while (!stack.isEmpty()&&!(t = stack.pop()).equals("[")) {
            tmp = t + tmp;
          }
          while (!stack.isEmpty()
              && Character.isDigit(stack.peek().charAt(0))) {
            loops = stack.pop() + loops;
          }
          loop = Integer.parseInt(loops);

          for (int j = 0; j < loop; j++) {
            innerSB.append(tmp);
          }
          if (stack.isEmpty()) {
            sb.append(innerSB.toString());
          } else {
            stack.push(innerSB.toString());
          }
          innerSB= new StringBuilder();
          tmp = "";
          loops = "";
          i++;
        }
      }
    }
    return sb.toString();
  }

  /**
   * @param args
   */
  public static void main(String[] args) {

System.out.println(new DecodeStrings().decodeString("2[abc]3[cd]ef"));
//         Assert.assertEquals("", "");

  }

}
