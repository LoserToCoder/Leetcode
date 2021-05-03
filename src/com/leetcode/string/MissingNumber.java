package com.leetcode.string;

public class MissingNumber {
    /*
    一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
    在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
    示例 1:

    输入: [0,1,3]
    输出: 2
    示例2:

    输入: [0,1,2,3,4,5,6,7,9]
    输出: 8
    链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
     */

    /**
     * 循环结束的条件：
     * 「lb<=rb」mid要移动，不然会走死循环
     * 「lb<rb」mid不需要都移动
     * @param nums
     * @return
     */
    public int missingNumberByBinarySearch(int [] nums){
        int lb =0,rb=nums.length-1;
        while (lb<=rb){
            int mid =lb+((rb-lb)>>1);
            if(nums[mid]==mid){
                lb=mid+1;
            }else{
                rb=mid-1;
            }
        }
        return lb;
    }

    /**
     * 异或思想求解
     * @param nums
     * @return
     */
    public int missingNumberByXor(int [] nums){

        int xor = 0;
        for(int i=0;i<nums.length;i++){
            xor ^= nums[i]^i;
        }
        return xor^nums.length;
    }

    /**
     *求和思想：
     *  为避免求和溢出的问题,所以取差值
     */
    public int missingNumber(int[] nums) {
        int len = nums.length;
        if(nums[0]!=0){
            return 0;
        }else if(nums[len-1]!=len){
            return len;
        }
        int missVal =0;
        for(int i=0;i<len-1;i++){
            int diff=nums[i+1]-nums[i];
            if(diff>1){
                missVal=nums[i]+1;
                break;
            }
        }
        return missVal;
    }
}
