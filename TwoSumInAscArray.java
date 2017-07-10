/**
 * 
 */
package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author aahu
 *
 */
public class TwoSumInAscArray {

  public int[] twoSum(int[] numbers, int target) {

    if (numbers.length < 2) {
      return numbers;
    }
    Arrays.sort(numbers);
    int i = 0, j = numbers.length - 1;
    while (i < j) {

      if (numbers[i] + numbers[j] == target) {
        return new int[] { i , j };
      } else if (numbers[i] + numbers[j] > target) {
        j--;
      } else if (numbers[i] + numbers[j] < target)
        i++;

    }
    int[] index = { i, j };
    return index;

  }

  public int[] twoSumWithBinarySearch(int[] numbers, int target) {
    for (int i = 0; i < numbers.length; i++) {
      int j = bSearch(numbers, target - numbers[i], i + 1);
      if (j != -1) {
        return new int[] { i, j };
      }
    }

    throw new IllegalArgumentException("No two sum solution");
  }

  private int bSearch(int[] numbers, int key, int start) {
    int L = start;
    int R = numbers.length - 1;
    while (L <= R) {
      int mid = (L + R) / 2;
      if (numbers[mid] == key) {
        return mid;
      } else {
        if (numbers[mid] < key) {
          L = mid + 1;
        } else {
          R = mid - 1;
        }
      }
    }

    return -1;
  }

  public int[] twoSumInRamdomArray(int[] numbers, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int k = 0; k < numbers.length; k++) {
      int x = numbers[k];
      if (map.containsKey(target - x)) {
        return new int[] { map.get(target - x) + 1, k + 1 };
      }
      map.put(x, k);
    }
    throw new IllegalArgumentException("No two sum solution");
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    int[] numbers = { 1, 2, 3, 4, 4, 9, 56, 90 };
    int[] index = new TwoSumInAscArray().twoSum(numbers, 8);
    for (int i = 0; i < index.length; i++) {
      System.out.println(index[i]);
    }
    int[] index1 = new TwoSumInAscArray().twoSumWithBinarySearch(numbers, 8);
    for (int i = 0; i < index1.length; i++) {
      System.out.println(index1[i]);
    }
  }

}
