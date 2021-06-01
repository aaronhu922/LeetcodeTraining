/**
 * 
 */
package com.leetcode;

/**
 * @author aahu
 *
 */
public class RemoveDuplicateFromSortedArray {

  public int removeDuplicates(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
      if (nums[i] != nums[j]) {
         i++;
         nums[i]=nums[j];
      }   
    }
    return i+1;
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    RemoveDuplicateFromSortedArray r = new RemoveDuplicateFromSortedArray();
    int[] i1 = { 1, 1, 1, 2, 3, 4, 5, 7, 7, 8 };
    int length = r.removeDuplicates(i1);
    System.out.println(length);
    for (int i = 0; i < 7; i++) {
      System.out.print(i1[i]);
    }
  }

}
