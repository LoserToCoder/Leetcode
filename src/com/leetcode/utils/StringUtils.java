package com.leetcode.utils;

public class StringUtils {

    public static String arrayToString(int[] nums) {

        if(nums==null||nums.length==0) return "";
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(nums[0]);
        for(int i=1;i<nums.length;i++){
            sb.append(",")
              .append(nums[i]);
        }
        sb.append("]");

        return sb.toString();
    }



}
