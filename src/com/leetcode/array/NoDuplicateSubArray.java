package com.leetcode.array;

import java.util.HashMap;

public class NoDuplicateSubArray {


    /**
     * 描述
     * 给定一个数组arr，返回arr的最长无重复元素子数组的长度，无重复指的是所有数字都不相同。
     * 子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组
     * 示例1
     * 输入：
     * [2,3,4,5]
     * 复制
     * 返回值：
     * 4
     * 复制
     * 说明：
     * [2,3,4,5]是最长子数组
     *
     * 示例2
     * 输入：
     * [2,2,3,4,3]
     * 复制
     * 返回值：
     * 3
     * 说明：
     * [2,3,4]是最长子数组
     *
     * 示例3
     * 输入：
     * [9]
     * 复制
     * 返回值：
     * 1
     *
     * 示例4
     * 输入：
     * [1,2,3,1,2,3,2,2]
     * 复制
     * 返回值：
     * 3
     * 说明：
     * 最长子数组为[1,2,3]
     *
     * 示例5
     * 输入：
     * [2,2,3,4,8,99,3]
     * 返回值：
     * 5
     * 说明：
     * 最长子数组为[2,3,4,8,99]
     * @param arr
     * @return
     */
    public int maxLength (int[] arr) {
        // write code here
        if (arr.length == 0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < arr.length; ++i) {
            if (map.containsKey(arr[i])) {
                j = Math.max(j, map.get(arr[i]) + 1);
            }
            map.put(arr[i], i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        int [] arrays = {3,3,2,1,3,3,3,1};
        System.out.println(new NoDuplicateSubArray().maxLength(arrays));
    }

}
