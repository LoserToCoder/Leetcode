package com.leetcode.bits;

public class PowerOfTwo {

    /**
     * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
     * 示例 1:
     * 输入: 1
     * 输出: true
     * 解释: 20 = 1
     * 示例 2:
     * 输入: 16
     * 输出: true
     * 解释: 24 = 16
     * 示例 3:
     * 输入: 218
     * 输出: false
     * 链接：https://leetcode-cn.com/problems/power-of-two
     */
    public static boolean isPowerOfTwo(int n){
        return n>0&&(n&n-1)==0;//要判断n>0
    }

    public static void main(String[] args) {
        for(int i=1;i>0&&i<=Integer.MAX_VALUE;i++){
            if(isPowerOfTwo(i)){
                System.out.println(Integer.toString(i,2));
            }
        }
    }

}
