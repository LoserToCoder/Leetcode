package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class MorrisTraversal {


    /**
     * 中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur!=null){

            if(cur.left ==null){ //遍历链表｜切换分支
                traversal.add(cur.val);
                cur = cur.right;
            }else{
                pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }

                if(pre.right==null){ //串接链表
                    pre.right = cur;
                    cur = cur.left;
                }else {
                    //遍历(回溯)链表｜切换分支
                    pre.right =null;
                    traversal.add(cur.val);
                    cur =cur.right;
                }
            }

        }
        return traversal;
    }

    /**
     * 前序遍历
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        return traversal;
    }

    /**
     * 后序遍历
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        return traversal;
    }

}
