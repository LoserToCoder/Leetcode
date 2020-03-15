package com.leetcode.bits;

public class RangeBitwiseAnd {

    /**
     * 题目描述:
     * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
     * 示例 1: 
     * 输入: [5,7]
     * 输出: 4
     * 示例 2:
     * 输入: [0,1]
     * 输出: 0
     * 链接：https://leetcode-cn.com/problems/bitwise-and-of-numbers-range
     */

    /***
     *
     * @param m
     * @param n
     * @return
     *
     *
     */
    public int rangeBitwiseAnd(int m, int n) {

        while (m<n){
            /***
             * 一个数二进制位为1的位从高到低记为Bn,Bn-1,Bn-2,...,B1;
             *(n&n-1)操作是降低低位的1, (n&n-1)和n之间的高位都保持一致,
             *n&n-1可以代表 [n,n&n-1]之间连续所有数的与运算,
             *之间连续的数高位是一致的,即便是低位不一致结果也是大于等于(n&n-1)
             * 再进行与运算也是一样的结果
             */
            n&=n-1;
        }
        return n;
    }

    public int bits(int n){
        int c=0;
        while (n!=0){
            n&=n-1;
            c++;
        }
        return c;
    }
    public static void main(String[] args) {

        RangeBitwiseAnd bitwiseAnd = new RangeBitwiseAnd();
        bitwiseAnd.bits(25);

    }
}
