package com.leetcode.tree;

import java.util.Stack;

public class ConvertBiNode {

    public TreeNode convertBiNode(TreeNode root) {

        if(root==null) return null;

        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        TreeNode dummyNode = new TreeNode(0);
        TreeNode newTree = dummyNode;
        while(cur!=null||!s.isEmpty()){

            if(cur==null){
                cur = s.pop();
                cur.left = null;
                newTree.right = cur;
                newTree = newTree.right;
                cur = cur.right;
            }else{
                s.push(cur);
                cur = cur.left;
            }
        }
        return dummyNode.right;
    }

    private TreeNode head = new TreeNode(-1);
    private TreeNode prev = head;
    public TreeNode convertBiNodeOptimizer(TreeNode root) {
        recurInOrder(root);
        return head.right;
    }

    public void recurInOrder(TreeNode node){
        if(node==null){
            return;
        }
        recurInOrder(node.left);
        prev.right = node;
        prev = prev.right;
        node.left = null;
        recurInOrder(node.right);
    }


}
