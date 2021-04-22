package com.leetcode.map;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateIII {

    /**
     * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，
       使得nums [i] 和nums [j]的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
     * 示例1:
     * 输入: nums = [1,2,3,1], k = 3, t = 0
     * 输出: true
     * 示例 2:
     * 输入: nums = [1,0,1,1], k = 1, t = 2
     * 输出: true
     * 示例 3:
     * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
     * 输出: false
     * 链接：https://leetcode-cn.com/problems/contains-duplicate-iii
     *
     * |nums[i]-nums[j]<=t ==>nums[i]<=nums[j]+t, nums[i]>=nums[j]-t
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        
         Map<Long,Integer> map=new HashMap<>();
         for(int i=0;i<nums.length;i++){
            
            for(int delta=0;delta<=t;delta++){
                if(map.containsKey(nums[i]+delta)||map.containsKey(nums[i]-delta)){
                    Integer j=map.get(nums[i]+delta);
                    j=(j==null)?map.get(nums[i]-delta):j;
                    if(i-j<=k) return true;
                }
            }
            map.put(Long.valueOf(nums[i]),i);

         }

         return false;

    }

    public static void main(String[] args) {

        System.out.println("   ".trim().length());

    }
    
}
