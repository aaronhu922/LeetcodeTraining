/**
 * 
 */
package com.leetcode;

/**
 * @author aahu
 *Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
 */
public class Search2DMatrix {

  public boolean searchMatrix(int[][] matrix, int target) {
    if(matrix.length==0)return false;
    int rowMid=-1, colMid=-1;
    int left=0,right=matrix[0].length-1;
    int up=0, down = matrix.length-1;
    
    while(up<=down){
      colMid=(up+down)/2;
      if(matrix[colMid][right]>target&&matrix[colMid][0]<=target) break;
      if(matrix[colMid][right]>target) down=colMid-1;
      else if(matrix[colMid][right]<target) up=colMid+1;
      else if(matrix[colMid][right]==target) return true;
    }
    
    while(left<=right){
      rowMid=(left+right)/2;
      if(matrix[colMid][rowMid]>target) right=rowMid-1;
      else if(matrix[colMid][rowMid]<target) left=rowMid+1;
      else if(matrix[colMid][rowMid]==target) return true;
    }    
    
    return false;
}

  /**
   * @param args
   */
  public static void main(String[] args) {

System.out.println(new Search2DMatrix().searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}}, 10));
  }

}
