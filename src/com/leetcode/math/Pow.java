package com.leetcode.math;

public class Pow {

    /**
     * 实现pow(x, n)，即计算 x 的 n 次幂函数（即，xn）。
     *
     * 
     *
     * 示例 1：
     *
     * 输入：x = 2.00000, n = 10
     * 输出：1024.00000
     * 示例 2：
     *
     * 输入：x = 2.10000, n = 3
     * 输出：9.26100
     * 示例 3：
     *
     * 输入：x = 2.00000, n = -2
     * 输出：0.25000
     * 解释：2-2 = 1/22 = 1/4 = 0.25
     *
     * 链接：https://leetcode-cn.com/problems/powx-n
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {

        if(x==0.0) return 0;
        long b = n;
        double res = 1;
        if(n<0){
            b = -b ;
            x = 1/x;
        }
        while(b!=0){

            if((b&1)==1) res *=x;
            x *=x;
            b = b>>1;
        }
        return res;
    }

}
