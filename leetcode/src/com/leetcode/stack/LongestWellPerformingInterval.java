package com.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LongestWellPerformingInterval {


    /***
     * 给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
     * 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
     * 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
     * 请你返回「表现良好时间段」的最大长度。
     * 示例 1：
     * 输入：hours = [9,9,6,0,6,6,9]
     * 输出：3
     * 解释：最长的表现良好时间段是 [9,9,6]。
     * 提示：
     * 1 <= hours.length <= 10000
     * 0 <= hours[i] <= 16
     * 链接：https://leetcode-cn.com/problems/longest-well-performing-interval
     * @param hours
     * @return
     */
    public int longestWPI(int[] hours) {


        int longest=0;

        int []scores=new int[hours.length+1];
        hours[0]=(hours[0]>8)?1:-1;
        for (int i=1;i<scores.length;i++){
            int score=hours[i-1]>8?1:-1;
            scores[i] = scores[i - 1] + score;
        }

        //递减栈
        Deque<Integer> s = new ArrayDeque<>();
        for (int i=0;i<scores.length;i++){

            if (!s.isEmpty() && scores[s.peek()] <= scores[i]) {
                continue;
            }
            s.push(i);
        }

        for (int i=scores.length-1;i>=0;i--){

            if(scores[i]>scores[s.peek()]){
                longest = Math.max(longest, i - s.peek());
                s.pop();i++;
                if(s.isEmpty()) break;
            }

        }
        return longest;
    }

    /**
     * 散列表
     * @param hours
     *
     * 算法思想:
     *     如果整个数组中,劳累天数永远大于不劳累的天数,那么最长的表现良好时间段就是整个数组
     *     否则: 在选中的最长表现良好时间段中,劳累时间永远比不劳累多一天
     *
     */
    public int longestWPIS(int[] hours) {

        Map<Integer, Integer> map = new HashMap<>();
        int sum=0,longest=0;

        for(int i=0;i<hours.length;i++){

            sum+=(hours[i]>8)?1:-1;

            if(sum>0) longest=i+1;
            else{

                //如果不存在设置,存在就不设置了
                map.putIfAbsent(sum, i);

                //劳累时间永远比不劳累多一天
                if(map.containsKey(sum-1)) longest = Math.max(longest, i - map.get(sum - 1));

            }

        }
        return longest;

    }

    public static void main(String[] args) {


        LongestWellPerformingInterval interval = new LongestWellPerformingInterval();

        int[] hours = {5, 6, 6, 9, 6, 9, 9};
        System.out.println(interval.longestWPI(hours));

    }
}
