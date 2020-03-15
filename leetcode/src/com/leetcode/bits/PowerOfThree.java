package com.leetcode.bits;

public class PowerOfThree {

    /***
     * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
     * 示例 1:
     * 输入: 27
     * 输出: true
     * 示例 2:
     * 输入: 0
     * 输出: false
     * 示例 3:
     * 输入: 9
     * 输出: true
     * 示例 4:
     * 输入: 45
     * 输出: false
     * 进阶：
     * 你能不使用循环或者递归来完成本题吗？
     * 链接：https://leetcode-cn.com/problems/power-of-three
     */
    public boolean isPowerOfThree(int n) {

        switch (n){
            case 1:return true;
            case 3:return true;
            case 9:return true;
            case 27:return true;
            case 81:return true;
            case 243:return true;
            case 729:return true;
            case 2187:return true;
            case 6561:return true;
            case 19683:return true;
            case 59049:return true;
            case 177147:return true;
            case 531441:return true;
            case 1594323:return true;
            case 4782969:return true;
            case 14348907:return true;
            case 43046721:return true;
            case 129140163:return true;
            case 387420489:return true;
            case 1162261467:return true;
            default:return false;
        }
    }
    public static void main(String[] args) {


        for(int i=1;i<30;i++){
            System.out.println(Math.pow(3,i));
        }
        //System.out.println(Integer.MAX_VALUE);

    }
}
