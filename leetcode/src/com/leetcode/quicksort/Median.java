package com.leetcode.quicksort;

public class Median {

    /**
     * 描述
     * 给定一个未排序的整数数组，找到其中位数。
     *
     * 中位数是排序后数组的中间值，如果数组的个数是偶数个，则返回排序后数组的第N/2个数。
     *
     * 数组大小不超过10000
     *
     * 样例
     * 样例 1:
     *
     * 输入：[4, 5, 1, 2, 3]
     * 输出：3
     * 解释：
     * 经过排序，得到数组[1,2,3,4,5]，中间数字为3
     * 样例 2:
     *
     * 输入：[7, 9, 4, 5]
     * 输出：5
     * 解释：
     * 经过排序，得到数组[4,5,7,9]，第二个(4/2)数字为5
     * https://www.lintcode.com/problem/80/
     */
    public int median(int[] nums) {
        int partition = Partition.partition(nums, 0, nums.length - 1, (nums.length + 1) / 2 - 1);
        return nums[partition];
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 1, 2, 3};
        Median median = new Median();
        System.out.println(median.median(nums));
    }

}
