package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 给定一个二叉树，返回它的前序遍历。
 示例:输入: [1,null,2,3]
        1
         \
          2
         /
        3
 输出: [1,2,3]
 进阶:递归算法很简单，你可以通过迭代算法完成吗？
 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 */
public class PreOrderTraversal {

    public List<Integer> preorderTraversalRecursion(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        recursion(traversal,root);
        return traversal;
    }

    public void recursion(List<Integer> traversal,TreeNode node){
        if(node!=null){
            traversal.add(node.val);
            recursion(traversal,node.left);
            recursion(traversal,node.right);
        }
    }

    public List<Integer> preorderTraversalMethodOne(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        stack.push(null);
        TreeNode cur=root;
        while(cur!=null){
            traversal.add(cur.val);
            if(cur.right!=null){
                stack.push(cur.right);
            }
            if(cur.left!=null){
                cur=cur.left;
            }else{
                cur=stack.pop();
            }
        }
        return traversal;
    }
     public List<Integer> preorderTraversalMethodTwo(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        if(root==null){
            return traversal;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur=stack.pop();
            traversal.add(cur.val);
            if(cur.right!=null){
                stack.push(cur.right);
            }
            if(cur.left!=null){
                stack.push(cur.left);
            }

        }
        return traversal;
    }

    public static void main(String[] args) {

    }
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

}
