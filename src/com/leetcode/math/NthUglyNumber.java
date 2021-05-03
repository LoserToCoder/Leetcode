package com.leetcode.math;

public class NthUglyNumber {


    /**
     *
     给你一个整数 n ，请你找出并返回第 n 个 丑数 。

     丑数 就是只包含质因数 2、3 和/或 5 的正整数。
     示例 1：

     输入：n = 10
     输出：12
     解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
     示例 2：

     输入：n = 1
     输出：1
     解释：1 通常被视为丑数。

     提示：
     E(i2,i3,i5) = (2^i2)*(3^i3)*(5^i5)
     1 <= n <= 1690
     通过次数80,644提交次数141,568
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] dps = new int[n];
        dps[0] =1;
        int i2=0,i3=0,i5=0;
        for(int i=1;i<n;i++){

            dps[i] = 1;
            int p2=dps[i2]*2,p3=dps[i3]*3,p5=dps[i5]*5;
            dps[i] = min(p2, p3, p5);
            if(dps[i]==p2) i2++;//避免重复值
            if(dps[i]==p3) i3++;//避免重复值
            if(dps[i]==p5) i5++;//避免重复值
        }
        return dps[n - 1];
    }
    int min(int a,int b,int c){
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {
        NthUglyNumber nthUglyNumber = new NthUglyNumber();
        nthUglyNumber.nthUglyNumber(10);
    }
}
