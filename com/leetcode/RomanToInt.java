package com.leetcode;

import java.util.HashMap;

/*
 * Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999. * 
 * 
 * */


public class RomanToInt {
  

  public static void main(String[] args) {
    System.out.println(new RomanToInt().romanToInt("DCXXI"));
  }
  
  HashMap<String, Integer> romanIntMapping = null;

  
  public RomanToInt() {
     if (romanIntMapping==null) {
       romanIntMapping = new HashMap<>();
    }
     romanIntMapping.put("M", 1000);
     romanIntMapping.put("CM", 900);
     romanIntMapping.put("D", 500);
     romanIntMapping.put("CD", 400);
     romanIntMapping.put("C", 100);
     romanIntMapping.put("XC", 90);
     romanIntMapping.put("L", 50);
     romanIntMapping.put("XL", 40);
     romanIntMapping.put("X", 10);
     romanIntMapping.put("IX", 9);
     romanIntMapping.put("V", 5);
     romanIntMapping.put("IV", 4);
     romanIntMapping.put("I", 1);
  }


  public int romanToInt(String s) {
    int num = 0;
    int i=0;
    for ( i = 0; i < s.length()-1; i++) {
      int p = romanIntMapping.get(s.substring(i, i+1));
      int q = romanIntMapping.get(s.substring(i+1, i+2));
      if (p>=q) {
        num+=p;
      } else {
        num+=romanIntMapping.get(s.substring(i, i+2));
        i++;
      }
    }
    if (s.length()==1 || i==s.length()-1) {
      num+=romanIntMapping.get(s.substring(i, i+1));
    }
    

    return num;
  }
  
  public int romanToInt2(String s) {
    int nums[]=new int[s.length()];
    for(int i=0;i<s.length();i++){
        switch (s.charAt(i)){
            case 'M':
                nums[i]=1000;
                break;
            case 'D':
                nums[i]=500;
                break;
            case 'C':
                nums[i]=100;
                break;
            case 'L':
                nums[i]=50;
                break;
            case 'X' :
                nums[i]=10;
                break;
            case 'V':
                nums[i]=5;
                break;
            case 'I':
                nums[i]=1;
                break;
        }
    }
    int sum=0;
    for(int i=0;i<nums.length-1;i++){
        if(nums[i]<nums[i+1])
            sum-=nums[i];
        else
            sum+=nums[i];
    }
    return sum+nums[nums.length-1];
}

}
