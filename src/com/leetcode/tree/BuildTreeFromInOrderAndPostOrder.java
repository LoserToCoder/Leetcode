package com.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

public class BuildTreeFromInOrderAndPostOrder {

    /**
     * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历，
     * postorder 是同一棵树的后序遍历，请你构造并返回这颗二叉树。
     * <p>
     * 示例 1:
     * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
     * 输出：[3,9,20,null,null,15,7]
     * <p>
     * 示例 2:
     * 输入：inorder = [-1], postorder = [-1]
     * 输出：[-1]
     * <p>
     * 提示:
     * <p>
     * 1 <= inorder.length <= 3000
     * postorder.length == inorder.length
     * -3000 <= inorder[i], postorder[i] <= 3000
     * inorder和postorder都由 不同 的值组成
     * postorder中每一个值都在inorder中
     * inorder保证是树的中序遍历
     * postorder保证是树的后序遍历
     * <p>
     * 链接：https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal
     *
     * @param inorder
     * @param postorder
     * @return
     */

    private Map<Integer, Integer> map = new HashMap<>();
    private int pos;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pos = postorder.length-1;
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return generateTreeNode(postorder, inorder, 0, inorder.length - 1);
    }
    public TreeNode generateTreeNode(int[]postorder,int[]inorder,int start,int end){
        if(start>end) return null;
        Integer idx = map.get(postorder[pos]);
        TreeNode root = new TreeNode(postorder[pos--]);
        root.right = generateTreeNode(postorder,inorder,idx+1,end);
        root.left = generateTreeNode(postorder, inorder, start, idx - 1);
        return root;
    }
}
