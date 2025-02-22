package com.leetcode.array;

public class FindMinRepeatSortedArray {


    /*
    已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
    若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
    若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
    注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。

    给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。

    示例 1：

    输入：nums = [1,3,5]
    输出：1
    示例 2：

    输入：nums = [2,2,2,0,1]
    输出：0

    链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii
     */
    public int findMin(int[] nums) {

        if(nums==null||nums.length<1){
            throw new IllegalArgumentException();
        }
        int lb =0, rb = nums.length-1;
        while (lb<rb){

            int mid = lb + ((rb - lb) >> 1);
            if(nums[mid]==nums[rb]){
                rb = rb-1;
            } else if(nums[mid]<nums[rb]){
                rb = mid;
            }else {
                lb = mid+1;
            }
        }
        return nums[lb];

    }

    public int findMax(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] > nums[l]) {
                l = mid;
            } else if (nums[mid] < nums[l]) {
                r = mid - 1;
            } else {
                l++;
            }
        }
        return nums[l];
    }

}
