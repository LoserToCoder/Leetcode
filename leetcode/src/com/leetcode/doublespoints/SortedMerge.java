package com.leetcode.doublespoints;

public class SortedMerge {


    /**
     * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。
     * 编写一个方法，将 B 合并入 A 并排序。
     * 初始化 A 和 B 的元素数量分别为 m 和 n。
     * 示例:
     * 输入:
     * A = [1,2,3,0,0,0], m = 3
     * B = [2,5,6],       n = 3
     *
     * 输出: [1,2,2,3,5,6]
     * 链接：https://leetcode-cn.com/problems/sorted-merge-lcci
     * @param A
     * @param m
     * @param B
     * @param n
     * 第一种解法是: 声明一个中间数组  牺牲空间
     * public void merge(int[]A,int m,int[]B,int n){
     *         if(n==0) return;
     *         int []C=new int[m+n];
     *         int p=0,q=0,r=0;
     *         while(p<m||q<n){
     *             int temp;
     *             if(p==m){
     *                 C[r++]=B[q++];
     *             }else if(q==n){
     *                 C[r++]=A[p++];
     *             }else if(A[p]>B[q]){
     *                 C[r++]=B[q++];
     *             }else{
     *                 C[r++]=A[p++];
     *             }
     *         }
     *         for(int i=0;i<r;i++){
     *             A[i]=C[i];
     *         }
     *     }
     *  第二种解法:不损耗空间的,因为直接正向遍历 使用双指针解法,程序会很复杂,逆向遍历并合并数组
     *
     *  总结:正常思路解决问题非常繁琐时候，可以逆向考虑一下问题的解法
     *   public void merge(int[]A,int m,int[]B,int n){
     *         if(n<=0) return;
     *         int t=m+n-1;
     *         int p=m-1;
     *         int q=n-1;
     *         while (p>=0||q>=0){
     *
     *             if(m<=0){
     *                 A[t--]=B[q--];
     *             }else if(n<=0){
     *                 A[t--]=A[p--];
     *             }else if(A[p]>B[q]){
     *                 A[t--] = B[q--];
     *             }else {
     *                 A[t--] = A[p--];
     *             }
     *         }
     *     }
     *
     */
    public void merge(int[]A,int m,int[]B,int n){
        if(n<=0) return;
        int t=m+n-1;
        int p=m-1;
        int q=n-1;
        while (p>=0||q>=0){

            if(p<0){
                A[t--]=B[q--];
            }else if(q<0){
                A[t--]=A[p--];
            }else if(A[p]>B[q]){
                A[t--] = B[q--];
            }else {
                A[t--] = A[p--];
            }
        }
    }
}
