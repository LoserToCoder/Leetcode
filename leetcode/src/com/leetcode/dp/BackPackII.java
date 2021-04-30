package com.leetcode.dp;

public class BackPackII {

    /**
     * 有 n 个物品和一个大小为 m 的背包. 给定数组 A 表示每个物品的大小和数组 V 表示每个物品的价值.
     *
     * 问最多能装入背包的总价值是多大?
     * 提示：
     *  1.A[i], V[i], n, m 均为整数
     *  2.你不能将物品进行切分
     *  3.你所挑选的要装入背包的物品的总大小不能超过 m
     *  4.每个物品只能取一次
     * 样例 1:
     *
     * 输入: m = 10, A = [2, 3, 5, 7], V = [1, 5, 2, 4]
     * 输出: 9
     * 解释: 装入 A[1] 和 A[3] 可以得到最大价值, V[1] + V[3] = 9
     * 样例 2:
     *
     * 输入: m = 10, A = [2, 3, 8], V = [2, 5, 8]
     * 输出: 10
     * 解释: 装入 A[0] 和 A[2] 可以得到最大价值, V[0] + V[2] = 10
     */
    public int backPackII(int capacity, int[] A, int[] V) {
        // write your code here
        int m = A.length,n=V.length;
        int[] dp = new int[capacity + 1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

            }
        }
        return dp[capacity];
    }

}
