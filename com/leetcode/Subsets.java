/**
 * 
 */
package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author aahu
 *Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
public class Subsets {
  
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<>();
    int length = nums.length;
    if(length==0) {
      List<Integer> items = new ArrayList<>();
      subsets.add(items);
      return subsets;
      }
  
    int[] sNums = new int[length-1];
    for (int i = 0; i < sNums.length; i++) {
      sNums[i]=nums[i];
    }   
    
    List<List<Integer>> sSubsets = subsets(sNums);
    for (int i = 0; i < sSubsets.size(); i++) {
      List<Integer> tmp = sSubsets.get(i);
      subsets.add(tmp);
      List<Integer> nItems = new ArrayList<>();    
//      System.arraycopy(tmp, 0, nItems, 0, tmp.size());
      nItems.addAll(tmp);
      nItems.add(nums[length - 1]);
      subsets.add(nItems);
    }
    
    return subsets;
}

  
  public List<List<Integer>> subsetsNoRecursive(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<>();
    subsets.add(new ArrayList<Integer>());
    
    for (int i = 0; i < nums.length; i++) {
      List<List<Integer>> tmp = new ArrayList<>();
      for (List<Integer> list : subsets) {
        List<Integer> nItems = new ArrayList<>(list);   
        nItems.add(nums[i]);
        tmp.add(nItems);
      }
      subsets.addAll(tmp);
    }
 
    
    return subsets;
}
  
  /** Given two binary strings, return their sum (also a binary string).

      For example,
      a = "11"
      b = "1"
      Return "100".
  */
  public String addBinary(String a, String b) {
    
    
    return "";
  }
  
  /**
   * @param args
   */
  public static void main(String[] args) {

new Subsets().subsets(new int[]{1,2,3});
System.out.println(Integer.decode("0x11"));
System.out.println(Integer.toBinaryString(3));
  }

}
