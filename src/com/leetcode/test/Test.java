package com.leetcode.test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class Test {


    /**
     * Exception
     *  RuntimeException:
     *     IllegalArgumentException
     *     NullPointerException
     *     ClassCastException
     *     ArithmeticException
     *     IndexOutOfBoundsException
     */

    public static void main(String[] args) {

        //FutureTask
        //ThreadPoolExecutor
        //CompletableFuture

        System.out.println('a'!=' ');

    }


    public boolean judgeSquareSum(int c) {

        int n =(int)Math.sqrt(c);
        for(int i=n;i>=1;i--){

            int v = c-i*i;
            if(v==0||isSquare(v)){
                return true;
            }
        }
        return false;
    }

    public boolean isSquare(int v){
        int k = (int) Math.sqrt(v);
        return k*k ==v;
    }

    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<heights.length;i++){

            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {

                int j = stack.pop();
                if(stack.isEmpty()){
                    ans = Math.max(ans,i*heights[j]);
                }else{
                    ans = Math.max(ans, (i - stack.peek() - 1) * heights[j]);
                }
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){

            int j = stack.pop();
            if(stack.isEmpty()){
                ans = Math.max(ans, heights[j] * heights.length);
            }else{
                ans = Math.max(ans, (heights.length- stack.peek() - 1) * heights[j]);
            }
        }
        return ans;
    }

    public int[] smallestK(int[] arr, int k) {
        if(arr==null||arr.length<k){
            return arr;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k,(p,q)->{return q - p;});
        for(int element:arr){

            if (priorityQueue.size() < k) {
                priorityQueue.offer(element);
            }else{
                if(element< priorityQueue.peek()){
                    priorityQueue.poll();
                    priorityQueue.offer(element);
                }
            }
        }
        int[] ret = new int[k];
        for(int i=0;i<k;i++){
            ret[i] = priorityQueue.poll();
        }
        return ret;
    }

}
