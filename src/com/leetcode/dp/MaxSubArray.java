package com.leetcode.dp;

public class MaxSubArray {

    /**
     * 给定一个整数数组，找出总和最大的连续数列，并返回总和。
     *
     * 示例：
     *
     * 输入： [-2,1,-3,4,-1,2,1,-5,4]
     * 输出： 6
     * 解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
     * 进阶：
     *
     * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
     */
    public int maxSubArray(int[] nums) {

        int [] dp = new int[nums.length+1];
        int maxSum = nums[0];
        for(int i =0 ;i<  nums.length;i++) {

            if(dp[i]<=0) {
                dp[i+1] = nums[i];
            } else {
                dp[i+1] = dp[i]+nums[i];
            }
            maxSum = Math.max(maxSum,dp[i+1]);
        }
        return maxSum;
    }
}
