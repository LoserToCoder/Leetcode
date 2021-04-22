package com.leetcode.dp;

public class WeightCapacity {


    /**
     * 1915 · 举重
     * 题目题解笔记讨论排名
     * 描述
     * 奥利第一次来到健身房，她正在计算她能举起的最大重量。杠铃所能承受的最大重量为maxCapacity，健身房里有n个杠铃片，
     * 第 i 个杠铃片的重量为 weights[i]。奥利现在需要选一些杠铃片加到杠铃上，使得杠铃的重量最大，但是所选的杠铃片重量
     * 总和又不能超过 maxCapacity ，请计算杠铃的最大重量是多少。
     *
     * 比如，给定杠铃片的重量为 weights = [1, 3, 5]， 而杠铃的最大承重为 maxCapacity = 7，那么应该选择重量为 1 和 5 的杠铃片，
     * (1 + 5 = 6)，所以最终的答案是 6。
     *
     *
     * 样例
     * 样例 1
     *
     * 输入：
     * [1,3,5]
     * 7
     * 输出：
     * 6
     * https://www.lintcode.com/problem/lifting-weights/description
     * @param weights
     * @param maxCapacity
     * @return
     */
    public int weightCapacity(int[] weights, int maxCapacity) {
        boolean[] dp = new boolean[maxCapacity + 1];
        dp[0] = true;
        int max = 0;

        for (int i = 0; i < weights.length; i++) {
            for (int k = maxCapacity; k>=weights[i]; k--) {
                if (dp[k -weights[i]]) {
                    dp[k] = true;
                    max = Math.max(max,k);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {

        int[] weights = {1, 5, 16, 11,9};
        WeightCapacity weightCapacity = new WeightCapacity();
        System.out.println(weightCapacity.weightCapacity(weights,24));
    }
}

