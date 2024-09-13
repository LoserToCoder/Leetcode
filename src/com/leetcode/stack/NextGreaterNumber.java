package com.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterNumber {

    /**
     * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
     * <p>
     * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
     * <p>
     * 如果不存在，则输出 -1 。
     * <p>
     * 示例 1:
     * 输入: nums = [1,2,1]
     * 输出: [2,-1,2]
     * 解释: 第一个 1 的下一个更大的数是 2；
     * 数字 2 找不到下一个更大的数；
     * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
     * <p>
     * 示例 2:
     * 输入: nums = [1,2,3,4,3]
     * 输出: [2,3,4,-1,4]
     * <p>
     * <p>
     * 提示:
     *   1   <= nums.length <= 104
     *  -109 <= nums[i]     <= 109
     *
     *  两种解法:
     *  (从左到右👉)
     *  (从右往左👈)
     */

    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int [] ret = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        Arrays.fill(ret,-1);

        for(int i=0; i< n*2;i++) {
            while (!stack.isEmpty() && nums[stack.peek()]< nums[i%n]) {
                ret[stack.pop()] = nums[i%n];
            }
            stack.push(i%n);
        }
        return ret;
    }
}
