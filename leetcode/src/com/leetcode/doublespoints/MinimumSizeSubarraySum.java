package com.leetcode.doublespoints;

public class MinimumSizeSubarraySum {


    /**
     *给定一个含有n个正整数的数组和一个正整数s ，
     * 找出该数组中满足其和 ≥ s 的长度最小的连续子数组。
     * 如果不存在符合条件的连续子数组，返回 0。
     * 示例:
     * 输入: s = 7, nums = [2,3,1,2,4,3]
     * 输出: 2
     * 解释: 子数组[4,3]是该条件下的长度最小的连续子数组。
     * 进阶:
     * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试O(n log n) 时间复杂度的解法。
     * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        /*int len=nums.length+1;
        for(int i=0;i<nums.length;i++){
            int k=s;
            for(int j=i;j<nums.length;j++){

                k -= nums[j];
                if(k<=0){
                    len = Math.min(len, j - i + 1);
                    break;
                }
            }
        }
        return len==nums.length+1?0:len;*/
        int n=nums.length,minLen=n+1;
        int r=0;
        for(int i=0;i<n;i++){
            s-=nums[i];
            while(s<=0){
                /**
                 * 可以看出 始终r<=i;
                 *
                 * 就是通过差值来解决:连续子数组之和大于等于s的,
                 *
                 * 实际上差值等同于题目给定的s和连续子数组的值Sn-Sm比较
                 * 小于等于零说明符合条件
                 * 这时候要去除连续子数组的开头元素,然后再做比较然后
                 * 看差值是否还是符合,就可以取最小连续子数组
                 * 注:r就是每次连续子数组的开始元素指针
                 *
                 * 最多也就是将整个数组元素扫描两遍
                 */

            	minLen=Math.min(minLen,i-r+1);
                s = s + nums[r++];
            }
        }

        return minLen==n+1?0:minLen;
    }


    public static void main(String[] args) {

        //int s = 7;int []nums = {2, 3, 1, 2, 4, 3};

        int s = 7;int []nums = {2,3,1,2,4,5,6,3,9};
        MinimumSizeSubarraySum subarraySum = new MinimumSizeSubarraySum();
        System.out.println(subarraySum.minSubArrayLen(s,nums));

    }



}
