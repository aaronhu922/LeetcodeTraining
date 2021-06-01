package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i=0;i<len;i++){
            if(map.containsKey(nums[i]))
                 map.put(nums[i], map.get(nums[i])+1);
            else
                map.put(nums[i], 1);
            if(map.get(nums[i]) > len/2)
                return nums[i];
        }
        return -1;
    }

    public int majorityElementBY(int[] nums) {
        int m = 0, x = 0;
        for (int i:nums){
            if (x==0) {
                m = i;
                x = 1;
            }
            else if (m == i)
                x++;
            else
                x--;
        }
        return m;
    }

//    Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
    public List<Integer> majorityElement3n(int[] nums) {
        List<Integer> list = new ArrayList<>();

        return list;
    }
}
