package com.leetcode.array;

public class SearchRotatedSortedArray {


    /**
     * 整数数组 nums 按升序排列，数组中的值 互不相同 。
     *
     * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
     * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
     * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
     *
     * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回-1。
     *
     *
     * 示例 1：
     *
     * 输入：nums = [4,5,6,7,0,1,2], target = 0
     * 输出：4
     *
     * 示例2：
     *
     * 输入：nums = [4,5,6,7,0,1,2], target = 3
     * 输出：-1
     *
     * 示例 3：
     *
     * 输入：nums = [1], target = 0
     * 输出：-1
     *
     * 提示：
     *
     * 1 <= nums.length <= 5000
     * -10^4 <= nums[i] <= 10^4
     * nums 中的每个值都 独一无二
     * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
     * -10^4 <= target <= 10^4
     *
     * 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？
     *
     * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
     * @param nums
     * @param target
     * @return
     * 
     * 解决关键在于:
     * 确认前半段区间还是后半段区间
     * 
     */
    public int search(int[] nums, int target) {

        if(nums==null||nums.length<1){
            return -1;
        }
        int lo = 0 , hi = nums.length-1;

        while(lo<=hi){

            int mid = lo+((hi-lo)>>1);

            if(nums[mid]==target){
                return mid;
            }

            if(nums[mid]==nums[lo]){
                lo++;
                continue;
            }

            //前半段
            if(nums[mid]>nums[lo]){

                //[lo,mid)
                //在前半段的范围内
                if(target>=nums[lo] && target<nums[mid]){
                     hi =mid-1;
                }else {
                    //不在前半段的范围内
                     lo = mid+1;
                }

            }else{
                //中点落到后半段
                //(mid,hi]
                if(target>nums[mid] && target<=nums[hi]){
                    lo = mid+1;
                }else{
                    hi = mid-1;
                }
            }

        }
        return -1;

    }

}
