package com.leetcode.binary;

public class SearchRange {
    /*
     给定一个按照升序排列的整数数组 nums，和一个目标值 target。
     找出给定目标值在数组中的开始位置和结束位置。
     你的算法时间复杂度必须是O(log n) 级别。
     如果数组中不存在目标值，返回[-1, -1]。
        示例 1:
        输入: nums = [5,7,7,8,8,10], target = 8
        输出: [3,4]
        示例2:
        输入: nums = [5,7,7,8,8,10], target = 6
        输出: [-1,-1]
        链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
     */
    public int[] searchRange(int[] nums, int target) {
      int[]dp={-1,-1};
      if(nums==null||nums.length<1) return dp;
      int leftIdx=binarySearchFirstElement(target,nums,0,nums.length-1);
      if(leftIdx==-1) return dp;
      dp[0]=leftIdx;
      dp[1]=binarySearchLastElement(target,nums,leftIdx,nums.length-1);
      return dp;
    }

    private  int binarySearchLastElement(int target,int []array,int start,int limit){
        int middle=0;
        int prev=-1;// =>增加一个前项指针,避免出现错过以及循环跳出
        for(;start<limit;) {
            middle=(start+limit)/2;
            if(target<array[middle]){
                limit=middle-1;
            }else{
                prev=middle;
                start=middle+1;
            }
        }
        if(target>=array[start]){
            return start;
        }
        return prev;
    }
    private  int binarySearchFirstElement(int key,int []array,int low,int high){
        int middle;
        while(low<high){
            middle=(low+high)>>1;
            if(key<=array[middle]){
                high=middle;
            }else if(key>array[middle]){
                low=middle+1;
            }
        }
        return key==array[low]?low:-1;
    }

      private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            }
            else {
                lo = mid+1;
            }
        }

        return lo;
    }

    public int[] searchRangeOffical(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false)-1;

        return targetRange;
    }
    public static void main(String[] args) {

        int []nums={1,3,5,7,9,9,10};
        SearchRange range = new SearchRange();
        for(int key:nums){
            int first=range.binarySearchFirstElement(key,nums,0,nums.length-1);
            int last = range.binarySearchLastElement(key, nums, first, nums.length - 1);
            System.out.println("[first:"+first+",last:"+last+"]");
        }


    }
}
