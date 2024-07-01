package com.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {


    /**
     *
     * @param root
     * @return
     */
    public boolean isCompleteTree (TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //定义一个首次出现空节点的标记位
        boolean notComplete = false;
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur==null){
                notComplete = true;
                continue;
            }
            //后续访问已经遇到空节点了，说明经过了叶子
            if(notComplete){
                return false;
            }
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return true;
    }
}
