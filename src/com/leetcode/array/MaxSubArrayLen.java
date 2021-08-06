package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class MaxSubArrayLen {


    /**
     * 和等于 k 的最长子数组长度
     * 给定一个数组 nums 和一个目标值 k，找到和等于 k 的最长连续子数组长度。
     * 如果不存在任意一个符合要求的子数组，则返回 0。
     *
     *
     *
     * 示例 1:
     *
     * 输入: nums = [1,-1,5,-2,3], k = 3
     * 输出: 4
     * 解释: 子数组 [1, -1, 5, -2] 和等于 3，且长度最长。
     *
     * 示例 2:
     * 输入: nums = [-2,-1,2,1], k = 1
     *
     * 输出: 2
     * 解释: 子数组 [-1, 2] 和等于 1，且长度最长。
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 2 * 105
     * -104 <= nums[i] <= 104
     * -109 <= k <= 109
     *
     *
     * 进阶:
     * 你能使时间复杂度在 O(n) 内完成此题吗?
     * @param nums
     * @param k
     * @return
     */
    public int maxSubArrayLen(int[] nums, int k) {
        int n = nums.length;
        // 哈希表，映射前缀和值到第一次出现的下标位置
        Map<Integer, Integer> preSumMap= new HashMap<>();
        int maxLen = 0;
        // 前缀和
        int preSum = 0;
        // 0 出现的位置在 -1 位置处
        preSumMap.put(0, -1);
        for (int i = 0; i < n; ++i) {
            // 累加前缀和
            preSum += nums[i];
            // 确保记录的是第一次出现的位置
            if (!preSumMap.containsKey(preSum)) {
                preSumMap.put(preSum, i);
            }
            // 检查一下是否需要更新答案
            if (preSumMap.containsKey(preSum - k)) {
                maxLen = Math.max(maxLen, i - preSumMap.get(preSum - k));
            }
        }
        return maxLen;
    }
}
