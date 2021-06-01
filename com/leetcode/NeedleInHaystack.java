/**
 * 
 */
package com.leetcode;

/**
 * @author aahu
 *
 */
public class NeedleInHaystack {

  public int strStr(String haystack, String needle) {

//    if (haystack.equals(needle)) {
//      return 0;
//    }
//    if (needle.equals(""))
//      return 0;
    if (needle.isEmpty()) {
      return 0;
    }
//    char[] c = haystack.toCharArray();
//    char[] n = needle.toCharArray();
//
//    for (int i = 0; i < c.length - n.length + 1; i++) {
//      int j = 0;
//      while (true) {
//        if (c[i + j] == n[j]) {
//          if (j == n.length - 1)
//            return i;
//          j++;
//        } else
//          break;
//      }
//    }
    for (int i = 0; i <= haystack.length() - needle.length(); i++) {
      int j = 0;
      while (true) {
        if (haystack.charAt(i + j) == needle.charAt(j)) {
          if (j == needle.length() - 1)
            return i;
          j++;
        } else
          break;
      }
    }


    return -1;

  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(new NeedleInHaystack().strStr("mississippi", "pi"));

  }

}
