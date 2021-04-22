package com.leetcode.doublespoints;

public class SubarrayProductLessThanK {

    /**
     * 给定一个正整数数组nums。
     * 找出该数组内乘积小于k的连续的子数组的个数。
     * 示例 1:
     * 输入: nums = [10,5,2,6], k = 100
     * 输出: 8
     * 解释: 8个乘积小于100的子数组分别为:
     * [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
     * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
     * 说明:0 < nums.length <= 50000
     *      0 < nums[i] < 1000
     *      0 <= k < 10^6
     * 链接：https://leetcode-cn.com/problems/subarray-product-less-than-k
     * @param nums
     * @param k
     * @return

     * 算法
     *
     * 有时候应该换一种思路去解决问题,不是直接去解决问题
     *
     * 我们使用一重循环枚举right，同时设置left 的初始值为 0。在循环的每一步中，表示 right 向右移动了一位，
     * 将乘积乘以nums[right]。此时我们需要向右移动left，直到满足乘积小于 kk 的条件。
     * 在每次移动时，需要将乘积除以 ]nums[left]。当left 移动完成后，对于当前的right，就包含了
     * right−left+1 个乘积小于 kk 的连续子数组。
     * 链接：https://leetcode-cn.com/problems/subarray-product-less-than-k/solution/cheng-ji-xiao-yu-kde-zi-shu-zu-by-leetcode/
     *
     */


    public int numSubarrayProductLessThanK(int[] nums, int k) {


        /*int c=0;

        for(int i=0;i<nums.length;i++){

            int s=1;
            for(int j=i;j<nums.length;j++){

                s*=nums[j];
                if(s<k){
                    c++;
                }else {
                    break;
                }

            }
        }
        return c;*/
        if (k <= 1) return 0;
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) prod /= nums[left++];
            ans += right - left + 1;
        }
        return ans;


    }

    public static void main(String[] args) {

        int[] nums = {10,5,2,6};
        int k=100;
        SubarrayProductLessThanK lessThanK = new SubarrayProductLessThanK();
        System.out.println(lessThanK.numSubarrayProductLessThanK(nums,k));

    }

}
