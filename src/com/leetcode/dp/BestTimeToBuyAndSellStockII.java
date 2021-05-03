package com.leetcode.dp;

public class BestTimeToBuyAndSellStockII {


    public int maxProfit(int[] prices) {
    	if(prices==null||prices.length<1) return 0;
    	int res=0;
        for (int i = 1,diff=0; i < prices.length; i++) {
            diff=prices[i]-prices[i-1];
            if(diff>0){
               res+=diff;
            }
        }
        return res;
    }
}
