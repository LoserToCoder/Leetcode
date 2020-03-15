package com.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CombinationSumIII {
    /**
     * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，
     * 并且每种组合中不存在重复的数字。
     * 说明：
     * 所有数字都是正整数。
     * 解集不能包含重复的组合。 
     * 示例 1:
     * 输入: k = 3, n = 7
     * 输出: [[1,2,4]]
     * 示例 2:
     * 输入: k = 3, n = 9
     * 输出: [[1,2,6], [1,3,5], [2,3,4]]
     * 链接：https://leetcode-cn.com/problems/combination-sum-iii
     *
     * @param k
     * @param n
     * @return
     */

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        Stack<Integer> s=new Stack<>();
        backtrack(k,1,n,s,combinations);
        return combinations;
    }

    public void backtrack(int k, int pos, int target, Stack<Integer> s,List<List<Integer>> combinations){

        if(k<s.size()||target<0) return;
        if(k==s.size()&&target==0){
            combinations.add(new ArrayList<>(s));
            return;
        }
        for(int i=pos;i<=9;i++) {
            if (target<i) break;
            s.push(i);
            backtrack(k, i + 1, target - i, s,combinations);
            s.pop();
        }
    }
    public static void main(String[] args) {

        CombinationSumIII sumIII = new CombinationSumIII();
        for(int i=1;i<=100;i++){
            List<List<Integer>> lists = sumIII.combinationSum3(4, i);
            System.out.println(lists);
        }

    }
}
