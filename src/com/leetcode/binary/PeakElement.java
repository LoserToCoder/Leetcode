package com.leetcode.binary;

public class PeakElement {


    /**
     *
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int l=0,r=nums.length-1;
        while(l<r){
            int mid=l+((r-l)>>1);
            /**
             * 峰值临界点:
             *    1. 刚好在临界点
             *    2. 也可能在临界点右边
             *
             */
            if(nums[mid]>nums[mid+1])r=mid;
            else l=mid+1;
        }
        return l;
    }

    public static void main(String[] args) {

        new PeakElement().findPeakElement(new int[]{1, 3, 4, 7, 13, 19, 17, 13, 8, 3, 1});


    }
}
