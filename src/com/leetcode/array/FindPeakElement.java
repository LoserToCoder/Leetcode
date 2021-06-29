package com.leetcode.array;

public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int l=0, h =nums.length-1;
        while (l<h){
            int mid =((h-l)>>1)+l;

            if(nums[mid]<=nums[h]){
                l = mid+1;
            }else{
                h = h-1;
            }
        }
        return l;
    }
}
