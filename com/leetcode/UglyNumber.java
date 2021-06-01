/**
 * 
 */
package com.leetcode;

/**
 * @author aahu
 *Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

Note that 1 is typically treated as an ugly number.
 */
public class UglyNumber {
  
  public boolean isUgly(int num) {

    if (num == 0)
      return false;
    if (num == 1)
      return true;

    while (num != 2 && num != 3 && num != 5) {
      if (num % 5 == 0) {
        num = num / 5;
        continue;
      }
      if (num % 3 == 0) {
        num = num / 3;
        continue;
      }
      if (num % 2 == 0) {
        num = num / 2;
        continue;
      }
      return false;
    }

    return true;
  }

  /**
   * @param args
   */
  public static void main(String[] args) {

System.out.println(new UglyNumber().isUgly(1));
  }

}
