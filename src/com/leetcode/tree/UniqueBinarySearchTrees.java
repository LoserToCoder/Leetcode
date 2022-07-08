package com.leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UniqueBinarySearchTrees {


    /***
     * 不同的二叉搜索树 II
     * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。
     * 可以按 任意顺序 返回答案。
     *
     *
     *
     * 示例 1：
     * 输入：n = 3
     * 输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
     * 示例 2：
     * 输入：n = 1
     * 输出：[[1]]
     *
     * 提示：
     *
     * 1 <= n <= 8
     * 链接:https://leetcode.cn/problems/unique-binary-search-trees-ii/
     */

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return Collections.emptyList();
        }
        return buildTree(1, n);
    }

    public List<TreeNode> buildTree(int l,int r){
        List<TreeNode> allTrees = new ArrayList<>();
        if(l>r){
            allTrees.add(null);
            return allTrees;
        }

        for (int i = l; i <= r; i++) {

            List<TreeNode> lNodes = buildTree(l, i - 1);
            List<TreeNode> rNodes = buildTree(i + 1, r);
            for (TreeNode left : lNodes) {

                for (TreeNode right : rNodes) {

                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = left;
                    treeNode.right = right;
                    allTrees.add(treeNode);
                }
            }
        }
        return allTrees;
    }
}
