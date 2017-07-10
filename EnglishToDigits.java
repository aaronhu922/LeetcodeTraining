/**
 * 
 */
package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aahu
 *Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.

Note:
Input contains only lowercase English letters.
Input is guaranteed to be valid and can be transformed to its original digits. That means invalid inputs such as "abc" or "zerone" are not permitted.
Input length is less than 50,000.
Example 1:
Input: "owoztneoer"

Output: "012"
Example 2:
Input: "fviefuro"

Output: "45"
 */
public class EnglishToDigits {
  
  public String originalDigits(String s) {
    if(s==null) return null;
    int[] index = new int[26];
    for (int i = 0; i < s.length(); i++) {
      index[s.charAt(i)-'a']++;
    }
    List<Integer> list0 = new ArrayList<>();
    while(index['z'-'a']>0){
      list0.add(0);
      index['z'-'a']--;
      index['e'-'a']--;
      index['r'-'a']--;
      index['o'-'a']--;
    }
    List<Integer> list8 = new ArrayList<>();

    while(index['g'-'a']>0){
      list8.add(8);
      index['g'-'a']--;
      index['e'-'a']--;
      index['i'-'a']--;
      index['h'-'a']--;
      index['t'-'a']--;
    }
    List<Integer> list4 = new ArrayList<>();
    while(index['u'-'a']>0){
      list4.add(4);
      index['u'-'a']--;
      index['f'-'a']--;
      index['o'-'a']--;
      index['r'-'a']--;
    }
    
    List<Integer> list2 = new ArrayList<>();

    while(index['w'-'a']>0){
      list2.add(2);
      index['w'-'a']--;
      index['t'-'a']--;
      index['o'-'a']--;
    }
    List<Integer> list6 = new ArrayList<>();
    while(index['x'-'a']>0){
      list6.add(6);
      index['x'-'a']--;
      index['s'-'a']--;
      index['i'-'a']--;
    }
    
    List<Integer> list3 = new ArrayList<>();

    while(index['t'-'a']>0){
      list3.add(3);
      index['t'-'a']--;
      index['h'-'a']--;
      index['r'-'a']--;
      index['e'-'a']--;
      index['e'-'a']--;
    }
    
    List<Integer> list7 = new ArrayList<>();

    while(index['s'-'a']>0){
      list7.add(7);
      index['v'-'a']--;
      index['s'-'a']--;
      index['e'-'a']--;
      index['e'-'a']--;
      index['n'-'a']--;
    }
    List<Integer> list1 = new ArrayList<>();

    while(index['o'-'a']>0){
      list1.add(1);
      index['o'-'a']--;
      index['n'-'a']--;
      index['e'-'a']--;
    }
    
    List<Integer> list5 = new ArrayList<>();

    while(index['f'-'a']>0){
      list5.add(5);
      index['f'-'a']--;
      index['i'-'a']--;
      index['v'-'a']--;
      index['e'-'a']--;
    }
    List<Integer> list9 = new ArrayList<>();

    while(index['i'-'a']>0){
      list9.add(9);
      index['n'-'a']--;
      index['i'-'a']--;
      index['n'-'a']--;
      index['e'-'a']--;
    }
    
    StringBuffer sb = new StringBuffer();
    for (Integer integer : list0) {
      sb.append(integer);
    }
    for (Integer integer : list1) {
      sb.append(integer);
    }
    for (Integer integer : list2) {
      sb.append(integer);
    }
    for (Integer integer : list3) {
      sb.append(integer);
    }
    for (Integer integer : list4) {
      sb.append(integer);
    }
    for (Integer integer : list5) {
      sb.append(integer);
    }
    for (Integer integer : list6) {
      sb.append(integer);
    }
    for (Integer integer : list7) {
      sb.append(integer);
    }
    for (Integer integer : list8) {
      sb.append(integer);
    }
    for (Integer integer : list9) {
      sb.append(integer);
    }
    
    return sb.toString();
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    int[] num={1,1,};

for (int i = 0; i < 5; i++) {
  System.out.println(i);
}
for (int i = 0; i < 5; ++i) {
  System.out.println(i);
}
  }

}
