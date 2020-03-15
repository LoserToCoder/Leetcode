package com.leetcode.dp;

public class UniquePaths {


    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角
     * （在下图中标记为“Finish”）。问总共有多少条不同的路径？
     * 链接：https://leetcode-cn.com/problems/unique-paths
     * @param m
     * @param n
     * @return
     动态规划:
       令dp[i][j]:代表到达的路径数目
       转移方程就是:dp[i][j]=dp[i-1][j](从上边过来)+dp[i][j-1](从左边过来) 
       (i-1>=0,j-1>=0)
     */
    public int uniquePaths(int m, int n) {

        if(m==1||n==1) return 1;
        int[][] dp = new int[m][n];
        dp[0][0]=1;

        for(int i=0;i<m;i++){


            for(int j=0;j<n;j++){

                if(i-1>=0&&j-1<0){//只能从上边转移到
                    dp[i][j] = dp[i - 1][j];
                }else if(j-1>=0&&i-1<0){
                    dp[i][j] = dp[i][j - 1];//只能从左边转移
                }else if(i-1>=0&&j-1>=0){
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }


        return dp[m-1][n-1];
    }

    public static void main(String[] args) {


        UniquePaths paths = new UniquePaths();

        System.out.println(paths.uniquePaths(7,3));

    }
}
