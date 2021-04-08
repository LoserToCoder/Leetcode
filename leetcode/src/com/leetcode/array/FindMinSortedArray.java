package com.leetcode.array;

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

        if(nums==null||nums.length<1){
            throw new IllegalArgumentException();
        }
        int lb = 0, rb = nums.length - 1;
        while (lb<rb){

            int mid =lb+((rb-lb)>>1);

            /**
             * 由于此题是要求取最小值, mid和right比较
             * 如果 是mid 和left比较的话
             *  nums[left]<=nums[right] 这种情况下
             *  最小值可能在最左边也可能在中间,不太好把控
             * 反而通过判断right和mid
             * nums[right]<=nums[mid] 则说明最小值处在 mid~right之间
             * nums[right]>nums[mid] 最小值处在left~mid之间
             */
            if (nums[rb] > nums[mid]) {
                rb = mid;
            }else {
                lb = mid+1;
            }
        }
        return nums[lb];

    }


    public static void main(String[] args) {

        FindMinSortedArray findMinSortedArray = new FindMinSortedArray();
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(findMinSortedArray.findMin(nums));


    }
}
