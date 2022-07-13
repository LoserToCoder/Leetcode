package com.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

public class BuildTreeFromPreOrderAndInOrder {


    private int pos = 0;
    private Map<Integer,Integer> map = new HashMap<>();

    /**
     * 给定两个整数数组preorder 和 inorder，其中preorder 是二叉树的先序遍历，
     * inorder是同一棵树的中序遍历，请构造二叉树并返回其根节点。
     *
     *
     * 示例 1:
     * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
     * 输出: [3,9,20,null,null,15,7]
     *
     * 示例 2:
     * 输入: preorder = [-1], inorder = [-1]
     * 输出: [-1]
     *
     * 提示:
     *
     * 1 <= preorder.length <= 3000
     * inorder.length == preorder.length
     * -3000 <= preorder[i], inorder[i] <= 3000
     * preorder和inorder均无重复元素
     * inorder均出现在preorder
     * preorder保证 为二叉树的前序遍历序列
     * inorder保证 为二叉树的中序遍历序列
     *
     * 链接：https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++) map.put(inorder[i],i);
        return generateTreeNode(preorder,inorder,0,inorder.length-1);
    }

    public TreeNode generateTreeNode(int [] preorder,int [] inorder,int start,int end){
        if(start>end){
            return null;
        }
        int idx = map.get(preorder[pos]);
        if(idx>end||idx<start) return null;
        TreeNode treeNode = new TreeNode(preorder[pos++]);
        treeNode.left = generateTreeNode(preorder,inorder,start,idx-1);
        treeNode.right = generateTreeNode(preorder,inorder,idx+1,end);
        return treeNode;
    }


}
