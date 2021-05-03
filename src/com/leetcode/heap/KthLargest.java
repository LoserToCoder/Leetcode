package com.leetcode.heap;

import java.util.PriorityQueue;

public class KthLargest {

    /**
     * 使用小根堆
     * 其他思路:可以使用快速排序思想找到Array.Length-k索引的位置的元素
     *
     * @param nums
     * @param k
     * @return
     */

    private PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n1 - n2);

    private int k;
    public KthLargest(int k, int[] nums) {
         this.k=k;
         for(int n:nums){
             adjustHeap(n);
         }
    }

    private void adjustHeap(int val){
        pq.add(val);
        if(pq.size()>k){
            pq.poll();
        }
    }

    public int add(int val) {
        adjustHeap(val);
        return pq.peek();
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((n1,n2)-> n1-n2);
        for(int n:nums){
            pq.add(n);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        /*int[] nums = {3, 2, 1, 5, 6, 4};
        int k=4;*/
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k=4;

    }
}
