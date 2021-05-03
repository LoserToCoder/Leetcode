package com.leetcode.string;

public class EditDistance {

    /**
     给定两个单词word1 和word2，计算出将word1转换成word2 所使用的最少操作数。
     你可以对一个单词进行如下三种操作：
     插入一个字符
     删除一个字符
     替换一个字符
     示例1:
     输入: word1 = "horse", word2 = "ros"
     输出: 3
     解释:
     horse -> rorse (将 'h' 替换为 'r')
     rorse -> rose (删除 'r')
     rose -> ros (删除 'e')
     示例2:
     输入: word1 = "intention", word2 = "execution"
     输出: 5
     解释:
     intention -> inention (删除 't')
     inention -> enention (将 'i' 替换为 'e')
     enention -> exention (将 'n' 替换为 'x')
     exention -> exection (将 'n' 替换为 'c')
     exection -> execution (插入 'u')
     链接：https://leetcode-cn.com/problems/edit-distance
     * @param word1
     * @param word2
     * @return
     */

    public int minDistance(String word1, String word2) {

       int m=word1.length();
       int n=word2.length();
       int [][]dp=new int[m+1][n+1];
       //第一行
       for(int i=0;i<=n;i++) dp[0][i]=i;//插入字符

       //第一列
       for(int i=0;i<=m;i++) dp[i][0]=i;//删除字符


       for(int i=1;i<=m;i++){

          for(int j=1;j<=n;j++){
               
               if(word1.charAt(i-1)==word2.charAt(j-1)) dp[i][j]=dp[i-1][j-1];
               /**
                * 当word1[i]!=word2[j]时,可以看做以下位置向 dp[i][j]的转换的最小距离
                * dp[i-1][j-1] 表示替换操作,
                * dp[i-1][j] 表示删除操作，相对dp[i][j]来说就是从上向下转移,表示删除
                * dp[i][j-1] 表示插入操作。相对dp[i][j]来说就是从左向右转移,表示插入
                */
               else
                 dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
          }

       }
       return dp[m][n];
    }


    public static void main(String[] args) {

    }

}
