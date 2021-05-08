package com.leetcode.tree;


import java.util.ArrayDeque;
import java.util.Deque;

public class ValidBST {


    /*
    实现一个函数，检查一棵二叉树是否为二叉搜索树。
    示例1:
        输入:
            2
           / \
          1   3
        输出: true
    示例2:
        输入:
            5
           / \
          1   4
            / \
           3   6
        输出: false
        解释: 输入为: [5,1,4,null,null,3,6]。
        根节点的值为 5 ，但是其右子节点值为 4 。
    链接：https://leetcode-cn.com/problems/legal-binary-search-tree-lcci
     */

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean isValidBST(TreeNode node, long min, long max) {
        if(node==null){
            return true;
        }
        if(node.val<=min||node.val>=max){
            return false;
        }
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }


    public boolean isValidBSTLevel(TreeNode root) {

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            TreeNode predecessorNode = predecessor(node);
            if(predecessorNode!=null&&predecessorNode.val>node.val){
                return false;
            }
            TreeNode successorNode = successor(node);
            if(successorNode!=null&&successorNode.val< node.val){
                return false;
            }
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
        return true;
    }


    private TreeNode successor(TreeNode node) {
        if (node.right == null) {
            return null;
        }
        TreeNode curNode = node.right;

        while (curNode.left!=null) {
            curNode =curNode.left;
        }
        return curNode;
    }

    private TreeNode predecessor(TreeNode node) {
        if(node.left ==null){
            return null;
        }
        TreeNode curNode = node.left;

        while (curNode.right!=null){
            curNode = curNode.right;
        }
        return curNode;
    }

}
