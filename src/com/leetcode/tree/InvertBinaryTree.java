package com.leetcode.tree;


public class InvertBinaryTree {

    /**
     *翻转一棵二叉树。
     *
     * 示例：
     *
     * 输入：
     *
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     * 输出：
     *
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     *
     *
     * 链接：https://leetcode-cn.com/problems/invert-binary-tree
     * @param root
     * @return
     * 递归调用
     */
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        /*TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left  = right;*/
        turnOver(root);
        return root;
    }

    private void turnOver(TreeNode node){
        if(node==null){
            return;
        }
        TreeNode left = node.left;
        TreeNode right= node.right;
        node.left =right;
        node.right=left;
        turnOver(left);
        turnOver(right);
    }
}
