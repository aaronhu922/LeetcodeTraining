
package com.leetcode;

/**
 * @author aahu
 *The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ¡Ü x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ¡ü   ¡ü

The above arrows point to positions where the corresponding bits are different.
 */
public class HammingDistance {
  public int hammingDistance(int x, int y) {
    int left=-1, right=-1;
    for(int i=0;i<31;i++){
        if((x>>i&1)!=(y>>i&1)){
            left=i;
            break;
        }
    }
    for(int i=left+1;i<31;i++){
        if((x>>i&1)!=(y>>i&1)){
            right=i;                
        }
    }
    if(left==-1)return 0;
    return right>left?(right-left):1;
}

  public int hammingDistance1(int x, int y) {
    int ret = 0;
    for (int i = 0; i < 31; i++) {
      if ((x >> i & 1) != (y >> i & 1)) {
        ret++;
      }
    }

    return ret;
  }
  
  
}
