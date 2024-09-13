package com.leetcode.math;

import java.util.HashMap;
import java.util.Map;

public class MaximumProduct {

    /**
     * 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
     *
     * 示例 1：
     * 输入：nums = [1,2,3]
     * 输出：6
     *
     * 示例 2：
     * 输入：nums = [1,2,3,4]
     * 输出：24
     *
     * 示例 3：
     * 输入：nums = [-1,-2,-3]
     * 输出：-6
     *
     * 提示：
     * 3 <= nums.length <= 104
     * -1000 <= nums[i] <= 1000
     */

    /**
     * 排序:
     * 数组分情况
     * 全是负数 或者全是非负数的情况 （都是最大值相乘）
     *
     * 有负数的情况下
     * 取 两个最小数 和 最大数 想乘 然后和 最大的三个数比较
     *
     */

    public int maximumProduct(int[] nums) {
       int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
       int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int num : nums) {

            if(num<min1) {
                min2 = min1;
                min1 = num;
            } else if(num<min2) {
                min2 = num;
            }

            if(num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if(num > max3){
                max3 = num;
            }
        }
        return Math.max(min2 * min1 * max1, max1 * max2 * max3);
    }


    public int findShortestSubArray(int[] nums) {

        Map<Integer,Node> map = new HashMap<>();
        int maxFrequence = 0;
        for(int i =0;i<nums.length;i++) {

            Node node = null;
            if(!map.containsKey(nums[i])) {
                node = new Node();
                node.left = i;
                node.right = i;
                node.count = 1;
            } else {
                node =  map.get(nums[i]);
                node.right = i;
                node.count = node.count+1;
            }
            map.put(nums[i],node);

            maxFrequence = Math.max(maxFrequence,node.count);
        }

        int maxLength = 0;
        for(Map.Entry<Integer,Node> entry: map.entrySet()){
            Node node = entry.getValue();
            if(node.count == maxFrequence) {
                maxLength = Math.min(maxLength,node.right-node.right+1);
            }
        }
        return maxLength;
    }

    public class Node {
        public int left;
        public int right;
        public int count;
    }

    public static void main(String[] args) {

        int shortestSubArray = new MaximumProduct().findShortestSubArray(new int[]{1, 2, 2, 3, 1});
        System.out.println(shortestSubArray);
    }
}
