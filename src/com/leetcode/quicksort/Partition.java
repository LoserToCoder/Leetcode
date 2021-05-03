package com.leetcode.quicksort;

public class Partition {


    private static  void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int findKthLargest(int[] nums, int k) {
        int pos = partition(nums, 0, nums.length - 1, nums.length - k);
        return nums[pos];
    }

    public static int partition(int[] nums, int left, int right,int k) {
        // 在区间随机选择一个元素作为标定点
        if (left<right) {
            int randomIndex = left+((right-left)>>1);
            swap(nums, left, randomIndex);
        }

        int pivot = nums[left];

        // 将等于 pivot 的元素分散到两边
        // [left, lt) <= pivot
        // (rt, right] >= pivot

        int lt = left + 1;
        int rt = right;

        while (lt<=rt) {
            while (lt <= rt && nums[lt] < pivot) {
                lt++;
            }
            while (lt <= rt && nums[rt] > pivot) {
                rt--;
            }

            if(lt<=rt){
                swap(nums, lt, rt);
                lt++;
                rt--;
            }
        }
        swap(nums, left, rt);
        if(rt<k){
            return partition(nums, rt + 1, right, k);
        }else if(rt>k){
            return partition(nums, left, rt - 1, k);
        }
        return rt;
    }
}
