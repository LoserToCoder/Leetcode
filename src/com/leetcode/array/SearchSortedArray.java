package com.leetcode.array;

public class SearchSortedArray {

    /*
    已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
    在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，
    使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
    （下标 从 0 开始 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
    给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。
    如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。

    示例1：

    输入：nums = [2,5,6,0,0,1,2], target = 0
    输出：true
    示例2：

    输入：nums = [2,5,6,0,0,1,2], target = 3
    输出：false

    链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii

     */

    public boolean search(int[] nums, int target) {
        if(nums==null||nums.length<1){
            return false;
        }
        int lb=0,rb=nums.length-1;
        while (lb<=rb){
            int mid = lb+((rb-lb)>>1);

            if(nums[mid]==target){
                return true;
            }

            if(nums[mid]==nums[lb]){
                lb++;
                continue;
            }

            //前半段有序
            if(nums[mid]>nums[lb]){

                if(nums[lb]<=target&&target<nums[mid]){
                    rb = mid-1;
                }else {
                    lb = mid+1;
                }
            }else {//后半段有序
                if(nums[mid]<target&&target<=nums[rb]){
                    lb =mid+1;
                }else{
                    rb =mid-1;
                }
            }
        }
        return false;
    }

    /**
     * 搜索旋转数组。给定一个排序后的数组，包含n个整数，但这个数组已被旋转过很多次了，次数不详。
     * 请编写代码找出数组中的某个元素，假设数组元素原先是按升序排列的。若有多个相同元素，返回索引值最小的一个。
     * <p>
     * 示例1:
     * 输入: arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 5
     * 输出: 8（元素5在该数组中的索引）
     * 示例2:
     * 输入：arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 11
     * 输出：-1 （没有找到）
     * 提示:
     * arr 长度范围在[1, 1000000]之间
     */
    public int searchV2(int[] nums,int target) {

        int mid = peakIndex(nums);

        int index = search(0, mid, nums,target);
        if (index != -1) {
            return index;
        }
        return search(mid + 1, nums.length - 1, nums, target);
    }

    public int peakIndex(int [] nums) {

        int l=0, r = nums.length-1;

        while (l < r) {

            int mid = l+((r-l)>>1);


            if(nums[mid] > nums[l]) {
                l = mid;
            } else if(nums[mid]< nums[l]) {
                r = mid-1;
            } else {
                l++;
            }
        }
        return l;
    }

    public int search(int l,int r,int [] nums,int target){

        if (l > r) {
            return -1;
        }

        while (l < r) {

            int mid = l + ((r - l) >> 1);
            if (nums[mid] > target) {
                r = mid-1;
            } else if (nums[mid] == target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        if (nums[l] == target) {
            return l;
        }
        return -1;
    }


    public static void main(String[] args) {


        int i = new SearchSortedArray().searchV2(new int[]{1,1,1,1,1,2,1,1,1
}, 2);
        System.out.println(i);

    }





}
