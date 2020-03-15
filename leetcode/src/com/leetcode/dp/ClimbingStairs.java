package com.leetcode.dp;
public class ClimbingStairs {
    /**

     假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     注意：给定 n 是一个正整数。
         示例 1：
         输入： 2
         输出： 2
         解释： 有两种方法可以爬到楼顶。
                         1.  1 阶 + 1 阶
                         2.  2 阶
        示 例 2：
         输入： 3
         输出： 3
         解释： 有三种方法可以爬到楼顶。
                     1.  1 阶 + 1 阶 + 1 阶
                     2.  1 阶 + 2 阶
                     3.  2 阶 + 1 阶
     * 链接：https://leetcode-cn.com/problems/climbing-stairs
     * @param n
     * @return
     */
    public int climbStair(int n) {
        if(n==1||n==2)
            return  n;
        return  climbStair(n-1)+climbStair(n-2);
    }
    public int climbStairs(int n) {
        if(n==1||n==2)
            return  n;
        int []dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public long climbStairss(int n)throws Exception {
        if(n==1||n==2)
            return  n;
        long []dp=new long[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }



    public static void main(String[] args) throws Exception{
        System.out.println(new ClimbingStairs().climbStairss(100));
    }
}
