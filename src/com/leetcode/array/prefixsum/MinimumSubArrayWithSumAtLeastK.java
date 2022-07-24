package com.leetcode.array.prefixsum;

public class MinimumSubArrayWithSumAtLeastK {


    /**
     * 给定一个含有n个正整数的数组和一个正整数 target 。找出该数组中满足其和 ≥ target 的长度最小的
     * 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
     *
     *
     * 示例 1：
     * 输入：k = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组[4,3]是该条件下的长度最小的子数组。
     *
     *
     * 示例 2：
     * 输入：k = 4, nums = [1,4,4]
     * 输出：1
     *
     * 示例 3：
     * 输入：k = 11, nums = [1,1,1,1,1,1,1,1]
     * 输出：0
     *
     * 提示：
     * 1 <= k <= 10^9
     * 1 <= nums.length <= 10^5
     * 1 <= nums[i] <= 10^5
     *
     * 进阶：
     * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
     *
     * 链接：https://leetcode.cn/problems/minimum-size-subarray-sum
     * @param k
     * @param nums
     * @return
     */
    public int minSubArrayLen(int k, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= k) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
