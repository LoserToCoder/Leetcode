package com.leetcode.dp;


import java.util.concurrent.ThreadPoolExecutor;

public class CoinChange {


    public int coinChange(int[] coins, int amount) {

        if(amount==0||coins==null||coins.length<1){
            return 0;
        }
        int[][] dp = new int[coins.length][amount+1];
        for(int i=1;i<=amount;i++){

            for(int j=0;j<coins.length;j++){


            }

        }
        return dp[coins.length-1][amount];

    }

    public static void main(String[] args) {

        //ThreadPoolExecutor

    }
}
