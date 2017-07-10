/**
 * 
 */
package com.leetcode;

/**
 * @author aahu Given a non negative integer number num. For every numbers i in
 *         the range 0 ¡Ü i ¡Ü num calculate the number of 1's in their binary
 *         representation and return them as an array.
 * 
 *         Example: For num = 5 you should return [0,1,1,2,1,2].
 * 
 *         Follow up:
 * 
 *         It is very easy to come up with a solution with run time
 *         O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly
 *         in a single pass? Space complexity should be O(n). Can you do it like
 *         a boss? Do it without using any builtin function like
 *         __builtin_popcount in c++ or in any other language.
 *
 */
public class CountBitsOfInt {

  public int[] countBits(int num) {
    int[] bitsCount = new int[num + 1];

    bitsCount[0] = 0;
    if (num >= 1)
      bitsCount[1] = 1;

    for (int i = 2; i <= num; i++) {
      int tmp = getMaxPowOf2(i);
      int index = i%tmp;
       bitsCount[i]=bitsCount[index]+1;
    }

    return bitsCount;
  }

  private int getMaxPowOf2(int i) {
    int j = 0;
    while (i != 0) {
      i = i >>> 1;
      i = i & Integer.MAX_VALUE;
      j++;
    }
    return (int) Math.pow(2, j - 1);
  }

  public int hammingWeight(int n) {
   
    int num = 0;

    for (int i = 0; i < 32; i++) {
        if ((n & 1) != 0)
        num += 1;
       n=n>>>1;
    }
    return num;
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] bitnum = new CountBitsOfInt().countBits(16);
    for (int i = 0; i < bitnum.length; i++) {
      System.out.println(bitnum[i]);
    }

  }

}
