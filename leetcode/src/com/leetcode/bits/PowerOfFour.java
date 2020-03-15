package com.leetcode.bits;

public class PowerOfFour {

    /**
     * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
     * 示例 1:
     * 输入: 16
     * 输出: true
     * 示例 2:
     * 输入: 5
     * 输出: false
     * 进阶：
     * 你能不使用循环或者递归来完成本题吗？
     * 链接：https://leetcode-cn.com/problems/power-of-four
     */

    public boolean isPowerOfFour(int num) {
        if(num<=0||(num&(num-1))!=0) return false;
        while(num>1){ //(num&(num-1))的操作是判断是否是2的次幂
           num=num>>2;
        }
        return num==1;
    }

    public boolean isPowerOfFourOther(int num){
        /***
         * 考虑32位中,8为单位为,分三种情况考虑:
         * 0xff000000  前八位中  num>>24  之后最大是64
         * ox00ff0000  num>>16  取8位数分析
         */
       if(num<=0||(num&(num-1))!=0) return false;
    
        if((num & 0xff000000) != 0)
            num = num >> 24;
        else if((num & 0x00ff0000) != 0)
            num = num >> 16;
        else if((num & 0x0000ff00) != 0)
            num = num >> 8;

        return num == 1 || num == 4 || num == 16 || num == 64; 

    }





    public static void main(String[] args) {
        new PowerOfFour().isPowerOfFour(8);
    }
}
