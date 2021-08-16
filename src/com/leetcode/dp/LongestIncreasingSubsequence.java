package com.leetcode.dp;

public class LongestIncreasingSubsequence {

    /**
     * 最长递增子序列
     * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     *
     * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
     * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
     *
     *
     * 示例 1：
     *
     * 输入：nums = [10,9,2,5,3,7,101,18]
     * 输出：4
     * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
     * 示例 2：
     *
     * 输入：nums = [0,1,0,3,2,3]
     * 输出：4
     * 示例 3：
     *
     * 输入：nums = [7,7,7,7,7,7,7]
     * 输出：1
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 2500
     * -104 <= nums[i] <= 104
     *
     *
     * 进阶：
     * 你可以设计时间复杂度为 O(n2) 的解决方案吗？
     * 你能将算法的时间复杂度降低到 O(n log(n)) 吗?
     * @param nums
     * @return
     *
     * dp[i] 的值代表 nums 前i个数字的最长子序列长度,
     * 后边只需要给予num[i]的基础之上累计即可
     * 比num[i]大,说明比num[i]前面的元素也大
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxAns = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxAns = Math.max(maxAns, dp[i]);
        }
        return maxAns;
    }


    /**
     *  关键之处:需要维护一个数组 tails tails[i] 代表子序列长度为i+1的最小尾数
     *
     * 尾数越小,越往后的话,这个子序列递增达到最大的几率就大
     * @param nums
     * @return
     */
    public int lengthOfLISOptimizer(int[] nums) {

        int n = nums.length;
        int[] tails = new int[n];

        int ans = 0;//保存当前最大子序列长度

        for (int num : nums) {

            int i=0, j = ans;
            while (i < j) {

                int m = i+((j-i)>>1);

                if(tails[m]<num){
                    i = m+1;
                }else{
                    j = m;
                }

            }
            tails[i] = num;

            //while 循环里出来,i==j,如果此时j==ans的话
            if(j==ans) ans++;
        }

        return ans;

    }

}
