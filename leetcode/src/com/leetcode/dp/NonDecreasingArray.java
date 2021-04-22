package com.leetcode.dp;

public class NonDecreasingArray {


    /**
     * 给定一个长度为n的整数数组，你的任务是判断在最多改变1 个元素的情况下，
     * 该数组能否变成一个非递减数列。我们是这样定义一个非递减数列的：
     * 对于数组中所有的i (1 <= i < n)，满足array[i] <= array[i + 1]。
     * 示例 1:
     * 输入: [4,2,3]
     * 输出: True
     * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
     * 示例 2:
     * 输入: [4,2,1]
     * 输出: False
     * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
     * 说明:n 的范围为 [1, 10,000]。
     * 链接：https://leetcode-cn.com/problems/non-decreasing-array
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {

        if(nums.length<3) return true;
        /*Map<Integer, Integer> map = new HashMap<>();
        for(int i=1;i<nums.length-1;i++){

            int num1 = map.getOrDefault(i - 1, nums[i - 1]);
            int num2 = map.getOrDefault(i, nums[i]);
            int num3 = map.getOrDefault(i + 1, nums[i + 1]);
            if(num1<=num3&&(num3<num2||num2<num1)){
                map.put(i, num3);
            }else if(num1>num3){
                if(num3>=num2){
                    map.put(i - 1, num2);
                }else if(num1<=num2){
                    map.put(i + 1, num2);
                }
            }
            if(map.size()>1||(num1>num2&&num2>num3)) return false;

        }*/
        int cn=0;

        for(int i=1;i<nums.length-1;i++){

            if(nums[i-1]<=nums[i+1]&&(nums[i+1]<nums[i]||nums[i]<nums[i-1])){
                nums[i] = nums[i + 1];
                cn++;
            }else if(nums[i-1]>nums[i+1]){

                if(nums[i-1]<=nums[i]){
                    nums[i+1]=nums[i];
                    cn++;
                }else if(nums[i+1]>=nums[i]){
                    cn++;
                }

            }
            if(cn>1||(nums[i-1]>nums[i]&&nums[i]>nums[i+1])) return false;

        }


        return true;
    }


    public static void main(String[] args) {

        NonDecreasingArray array = new NonDecreasingArray();
        int []nums={2,3,3,2,4};//{-1,4,2,3};//
        System.out.println(array.checkPossibility(nums));




    }

}
