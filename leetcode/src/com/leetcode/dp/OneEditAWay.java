package com.leetcode.dp;

public class OneEditAWay {


    /**
     * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。
     * 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
     * 示例1:
     * 输入:
     * first = "pale"
     * second = "ple"
     * 输出: True
     * 示例2:
     * 输入:
     * first = "pales"
     * second = "pal"
     * 输出: False
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/one-away-lcci
     * @param first
     * @param second
     * @return
     */
    public boolean oneEditAway(String first, String second) {

        int m=first.length();
        int n=second.length();

        int[][] dp = new int[m + 1][n + 1];

        for(int i=1;i<=m;i++) dp[i][0]=i;//删除

        for(int i=1;i<=n;i++) dp[0][i]=i;//新增

        for(int i=1;i<=m;i++){

            for(int j=1;j<=n;j++){

                if (first.charAt(i - 1) == second.charAt(j - 1)) {
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                }
            }
        }
        return dp[m][n]<=1;
    }


    public static void main(String[] args) {

        OneEditAWay editAWay = new OneEditAWay();
        String first = "teacher";
        String second = "attacher";
        System.out.println(editAWay.oneEditAway(first,second));

    }


}
