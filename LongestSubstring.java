/**
 * 
 */
package com.leetcode;

/**
 * @author aahu
 * Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 */
public class LongestSubstring {
  
  public int lengthOfLongestSubstring(String s) {
    int n = s.length(), ans = 0;
    int[] index = new int[128]; // current index of character
    // try to extend the range [i, j]
    for (int j = 0, i = 0; j < n; j++) {
      i = Math.max(index[s.charAt(j)], i);
      ans = Math.max(ans, j - i + 1);
      index[s.charAt(j)] = j + 1;
    }
    return ans;}

  /**
   * @param args
   */
  public static void main(String[] args) {
  
    System.out.println(new LongestSubstring().lengthOfLongestSubstring("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ "
        + "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijkl"));

  }

}
