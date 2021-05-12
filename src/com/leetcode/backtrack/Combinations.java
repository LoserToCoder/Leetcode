package com.leetcode.backtrack;

import java.util.*;

public class Combinations {


    /**
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     *
     * 示例:
     *
     * 输入:n = 4, k = 2
     * 输出:
     * [
     *   [2,4],
     *   [3,4],
     *   [2,3],
     *   [1,2],
     *   [1,3],
     *   [1,4],
     * ]
     * 链接：https://leetcode-cn.com/problems/combinations
     */
    private List<List<Integer>> results = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, k, 1,new Stack<Integer>());
        return results;
    }

    private void backtrack(int n, int k, int pos,List<Integer> sub){

        if(k==sub.size()){
            results.add(new ArrayList<>(sub));
            return;
        }
        for(int i=pos;i<=n-(k-1-sub.size());i++){
            sub.add(i);
            backtrack(n, k, i + 1, sub);
            sub.remove(sub.size() - 1);
        }
    }

    public static void main(String[] args) {

        Combinations combinations = new Combinations();
        List<List<Integer>> combine = combinations.combine(4, 2);
        System.out.println(combine);


    }
}
