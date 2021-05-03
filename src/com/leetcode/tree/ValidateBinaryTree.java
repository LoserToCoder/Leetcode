package com.leetcode.tree;

public class ValidateBinaryTree {

    /**
     * 二叉树上有 n个节点，按从0到 n - 1编号，其中节点i的两个子节点分别是leftChild[i]和rightChild[i]。
     *
     * 只有 所有 节点能够形成且 只 形成 一颗有效的二叉树时，返回true；否则返回 false。
     *
     * 如果节点i没有左子节点，那么leftChild[i]就等于-1。右子节点也符合该规则。
     *
     * 注意：节点没有值，本问题中仅仅使用节点编号。
     * 示例 1：
     *
     * 输入：n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]
     * 输出：true
     * 示例 2：
     *
     * 输入：n = 4, leftChild = [1,-1,3,-1], rightChild = [2,3,-1,-1]
     * 输出：false
     * 示例 3：
     *
     * 输入：n = 2, leftChild = [1,0], rightChild = [-1,-1]
     * 输出：false
     * 示例 4：
     *
     * 输入：n = 6, leftChild = [1,-1,-1,4,-1,-1], rightChild = [2,-1,-1,5,-1,-1]
     * 输出：false
     * 
     * 链接：https://leetcode-cn.com/problems/validate-binary-tree-nodes
     * @param n
     * @param leftChild
     * @param rightChild
     * @return
     */
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        return true;
    }
}
