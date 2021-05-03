package com.leetcode.dp;

public class BackPack {

    /**
     *在n个物品中挑选若干物品装入背包，最多能装多满？
     * 假设背包的大小为m，每个物品的大小为weights[i]
     *
     * 你不可以将物品进行切割。
     *
     * 样例
     * 样例 1:
     * 	输入:  [3,4,8,5], backpack size=10
     * 	输出:  9
     *
     * 样例 2:
     * 	输入:  [2,3,5,7], backpack size=12
     * 	输出:  12
     * @param m
     * @param weights
     * @return
     */

    public int backPack(int m, int[] weights) {
        int max = 0;
        boolean[] dp = new boolean[m + 1];
        dp[0] =true;
        /**每个物品只能使用一次*/
        for(int weight:weights){

            for (int i = m; i >= weight; i--) {
                if(dp[i-weight]){
                    dp[i] = true;
                    max = Math.max(max, i);
                }
            }
        }
        return max;
    }

    public int backPackByIntArray(int m, int[] weights) {
        int max = 0;
        int[] dp = new int[m + 1];
        /**每个物品只能使用一次*/
        for(int weight:weights){
            for (int i = m; i >= weight; i--) {
                dp[i] = Math.max(dp[i], dp[i - weight] + weight);
            }
        }
        return dp[m];
    }




    public static void main(String[] args) {

        int i = new BackPack().backPack(10, new int[]{3, 4, 8, 5});
        System.out.println(i);

    }
}
