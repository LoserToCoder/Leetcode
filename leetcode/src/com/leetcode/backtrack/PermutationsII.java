package com.leetcode.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PermutationsII {


    private List<List<Integer>> permutes = new LinkedList<>();

    /**
     * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
     * 示例:
     * 输入: [1,1,2]
     * 输出:
     * [
     *   [1,1,2],
     *   [1,2,1],
     *   [2,1,1]
     * ]
     * 链接：https://leetcode-cn.com/problems/permutations-ii
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n=nums.length;
        backtrack(nums,new ArrayList<>(n),new boolean[n]);
        return permutes;
    }

    private void backtrack(int []nums,List<Integer> s,boolean[]visited){

        if(s.size()>=nums.length){
            permutes.add(new ArrayList<>(s));
            return;
        }

        for(int i=0;i<nums.length;i++){

            if(visited[i]) continue;
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if(i>0&&nums[i]==nums[i-1]&&!visited[i-1]) continue;
            s.add(nums[i]);
            visited[i]=true;
            backtrack(nums,s,visited);
            visited[i]=false;
            s.remove(s.size() - 1);

        }

    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 2,2,3};

        PermutationsII permutationsII = new PermutationsII();
        System.out.println(permutationsII.permuteUnique(nums));
    }

}
