package com.leetcode.doublespoints;

import com.leetcode.utils.StringUtils;

public class SortColors {


    /***
     * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，
     * 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     * 注意:
     * 不能使用代码库中的排序函数来解决这道题。
     * 示例:
     * 输入: [2,0,2,1,1,0]
     * 输出: [0,0,1,1,2,2]
     * 进阶：
     * 一个直观的解决方案是使用计数排序的两趟扫描算法。
     * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
     * 你能想出一个仅使用常数空间的一趟扫描算法吗？
     * 链接：https://leetcode-cn.com/problems/sort-colors
     * @param nums
     *
     * 算法: 由于颜色分为三种0,1,2 其中 0和2处于两端
     * 使用l代表左边的,r代表右边  当遍历元素时候,
     * 如果当前元素等于0,需要将l指定的值和cur指针指定的值进行交换值,并且l指针往前移动一个位置
     * 如果当前元素等于2.需要将r指定的值和cur指针指定的值进行交换值,并且r指针往后退一步
     * 如果等于1,只需要移动cur指针即可
     *
     */
    public void sortColors(int[] nums) {

        int l=0,r=nums.length-1;
        int cur=0;
        while (cur <= r) {


            int temp=nums[cur];
            if(nums[cur]==0){
                nums[cur++] = nums[l];
                nums[l++]=temp;
            }else if(nums[cur]==2){

                nums[cur] = nums[r];
                nums[r--] = temp;
            }else {
                cur++;
            }
        }

    }




    public static void main(String[] args) {


        SortColors sortColors = new SortColors();
        int[] nums = {2, 0, 2, 1, 1, 0};

        System.out.println(StringUtils.arrayToString(nums));

        sortColors.sortColors(nums);

        System.out.println(StringUtils.arrayToString(nums));

    }
}
