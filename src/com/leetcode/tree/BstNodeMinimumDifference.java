package com.leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BstNodeMinimumDifference {


    public int getMinimumDifference(TreeNode root) {
        int minDiff =Integer.MAX_VALUE;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curNode = root;
        while (curNode!=null||!stack.isEmpty()){

            if(curNode!=null){
                stack.push(curNode);
                curNode = curNode.left;
            }else {
                TreeNode topNode = stack.pop();
                curNode = topNode.right;
            }
        }
        return minDiff;
    }


    int minDiff = Integer.MAX_VALUE;
    public int getMinimumDifferenceRecursion(TreeNode root) {
        Deque<Integer> stack = new ArrayDeque<>();
        recursion(root,stack);
        return minDiff;
    }
    private void recursion(TreeNode node,Deque<Integer> stack) {

        if (node != null) {
            recursion(node.left, stack);
            if (!stack.isEmpty()) {
                minDiff = Math.min(node.val - stack.pop(), minDiff);
            }
            stack.push(node.val);
            recursion(node.right, stack);
        }
    }

    public int getMinimumDifferenceMorris(TreeNode root) {
        int minDiff =Integer.MAX_VALUE;
        TreeNode curNode = root;
        TreeNode preNode = null;
        List<Integer> traversal = new ArrayList<>();
        while (curNode!=null){

            if(curNode.left!=null){
                TreeNode pre = curNode.left;

                 while (pre.right!=null&&pre.right!=curNode){
                     pre = pre.right;
                 }

                 //串接链表
                 if(pre.right==null){
                     pre.right =curNode;
                     curNode = curNode.left;
                 }else{
                     //遍历链表｜切换分支
                     pre.right = null;
                     if(preNode!=null){
                         minDiff = Math.min(minDiff, curNode.val - preNode.val);
                     }
                     preNode = curNode;
                     curNode =curNode.right;
                 }
            }else {
                //切换分支
                if(preNode!=null){
                    minDiff = Math.min(minDiff, curNode.val - preNode.val);
                }
                preNode = curNode;
                curNode = curNode.right;
            }
        }
        return minDiff;
    }




}
