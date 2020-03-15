package com.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum{

    /***
     给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     candidates 中的数字可以无限制重复被选取。
     说明：
         所有数字（包括 target）都是正整数。
         解集不能包含重复的组合。 
         示例 1:
         输入: candidates = [2,3,6,7], target = 7,
         所求解集为:
         [[7],[2,2,3]]
         示例 2:
         输入: candidates = [2,3,5], target = 8,
         所求解集为:
         [[2,2,2,2],[2,3,3],[3,5]]

     链接：https://leetcode-cn.com/problems/combination-sum
     */
    /**
     * 注意事项:
     * 首先是candidates序列的是否有序的问题?
     * 其次是每次进行回溯时List<Integer>是引用类型,不能使用同一个,需要另外重新一个副本
     * 对于传递进来的参数尽量不要去做修改
     */
    private List<List<Integer>> combinations = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> sub=new ArrayList<>();
        Arrays.sort(candidates);
        dfs(sub,0,target,candidates);
        return combinations;
    }
    public void dfs(List<Integer> sub,int level,int target,int[]candidates){
        if(target==0){
            combinations.add(sub);
            return;
        }
        for(int i=level;i<candidates.length;i++){
            if(target<candidates[i]) break;
            List<Integer> list=new ArrayList<>(sub);
            list.add(candidates[i]);
            dfs(list,i,target-candidates[i],candidates);
        }
    }

    public static void main(String[] args) {

        CombinationSum combinationSum = new CombinationSum();
        int[]candidates ={2,3,5};
        int target = 7;
        List<List<Integer>> lists = combinationSum.combinationSum(candidates, target);
        for(List<Integer> item:lists){
            System.out.println(item);
        }

    }

}