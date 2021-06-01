package com.leetcode;

public class ValidAnagram {
  
  public boolean isAnagram(String s, String t) {
    if (s==null || t==null || s.length() != t.length()) {
      return false;
    }
    
    int[] sfeq = new int[26];
    int[] tfeq = new int[26];
    
    for (int i = 0; i<s.length();i++)
    {
      sfeq[s.charAt(i)-'a']++;
      tfeq[t.charAt(i)-'a']++;
    }
 
    for (int i = 0; i < sfeq.length; i++) {
      if (sfeq[i]!=tfeq[i]) {
        return false;
      }
    }
    return true;
    
  }

  public static void main(String[] args) {
System.out.println(new ValidAnagram().isAnagram("hello", "ollhe"));
  }

}
