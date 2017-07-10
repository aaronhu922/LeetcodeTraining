/**
 * 
 */
package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author aahu Given an integer n, generate a square matrix filled with
 *         elements from 1 to n2 in spiral order.
 * 
 *         For example, Given n = 3,
 * 
 *         You should return the following matrix: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [
 *         7, 6, 5 ] ]
 */
public class SpiralMatrix {

  public int[][] generateMatrix(int n) {
    int[][] matrix = new int[n][n];
    int loop = 0;
    int val = 1;
    while (n > 0) {
      for (int i = 1; i <= n; i++) {
        matrix[loop][loop + i - 1] = val++;
      }
      for (int i = 1; i <= n - 1; i++) {
        matrix[i + loop][n + loop - 1] = val++;
      }
      for (int i = 1; i <= n - 1; i++) {
        matrix[n + loop - 1][n + loop - 1 - i] = val++;
      }
      for (int i = 1; i <= n - 2; i++) {
        matrix[n - 2 + loop - i + 1][loop] = val++;
      }
      n = n - 2;
      loop++;

    }
    return matrix;
  }

  public int findMaximumXOR(int[] nums) {
    if (nums.length < 2)
      return 0;
    int max = -1;
    for (int i = 0; i < nums.length; i++) {
      if (max < nums[i]) {
        max = nums[i];
      }
    }
    int maxXOR = 0;

    int maxBit = 0;
    for (int i = 30; i >= 0; i--) {
      if ((max & 1<<i)==1) {
        maxBit = i;
        break;
      }      
    }
    
    int mask=0;
    Set<Integer> maskSet = new HashSet<Integer>();

    for (int j = maxBit; j >= 0; j--) {
      mask=mask|(1<<j);
      for (int i = 0; i < nums.length; i++) {
        maskSet.add(nums[i]&mask);
      }
    }
    return maxXOR;
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    new SpiralMatrix().findMaximumXOR(new int[]{8,10,2});
  }

}
