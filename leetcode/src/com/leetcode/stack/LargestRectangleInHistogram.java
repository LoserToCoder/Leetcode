package com.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Map;

public class LargestRectangleInHistogram {


    /**
     * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。
     * 每个柱子彼此相邻，且宽度为 1 .
     * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
     * https://leetcode-cn.com/problems/largest-rectangle-in-histogram
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {


        int max=0;
        ArrayDeque<Integer> s = new ArrayDeque<>();
        s.push(-1);
        /**
         * 算法思路是:
         *   栈中存储递增序列,当滑过某一个元素时,查看栈顶元素是否大于当前元素,如果大于则
         *   出栈,计算栈顶元素,到下一个元素之间的距离,长度,计算面积
         *   继续遍历,直至当前的栈顶元素小于或等于当前滑过的窗口元素
         */
        for(int i=0;i<heights.length;i++){
            while (s.peek()!=-1&&heights[s.peek()]>heights[i])
                max = Math.max(max, heights[s.pop()] * (i - 1 - s.peek()));
            s.push(i);
        }
        while (s.peek()!=-1) {
            max = Math.max(max, heights[s.pop()] * (heights.length - 1 - s.peek()));
        }
        return max;

    }

    public static void main(String[] args) {

        LargestRectangleInHistogram histogram = new LargestRectangleInHistogram();
        int[] heights = {2,2};
        System.out.println(histogram.largestRectangleArea(heights));

    }
}
