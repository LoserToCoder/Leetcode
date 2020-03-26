package com.leetcode.test;
public class Test {


    /**
     * Exception
     *  RuntimeException:
     *     IllegalArgumentException
     *     NullPointerException
     *     ClassCastException
     *     ArithmeticException
     *     IndexOutOfBoundsException
     */

    public static void main(String[] args) {

        //FutureTask
        //ThreadPoolExecutor
        //CompletableFuture
       StringBuilder sb = new StringBuilder();
        sb.append("@@@@@");
        System.out.println(sb.toString());
        sb.delete(0, sb.length()-1);
        System.out.println(sb.toString());
        Test test = new Test();
        int []nums={16,16,18,24,30,32};
        int target=48;
        for(int num:nums){
            int idx = test.binarySearch(target - num, nums);
            System.out.println(idx);
        }


    }

    private int binarySearch(int key,int []nums){

        int low=0;
        int high=nums.length-1;
        while(low<high){
            int mid=((high-low)>>1)+low;

            if(key>nums[mid]){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        return nums[low]==key?low:-1;
    }


}
