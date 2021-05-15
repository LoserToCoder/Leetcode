package com.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSets {

    /**
     * 给你一个整数数组nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     * <p>
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * 示例 2：
     * <p>
     * 输入：nums = [0]
     * 输出：[[],[0]]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 10
     * -10 <= nums[i] <= 10
     * nums 中的所有元素 互不相同
     * <p>
     * 链接：https://leetcode-cn.com/problems/subsets
     *
     * @param nums
     * @return
     */

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(results,new ArrayList<Integer>(),nums,0);
        return results;
    }

    private void backtrack(List<List<Integer>> results,List<Integer> sub,int []nums,int i){
        if(i==nums.length){
            results.add(new ArrayList<>(sub));
            return;
        }
        sub.add(nums[i]);//选择
        backtrack(results,sub,nums,i+1);
        sub.remove(sub.size() - 1);
        //不选择
        backtrack(results,sub,nums,i+1);
    }


    private List<List<Integer>> results = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(new ArrayList<>(),nums,0);
        return results;
    }

    private void backtrack(List<Integer> sub,int []nums,int i){

        if(i>=nums.length){
            results.add(new ArrayList<>(sub));
            return;
        }
        sub.add(nums[i]);
        backtrack(sub,nums,i+1);
        sub.remove(sub.size() - 1);
        while (i+1<nums.length&&nums[i]==nums[i+1]){
            i++;
        }
        backtrack(sub,nums,i+1);
    }

    public static void main(String[] args) {
        new SubSets().subsetsWithDup(new int[]{1, 2, 3, 2});
        /**
         *
         [[1,2,2,3],[1,2,2],[1,2,3],[1,2],[1,3],[1],
          [2,2,3],[2,2],[2,3],[2],
           [3],[]]
         */
    }
}
