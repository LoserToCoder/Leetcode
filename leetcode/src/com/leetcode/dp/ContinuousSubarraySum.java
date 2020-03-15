package com.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {


    /**
     * 给定一个包含非负数的数组和一个目标整数 k，
     * 编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，
     * 总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。
     * 示例 1:
     * 输入: [23,2,4,6,7], k = 6
     * 输出: True
     * 解释: [2,4] 是一个大小为 2 的子数组，并且和为 6。
     * 示例 2:
     * 输入: [23,2,6,4,7], k = 6
     * 输出: True
     * 解释: [23,2,6,4,7]是大小为 5 的子数组，并且和为 42。
     * 说明:
     * 数组的长度不会超过10,000。
     * 你可以认为所有数字总和在 32 位有符号整数范围内。
     * 链接：https://leetcode-cn.com/problems/continuous-subarray-sum
     * @param nums
     * @param k
     * @return
     *
     * 子数组可以来表示:  S3-S1=[a2,a3]
     *   (Sn-Sm)%k=0
     *   Sn%k==Sm%k (n-m>=2)  注意的:Sn,Sm为0的情况
     */
    public boolean checkSubarraySum(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum=0;
        for(int i=0;i<nums.length;i++){

            sum += nums[i];

            if(k!=0){
               sum=sum%k;
            }

            if(map.containsKey(sum)){
                if(i-map.get(sum)>=2) return true;
            }else{
                map.put(sum, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
