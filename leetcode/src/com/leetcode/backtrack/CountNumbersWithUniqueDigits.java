package com.leetcode.backtrack;

public class CountNumbersWithUniqueDigits {

    /***
     给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。
     示例:
     输入: 2
     输出: 91
     解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
     链接：https://leetcode-cn.com/problems/count-numbers-with-unique-digits
     * @param n
     * @return
     * n=1   等于 10
     * n=2   9*9+10(n=1)   其中 9*9 十位数不包含0个位数包含0
     * n=3   9*9*8+91(n=2)  739
     */
    public int countNumbersWithUniqueDigits(int n) {
        int []dp=new int[n];
        int ans=9;
        dp[0]=10;
        for(int i=1;i<n;i++){
            ans=(10-i)*ans;
            dp[i]=dp[i-1]+ans;
        }
        return dp[n-1];
    }

    public static void main(String[] args) {

        CountNumbersWithUniqueDigits digits = new CountNumbersWithUniqueDigits();
        digits.countNumbersWithUniqueDigits(10);
    }
}
