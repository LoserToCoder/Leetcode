package com.leetcode.dp;
import java.util.List;

public class Triangle {

    
    /**给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到
        下一行中相邻的结点上。例如，给定三角形：
                         [
                                [2],
                               [3,4],
                              [6,5,7],
                             [4,1,8,3]
                         ]
     自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
     说明：如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）
     来解决这个问题，那么你的算法会很加分。
     链接：https://leetcode-cn.com/problems/triangle*/
                               
    public int minimumTotalOptimize(List<List<Integer>> triangle) {
        int n=triangle.size();
        int []dp=new int[n];
        List<Integer> lastLine=triangle.get(n-1);
        /**对最后一行进行赋值,减少比较与遍历**/
        for(int i=0;i<n;i++){
            dp[i]=lastLine.get(i);
        }
        for(int i=n-2;i>=0;i--){
            int len=triangle.get(i).size();
            for(int j=0;j<len;j++){
                dp[j]=Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
     
     /*
       简便的利用存储空间来避免索引超标的问题
     */
     public int minimumTotal(List<List<Integer>> triangle) {
         int n=triangle.size();
         int []dp=new int[n+1];
         /**
          * 多浪费一个存储单元,来避免索引超标问题,
          * 取最后一行数值时候,
          */

         for(int i=n-1;i>=0;i--){
            int len=triangle.get(i).size();
            for(int j=0;j<len;j++){
               dp[j]=Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
            }
         }
         return dp[0];
    }
    public static void main(String[] args) {
        ///System.out.println(new Triangle().minimumTotal());
        int [][]dp=new int[10][];
        for(int i=0;i<dp.length;i++){
            dp[i]=new int[i+1];
        }
        for(int i=0;i<dp.length;i++){
            System.out.println(dp[i].length);
        }
    }
}
