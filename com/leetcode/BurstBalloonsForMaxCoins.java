/**
 * 
 */
package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author aahu
 *Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note: 
(1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
(2) 0 ¡Ü n ¡Ü 500, 0 ¡Ü nums[i] ¡Ü 100

Example:

Given [3, 1, 5, 8]

Return 167

    nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
   coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */
public class BurstBalloonsForMaxCoins {
  
  Map map = new HashMap<Integer,Integer>();
  
  public int maxCoins(int[] nums) {
    if (nums.length==1) {
      return nums[0];
    }
    if (nums.length==2) {
      return nums[0]*nums[1]+Math.max(nums[0], nums[1]);
    }
    if (nums.length==3) {
      return nums[0]*nums[1]*nums[2]+maxCoins(new int[]{nums[0],nums[2]});
    }
    for (int i = 1; i < nums.length-1; i++) {
      map.put(i, nums[i]);
    }
    int value;
    while (getMin(nums, 1, nums.length-2)!=-1) {
      int index = getMin(nums, 1, nums.length-2);
//       int tmp= map.get(index)*
    }
    
    return 0;
  }
  
  public int getMin(int[] nums, int low, int high){
     int min = 101;
     int index=low;
     for (int i = low; i < high; i++) {
      if (nums[i]<min) {
        min=nums[i];
        index=i;
      }
    }
     if (min!=101) {
       nums[index]=101;
       return index;  
    }
   return -1;
     
  }
  
  private int[] theArray;
  
  public void quickSort(int[] nums) {
    theArray=nums;
    recQuickSort(1, nums.length - 2);
  }

  public void recQuickSort(int left, int right) {
    if (right - left <= 0) {
      return;
    } else {
      long pivot = theArray[right];
      int partition = partitionIt(left, right, pivot);
      recQuickSort(left, partition - 1);
      recQuickSort(partition + 1, right);
    }
  }

  
  public int partitionIt(int left, int right, long pivot) {
    int leftPtr = left - 1; // left (after ++)
    int rightPtr = right; // right-1 (after --)
    while (true) { // find bigger item
      while (theArray[++leftPtr] < pivot)
        ; // (nop)
      // find smaller item
      while (rightPtr > 0 && theArray[--rightPtr] > pivot)
        ; // (nop)
      if (leftPtr >= rightPtr) // if pointers cross,
        break; // partition done
      else // not crossed, so
        swap(leftPtr, rightPtr); // swap elements
    } // end while(true)
    swap(leftPtr, right); // restore pivot
    return leftPtr; // return pivot location
  }
  
  public void swap(int index1, int index2) {
    int temp = theArray[index1];
    theArray[index1] = theArray[index2];
    theArray[index2] = temp;
  }
  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
