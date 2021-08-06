package com.leetcode.doublespoints;

import java.util.Arrays;

public class ValidTriangleNumber {

    /**
     *
     给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。

     示例 1:
     输入: [2,2,3,4]
     输出: 3

     解释:
     有效的组合是:
     2,3,4 (使用第一个 2)
     2,3,4 (使用第二个 2)
     2,2,3
     注意:

     数组长度不超过1000。
     数组里整数的范围为 [0, 1000]。
     * @param nums
     * @return
     */
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ret = 0;

        // [left, right] 为第三条边的合法位置
        int left, right;

        for (int i = 0; i < n; ++i) {
            right = i + 2;
            for (int j = i + 1; j < n; ++j) {
                left = j + 1;
                while(right < n && nums[right] < nums[i] + nums[j]) right++;
                ret += Math.max(right - left, 0);
            }
        }
        return ret;
    }
}
