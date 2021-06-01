package com.leetcode;

import java.util.Arrays;

public class MidOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int total_len = len1 + len2;
        int[] nums = new int[total_len];
        int i = 0, j = 0, x = 0;
        while (i < len1 && j < len2) {
            if (nums1[i] <= nums2[j]) {
                nums[x] = nums1[i];
                i++;
            } else {
                nums[x] = nums2[j];
                j++;
            }
            x++;
        }
        if (i >= len1) {
            while (j < len2) {
                nums[x] = nums2[j];
                x++;
                j++;
            }
        } else {
            while (i < len1) {
                nums[x] = nums1[i];
                x++;
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
        if ((total_len) % 2 == 0)
            return (double) (nums[total_len / 2 - 1] + nums[total_len / 2]) / 2;
        else
            return (double) nums[total_len / 2];
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,2},
                new int[]{3,4}));
    }

}
