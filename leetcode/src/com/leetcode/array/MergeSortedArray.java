package com.leetcode.array;

public class MergeSortedArray {
    /*
        给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。
        初始化nums1 和 nums2 的元素数量分别为m 和 n 。你可以假设nums1 的空间大小等于m + n，这样它就
        有足够的空间保存来自 nums2 的元素。

        示例 1：

            输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
            输出：[1,2,2,3,5,6]
            示例 2：

            输入：nums1 = [1], m = 1, nums2 = [], n = 0
            输出：[1]
            提示：
            nums1.length == m + n
            nums2.length == n
            0 <= m, n <= 200
            1 <= m + n <= 200
            -109 <= nums1[i], nums2[i] <= 109
            链接：https://leetcode-cn.com/problems/merge-sorted-array
     */

    /**
     * 从头部开始，解决起来比较吃力
     * 从尾部解决解决
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       int p1=m-1,p2=n-1;
       int tail = m+n-1;
       int cur = 0;
       while (p2>=0){
           if(p1==-1){
               cur = nums2[p2--];
           }else if(nums1[p1]>nums2[p2]){
               cur = nums1[p1--];
           }else{
               cur = nums2[p2--];
           }
           nums1[tail--] =cur;
       }
    }

    /**
     * 空间复杂度O(m+n)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void mergeOptimize(int[] nums1, int m, int[] nums2, int n) {
        int [] ret = new int[m+n];
        int i=0,j=0,k=0;
        while(i<m || j<n){

            if(j==n){
                ret[k++] = nums1[i++];
            }else if(i==m){
                ret[k++] = nums2[j++];
            }else{
                if(nums1[i]>=nums2[j]){
                    ret[k++] = nums2[j++];
                }else{
                    ret[k++] = nums1[i++];
                }
            }
        }
        for(i=0;i<m+n;i++){
            nums1[i]=ret[i];
        }
    }
}
