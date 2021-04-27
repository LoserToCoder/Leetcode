package com.leetcode.test;

import java.util.ArrayDeque;
import java.util.Deque;

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


}
