package com.leetcode.bits;

import java.util.Random;

/***
 * 问题描述:
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 */
public class BitSet {

    /***
     *   关于n与n-1的位运算来计算2进制位中1的个数
     *   由于 1的位代表 2^i (2的i次幂) 与 2^i -1(实际就是二进制i-1个1的二进制位)
     *   由于2^i 和2^i-1在计算机中刚好是i个1位的数,即 11111111111111111111(从左边数第一个1就是2^i, 剩下的就是1就是2^i-1的二进制表示)
     *   所以就是2^i与2^i-1进行与运算,就是消除一个数中二进制的最低位的1
     *   利用这种原理：n=n&(n-1)就是消除最低位的1之后的数,不断的迭代直至n=0为止。
     * @param n
     * @return
     */

    public int hammingWeight(int n){
        int bits=0;
        while (n!=0){
            bits++;
            n = n & (n - 1);
        }
        return bits;
    }

    /**
     * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
     * 利用位运算来计算, 想象求两个集合的元素,先求集合的交集 A与B,然后求集合之间
     *  a&b  求交集  当a&b等于0时,a|b并集，否则就是没有
     *  a^b  去除交集部分
     *
     * @param a
     * @param b
     * @return
     */
    public  int getSum(int a,int b){
        int n;
        while ((n=a&b)!=0){
            a=a^b;
            b=n<<1;
        }
        return a|b;
    }

    /*public int hammingWeight(int n) {
        if(Integer.MIN_VALUE==n){
            return  1;
        }
        if(n<0){
            n=-n;
        }
        int count=0;
        while (n!=0){
            if((n&1)==1)
                count++;
             n=n>>1;
        }
        return count;
    }*/

    /***
     *   对于一个2的幂来说
     *   2^n-1 中二进制1只有一个  刚好与2^n进行与运算刚好为0
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
         /* int power;
          for(int i=0;i<31;i++){
              power=1<<i;
              if(n==power){
                    return true;
                }
          }
          return false;
       */
         return n>0&&(n&(n-1))==0;

    }
    public static void main(String[] args) {
        Random random=new Random();
        BitSet bitSet=new BitSet();
        for(int i=0;i<100;i++){
            int nums = random.nextInt(Integer.MAX_VALUE);
            System.out.print(Integer.toString(nums,2));
            System.out.print(Integer.toString(nums - 1, 2));
            System.out.print(Integer.toString(nums - 2, 2));
            System.out.print(Integer.toString(nums-3,2));
            System.out.println();
        }
    }

}
