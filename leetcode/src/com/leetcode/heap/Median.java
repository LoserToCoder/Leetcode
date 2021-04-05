package com.leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Median {

    /*
      数字是不断进入数组的，在每次添加一个新的数进入数组的同时返回当前新数组的中位数。
      说明
        中位数的定义：
        这里的中位数不等同于数学定义里的中位数。
        中位数是排序后数组的中间值，如果有数组中有n个数，则中位数为A[(n-1)/2]A[(n−1)/2]。
        比如：数组A=[1,2,3]的中位数是2，数组A=[1,19]的中位数是1。
        样例
        样例1

            输入: [1,2,3,4,5]
            输出: [1,1,2,2,3]
            样例说明：
            [1] 和 [1,2] 的中位数是 1.
            [1,2,3] 和 [1,2,3,4] 的中位数是 2.
            [1,2,3,4,5] 的中位数是 3.
        样例2

            输入: [4,5,1,3,2,6,0]
            输出: [4,4,4,3,3,3,3]
            样例说明：
            [4], [4,5] 和 [4,5,1] 的中位数是 4.
            [4,5,1,3], [4,5,1,3,2], [4,5,1,3,2,6] 和 [4,5,1,3,2,6,0] 的中位数是 3.
      https://www.lintcode.com/problem/find-median-from-data-stream/
     */

    public int[] medianII(int[] nums) {
        if(nums==null||nums.length<1){
            return null;
        }
        int[] ret = new int[nums.length];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return y-x;
            }
        });
        ret[0] = nums[0];
        maxHeap.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            int cur = maxHeap.peek();
            if(nums[i]<=cur){
                maxHeap.add(nums[i]);
            }else{
                minHeap.add(nums[i]);
            }
            if(maxHeap.size()>minHeap.size()+1){
                minHeap.add(maxHeap.poll());
            }else if(maxHeap.size()<minHeap.size()){
                maxHeap.add(minHeap.poll());
            }
            ret[i] = maxHeap.peek();
        }
        return ret;
    }

}
