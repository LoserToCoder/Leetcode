package com.leetcode.backtrack;

import java.util.LinkedList;
import java.util.List;

public class Permutation {


    private List<List<Integer>> permutes = new LinkedList<>();

    /**
     * 给定一个没有重复数字的序列，返回其所有可能的全排列。
     * 示例:
     * 输入: [1,2,3]
     * 输出:
     * [
     *   [1,2,3],
     *   [1,3,2],
     *   [2,1,3],
     *   [2,3,1],
     *   [3,1,2],
     *   [3,2,1]
     * ]
     * 链接：https://leetcode-cn.com/problems/permutations
     * @param nums
     * @return
     */

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new LinkedList<>(),new boolean[nums.length]);
        return permutes;
    }


    public void backtrack(int[]nums,LinkedList<Integer> seg,boolean[]visited){

        if(seg.size()>=nums.length){
            permutes.add(new LinkedList<>(seg));
            return;
        }
        for(int i=0;i<nums.length;i++){

            if(visited[i]) continue;
            seg.add(nums[i]);
            visited[i]=true;
            backtrack(nums,seg,visited);
            visited[i]=false;
            seg.removeLast();
        }


    }
    public static void main(String[] args) {

        int[] nums = {1, 2, 3,4,5,6,7,8,9};
        Permutation permutation = new Permutation();
        System.out.println(permutation.permute(nums).size());

    }

}
