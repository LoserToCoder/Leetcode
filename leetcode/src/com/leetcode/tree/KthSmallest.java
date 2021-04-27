package com.leetcode.tree;

public class KthSmallest {

    /***
     * 给定一个二叉搜索树，编写一个函数kthSmallest来查找其中第k个最小的元素。
     * 说明:你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
     * 示例 1:
     * 输入: root = [3,1,4,null,2], k = 1
     *    3
     *   / \
     *  1   4
     *   \
     *   2
     * 输出: 1
     * 示例 2:
     * 输入: root = [5,3,6,2,4,null,null,1], k = 3
     *        5
     *       / \
     *      3   6
     *     / \
     *    2   4
     *   /
     *  1
     * 输出: 3
     * 进阶：
     * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化kthSmallest函数？
     * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
     * @param root
     * @param k
     * @return
     */

    public int kthSmallest(TreeNode root, int k) {
        return traversal(root, k).val;
    }

    public Result traversal(TreeNode node, int k) {

        if (node == null) return new Result(false, 0);
        Result ld = traversal(node.left, k);
        if (ld.found) {
            /**
             * 注意递归返回的结果,可能是某个子节点
             * 满足条件进行了剪枝操作返回的结果节点
             * **/
            return ld;
        }
        if (ld.val == k - 1) {
            return new Result(true, node.val);
        }
        Result rd = traversal(node.right, k - ld.val - 1);
        if (rd.found) {
            /**
             * 注意递归返回的结果,可能是某个子节点
             * 满足条件进行了剪枝操作返回的结果节点
             * **/
            return rd;
        }
        return new Result(false, ld.val + 1 + rd.val);
    }

    class Result {
        boolean found;
        int val;

        Result(boolean found, int val) {
            this.found = found;
            this.val = val;
        }
    }

   class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        System.out.println(Math.PI);
        System.out.println(Math.E);
    }

 }