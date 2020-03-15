package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        recursion(traversal,root);
        return traversal;
    }

    /***
     * 递归方式
     * @param traversal
     * @param node
     */
    public void recursion(List<Integer> traversal,TreeNode node) {
        if(node!=null){
            recursion(traversal, node.left);
            traversal.add(node.val);
            recursion(traversal,node.right);
        }
    }

    /***
     * 迭代方式
     * @param root
     * @return
     */
    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        if(root==null) return traversal;
        stack.push(root);
        boolean isBacktrack=false;
        while (!stack.isEmpty()){
            if(root.left!=null&&!isBacktrack){
                root=root.left;
                stack.push(root);
            }else{
                root=stack.pop();
                traversal.add(root.val);
                if(root.right!=null){
                    root=root.right;
                    stack.push(root);
                    isBacktrack=false;
                }else{
                    isBacktrack=true;
                }
            }
        }
        return traversal;
    }

    /**
     * 中序迭代遍历
     * 判断条件是cur!=null||!stack.isEmpty()
     * 如果cur节点为null,但是栈不为空
     * @param root
     * @return
     */
    public List<Integer> inOrder(TreeNode root){
       
       List<Integer> traversal=new ArrayList<>();
       Stack<TreeNode> stack=new Stack<>();
       TreeNode cur=root;
       while(cur!=null||!stack.isEmpty()){
            
            if(cur!=null){ //不为null,继续左分支,压栈
                stack.push(cur);
                cur=cur.left;
            }else{//为null,出栈,遍历右分支
                cur=stack.pop();
                traversal.add(cur.val);
                cur=cur.right;
            }
       }
       return traversal;
    }

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){this.val=val;}
    }

    public static void main(String[] args) {

    }

}
