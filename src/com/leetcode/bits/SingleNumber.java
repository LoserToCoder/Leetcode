package com.leetcode.bits;
public class  SingleNumber {
    
    /*
    定一个整数数组nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
    进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
    链接：https://leetcode-cn.com/problems/single-number-iii
     */
    public int[] singleNumber(int[] nums) {
        int bitmask = 0;
        for (int num : nums) {
            bitmask ^= num;
        }
        //bitmask &= -bitmask,保留最低位的1
        bitmask &= -bitmask;
        int[] ret = {0, 0};
        for (int num : nums) {
            if ((bitmask & num) != 0) {
                ret[0] ^= num;
            } else {
                ret[1] ^= num;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(32));
        System.out.println(Integer.toBinaryString(-32));
        System.out.println(32&-32);
    }
    
}
