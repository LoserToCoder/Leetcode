package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class MaxSubArray {


    /**
     * 描述
     * 给一个数组nums和目标值k，找到数组中最长的子数组，使其中的元素和为k。如果没有，则返回0。
     * @param nums
     * @param k
     * @return
     */
    public int maxSubArrayLen(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum =0;
        int maxLen =0;
        for(int i=0;i<nums.length;i++){

            sum += nums[i];
            if(map.containsKey(sum-k)){
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }else{
                map.put(sum, i);
            }

        }
        return maxLen;
    }
}
