package com.leetcode.tree;

import java.util.*;

public class ZigzagLevelOrder {

    /**
     * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（
     * 即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     *
     * 例如：
     * 给定二叉树[3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回锯齿形层序遍历如下：
     *
     * [
     *   [3],
     *   [20,9],
     *   [15,7]
     * ]
     * 
     * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root==null){
            return ret;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        queue.add(root);
        int level =1;//层数为奇数时，正常顺序遍历,层数为偶数,倒序遍历
        while (!queue.isEmpty()||!stack.isEmpty()){

            boolean isOrder = (level&1)==1;
            int n = isOrder?queue.size():stack.size();
            List<Integer> sub = new ArrayList<>();
            for(int i=0;i<n;i++){

                if(isOrder){
                    TreeNode curNode = queue.poll();
                    sub.add(curNode.val);
                    if(curNode.left!=null){
                        stack.push(curNode.left);
                    }
                    if(curNode.right!=null){
                        stack.push(curNode.right);
                    }
                }else{
                    TreeNode curNode = stack.poll();
                    sub.add(curNode.val);
                    if(curNode.right!=null){
                        queue.addFirst(curNode.right);
                    }
                    if(curNode.left!=null){
                        queue.addFirst(curNode.left);
                    }

                }
            }
            level++;
            ret.add(sub);
        }
        return ret;
    }
}
