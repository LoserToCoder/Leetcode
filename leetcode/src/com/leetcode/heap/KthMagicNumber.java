package com.leetcode.heap;

import java.util.PriorityQueue;

public class KthMagicNumber {

    /*
    有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，
    而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。

    示例 1:
    输入: k = 5
    输出: 9

    链接：https://leetcode-cn.com/problems/get-kth-magic-number-lcci
     */

    /**
     * 动态规划做法
     * @param k
     * @return
     */
    public int getKthMagicNumber(int k) {
        int[] dp = new int[k];
        dp[0]=1;
        int i3=0,i5=0,i7=0;
        for(int i=1;i<k;i++){
            int a3 = dp[i3]*3,a5= dp[i5]*5,a7=dp[i7]*7;
            dp[i] = Math.min(a3, Math.min(a5, a7));
            if(a3==dp[i]) i3++;
            if(a5==dp[i]) i5++;
            if(a7==dp[i]) i7++;
        }
        return dp[k-1];
    }


    public int getKthMagicNumberByHeap(int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(1L);
        for(int i=1;i<k;i++){

            long val = pq.poll();
            while (!pq.isEmpty()&&pq.peek()==val){//纯数值比较切记引用比较等值问题
                pq.poll();
            }
            pq.add(3*val);
            pq.add(5*val);
            pq.add(7*val);
        }
        return pq.peek().intValue();
    }

    public static void main(String[] args) {
        new KthMagicNumber().getKthMagicNumberByHeap(6);
    }
}
