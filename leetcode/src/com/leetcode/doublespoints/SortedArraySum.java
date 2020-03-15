package com.leetcode.doublespoints;

public class SortedArraySum {


    /**
     * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
     * 如果有多对数字的和等于s，则输出任意一对即可。
     * 示例 1：
     *
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[2,7] 或者 [7,2]
     * 示例 2：
     *
     * 输入：nums = [10,26,30,31,47,60], target = 40
     * 输出：[10,30] 或者 [30,10]
     * 限制：
     * 1 <= nums.length <= 10^5
     * 1 <= nums[i] <= 10^6
     * 链接：https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof
     * @param nums
     * @param target
     * @return
     * 思路1:  使用HashSet解决
     *   public int[] twoSum(int[] nums, int target) {
     *         Set<Integer> map=new HashSet<>();
     *
     *         for(int num:nums){
     *             if(map.contains(target-num)){
     *                 return new int[]{target-num,num};
     *             }
     *             map.add(num);
     *         }
     *         throw new IllegalArgumentException("不合法参数");
     *     }
     *  时间复杂度O(n) 空间复杂度是O(n)
     *
     * 思路二:
     *   由于数组是有序的使用二分法
     *   public int[] twoSum(int[] nums, int target) {
     *
     *        for(int num:nums){
     *            int idx=binarySearch(target-num,nums);
     *            if(idx!=-1){
     *                return new int[]{num,target-num};
     *            }
     *        }
     *        throw new IllegalArgumentException("不合法参数");
     *
     *     }
     *
     *     private int binarySearch(int key,int []nums){
     *
     *        int low=0;
     *        int high=nums.length-1;
     *        while(low<=high){
     *            int mid=((high-low)>>1)+low;
     *
     *            if(key>nums[mid]){
     *                low=mid+1;
     *            }else if(key<nums[mid]){
     *                high=mid-1;
     *            }else{
     *                return mid;
     *            }
     *        }
     *        return -1;
     *     }
     *     时间复杂度是O(nlogn) 空间复杂度O(1)
     *
     *  思路三:  使用双指针  head头指针,tail尾指针
     *
     *           sum=num[head]+num[tail];
     *           如果此值大于target值,需要往增加的方向去,需要往左走,即tail--
     *           如果辞职小于target值,需要往增减的方向去,需要往右走,即head++
     *           否则就是刚好等于
     *      时间复杂度是O(n) 空间复杂度O(1)
     *
     */
    public int[] twoSum(int[] nums, int target) {

        int head=0;
        int tail=nums.length-1;

        while(head<tail){

            int sum=nums[head]+nums[tail];
            if(sum==target){
                return new int[]{nums[head],nums[tail]};
            }else if(sum<target){
                head++;
            }else{
                tail--;
            }
        }
        throw new IllegalArgumentException("不合法参数");

    }

}
