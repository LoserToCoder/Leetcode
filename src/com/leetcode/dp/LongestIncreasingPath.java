package com.leetcode.dp;

public class LongestIncreasingPath {

    /**
     * 矩阵中的最长递增路径
     * 给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径的长度。
     * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在
     * 对角线 方向上移动或移动到 边界外（即不允许环绕）。
     *
     *
     *
     * 示例 1：
     * 输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
     * 输出：4
     * 解释：最长递增路径为 [1, 2, 6, 9]。
     *
     * 示例 2：
     * 输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
     * 输出：4
     * 解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
     *
     * 示例 3：
     * 输入：matrix = [[1]]
     * 输出：1
     *
     * @param matrix
     * @return
     */
   public int longestIncreasingPath(int[][] matrix){
       int rows = matrix.length,cols = matrix[0].length;
       int [][]dp = new int[rows][cols];
       int ret = 0;
       for(int i=0;i<rows;i++){
           for(int j=0;j<cols;j++){

               if(dp[i][j]==0){
                   dfs(matrix, dp, i, j, Integer.MIN_VALUE);
                   ret = Math.max(ret, dp[i][j]);
               }

           }
       }
       return ret;
   }
   public int dfs(int[][]matrix,int [][]dp,int i,int j,int prev){
       if(i<0||i>=matrix.length||j<0||j>=matrix[0].length||matrix[i][j]<=prev) return 0;

       if(dp[i][j]!=0) return dp[i][j];

       int left = dfs(matrix,dp,i,j-1,matrix[i][j]);
       int right = dfs(matrix, dp, i, j + 1, matrix[i][j]);
       int up = dfs(matrix, dp, i - 1, j, matrix[i][j]);
       int down = dfs(matrix, dp, i + 1, j, matrix[i][j]);
       dp[i][j] = Math.max(left, Math.max(right, Math.max(up, down)))+1;

       return dp[i][j];
   }
}
