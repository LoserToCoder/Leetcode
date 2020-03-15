package com.leetcode.doublespoints;

import java.util.*;

public class ThreeSumClosest {


    /**
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
     * 找出 nums 中的三个整数，使得它们的和与 target 最接近。
     * 返回这三个数的和。假定每组输入只存在唯一答案。
     * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
     * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2)
     * 链接：https://leetcode-cn.com/problems/3sum-closest
     * @param nums
     * @param target
     * @return
     */
   /* private int closestSum=0;
    public int threeSumClosest(int[] nums, int target) {

        init(nums);
        List<Integer> s = new ArrayList<>();
        backtrack(0,target,nums,s);
        return closestSum;
    }

    private void init(int[] nums) {
        closestSum = nums[0] + nums[1] + nums[2];
    }


    public void backtrack(int pos, int target,int[]nums,List<Integer> s){

        if(s.size()==3){
            int p0=s.get(s.size()-1),p1=s.get(s.size()-2),p2=s.get(s.size()-3);
            int sum=p0+p1+p2;
            if(Math.abs(sum-target)<Math.abs(closestSum-target)){
                closestSum=sum;
            }
            return;
        }

        for(int i=pos;i+3-s.size()<=nums.length;i++){
            s.add(nums[i]);
            backtrack(i + 1, target, nums, s);
            s.remove(s.size()-1);
        }



    }*/

    public int threeSumClosest(int[]nums,int target){

        Arrays.sort(nums);//先对数组排序

        int closestSum = nums[0] + nums[1] + nums[2];

        for(int i=0;i<nums.length;i++){

            int p0=i+1,p1=nums.length-1;


            while (p0<p1){

                //固定某个元素,然后使用两个指针来移动,找出符合条件的
                int sum = nums[i] + nums[p0] + nums[p1];

                if (Math.abs(target - closestSum) < Math.abs(target - sum)) {
                    closestSum=sum;
                }

                if(sum>target){
                    p1--;
                }else if(sum<target){
                    p0++;
                }else {
                    return closestSum;
                }
            }
        }

        return closestSum;
    }


    public static void main(String[] args) {


        ThreeSumClosest closest = new ThreeSumClosest();
        int target=1;
        int []nums={-1,2,1,-4};
        int sum = closest.threeSumClosest(nums, target);

        System.out.println(sum);


    }
}
