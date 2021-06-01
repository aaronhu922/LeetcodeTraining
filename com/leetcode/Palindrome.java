/**
 * 
 */
package com.leetcode;

import com.leetcode.Twolinkedlist.ListNode;

/**
 * @author aahu
 *
 */
public class Palindrome {

  public boolean isPalindrome(String s) {
    if (s == null) {
      return false;
    }
    if (s.equals("")) {
      return true;
    }
    int l = 0;
    int r = s.length() - 1;
    while (l < r) {
      while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
        l++;
      }
      while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
        r--;
      }
      if ((s.charAt(l) - s.charAt(r)) % 32 == 0) {
        l++;
        r--;
      } else
        return false;
    }

    return true;
  }

  public boolean isPalindrome(ListNode head) {
    
    return false;
  }


  /**
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(
        new Palindrome().isPalindrome("A man, a plan, a canal: Panama"));
    System.out.println(new Palindrome().isPalindrome("dsfads"));
    System.out.println(new Palindrome().isPalindrome(".;"));
    System.out.println(new Palindrome().isPalindrome(" "));
    System.out.println(new Palindrome().isPalindrome("a "));
    // assert(new Palindrome().isPalindrome("A man, a plan, a canal: Panama"));
    
    System.out.println(5/2);
    System.out.println(5%2);
    System.out.println('A'-'a');
    System.out.println((int)'a');

  }

}
