package com.leetcode;

//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nu
//ms2 的元素。
//
//
//
// 示例 1：
//
//
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
//
//
// 示例 2：
//
//
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
//
//
//
//
// 提示：
//
//
// nums1.length == m + n
// nums2.length == n
// 0 <= m, n <= 200
// 1 <= m + n <= 200
// -109 <= nums1[i], nums2[i] <= 109
//
// Related Topics 数组 双指针
// 👍 968 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class MergeTwoSortedArrays88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //从后往前比较数组1和2元素大小，谁大从后往前入位，最后如果数组2还剩下，说明数组1的元素已经往后移动结束
        //剩下的都是数组2的有序元素，直接copy到数组1对应的位置。
        int q = m + n - 1; //nums1's length
        int i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] <= nums2[j]) {
                nums1[q] = nums2[j];
                j--;
            } else {
                nums1[q] = nums1[i];
                i--;
            }
            q--;
        }
        while (j >= 0) {
            nums1[j] = nums2[j];
            j--;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)


