/**
 * 
 */
package com.leetcode;

/**
 * @author aahu
 *Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
 */
public class SearchForARange {

  public int[] searchRange(int[] nums, int target) {
    
    int tmpl = findFirst(nums, target);
    int tmpR = findLast(nums, target);

    int l=0,r=nums.length-1;
    int index = binarySearch(nums,l,r,target);
    l=r=index;
    int left=index;
    if(index==-1)return new int[]{-1,-1};
    else {
       while(++index<nums.length&&nums[index]==target)
         r++;
       while(--l>=0&&nums[l]==target)
         left--;
    }
    
    return new int[]{left,r};
  }
  
  
  private int binarySearch(int[] nums, int l, int r,int target) {
   
    while(l<=r){
    int mid = (l+r)/2;
    if(nums[mid]==target) return mid;
    else if(nums[mid]<target)l=mid+1;
    else r=mid-1;
    }
    return -1;
  }

  private int findFirst(int[] nums, int target){
    int idx = -1;
    int start = 0;
    int end = nums.length - 1;
    while(start <= end){
        int mid = (start + end) / 2;
        if(nums[mid] >= target){
            end = mid - 1;
        }else{
            start = mid + 1;
        }
        if(nums[mid] == target) idx = mid;
    }
    return idx;
}

private int findLast(int[] nums, int target){
    int idx = -1;
    int start = 0;
    int end = nums.length - 1;
    while(start <= end){
        int mid = (start + end) / 2;
        if(nums[mid] <= target){
            start = mid + 1;
        }else{
            end = mid - 1;
        }
        if(nums[mid] == target) idx = mid;
    }
    return idx;
}

  /**
   * @param args
   */
  public static void main(String[] args) {

new SearchForARange().searchRange(new int[]{5,7,7,8,8,10}, 8);
  }

}
