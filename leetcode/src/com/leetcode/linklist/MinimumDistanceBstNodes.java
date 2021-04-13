package com.leetcode.linklist;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class MinimumDistanceBstNodes {

    class TreeNode {
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

    public int minDiffInBST(TreeNode root) {

        int minDiff = Integer.MAX_VALUE;
        Deque<TreeNode> queue = new ArrayDeque<>();
        if(root!=null)   {
             queue.add(root);
        }

        while (!queue.isEmpty()){

            TreeNode curNode= queue.poll();
            TreeNode leftNode = curNode.left;
            TreeNode rightNode  = curNode.right;
            if(leftNode!=null){
                TreeNode preCursor = getPrecursor(leftNode);
                minDiff = Math.min(minDiff, curNode.val - preCursor.val);
                queue.add(leftNode);
            }
            if(rightNode!=null) {
                TreeNode succeed = getSucceed(rightNode);
                minDiff = Math.min(minDiff, rightNode.val - succeed.val);
                queue.add(rightNode);
            }
        }
        return minDiff;

    }

    private TreeNode getPrecursor(TreeNode node){
        while (node.right!=null){
            node = node.right;
        }
        return node;
    }

    private TreeNode getSucceed(TreeNode node){
        while (node.left!=null){
            node = node.left;
        }
        return node;
    }
}
