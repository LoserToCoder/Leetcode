package com.leetcode.dp;

public class DecodeWays {


    /**
     *
     * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
     *
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
     * 示例 1:
     * 输入: "12"
     * 输出: 2
     * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
     * 示例 2:
     * 输入: "226"
     * 输出: 3
     * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
     * 链接：https://leetcode-cn.com/problems/decode-ways
     * @param s
     * @return
     */
    public int numDecodings(String s) {

        int n=s.length();

        if(n==1) return s.charAt(0) == '0' ? 0 : 1;
        int[] dp = new int[n + 1];

        dp[n] =1;
        dp[n - 1]=s.charAt(n-1)=='0'?0:1;

        for(int i=n-2;i>=0;i--){

            if(s.charAt(i)=='0'){
                dp[i]=0;//为使得dp[i]=dp[i+2]+dp[i+1]==dp[i+2]
                continue;
            }
            if((s.charAt(i)-'0')*10+(s.charAt(i+1)-'0')<=26){
                dp[i] = dp[i+2] + dp[i + 1];
            }else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
       String s= "1223";

    }
}
