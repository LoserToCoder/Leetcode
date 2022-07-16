package com.leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PathSumII {



    /**
     * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，
     * 找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
     * 叶子节点 是指没有子节点的节点。
     *
     *
     * 示例 1：
     * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
     * 输出：[[5,4,11,2],[5,8,4,5]]
     *
     * 示例 2：
     * 输入：root = [1,2,3], targetSum = 5
     * 输出：[]
     *
     * 示例 3：
     * 输入：root = [1,2], targetSum = 0
     * 输出：[]
     *
     * 提示：
     *
     * 树中节点总数在范围 [0, 5000] 内
     * -1000 <= Node.val <= 1000
     * -1000 <= targetSum <= 1000
     *
     * 链接：https://leetcode.cn/problems/path-sum-ii
     * @param root
     * @param targetSum
     * @return
     */

    //存储符合条件的集合
    private List<List<Integer>> result = new ArrayList<>();
    // 存储符合条件的节点元素
    private Deque<Integer> queue = new ArrayDeque<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root,targetSum);
        return result;
    }

    public void dfs(TreeNode node,int targetSum){
        if(node == null) return;
        targetSum = targetSum -node.val;
        queue.offer(node.val);
        if(node.left == null && node.right==null && targetSum==0){
            result.add(new ArrayList<>(queue));
        }
        dfs(node.left,targetSum);
        dfs(node.right,targetSum);
        //回溯
        queue.pollLast();
    }
}
