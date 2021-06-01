/**
 * 
 */
package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aahu
 *Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.


Example 1
Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]


Example 2
Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]
 */
public class DiffWaysAddParentheses {
  
  public List<Integer> diffWaysToCompute(String input) {
    List<Integer> result =new ArrayList<Integer>();
    for (int i = 0; i < input.length(); i++) {
      if(input.charAt(i)=='*'||input.charAt(i)=='+'||input.charAt(i)=='-'){
        String part1 = input.substring(0,i);
        String part2 = input.substring(i+1);
        
        List<Integer> part1Ret=diffWaysToCompute(part1);
        List<Integer> part2Ret=diffWaysToCompute(part2);
        for (Integer p1 : part1Ret) {
          for (Integer p2 : part2Ret) {
            int c = 0;
            switch (input.charAt(i)) {
                case '+': c = p1+p2;
                    break;
                case '-': c = p1-p2;
                    break;
                case '*': c = p1*p2;
                    break;
            }
            result.add(c);
          }
        }

      }
      
    }
    if (result.size()==0) {
      result.add(Integer.parseInt(input));
    }

    return result;
  }
  
  private List<Integer> computer(List<Integer> nums, List<Character> ops) {
    List<Integer> result = new ArrayList<Integer>();
    if (nums.size()==2) {
      int value = math(nums.get(0),nums.get(1),ops.get(0));
      result.add(value);
    }
    if (nums.size()==3) {
      List<Integer> tmp1 = computer(nums.subList(0, 1), ops.subList(0, 0));
      List<Integer> tmp2 = computer(nums.subList(1, 2), ops.subList(1, 1));      
      result.add(math(tmp1.get(0),nums.get(2),ops.get(1)));
      result.add(math(nums.get(0),tmp2.get(0),ops.get(0)));
    }
    
    for (int i = 1; i < nums.size()-1; i++) {
      List<Integer> tmp = computer(nums.subList(i, nums.size()), ops.subList(0, i-1));
      
    }
    
    
    return null;
  }

  private int math(int int1, int int2, char char1) {
    int value = 0;
    switch (char1) {
    case '*':
      value=Math.multiplyExact(int1, int2);
      break;
    case '+':
      value=Math.addExact(int1, int2);
      break;
    case '-':
      value=Math.subtractExact(int1, int2);
      break;
    default:
      break;
    }
     return value;
  }

  public static void main(String[] args) {
new DiffWaysAddParentheses().diffWaysToCompute("2+1-2*3");
  }

}
