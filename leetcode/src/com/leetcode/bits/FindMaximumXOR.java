package com.leetcode.bits;
import java.util.HashSet;
import java.util.Set;

public class FindMaximumXOR {
    /***
     给定一个非空数组，数组中元素为 a0, a1, a2, … , an-1，其中 0 ≤ ai < 231 。
     找到 ai 和aj 最大的异或 (XOR) 运算结果，其中0 ≤ i,  j < n 。
     你能在O(n)的时间解决这个问题吗？
     示例:
     输入: [3, 10, 5, 25, 2, 8]
     输出: 28
     解释: 最大的结果是 5 ^ 25 = 28.
     链接：https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array
     * @param nums
     * @return
     */
    public int findMaximumXOR(int []nums){

        int res=0;
        int mask=0;
        Set<Integer> map = new HashSet<>();
        for(int i=31;i>=0;i--){
            mask=mask|1<<i;
            for(int num:nums){
                map.add(num & mask);
            }
            int tmp=res|1<<i;
            for(int prefix:map){
                if(map.contains(prefix^tmp)){
                    res=tmp;
                    break;
                }
            }
            map.clear();
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums = {3, 10, 5, 25, 2, 8};
        System.out.println(new FindMaximumXOR().findMaximumXOR(nums));

    }


}
