/**
 * 
 */
package com.leetcode;

/**
 * @author aahu
 * 
 */
public class TrappingRainWater {

  int trappingRainWater = 0;

  /**
   * @param args
   */
  public static void main(String[] args) {
    int A[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
    TrappingRainWater t = new TrappingRainWater();
    int i = t.trapB(A);
    System.out.println(i);
  }
  public int trapB(int[] A) {
    int i = 0, j = A.length - 1, result = 0, plank = 0;
    while(i <= j){
        plank = plank < Math.min(A[i], A[j]) ? Math.min(A[i], A[j]) : plank;
        result = A[i] >= A[j] ? result + (plank - A[j--]) : result + (plank - A[i++]);
    }
    return result;
}
  
  public int trap(int[] A) {

    if (A.length <= 2) {
      return 0;
    }

    int[] maxMid = max(A);
    System.out.println(maxMid[0] + " " + maxMid[1]);
    int[] ALeft = new int[maxMid[1]]; 
    // TODO:
    for (int i = 0; i < ALeft.length; i++) {
      ALeft[i] = A[i];
    }

    int[] ARight = new int[A.length - maxMid[1] - 1];
    // TODO:
    for (int i = 0; i < ARight.length; i++) {
      ARight[i] = A[maxMid[1] + i + 1];
    }

    trappingRainWater = trapLeft(ALeft) + trapRight(ARight);

    return trappingRainWater;

  }

  public int trapLeft(int[] Left) {
    int i = 0;
    if (Left.length <= 1) {
      return 0;
    }
    if (Left.length == 2 && Left[0] > Left[1]) {
      return Left[0] - Left[1];
    }
    int[] maxLeft = max(Left);
    for (int j = maxLeft[1] + 1; j < Left.length; j++) {
      i += (maxLeft[0] - Left[j]);
    }

    if (maxLeft[1] >= 2) {
      int[] leftLeft = new int[maxLeft[1]];
      for (int j = 0; j < maxLeft[1]; j++) {
        leftLeft[j] = Left[j];
      }
      return i + trapLeft(leftLeft);
    }

    return i;
  }

  public int trapRight(int[] Right) {
    int i = 0;
    if (Right.length <= 1) {
      return 0;
    }
    if (Right.length == 2 && Right[1] > Right[0]) {
      return Right[1] - Right[0];
    }
    int[] maxRight = max(Right);
    for (int j = 0; j < maxRight[1]; j++) {
      i += (maxRight[0] - Right[j]);
    }

    if (Right.length - maxRight[1] >= 2) {
      int[] rithtRight = new int[Right.length - maxRight[1] - 1];
      for (int j = 0; j < rithtRight.length; j++) {
        rithtRight[j] = Right[maxRight[1] + 1 + j];
      }
      return i + trapRight(rithtRight);
    } else {
      return i;
    }

  }

  public int[] max(int[] B) {
    int value = 0, index = 0;
    for (int i = 0; i < B.length; i++) {
      if (B[i] > value) {
        value = B[i];
        index = i;
      }
    }

    return new int[] { value, index };
  }

}
