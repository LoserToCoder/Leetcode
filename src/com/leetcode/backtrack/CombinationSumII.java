package com.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CombinationSumII {

    /***
     给定一个数组candidates和一个目标数target，找出candidates中所有可以使数字和为target
     的组合。candidates中的每个数字在每个组合中只能使用一次。
     说明：
     所有数字（包括目标数）都是正整数。
     解集不能包含重复的组合。
     示例1:
         输入: candidates =[10,1,2,7,6,1,5], target =8,
         所求解集为:
         [[1, 7],[1, 2, 5],[2, 6],[1, 1, 6]]
     示例2:
         输入: candidates =[2,5,2,1,2], target =5,
         所求解集为:
         [[1,2,2],[5]]
         链接：https://leetcode-cn.com/problems/combination-sum-ii
     * @param candidates
     * @param target
     * @return
     */
    private List<List<Integer>> combination = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
         Arrays.sort(candidates);//对candidates进行排序,使得剪枝更加方便
         Stack<Integer> stack = new Stack<>();//
         backtrack(candidates,target,0,stack);
         return combination;
    }
    public void backtrack(int[]candidates,int target,int i,Stack<Integer> stack){
        if(target==0){
            combination.add(new ArrayList<>(stack));
            return;
        }
        for(int j=i;j<candidates.length;j++){
            if(target<candidates[j]) break;//剪枝操作
            if(j>i&&candidates[j-1]==candidates[j])
                continue;
                /**
                 * 回溯(递归)+剪枝
                 * 1. 减少重复
                 * 2. 减少已经有的解或这个路径没有解
                 * */

            stack.push(candidates[j]);
            backtrack(candidates,target-candidates[j],j+1,stack);
            stack.pop();
        }
    }
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
       // int []candidates = {2,5,2,1,2};int target = 5;

        CombinationSumII sum = new CombinationSumII();
        List<List<Integer>> lists = sum.combinationSum2(candidates, target);
        for(List<Integer> list:lists){
            System.out.println(list);
        }
    }

}
