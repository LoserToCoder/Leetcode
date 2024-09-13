package com.leetcode.tree;

import java.util.ArrayDeque;
import java.util.Deque;
public class BSTIterator {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    private TreeNode cur;

    private Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        cur = root;
        stack = new ArrayDeque<>();
    }

    public int next() {

        if(cur==null && stack.isEmpty()){
            return -1;
        }


        while(cur!=null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int ret = cur.val;
        cur = cur.right;
        return  ret;
    }

    public boolean hasNext() {
        return cur!=null || !stack.isEmpty();
    }
}
