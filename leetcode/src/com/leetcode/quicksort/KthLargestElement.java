package com.leetcode.quicksort;

public class KthLargestElement {

    /**
     * 在数组中找到第 k 大的元素。
     * 你可以交换数组中的元素的位置。
     * 样例 1：
     *
     * 输入：
     *
     * k = 1
     * nums = [1,3,4,2]
     * 输出：
     *
     * 4
     * 解释：
     *
     * 第一大的元素是4。
     *
     * 样例 2：
     *
     * 输入：
     *
     * k = 3
     * nums = [9,3,2,4,8]
     * 输出：
     *
     * 4
     * 解释：
     *
     * 第三大的元素是4。
     *
     * 挑战
     * 要求时间复杂度为O(n)，空间复杂度为O(1)。
     * https://www.lintcode.com/problem/5/
     */
    public int kthLargestElement(int k, int[] nums) {
        int pos = Partition.partition(nums, 0, nums.length - 1, nums.length - k);
        return nums[pos];
    }
}
