package com.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaximumSubArray {

    /**
     * 一个数组的 最小乘积定义为这个数组中 最小值乘以数组的 和。
     *
     * 比方说，数组[3,2,5]（最小值是2）的最小乘积为2 * (3+2+5) = 2 * 10 = 20。
     * 给你一个正整数数组nums，请你返回nums任意非空子数组的最小乘积的最大值。
     * 由于答案可能很大，请你返回答案对109 + 7取余的结果。
     *
     * 请注意，最小乘积的最大值考虑的是取余操作 之前的结果。题目保证最小乘积的最大值在
     * 不取余 的情况下可以用 64 位有符号整数保存。
     *
     * 子数组定义为一个数组的 连续部分。
     *
     * 
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3,2]
     * 输出：14
     * 解释：最小乘积的最大值由子数组 [2,3,2] （最小值是 2）得到。
     * 2 * (2+3+2) = 2 * 7 = 14 。
     * 示例 2：
     *
     * 输入：nums = [2,3,3,1,2]
     * 输出：18
     * 解释：最小乘积的最大值由子数组 [3,3] （最小值是 3）得到。
     * 3 * (3+3) = 3 * 6 = 18 。
     * 示例 3：
     *
     * 输入：nums = [3,1,5,6,4,2]
     * 输出：60
     * 解释：最小乘积的最大值由子数组 [5,6,4] （最小值是 4）得到。
     * 4 * (5+6+4) = 4 * 15 = 60 。
     * 
     *
     * 提示：
     *
     * 1 <= nums.length <= 105
     * 1 <= nums[i] <= 10^7
     *
     * 链接：https://leetcode-cn.com/problems/maximum-subarray-min-product
     * @param nums
     * @return
     */
    private long mod =(int)Math.pow(10,9)+7;
    public int maxSumMinProduct(int[] nums) {

        /**
         * 从左往右,维护递增栈,
         * lefts存储左边的边界指针
         * rights存储右边的边界指针
         */
        int n = nums.length;
        int[] lefts = new int[n];
        int[] rights = new int[n];
        Arrays.fill(rights,n-1);
        Deque<Integer> s = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            while (!s.isEmpty() && nums[s.peek()] >= nums[i]) {
                // 这里的 right 是非严格定义的，right[i] 是右侧最近的小于等于 nums[i] 的元素下标
                rights[s.peek()] = i - 1;
                s.pop();
            }
            if (!s.isEmpty()){
                // 这里的 left 是严格定义的，left[i] 是左侧最近的严格小于 nums[i] 的元素下标
                lefts[i] = s.peek() + 1;
            }
            s.push(i);
        }
        //long 类型存储,防止整数溢出

        long[] pres = new long[n+1];
        for(int i=1;i<=n;i++){
            pres[i] = pres[i - 1] + nums[i - 1];
        }
        long maxSum =0;
        for(int i=0;i<n;i++){

            maxSum = Math.max(maxSum, (pres[rights[i] + 1] - pres[lefts[i]]) * nums[i]);
        }

        return (int)(maxSum%mod);

    }

    public static void main(String[] args) {
        new MaximumSubArray().maxSumMinProduct(new int[]{1, 2, 3, 2});
    }

}
