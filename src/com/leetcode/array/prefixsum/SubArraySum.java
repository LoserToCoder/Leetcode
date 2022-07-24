package com.leetcode.array.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {

    /***
     * 给你一个整数数组 nums 和一个整数k ，请你统计并返回 该数组中和为k的连续子数组的个数。
     *
     * 示例 1：
     * 输入：nums = [1,1,1], k = 2
     * 输出：2
     *
     * 示例 2：
     * 输入：nums = [1,2,3], k = 3
     * 输出：2
     *
     * 提示：
     * 1 <= nums.length <= 2 * 104
     * -1000 <= nums[i] <= 1000
     * -10^7 <= k <= 10^7
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/subarray-sum-equals-k
     * @param nums
     * @param k
     * @return
     */
    public int subArraySum(int[] nums, int k) {
        Map<Integer, Integer> preSumMap = new HashMap<>();
        int ans =0;
        int preSum=0;
        preSumMap.put(0,1);
        for(int i=0;i<nums.length;i++){

            preSum +=nums[i];
            if (preSumMap.containsKey(preSum - k)) {
                ans += preSumMap.get(preSum - k);
            }
            preSumMap.put(preSum, preSumMap.getOrDefault(preSum, 0) + 1);
        }
        return ans;
    }

}