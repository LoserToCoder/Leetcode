package com.leetcode.dp;

public class MiniumPathSum {

   /*
   给定一个包含非负整数的 mxn网格，请找出一条从左上角到右下角的路径，
    使得路径上的数字总和为最小。(说明:每次只能向下或者向右移动一步)
    示例:
    输入:
            [ [1,3,1],
              [1,5,1],
              [4,2,1] ]
    输出: 7
    解释: 因为路径 1→3→1→1→1 的总和最小。
    动态规划函数表达式  dp[i][j]=min{dp[i-1][j],dp[i][j-1]}+grid[i][j]
    注意(注意i,j的边界处时,上述函数要拆分  i=0或j=0
    i=0时,只能是从左边来的,所有往右走
    j=0时,只能是从上边下来的,所以往下走
    链接：https://leetcode-cn.com/problems/minimum-path-sum*/

   /***
   时间复杂度 ：O(mn)。遍历整个矩阵恰好一次。
   空间复杂度 ：O(mn)。额外的一个同大小矩阵。
   **/
   public  int minPathSum(int [][]grid){
        int n=grid.length;
        int m=grid[0].length;
        int [][]dp=new int[n][m];
        dp[0][0]=grid[0][0];
        for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
              if(i==0&&j>0){
                 dp[i][j]=dp[i][j-1]+grid[i][j];
              }else if(i>0&&j==0){
                 dp[i][j]=dp[i-1][j]+grid[i][j];
              }else if(i>0&&j>0){
                 dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
              }
           }
        }
        return dp[n-1][m-1];
   }
   /***
   时间复杂度:O(mn)
   空间复杂度:O(m)
   **/
   public int minPathSum2(int[][] grid) {
       int[] dp = new int[grid[0].length];
       for (int i = grid.length - 1; i >= 0; i--) {
           for (int j = grid[0].length - 1; j >= 0; j--) {
               if(i == grid.length - 1 && j != grid[0].length - 1)
                   dp[j] = grid[i][j] +  dp[j + 1];
               else if(j == grid[0].length - 1 && i != grid.length - 1)
                   dp[j] = grid[i][j] + dp[j];
               else if(j != grid[0].length - 1 && i != grid.length - 1)
                   dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1]);
               else
                   dp[j] = grid[i][j];
           }
       }
       return dp[0];
   }
   
}
