package com.leetcode.backtrack;
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pos = -1;
        for(int i=n-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                pos = i-1;
                break;
            }
        }
        if(pos==-1){
            reverse(nums,0,n-1);
            return;
        }

        /**
         * 找到相对接近pos位置对应的值
         */
        for(int i=n-1;i>pos;i--){
            if(nums[i]>nums[pos]){
                swap(nums,i,pos);
                break;
            }
        }
        reverse(nums,pos+1,n-1);
    }

    /**
     * 倒序或者顺序的话，不用直接排序
     * @param nums
     * @param i
     * @param j
     */
    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    private void swap(int [] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
