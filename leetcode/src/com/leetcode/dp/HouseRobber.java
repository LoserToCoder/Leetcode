package com.leetcode.dp;

public class HouseRobber {

   /*
       你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素
       就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
       给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
        示例 1:
                    输入: [1,2,3,1]
                    输出: 4
                    解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
                    偷窃到的最高金额 = 1 + 3 = 4 。
        示例 2:
                    输入: [2,7,9,3,1]
                    输出: 12
                    解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
                    偷窃到的最高金额 = 2 + 9 + 1 = 12 。
                    链接：https://leetcode-cn.com/problems/house-robber
    */

    /**
     *  robs : 动态规划其中一种方式:自底向上方式求解
     * @param nums
     * @return
     */
   public int robs(int[] nums) {
       if (nums == null || nums.length == 0) return 0;
       //dp[i][0] 不打劫i最多可以拿多少钱
       //dp[i][1] 打劫i最多可以拿多少钱
       int[][] dp = new int[nums.length][2];
       dp[0][0] = 0;
       dp[0][1] = nums[0];
       for (int i = 1; i < nums.length; i++) {
           dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
           dp[i][1] = dp[i-1][0] + nums[i];
       }
       return Math.max(dp[dp.length - 1][0], dp[dp.length - 1][1]);
   }

    /***
     *  rob:动态规划自顶向下方式求解
     * @param nums
     * @return
     */
    public  int rob(int []nums){
        int []results=new  int[nums.length];
        for(int i=0;i<nums.length;i++)
              results[i]=-1;
        return  resolveDp(nums.length-1,nums,results);
    }
    public int resolveDp(int idx,int []nums,int []results){
        if(idx<0) return 0;
        if(results[idx]!=-1)
            return  results[idx];
        results[idx]=Math.max(resolveDp(idx-2,nums,results)+nums[idx],resolveDp(idx-1,nums,results));
        return  results[idx];
    }
    public static void main(String[] args) {
        int []nums={2,7,9,3,1};
        HouseRobber rob = new HouseRobber();
        int ret = rob.robs(nums);
        System.out.println(ret);
    }



}
