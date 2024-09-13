package com.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMinSortedArray {

    /**
     *
     已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。
     例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
     若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
     若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
     注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。

     给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。



     示例 1：

     输入：nums = [3,4,5,1,2]
     输出：1
     解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
     示例 2：

     输入：nums = [4,5,6,7,0,1,2]
     输出：0
     解释：原数组为 [0,1,2,4,5,6,7] ，旋转 4 次得到输入数组。
     示例 3：

     输入：nums = [11,13,15,17]
     输出：11
     解释：原数组为 [11,13,15,17] ，旋转 4 次得到输入数组。

     https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {


            /**
             * 由于此题是要求取最小值, mid和right比较
             * 如果 是mid 和left比较的话
             *  nums[left]<=nums[right] 这种情况下
             *  最小值可能在最左边也可能在中间,不太好把控
             * 反而通过判断right和mid
             * nums[right]<=nums[mid] 则说明最小值处在 mid~right之间
             * nums[right]>nums[mid] 最小值处在left~mid之间
             */
            int left = 0 ,right = nums.length-1;
            while (left<right){
                int mid = left+(right-left)/2;
                // 如果中点位置  nums[mid]>nums[right] 说明 拐点在右侧,最小值在右侧 此时继续往右推进
                if(nums[mid]>nums[right]){
                    left = mid+1;
                } else {
                    /**
                     * 不排除有重复元素
                     * nums[mid]<nums[right] 说明在已经在拐点下侧了
                     * right = mid-1;
                     * nums[mid]==nums[right] 如果有重复元素的存在的话,可能还没有到拐点
                     * 执行 right = mid-1 可能会错过最小值
                     * 综合选择还是
                     * right= right-1;
                     */
                    right = right-1;
                }
            }

            return nums[left];

    }


    public static void main(String[] args) {
        FindMinSortedArray findMinSortedArray = new FindMinSortedArray();
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(findMinSortedArray.findMin(nums));

        int[] array = {4,2,1,2};
        int i = minimizeMax(array,1);


    }

    public static int minimizeMax(int[] nums, int p) {

        Arrays.sort(nums);

        int n = nums.length,left = -1, right = nums[n-1]-nums[0];
        while(left+1 < right) {

            int mid = (left+right)>>1, cnt = 0;
            for(int i=0;i<n-1;i++) {
                if(nums[i+1]-nums[i]<=mid) {
                    cnt++;
                    i++;
                }
            }

            if(cnt>=p) right = mid;
            else left = mid;
        }
        return right;

    }
}
