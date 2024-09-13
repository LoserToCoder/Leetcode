package com.leetcode.tree;

public class SymmetricBinaryTree {


     public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
     }

    /**
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
     * https://leetcode.cn/problems/symmetric-tree/description/
     */
    public boolean isSymmetric(TreeNode root) {
        return root == null || checkSymmetric(root.left,root.right);
    }

    public boolean checkSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && checkSymmetric(p.left, q.right) && checkSymmetric(p.right, q.left);
    }
}
