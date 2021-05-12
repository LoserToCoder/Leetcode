package com.leetcode.test;

import java.util.*;

public class Test {


    /**
     * Exception
     * RuntimeException:
     * IllegalArgumentException
     * NullPointerException
     * ClassCastException
     * ArithmeticException
     * IndexOutOfBoundsException
     */

    public static void main(String[] args) {

        //FutureTask
        //ThreadPoolExecutor
        //CompletableFuture
        System.out.println("车主现金劵是激励车主接单的一种营销方式,同时也是公司倡导低碳生活方式. 共享更多的车位减少排放量,车主通过参见活动或者接单达标得到相应的现金劵,然后现金劵激活后,可在符合条件的行程订单中核销.".length());

    }

    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        Map<String, Integer> map = new HashMap<>();

        for(int i=0;i+10<=len;i++){
            String sub = s.substring(i,i+10);
            map.put(sub, map.getOrDefault(sub, 0) + 1);
        }
        List<String> ret = new ArrayList<>();
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            if(entry.getValue()>1){
                ret.add(entry.getKey());
            }
        }
        return ret;
    }


    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {

            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {

                int j = stack.pop();
                if (stack.isEmpty()) {
                    ans = Math.max(ans, i * heights[j]);
                } else {
                    ans = Math.max(ans, (i - stack.peek() - 1) * heights[j]);
                }
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {

            int j = stack.pop();
            if (stack.isEmpty()) {
                ans = Math.max(ans, heights[j] * heights.length);
            } else {
                ans = Math.max(ans, (heights.length - stack.peek() - 1) * heights[j]);
            }
        }
        return ans;
    }

    public int[] smallestK(int[] arr, int k) {
        if (arr == null || arr.length < k) {
            return arr;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, (p, q) -> {
            return q - p;
        });
        for (int element : arr) {

            if (priorityQueue.size() < k) {
                priorityQueue.offer(element);
            } else {
                if (element < priorityQueue.peek()) {
                    priorityQueue.poll();
                    priorityQueue.offer(element);
                }
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = priorityQueue.poll();
        }
        return ret;
    }

}
