package com.leetcode.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindTarget {


    /**
     * 给定一个二叉搜索树 root 和一个目标结果 k，如果二叉搜索树中存在两个元素且它们的和等于给定的目标结果，则返回 true。
     * 示例 1：
     * 输入: root = [5,3,6,2,4,null,7], k = 9
     * 输出: true
     *
     * 示例 2：
     * 输入: root = [5,3,6,2,4,null,7], k = 28
     * 输出: false
     *
     * 提示:
     * 二叉树的节点个数的范围是  [1, 104].
     * -104 <= Node.val <= 104
     * 题目数据保证，输入的 root 是一棵 有效 的二叉搜索树
     * -105 <= k <= 105
     */

    /**
     * 迭代 + 中序遍历 + 双指针
     * 左栈指向最小  右栈指向最大
     * 两边不断放缩逼近
     * @param root
     * @param k
     * @return
     */


    public boolean findTarget(TreeNode root, int k) {


        TreeNode left = root, right = root;
        Deque<TreeNode> leftStack  =  new ArrayDeque<TreeNode>();
        Deque<TreeNode> rightStack = new ArrayDeque<TreeNode>();
        leftStack.push(left);
        while (left.left != null) {
            leftStack.push(left.left);
            left = left.left;
        }
        rightStack.push(right);
        while (right.right != null) {
            rightStack.push(right.right);
            right = right.right;
        }
        while (left != right) {
            if (left.val + right.val == k) {
                return true;
            }
            if (left.val + right.val < k) {
                left = getLeft(leftStack);
            } else {
                right = getRight(rightStack);
            }
        }
        return false;
    }

    public TreeNode getLeft(Deque<TreeNode> stack) {
        TreeNode root = stack.pop();
        TreeNode node = root.right;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        return root;
    }

    public TreeNode getRight(Deque<TreeNode> stack) {
        TreeNode root = stack.pop();
        TreeNode node = root.left;
        while (node != null) {
            stack.push(node);
            node = node.right;
        }
        return root;
    }

}
